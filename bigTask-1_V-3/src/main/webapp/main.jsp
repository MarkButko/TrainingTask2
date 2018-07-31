<%@ include file="includes/before_head.jsp"%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<title><fmt:message key="main.title"/></title>
<%@ include file="includes/after_head.jsp"%>
<%@ include file="includes/navigation.jsp"%>
<div class="container-fluid">
	<div class="row main-container">
		<div class="col-md-2" id="filter-bar">
			<br>
			<div class="container">
				<form name="filter" action="main">

					<label for="color-filter">
						<fmt:message key="main.color" />
						:
						<select name="color_filter" class="form-control">
							<c:forEach var="color" items="${colors}">
								<option value="${color}" ${color_filter == color ? 'selected' : ''}>${color}</option>
							</c:forEach>
						</select>
					</label>

					<div class="form-group">
						<label for="wire-length">
							<fmt:message key="main.wire.length" />
							:
						</label>
						<div class="form-inline" id="wire-length">
							<input type="text" name="wire_length_from" class="form-control" placeholder="From" value="${wire_length_from}">
							<input type="text" name="wire_length_to" class="form-control" placeholder="To" value="${wire_length_to}">
						</div>
					</div>

					<div class="form-group">
						<label for="power">
							<fmt:message key="main.power" />
							:
						</label>
						<div class="form-inline" id="power">
							<input type="text" name="power_from" class="form-control" placeholder="From" value="${power_from}">
							<input type="text" name="power_to" class="form-control" placeholder="To" value="${power_to}">
						</div>
					</div>

					<div class="form-group">
						<label for="weight">
							<fmt:message key="main.weight" />
							:
						</label>
						<div class="form-inline" id="weight">
							<input type="text" name="weight_from" class="form-control" placeholder="From" value="${weight_from}">
							<input type="text" name="weight_to" class="form-control" placeholder="To" value="${weight_to}">
						</div>
					</div>

					<button type="submit" class="btn btn-primary">
						<fmt:message key="main.filter" />
					</button>
				</form>
			</div>
		</div>

		<div class="col-md-10 row">
			<div class="col-md-7" id="main-area">
				<br>
				<div class="container">
					<form name="sort" action="main" class="form-horizontal">
						<div class="input-group">
							<select name="sort-type" class="form-control">
								<option value="power" selected><fmt:message key="main.power" /></option>
								<option value="color"><fmt:message key="main.color" /></option>
								<option value="wire_length"><fmt:message key="main.wire.length" /></option>
								<option value="weight"><fmt:message key="main.weight" /></option>
							</select>
							<span class="input-group-btn">
								<button type="submit" class="btn btn-primary">
									<fmt:message key="main.sort" />
								</button>
							</span>
						</div>
					</form>
				</div>

				<div>
					<table class="table">
						<tr>
							<th><fmt:message key="main.power" /></th>
							<th><fmt:message key="main.color" /></th>
							<th><fmt:message key="main.wire.length" /></th>
							<th><fmt:message key="main.weight" /></th>
							<th><fmt:message key="main.turned.on.label" /></th>
							<th></th>
						</tr>
						<c:forEach var="appliance" items="${appliances}">
							<tr>
								<td>${appliance.power}</td>
								<td>${appliance.color}</td>
								<td>${appliance.wireLength}</td>
								<td>${appliance.weight}</td>
								<td><c:choose>
										<c:when test="${appliance.isTurnedOn}">
											<span style="color: #1D9E3F;">
												<fmt:message key="main.yes" />
											</span>
										</c:when>
										<c:otherwise>
											<span style="color: #D43B27;">
												<fmt:message key="main.no" />
											</span>
										</c:otherwise>
									</c:choose></td>
								<td><form name="turn-on" action="main" class="form-horizontal">
										<input type="hidden" name="operation" value="turn-on">
										<input type="hidden" name="id" value="${appliance.id}">
										<input type="submit" value="<fmt:message key="main.turn.on" />" class="btn btn-link" id="turn-on">
									</form></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

			<div class="col-md-5">
				<br>
				<div class="container" id="turned-on-form">
					<form id="count-power" action="main" class="form-horizontal">
						<input type="hidden" name="operation" value="count-power">
						<div class="form-group">
							<label class="col-md-12 control-label">
								<fmt:message key="main.total.power" />
								: <strong>${totalPowerConsumption} </strong>
							</label>
						</div>
						<input type="submit" value="<fmt:message key="main.count" />" class="btn btn-primary" id="count-button">
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="includes/footer.jsp"%>