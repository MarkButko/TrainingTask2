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

	private Set<ElectricalAppliance> turnedOnDevices = new HashSet<>();
	private boolean activated = true;

	public Set<ElectricalAppliance> getTurnedOnDevices() {
		return turnedOnDevices;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	/**
	 * turns on device. adds to set
	 * 
	 * @param device
	 * @return
	 */
	public boolean turnOn(ElectricalAppliance device) {
		device.setTurnedOn(true);
		return turnedOnDevices.add(device);
	}

	/**
	 * turns off device. removes from set
	 * 
	 * @param device
	 * @return
	 */
	public boolean turnOff(ElectricalAppliance device) {
		device.setTurnedOn(false);
		return turnedOnDevices.remove(device);
	}

	/**
	 * turns off all devices by setting their isTurnedOn fields to false
	 * 
	 * @param device
	 * @return amount of turned off devices
	 */
	public int deactivate() {
		int count = 0;
		for (ElectricalAppliance device : turnedOnDevices) {
			if (device.getTurnedOn()) {
				device.setTurnedOn(false);
				count++;
			}
		}

		return count;
	}

	/**
	 * turns on all devices by setting their isTurnedOn fields to true
	 * 
	 * @param device
	 * @return amount of turned on devices
	 */
	public int activate() {
		int count = 0;
		for (ElectricalAppliance device : turnedOnDevices) {
			if (!device.getTurnedOn()) {
				device.setTurnedOn(true);
				count++;
			}
		}

		return count;
	}

	/**
	 * 
	 * @return total power that all turned on devices consume at the time.
	 */
	public int powerConsumption() {
		int powerConsumption = 0;
		if (activated) {
			for (ElectricalAppliance device : turnedOnDevices) {
				powerConsumption += device.getPower();
			}
		}
		return powerConsumption;
	}
}
