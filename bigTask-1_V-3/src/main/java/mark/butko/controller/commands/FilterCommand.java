package mark.butko.controller.commands;

import static mark.butko.constants.Attributes.APPLIANCES;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.controller.commands.filters.ColorFilterChain;
import mark.butko.controller.commands.filters.FilterChain;
import mark.butko.controller.commands.filters.PowerFilterChain;
import mark.butko.controller.commands.filters.WeightFilterChain;
import mark.butko.controller.commands.filters.WireLengthFilterChain;
import mark.butko.data.DataBaseEmulator;
import mark.butko.model.entities.consumers.ElectricalAppliance;

public class FilterCommand implements Command {

	private static FilterChain filterChain;

	public FilterCommand() {
		filterChain = new ColorFilterChain();
		FilterChain wireLengthFilterChain = new WireLengthFilterChain();
		FilterChain powerFilterChain = new PowerFilterChain();
		FilterChain weightFilterChain = new WeightFilterChain();

		filterChain.setNextChain(wireLengthFilterChain);
		wireLengthFilterChain.setNextChain(powerFilterChain);
		powerFilterChain.setNextChain(weightFilterChain);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Set<ElectricalAppliance> filteredAppliances = filterChain.getFiltered(DataBaseEmulator.getData(), request);
		request.getSession().setAttribute(APPLIANCES, filteredAppliances);
		request.setAttribute(APPLIANCES, filteredAppliances);
		// ???
		new SortCommand().execute(request, response);
	}

}
