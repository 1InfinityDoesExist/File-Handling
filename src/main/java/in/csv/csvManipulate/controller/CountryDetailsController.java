package in.csv.csvManipulate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.csv.csvManipulate.request.CountryDetailsCreateRequest;
import in.csv.csvManipulate.service.CountryDetailsService;

@RestController
@RequestMapping(value = "/country_details")
public class CountryDetailsController {

	@Autowired
	private CountryDetailsService countryDetailsService;

	@PostMapping(value = "/persist")
	public ResponseEntity<ModelMap> saveCountryDetialsInDB(@RequestBody CountryDetailsCreateRequest request) {
		countryDetailsService.saveCountryDetails(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ModelMap("response", "Successfully created"));
	}

}
