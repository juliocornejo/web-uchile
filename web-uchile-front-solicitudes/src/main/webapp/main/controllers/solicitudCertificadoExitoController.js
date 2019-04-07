var solicitudCertificadoApp = angular.module('solicitudCertificadoExito',[]);



solicitudCertificadoApp.controller('SolicitudCertificadoExitoController', [ '$scope', '$http', '$window', '$sce',
                                                        function($scope, $http, $window, $sce) {
	

	/*variables globales*/
	$scope.val = null;
	$scope.pagina = null;
	
	$scope.leerSolicitudCertificadoExito = function() {
				
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.obtenerComponentesFormulario();
		console.log('=================================================================================================================');
	};
	
	$scope.obtenerComponentesFormulario = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		$scope.botonSalir = $('button[id=salir]');
		$scope.pagina = '/certificado/';
		console.log('=================================================================================================================');
	};

	$scope.cerrarVentana = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		var strCadena = $window.location.pathname;
		var array = $window.location.pathname.split("/");
		var url = $window.origin +  '/'+ array[1] + $scope.pagina;
		$window.location.href = url;
		
		console.log('=================================================================================================================');
	}

	$scope.leerSolicitudCertificadoError = function() {
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.obtenerComponentesFormulario();
		console.log('=================================================================================================================');
	};
	
}]);