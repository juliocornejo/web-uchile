//var loginService = angular.module('loginService',[]);
//
//
//
//loginService.factory('loginService', ['$interval', '$scope', '$http', '$window', '$sce',
//                                                        function($interval, $scope, $http, $window, $sce) {
//
//	/*variables globales*/
//	$scope.val = null;
//	$scope.mensaje;
//	$scope.ficha;
//	$scope.error;
//	$scope.selectedPrograma = 'Seleccionar Programa';
//	$scope.jsonListaProgramaCtrl; 
//	$scope.jsonTipoCertificadoCtrl; 
//	$scope.jsonListaFinalidadCertificadoCtrl; 
//	$scope.jsonListaSolicitudCertificadoCtrl; 
//	$scope.jsonRequest;
//	
//	/*objetos de trabajos*/
//	$scope.usuario;
//	$scope.contrasenha;
//	
//	/*botonera del formulario*/
//	$scope.botonIniciar;
//	$scope.botonRegistrar;
//
//	/*pestañas*/
//	$scope.pestanaLogin;
//	$scope.pestanaConfirmacion;
//	$scope.tabAntecedentes;
//	$scope.tabConfirmacion;
//	$scope.liLogin;
//	$scope.modalCargando;
//	
//
//    $scope.serviceObtenerUsuarioLogin = function(data, config){
//    	
//    	
//
//        $http.post('/web-uchile-front-solicitudes/rest/LoginService/loginUsuario', data, config)
//        .then(
//        	function (response) {
//        		if(response.data == undefined || response.data == null){
//        			console.log('Servicio no disponible');
//        			//Error servicio Abajo
//        		}else if(response.data.error !== undefined && response.data.error !== null){
//        			console.log('Error en el negocio');
//        			//Error en la logia del negocio
//        		}else if(response.data.ok!==undefined && response.wrapper.ok!==null && response.wrapper.ok!==true){
//        			console.log('OK');
//        			var url = $window.origin +'/'+ response.data.url;
//        			$window.location.href = url;
//        			$scope.modalCargando.modal("hide");
//        		}else{
//        			console.log('Error en el servicio');
//        			$scope.modalCargando.modal("hide");
//        		}
//            }
//        );
//    };
//    
//	$scope.caracteresTexto = function (texto){
//	  console.log('=============================================== validar texto =======================================================');
//	    console.log(texto);
//	    var caract = new RegExp(/^[0-9a-zA-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜ_\s]+$/);
//	    if (caract.test(texto) == false){
//	        return false;
//	    }else{
//	        return true;
//	    }
//	  console.log('======================================================================================================================');
//	}   
//
//	$scope.validarData = function (){
//    	var validoUsuario= $scope.caracteresTexto($scope.usuario.val());
//    	if(!validoUsuario){
//    		$scope.mensaje.html("<span><strong>*</strong> Debe ingresar el nombre de Usuario.</span>");
//    		$scope.mensaje.attr('style','display: block;')
//    		return false;
//    	}		
//    	var validoContrasenha = $scope.caracteresTexto($scope.contrasenha.val());
//    	if(!validoContrasenha){
//    		$scope.mensaje.html("<span><strong>*</strong> Debe ingresar contraseña.</span>");
//    		$scope.mensaje.attr('style','display: block;')
//    		return false;
//    	}
//	
//		$scope.mensaje.html("");
//		$scope.mensaje.attr('style','display: none;')
//		console.log('======================================================================================================================');
//		return true;
//	}	
//	
//	$scope.levantarModal = function (){
//		console.log('====================================== levantar el modal ========================================');
//		$scope.modalCargando.modal("show");
//		console.log('======================================================================================================================');
//		return;
//	}	
//	
//	$scope.bajarModal = function (){
//		console.log('====================================== bajar el modal ========================================');
//		$scope.modalCargando.modal("hide");
//		console.log('======================================================================================================================');
//		return;
//	}	
//	
//	
//	
//	
//}]);