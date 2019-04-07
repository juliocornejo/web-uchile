var solicitudCertificadoApp = angular.module('solicitudPostulacionExito',[]);



solicitudCertificadoApp.controller('SolicitudPostulacionExitoController', [ '$scope', '$http', '$window', '$sce',
                                                        function($scope, $http, $window, $sce) {
	

	/*variables globales*/
	$scope.val = null;
	$scope.pagina = null;
	
	$scope.leerSolicitudPostulacionExito = function() {
				
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.obtenerComponentesFormulario();
		console.log('=================================================================================================================');
	};
	
	$scope.obtenerComponentesFormulario = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		$scope.botonSalir = $('button[id=salir]');
		$scope.pagina = '/postulacion/';
		console.log('=================================================================================================================');
	};

	$scope.cerrarVentana = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		var strCadena = $window.location.pathname;
		var array = $window.location.pathname.split("/");
		var url = $window.origin +  '/'+ array[1] + $scope.pagina;
		$window.location.href = url;
		
		console.log('=================================================================================================================');
	};
	
	
	$scope.leerSolicitudPostulacionError = function() {
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.obtenerComponentesFormulario();
		console.log('=================================================================================================================');
	};
	
}]);