
package in.csv.csvManipulate.exception;

import org.springframework.stereotype.Component;

public class CountryDetailsNotFoundException extends BaseException {

	public CountryDetailsNotFoundException(String message) {
		super(message);
	}

}
