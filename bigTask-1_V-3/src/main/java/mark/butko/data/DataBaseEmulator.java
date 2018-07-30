package mark.butko.data;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import mark.butko.model.entities.consumers.ElectricalAppliance;
import mark.butko.model.entities.consumers.Hairdryer;
import mark.butko.model.entities.consumers.Iron;
import mark.butko.model.entities.consumers.Kettle;
import mark.butko.model.entities.consumers.Microwave;
import mark.butko.model.entities.consumers.Refrigerator;
import mark.butko.model.entities.consumers.WashingMachine;

/**
 * Class that generates and gives access to test data.
 * 
 * @author markg
 *
 */
public class DataBaseEmulator {

	private static Set<ElectricalAppliance> data;

	static {
		data = new HashSet<ElectricalAppliance>(30, 1.0f);

		String[] colors = { "Red", "Green", "Grey", "Black", "Magenta", "Blue", "Purple", "Yellow", "White" };
		int[] powers = { 5, 10, 15, 20, 30, 45, 95 };
		for (int i = 0; i < 5; i++) {
			data.add(new Kettle());
			data.add(new Hairdryer());
			data.add(new Iron());
			data.add(new Microwave());
			data.add(new Refrigerator());
			data.add(new WashingMachine());
		}

		int i = 0;
		for (ElectricalAppliance appliance : data) {
			appliance.setColor(colors[i % 9]);
			appliance.setPower(powers[i % 4]);
			appliance.setWeight(powers[i % 3]);
			appliance.setWireLength(powers[i % 7]);
			i++;
		}
	}

	/**
	 * 
	 * @return Set of all existed data
	 */
	public static Set<ElectricalAppliance> getData() {
		return Collections.unmodifiableSet(data);
	}

	/**
	 * 
	 * @param id
	 * @return specified by id object from set of data
	 */
	public static ElectricalAppliance getByID(Long id) {
		for (ElectricalAppliance device : data) {
			if (id.equals(device.getId()))
				return device;
		}
		return data.iterator().next();
	}
}
