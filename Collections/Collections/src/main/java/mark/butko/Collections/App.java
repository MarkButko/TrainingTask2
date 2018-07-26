package mark.butko.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 4, 5, 3, 4, 2, 4, 5, 7));
		System.out.println(new Counting<Integer>().count(list));
	}
}
