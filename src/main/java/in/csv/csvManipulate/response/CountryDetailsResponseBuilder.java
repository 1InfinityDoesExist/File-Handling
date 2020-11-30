package in.csv.csvManipulate.response;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import in.csv.csvManipulate.model.Currency;
import in.csv.csvManipulate.model.Language;
import in.csv.csvManipulate.model.RegionalBloc;

@Component
public class CountryDetailsResponseBuilder {
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
	private List<String> borders;
	private String nativeName;
	private String numericCode;
	private List<Currency> currencies;
	private List<Language> languages;
	private Map<String, Object> translations;
	private String flag;
	private String cioc;
	private List<RegionalBloc> regionalBlocs;

	public CountryDetailsResponseBuilder setId(String id) {
		this.id = id;
		return this;
	}

	public CountryDetailsResponseBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public CountryDetailsResponseBuilder setTopLevelDomain(List<String> topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
		return this;

	}

	public CountryDetailsResponseBuilder setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
		return this;
	}

	public CountryDetailsResponseBuilder setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
		return this;
	}

	public CountryDetailsResponseBuilder setCallingCodes(List<String> callingCodes) {
		this.callingCodes = callingCodes;
		return this;
	}

	public CountryDetailsResponseBuilder setCapital(String capital) {
		this.capital = capital;
		return this;
	}

	public CountryDetailsResponseBuilder setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
		return this;
	}

	public CountryDetailsResponseBuilder setRegion(String region) {
		this.region = region;
		return this;
	}

	public CountryDetailsResponseBuilder setSubregion(String subregion) {
		this.subregion = subregion;
		return this;
	}

	public CountryDetailsResponseBuilder setPopulation(Long population) {
		this.population = population;
		return this;
	}

	public CountryDetailsResponseBuilder setLatlng(List<Integer> latlng) {
		this.latlng = latlng;
		return this;
	}

	public CountryDetailsResponseBuilder setDemonym(String demonym) {
		this.demonym = demonym;
		return this;
	}

	public CountryDetailsResponseBuilder setArea(Long area) {
		this.area = area;
		return this;
	}

	public CountryDetailsResponseBuilder setGini(Double gini) {
		this.gini = gini;
		return this;
	}

	public CountryDetailsResponseBuilder setTimezones(List<String> timezones) {
		this.timezones = timezones;
		return this;
	}

	public CountryDetailsResponseBuilder setBoarders(List<String> borders) {
		this.borders = borders;
		return this;
	}

	public CountryDetailsResponseBuilder setNativeName(String nativeName) {
		this.nativeName = nativeName;
		return this;
	}

	public CountryDetailsResponseBuilder setNumericCode(String numericCode) {
		this.numericCode = numericCode;
		return this;
	}

	public CountryDetailsResponseBuilder setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
		return this;
	}

	public CountryDetailsResponseBuilder setLanguages(List<Language> languages) {
		this.languages = languages;
		return this;
	}

	public CountryDetailsResponseBuilder setTranslations(Map<String, Object> translations) {
		this.translations = translations;
		return this;
	}

	public CountryDetailsResponseBuilder setFlag(String flag) {
		this.flag = flag;
		return this;
	}

	public CountryDetailsResponseBuilder setCioc(String cioc) {
		this.cioc = cioc;
		return this;
	}

	public CountryDetailsResponseBuilder setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
		this.regionalBlocs = regionalBlocs;
		return this;
	}

	public CountryDetailsResponse getCountryDetails() {
		return new CountryDetailsResponse(id, name, topLevelDomain, alpha2Code, alpha3Code, callingCodes, capital,
				altSpellings, region, subregion, population, latlng, demonym, area, gini, timezones, borders,
				nativeName, numericCode, currencies, languages, translations, flag, cioc, regionalBlocs);
	}

}
