package in.csv.csvManipulate.response;

import java.util.List;
import java.util.Map;

import in.csv.csvManipulate.model.Currency;
import in.csv.csvManipulate.model.Language;
import in.csv.csvManipulate.model.RegionalBloc;

@lombok.Getter
public class CountryDetailsResponse {
	private String id;
	private String name;
	private List<String> topLevelDomain;
	private String alpha2Code;
	private String alpha3Code;
	private List<String> callingCodes;
	private String capital;
	private List<String> altSpellings;
	private String region;
	private String subregion;
	private Long population;
	private List<Integer> latlng;
	private String demonym;
	private Long area;
	private Double gini;
	private List<String> timezones;
	private List<String> boarders;
	private String nativeName;
	private String numericCode;
	private List<Currency> currencies;
	private List<Language> languages;
	private Map<String, Object> translations;
	private String flag;
	private String cioc;
	private List<RegionalBloc> regionalBlocs;

	public CountryDetailsResponse(String id, String name, List<String> topLevelDomain, String alpha2Code,
			String alpha3Code, List<String> callingCodes, String capital, List<String> altSpellings, String region,
			String subregion, Long population, List<Integer> latlng, String demonym, Long area, Double gini,
			List<String> timezones, List<String> boarders, String nativeName, String numericCode,
			List<Currency> currencies, List<Language> languages, Map<String, Object> translations, String flag,
			String cioc, List<RegionalBloc> regionalBlocs) {
		super();
		this.id = id;
		this.name = name;
		this.topLevelDomain = topLevelDomain;
		this.alpha2Code = alpha2Code;
		this.alpha3Code = alpha3Code;
		this.callingCodes = callingCodes;
		this.capital = capital;
		this.altSpellings = altSpellings;
		this.region = region;
		this.subregion = subregion;
		this.population = population;
		this.latlng = latlng;
		this.demonym = demonym;
		this.area = area;
		this.gini = gini;
		this.timezones = timezones;
		this.boarders = boarders;
		this.nativeName = nativeName;
		this.numericCode = numericCode;
		this.currencies = currencies;
		this.languages = languages;
		this.translations = translations;
		this.flag = flag;
		this.cioc = cioc;
		this.regionalBlocs = regionalBlocs;
	}

}
