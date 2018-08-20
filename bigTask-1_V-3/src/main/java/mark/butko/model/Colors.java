package mark.butko.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Inteface that represents all avaliable colors
 * 
 * @author markg
 *
 */
public interface Colors {

	List<String> avaliable = new ArrayList<>(
			Arrays.asList("any", "red", "green", "grey", "black", "blue", "purple", "yellow", "white"));
}