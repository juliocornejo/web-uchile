var solicitudCertificadoApp = angular.module('login',[]);



solicitudCertificadoApp.controller('LoginController', [ '$scope', '$http', '$window', '$sce',
                                                        function($scope, $http, $window, $sce) {

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
	$scope.pestanaLogin;
	$scope.pestanaConfirmacion;
	$scope.tabAntecedentes;
	$scope.tabConfirmacion;
	$scope.liLogin;
	$scope.modalCargando;
	
	$scope.parsearLoginJson = function() {
				
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.ficha = $window.ficha;
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
		
		$scope.pestanaLogin = $('a[id=pestanaLogin]');
		$scope.pestanaConfirmacion = $('a[id=pestanaConfirmacion]');
		$scope.tabAntecedentes = $('div[id=antecedentes]');
		$scope.tabConfirmacion = $('div[id=confirmacion]');
		
		$scope.pestanaLogin.attr('disabled','disabled');
		
		$scope.liLogin = $('li[id=pestana1');
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

        $http.post('/web-uchile-front-solicitudes/rest/LoginService/loginUsuario', data, config)
        
        
        .then(function (response) {
        	if(response.data !== undefined && response.data.ok == true){
        			//var url = $window.origin +'/'+ response.data.redireccion;
        			//$window.location.href = url;
        			$scope.modalCargando.modal("hide");
        			
        			setTimeout(function(){
        				 $http.post('/web-uchile-front-solicitudes/rest/LoginService/redireccionAdministracion', data, config)
        				
        			}, 1000);
        		}else{
        			$scope.modalCargando.modal("hide");
        			$scope.mensaje.html("<span><strong>*</strong> Usuario Inválido.</span>");
            		$scope.mensaje.attr('style','display: block;')
        		}
            }
        );
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
	
	
	
	
}]);