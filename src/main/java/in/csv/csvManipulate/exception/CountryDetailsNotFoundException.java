
package in.csv.csvManipulate.exception;

import org.springframework.stereotype.Component;

@Component
public class CountryDetailsNotFoundException extends BaseException {

	public CountryDetailsNotFoundException(String message) {
		super(message);
	}

}
