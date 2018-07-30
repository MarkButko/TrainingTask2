package mark.butko.model.entities.providers;

import java.util.HashSet;
import java.util.Set;

import mark.butko.model.entities.consumers.ElectricalAppliance;

/**
 * Provides electricity for all ElectricalAppliance class objects. Implements
 * Observer pattern: gives methods for turning on/off individual devides and
 * shouts down all them id there is no power.
 * 
 * @author markg
 *
 */
public class PowerSocket {

	Set<ElectricalAppliance> turnedOnDevices = new HashSet<>();

	public Set<ElectricalAppliance> getTurnedOnDevices() {
		return turnedOnDevices;
	}

	/**
	 * turns on device. adds to set
	 * 
	 * @param device
	 * @return
	 */
	public boolean turnOn(ElectricalAppliance device) {
		device.setIsTurnedOn(true);
		return turnedOnDevices.add(device);
	}

	/**
	 * turns off device. removes from set
	 * 
	 * @param device
	 * @return
	 */
	public boolean turnOff(ElectricalAppliance device) {
		device.setIsTurnedOn(false);
		return turnedOnDevices.remove(device);
	}

	/**
	 * 
	 * @return total power that all turned on devices consume.
	 */
	public int powerConsumption() {
		int powerConsumption = 0;
		for (ElectricalAppliance device : turnedOnDevices) {
			powerConsumption += device.getPower();
		}
		return powerConsumption;
	}
}
