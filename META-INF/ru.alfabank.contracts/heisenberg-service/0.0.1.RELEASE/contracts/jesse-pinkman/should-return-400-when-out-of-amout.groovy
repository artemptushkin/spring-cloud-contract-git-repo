import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		url '/blueCrystals'
		headers {
			header 'Content-Type' : 'application/json;charset=UTF-8'
		}
		body(
			amount: 1000
		)
		bodyMatchers {
			jsonPath('$.amount', byEquality())
		}
	}
	response {
		status 400
	}
}


