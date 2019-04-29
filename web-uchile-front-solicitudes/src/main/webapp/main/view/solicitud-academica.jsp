<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html ng-app="solicitudAcademica" lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<title>Facultad de Artes Universidad de Chile</title>
		
		<link href="/web-uchile-front-solicitudes/assets/css/estilos.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="/web-uchile-front-solicitudes/assets/css/normalize.min.css">
		
		<!-- jQuery Global -->
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/jquery.mobile.custom.min.js"></script>


		<!-- jQuery Global Angular-->
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/angular-1.5.0/angular.min.js"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/angular-1.5.0/i18n/angular-locale_es-cl.js"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/angular-sanitize.js"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/angular-aria.min.js"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/angular-messages.min.js"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/angular-animate.js"></script>	
		

		<!-- jQuery Global Bootstrap-->
		<link rel="stylesheet" type="text/css" href="/web-uchile-front-solicitudes/assets/css/bootstrap/bootstrap.min.css">
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/ui-bootstrap-tpls-1.1.2.min.js"></script>
		
		<!-- Global datepicker-->
		<link rel="stylesheet" type="text/css" href="/web-uchile-front-solicitudes/lib/calendario/css/bootstrap-datetimepicker.min.css">
		<script type="text/javascript" src="/web-uchile-front-solicitudes/lib/calendario/js/bootstrap-datetimepicker.min.js"></script>
		
		<!-- jQuery Global Controller-->		
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/controllers/solicitudAcademicaController.js?version=1.0.1"></script>
		
		
		<!-- JS generales de Desarrollo-->
		<script src="/web-uchile-front-solicitudes/assets/js/swiper.min.js"></script>
		<script src="/web-uchile-front-solicitudes/assets/js/photoswipe/photoswipe.min.js"></script>
		<script src="/web-uchile-front-solicitudes/assets/js/photoswipe/photoswipe-ui-default.min.js"></script>
		<script src="/web-uchile-front-solicitudes/assets/js/select2.min.js"></script>

		<!-- Core JS file -->
		<script src="/web-uchile-front-solicitudes/assets/js/photoswipe/photoswipe.min.js"></script>

		<!-- UI JS file -->
		<script src="/web-uchile-front-solicitudes/assets/js/photoswipe/photoswipe-ui-default.min.js"></script>

		<!-- jQuery UX -->
		<script src="/web-uchile-front-solicitudes/assets/js/ux/utilidades.js"></script>
		<script src="/web-uchile-front-solicitudes/assets/js/ux/listing/main.js"></script>
		<script src="/web-uchile-front-solicitudes/assets/js/validar_es.js"></script>
		
		<script type="text/javascript">
		var jsonMensajeError = ${Error};
		var jsonArchivosubido = ${Archivo};
		var jsonListaPrograma = ${listaPrograma};
		var jsonListaTipoSolicitudes = ${listaTipoSolicitudes};
		var ficha = ${ficha};
		
		$( document ).ready(function() {
			console.log('Inicio del Formulario de Solicitud Academica');
	     });	

		</script>

</head>
<body ng-controller="SolicitudAcademicaController" ng-init="parsearSolicitudAcademicaJson();" class="body">

	<div class="banner">
		<img src='/web-uchile-front-solicitudes/assets/images/banner_1.jpg' border='0' alt="banner 1" class="bannerTop"/>
	</div>
	
	<div class="main-container footer">

		<div class="page-header">
		  <h1 style="margin: 0.1em 16px 0.2em 0;font-size: 29px;font-weight: normal;color: #333;">Solicitud Académica</h1>
		</div>
		
		<div class="titulos">Bienvenido al sistema de Postulaciones en Línea de la Escuela de Postgrado de la Facultad de Artes de la Universidad de Chile.</div>
		<br />
		<div id="msgGeneral" class="alert alert-danger" style="display: none;"></div>	
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<ul class="nav nav-tabs" style="border-bottom: 1px solid #fff;">
		  <li id="pestana1" class="active" style="border:1px solid #fcefa1;">
		  	<a id="pestanaDatosPersonales" 
				data-toggle="tab" 
				href="#" 
				class="btn boton-activo" 
				ng-click="siguienteFormularioPestana('personal')"
				style="color:#000;width: auto;" >Antecedentes Personales</a> 
		  </li>
		  <li id="pestana2" class="disabled disabledTab" style="border:1px solid #ddd;">
		  	<a id="pestanaConfirmacion" 
		  	   data-toggle="tab" 
		  	   href="#" 
		  	   class="btn boton-inactivo" 
		  	   ng-click="siguienteFormularioPestana('confirmar')"
		  	   style="color: #000;width: auto;">Confirmacion de Solicitud</a>
		  </li>
		</ul>
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />	
				
		<div class="tab-content">
		  <div id="personal" class="tab-pane fade in active">
		  <br />
		  	<div>
			  <table class="table">
			    <thead>
			      <tr>
			        <th></th>
			        <th></th>
			        <th></th>
			        <th></th>
			      </tr>
			    </thead>	
			    <tbody>
			      <tr>
			        <td style="font-size: 12px!important;width: 220px;"></td>
			        <td style="font-size: 12px!important;">Nombres</td>
			        <td style="font-size: 12px!important;">Apellido Paterno</td>
			        <td style="font-size: 12px!important;">Apellido Materno</td>
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;">Nombre del Postulante <span class="spanObligatorio">(*)</span></td>
			        <td><input id="nombres" type="text" class="form-control" style="width: 200px;" placeholder="Nombres"></td> 
			        <td><input id="apellidopaterno" type="text" class="form-control" style="width: 200px;" placeholder="Apellido Paterno"></td> 
			        <td><input id="apellidomaterno" type="text" class="form-control" style="width: 200px;" placeholder="Apellido Materno"></td> 
			      </tr>			    
			      <tr>
			        <td style="font-size: 12px!important;">Cédula de identidad o Pasaporte <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3"><input id="cedulaOrPasaporte" type="text" class="form-control" style="width: 200px;" placeholder="Cédula o Pasaporte"></td> 
			      </tr>
			  	  <tr>
			        <td style="font-size: 12px!important;">Programa <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3">
						<div class="vf-selector">
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true" ng-cloak>
									{{selectedPrograma}} <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<li ng-repeat="programa in jsonListaProgramaCtrl track by $index">
										<a ng-click="seleccionDePrograma(programa)">{{programa.nombreProgramaUniversidad}}</a>
									</li>
								</ul>
							</div>
						</div>					  
			        </td>
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;">Correo electrónico <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3"><input id="correo" type="text" class="form-control" style="width: 200px;" placeholder="Correo electrónico"></td> 
			      </tr>			      
			      <tr>
			        <td style="font-size: 12px!important;">Año de Ingreso <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3"><input id="anho" type="text" class="form-control" style="width: 200px;" placeholder="Año de Ingreso"></td> 
			      </tr>				      
			      <tr>
			        <td style="font-size: 12px!important;">Tipo de Solicitud <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3">
				        <div class="radio" ng-repeat='tipoSolicitud in jsonTipoSolicitudCtrl track by $index'>
	    					<label>
	    						<input id="{{tipoSolicitud.idTipoSolicitud}}" 
	    						     type="radio" 
	    						     name="optradioTC" 
	    						 ng-click="seleccionTipoSolicitud(tipoSolicitud)" > {{tipoSolicitud.nombreTipoSolicitud}}
	    					</label>
						</div			        
			        </td> 
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;">Fundamente su Solicitud <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3">
			        	<textarea id="comentario" class="form-control" rows="3"></textarea>
			        </td> 
			      </tr>	
			      			      
			      <tr>
			        <td style="font-size: 12px!important;" colspan="4"> 
			        	<span>También es posible incorporar documentos con el botón “ADJUNTAR ARCHIVO” que respalden la justificación de su solicitud, por ejemplo: </span>
						<span>certificados médicos, certificados de trabajo, cartas de apoyo, etc.</span>
						<span>Los documentos de la solicitud academica deben estar adjuntos dentro de una carpeta comprimida como un archivo rar o zip (15Mb)</span>
			        </td>
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;" colspan="4"> 
				        <span class="btn-file">
						    <form enctype="multipart/form-data" id="formuploadajax" method="post">
						        Adjuntar Archivo: 
						        <br />
						        <input  type="file" 
						                 id="archivo1" 
						                name="archivo1" 
						               style="width: 300px;" 
						               accept="application/zip,application/rar"/> 
						        <br />
						        <span id="nombreArchivo" ></span><br />
						        <span id="tamanoArchivo" ></span><br />
						        <span id="mensajeArchivo" style="color: red;"></span> 
						        <br />
						        <input id="botonSubirArchivo" type="submit" value="Subir archivos"/>
						    </form>
						</span> 
			        </td>
			      </tr>				      			      
			      <tr>
			        <td style="font-size: 12px!important;" colspan="4"> 
			        	<span>favor de nombrar al archivo de tal forma que tenga el nombre o el rut del postulante - Ej:"julio_pedreros_solicitud_academica_postergacion.rar" o "20000000-5_solicitud_academica_homologacion.rar"</span>
			        </td>
			      </tr>	
			    </tbody>
			  </table>	
		  	</div>
			<div style="text-align:right">
				<p>
				  <button id="limpiar" type="button" class="btn botones-abajos" ng-click="limpiarFormulario()">Limpiar</button>
				  <button id="siguiente" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('confirmar')">Siguiente</button>
				</p>
			</div>			  	
			<div id="msgPersonal" class="alert alert-danger" style="display: none;"></div>		  	
		  </div>
		  
		  <div id="confirmacion" class="tab-pane fade">
		   <br />
		  	<div>
			  <table class="table" cellpadding="1" cellspacing="1" border="0"> 
			    <thead>
			      <tr>
			        <th></th>
			        <th></th>
			        <th></th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Nombre del Solicitante : </td>
			        <td colspan="3">
			        	<span id="nombresLabel"/> <span id="apellidoPaternoLabel"/> <span id="apellidoMaternoLabel"/>
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Cédula de identidad o Pasaporte : </td>
			        <td colspan="3">
			        	<span id="rutLabel"/>
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Programa : </td>
			        <td colspan="3">
			        	<span id="programaLabel"/>
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Correo electrónico</td>
			        <td colspan="3">
			        	<span id="correoLabel"/>
			        </td> 
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Año de Ingreso : </td>
			        <td colspan="3">
			        	<span id="anhoIngresoLabel"/>
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Tipo de Solicitud : </td>
			        <td colspan="3">
			        	<span id="tipoSolicitudLabel"/>
			        </td> 
			      </tr>			      
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Fundamentacion de Solicitud : </td>
			        <td colspan="3">
			        	<span id="fundamentosLabel"/>
			        </td> 
			      </tr>				      
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Archivo Adjunto : </td>
			        <td colspan="2">
			        	<span id="archivoLabel"/>  
			        </td> 
			        <td >
			        	<div class="checkbox">
						  <label><input id="archivo3"type="checkbox" value="">No voy a adjuntar archivo</label>
						</div>			        	   
			        </td> 			        
			        

			      </tr>				      
			    </tbody>
			  </table>
		  	</div>
			<div style="text-align:right">
				<p>
				  <button id="atrasConfirmar" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('personal')">Atras</button>
				  <button id="siguienteConfirmar" type="button" class="btn botones-abajos" ng-click="almacenarSolicitudCertificadoPagoOffline()">Guardar</button>
				</p>
			</div>
			<div id="msgConfirmar" class="alert alert-danger" style="display: none;"></div>		
		  </div>			  
		
		
		
		</div>
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-subintro"><span class="spanObligatorio">(*)</span> campos obligatorios </div>
		<div class="texto-saludate" /><div class="texto-saludate" /><div class="texto-saludate" />
		<div class="texto-subintro">La respuesta oficial será enviada a su correo electrónico</div>
		<div class="texto-subintro">Para cualquier consulta, por favor dirigirse a la Secretaría de Postgrado del Programa.</div>
		<div class="texto-saludate">Saluda atentamente,</div>
		<div class="texto-saludate">Escuela de Postgrado</div>
		<div class="texto-saludate">Facultad de Artes</div>
		<div class="texto-saludate">Universidad de Chile</div>

	</div>

	<!-- Modal -->
	<div id="cargandoModal" class="modal fade " role="dialog" tabindex="-1">
	  <div class="modal-dialog modalPrincipal" role="document">
	
	    <!-- Modal content-->
	    <div class="modal-content modelCargando">
	      <div class="modal-header">
	        <h4 class="modal-title">Enviando la Solicitud Academica   
	        	<img ng-src='/web-uchile-front-solicitudes/assets/images/3d-loader.gif' height="35" width="35" />
	        </h4>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Modal -->
	<div id="cargandoModalSubir" class="modal fade " role="dialog" tabindex="-1">
	  <div class="modal-dialog modalPrincipal" role="document">
	
	    <!-- Modal content-->
	    <div class="modal-content modelCargando">
	      <div class="modal-header">
	        <h4 class="modal-title">Espere un momento, su archivo se está adjuntando  
	        	<img ng-src='/web-uchile-front-solicitudes/assets/images/3d-loader.gif' height="35" width="35" />
	        </h4>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>