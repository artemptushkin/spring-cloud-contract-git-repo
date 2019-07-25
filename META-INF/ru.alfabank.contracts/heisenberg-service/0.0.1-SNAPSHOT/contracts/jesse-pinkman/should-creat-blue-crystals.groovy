import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		url '/blueCrystals/create'
		headers {
			header 'Content-Type' : 'application/json'
		}
		body(
			amount: 200
		)
		bodyMatchers {
			jsonPath('$.amount', byRegex('^[0-9]{1,3}$'))
		}
	}
	response {
		status 201
		body(
			amount: fromRequest().body('$.amount'),
			price: 10100.0d
		)
		bodyMatchers {
			jsonPath('$.amount', byRegex('^\\d*$'))
			jsonPath('$.price', byEquality())
		}
	}
}
