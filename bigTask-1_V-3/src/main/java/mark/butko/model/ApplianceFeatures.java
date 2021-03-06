package mark.butko.model;

import java.util.Comparator;

import mark.butko.model.entities.consumers.ElectricalAppliance;

/**
 * Represents features of ElectricalAppliance. Gives comparator for each
 * individual feature with ID as second field. So TreeSet will distinct them by
 * ID and sort by first feature.
 * 
 * @author markg
 *
 */
public enum ApplianceFeatures {
	POWER {
		public Comparator<ElectricalAppliance> getComparator() {
			return new ElectricalAppliance.PowerComparator().thenComparing(new ElectricalAppliance.IDComparator());
		}
	},
	COLOR {
		public Comparator<ElectricalAppliance> getComparator() {
			return new ElectricalAppliance.ColorComparator().thenComparing(new ElectricalAppliance.IDComparator());
		}
	},
	WEIGHT {
		public Comparator<ElectricalAppliance> getComparator() {
			return new ElectricalAppliance.WeightComparator().thenComparing(new ElectricalAppliance.IDComparator());
		}
	},
	WIRE_LENGTH {
		public Comparator<ElectricalAppliance> getComparator() {
			return new ElectricalAppliance.WireLengthComparator().thenComparing(new ElectricalAppliance.IDComparator());
		}
	};
	public Comparator<ElectricalAppliance> getComparator() {
		return null;
	}
}