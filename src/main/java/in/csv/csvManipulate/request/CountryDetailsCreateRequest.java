package in.csv.csvManipulate.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDetailsCreateRequest {
	private String url;
}
