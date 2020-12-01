package in.csv.csvManipulate.service;

import java.util.List;

import org.springframework.stereotype.Component;

import in.csv.csvManipulate.entity.CountryDetails;
import in.csv.csvManipulate.request.CountryDetailsCreateRequest;

@Component
public interface CountryDetailsService {

	public void saveCountryDetails(CountryDetailsCreateRequest request);

	public List<CountryDetails> getAllCountryDetails();

	public List<CountryDetails> getAllCountryBasedOnBoundary(List<String> boarders);

}
