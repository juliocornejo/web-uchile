var solicitudCertificadoApp = angular.module('solicitudCertificado',[]);



solicitudCertificadoApp.controller('SolicitudCertificadoController', [ '$scope', '$http', '$window', '$sce',
                                                        function($scope, $http, $window, $sce) {
	

	/*variables globales*/
	$scope.val = null;
	$scope.mensaje;
	$scope.ficha;
	$scope.error;
	$scope.selectedPrograma = 'Seleccionar Programa';
	$scope.jsonListaProgramaCtrl; 
	$scope.jsonTipoCertificadoCtrl; 
	$scope.jsonListaFinalidadCertificadoCtrl; 
	$scope.jsonInformacionSolicitd;
	
	/*objetos de trabajos*/
	$scope.nombre;
	$scope.apellidoPaterno;
	$scope.apellidoMaterno;
	$scope.rut;
	$scope.correo;
	$scope.annoIngresos;
	$scope.objetoPrograma;
	$scope.objetoTipoCertificado;
	$scope.objetoFinalidadCertificado;
	
	$scope.nombresLabel;
	$scope.apellidoPaternoLabel;
	$scope.apellidoMaternoLabel;
	$scope.rutLabel;
	$scope.correoLabel;
	$scope.programaLabel;
	$scope.annoIngresosLabel;
	$scope.tipoLabel;
	$scope.finesLabel;

	
	/*botonera del formulario*/
	$scope.botonLimpiar;
	$scope.botonSiguiente;
	$scope.botonEnviar;
	$scope.botonVolver;
	
	
	/*pestañas*/
	$scope.pestanaAntecedentes;
	$scope.pestanaConfirmacion;
	$scope.tabAntecedentes;
	$scope.tabConfirmacion;
	$scope.liAntecedentes;
	$scope.liConfirmacion;
	$scope.modalCargando;
	
	
	
	
	
	$scope.parsearSolicitudCertificadoJson = function() {
				
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.ficha = $window.ficha;
		$scope.jsonListaProgramaCtrl = $window.jsonListaPrograma;
		$scope.jsonTipoCertificadoCtrl = $window.jsonListaTipoCertificado;
		$scope.jsonListaFinalidadCertificadoCtrl = $window.jsonListaFinalidadCertificado;
		$scope.error = $window.jsonMensajeError;
		console.log('=================================================================================================================');
		
		if($scope.jsonListaProgramaCtrl !== undefined){
			console.log('Lista	de Programas');
			$scope.obtenerComponentesFormulario();
		}else{
			console.log('fallo en traer json');
		}
		
		if($scope.error !== undefined && $scope.error.mensajeError !== ""){
    		$scope.mensaje.html("<span><strong>*</strong> " + $scope.error.mensajeError + ".</span>");
    		$scope.mensaje.attr('style','display: block;')
		}
		
	};
	
	
	$scope.seleccionDePrograma = function(programaUniversidad){
		
		if(programaUniversidad !== undefined){
			$scope.objetoPrograma = programaUniversidad;
			$scope.selectedPrograma =  programaUniversidad.nombreProgramaUniversidad;
		}else{
			$scope.objetoPrograma = null;
			$scope.selectedPrograma =  'Seleccionar Programa';
		}
		console.log('=============================================== Seleccion de Programa ===========================================');
		console.log(programaUniversidad);
		console.log('=================================================================================================================');
	};
	
	
	$scope.seleccionTipoCertificado = function(tipoCertificado){
		
		if(tipoCertificado !== undefined){
			$scope.objetoTipoCertificado = tipoCertificado;
		}
		console.log('=============================================== Seleccion de Certificado ===========================================');
		console.log($scope.objetoTipoCertificado);
		console.log('=================================================================================================================');
	};

	$scope.seleccionFinalidadCertificado= function(finalidadCertificado){
		
		if(finalidadCertificado !== undefined){
			$scope.objetoFinalidadCertificado = finalidadCertificado;
		}
		console.log('=============================================== Seleccion de Finalidad ===========================================');
		console.log($scope.objetoFinalidadCertificado);
		console.log('=================================================================================================================');
	};
	
	$scope.obtenerComponentesFormulario = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		$scope.nombre = $('input[id=nombres]');
		$scope.apellidoPaterno = $('input[id=apellidoPaterno]');
		$scope.apellidoMaterno = $('input[id=apellidoMaterno]');;
		$scope.rut = $('input[id=rut]');
		$scope.correo = $('input[id=correo]');
		$scope.annoIngresos = $('input[id=annoIngresos]');
		
		$scope.botonLimpiar = $('button[id=limpiar]');
		$scope.botonSiguiente = $('button[id=siguiente]');
		$scope.botonEnviar = $('button[id=enviar]');
		$scope.botonVolver = $('button[id=volver]');
		
		$scope.botonEnviar.hide();
		$scope.botonVolver.hide();
		
		$scope.nombresLabel = $('span[id=nombresLabel]'); 
		$scope.apellidoPaternoLabel = $('span[id=apellidoPaternoLabel]'); 
		$scope.apellidoMaternoLabel= $('span[id=apellidoMaternoLabel]'); 
		$scope.rutLabel = $('span[id=rutLabel]'); 
		$scope.correoLabel = $('span[id=correoLabel]'); 
		$scope.programaLabel = $('span[id=programaLabel]'); 
		$scope.annoIngresosLabel= $('span[id=annoIngresosLabel]'); 
		$scope.tipoLabel = $('span[id=tipoLabel]'); 
		$scope.finesLabel = $('span[id=finesLabel]'); 
		
		$scope.pestanaAntecedentes = $('a[id=pestanaAntecedentes]');
		$scope.pestanaConfirmacion = $('a[id=pestanaConfirmacion]');
		$scope.tabAntecedentes = $('div[id=antecedentes]');
		$scope.tabConfirmacion = $('div[id=confirmacion]');
		
		$scope.pestanaAntecedentes.attr('disabled','disabled');
		$scope.pestanaConfirmacion.attr('disabled','disabled');
		
		$scope.liAntecedentes = $('li[id=pestana1');
		$scope.liConfirmacion = $('li[id=pestana2');
		
		$scope.mensaje = $('div[id=msg');
		
		$scope.modalCargando = $('div[id=cargandoModal');
		
		console.log('=================================================================================================================');
	};
	
	$scope.limpiarFormulario= function(){
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
		
		$scope.botonLimpiar.hide();
		$scope.botonSiguiente.hide();
		
		$scope.botonEnviar.show();
		$scope.botonVolver.show();
		
		$scope.habilitarPestanaConfirmacion();
		
		console.log('=================================================================================================================');
	};
	
	
	$scope.habilitarPestanaConfirmacion = function(){
		console.log('========================================= Pasar a Pestaña de Confirmacion========================================');
		$scope.pestanaAntecedentes.addClass('boton-inactivo');
		$scope.pestanaAntecedentes.removeClass('boton-activo');
		$scope.pestanaAntecedentes.attr('style','border:1px solid #ddd;');

		$scope.pestanaConfirmacion.addClass('boton-activo');
		$scope.pestanaConfirmacion.removeClass('boton-inactivo');
		$scope.pestanaConfirmacion.attr('style','border:1px solid #fcefa1');
		
		
		$scope.tabAntecedentes.removeClass('in'); 
		$scope.tabAntecedentes.removeClass('active'); 
		
		$scope.tabConfirmacion.addClass('in');
		$scope.tabConfirmacion.addClass('active');
		
		$scope.liAntecedentes.removeClass('active');  
		$scope.liConfirmacion.addClass('active');
		
		
		console.log('====================================================================================================================');
	};
	
	$scope.volverPrimeraPestana = function(){
		console.log('===================================== Volver a La priemra pestaña ================================================');
		$scope.limpiarSegundaPestana();
		$scope.botonLimpiar.show();
		$scope.botonSiguiente.show();
		$scope.botonEnviar.hide();
		$scope.botonVolver.hide();
		$scope.desahabilitarPestanaConfirmacion();
		console.log('=================================================================================================================');
	};
	
	
	$scope.limpiarSegundaPestana= function(){
		console.log('=============================================== Limpiar Pestañas2  ===========================================');
		$scope.nombresLabel.text('');
		$scope.apellidoPaternoLabel.text('');
		$scope.apellidoMaternoLabel.text('');
		$scope.rutLabel.text('');
		$scope.correoLabel.text('');
		$scope.programaLabel.text('');
		$scope.annoIngresosLabel.text('');
		$scope.tipoLabel.text('');
		$scope.finesLabel.text('');
		console.log('======================================================================================================================');
	};
	$scope.desahabilitarPestanaConfirmacion = function(){
		console.log('========================================= Volver a Pestaña de Antecedentes    ========================================');
		$scope.pestanaAntecedentes.addClass('boton-activo ');
		$scope.pestanaAntecedentes.removeClass('boton-inactivo');
		$scope.pestanaAntecedentes.attr('style','border:1px solid #fcefa1;');
		
		$scope.pestanaConfirmacion.addClass('boton-inactivo');
		$scope.pestanaConfirmacion.removeClass('boton-activo');
		$scope.pestanaConfirmacion.attr('style','border:1px solid #ddd;');
		
		
		$scope.tabAntecedentes.addClass('in'); 
		$scope.tabAntecedentes.addClass('active'); 
		
		
		$scope.tabConfirmacion.removeClass('in');
		$scope.tabConfirmacion.removeClass('active');
		
		$scope.liAntecedentes.addClass('active');  
		$scope.liConfirmacion.removeClass('active');
		
		console.log('====================================================================================================================');
	};	
	
	
    $scope.almacenarSolicitudCertificadoPagoOffline = function(){
    	
    	$scope.modalCargando.modal("show");
     	
    	$scope.jsonInformacionSolicitd =  new Object();
    	
    	$scope.jsonInformacionSolicitd.nombrePersonaSolicitudCertificado =  $scope.nombre.val();
    	$scope.jsonInformacionSolicitd.apellidoPaternoPersonaSolicitudCertificado = $scope.apellidoPaterno.val();
    	$scope.jsonInformacionSolicitd.apellidoMaternoPersonaSolicitudCertificado = $scope.apellidoMaterno.val();
    	$scope.jsonInformacionSolicitd.rutPersonaSolicitudCertificado = $scope.rut.val();
    	$scope.jsonInformacionSolicitd.mailMember = $scope.correo.val();
    	$scope.jsonInformacionSolicitd.anhoIngreso = $scope.annoIngresos.val();
    	$scope.jsonInformacionSolicitd.programa = $scope.objetoPrograma;
    	$scope.jsonInformacionSolicitd.tipoCertificado = $scope.objetoTipoCertificado;
    	$scope.jsonInformacionSolicitd.finalidadCertificado = $scope.objetoFinalidadCertificado;
    	    	
    	var data = $.param({
    		requestJson: JSON.stringify($scope.jsonInformacionSolicitd),
    		requestFicha: JSON.stringify($scope.ficha)
        });
    
        var config = {
            headers : {
            	'Content-Type': 'application/json;',
                'Accept-Encoding' : 'gzip',
            }
        };

        $http.post('/web-uchile-front-solicitudes/rest/SolicitudCertificadoService/almacenarSolicitudCertificadoPagoOffline', data, config)
        .then(
        	function (response) {
        		if(response.data !== undefined){
        			var url = $window.origin +'/'+ response.data.url;
        			$window.location.href = url;
        			$scope.modalCargando.modal("hide");
        		}else{
        			$scope.modalCargando.modal("hide");
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
    
    
	$scope.validaRut= function(rut){
	  console.log('=============================================== validar rut ===========================================');
  	  var suma=0; 
	  var arrRut = rut.split("-"); 
	  var rutSolo = arrRut[0]; 
	  var verif = arrRut[1]; 
	  var continuar = true; 
	  for(i=2;continuar;i++){ 
	    suma += (rutSolo%10)*i; 
	    rutSolo = parseInt((rutSolo /10)); 
	    i=(i==7)?1:i; 
	    continuar = (rutSolo == 0)?false:true; 
	  }
	  resto = suma%11; dv = 11-resto; 
	   if(dv==10){  
	      if(verif.toUpperCase() == 'K') return true;
	   }else if (dv == 11 && verif == 0)
	    return true; 
	    else if (dv == verif) return true; 
	    else return false;
	   console.log('======================================================================================================================');
	   return false;
	};
	
	
	$scope.caracteresCorreoValido = function (email){
	  console.log('=============================================== validar correo =======================================================');
	    console.log(email);
	    var caract = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);
	    if (caract.test(email) == false){
	        return false;
	    }else{
	        return true;
	    }
	    
	    console.log('======================================================================================================================');
	}
	
	$scope.menorAlAnhoActual = function (anho){
		console.log('====================================== validar año actual versus al ingresado ========================================');
		var fecha = new Date();
		var hoy = fecha.getFullYear();

		if(anho === undefined || anho === '' || anho === null)
			return false;
		
		console.log('El año actual es: '+ anho);
		try{
			var verificado = $.isNumeric(anho);
			if(!verificado) return false;
		}catch (e) {
			return false;
		}
		
		if(anho > hoy){
			return false;
		}
		
		console.log('ano ingresado  '+ anho);
		console.log('======================================================================================================================');
		return true;
		

	}	

	$scope.validarData = function (){
		
		console.log('============================ verificacion de la informacion ingresada =================================================');

    	var validoNombre = $scope.caracteresTexto($scope.nombre.val());
    	if(!validoNombre){
    		$scope.mensaje.html("<span><strong>*</strong> Debe ingresar el nombre del Alumno.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}		
    	var validoPaterno = $scope.caracteresTexto($scope.apellidoPaterno.val());
    	if(!validoPaterno){
    		$scope.mensaje.html("<span><strong>*</strong> Debe ingresar el apellido paterno del Alumno.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}
    	
    	var validoMaterno = $scope.caracteresTexto($scope.apellidoMaterno.val());
    	if(!validoMaterno){
    		$scope.mensaje.html("<span><strong>*</strong> Debe ingresar el apellido materno del Alumno.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}   	
		
    	var valido = true; //$scope.validaRut($scope.rut.val());
    	if(!valido){
    		$scope.mensaje.html("<span><strong>*</strong> RUT incorrecto, ingréselo en el formato 11111111-1</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}
    	
    	var validarCorreo = $scope.caracteresCorreoValido($scope.correo.val());
    	if(!validarCorreo){
    		$scope.mensaje.html("<span><strong>*</strong> Correo incorrecto, ingréselo en el formato correcto, Ej: ejemplo@gmail.com</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}   
    	
    	var validarNumero = $scope.menorAlAnhoActual($scope.annoIngresos.val());
    	if(!validarNumero){
    		$scope.mensaje.html("<span><strong>*</strong> El año ingresado no debe ser mayor o igual al año actual.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}      
    	
		if($scope.objetoPrograma === undefined){
    		$scope.mensaje.html("<span><strong>*</strong> Debe seleccionar un prograna.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
    	}else if($scope.objetoPrograma != null && $scope.objetoPrograma.idProgramaUniversidad === 0){
    		$scope.mensaje.html("<span><strong>*</strong> Debe seleccionar un prograna.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;    		
    	}
		if($scope.objetoTipoCertificado === undefined || $scope.objetoTipoCertificado == null){
    		$scope.mensaje.html("<span><strong>*</strong> Debe seleccionar un tipo de certificado.</span>");
    		$scope.mensaje.attr('style','display: block;')
    		return false;
		}
		if($scope.objetoFinalidadCertificado === undefined || $scope.objetoFinalidadCertificado === null){
    		$scope.mensaje.html("<span><strong>*</strong> Debe seleccionar la finalidad del certificado.</span>");
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