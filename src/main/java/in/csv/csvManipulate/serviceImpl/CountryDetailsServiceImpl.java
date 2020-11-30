package in.csv.csvManipulate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.csv.csvManipulate.kafka.producer.CountryDetailsProducer;
import in.csv.csvManipulate.repository.CountryDetailsRepository;
import in.csv.csvManipulate.request.CountryDetailsCreateRequest;
import in.csv.csvManipulate.service.CountryDetailsService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountryDetailsServiceImpl implements CountryDetailsService {

	@Autowired
	private CountryDetailsProducer countryDetailsproducer;

	@Autowired
	private CountryDetailsRepository countryDetailsRepository;

	@Override
	public void saveCountryDetails(CountryDetailsCreateRequest request) {
		log.info(":::::CountryDetailsServiceImpl Class,  saveCountryDetails method:::::");
		try {
			log.info("::::request {}", request);
			countryDetailsproducer.produce("countryDetails", new ObjectMapper().writeValueAsString(request));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
