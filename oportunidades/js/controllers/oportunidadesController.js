angular.module("oportunidades").controller("oportunidadesCtrl", function ($scope, candidatoAPI) {
	$scope.app = "Oportunidades Meus Pedidos";

	$scope.candidato = {};

	$scope.candidato.conhecimentos = [
        { tecnologia: "HTML", nivel: 0 }, { tecnologia: "CSS", nivel: 0 }, { tecnologia: "JAVASCRIPT", nivel: 0 }, 
        { tecnologia: "PYTHON", nivel: 0 }, { tecnologia: "DJANGO", nivel: 0 }, 
        { tecnologia: "IOS", nivel: 0 },
        { tecnologia: "ANDROID", nivel: 0 }];

    var oriCandidato = angular.copy($scope.candidato);

    $scope.resetForm = function (){
	  $scope.candidato = angular.copy(oriCandidato);
      $scope.candidatoForm.$setPristine();
    };

	$scope.enviarCandidato = function (candidato) {
		candidatoAPI.salvaCandidato(candidato).then(function successCallback(response) {
			delete $scope.candidato;
			$scope.candidato = angular.copy(oriCandidato);
			$scope.candidatoForm.$setPristine();
			$scope.message = "Oportunidade cadastrada com sucesso, favor verificar seu e-mail!";
		}, function errorCallback(response) {
			$scope.message = "Aconteceu um problema: " + response.data;
		});
	};

});