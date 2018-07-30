package mark.butko.model.entities.consumers;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Abstract class that declares common for all devices methods and fields. Gives
 * Comparators for individual fields.
 * 
 * @author markg
 *
 */
public abstract class ElectricalAppliance {

	protected final Long id = IDGenerator.getNextValue();
	protected Integer power;
	protected String color;
	protected Integer wireLength;
	protected Integer weight;
	protected Boolean isTurnedOn = false;

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getWireLength() {
		return wireLength;
	}

	public void setWireLength(Integer wireLength) {
		this.wireLength = wireLength;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Boolean getIsTurnedOn() {
		return isTurnedOn;
	}

	public void setIsTurnedOn(Boolean isTurnedOn) {
		this.isTurnedOn = isTurnedOn;
	}

	public Long getId() {
		return id;
	}

	public static class PowerComparator implements Comparator<ElectricalAppliance> {
		public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
			return o1.power.compareTo(o2.power);
		}
	}

	public static class WeightComparator implements Comparator<ElectricalAppliance> {
		public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
			return o1.weight.compareTo(o2.weight);
		}
	}

	public static class ColorComparator implements Comparator<ElectricalAppliance> {
		public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
			return o1.color.compareTo(o2.color);
		}
	}

	public static class WireLengthComparator implements Comparator<ElectricalAppliance> {
		public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
			return o1.wireLength.compareTo(o2.wireLength);
		}
	}

	public static class IDComparator implements Comparator<ElectricalAppliance> {
		public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
			return o1.id.compareTo(o2.id);
		}
	}

	/**
	 * Generates unique ID for each object of ElectricalAppliance class
	 * 
	 * @author markg
	 *
	 */
	public static class IDGenerator {
		private static AtomicLong currentValue = new AtomicLong(0L);

		public static long getNextValue() {
			return currentValue.getAndIncrement();
		}

		// Should be used when reading data from database
		public static void setIniitalValue(Long initialValue) {
			currentValue = new AtomicLong(initialValue);
		}
	}
}
