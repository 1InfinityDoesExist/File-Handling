package in.csv.csvManipulate.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("countryDetailsConsumer")
@Slf4j
public class CountryDetailsConsumer {

	@Autowired
	private MongoTemplate mongoTemplate;

	public CountryDetailsConsumer() {
		log.info("-----CountryDetailsConsumer Class, CountryDetailsConsumer method-----");
	}

	@KafkaListener(topics = "countryDetails", containerFactory = "concurrentKafkaListenerContainerFactory")
	public void consumes(ConsumerRecord<String, String> consumerRecord) {
		log.info(":::::CountryDetailsCounsumer Class,  consumer method:::::");
		try {
			log.info(":::::consumerRecord Value : {}", consumerRecord.value().toString());
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(consumerRecord.value().toString());
			log.info("::::jsonObject {}", jsonObject);
			String url = (String) jsonObject.get("url");
			log.info(":::::url value {}", url);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
