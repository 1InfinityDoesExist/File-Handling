package in.csv.csvManipulate.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Language {
	private String iso639_1;
	private String iso639_2;
	private String name;
	private String nativeName;
}
