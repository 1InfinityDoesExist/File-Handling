package in.csv.csvManipulate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.csv.csvManipulate.kafka.producer.CountryDetailsProducer;
import in.csv.csvManipulate.repository.CountryDetailsRepository;
import in.csv.csvManipulate.request.CountryDetailsCreateRequest;
import in.csv.csvManipulate.service.CountryDetailsService;

@Service
public class CountryDetailsServiceImpl implements CountryDetailsService {

	@Autowired
	private CountryDetailsProducer countryDetailsproducer;

	@Autowired
	private CountryDetailsRepository countryDetailsRepository;

	@Override
	public void saveCountryDetails(CountryDetailsCreateRequest request) {
		countryDetailsproducer.produce("countryDetails", request.toString());
	}

}
