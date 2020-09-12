package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'GET'
		url '/ratingsdata/users/100'
	}
	response {
		status OK()
		body(file("ShouldGetRatingForUserResponse.json"))
		headers {
			contentType('application/json')
		}
	}
}