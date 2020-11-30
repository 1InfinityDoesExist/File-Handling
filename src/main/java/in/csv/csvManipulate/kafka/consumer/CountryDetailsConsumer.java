package in.csv.csvManipulate.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import in.csv.csvManipulate.entity.CountryDetails;
import in.csv.csvManipulate.repository.CountryDetailsRepository;
import lombok.extern.slf4j.Slf4j;

@Component("countryDetailsConsumer")
@Slf4j
public class CountryDetailsConsumer {

	@Autowired
	private MongoTemplate mongoTemplate;

	public CountryDetailsConsumer() {
		log.info("-----CountryDetailsConsumer Class, CountryDetailsConsumer method-----");
	}

	@SuppressWarnings("unchecked")
	@KafkaListener(topics = "countryDetails", containerFactory = "concurrentKafkaListenerContainerFactory")
	public void consumes(ConsumerRecord<String, String> consumerRecord) {
		log.info(":::::CountryDetailsCounsumer Class,  consumer method:::::");
		try {
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(consumerRecord.value());
			String url = (String) jsonObject.get("url");
			HttpResponse<String> response = Unirest.get(url)
					.header("Cookie", "__cfduid=d1d59026877ab76d42817dc30f62567641606718641").asString();
			JSONArray jsonArray = (JSONArray) new JSONParser().parse(response.getBody());
			jsonArray.forEach(jsonObj -> {
				try {
					CountryDetails countryDetails = new ObjectMapper().readValue(jsonObj.toString(),
							CountryDetails.class);
					log.info(":::::countryDetails {}", countryDetails.getAlpha3Code());
					mongoTemplate.save(countryDetails, "country_details");
					// countryDetailsRepository.save(countryDetails);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			});
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}
}
