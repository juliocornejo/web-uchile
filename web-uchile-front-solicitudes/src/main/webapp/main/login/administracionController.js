var uchileApp = angular.module('uchileApp.administracion')

.controller('AdministracionController', [ '$scope', '$http', '$window', '$sce', 'notify',   function($scope, $http, $window, $sce, notify) {

	/*variables globales*/

	$scope.val = null;
	
	$scope.mensaje;
	$scope.error;
	$scope.ficha;
	$scope.selectedPrograma = 'Seleccionar Programa';
	$scope.jsonListaProgramaCtrl; 
	$scope.jsonTipoCertificadoCtrl; 
	$scope.jsonListaFinalidadCertificadoCtrl; 
	$scope.jsonListaSolicitudCertificadoCtrl; 
	$scope.jsonRequest;
	
	/*objetos de trabajos*/
	$scope.usuario;
	$scope.contrasenha;
	
	/*botonera del formulario*/
	$scope.botonIniciar;
	$scope.botonRegistrar;

	/*pestañas*/
	$scope.pestanaAdministracion;
	$scope.pestanaConfirmacion;
	$scope.tabAntecedentes;
	$scope.tabConfirmacion;
	$scope.liLogin;
	$scope.modalCargando;
	
	$scope.parsearAdministracionJson = function() {
		console.log('=============================================== Inicializando Data Certificados ===========================================');
	//	$scope.ficha = $window.ficha;
		$scope.login = $window.login;

		$scope.error = $window.jsonMensajeError;
		console.log('=================================================================================================================');
		
		if($scope.ficha !== undefined && $scope.ficha !== null && $scope.ficha !== ""){
			console.log('Lista	de Programas');
			$scope.obtenerComponentesFormulario();
		}else{
			console.log('fallo en traer la ficha');
		}
		
		if($scope.error !== undefined && $scope.error.mensajeError !== ""){
    		$scope.mensaje.html("<span><strong>*</strong> " + $scope.error.mensajeError + ".</span>");
    		$scope.mensaje.attr('style','display: block;')
		}
	};
	
	$scope.obtenerComponentesFormulario = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		$scope.usuario = $('input[id=usuario]');
		$scope.contrasenha = $('input[id=contrasenha]');
		
		$scope.botonIniciar = $('button[id=iniciar]');
		$scope.botonRegistrar = $('button[id=registrar]');
		
		$scope.pestanaAdministracion = $('a[id=pestanaAdministracion]');
		$scope.pestanaConfirmacion = $('a[id=pestanaConfirmacion]');
		$scope.tabAntecedentes = $('div[id=antecedentes]');
		$scope.tabConfirmacion = $('div[id=confirmacion]');
		
		$scope.pestanaAdministracion.attr('disabled','disabled');
		
		$scope.liAdministracion = $('li[id=pestana1');
		$scope.mensaje = $('div[id=msg');
		
		$scope.modalCargando = $('div[id=cargandoModal');
		
		console.log('=================================================================================================================');
	};
	
	$scope.registrarUsuario= function(){
		console.log('=============================================== Limpiar Formulario  ===========================================');
		$scope.nombre.val('');
		$scope.apellidoPaterno.val('');
		$scope.apellidoMaterno.val('');
		$scope.rut.val('');
		$scope.correo.val('');
		$scope.annoIngresos.val('');
		
		$scope.nombresLabel.text('');
		$scope.apellidoPaternoLabel.text('');
		$scope.apellidoMaternoLabel.text('');
		$scope.rutLabel.text('');
		$scope.correoLabel.text('');
		$scope.programaLabel.text('');
		$scope.annoIngresosLabel.text('');
		$scope.tipoLabel.text('');
		$scope.finesLabel.text('');
		$scope.objetoPrograma = null;
		$scope.selectedPrograma =  'Seleccionar Programa';

		if($scope.objetoTipoCertificado !== undefined && $scope.objetoTipoCertificado != null && $scope.objetoTipoCertificado.idTipoCertificado != 0){
			$('input[id='+ $scope.objetoTipoCertificado.idTipoCertificado +']').val('');
			$('input[id='+ $scope.objetoTipoCertificado.idTipoCertificado +']').removeAttr("checked");
		}
		if($scope.objetoFinalidadCertificado !== undefined && $scope.objetoFinalidadCertificado != null && $scope.objetoFinalidadCertificado.idFinalidadCertificado != 0){
			$('input[id='+ $scope.objetoFinalidadCertificado.idFinalidadCertificado +']').val('');
			$('input[id='+ $scope.objetoFinalidadCertificado.idFinalidadCertificado +']').removeAttr("checked");
		}
		
		$scope.mensaje.attr('style','display: none;')
		$scope.mensaje.html('');
		
		console.log('======================================================================================================================');
	};
	
	

	$scope.siguienteFormulario = function(){
		console.log('===================================== Obtener Data Pasar Siguiente Pestaña ========================================');
		var seguir = $scope.validarData();
		if(!seguir) 
			return; 
		
		
		$scope.mensaje.attr('style','display: none;')
		$scope.mensaje.html('');
		
		$scope.nombresLabel.text($scope.nombre.val());
		$scope.apellidoPaternoLabel.text($scope.apellidoPaterno.val());
		$scope.apellidoMaternoLabel.text($scope.apellidoMaterno.val());
		$scope.rutLabel.text($scope.rut.val());
		$scope.correoLabel.text($scope.correo.val());
		$scope.annoIngresosLabel.text($scope.annoIngresos.val());
		
		if($scope.objetoPrograma !== undefined && $scope.objetoPrograma != null){
			$scope.programaLabel.text($scope.objetoPrograma.nombreProgramaUniversidad);
		}
		if($scope.objetoTipoCertificado !== undefined && $scope.objetoTipoCertificado != null){
			$scope.tipoLabel.text($scope.objetoTipoCertificado.nombreTipoCertificado);
		}
		if($scope.objetoFinalidadCertificado !== undefined && $scope.objetoFinalidadCertificado != null){
			$scope.finesLabel.text($scope.objetoFinalidadCertificado.nombreFinalidadCertificado);
		}	
		
		$scope.botonIniciar.hide();
		$scope.botonRegistrar.hide();

		$scope.habilitarPestanaConfirmacion();
		
		console.log('=================================================================================================================');
	};
	
//	$scope.obtenerUsuarioAdministracion = function(){
//	
//			var seguir = $scope.validarData();
//			if(!seguir) 
//				return; 
//	
//			$scope.modalCargando.modal("show");
//			
//			notify($scope.usuario.val(), $scope.contrasenha.val(), $scope.ficha ).success(function(response) {
//				var a = response;
//			}).error(function(data, status, headers, config) {
//    	        //$log.error(status);
//    	        //$log.error(data);                		
//        	});
//
//		};
	$scope.obtenerUsuarioLogin = function(){

		var seguir = $scope.validarData();
		if(!seguir) 
			return; 

		$scope.modalCargando.modal("show");
		$scope.jsonRequest =  new Object();

		$scope.jsonRequest.usernamePerfil =  $scope.usuario.val();
		$scope.jsonRequest.passwordContrasenha =  $scope.contrasenha.val();

		var data = $.param({
			requestJson: JSON.stringify($scope.jsonRequest),
			requestFicha: JSON.stringify($scope.ficha)
		});

		var config = {
				headers : {
					'Content-Type': 'application/json;',
					'Accept-Encoding' : 'gzip',
				}
		};

		$http.post('/web-uchile-front-solicitudes/rest/AdministracionService/loginUsuario', data, config).then(function (response) {
			if(response==null){
				$scope.modalCargando.modal("hide");
				$scope.mensaje.html("<span><strong>*</strong> Error.</span>");
				$scope.mensaje.attr('style','display: block;');
			}
			else if(response.data !== undefined && response.data.error !== undefined && response.data.error !== null){
				$scope.modalCargando.modal("hide");
				$scope.mensaje.html("<span><strong>*</strong> Usuario Sin validar.</span>");
				$scope.mensaje.attr('style','display: block;');
			}else if(response.data !== undefined && response.data.ok !== undefined && response.data.ok == true && response.data.data == "ok"){
				//var url = $window.origin +'/'+ response.data.redireccion;
				//$window.location.href = url;
				$scope.modalCargando.modal("hide");

				setTimeout(function(){

					
					var config = {
							headers : {
								'Content-Type': 'application/json;',
								'Accept-Encoding' : 'gzip',
							}
					};
					$scope.redireccionar(response.data.redireccion);

				}, 1000);
			}else{
				$scope.modalCargando.modal("hide");
				$scope.mensaje.html("<span><strong>*</strong> Usuario Inválido.</span>");
				$scope.mensaje.attr('style','display: block;')
			}
		}
		);
	};
	
	$scope.redireccionar  = function(url){
		var form = $(document.createElement('form'));
        $(form).attr("action", url);
        $(form).attr("method", "POST");
        $(form).css("display", "none");

//        var key = $("<input>") .attr("type", "text") .attr("name", "key") .val(ficha);
//        $(form).append($(key));

        form.appendTo( document.body );
        $(form).submit();
	};

    
	$scope.caracteresTexto = function (texto){
	  console.log('=============================================== validar texto =======================================================');
	    console.log(texto);
	    var caract = new RegExp(/^[0-9a-zA-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜ_\s]+$/);
	    if (caract.test(texto) == false){
	        return false;
	    }else{
	        return true;
	    }
	  console.log('======================================================================================================================');
	}   

	$scope.validarData = function (){
    	var validoUsuario= $scope.caracteresTexto($scope.usuario.val());
    	if(!validoUsuario){
    		$scope.mensaje.html("<span><strong>*</strong> Debe ingresar el nombre de Usuario.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}		
    	var validoContrasenha = $scope.caracteresTexto($scope.contrasenha.val());
    	if(!validoContrasenha){
    		$scope.mensaje.html("<span><strong>*</strong> Debe ingresar contraseña.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}
	
		$scope.mensaje.html("");
		$scope.mensaje.attr('style','display: none;')
		console.log('======================================================================================================================');
		return true;
	}	
	
	$scope.levantarModal = function (){
		console.log('====================================== levantar el modal ========================================');
		$scope.modalCargando.modal("show");
		console.log('======================================================================================================================');
		return;
	}	
	
	$scope.bajarModal = function (){
		console.log('====================================== bajar el modal ========================================');
		$scope.modalCargando.modal("hide");
		console.log('======================================================================================================================');
		return;
	}	
}]).

factory('notify', ['$window', '$http', function(win, $http) {
   var msgs = [];
   return function(usuario, contrasenha, ficha) {
	   
	  		
		var jsonRequest =  new Object();

		jsonRequest.usernamePerfil =  usuario;
		jsonRequest.passwordContrasenha =  contrasenha;

		var data = $.param({
			requestJson: JSON.stringify(jsonRequest),
			requestFicha: JSON.stringify(ficha)
		});

		var config = {
				headers : {
					'Content-Type': 'application/json;',
					'Accept-Encoding' : 'gzip',
				}
		};
		
		
		return $http.post('/web-uchile-front-solicitudes/rest/AdministracionService/loginUsuario', data, config)
		.then(function (response){}
			
		);
	   
   };
 }]);



