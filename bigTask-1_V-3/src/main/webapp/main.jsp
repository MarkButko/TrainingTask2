<%@ include file="includes/before_head.jsp"%>
<style>
body {
	background-color: LightGray;
}

nav {
	background-color: BurlyWood;
}

label {
	margin-bottom: 0px;
	margin-top: 3px;
}

select {
	margin-right: 5px;
}

table {
	margin-top: 5px;
}

.main-container {
	height: 100%;
}

.form-inline {
	margin: 0px;
}

#filter-bar {
	background-color: DarkSeaGreen;
	min-height: 100%;
}

#turned_on_form, #turned_on_content {
	background-color: LightCoral;
	padding: 10px;
	margin: 5px;
	border-radius: 10px;
	float: left;
	border-radius: 10px;
}

#main-area {
	background-color: Plum;
}

#count-button {
	float: right;
}
</style>

<%@ include file="includes/after_head.jsp"%>
<%@ include file="includes/navigation.jsp"%>
<div class="container-fluid">
	<div class="row main-container">
		<div class="col-md-2" id="filter-bar">
			<br>
			<div class="container">
				<form name="filter" action="main">
					<input type="hidden" name="operation" value="filter"> <label
						for="color-filter">Color: <input type="text"
						name="color-filter" class="form-control"></label>
					<div class="form-group">
						<label for="wire-length">Wire length:</label>
						<div class="form-inline" id="wire-length">
							<input type="text" name="wire-length-from" class="form-control"
								placeholder="From"> <input type="text"
								name="wire-length-to" class="form-control" placeholder="To">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Filter</button>
				</form>
			</div>
		</div>

		<div class="col-md-10 row">
			<div class="col-md-7" id="main-area">
				<br>
				<div class="container">
					<form name="sort" action="main" class="form-horizontal">
						<input type="hidden" name="operation" value="sort">
						<div class="input-group">
							<select name="sort_type" class="form-control">
								<option value="power" selected>Power</option>
								<option value="color">Color</option>
							</select> <span class="input-group-btn">
								<button type="submit" class="btn btn-primary">Sort</button>
							</span>
						</div>
					</form>
				</div>

				<div>
					<table class="table">
						<tr>
							<th>Power</th>
							<th>Color</th>
							<th>Wire length</th>
							<th>Weight</th>
							<th>Turned on</th>
							<th></th>
						</tr>
						<c:forEach var="appliance" items="${appliances}">
							<tr>
								<td>${appliance.power}</td>
								<td>${appliance.color}</td>
								<td>${appliance.wireLength}</td>
								<td>${appliance.weight}</td>
								<td><c:if test="${appliance.isTurnedOn}">
										<span style="color: green;">Yes</span>
									</c:if> <c:if test="${!appliance.isTurnedOn}">
										<span style="color: red;">Not</span>
									</c:if></td>
								<td><form name="turn_on" action="main"
										class="form-horizontal">
										<input type="hidden" name="operation" value="turn_on">
										<input type="hidden" name="id" value="${appliance.id}">
										<input type="submit" value="Turn on" class="btn btn-link"
											id="turn_on">
									</form></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

			<div class="col-md-5">
				<br>
				<div class="container" id="turned_on_form">
					<form id="count_power" action="main" class="form-horizontal">
						<input type="hidden" name="operation" value="count_power">
						<div class="form-group">
							<label class="col-md-12 control-label">Total power
								consumption: <strong>${totalPowerConsumption} </strong>
							</label>
						</div>
						<input type="submit" value="Count" class="btn btn-primary"
							id="count-button">
					</form>
				</div>
				<label>Turned on devices:</label><br>
				<div class="container" id="turned_on_content"></div>
			</div>
		</div>
	</div>
</div>
<%@ include file="includes/footer.jsp"%>