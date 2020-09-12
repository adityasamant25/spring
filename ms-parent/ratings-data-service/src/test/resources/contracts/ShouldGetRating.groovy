package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'GET'
		url '/ratingsdata/100'
	}
	response {
		status OK()
		body([
			movieId: "100",
			rating: 4
		])
		headers {
			contentType('application/json')
		}
	}
}