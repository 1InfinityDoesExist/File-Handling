package in.csv.csvManipulate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.csv.csvManipulate.entity.CountryDetails;
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

	@GetMapping(value = "/getAll")
	public ResponseEntity<ModelMap> getAllCountryDetails() {
		List<CountryDetails> listOfCountryDetails = countryDetailsService.getAllCountryDetails();
		return ResponseEntity.status(HttpStatus.OK).body(new ModelMap().addAttribute("response", listOfCountryDetails));
	}

	@GetMapping(value = "/neighbourbased")
	public ResponseEntity<ModelMap> getAllCountryBasedOnBoundary(
			@RequestParam(value = "boarders", required = true) List<String> boarders) {
		List<CountryDetails> listOfCountryDetails = countryDetailsService.getAllCountryBasedOnBoundary(boarders);
		return ResponseEntity.status(HttpStatus.OK).body(new ModelMap().addAttribute("response", listOfCountryDetails));
	}

}
