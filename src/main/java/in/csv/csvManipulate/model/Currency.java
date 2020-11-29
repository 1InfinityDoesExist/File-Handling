package in.csv.csvManipulate.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Currency {
	private String code;
	private String name;
	private String symbol;

}
