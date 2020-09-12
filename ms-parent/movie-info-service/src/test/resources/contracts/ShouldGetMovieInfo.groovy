package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'GET'
		url '/movies/100'
	}
	response {
		status OK()
		body([
			"movieId": "100",
			"name": "Lock, Stock and Two Smoking Barrels",
			"description": "A card shark and his unwillingly-enlisted friends need to make a lot of cash quick after losing a sketchy poker match. To do this they decide to pull a heist on a small-time gang who happen to be operating out of the flat next door."
		])
		headers {
			contentType('application/json')
		}
	}
}