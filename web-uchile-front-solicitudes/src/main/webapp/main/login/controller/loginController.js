'use strict';
angular.module('uchileApp.login')

.controller('LoginController', [ '$rootScope', '$http', '$log', '$window', '$sce', 'loginFactory',     function($rootScope, $http, $log, $window, $sce, loginFactory) {

	/*variables globales*/

	$rootScope.val = null;

	$rootScope.mensaje;
	$rootScope.error;
	$rootScope.ficha;
	$rootScope.selectedPrograma = 'Seleccionar Programa';
	$rootScope.jsonListaProgramaCtrl; 
	$rootScope.jsonTipoCertificadoCtrl; 
	$rootScope.jsonListaFinalidadCertificadoCtrl; 
	$rootScope.jsonListaSolicitudCertificadoCtrl; 
	$rootScope.jsonRequest;

	/*objetos de trabajos*/
	$rootScope.usuario;
	$rootScope.contrasenha;
	$rootScope.usuarioLogin;
	$rootScope.redireccionLogin;
	$rootScope.mensajeErrorLogin;
	/*botonera del formulario*/
	$rootScope.botonIniciar;
	$rootScope.botonRegistrar;

	/*pestañas*/
	$rootScope.pestanaLogin;
	$rootScope.pestanaConfirmacion;
	$rootScope.tabAntecedentes;
	$rootScope.tabConfirmacion;
	$rootScope.liLogin;
	$rootScope.modalCargando;

	$rootScope.parsearLoginJson = function() {
		console.log('=============================================== Inicializando Data Login ===========================================');
		
		$rootScope.ficha = $window.ficha;
		$rootScope.login = $window.login;

		$rootScope.error = $window.jsonMensajeError;
		console.log('=================================================================================================================');

		if($rootScope.ficha !== undefined && $rootScope.ficha !== null && $rootScope.ficha !== ""){
			console.log('Obtencion de Ficha');
			$rootScope.obtenerComponentesFormulario();
		}else{
			console.log('fallo en traer la ficha');
		}

		if($rootScope.error !== undefined && $rootScope.error.mensajeError !== ""){
			$rootScope.mensaje.html("<span><strong>*</strong> " + $rootScope.error.mensajeError + ".</span>");
			$rootScope.mensaje.attr('style','display: block;')
		}
		
		$rootScope.mensajeErrorLogin =  "el usuario no puede ser validado";
	};

	$rootScope.obtenerComponentesFormulario = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		$rootScope.usuario = $('input[id=usuario]');
		$rootScope.contrasenha = $('input[id=contrasenha]');

		$rootScope.botonIniciar = $('button[id=iniciar]');
		$rootScope.botonRegistrar = $('button[id=registrar]');

		$rootScope.pestanaLogin = $('a[id=pestanaLogin]');
		$rootScope.pestanaConfirmacion = $('a[id=pestanaConfirmacion]');
		$rootScope.tabAntecedentes = $('div[id=antecedentes]');
		$rootScope.tabConfirmacion = $('div[id=confirmacion]');

		$rootScope.pestanaLogin.attr('disabled','disabled');

		$rootScope.liLogin = $('li[id=pestana1');
		$rootScope.mensaje = $('div[id=msg');

		$rootScope.modalCargando = $('div[id=cargandoModal');

		console.log('=================================================================================================================');
	};

	$rootScope.registrarUsuario= function(){
		console.log('=============================================== Limpiar Formulario  ===========================================');
		$rootScope.nombre.val('');
		$rootScope.apellidoPaterno.val('');
		$rootScope.apellidoMaterno.val('');
		$rootScope.rut.val('');
		$rootScope.correo.val('');
		$rootScope.annoIngresos.val('');

		$rootScope.nombresLabel.text('');
		$rootScope.apellidoPaternoLabel.text('');
		$rootScope.apellidoMaternoLabel.text('');
		$rootScope.rutLabel.text('');
		$rootScope.correoLabel.text('');
		$rootScope.programaLabel.text('');
		$rootScope.annoIngresosLabel.text('');
		$rootScope.tipoLabel.text('');
		$rootScope.finesLabel.text('');
		$rootScope.objetoPrograma = null;
		$rootScope.selectedPrograma =  'Seleccionar Programa';

		if($rootScope.objetoTipoCertificado !== undefined && $rootScope.objetoTipoCertificado != null && $rootScope.objetoTipoCertificado.idTipoCertificado != 0){
			$('input[id='+ $rootScope.objetoTipoCertificado.idTipoCertificado +']').val('');
			$('input[id='+ $rootScope.objetoTipoCertificado.idTipoCertificado +']').removeAttr("checked");
		}
		if($rootScope.objetoFinalidadCertificado !== undefined && $rootScope.objetoFinalidadCertificado != null && $rootScope.objetoFinalidadCertificado.idFinalidadCertificado != 0){
			$('input[id='+ $rootScope.objetoFinalidadCertificado.idFinalidadCertificado +']').val('');
			$('input[id='+ $rootScope.objetoFinalidadCertificado.idFinalidadCertificado +']').removeAttr("checked");
		}

		$rootScope.mensaje.attr('style','display: none;')
		$rootScope.mensaje.html('');

		console.log('======================================================================================================================');
	};

	$rootScope.siguienteFormulario = function(){
		console.log('===================================== Obtener Data Pasar Siguiente Pestaña ========================================');
		var seguir = $rootScope.validarData();
		if(!seguir) 
			return; 


		$rootScope.mensaje.attr('style','display: none;')
		$rootScope.mensaje.html('');

		$rootScope.nombresLabel.text($rootScope.nombre.val());
		$rootScope.apellidoPaternoLabel.text($rootScope.apellidoPaterno.val());
		$rootScope.apellidoMaternoLabel.text($rootScope.apellidoMaterno.val());
		$rootScope.rutLabel.text($rootScope.rut.val());
		$rootScope.correoLabel.text($rootScope.correo.val());
		$rootScope.annoIngresosLabel.text($rootScope.annoIngresos.val());

		if($rootScope.objetoPrograma !== undefined && $rootScope.objetoPrograma != null){
			$rootScope.programaLabel.text($rootScope.objetoPrograma.nombreProgramaUniversidad);
		}
		if($rootScope.objetoTipoCertificado !== undefined && $rootScope.objetoTipoCertificado != null){
			$rootScope.tipoLabel.text($rootScope.objetoTipoCertificado.nombreTipoCertificado);
		}
		if($rootScope.objetoFinalidadCertificado !== undefined && $rootScope.objetoFinalidadCertificado != null){
			$rootScope.finesLabel.text($rootScope.objetoFinalidadCertificado.nombreFinalidadCertificado);
		}	

		$rootScope.botonIniciar.hide();
		$rootScope.botonRegistrar.hide();

		$rootScope.habilitarPestanaConfirmacion();

		console.log('=================================================================================================================');
	};

	$rootScope.obtenerUsuarioLogin = function(){

		var seguir = $rootScope.validarData();
		if(!seguir) 
			return; 

		$rootScope.modalCargando.modal("show");

		loginFactory.obtenerLoginFactory($rootScope.usuario.val(), $rootScope.contrasenha.val(), $rootScope.ficha);
		//redirecciona una vez que haya obtenido el valor del service			
		setTimeout(function(){
			$rootScope.obtenerUsuarioLoginDos();
		}, 500);

	};
	
	$rootScope.obtenerUsuarioLoginDos = function(){
		if($rootScope.usuarioLogin){
			$rootScope.redireccionar($rootScope.redireccionLogin);
		}else{
			if($rootScope.mensajeErrorLogin!==undefined){
				$rootScope.modalCargando.modal("hide");
				$rootScope.mensaje.html("<span><strong>*</strong>"+ $rootScope.mensajeErrorLogin+"</span>");
				$rootScope.mensaje.attr('style','display: block;');
			}else{
				$rootScope.obtenerUsuarioLoginDos();
			}
		}
	};
	
	$rootScope.redireccionar  = function(url){
		var form = $(document.createElement('form'));
		$(form).attr("action", url);
		$(form).attr("method", "POST");
		$(form).css("display", "none");

		form.appendTo(document.body);
		$(form).submit();
	};


	$rootScope.caracteresTexto = function (texto){
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

	$rootScope.validarData = function (){
		var validoUsuario= $rootScope.caracteresTexto($rootScope.usuario.val());
		if(!validoUsuario){
			$rootScope.mensaje.html("<span><strong>*</strong> Debe ingresar el nombre de Usuario.</span>");
			$rootScope.mensaje.attr('style','display: block;')
			return false;
		}		
		var validoContrasenha = $rootScope.caracteresTexto($rootScope.contrasenha.val());
		if(!validoContrasenha){
			$rootScope.mensaje.html("<span><strong>*</strong> Debe ingresar contraseña.</span>");
			$rootScope.mensaje.attr('style','display: block;')
			return false;
		}

		$rootScope.mensaje.html("");
		$rootScope.mensaje.attr('style','display: none;')
		console.log('======================================================================================================================');
		return true;
	}	

	$rootScope.levantarModal = function (){
		console.log('====================================== levantar el modal ========================================');
		$rootScope.modalCargando.modal("show");
		console.log('======================================================================================================================');
		return;
	}	

	$rootScope.bajarModal = function (){
		console.log('====================================== bajar el modal ========================================');
		$rootScope.modalCargando.modal("hide");
		console.log('======================================================================================================================');
		return;
	}	
}]);

//$rootScope.obtenerUsuarioLogin = function(){

//var seguir = $rootScope.validarData();
//if(!seguir) 
//return; 

//$rootScope.modalCargando.modal("show");
//$rootScope.jsonRequest =  new Object();

//$rootScope.jsonRequest.usernamePerfil =  $rootScope.usuario.val();
//$rootScope.jsonRequest.passwordContrasenha =  $rootScope.contrasenha.val();

//var data = $.param({
//requestJson: JSON.stringify($rootScope.jsonRequest),
//requestFicha: JSON.stringify($rootScope.ficha)
//});

//var config = {
//headers : {
//'Content-Type': 'application/json;',
//'Accept-Encoding' : 'gzip',
//}
//};

//$http.post('/web-uchile-front-solicitudes/rest/LoginService/loginUsuario', data, config).then(function (response) {
//if(response==null){
//$rootScope.modalCargando.modal("hide");
//$rootScope.mensaje.html("<span><strong>*</strong> Error.</span>");
//$rootScope.mensaje.attr('style','display: block;');
//}
//else if(response.data !== undefined && response.data.error !== undefined && response.data.error !== null){
//$rootScope.modalCargando.modal("hide");
//$rootScope.mensaje.html("<span><strong>*</strong> Usuario Sin validar.</span>");
//$rootScope.mensaje.attr('style','display: block;');
//}else if(response.data !== undefined && response.data.ok !== undefined && response.data.ok == true && response.data.data == "ok"){
//$rootScope.redireccion		//var url = $window.origin +'/'+ response.data.redireccion;
////$window.location.href = url;
//$rootScope.modalCargando.modal("hide");

//setTimeout(function(){


//var config = {
//headers : {
//'Content-Type': 'application/json;',
//'Accept-Encoding' : 'gzip',
//}
//};
//$rootScope.redireccionar(response.data.redireccion);

//}, 1000);
//}else{
//$rootScope.modalCargando.modal("hide");
//$rootScope.mensaje.html("<span><strong>*</strong> Usuario Inválido.</span>");
//$rootScope.mensaje.attr('style','display: block;')
//}
//}
//);
//};



