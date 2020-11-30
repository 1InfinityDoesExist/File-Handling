package in.csv.csvManipulate.service;

import org.springframework.stereotype.Component;

import in.csv.csvManipulate.request.CountryDetailsCreateRequest;

@Component
public interface CountryDetailsService {

	public void saveCountryDetails(CountryDetailsCreateRequest request);

}
