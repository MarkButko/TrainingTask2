package mark.butko.model;

public enum RegexContainer {

	RU("^[А-ЯЁ][а-яё]{1,20}$"), 
	UK("^[А-ЯЄІЇҐ][а-яєіїґ]{1,20}$"), 
	EN("^[A-Z][a-z]{1,20}$");
	
	private String name;
	private String email = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

	private RegexContainer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
