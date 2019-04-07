var solicitudCertificadoApp = angular.module('solicitudAcademicaExito',[]);



solicitudCertificadoApp.controller('SolicitudAcademicaExitoController', [ '$scope', '$http', '$window', '$sce',
                                                        function($scope, $http, $window, $sce) {
	

	/*variables globales*/
	$scope.val = null;
	$scope.pagina = null;
	
	$scope.leerSolicitudAcademicaExito = function() {
				
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.obtenerComponentesFormulario();
		console.log('=================================================================================================================');
	};
	
	$scope.obtenerComponentesFormulario = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		$scope.botonSalir = $('button[id=salir]');
		$scope.pagina = '/academica/';
		console.log('=================================================================================================================');
	};

	$scope.cerrarVentanaAcademica = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		var strCadena = $window.location.pathname;
		var array = $window.location.pathname.split("/");
		var url = $window.origin +  '/'+ array[1] + $scope.pagina;
		$window.location.href = url;
		
		console.log('=================================================================================================================');
	};
	
	
	$scope.leerSolicitudAcademicaError = function() {
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.obtenerComponentesFormulario();
		console.log('=================================================================================================================');
	};
	
}]);