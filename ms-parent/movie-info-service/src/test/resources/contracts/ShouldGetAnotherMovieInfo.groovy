package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'GET'
		url '/movies/200'
	}
	response {
		status OK()
		body([
			"movieId": "200",
			"name": "Star Trek: Insurrection",
			"description": "When an alien race and factions within Starfleet attempt to take over a planet that has \"regenerative\" properties, it falls upon Captain Picard and the crew of the Enterprise to defend the planet's people as well as the very ideals upon which the Federation itself was founded."
		])
		headers {
			contentType('application/json')
		}
	}
}