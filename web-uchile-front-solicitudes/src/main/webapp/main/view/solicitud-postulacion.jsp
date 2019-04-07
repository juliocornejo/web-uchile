<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html ng-app="solicitudPostulaciones" lang="en">
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
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/controllers/solicitudPostulacionController.js?version=1.0.1"></script>
		
		
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
		var jsonListaRegiones = ${listaRegiones};
		var ficha = ${ficha};

		
		$( document ).ready(function() {
			console.log('Inicio del Formulario de Postulaciones');
	     });	

		</script>

</head>
<body ng-controller="SolicitudPostulacionController" ng-init="parsearSolicitudPostulacionesJson();" class="body">

	<div class="banner">
		<img src='/web-uchile-front-solicitudes/administracion-solicitudes/banner_1.jpg' border='0' alt="banner 1" class="bannerTop"/>
	</div>
	
	<div class="main-container footer">

		<div class="page-header">
		  <h1 style="margin: 0.1em 16px 0.2em 0;font-size: 29px;font-weight: normal;color: #333;">Postulaciones 2018 - 2019</h1>
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
		  	<a id="pestanaPrograma" 
				data-toggle="tab" 
				href="#" 
				class="btn boton-activo" 
				ng-click="siguienteFormularioPestana('programa')"
				style="color:#000;width: auto;" >Progama</a> 
		  </li>
		  <li id="pestana2" class="disabled disabledTab" style="border:1px solid #ddd;">
		  	<a id="pestanaDatosPersonales" 
		  	   data-toggle="tab" 
		  	   href="#" 
		  	   class="btn boton-inactivo" 
		  	   ng-click="siguienteFormularioPestana('personal')"
		  	   style="color: #000;width: auto;">Datos Personales</a>
		  </li>
		  <li id="pestana3" class="disabled disabledTab" style="border:1px solid #ddd;">
		  	<a id="pestanaFormacion" 
		  	   data-toggle="tab" 
		  	   href="#" 
		  	   class="btn boton-inactivo" 
		  	   ng-click="siguienteFormularioPestana('formacion')"
		  	   style="color: #000;width: auto;">Formación Académica y Experiencia</a>
		  </li>
		  <li id="pestana4" class="disabled disabledTab" style="border:1px solid #ddd;">
		  	<a id="pestanaOtros" 
		  	   data-toggle="tab" 
		  	   href="#" 
		  	   class="btn boton-inactivo" 
		  	   ng-click="siguienteFormularioPestana('otro')"
		  	   style="color: #000; width: auto;">Otros</a>
		  </li>		  		  
		  <li id="pestana5" class="disabled disabledTab" style="border:1px solid #ddd;">
		  	<a id="pestanaDocumentos" 
		  	   data-toggle="tab" 
		  	   href="#" 
		  	   class="btn boton-inactivo" 
		  	   ng-click="siguienteFormularioPestana('documento')"
		  	   style="color: #000;width: auto;">Documentos Obligatorios</a>
		  </li>		  
		  <li id="pestana6" class="disabled disabledTab" style="border:1px solid #ddd;">
		  	<a id="pestanaConfirmacion" 
		  	   data-toggle="tab" 
		  	   href="#" 
		  	   class="btn boton-inactivo" 
		  	   ng-click="siguienteFormularioPestana('confirmar')"
		  	   style="color: #000;width: auto;">Confirmación de Postulación</a>
		  </li>				  
		  
		</ul>
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />	
				
		<div class="tab-content">
		  <div id="programa" class="tab-pane fade in active">
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
									<li ng-repeat="programaPostulacion in jsonListaProgramaCtrl track by $index">
										<a ng-click="seleccionDePrograma(programaPostulacion)">{{programaPostulacion.nombreProgramaUniversidadPostulacion}}</a>
									</li>
								</ul>
							</div>
						</div>					  
			        </td>
			      </tr>	
			  	  <tr>
			        <td colspan="4" style="font-size: 12px!important;">
			        	<span id="mensajeSeleccion"></span>
			        </td>
			      </tr>				      
			  	  <tr>
			        <td id="imagen" colspan="4" style="display: none;">
			        	<img ng-src='/web-uchile-front-solicitudes/assets/img/postulacion/pago_de_inscripcion_plataforma_de_postulacion.jpg' 
			        		 border='0' alt="banner 1" class="bannerTop"/>
			        </td>
			      </tr>				      
			    </tbody>
			  </table>	
		  	</div>
			<div style="text-align:right">
				<p>
				  <button id="siguientePrograma" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('personal')">Siguiente</button>
				</p>
			</div>			  	
			<div id="msgPrograma" class="alert alert-danger" style="display: none;">
			</div>		  	
		  </div>
		  
		  <div id="datos_personal" class="tab-pane fade">
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
			        <td style="font-size: 12px!important;">Cédula de identidad o Pasaporte <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3"><input id="cedulaOrPasaporte" type="text" class="form-control" style="width: 200px;" placeholder="Cédula o Pasaporte"></td> 
			      </tr>
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
			        <td style="font-size: 12px!important;">Fecha de Nacimiento <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3">
			        	<input id="fechaNacimiento" type="text" class="form-control" style="width: 200px;" placeholder="Fecha de Nacimiento">
			        
			        	<div id="datetimepicker1" class="input-append date" style="width: 300px; display: none;">
						    <input id="fechaNacimiento" 
						        class="form-control" 
						        style="width: 200px;"
					      data-format="dd/MM/yyyy" 
					             type="text"
					             placeholder="Fecha de Nacimiento"/>
						    <span class="add-on">
						      <i data-date-icon="icon-calendar" data-time-icon="icon-time" class="icon-calendar">Seleccionar</i>
						    </span>
					    </div>
			        </td> 
			      </tr>		      
			      <tr>
			        <td style="font-size: 12px!important;">Nacionalidad</td>
			        <td colspan="3"><input id="nacionalidad" type="text" class="form-control" style="width: 200px;" placeholder="Nacionalidad"></td> 
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;">Fono de Contacto</td>
			        <td colspan="3"><input id="fono" type="text" class="form-control" style="width: 200px;" placeholder="Fono de Contacto"></td> 
			      </tr>			      
			      <tr>
			        <td style="font-size: 12px!important;">Fono móvil de Contacto</td>
			        <td colspan="3"><input id="movil" type="text" class="form-control" style="width: 200px;" placeholder="Fono móvil de Contacto"></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;">Correo electrónico <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3"><input id="correo" type="text" class="form-control" style="width: 200px;" placeholder="Correo electrónico"></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;">Pais de Residencia <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3"><input id="residencia" type="text" class="form-control" style="width: 200px;" placeholder="Pais de Residencia"></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;">Región </td>
			        <td colspan="3"><input id="region" type="text" class="form-control" style="width: 200px;" placeholder="Región"></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;">Comuna </td>
			        <td colspan="3"><input id="comuna" type="text" class="form-control" style="width: 200px;" placeholder="Comuna"></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;">Ciudad de Residencia </td>
			        <td colspan="3"><input id="ciudad" type="text" class="form-control" style="width: 200px;" placeholder="Ciudad"></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;">Domicilio</td>
			        <td colspan="3"><input id="domicilio" type="text" class="form-control" style="width: 200px;" placeholder="Domicilio"></td> 
			      </tr>
			    </tbody>
			  </table>
		  	</div>
			<div style="text-align:right">
				<p>
				  <button id="atrasPersonal" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('programa')">Atras</button>
				  <button id="siguientePersonal" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('formacion')">Siguiente</button>
				</p>
			</div>	
			<div id="msgPersonal" class="alert alert-danger" style="display: none;"></div>				
		  </div>
		  
		  <div id="formacion" class="tab-pane fade">
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
			        <td style="font-size: 12px!important; width: 300px;">Título profesional o Grado académico <span class="spanObligatorio">(*)</span> </td>
			        <td colspan="3">
			        	<input id="tituloOrGrado" type="text" class="form-control" placeholder="Título profesional o Grado académico">
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 300px;">¿Cuál fue la casa de estudios obtuvo su título profesional o grado académico? <span class="spanObligatorio">(*)</span></td>
			        <td colspan="3">
			        	<input id="casaEstudio" type="text" class="form-control" placeholder="¿Cuál fue la casa de estudios obtuvo su título profesional o grado académico?">
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 300px;">¿Dónde se encontraba la casa de estudios?</td>
			        <td colspan="3">
			        	<input id="direccionCasaEstudio" type="text" class="form-control" placeholder="¿Dónde se encontraba la casa de estudios?">
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 300px;">Año de Titulación</td>
			        <td style="font-size: 12px!important;">
			        	<input id="anhoTitulacion" type="text" class="form-control" placeholder="Año de Titulación, Ej: 2017">
			        </td>
			        <td style="font-size: 12px!important;">Ocupación Actual</td>
			        <td style="font-size: 12px!important;">
			        	<input id="anhoOcupacion" type="text" class="form-control" placeholder="Año de Titulación">
			        </td>
			      </tr>	
			    </tbody>
			  </table>
		  	</div>
			<div style="text-align:right">
				<p>
				  <button id="atrasFormacion" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('personal')">Atras</button>
				  <button id="siguienteFormacion" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('otro')">Siguiente</button>
				</p>
			</div>	
			<div id="msgFormacion" class="alert alert-danger" style="display: none;"></div>				
					  	
		  </div>	
		  	  
		  <div id="otro" class="tab-pane fade">
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
			        <td style="font-size: 12px!important; width: 210px;" >¿Cómo se enteró del programa?</td>
			        <td colspan="3"><input id="enteroPrograma" type="text" class="form-control" style="width: 300px;" placeholder="¿Cómo se enteró del programa?"></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;"> ¿Cuáles son sus fuentes de financiamiento?</td>
			        <td colspan="3"><input id="financiamineto" type="text" class="form-control" style="width: 300px;" placeholder="¿Cuáles son sus fuentes de financiamiento?"></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;"> Ingrese comentarios u observaciones (si amerita)</td>
			        <td colspan="3">
			        	<textarea id="comentario" class="form-control" rows="3" ></textarea>
			        </td> 
			      </tr>			      
			    </tbody>
			  </table>
		  	</div>
			<div style="text-align:right">
				<p>
				  <button id="atrasOtro" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('formacion')">Atras</button>
				  <button id="siguienteOtro" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('documento')">Siguiente</button>
				</p>
			</div>
			<div id="msgOtro" class="alert alert-danger" style="display: none;"></div>		
		  </div>	
		  
		  <div id="documentos" class="tab-pane fade">
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
			        <td style="font-size: 12px!important; width: 210px;"colspan="3" >1) Currículum vitae.</td>
			        <td ></td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;" colspan="3"> 2) Fotografía digital de 3x4 cms.</td>
			        <td ></td>  
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;" colspan="3">3) Títulos y grados académicos.</td>
			        <td ></td> 
			      </tr>			      
			      <tr>
			        <td style="font-size: 12px!important;" colspan="3"> 4) Comprobante de pago de arancel de inscripción.</td>
			        <td ></td> 
			      </tr>			      
			      <tr>
			        <td style="font-size: 12px!important;" colspan="3"> 5) Cédula de identidad o pasaporte digitalizado por ambos lados.</td>
			        <td></td> 
			      </tr>		
			      <tr>
			        <td style="font-size: 12px!important;" colspan="3">	<span class="spanObligatorio">(*)</span>
			        	Los documentos de la solicitud deben estar adjuntos dentro de una carpeta comprimida como un archivo rar o zip (20Mb)
			        </td>
			        <td></td> 
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;" colspan="3"></td>
			        <td></td> 
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;" colspan="3">
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
						    <div id="mensaje"></div>
						</span>    
 			        </td>
			      	<td></td> 
			      </tr>				      			      
			    </tbody>
			  </table>
		  	</div>
			<div style="text-align:right">
				<p>
				  <button id="atrasDocumento" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('otro')">Atras</button>
				  <button id="siguienteDocumento" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('confirmar')">Siguiente</button>
				</p>
			</div>	
			<div id="msgDocumento" class="alert alert-danger" style="display: none;"></div>		
					  	
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
			        <td style="font-size: 12px!important; width: 210px;">Nombre del Postulante : </td>
			        <td colspan="3">
			        	<span id="nombresLabel"/> <span id="apellidoPaternoLabel"/> <span id="apellidoMaternoLabel"/>
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Programa Universidad : </td>
			        <td colspan="3">
			        	<span id="programaLabel"/>
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Cédula de identidad o Pasaporte : </td>
			        <td colspan="3">
			        	<span id="rutLabel"/>
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Fecha de Nacimiento : </td>
			        <td colspan="3">
			        	<span id="fechaNacimientoLabel"/>
			        </td> 
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Nacionalidad : </td>
			        <td colspan="3">
			        	<span id="nacionalidadLabel"/>
			        </td> 
			      </tr>			      
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Fono de Contacto : </td>
			        <td colspan="3">
			        	<span id="fonoContactoLabel"/>
			        </td> 
			      </tr>				      
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Fono móvil de Contacto : </td>
			        <td colspan="3">
			        	<span id="fonoMovilLabel"/>
			        </td> 
			      </tr>				      
			      <tr>
			        <td style="font-size: 12px!important; width: 210px;">Email del Postulante</td>
			        <td colspan="3">
			        	<span id="correoLabel"/>
			        </td> 
			      </tr>	
			      <tr>			      
			        <td style="font-size: 12px!important; width: 210px;">País de Domicilio</td>
			        <td colspan="3">
			        	<span id="paisLabel"/>
			        </td> 
			      </tr>			      
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">Ciudad de Residencia</td>
			        <td colspan="3">
			        	<span id="ciudadLabel"/>
			        </td> 
			      </tr>				      
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">Domicilio</td>
			        <td colspan="3">
			        	<span id="domicilioLabel"/>
			        </td> 
			      </tr>				      
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">Título profesional o Grado académico</td>
			        <td colspan="3">
			        	<span id="tituloGradoLabel"/>
			        </td> 
			      </tr>	
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">¿Cuál fue la casa de estudios obtuvo su título profesional o grado académico?</td>
			        <td colspan="3">
			        	<span id="casaEstudioLabel"/>
			        </td> 
			      </tr>				      
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">¿Dónde se encontraba la casa de estudios?</td>
			        <td colspan="3">
			        	<span id="direccionCasaEstudioLabel"/>
			        </td> 
			      </tr>		      
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">Año de titulación</td>
			        <td colspan="3">
			        	<span id="anhoTitulacionLabel"/>
			        </td> 
			      </tr>				      
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">Ocupación actual</td>
			        <td colspan="3">
			        	<span id="ocupacionLabel"/>
			        </td> 
			      </tr>				      
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">¿Cómo se enteró del programa?</td>
			        <td colspan="3">
			        	<span id="enteroProgramaLabel"/>
			        </td> 
			      </tr>	
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">¿Cuáles son sus fuentes de financiamiento?</td>
			        <td colspan="3">
			        	<span id="financiamientoLabel"/>
			        </td> 
			      </tr>				      			      			      
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">comentarios u observaciones</td>
			        <td colspan="3">
			        	<span id="comentariosLabel"/>
			        </td> 
			      </tr>	
			      <tr>				      
			        <td style="font-size: 12px!important; width: 210px;">Archivo Adjunto</td>
			        <td colspan="3">
			        	<span id="nombreArchivoLabel"/>
			        </td> 
			      </tr>	
			    </tbody>
			  </table>
		  	</div>
			<div style="text-align:right">
				<p>
				  <button id="atrasConfirmar" type="button" class="btn botones-abajos" ng-click="siguienteFormulario('documento')">Atras</button>
				  <button id="siguienteConfirmar" type="button" class="btn botones-abajos" ng-click="almacenarSolicitudCertificadoPagoOffline()">Postular</button>
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
	        <h4 class="modal-title">Enviando la Solicitud de Postulación   
	        	<img ng-src='/web-uchile-front-solicitudes/administracion-solicitudes/3d-loader.gif' height="35" width="35" />
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
	        	<img ng-src='/web-uchile-front-solicitudes/administracion-solicitudes/3d-loader.gif' height="35" width="35" />
	        </h4>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>