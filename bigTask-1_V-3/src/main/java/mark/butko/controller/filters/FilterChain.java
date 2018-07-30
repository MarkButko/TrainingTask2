package mark.butko.controller.filters;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import mark.butko.model.entities.consumers.ElectricalAppliance;

/**
 * Abstract filter. Implementation of pattern Chain of responsibility. Should be
 * inherited if new filter of user input added.
 * 
 * @author markg
 *
 */
public abstract class FilterChain {

	protected FilterChain nextChain;

	/**
	 * Sets filter that will be processing data next.
	 * 
	 * @param nextChain next filter in chain of responsibility
	 */
	public void setNextChain(FilterChain nextChain) {
		this.nextChain = nextChain;
	};

	/**
	 * Filters given set and calls next filter in chain if exists. Sets needed for
	 * jsp page attributes using request object
	 * 
	 * @param appliances data that will be filtered
	 * @param request
	 * @return filtered data
	 */
	public Set<ElectricalAppliance> getFiltered(Set<ElectricalAppliance> appliances, HttpServletRequest request) {
		return appliances;
	};
}
