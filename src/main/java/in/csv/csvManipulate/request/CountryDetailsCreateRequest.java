package in.csv.csvManipulate.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.ToString;

@lombok.Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDetailsCreateRequest {
	private String url;
}
