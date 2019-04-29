'use strict';
angular.module('uchileApp.loginFactory', [])
.factory('loginFactory', ['$rootScope', '$q', '$http', '$log', 'loginService',  function($rootScope, $q, $http, $log, loginService) {
 // 'use strict';

  /**** Funcion para obtener el login de usuario **/
	
	return {
		obtenerLoginFactory: function(usuario, contrasenha, ficha) {

			var a = loginService.obtenerLoginService(usuario, contrasenha, ficha).then(function(wrapperResponse) {
				if(wrapperResponse.data.error==null && wrapperResponse.data.data!=null && wrapperResponse.data.data.procesoWebUchile ==true){
					$rootScope.usuarioLogin =  wrapperResponse.data.data.procesoWebUchile;
					$rootScope.redireccionLogin = wrapperResponse.data.data.redireccion;
				}else if(wrapperResponse.data.error!=null){
					$rootScope.mensajeErrorLogin =  "el usuario no puede ser validado";
				}else{
					$rootScope.usuarioLogin =  false;
					$rootScope.mensajeErrorLogin = "usuario invalido para iniciar session ";
				}
				 
			});
		
		}
	};
	
}]);