import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		url '/blueCrystals/create'
		headers {
			header 'Content-Type' : 'application/json;charset=UTF-8'
		}
		body(
			amount: 100
		)
		bodyMatchers {
			jsonPath('$.amount', byEquality())
		}
	}
	response {
		status 201
		headers {
			header 'Content-Type' : 'application/json;charset=UTF-8'
		}
		body(
			amount: fromRequest().body('$.amount'),
			price: 5000d
		)
		bodyMatchers {
			jsonPath('$.amount', byRegex('^\\d*$'))
			jsonPath('$.price', byEquality())
		}
	}
}
