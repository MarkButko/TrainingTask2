package mark.butko.model;

import java.util.regex.Pattern;

public class RegexValidator {

	public boolean match(String input, String regex) {
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(input).matches();
	}

}
