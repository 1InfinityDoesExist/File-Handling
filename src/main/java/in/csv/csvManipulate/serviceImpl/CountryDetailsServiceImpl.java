package in.csv.csvManipulate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.csv.csvManipulate.entity.CountryDetails;
import in.csv.csvManipulate.kafka.producer.CountryDetailsProducer;
import in.csv.csvManipulate.request.CountryDetailsCreateRequest;
import in.csv.csvManipulate.service.CountryDetailsService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountryDetailsServiceImpl implements CountryDetailsService {

	@Autowired
	private CountryDetailsProducer countryDetailsproducer;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void saveCountryDetails(CountryDetailsCreateRequest request) {
		log.info(":::::CountryDetailsServiceImpl Class,  saveCountryDetails method:::::");
		try {
			log.info("::::request {}", request);
			countryDetailsproducer.produce("countryDetails", new ObjectMapper().writeValueAsString(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CountryDetails> getAllCountryDetails() {
		return mongoTemplate.findAll(CountryDetails.class);
	}

	@Override
	public List<CountryDetails> getAllCountryBasedOnBoundary(List<String> boarders) {
		Query query = new Query();
		Criteria criteria = Criteria.where("borders").all(boarders);
		query.addCriteria(criteria);
		return mongoTemplate.find(query, CountryDetails.class);
	}

}
