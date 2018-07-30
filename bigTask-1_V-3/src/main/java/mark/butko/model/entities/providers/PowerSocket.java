package mark.butko.model.entities.providers;

import java.util.HashSet;
import java.util.Set;

import mark.butko.model.entities.consumers.ElectricalAppliance;

public class PowerSocket {

	Set<ElectricalAppliance> turnedOnDevices = new HashSet<>();

	public Set<ElectricalAppliance> getTurnedOnDevices() {
		return turnedOnDevices;
	}

	public boolean turnOn(ElectricalAppliance device) {
		device.setIsTurnedOn(true);
		return turnedOnDevices.add(device);
	}

	public boolean turnOff(ElectricalAppliance device) {
		device.setIsTurnedOn(false);
		return turnedOnDevices.remove(device);
	}

	public int powerConsumption() {
		int powerConsumption = 0;
		for (ElectricalAppliance device : turnedOnDevices) {
			powerConsumption += device.getPower();
		}
		return powerConsumption;
	}
}
