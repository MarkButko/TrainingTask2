package mark.butko.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class that was created to switch from using plain Properies class to
 * ResourceBundle. This replacement provides better i18n opportunities.
 * PropertiesProvider should be used as interface.
 * 
 * @author Butko Mark
 *
 */
public class ResourceBundlePropertiesProvider extends PropertiesProvider {

	private ResourceBundle resourceBundle;
	private Locale locale;

	/**
	 * Creates new object with specifeid locale. Stubs constructor of Parent class.
	 * 
	 * @param resourceBundle
	 * @param locale
	 * @throws Exception
	 */
	public ResourceBundlePropertiesProvider(ResourceBundle resourceBundle, Locale locale) throws Exception {
		super("stub");
		this.resourceBundle = resourceBundle;
		this.locale = locale;
	}

	@Override
	public String getProperty(String key) {
		return resourceBundle.getString(key);
	}

	@Override
	public String getLanguage() {
		return locale.getLanguage();
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
