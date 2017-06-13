angular.module("oportunidades").factory("candidatoAPI", function ($http, config) {
	var _salvaCandidato = function (candidato) {
		return $http.post(config.baseUrl + "/candidatos", candidato);
	};

	return {
		salvaCandidato: _salvaCandidato
	};
});