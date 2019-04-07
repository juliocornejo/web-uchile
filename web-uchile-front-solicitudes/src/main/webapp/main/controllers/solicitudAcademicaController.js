var solicitudAcademicaApp = angular.module('solicitudAcademica',[]);

solicitudAcademicaApp.controller('SolicitudAcademicaController', [ '$scope', '$http', '$window', '$sce', '$httpParamSerializerJQLike', 
                                                            function($scope, $http, $window, $sce, $httpParamSerializerJQLike) {
	
    $scope.attachedFile = function(element) {
        $scope.$apply(function($scope) {
            $scope.file = element.files[0];   
        });     
        console.log('Archivo Adjunto');
    };
	

	/*variables globales*/
    $scope.tamanoGobal = 15000000;
    $scope.kbOrMb = 1000000;
	$scope.val = null;
	$scope.mensaje;
	$scope.msgPersonal;
	$scope.msgConfirmar;
	$scope.msgGeneral;
	
	
	$scope.ficha;
	$scope.error;
	$scope.selectedPrograma = 'Seleccionar Programa';
	$scope.jsonListaProgramaCtrl; 
	$scope.jsonTipoSolicitudCtrl; 
	$scope.stylePestanna = "border:1px solid #ddd; color: #000; width:auto;";
	
	
	$scope.jsonInformacionSolicitd;
	
	/*objetos de trabajos*/
	$scope.mensajeSeleccion;
	$scope.objetoPrograma;
	$scope.objetoTipoSolicitud;
	$scope.ArchivoSolicitudDTO;
	
	/*datos de la pestaña de personal*/
	$scope.rut;
	$scope.nombre;
	$scope.apellidoPaterno;
	$scope.apellidoMaterno;
	$scope.correo;
	$scope.anho;
	$scope.comentario;

	/*datos de la pestaña de documentos*/
	$scope.archivoCargado;
	$scope.nombreArchivo;
	$scope.tamanoArchivo;
	$scope.mensajeArchivo;
	$scope.botonSubirArchivo;
	
	
	/*botonera del formulario*/
	$scope.botonSiguientePersonal;
	$scope.botonAtrasPersonal;
	
	$scope.botonSiguienteConfirmar;
	$scope.botonAtrasConfirmar;		
	
	/*pestañas*/
	$scope.pestanaPersonal;
    $scope.pestanaConfirmacion;
    
	$scope.liPersonal;
	$scope.liConfirmacion;
	
	$scope.tabPersonal;
	$scope.tabConfirmacion;
	

	/*modal de la pagina*/
	$scope.modalCargando;
	$scope.modalSubir;
	
	/* label de confirmacion*/
	$scope.nombresLabel;
	$scope.apellidoPaternoLabel;
	$scope.apellidoMaternoLabel;
	$scope.programaLabel;
	$scope.rutLabel;
	$scope.comentariosLabel;
	$scope.tipoSolicitudLabel;
	$scope.nombreArchivoLabel;
	
	$scope.parsearSolicitudAcademicaJson = function() {
				
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.ficha = $window.ficha;
		$scope.error = $window.jsonMensajeError;
		$scope.jsonListaProgramaCtrl = $window.jsonListaPrograma;
		$scope.jsonTipoSolicitudCtrl = $window.jsonListaTipoSolicitudes;
		console.log('=================================================================================================================');
		
		if($scope.jsonListaProgramaCtrl !== undefined && $scope.jsonTipoSolicitudCtrl !== undefined){
			console.log('Lista	de Programas');
			$scope.obtenerComponentesFormulario();
		}else{
			console.log('no hay poruebas');
		}
		
		if($scope.error !== undefined && $scope.error.mensajeError !== ""){
    		$scope.mensaje.html("<span><strong>*</strong> " + $scope.error.mensajeError + ".</span>");
    		$scope.mensaje.attr('style','display: block;')
		}
		
		
	};
	
	
	$scope.obtenerComponentesFormulario = function(){
		console.log('============================================ Obtener Componentes Formulario ========================================');
		
		 

	
		$scope.liPersonal = $('li[id=pestana1');
		$scope.liConfirmacion = $('li[id=pestana2');
		
		$scope.pestanaPersonal = $('a[id=pestanaDatosPersonales]');
	    $scope.pestanaConfirmacion = $('a[id=pestanaConfirmacion]');	
	    
		$scope.tabPersonal = $('div[id=personal]');
		$scope.tabConfirmacion = $('div[id=confirmacion]');
		
		$scope.botonSiguientePersonal = $('button[id=siguientePersonal]');
		$scope.botonAtrasPersonal = $('button[id=atrasPersonal]');
		
		
 		$scope.rut = $('input[id=cedulaOrPasaporte]'); 
		$scope.nombre = $('input[id=nombres]');
		$scope.apellidoPaterno  = $('input[id=apellidopaterno]');
		$scope.apellidoMaterno = $('input[id=apellidomaterno]');
		$scope.anho = $('input[id=anho]');
		$scope.correo = $('input[id=correo]');
		$scope.comentario = $('textarea[id=comentario]');
		$scope.msgPersonal = $('div[id=msgPersonal]');
		
	
		/*datos de la pestaña de confirmar*/
		
		$scope.nombresLabel = $('span[id=nombresLabel]');
		$scope.apellidoPaternoLabel = $('span[id=apellidoPaternoLabel]');
		$scope.apellidoMaternoLabel = $('span[id=apellidoMaternoLabel]');
		$scope.programaLabel = $('span[id=programaLabel]');
		$scope.rutLabel = $('span[id=rutLabel]');
		$scope.correoLabel = $('span[id=correoLabel]');
		$scope.anhoIngresoLabel = $('span[id=anhoIngresoLabel]');
		$scope.tipoSolicitudLabel = $('span[id=tipoSolicitudLabel]');
		$scope.fundamentosLabel = $('span[id=fundamentosLabel]');
		$scope.nombreArchivoLabel = $('span[id=archivoLabel]');
		
		$scope.botonSiguienteConfirmar = $('button[id=siguienteConfirmar]');
		$scope.botonAtrasConfirmar = $('button[id=atrasConfirmar]');
		$scope.msgConfirmar = $('div[id=msgConfirmar]');
		$scope.msgGeneral = $('div[id=msgGeneral]');
		
		$scope.modalCargando = $('div[id=cargandoModal');
		$scope.modalSubir = $('div[id=cargandoModalSubir');
		
		$scope.nombreArchivo = $('span[id=nombreArchivo]'); 
		$scope.tamanoArchivo = $('span[id=tamanoArchivo]');
		$scope.mensajeArchivo = $('span[id=mensajeArchivo]');
		$scope.botonSubirArchivo = $('input[id=botonSubirArchivo]');
		if($scope.botonSubirArchivo !== undefined){
			$scope.botonSubirArchivo.hide();
		}
		
		
		console.log('=================================================================================================================');
	};
	
	
	$scope.seleccionDePrograma = function(programa){
		
		if(programa !== undefined && programa.idProgramaUniversidad !== 0){
			$scope.objetoPrograma = programa;
			$scope.selectedPrograma =  programa.nombreProgramaUniversidad;
		}else{
			$scope.objetoPrograma = null;
			$scope.selectedPrograma =  'Seleccionar Programa';
		}
		console.log('=============================================== Seleccion de Programa ===========================================');
		console.log(programa);
		console.log('=================================================================================================================');
	}
	
	$scope.seleccionTipoSolicitud = function(tipoSolicitud){
		
		if(tipoSolicitud !== undefined){
			$scope.objetoTipoSolicitud = tipoSolicitud;
		}
		console.log('=============================================== Seleccion de Certificado ===========================================');
		console.log($scope.objetoTipoSolicitud);
		console.log('=================================================================================================================');
	}	
	
	
	
	$scope.siguienteFormulario = function(tabPestana){
		console.log('===================================== Obtener Data Pasar Siguiente Pestaña ========================================');
		if(tabPestana !== undefined ) {
			console.log("pestaña seleccionada : "+ tabPestana);
			if(tabPestana === 'personal'){
	    		$scope.activarPestannaPersonal();
	    		$scope.desactivarPestannaConfirmar();
				$scope.limpiarMensajeGeneral();
				$scope.limpiarMensajePestannaPersonal();
	    		return true;
			}else if(tabPestana === 'confirmar'){
				var formacion = $scope.validarDataPersonal();
				if(!formacion){
					return false;
				}else{
					/*si todo salio bien avanzamos a la pestaña datos formaacion*/
		    		$scope.desactivarPestannaPersonal();
					$scope.activarPestannaConfirmar();
					$scope.setearValoresConfirmacion();		
					$scope.limpiarMensajeGeneral();
					$scope.limpiarMensajePestannaConfirmar();
					return true;
				}
			}else{
	    		$scope.mensaje.html("<span><strong>*</strong> Problema con el sistema de interno.</span>");
	    		$scope.mensaje.attr('style','display: block;')				
			}
		}else{
    		$scope.mensaje.html("<span><strong>*</strong> Problema con el sistema de interno.</span>");
    		$scope.mensaje.attr('style','display: block;')
		}
		
		console.log('=================================================================================================================');
	};
	
	
	$scope.validarDataPersonal = function (){
		
		console.log('============================ verificacion de la informacion ingresada =================================================');

    	var validoNombre = $scope.caracteresTexto($scope.nombre.val());
    	if(!validoNombre){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el nombre del Alumno.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');
    		return false;
    	}		
    	var validoPaterno = $scope.caracteresTexto($scope.apellidoPaterno.val());
    	if(!validoPaterno){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el apellido paterno del Alumno.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');

    		return false;
    	}
    	
    	var validoMaterno = $scope.caracteresTexto($scope.apellidoMaterno.val());
    	if(!validoMaterno){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el apellido materno del Alumno.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');

    		return false;
    	}   
    	
    	//var validoRut = $scope.validaRut($scope.rut.val());
    	var valido = true; //$scope.validaRut($scope.rut.val());
    	if(!valido){
    		$scope.msgPersonal.html("<span><strong>*</strong> RUT o Pasaporte está incorrecto.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');
    		return false;
    	}
    	
		if($scope.objetoPrograma === undefined){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe seleccionar un prograna.</span>");
    		$scope.msgPersonal.attr('style','display: block;');
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');

    		return false;
    	}

    	var validarCorreo = $scope.caracteresCorreoValido($scope.correo.val());
    	if(!validarCorreo){
    		$scope.msgPersonal.html("<span><strong>*</strong> Correo incorrecto, ingréselo en el formato correcto, Ej: ejemplo@gmail.com</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');

    		return false;
    	} 
   	
    	var anhoOcupacion = $scope.menorAlAnhoActual($scope.anho.val());
    	if(!anhoOcupacion){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el año de ingreso.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');

    		return false;
    	} 

		if($scope.objetoTipoSolicitud == undefined){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe seleccionar un tipo de solicitud.</span>");
    		$scope.msgPersonal.attr('style','display: block;');
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');

    		return false;
    	} 
    	
    	var comentario = $scope.caracteresTexto($scope.comentario.val());
    	if(!comentario){
    		
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar un comentario o fundamental la solicitud.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		$scope.msgPersonal.removeClass('alert-success');  
			$scope.msgPersonal.addClass('alert-danger');
    		return false;
    	}else{
    		var verificacionTexto = $scope.extensionMensaje($scope.comentario.val());
    		if(!verificacionTexto){
    			$scope.comentario.val().substring(0, 899);
        		$scope.msgPersonal.html("<span><strong>*</strong> El fundamento no debe sobrepasar los 850 caracteres.</span>");
        		$scope.msgPersonal.attr('style','display: block;')
        		return false;    			
    		}
    	}   

		var documento = $scope.validarDataArchivo();
		if(documento){
			$('input[id=archivo3]').prop('checked',false); 
    	}else{
    		$('input[id=archivo3]').prop('checked',true);
    	} 
    	
    	$scope.msgPersonal.html("");
		$scope.msgPersonal.attr('style','display: none;')
		console.log('======================================================================================================================');
		return true;
	}	
	
	$scope.extensionMensaje = function(comentario){ 
		var comentarioAprobado = false;
        var totalMensaje = comentario.length - $scope.nEspacios(comentario); 
        if (totalMensaje < 851) {     
        	comentarioAprobado = true;
        }  
        return comentarioAprobado;
	} 
	
	$scope.nEspacios = function(dato){ 
		var contador = 0; 
		for (var i = 0; i < dato.length; i ++){
			contador += (dato.charAt(i) == " ") ? 1:0 
		}  
		return contador; 
	} 	

	$scope.validarDataArchivo = function() {
		var file = $('#archivo1').prop("files")[0];
		console.log('=============================================== setarValores del Archivo ===========================================');
		if(file === null || file === undefined){
    		return false;
		}else{
			console.log('======================================================================================================================');
			return true;			
		}
	
	} 	
	
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
	
	$scope.validaRut= function(dato){
		 var vacio = true;
		 console.log('=============================================== validar rut ===========================================');
		 if(dato === undefined || dato === null || dato === ''){
			 vacio = false;
		 }
		 console.log('======================================================================================================================');
	   return vacio;
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
	
	$(function(){
        $("#formuploadajax").on("submit", function(e){
            e.preventDefault();
            $scope.modalSubir.modal("show");
            var f = $(this);
            var formData = new FormData();
            var file = $('#archivo1').prop("files")[0];
            formData.append("file", file);
            var url = '/web-uchile-front-solicitudes/rest/SolicitudAcademicaService/subirArchivo';
            
            $.ajax({
		        url: url,
		        type: 'POST',
		        dataType : 'json',
		        data: formData,
		        cache: false,
		        contentType: false,
		        processData: false,
		        success: function (data) {
		        	if(data !== undefined){
		        		console.log(data);
		        		if(response.data !== undefined && response.data.ok == true){
		        			$scope.ArchivoSolicitudDTO =  $.parseJSON(data.tiempoRespuesta);
		        			console.log($scope.ArchivoSolicitudDTO);
							$scope.msgPersonal.removeClass('alert-danger');  
							$scope.msgPersonal.addClass('alert-success');
			        		$scope.msgPersonal.html("<span><strong>Succesful </strong> el archivo " + $scope.ArchivoSolicitudDTO.nombreArchivoSolicitud + " ha sido añadido a la postulación.</span>");
			        		$scope.msgPersonal.attr('style','display: block;');
			        		$scope.modalSubir.modal("hide");
			        		$scope.botonSubirArchivo.hide();
			        		return true;
		        		}else{
			        		$scope.msgPersonal.html("<span><strong>*</strong> Se produjo un error de digitación, espere un momento, gracias por su comprensión.</span>");
			        		$scope.msgPersonal.attr('style','display: block;');
			        		$scope.modalSubir.modal("hide");
			        		return false;		        			
		        		}
		        	}else{
		        		$scope.msgPersonal.html("<span><strong>*</strong> Se produjo un error de digitación, espere un momento, gracias por su comprensión.</span>");
		        		$scope.msgPersonal.attr('style','display: block;');
		        		$scope.modalSubir.modal("hide");
		        		return false;
		        	}
		        },
		        error:function(data) {
	        		$scope.msgPersonal.html("<span><strong>*</strong>Error interno del sistema.</span>");
	        		$scope.msgPersonal.attr('style','display: block;');
	        		$scope.modalSubir.modal("hide");
	        		return false;
		        }
		    });         
        });
    });
	 
	$("#archivo1").change(function(){
		$scope.setearParametosArchivos();
	});

	$scope.setearParametosArchivos = function() {
		var file = $('#archivo1').prop("files")[0];
		var kbitOrMbit = "Kb";
		console.log('=============================================== setarValores del Archivo ===========================================');
		if(file !== null && file !== undefined){
			console.log(file);
			var valor = parseInt(file.size / 1024);
			if(file.size > $scope.kbOrMb){
				kbitOrMbit = "Mb";
			}
			$scope.nombreArchivo.html("Nombre : <strong>"+file.name +"</strong>");
			$scope.tamanoArchivo.html("Tamaño : <strong>"+ valor + " - "+ kbitOrMbit+"</strong>");
			console.log("tamano global "+ $scope.tamanoGobal);
			if(file.size < $scope.tamanoGobal){
				$scope.mensajeArchivo.html('');
				$scope.botonSubirArchivo.show();
				$scope.limpiarMensajePestannaPersonal();
			}else{
				$scope.mensajeArchivo.html("<strong> El archivo no debe superar los 20Mb </strong>");
				$scope.botonSubirArchivo.hide();
			}
			
		}
		console.log('====================================================================================================================');
	}
		
	$scope.almacenarSolicitudCertificadoPagoOffline = function(){
		
		console.log('=========================== almacenar Solicitud Certificado Pago Off line ==========================================');
	    	
    	$scope.modalCargando.modal("show");

    	$scope.jsonSolicitidAcademica =  new Object();
    	$scope.jsonSolicitidAcademica.nombrePersonaSolicitudAcademica = $scope.nombre.val();
    	$scope.jsonSolicitidAcademica.apellidoPaternoPersonaSolicitudAcademica = $scope.apellidoPaterno.val();
    	$scope.jsonSolicitidAcademica.apellidoMaternoPersonaSolicitudAcademica = $scope.apellidoMaterno.val();
    	$scope.jsonSolicitidAcademica.rutPersonaSolicitudAcademica = $scope.rut.val();
    	$scope.jsonSolicitidAcademica.idProgramaUniversidad = $scope.objetoPrograma.idProgramaUniversidad;
    	$scope.jsonSolicitidAcademica.programaUniversidad = $scope.objetoPrograma.nombreProgramaUniversidad;
    	$scope.jsonSolicitidAcademica.mailMember = $scope.correo.val();
    	$scope.jsonSolicitidAcademica.anhoIngreso = $scope.anho.val();
    	$scope.jsonSolicitidAcademica.idTipoSolicitud = $scope.objetoTipoSolicitud.idTipoSolicitud;
    	$scope.jsonSolicitidAcademica.tipoSolicitud = $scope.objetoTipoSolicitud.nombreTipoSolicitud; 
    	$scope.jsonSolicitidAcademica.fundamentacionSolicitud = $scope.comentario.val();
		var documento = $scope.validarDataArchivo();
		if(documento){
		 	$scope.jsonSolicitidAcademica.archivoAdjunto = true;
	    	$scope.jsonSolicitidAcademica.nombreArchivo = $scope.ArchivoSolicitudDTO.nombreArchivoSolicitud;
	    	$scope.jsonSolicitidAcademica.idArchivoSolicitud = $scope.ArchivoSolicitudDTO.idArchivoSolicitud;
    	}else{
    	 	$scope.jsonSolicitidAcademica.archivoAdjunto = false;
        	$scope.jsonSolicitidAcademica.nombreArchivo = "";
        	$scope.jsonSolicitidAcademica.idArchivoSolicitud = 0;
    	} 
    	$scope.jsonSolicitidAcademica.programaUniversidadDTO = $scope.objetoPrograma;
    	$scope.jsonSolicitidAcademica.tipoSolicitudDTO = $scope.objetoTipoSolicitud;
    	$scope.jsonSolicitidAcademica.archivo = $scope.ArchivoSolicitudDTO;
    	
    	var data = $.param({
    		requestJson: JSON.stringify($scope.jsonSolicitidAcademica),
    		requestFicha: JSON.stringify($scope.ficha)
    		//requestJson: '{"idProgramaUniversidadPostulacion":51,"programaPostulacionUniversidad":"Magister en Gestión Cultural (2019)","costoProgramaUniversidad":"$50.000","tituloVersionSemestral":"Un Semestre","rutPersonaSolicitudPostulacion":"ertyuio","nombrePersonaSolicitudPostulacion":"ertyuio","apellidoPaternoPersonaSolicitudPostulacion":"rtyuiop","apellidoMaternoPersonaSolicitudPostulacion":"rtyuiop","fechaNacimiento":"2345678","nacionalidad":"","fonoContacto":"","celularContacto":"","mailMember":"EXT_JDAMUNOZ@FALABELLA.CL","domicilio":"","paisDomicilio":"chile","nombreRegion":"","idComunaDomicilio":0,"nombreComuna":"","ciudadDomicilio":"","tituloProfesional":"","entidadEducacional":"","paisEntidadEducacional":"wertyuio","anhoObtencionEntidadEducacional":"2017","ocupacionActual":"wertyuiop","interesPrograma":"","fuenteFinancimiamiento":"","idArchivoSolicitud":1051,"nombreArchivoSolicitud":"\"ARQ-AmbienteLocal-200818-1351.zip\"","programa":{"idProgramaUniversidadPostulacion":51,"codigoProgramaUniversidadPostulacion":"MAG_GC_2019","nombreProgramaUniversidadPostulacion":"Magister en Gestión Cultural (2019)","duracionProgramaUniversidadPostulacion":"Un Semestre","costoProgramaUniversidadPostulacion":"$50.000","clasificacionProgramaPostulacion":2,"prioridad":0}}'
        });
    
        var config = {
            headers : {
            	'Content-Type': 'application/json;',
                'Accept-Encoding' : 'gzip'
            }
        };

        $http.post('/web-uchile-front-solicitudes/rest/SolicitudAcademicaService/almacenarSolicitudAcademicaPagoOffline', data, config)
        .then(
        	function (response) {
        		if(response.data !== undefined && response.data.ok == true){
        			var url = $window.origin +'/'+ response.data.url;
        			$window.location.href = url;
        			$scope.modalCargando.modal("hide");
        		}else{
        			$scope.modalCargando.modal("hide");
        		}
            }
        );
        
        console.log('====================================================================================================================');
	  }
		
	$scope.setearValoresConfirmacion = function(){
		console.log('=============================================== validar rut ========================================================');
			$scope.nombresLabel.text($scope.nombre.val());
			$scope.apellidoPaternoLabel.text($scope.apellidoPaterno.val());
			$scope.apellidoMaternoLabel.text($scope.apellidoMaterno.val());
			$scope.programaLabel.text($scope.objetoPrograma.nombreProgramaUniversidad);
			$scope.rutLabel.text($scope.rut.val());
			$scope.correoLabel.text($scope.correo.val());
			$scope.anhoIngresoLabel.text($scope.anho.val());
			$scope.tipoSolicitudLabel.text($scope.objetoTipoSolicitud.nombreTipoSolicitud);  
			$scope.fundamentosLabel.text($scope.comentario.val());
			$scope.nombreArchivoLabel.text($scope.ArchivoSolicitudDTO.nombreArchivoSolicitud);
		console.log('====================================================================================================================');
    }	
	
	$scope.siguienteFormularioPestana = function(tabPestana){
		console.log('===================================== Obtener Data Pasar Siguiente Pestaña ========================================');

		if(tabPestana !== undefined ) {
			console.log("pestaña seleccionada : "+ tabPestana);
			if(tabPestana === 'personal'){
	    		$scope.desactivarPestannaPersonal();
	    		$scope.activarPestannaConfirmar();
//				$scope.limpiarMensajeGeneral();
				$scope.limpiarMensajePestannaPersonal();
				$scope.limpiarMensajeGeneral();
	    		return true;				
			}else if(tabPestana === 'confirmar'){
				var formacion = $scope.validarDataPersonal();
				if(!formacion){
					return false;
				}else{
					/*si todo salio bien avanzamos a la pestaña datos formaacion*/
		    		$scope.desactivarPestannaPersonal();
					$scope.activarPestannaConfirmar();
					$scope.setearValoresConfirmacion();		
					$scope.limpiarMensajeGeneral();
					$scope.limpiarMensajePestannaConfirmar();
					return true;
				}
			}else{
				$scope.msgGeneral.html("<span><strong>*</strong> Problema con el sistema de interno.</span>");
				$scope.msgGeneral.attr('style','display: block;')				
			}
		}else{
			$scope.msgGeneral.html("<span><strong>*</strong> Problema con el sistema de interno.</span>");
			$scope.msgGeneral.attr('style','display: block;')
		}
		
		console.log('=================================================================================================================');
	};
	
	

	$scope.activarPestannaPersonal = function (){
		$scope.pestanaPersonal.addClass('boton-activo');
		$scope.pestanaPersonal.removeClass('boton-inactivo');
		$scope.pestanaPersonal.attr('style','border:1px solid #fcefa1; color: #000; width:auto;');
		$scope.tabPersonal.addClass('in');
		$scope.tabPersonal.addClass('active');
		$scope.liPersonal.addClass('active'); 
	}
	$scope.desactivarPestannaPersonal = function (){
		$scope.liPersonal.removeClass('active');  
		$scope.pestanaPersonal.addClass('boton-inactivo');
		$scope.pestanaPersonal.removeClass('boton-activo');
		$scope.pestanaPersonal.attr('style','border:1px solid #ddd; color: #000; width:auto;');
		$scope.tabPersonal.removeClass('in'); 
		$scope.tabPersonal.removeClass('active'); 	
	}	
	
	$scope.activarPestannaConfirmar = function (){
		$scope.liConfirmacion.addClass('active'); 
		$scope.pestanaConfirmacion.addClass('boton-activo');
		$scope.pestanaConfirmacion.removeClass('boton-inactivo');
		$scope.pestanaConfirmacion.attr('style','border:1px solid #fcefa1; color: #000; width:auto;');
		$scope.tabConfirmacion.addClass('in');
		$scope.tabConfirmacion.addClass('active');	
		
	}
	$scope.desactivarPestannaConfirmar = function (){
		$scope.liConfirmacion.removeClass('active');  
		$scope.pestanaConfirmacion.addClass('boton-inactivo');
		$scope.pestanaConfirmacion.removeClass('boton-activo');
		$scope.pestanaConfirmacion.attr('style','border:1px solid #ddd; color: #000; width:auto;');
		$scope.tabConfirmacion.removeClass('in'); 
		$scope.tabConfirmacion.removeClass('active'); 
	}	
	$scope.limpiarMensajePestannaPersonal = function (){
		$scope.msgPersonal.html("");
		$scope.msgPersonal.attr('style','display: none;')
	}

	$scope.limpiarMensajePestannaConfirmar = function (){
		$scope.msgConfirmar.html("");
		$scope.msgConfirmar.attr('style','display: none;')
	}	
	
	$scope.limpiarMensajeGeneral = function (){
		$scope.msgGeneral.html("");
		$scope.msgGeneral.attr('style','display: none;');
	}
	
	
	$scope.limpiarFormulario= function(){
		console.log('=============================================== Limpiar Formulario  ===========================================');
 		$scope.rut.val(''); 
		$scope.nombre.val('');
		$scope.apellidoPaterno.val('');  
		$scope.apellidoMaterno.val(''); 
		$scope.anho.val(''); 
		$scope.correo.val('');
		$scope.comentario.val(''); 

			
		/*datos de la pestaña de confirmar*/
		
		$scope.nombresLabel.val(''); 
		$scope.apellidoPaternoLabel.val(''); 
		$scope.apellidoMaternoLabel.val('');
		$scope.programaLabel.val(''); 
		$scope.rutLabel.val(''); 
		$scope.correoLabel.val('');
		$scope.anhoIngresoLabel.val(''); 
		$scope.tipoSolicitudLabel.val(''); 
		$scope.fundamentosLabel.val(''); 
		$scope.nombreArchivoLabel.val(''); 
		
		
		var documento = $scope.validarDataArchivo();
		if(documento){
			$scope.archivoCargado = $('#archivo1');
			if($scope.archivoCargado != null && $scope.archivoCargado.val() != null){
				$scope.archivoCargado.val('');
				$('input[id=archivo3]').prop('checked',false);
			}
    	}
		

		$scope.nombreArchivo.text(''); 
		$scope.tamanoArchivo.text(''); 
		
		$scope.botonSubirArchivo = $('input[id=botonSubirArchivo]');
		if($scope.botonSubirArchivo !== undefined){
			$scope.botonSubirArchivo.hide();
		}
		
		$scope.ArchivoSolicitudDTO = null;
		$scope.objetoPrograma = null;
		$scope.selectedPrograma =  'Seleccionar Programa';

		if($scope.objetoTipoSolicitud !== undefined && $scope.objetoTipoSolicitud != null && $scope.objetoTipoSolicitud.idTipoSolicitud != 0){
			$('input[id='+ $scope.objetoTipoSolicitud.idTipoSolicitud +']').val('');
			$('input[id='+ $scope.objetoTipoSolicitud.idTipoSolicitud +']').removeAttr("checked");
		}
		$scope.limpiarMensajeGeneral();
		$scope.limpiarMensajePestannaConfirmar();
		$scope.limpiarMensajePestannaPersonal();
	
		console.log('======================================================================================================================');
	};

	 var fecha = $('#datetimepicker1').datetimepicker({
        weekStart: 1,
        format: 'dd-mm-yyyy',
        language: 'es'
     }).on('changeDate', function(ev) {
        var newDate = new Date(ev.date)
        console.log(newDate.getDate()); 
        fecha.hide()
     }).data('datetimepicker');
    
	
	
	
}]);