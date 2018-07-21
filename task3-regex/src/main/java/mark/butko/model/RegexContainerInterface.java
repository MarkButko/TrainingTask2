package mark.butko.model;

/**
 * Container for Strings that represents regular expressions used to validate
 * user input
 * 
 * @author Butko Mark
 * @version 1.0
 */
public interface RegexContainer {
	String EMAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
	String NAME_EN_REGEX = "^[A-Z][a-z]{1,20}$";
	String NAME_RU_REGEX = "^[А-ЯЁ][а-яё]{1,20}$";
}
