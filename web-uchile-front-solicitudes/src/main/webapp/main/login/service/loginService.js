'use strict';
angular.module('uchileApp.loginService', [])
.service('loginService', ['$q', '$http',  '$log',  function($q, $http, $log) {
 // 'use strict';

  /**** Funcion para obtener el avatar con indice **/

  var obtenerLoginService = function(usuario, contrasenha, ficha) {

		var jsonRequest =  new Object();
	  
	  		jsonRequest.usernamePerfil =  usuario;
	  		jsonRequest.passwordContrasenha =  contrasenha;
	  
	  		var request = $.param({
	  			requestJson: JSON.stringify(jsonRequest),
	  			requestFicha: JSON.stringify(ficha)
	  		});
	  
	  		return  $http({
	  			method: 'POST',
	  			data: request,
	  			url: '/web-uchile-front-solicitudes/rest/LoginService/loginUsuario',
	  			headers: {
	  				'Content-type': 'application/json'
	  			}
	  		})
	  		.success(function(wrapperResponse, status, headers, config) {
	  			
			}).error(function(wrapperResponse, status, headers, config) {
		        $log.error(status);
		        $log.error(wrapperResponse);                		
			});
	        }
	  		
	  		
  return {
	  obtenerLoginService: obtenerLoginService
    };
}]);