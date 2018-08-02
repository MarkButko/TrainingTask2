package mark.butko.controller.commands;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.controller.util.filters.ColorFilterChain;
import mark.butko.controller.util.filters.FilterChain;
import mark.butko.controller.util.filters.PowerFilterChain;
import mark.butko.controller.util.filters.WeightFilterChain;
import mark.butko.controller.util.filters.WireLengthFilterChain;
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
		// ???
		new SortCommand().execute(request, response);
	}

}
