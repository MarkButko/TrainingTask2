package mark.butko.Collections;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Counting<K> {

	public Map<K, Integer> count(List<K> list) {
		Map<K, Integer> map = new TreeMap<K, Integer>();
		for (K element : list) {
			Integer prev;
			if ((prev = map.put(element, 1)) == null) {
				continue;
			} else {
				map.put(element, ++prev);
			}
		}
		return map;
	}

}
