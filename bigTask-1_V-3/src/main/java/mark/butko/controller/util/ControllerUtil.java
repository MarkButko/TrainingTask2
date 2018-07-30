package mark.butko.controller.util;

/**
 * Class that has methods for valid initialization of parameters of filters
 * classes
 * 
 * @author markg
 *
 */
public class ControllerUtil {

	/**
	 * Parses given string value if possible
	 * 
	 * @param value
	 * @return parsed value or Integer.MAX_VALUE if cannot be parsed
	 */
	public static Integer parseOrMax(String value) {
		Integer result;
		try {
			result = Integer.parseInt(value);
		} catch (Exception ex) {
			result = Integer.MAX_VALUE;
		}
		return result;
	}

	/**
	 * Parses given string value if possible
	 * 
	 * @param value
	 * @return parsed value or 0 if cannot be parsed
	 */
	public static Integer parseOrZero(String value) {
		Integer result;
		try {
			result = Integer.parseInt(value);
		} catch (Exception ex) {
			result = 0;
		}
		return result;
	}

	/**
	 * Checks if value given in parameter is valid input (valid means for bussiness
	 * context)
	 * 
	 * @param value
	 * @return value or Integer.MAX_VALUE if value is ont valid
	 */
	public static Integer maxIfNotValid(Integer value) {
		Integer result = value;
		if (value == null || value < 0) {
			result = Integer.MAX_VALUE;
		}
		return result;
	}

	/**
	 * Checks if value given in parameter is valid input (valid means for bussiness
	 * context)
	 * 
	 * @param value
	 * @return value or 0 if value is ont valid
	 */
	public static Integer zeroIfNotValid(Integer value) {
		Integer result = value;
		if (value == null || value < 0) {
			result = 0;
		}
		return result;
	}

}
