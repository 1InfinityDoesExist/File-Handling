package in.csv.csvManipulate.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegionalBloc {
	private String acronym;
	private String name;
	private List<String> otherAcronyms;
	private List<String> otherNames;
}
