import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		url '/blueCrystals/create'
		headers {
			header 'Content-Type' : 'application/json'
		}
		body(
			amount: 1000
		)
		bodyMatchers {
			jsonPath('$.amount', byRegex('^[0-9]{4}$'))
		}
	}
	response {
		status 400
	}
}


