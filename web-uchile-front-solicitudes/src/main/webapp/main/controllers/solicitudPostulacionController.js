var solicitudPostulacionApp = angular.module('solicitudPostulaciones',[]);

solicitudPostulacionApp.controller('SolicitudPostulacionController', [ '$scope', '$http', '$window', '$sce', '$httpParamSerializerJQLike', 
                                                            function($scope, $http, $window, $sce, $httpParamSerializerJQLike) {
	
    $scope.attachedFile = function(element) {
        $scope.$apply(function($scope) {
            $scope.file = element.files[0];   
        });     
        console.log('file attached');
    };
	

	/*variables globales*/
    $scope.tamanoGobal = 20000000;
    $scope.kbOrMb = 1000000;
	$scope.val = null;
	$scope.mensaje;
	$scope.msgPrograma;
	$scope.msgPersonal;
	$scope.msgFormacion;
	$scope.msgOtro;
	$scope.msgDocumento;
	$scope.msgConfirmar;
	$scope.msgGeneral;
	
	
	
	$scope.error;
	$scope.ficha;
	$scope.selectedPrograma = 'Seleccionar Programa';
	$scope.jsonListaProgramaCtrl; 
	$scope.jsonRegionesCtrl; 
	$scope.stylePestanna = "border:1px solid #ddd; color: #000; width:auto;";
	
	
	$scope.jsonListaFinalidadCertificadoCtrl; 
	$scope.jsonInformacionSolicitd;
	
	/*objetos de trabajos*/
	$scope.tdImagen;
	$scope.mensajeSeleccion;
	$scope.objetoPrograma;
	$scope.ArchivoSolicitudDTO;
	
	/*datos de la pestaña de personal*/
	$scope.rut;
	$scope.nombre;
	$scope.apellidoPaterno;
	$scope.apellidoMaterno;
	$scope.fechaNacimiento;
	$scope.nacionalidad;
	$scope.fonoContacto;
	$scope.fonoMovil;
	$scope.correo;
	$scope.pais;
	$scope.region;
	$scope.comuna;
	$scope.ciudad;
	$scope.domicilio;

	/*datos de la pestaña de formación*/
	$scope.tituloOrGrado;
	$scope.casaEstudio;
	$scope.direccionCasaEstudio;
	$scope.anhoTitulacion;
	$scope.anhoOcupacion;

	/*datos de la pestaña de otro*/
	$scope.enteroPrograma;
	$scope.financiamineto;
	$scope.comentario;

	
	/*datos de la pestaña de documentos*/
	$scope.nombreArchivo;
	$scope.tamanoArchivo;
	$scope.mensajeArchivo;
	$scope.botonSubirArchivo;
	
	
	/*botonera del formulario*/
	$scope.botonSiguientePrograma;
	
	$scope.botonSiguientePersonal;
	$scope.botonAtrasPersonal;
	
	$scope.botonSiguienteFormacion;
	$scope.botonAtrasFormacion;	

	$scope.botonSiguienteOtro;
	$scope.botonAtrasOtro;	

	$scope.botonSiguienteDocumento;
	$scope.botonAtrasDocumento;		

	$scope.botonSiguienteConfirmar;
	$scope.botonAtrasConfirmar;		
	
	/*pestañas*/
	$scope.pestanaPrograma;
	$scope.pestanaPersonal;
    $scope.pestanaFormacion;
    $scope.pestanaOtros;
    $scope.pestanaDocumento;
    $scope.pestanaConfirmacion;
    
	$scope.liPrograma;
	$scope.liPersonal;
	$scope.liFormacion;
	$scope.liOtros;
	$scope.liDocumento;
	$scope.liConfirmacion;
	
	$scope.tabPrograma;
	$scope.tabPersonal;
	$scope.tabFormacion;
	$scope.tabOtros;
	$scope.tabDocumento;
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
	$scope.fechaNacimientoLabel;
	$scope.nacionalidadLabel;
	$scope.fonoContactoLabel;
	$scope.fonoMovilLabel;
	$scope.correoLabel;
	$scope.paisLabel;
	$scope.ciudadLabel;
	$scope.domicilioLabel;
	$scope.tituloGradoLabel;
	$scope.casaEstudioLabel;
	$scope.direccionCasaEstudioLabel;
	$scope.anhoTitulacionLabel;
	$scope.ocupacionLabel;
	$scope.enteroProgramaLabel;
	$scope.financiamientoLabel;
	$scope.comentariosLabel;
	$scope.nombreArchivoLabel;
	
	
	
	$scope.parsearSolicitudPostulacionesJson = function() {
				
		console.log('=============================================== Inicializando Data Certificados ===========================================');
		$scope.ficha = $window.ficha;
		$scope.error = $window.jsonMensajeError;
		$scope.jsonListaProgramaCtrl = $window.jsonListaPrograma;
		$scope.jsonRegionesCtrl = $window.jsonListaRegiones;
		console.log('=================================================================================================================');
		
		if($scope.jsonListaProgramaCtrl !== undefined){
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
		
		 
		$scope.botonSiguientePrograma = $('button[id=siguientePrograma]');
		if($scope.botonSiguientePrograma !== undefined){
			$scope.botonSiguientePrograma.hide();
		}
		$scope.tdImagen = $('td[id=imagen]');
		$scope.mensajeSeleccion = $('span[id=mensajeSeleccion]'); 
		$scope.msgPrograma = $('div[id=msgPrograma');
		
		$scope.liPrograma = $('li[id=pestana1');
		$scope.liPersonal = $('li[id=pestana2');
		$scope.liFormacion = $('li[id=pestana3');
		$scope.liOtros = $('li[id=pestana4');
		$scope.liDocumento = $('li[id=pestana5');
		$scope.liConfirmacion = $('li[id=pestana6');
		
		$scope.pestanaPrograma = $('a[id=pestanaPrograma]');
		$scope.pestanaPersonal = $('a[id=pestanaDatosPersonales]');
	    $scope.pestanaFormacion = $('a[id=pestanaFormacion]');
	    $scope.pestanaOtros = $('a[id=pestanaOtros]');
	    $scope.pestanaDocumento = $('a[id=pestanaDocumentos]');
	    $scope.pestanaConfirmacion = $('a[id=pestanaConfirmacion]');	
	    
		$scope.tabPrograma =  $('div[id=programa]');
		$scope.tabPersonal = $('div[id=datos_personal]');
		$scope.tabFormacion = $('div[id=formacion]');
		$scope.tabOtros = $('div[id=otro]');
		$scope.tabDocumento = $('div[id=documentos]');
		$scope.tabConfirmacion = $('div[id=confirmacion]');
		
		
		$scope.botonSiguientePersonal = $('button[id=atrasPersonal]');
		$scope.botonAtrasPersonal = $('button[id=siguientePersonal]');
		
		
 		$scope.rut = $('input[id=cedulaOrPasaporte]'); 
		$scope.nombre = $('input[id=nombres]');
		$scope.apellidoPaterno  = $('input[id=apellidopaterno]');
		$scope.apellidoMaterno = $('input[id=apellidomaterno]');
		$scope.fechaNacimiento = $('input[id=fechaNacimiento]');
		$scope.nacionalidad = $('input[id=nacionalidad]');
		$scope.fonoContacto = $('input[id=fono]');
		$scope.fonoMovil = $('input[id=movil]');
		$scope.correo = $('input[id=correo]');
		$scope.pais = $('input[id=residencia]');
		$scope.region = $('input[id=region]');
		$scope.comuna = $('input[id=comuna]');
		$scope.ciudad = $('input[id=ciudad]');
		$scope.domicilio = $('input[id=domicilio]');
		$scope.msgPersonal = $('div[id=msgPersonal]');
		
		
		/*datos de la pestaña de formación*/
		$scope.tituloOrGrado = $('input[id=tituloOrGrado]');
		$scope.casaEstudio = $('input[id=casaEstudio]');
		$scope.direccionCasaEstudio = $('input[id=direccionCasaEstudio]');
		$scope.anhoTitulacion = $('input[id=anhoTitulacion]');
		$scope.anhoOcupacion = $('input[id=anhoOcupacion]');	
		$scope.botonSiguienteFormacion = $('button[id=siguienteFormacion]');
		$scope.botonAtrasFormacion = $('button[id=atrasFormacion]');	
		$scope.msgFormacion = $('div[id=msgFormacion]');

		
		
		/*datos de la pestaña de Otros*/
		$scope.enteroPrograma = $('input[id=enteroPrograma]');
		$scope.financiamineto = $('input[id=financiamineto]');
		$scope.comentario = $('textarea[id=comentario]');
		$scope.msgOtro = $('div[id=msgOtro]');
		$scope.botonSiguienteOtro = $('button[id=siguienteOtro]');
		$scope.botonAtrasOtro = $('button[id=atrasOtro]');	
		

		
		/*datos de la pestaña de documentos*/
		$scope.nombreArchivo = $('span[id=nombreArchivo]'); 
		$scope.tamanoArchivo = $('span[id=tamanoArchivo]');
		$scope.mensajeArchivo = $('span[id=mensajeArchivo]');
		$scope.botonSubirArchivo = $('input[id=botonSubirArchivo]');
		$scope.botonSubirArchivo.hide();
		$scope.msgDocumento = $('div[id=msgDocumento]');
		$scope.botonSiguienteDocumento = $('button[id=siguienteDocumento]');
		$scope.botonAtrasDocumento = $('button[id=atrasDocumento]');		
		
		/*datos de la pestaña de confirmar*/
		
		$scope.nombresLabel = $('span[id=nombresLabel]');
		$scope.apellidoPaternoLabel = $('span[id=apellidoPaternoLabel]');
		$scope.apellidoMaternoLabel = $('span[id=apellidoMaternoLabel]');
		$scope.programaLabel = $('span[id=programaLabel]');
		$scope.rutLabel = $('span[id=rutLabel]');
		$scope.fechaNacimientoLabel = $('span[id=fechaNacimientoLabel]');
		$scope.nacionalidadLabel = $('span[id=nacionalidadLabel]');
		$scope.fonoContactoLabel = $('span[id=fonoContactoLabel]');
		$scope.fonoMovilLabel = $('span[id=fonoMovilLabel]');
		$scope.correoLabel = $('span[id=correoLabel]');
		$scope.paisLabel = $('span[id=paisLabel]');
		$scope.ciudadLabel = $('span[id=ciudadLabel]');
		$scope.domicilioLabel = $('span[id=domicilioLabel]');
		$scope.tituloGradoLabel = $('span[id=tituloGradoLabel]');
		$scope.casaEstudioLabel = $('span[id=casaEstudioLabel]');
		$scope.direccionCasaEstudioLabel = $('span[id=direccionCasaEstudioLabel]');
		$scope.anhoTitulacionLabel = $('span[id=anhoTitulacionLabel]');
		$scope.ocupacionLabel = $('span[id=ocupacionLabel]');
		$scope.enteroProgramaLabel = $('span[id=enteroProgramaLabel]');
		$scope.financiamientoLabel = $('span[id=financiamientoLabel]');
		$scope.comentariosLabel = $('span[id=comentariosLabel]');
		$scope.nombreArchivoLabel = $('span[id=nombreArchivoLabel]');
		$scope.botonSiguienteConfirmar = $('button[id=siguienteConfirmar]');
		$scope.botonAtrasConfirmar = $('button[id=atrasConfirmar]');
		$scope.msgConfirmar = $('div[id=msgConfirmar]');
		$scope.msgGeneral = $('div[id=msgGeneral]');;
		
		
		$scope.modalCargando = $('div[id=cargandoModal');
		$scope.modalSubir = $('div[id=cargandoModalSubir');
		
		console.log('=================================================================================================================');
	};
	
	
	$scope.seleccionDePrograma = function(programaPostulacion){
		
		if(programaPostulacion !== undefined && programaPostulacion.idProgramaUniversidadPostulacion !== 0){
			$scope.objetoPrograma = programaPostulacion;
			$scope.selectedPrograma =  programaPostulacion.nombreProgramaUniversidadPostulacion;
			$scope.tdImagen.attr('style','display: display;');
			
			$scope.mensajeSeleccion.html("El valor del arancel de inscripción del programa de "+ 
										programaPostulacion.nombreProgramaUniversidadPostulacion + 
										" es de "+ programaPostulacion.costoProgramaUniversidadPostulacion +
										" pesos");
			
			$scope.botonSiguientePrograma.show();
		}else{
			$scope.objetoPrograma = null;
			$scope.selectedPrograma =  'Seleccionar Programa';
			$scope.tdImagen.attr('style','display: none;');
			$scope.mensajeSeleccion.html("");
			$scope.botonSiguientePrograma.hide();
		}
		console.log('=============================================== Seleccion de Programa ===========================================');
		console.log(programaPostulacion);
		console.log('=================================================================================================================');
	};
	
	$scope.siguienteFormulario = function(tabPestana){
		console.log('===================================== Obtener Data Pasar Siguiente Pestaña ========================================');

		if(tabPestana !== undefined ) {
			console.log("pestaña seleccionada : "+ tabPestana);
			if(tabPestana === 'programa'){
				$scope.desactivarPestannaPersonal();
				$scope.desactivarPestannaFormacion();
				$scope.desactivarPestannaOtro(); 
				$scope.desactivarPestannaDocumento(); 
				$scope.desactivarPestannaConfirmar();
				$scope.activarPestannaPrograma();
				$scope.$scope.limpiarMensajePestannaPrograma();
				
			}else if(tabPestana === 'personal'){
				if($scope.objetoPrograma === undefined){
		    		$scope.msgPrograma.html("<span><strong>*</strong> Debe seleccionar un prograna.</span>");
		    		$scope.msgPrograma.attr('style','display: block;');
		    		return false;
		    	} else{
					/*si todo salio bien avanzamos a la pestaña datos personales*/
					$scope.desactivarPestannaPrograma();
		    		$scope.activarPestannaPersonal();
					$scope.desactivarPestannaFormacion();
					$scope.desactivarPestannaOtro(); 
					$scope.desactivarPestannaDocumento(); 
					$scope.desactivarPestannaConfirmar();
					$scope.limpiarMensajeGeneral();
					$scope.limpiarMensajePestannaPersonal();
					return true;
		    	}
			}else if(tabPestana === 'formacion'){
				if($scope.objetoPrograma === undefined){
		    		$scope.msgPersonal.html("<span><strong>*</strong> Debe seleccionar un prograna.</span>");
		    		$scope.msgPersonal.attr('style','display: block;');
		    		return false;
		    	} else{
					var formacion = $scope.validarDataPersonal();
					if(!formacion){
						return false;
					}else{
						/*si todo salio bien avanzamos a la pestaña datos formaacion*/
						$scope.desactivarPestannaPrograma();
			    		$scope.desactivarPestannaPersonal();
						$scope.activarPestannaFormacion();
						$scope.desactivarPestannaOtro(); 
						$scope.desactivarPestannaDocumento(); 
						$scope.desactivarPestannaConfirmar();
						$scope.limpiarMensajeGeneral();
						$scope.limpiarMensajePestannaFormacion();
						return true;
					}
		    	}
			}else if(tabPestana === 'otro'){
				if($scope.objetoPrograma === undefined){
		    		$scope.msgFormacion.html("<span><strong>*</strong> Debe seleccionar un prograna.</span>");
		    		$scope.msgFormacion.attr('style','display: block;');
		    		return false;
		    	} else{
					var dataPersonal = $scope.validarDataPersonal();
					if(!dataPersonal){
			    		$scope.msgFormacion.html("<span><strong>*</strong> faltan agregar datos en la pestaña de Datos Personales.</span>");
			    		$scope.msgFormacion.attr('style','display: block;');
			    		return false;
					}else{
						var otro = $scope.validarDataFormacion();
						if(!otro){
							return false;
						}else{
							/*si todo salio bien avanzamos a la pestaña datos otros*/
							$scope.desactivarPestannaPrograma();
				    		$scope.desactivarPestannaPersonal();
							$scope.desactivarPestannaFormacion();
							$scope.activarPestannaOtro(); 
							$scope.desactivarPestannaDocumento(); 
							$scope.desactivarPestannaConfirmar();
							$scope.limpiarMensajeGeneral();
							$scope.limpiarMensajePestannaOtro();
							return true;
						}
					}
		    	}
			}else if(tabPestana === 'documento'){
				if($scope.objetoPrograma === undefined){
		    		$scope.msgOtro.html("<span><strong>*</strong> Debe seleccionar un prograna.</span>");
		    		$scope.msgOtro.attr('style','display: block;');
		    		return false;
		    	} else{
					var dataPersonal = $scope.validarDataPersonal();
					if(!dataPersonal){
			    		$scope.msgOtro.html("<span><strong>*</strong> faltan agregar datos en la pestaña de Datos Personales.</span>");
			    		$scope.msgOtro.attr('style','display: block;');
			    		return false;
					}else{
						var documento = $scope.validarDataOtro();
						if(!documento){
							return false;
						}else{
							
							/*si todo salio bien avanzamos a la pestaña datos docuemtnos*/
							$scope.desactivarPestannaPrograma();
				    		$scope.desactivarPestannaPersonal();
							$scope.desactivarPestannaFormacion();
							$scope.desactivarPestannaOtro(); 
							$scope.activarPestannaDocumento(); 
							$scope.desactivarPestannaConfirmar();
							$scope.limpiarMensajeGeneral();
							$scope.limpiarMensajePestannaDocumento();
							return true;
						}
					}
		    	}
			}else if(tabPestana === 'confirmar'){
				if($scope.objetoPrograma === undefined){
		    		$scope.msgDocumento.html("<span><strong>*</strong> Debe seleccionar un prograna.</span>");
		    		$scope.msgDocumento.attr('style','display: block;')
		    		return false;
		    	} else{
					var dataPersonal = $scope.validarDataPersonal();
					if(!dataPersonal){
			    		$scope.msgDocumento.html("<span><strong>*</strong> faltan agregar datos en la pestaña de Datos Personales.</span>");
			    		$scope.msgDocumento.attr('style','display: block;')
			    		return false;
					}else{
						var documento = $scope.validarDataArchivo();
						if(!documento){
							return false;
						}else{
							/*si todo salio bien avanzamos a la pestaña datos confirmacion*/
							$scope.desactivarPestannaPrograma();
				    		$scope.desactivarPestannaPersonal();
							$scope.desactivarPestannaFormacion();
							$scope.desactivarPestannaOtro(); 
							$scope.desactivarPestannaDocumento(); 
							$scope.activarPestannaConfirmar();
							$scope.setearValoresConfirmacion();		
							$scope.limpiarMensajeGeneral();
							$scope.limpiarMensajePestannaConfirmar();
							return true;
						}						
					}
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

    	//var valido = $scope.validaRut($scope.rut.val());
		var valido = true; //$scope.validaRut($scope.rut.val());
    	if(!valido){
    		$scope.msgPersonal.html("<span><strong>*</strong> RUT o Pasaporte está incorrecto.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}		

    	var validoNombre = $scope.caracteresTexto($scope.nombre.val());
    	if(!validoNombre){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el nombre del Alumno.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}		
    	var validoPaterno = $scope.caracteresTexto($scope.apellidoPaterno.val());
    	if(!validoPaterno){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el apellido paterno del Alumno.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}
    	
    	var validoMaterno = $scope.caracteresTexto($scope.apellidoMaterno.val());
    	if(!validoMaterno){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el apellido materno del Alumno.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}   	
		
    	var validarFecha = $scope.validaRut($scope.fechaNacimiento.val());
    	if(!validarFecha){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar la fecha de nacimiento del Alumno.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	} 
  	
    	
    	var validarNacionalidad = true; //$scope.caracteresCorreoValido($scope.nacionalidad.val());
    	if(!validarNacionalidad){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar la nacionalidad.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}   
  	
    	
    	var validarFono = true; //$scope.caracteresCorreoValido($scope.nacionalidad.val());
    	if(!validarFono){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el número de teléfono.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}     	
    	
    	var validarMovil = true; //$scope.caracteresCorreoValido($scope.nacionalidad.val());
    	if(!validarFono){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el número de teléfono.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}      	
    	
    	var validarCorreo = $scope.caracteresCorreoValido($scope.correo.val());
    	if(!validarCorreo){
    		$scope.msgPersonal.html("<span><strong>*</strong> Correo incorrecto, ingréselo en el formato correcto, Ej: ejemplo@gmail.com</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}  
    	
    	var validarpais = $scope.caracteresTexto($scope.pais.val());
    	if(!validarpais){
    		$scope.msgPersonal.html("<span><strong>*</strong> Debe ingresar el país de residencia del alumno.</span>");
    		$scope.msgPersonal.attr('style','display: block;')
    		return false;
    	}    
    	

    	$scope.msgPersonal.html("");
		$scope.msgPersonal.attr('style','display: none;')
		console.log('======================================================================================================================');
		return true;
	}	
	
	
	$scope.validarDataFormacion = function (){
		
		console.log('============================ verificacion de la informacion ingresada en formación ======================================');
    	var tituloOrGrado = $scope.caracteresTexto($scope.tituloOrGrado.val()); 
    	if(!tituloOrGrado){
    		$scope.msgFormacion.html("<span><strong>*</strong> Debe ingresar el titulo o grado.</span>");
    		$scope.msgFormacion.attr('style','display: block;')
    		return false;
    	}		
    	var casaEstudio = $scope.caracteresTexto($scope.casaEstudio.val());
    	if(!casaEstudio){
    		$scope.msgFormacion.html("<span><strong>*</strong> Debe ingresar la casa de estudio.</span>");
    		$scope.msgFormacion.attr('style','display: block;')
    		return false;
    	}
    	
    	var direccionCasaEstudio = true;//$scope.caracteresTexto($scope.direccionCasaEstudio.val());
    	if(!direccionCasaEstudio){
    		$scope.msgFormacion.html("<span><strong>*</strong> Debe ingresar la dirección de la casa estudio.</span>");
    		$scope.msgFormacion.attr('style','display: block;')
    		return false;
    	}   	
		
    	var anhoTitulacion = true;$scope.menorAlAnhoActual($scope.anhoTitulacion.val());
    	if(!anhoTitulacion){
    		$scope.msgFormacion.html("<span><strong>*</strong> Debe ingresar el año de la titulación.</span>");
    		$scope.msgFormacion.attr('style','display: block;')
    		return false;
    	} 
  	
    	var anhoOcupacion = true; //$scope.caracteresTexto($scope.anhoOcupacion.val());
    	if(!anhoOcupacion){
    		$scope.msgFormacion.html("<span><strong>*</strong> Debe ingresar el año de la ocupación.</span>");
    		$scope.msgFormacion.attr('style','display: block;')
    		return false;
    	}  

    	$scope.msgFormacion.html("");
		$scope.msgFormacion.attr('style','display: none;')
		console.log('======================================================================================================================');
		return true;
	}		
	
	$scope.validarDataOtro = function (){
		
		console.log('============================ verificacion de la informacion ingresada en Otro ======================================');
		$scope.enteroPrograma;
		$scope.financiamineto;
		$scope.comentario;
		var enteroPrograma = true; 
    	if(!enteroPrograma){
    		$scope.msgOtro.html("<span><strong>*</strong> Debe ingresar ¿Cómo se enteró del programa?.</span>");
    		$scope.msgOtro.attr('style','display: block;')
    		return false;
    	}		
    	var financiamineto = true; //$scope.caracteresTexto($scope.casaEstudio.val());
    	if(!financiamineto){
    		$scope.msgOtro.html("<span><strong>*</strong> Debe ingresar 	¿Cuáles son sus fuentes de financiamiento? .</span>");
    		$scope.msgOtro.attr('style','display: block;')
    		return false;
    	}
    	
    	var comentario =  true; //$scope.caracteresTexto($scope.direccionCasaEstudio.val());
    	if(!comentario){
    		$scope.msgOtro.html("<span><strong>*</strong> Debe ingresar los comentarios u observaciones (si amerita).</span>");
    		$scope.msgOtro.attr('style','display: block;')
    		return false;
    	}else{
    		var verificacionTexto = $scope.extensionMensaje($scope.comentario.val());
    		if(!verificacionTexto){
        		$scope.msgOtro.html("<span><strong>*</strong> El comentario no debe sobrepasar los 850 caracteres.</span>");
        		$scope.msgOtro.attr('style','display: block;')
        		return false;    			
    		}
    	}   	
		
    	$scope.msgOtro.html("");
		$scope.msgOtro.attr('style','display: none;')
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
    		$scope.msgDocumento.html("<span><strong>*</strong> Debe ingresar adjuntar un archivo en formato (*.zip o *.rar).</span>");
    		$scope.msgDocumento.attr('style','display: block;')
    		return false;
		}else{
	    	$scope.msgDocumento.html("");
			$scope.msgDocumento.attr('style','display: none;')
			console.log('======================================================================================================================');
			return true;			
		}
	
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
            var url = '/web-uchile-front-solicitudes/rest/SolicitudPostulacionService/subirArchivo';
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
		        		if(data.ok && (data.tiempoRespuesta !== null && data.tiempoRespuesta !== "")){
		        			$scope.ArchivoSolicitudDTO =  $.parseJSON(data.tiempoRespuesta);
		        			console.log($scope.ArchivoSolicitudDTO);
							$scope.msgDocumento.removeClass('alert-danger');  
							$scope.msgDocumento.addClass('alert-success');
			        		$scope.msgDocumento.html("<span><strong>Succesful </strong> el archivo " + $scope.ArchivoSolicitudDTO.nombreArchivoSolicitud + " ha sido añadido a la postulación.</span>");
			        		$scope.msgDocumento.attr('style','display: block;');
			        		$scope.modalSubir.modal("hide");
			        		$scope.botonSubirArchivo.hide();
			        		return true;
		        		}else{
			        		$scope.msgDocumento.html("<span><strong>*</strong> Se produjo un error de digitación, espere un momento, gracias por su comprensión.</span>");
			        		$scope.msgDocumento.attr('style','display: block;');
			        		$scope.modalSubir.modal("hide");
			        		return false;		        			
		        		}
		        	}else{
		        		$scope.msgDocumento.html("<span><strong>*</strong> Se produjo un error de digitación, espere un momento, gracias por su comprensión.</span>");
		        		$scope.msgDocumento.attr('style','display: block;');
		        		$scope.modalSubir.modal("hide");
		        		return false;
		        	}
		        },
		        error:function(data) {
	        		$scope.msgDocumento.html("<span><strong>*</strong>Error interno del sistema.</span>");
	        		$scope.msgDocumento.attr('style','display: block;');
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

    	$scope.jsonSolicitidPostulacion =  new Object();
    	/*data : programa */
    	$scope.jsonSolicitidPostulacion.idProgramaUniversidadPostulacion =  $scope.objetoPrograma.idProgramaUniversidadPostulacion;
    	$scope.jsonSolicitidPostulacion.programaPostulacionUniversidad = $scope.objetoPrograma.nombreProgramaUniversidadPostulacion;
    	$scope.jsonSolicitidPostulacion.costoProgramaUniversidad = $scope.objetoPrograma.costoProgramaUniversidadPostulacion;
    	$scope.jsonSolicitidPostulacion.tituloVersionSemestral = $scope.objetoPrograma.duracionProgramaUniversidadPostulacion;
    	
   	
    	/*data : datos personales */
    	$scope.jsonSolicitidPostulacion.rutPersonaSolicitudPostulacion = $scope.rut.val();
    	$scope.jsonSolicitidPostulacion.nombrePersonaSolicitudPostulacion = $scope.nombre.val();
    	$scope.jsonSolicitidPostulacion.apellidoPaternoPersonaSolicitudPostulacion = $scope.apellidoPaterno.val();
    	$scope.jsonSolicitidPostulacion.apellidoMaternoPersonaSolicitudPostulacion = $scope.apellidoMaterno.val();
    	$scope.jsonSolicitidPostulacion.fechaNacimiento = $scope.fechaNacimiento.val(); 	
    	$scope.jsonSolicitidPostulacion.nacionalidad = $scope.nacionalidad.val();
    	$scope.jsonSolicitidPostulacion.fonoContacto = $scope.fonoContacto.val();
    	$scope.jsonSolicitidPostulacion.celularContacto = $scope.fonoMovil.val();
    	$scope.jsonSolicitidPostulacion.mailMember = $scope.correo.val();
    	$scope.jsonSolicitidPostulacion.domicilio = $scope.domicilio.val(); 	 
    	$scope.jsonSolicitidPostulacion.paisDomicilio = $scope.pais.val();
    	$scope.jsonSolicitidPostulacion.nombreRegion = $scope.region.val();
    	$scope.jsonSolicitidPostulacion.idComunaDomicilio = 0;
    	$scope.jsonSolicitidPostulacion.nombreComuna = $scope.comuna.val();
    	$scope.jsonSolicitidPostulacion.ciudadDomicilio = $scope.ciudad.val(); 	
 	
    	/*data : formacion */
    	$scope.jsonSolicitidPostulacion.tituloProfesional = $scope.tituloOrGrado.val();
    	$scope.jsonSolicitidPostulacion.entidadEducacional = $scope.casaEstudio.val();
    	$scope.jsonSolicitidPostulacion.paisEntidadEducacional = $scope.direccionCasaEstudio.val();
    	$scope.jsonSolicitidPostulacion.anhoObtencionEntidadEducacional = $scope.anhoTitulacion.val();
    	$scope.jsonSolicitidPostulacion.ocupacionActual = $scope.anhoOcupacion.val(); 	
    	

    	/* data : otros*/
    	$scope.jsonSolicitidPostulacion.interesPrograma = $scope.enteroPrograma.val();
    	$scope.jsonSolicitidPostulacion.fuenteFinancimiamiento = $scope.financiamineto.val();
    	$scope.jsonSolicitidPostulacion.comentarios = $scope.comentario.val();
    	


    	/* data : archivo */
    	$scope.jsonSolicitidPostulacion.idArchivoSolicitud = $scope.ArchivoSolicitudDTO.idArchivoSolicitud;
    	$scope.jsonSolicitidPostulacion.nombreArchivoSolicitud = $scope.ArchivoSolicitudDTO.nombreArchivoSolicitud;

    	
    	/*data :: programa*/
    	$scope.jsonSolicitidPostulacion.programa = $scope.objetoPrograma;
    	
    	/*data :: archivo*/
    	$scope.jsonSolicitidPostulacion.archivo = $scope.ArchivoSolicitudDTO;
    	
    	
    	var data = $.param({
    		requestJson: JSON.stringify($scope.jsonSolicitidPostulacion),
    		requestFicha: JSON.stringify($scope.ficha)
    		//requestJson: '{"idProgramaUniversidadPostulacion":51,"programaPostulacionUniversidad":"Magister en Gestión Cultural (2019)","costoProgramaUniversidad":"$50.000","tituloVersionSemestral":"Un Semestre","rutPersonaSolicitudPostulacion":"ertyuio","nombrePersonaSolicitudPostulacion":"ertyuio","apellidoPaternoPersonaSolicitudPostulacion":"rtyuiop","apellidoMaternoPersonaSolicitudPostulacion":"rtyuiop","fechaNacimiento":"2345678","nacionalidad":"","fonoContacto":"","celularContacto":"","mailMember":"EXT_JDAMUNOZ@FALABELLA.CL","domicilio":"","paisDomicilio":"chile","nombreRegion":"","idComunaDomicilio":0,"nombreComuna":"","ciudadDomicilio":"","tituloProfesional":"","entidadEducacional":"","paisEntidadEducacional":"wertyuio","anhoObtencionEntidadEducacional":"2017","ocupacionActual":"wertyuiop","interesPrograma":"","fuenteFinancimiamiento":"","idArchivoSolicitud":1051,"nombreArchivoSolicitud":"\"ARQ-AmbienteLocal-200818-1351.zip\"","programa":{"idProgramaUniversidadPostulacion":51,"codigoProgramaUniversidadPostulacion":"MAG_GC_2019","nombreProgramaUniversidadPostulacion":"Magister en Gestión Cultural (2019)","duracionProgramaUniversidadPostulacion":"Un Semestre","costoProgramaUniversidadPostulacion":"$50.000","clasificacionProgramaPostulacion":2,"prioridad":0}}'
        });
    
        var config = {
            headers : {
            	'Content-Type': 'application/json;',
                'Accept-Encoding' : 'gzip'
            }
        };

        $http.post('/web-uchile-front-solicitudes/rest/SolicitudPostulacionService/almacenarSolicitudPostulacionPagoOffline', data, config)
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
        
        console.log('====================================================================================================================');
	  }
		
	$scope.setearValoresConfirmacion = function(){
		console.log('=============================================== validar rut ========================================================');
			$scope.nombresLabel.text($scope.nombre.val());
			$scope.apellidoPaternoLabel.text($scope.apellidoPaterno.val());
			$scope.apellidoMaternoLabel.text($scope.apellidoMaterno.val());
			$scope.programaLabel.text($scope.objetoPrograma.nombreProgramaUniversidadPostulacion);
			$scope.rutLabel.text($scope.rut.val());
			$scope.fechaNacimientoLabel.text($scope.fechaNacimiento.val());
			$scope.nacionalidadLabel.text($scope.nacionalidad.val());
			$scope.fonoContactoLabel.text($scope.fonoContacto.val());
			$scope.fonoMovilLabel.text($scope.fonoMovil.val());
			$scope.correoLabel.text($scope.correo.val());
			$scope.paisLabel.text($scope.pais.val());
			$scope.ciudadLabel.text($scope.ciudad.val());
			$scope.domicilioLabel.text($scope.domicilio.val());
			$scope.tituloGradoLabel.text($scope.tituloOrGrado.val());
			$scope.casaEstudioLabel.text($scope.casaEstudio.val());
			$scope.direccionCasaEstudioLabel.text($scope.direccionCasaEstudio.val());
			$scope.anhoTitulacionLabel.text($scope.anhoTitulacion.val());
			$scope.ocupacionLabel.text($scope.anhoOcupacion.val());
			$scope.enteroProgramaLabel.text($scope.enteroPrograma.val());
			$scope.financiamientoLabel.text($scope.financiamineto.val());
			$scope.comentariosLabel.text($scope.comentario.val());
			$scope.nombreArchivoLabel.text($scope.ArchivoSolicitudDTO.nombreArchivoSolicitud);
		console.log('====================================================================================================================');
    }	
	
	
	
	$scope.seleccionDePrograma = function(programaPostulacion){
		
		if(programaPostulacion !== undefined && programaPostulacion.idProgramaUniversidadPostulacion !== 0){
			$scope.objetoPrograma = programaPostulacion;
			$scope.selectedPrograma =  programaPostulacion.nombreProgramaUniversidadPostulacion;
			$scope.tdImagen.attr('style','display: display;');
			
			$scope.mensajeSeleccion.html("El valor del arancel de inscripción del programa de "+ 
										programaPostulacion.nombreProgramaUniversidadPostulacion + 
										" es de "+ programaPostulacion.costoProgramaUniversidadPostulacion +
										" pesos");
			
			$scope.botonSiguientePrograma.show();
		}else{
			$scope.objetoPrograma = null;
			$scope.selectedPrograma =  'Seleccionar Programa';
			$scope.tdImagen.attr('style','display: none;');
			$scope.mensajeSeleccion.html("");
			$scope.botonSiguientePrograma.hide();
		}
		console.log('=============================================== Seleccion de Programa ===========================================');
		console.log(programaPostulacion);
		console.log('=================================================================================================================');
	};
	
	$scope.siguienteFormularioPestana = function(tabPestana){
		console.log('===================================== Obtener Data Pasar Siguiente Pestaña ========================================');

		if(tabPestana !== undefined ) {
			console.log("pestaña seleccionada : "+ tabPestana);
			if(tabPestana === 'programa'){
				$scope.desactivarPestannaPersonal();
				$scope.desactivarPestannaFormacion();
				$scope.desactivarPestannaOtro();
				$scope.desactivarPestannaDocumento();
				$scope.desactivarPestannaConfirmar();
				$scope.activarPestannaPrograma();
				$scope.msgGeneral.html("");
				$scope.msgGeneral.attr('style','display: none;');
				
			}else if(tabPestana === 'personal'){
				if($scope.objetoPrograma === undefined){
					$scope.msgGeneral.html("<span><strong>*</strong> Debe seguir el orden de las pestaña, partiendo por seleccionar programa.</span>");
					$scope.msgGeneral.attr('style','display: block;');
					$scope.desactivarPestannaPersonal();
					$scope.desactivarPestannaFormacion();
					$scope.desactivarPestannaOtro();
					$scope.desactivarPestannaDocumento();
					$scope.desactivarPestannaConfirmar();
					$scope.activarPestannaPrograma();
		    		return false;
		    	}else{
					/*si todo salio bien avanzamos a la pestaña datos personales*/
					$scope.desactivarPestannaPrograma();
					$scope.desactivarPestannaFormacion();
					$scope.desactivarPestannaOtro();
					$scope.desactivarPestannaDocumento();
					$scope.desactivarPestannaConfirmar();
					$scope.activarPestannaPersonal();
					$scope.msgGeneral.html("");
					$scope.msgGeneral.attr('style','display: none;');
		    	}
			}else if(tabPestana === 'formacion'){
				
				if($scope.objetoPrograma === undefined || $scope.objetoPrograma === null){
					$scope.msgGeneral.html("<span><strong>*</strong> Debe seguir el orden de las pestaña, partiendo por seleccionar programa.</span>");
					$scope.msgGeneral.attr('style','display: block;');
					$scope.desactivarPestannaPersonal();
					$scope.desactivarPestannaFormacion();
					$scope.desactivarPestannaOtro();
					$scope.desactivarPestannaDocumento();
					$scope.desactivarPestannaConfirmar();
					$scope.activarPestannaPrograma();
		    		return false;
		    	}else{
					var formacion = $scope.validarDataPersonal();
					if(!formacion){
						$scope.msgGeneral.html("<span><strong>*</strong> faltan agregar datos en la pestaña de Datos Personales.</span>");
						$scope.msgGeneral.attr('style','display: block;');
						$scope.desactivarPestannaPersonal();
						$scope.desactivarPestannaFormacion();
						$scope.desactivarPestannaOtro();
						$scope.desactivarPestannaDocumento();
						$scope.desactivarPestannaConfirmar();
						$scope.activarPestannaPrograma();
			    		return false;					
					}else{
						/*si todo salio bien avanzamos a la pestaña datos personales*/
						$scope.desactivarPestannaPrograma();
						$scope.desactivarPestannaPersonal();
						$scope.desactivarPestannaOtro();
						$scope.desactivarPestannaDocumento();
						$scope.desactivarPestannaConfirmar();
						$scope.activarPestannaFormacion();	
						$scope.limpiarMensajeGeneral();	
						return true;
					}		    		
		    	}
			}else if(tabPestana === 'otro'){
				if($scope.objetoPrograma === undefined || $scope.objetoPrograma === null){
					$scope.msgGeneral.html("<span><strong>*</strong> Debe seguir el orden de las pestaña, partiendo por seleccionar programa.</span>");
					$scope.msgGeneral.attr('style','display: block;');
					$scope.desactivarPestannaPersonal();
					$scope.desactivarPestannaFormacion();
					$scope.desactivarPestannaOtro();
					$scope.desactivarPestannaDocumento();
					$scope.desactivarPestannaConfirmar();
					$scope.activarPestannaPrograma();
		    		return false;
		    	}else{
					var dataPersonal = $scope.validarDataPersonal();
					if(!dataPersonal){
						$scope.msgGeneral.html("<span><strong>*</strong> faltan agregar datos en la pestaña de Datos Personales.</span>");
						$scope.msgGeneral.attr('style','display: block;');
						$scope.desactivarPestannaPersonal();
						$scope.desactivarPestannaFormacion();
						$scope.desactivarPestannaOtro();
						$scope.desactivarPestannaDocumento();
						$scope.desactivarPestannaConfirmar();
						$scope.activarPestannaPrograma();
			    		return false;	
					}else{
						var otro = $scope.validarDataFormacion();
						if(!otro ){
							$scope.msgGeneral.html("<span><strong>*</strong> faltan agregar datos en la pestaña de Formación Académica y Experiencia.</span>");
							$scope.msgGeneral.attr('style','display: block;');
							$scope.desactivarPestannaPersonal();
							$scope.desactivarPestannaFormacion();
							$scope.desactivarPestannaOtro();
							$scope.desactivarPestannaDocumento();
							$scope.desactivarPestannaConfirmar();
							$scope.activarPestannaPrograma();
				    		return false;
						}else{
								/*si todo salio bien avanzamos a la pestaña datos otros*/
								$scope.desactivarPestannaPrograma();
								$scope.desactivarPestannaPersonal();
								$scope.desactivarPestannaFormacion();
								$scope.desactivarPestannaDocumento();
								$scope.desactivarPestannaConfirmar();						
								$scope.activarPestannaOtro();	
								$scope.limpiarMensajeGeneral();
								return true;
							}						
					}
		    	}
			}else if(tabPestana === 'documento'){
				if($scope.objetoPrograma === undefined || $scope.objetoPrograma === null){
					$scope.msgGeneral.html("<span><strong>*</strong> Debe seguir el orden de las pestaña, partiendo por seleccionar programa.</span>");
					$scope.msgGeneral.attr('style','display: block;');
					$scope.desactivarPestannaPersonal();
					$scope.desactivarPestannaFormacion();
					$scope.desactivarPestannaOtro();
					$scope.desactivarPestannaDocumento();
					$scope.desactivarPestannaConfirmar();
					$scope.activarPestannaPrograma();
		    		return false;
		    	}else{
					var dataPersonal = $scope.validarDataPersonal();
					if(!dataPersonal){
						$scope.msgGeneral.html("<span><strong>*</strong> faltan agregar datos en la pestaña de Datos Personales.</span>");
						$scope.msgGeneral.attr('style','display: block;');
						$scope.desactivarPestannaPersonal();
						$scope.desactivarPestannaFormacion();
						$scope.desactivarPestannaOtro();
						$scope.desactivarPestannaDocumento();
						$scope.desactivarPestannaConfirmar();
						$scope.activarPestannaPrograma();
			    		return false;	
					}else{
						var documento = $scope.validarDataOtro();
						if(!documento){
							$scope.msgGeneral.html("<span><strong>*</strong> faltan agregar datos en la(s) pestaña(s) anteriores.</span>");
							$scope.msgGeneral.attr('style','display: block;');
							$scope.desactivarPestannaPersonal();
							$scope.desactivarPestannaFormacion();
							$scope.desactivarPestannaOtro();
							$scope.desactivarPestannaDocumento();
							$scope.desactivarPestannaConfirmar();
							$scope.activarPestannaPrograma();
				    		return false;
						}else{
							/*si todo salio bien avanzamos a la pestaña datos otros*/
							$scope.desactivarPestannaPrograma();
							$scope.desactivarPestannaPersonal();
							$scope.desactivarPestannaFormacion();
							$scope.desactivarPestannaOtro();	
							$scope.desactivarPestannaConfirmar();
							$scope.activarPestannaDocumento();
							$scope.limpiarMensajeGeneral();
							return true;
						}
					}
		    	}
			}else if(tabPestana === 'confirmar'){
				if($scope.objetoPrograma === undefined || $scope.objetoPrograma === null){
					$scope.msgGeneral.html("<span><strong>*</strong> Debe seguir el orden de las pestaña, partiendo por seleccionar programa.</span>");
					$scope.msgGeneral.attr('style','display: block;');
					$scope.desactivarPestannaPersonal();
					$scope.desactivarPestannaFormacion();
					$scope.desactivarPestannaOtro();
					$scope.desactivarPestannaDocumento();
					$scope.desactivarPestannaConfirmar();
					$scope.activarPestannaPrograma();
		    		return false;
		    	}else{
					var dataPersonal = $scope.validarDataPersonal();
					if(!dataPersonal){
						$scope.msgGeneral.html("<span><strong>*</strong> faltan agregar datos en la pestaña de Datos Personales.</span>");
						$scope.msgGeneral.attr('style','display: block;');
						$scope.desactivarPestannaPersonal();
						$scope.desactivarPestannaFormacion();
						$scope.desactivarPestannaOtro();
						$scope.desactivarPestannaDocumento();
						$scope.desactivarPestannaConfirmar();
						$scope.activarPestannaPrograma();
			    		return false;	
					}else{
						var documento = $scope.validarDataArchivo();
						if(!documento){
							$scope.msgGeneral.html("<span><strong>*</strong> Se debe adjuntar un archivo para confirmar la postulación.</span>");
							$scope.msgGeneral.attr('style','display: block;');
							$scope.desactivarPestannaPersonal();
							$scope.desactivarPestannaFormacion();
							$scope.desactivarPestannaOtro();
							$scope.desactivarPestannaDocumento();
							$scope.desactivarPestannaConfirmar();
							$scope.activarPestannaPrograma();
				    		return false;
							
						}else{
							/*si todo salio bien avanzamos a la pestaña datos confirmacion*/
							$scope.desactivarPestannaPrograma();
							$scope.desactivarPestannaPersonal();
							$scope.desactivarPestannaFormacion();
							$scope.desactivarPestannaOtro();	
							$scope.desactivarPestannaDocumento();
							$scope.activarPestannaConfirmar();
							$scope.setearValoresConfirmacion();			
							$scope.limpiarMensajeGeneral();
							return true;
						}
					}
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
	
	
	$scope.activarPestannaPrograma = function (){
		$scope.liPrograma.addClass('active'); 
		$scope.pestanaPrograma.addClass('boton-activo');
		$scope.pestanaPrograma.removeClass('boton-inactivo');
		$scope.pestanaPrograma.attr('style','border:1px solid #fcefa1; color: #000; width:auto;');
		$scope.tabPrograma.addClass('in');
		$scope.tabPrograma.addClass('active');
	}
	$scope.desactivarPestannaPrograma = function (){
		$scope.liPrograma.removeClass('active');  
		$scope.pestanaPrograma.addClass('boton-inactivo');
		$scope.pestanaPrograma.removeClass('boton-activo');
		$scope.pestanaPrograma.attr('style','border:1px solid #ddd; color: #000; width:auto;');
		$scope.tabPrograma.removeClass('in'); 
		$scope.tabPrograma.removeClass('active'); 
	}	

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
	$scope.activarPestannaFormacion = function (){
		$scope.liFormacion.addClass('active'); 
		$scope.pestanaFormacion.addClass('boton-activo');
		$scope.pestanaFormacion.removeClass('boton-inactivo');
		$scope.pestanaFormacion.attr('style','border:1px solid #fcefa1; color: #000; width:auto;');
		$scope.tabFormacion.addClass('in');
		$scope.tabFormacion.addClass('active');
		
	}
	$scope.desactivarPestannaFormacion = function (){
		$scope.liFormacion.removeClass('active');  
		$scope.pestanaFormacion.addClass('boton-inactivo');
		$scope.pestanaFormacion.removeClass('boton-activo');
		$scope.pestanaFormacion.attr('style','border:1px solid #ddd; color: #000; width:auto;');
		$scope.tabFormacion.removeClass('in'); 
		$scope.tabFormacion.removeClass('active'); 
	}	

	$scope.activarPestannaOtro = function (){
		$scope.liOtros.addClass('active'); 
		$scope.pestanaOtros.addClass('boton-activo');
		$scope.pestanaOtros.removeClass('boton-inactivo');
		$scope.pestanaOtros.attr('style','border:1px solid #fcefa1; color: #000; width:auto;');
		$scope.tabOtros.addClass('in');
		$scope.tabOtros.addClass('active');
		
	}
	$scope.desactivarPestannaOtro = function (){
		$scope.liOtros.removeClass('active');  
		$scope.pestanaOtros.addClass('boton-inactivo');
		$scope.pestanaOtros.removeClass('boton-activo');
		$scope.pestanaOtros.attr('style','border:1px solid #ddd; color: #000; width:auto;');
		$scope.tabOtros.removeClass('in'); 
		$scope.tabOtros.removeClass('active'); 
	}	
	
	$scope.activarPestannaOtro = function (){
		$scope.liOtros.addClass('active'); 
		$scope.pestanaOtros.addClass('boton-activo');
		$scope.pestanaOtros.removeClass('boton-inactivo');
		$scope.pestanaOtros.attr('style','border:1px solid #fcefa1; color: #000; width:auto;');
		$scope.tabOtros.addClass('in');
		$scope.tabOtros.addClass('active');
		
	}
	$scope.desactivarPestannaOtro = function (){
		$scope.liOtros.removeClass('active');  
		$scope.pestanaOtros.addClass('boton-inactivo');
		$scope.pestanaOtros.removeClass('boton-activo');
		$scope.pestanaOtros.attr('style','border:1px solid #ddd; color: #000; width:auto;');
		$scope.tabOtros.removeClass('in'); 
		$scope.tabOtros.removeClass('active'); 
	}	
	
	$scope.activarPestannaDocumento = function (){
		$scope.liDocumento.addClass('active'); 
		$scope.pestanaDocumento.addClass('boton-activo');
		$scope.pestanaDocumento.removeClass('boton-inactivo');
		$scope.pestanaDocumento.attr('style','border:1px solid #fcefa1; color: #000; width:auto;');
		$scope.tabDocumento.addClass('in');
		$scope.tabDocumento.addClass('active');	
		
	}
	$scope.desactivarPestannaDocumento = function (){
		$scope.liDocumento.removeClass('active');  
		$scope.pestanaDocumento.addClass('boton-inactivo');
		$scope.pestanaDocumento.removeClass('boton-activo');
		$scope.pestanaDocumento.attr('style','border:1px solid #ddd; color: #000; width:auto;');
		$scope.tabDocumento.removeClass('in'); 
		$scope.tabDocumento.removeClass('active'); 
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
	$scope.limpiarMensajePestannaPrograma = function (){
		$scope.msgPrograma.html("");
		$scope.msgPrograma.attr('style','display: none;')
	}	
	$scope.limpiarMensajePestannaPersonal = function (){
		$scope.msgPersonal.html("");
		$scope.msgPersonal.attr('style','display: none;')
	}

	$scope.limpiarMensajePestannaFormacion = function (){
		$scope.msgFormacion.html("");
		$scope.msgFormacion.attr('style','display: none;')
	}
	
	$scope.limpiarMensajePestannaOtro = function (){
		$scope.msgOtro.html("");
		$scope.msgOtro.attr('style','display: none;')
	}

	$scope.limpiarMensajePestannaDocumento = function (){
		$scope.msgDocumento.html("");
		$scope.msgDocumento.attr('style','display: none;')
	}
	$scope.limpiarMensajePestannaConfirmar = function (){
		$scope.msgConfirmar.html("");
		$scope.msgConfirmar.attr('style','display: none;')
	}	
	
	$scope.limpiarMensajeGeneral = function (){
		$scope.msgGeneral.html("");
		$scope.msgGeneral.attr('style','display: none;');
	}

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