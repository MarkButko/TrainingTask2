package mark.butko.controller.util;

public class ControllerUtil {

	public static Integer parseOrMax(String value) {
		Integer result;
		try {
			result = Integer.parseInt(value);
		} catch (Exception ex) {
			result = Integer.MAX_VALUE;
		}
		return result;
	}

	public static Integer parseOrZero(String value) {
		Integer result;
		try {
			result = Integer.parseInt(value);
		} catch (Exception ex) {
			result = 0;
		}
		return result;
	}

	public static Integer maxIfNotValid(Integer value) {
		Integer result = value;
		if (value == null || value < 0) {
			result = Integer.MAX_VALUE;
		}
		return result;
	}

	public static Integer zeroIfNotValid(Integer value) {
		Integer result = value;
		if (value == null || value < 0) {
			result = 0;
		}
		return result;
	}

}
