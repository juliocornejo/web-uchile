<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html ng-app="solicitudCertificado" lang="en">
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

		<!-- jQuery Global Controller-->		
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/controllers/solicitudCertificadoController.js?version=1.0.1"></script>
		
		
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
		var jsonListaPrograma = ${listaPrograma};
		var jsonListaTipoCertificado = ${listaTipoCertificado};
		var jsonListaFinalidadCertificado = ${listaFinalidadCertificado};
		var ficha = ${ficha};
		$( document ).ready(function() {
			console.log('Inicio del Formulario de Certificados');
	     });	

		</script>

</head>
<body ng-controller="SolicitudCertificadoController" ng-init="parsearSolicitudCertificadoJson(); data = {};" class="body">

	<div class="banner">
		<img src='/web-uchile-front-solicitudes/administracion-solicitudes/banner_1.jpg' border='0' alt="banner 1" class="bannerTop"/>
	</div>
	
	<div class="main-container footer">

		<div class="page-header">
		  <h1 style="margin: 0.1em 16px 0.2em 0;font-size: 29px;font-weight: normal;color: #333;">Solicitud de Certificados</h1>
		</div>
		
		<div class="titulos">Bienvenido al sistema de Solicitud de 	Certificados en Línea de la Escuela de Postgrado de la Facultad de Artes de la Universidad de Chile.</div>
		<br />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<ul class="nav nav-tabs" style="border-bottom: 1px solid #fff;">
		  <li id="pestana1" class="active" style="border:1px solid #fcefa1;">
		  	<a id="pestanaAntecedentes" 
				data-toggle="tab" 
				href="#antecedentes" 
				class="btn boton-activo" 
				ng-click="volverPrimeraPestana()"
				style="color: #000;" >Antecedentes Personales</a> 
		  </li>
		  <li id="pestana2" class="disabled disabledTab" style="border:1px solid #ddd;">
		  	<a id="pestanaConfirmacion" 
		  	   data-toggle="tab" 
		  	   href="#confirmacion" 
		  	   class="btn boton-inactivo" 
		  	   style="color: #000;">Confirmacion de Solicitud</a>
		  </li>
		</ul>
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />	
				
		<div class="tab-content">
		  <div id="antecedentes" class="tab-pane fade in active">
		  <br />
		  	<div>
			  <table class="table" cellpadding="1" cellspacing="1" border="0"> 
			    <thead>
			      <tr>
			        <th></th>
			        <th>Nombre</th>
			        <th>Apellido Paterno</th>
			        <th>Apellido Materno</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td style="font-size: 12px!important;">Nombre Completo</td>
			        <td><input id="nombres" type="text" class="form-control" placeholder="Nombres"></td>
			        <td><input type="text" class="form-control" id="apellidoPaterno" placeholder="Paterno"></td>
			        <td><input type="text" class="form-control" id="apellidoMaterno" placeholder="Materno"></td>
			      </tr>
			      
			      <tr style="border-top: 1px solid transparen!important;">
			        <td style="font-size: 12px!important;">RUT</td>
			        <td><input type="text" class="form-control" id="rut" maxlength="10" placeholder="Ej: XXXXXXXX-X"></td>
			        <td></td>
			        <td></td>
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;">Correo Electrónico</td>
			        <td><input type="text" class="form-control" id="correo" placeholder="Ej: ejemplo@gmail.com" > </td>
			        <td></td>
			        <td></td>
			      </tr>		      
			      <tr>
			        <td style="font-size: 12px!important;">Programa</td>
			        <td colspan="3">
						<div class="vf-selector">
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true" ng-cloak>
									{{selectedPrograma}} <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<li ng-repeat="programaUniversidad in jsonListaProgramaCtrl track by $index">
										<a ng-click="seleccionDePrograma(programaUniversidad)">{{programaUniversidad.nombreProgramaUniversidad}}</a>
									</li>
								</ul>
							</div>
						</div>					  
			        </td>
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;">Año de Ingreso</td>
			        <td><input type="text" class="form-control" id="annoIngresos" maxlength="10" placeholder="Ej: 2006"> </td>
			        <td></td>
			        <td></td>
			      </tr>			      
			    </tbody>
			  </table>
			  <table class="table" cellpadding="1" cellspacing="1" >
			    <tbody>
			      <tr>
			        <td style="font-size: 12px!important;vertical-align: center; width: 15%;">Tipo de Certificado</td>
			        <td> 
				        <div class="radio" ng-repeat='tipoCertificado in jsonTipoCertificadoCtrl track by $index'>
	    					<label>
	    						<input id="{{tipoCertificado.idTipoCertificado}}" 
	    						     type="radio" 
	    						     name="optradioTC" 
	    						 ng-click="seleccionTipoCertificado(tipoCertificado)" > {{tipoCertificado.nombreTipoCertificado}}
	    					</label>
						</div>	    					
			        </td>
			      </tr>
			    </tbody>
			  </table>	
			  <table class="table" cellpadding="1" cellspacing="1" >
			    <tbody>
			      <tr>
			        <td style="font-size: 12px!important; width:15%;">Fines del certificado</td>
			        <td> 
				        <div class="radio" ng-repeat='finalidadCertificado in jsonListaFinalidadCertificadoCtrl track by $index'>
	    					<label>
	    						<input id="{{finalidadCertificado.idFinalidadCertificado}}" 
	    							 type="radio" 
	    							 name="optradioFC" 
	    							 ng-click="seleccionFinalidadCertificado(finalidadCertificado)" > {{finalidadCertificado.nombreFinalidadCertificado}}
	    					</label>
						</div>	 			        
			        </td>
			      </tr>
			    </tbody>
			  </table>	
		  	</div>
			<div id="msg" class="alert alert-danger" style="display: none;">
				
			</div>		  	
		  </div>
		  
		  <div id="confirmacion" class="tab-pane fade">
		   <br />
		  	<div>
			  <table class="table" cellpadding="1" cellspacing="1" border="0"> 
			    <thead>
			      <tr>
			        <th></th>
			        <th>Nombre</th>
			        <th>Apellido Paterno</th>
			        <th>Apellido Materno</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td style="font-size: 12px!important;">Nombre Completo</td>
			        <td><span id="nombresLabel"/></td> 
			        <td><span id="apellidoPaternoLabel"/></td>
			        <td><span id="apellidoMaternoLabel" /></td>
			      </tr>
			      
			      <tr>
			        <td style="font-size: 12px!important;">RUT</td>
			        <td><span id="rutLabel" /></td>
			        <td></td>
			        <td></td>
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important;">Correo Electrónico</td>
			        <td><span id="correoLabel" /></td>
			        <td></td>
			        <td></td>
			      </tr>		      
			      <tr>
			        <td style="font-size: 12px!important;">Programa</td>
 					<td colspan="3"><span id="programaLabel" /></td>				  
			      </tr>	
			      <tr>
			        <td style="font-size: 12px!important;">Año de Ingreso</td>
			        <td><span id="annoIngresosLabel"/></td>
			        <td></td>
			        <td></td>
			      </tr>			      
			      <tr>
			        <td style="font-size: 12px!important;vertical-align: center; width: 15%;">Tipo de Certificado</td>
					<td colspan="3"><span id="tipoLabel" /></td>
			      </tr>
			      <tr>
			        <td style="font-size: 12px!important; width:15%;">Fines del certificado</td>
					<td colspan="3"><span id="finesLabel" /></td>
			      </tr>
			    </tbody>
			  </table>
		  	</div>
		  </div>
		  
		  
		</div>
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="left">
			<p>
			  <button id="limpiar" type="button" class="btn botones-abajos"  ng-click="limpiarFormulario()">Limpiar</button>
			  <button id="siguiente" type="button" class="btn botones-abajos" ng-click="siguienteFormulario()">Siguiente</button>
			  <button id="volver" type="button" class="btn botones-abajos" ng-click="volverPrimeraPestana()">Volver</button>
			  <button id="enviar" type="button" class="btn botones-abajos"  ng-click="almacenarSolicitudCertificadoPagoOffline()">Enviar</button>
			 
			</p>
		</div>		
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-subintro">La respuesta oficial será enviada a su correo electrónico</div>
		<div class="texto-subintro">Consideraciones importantes:</div>
		<div class="texto-subintro">Para obtener los certificados que tienen costo, se debe cancelar el IMPUESTO UNIVERSITARIO. Este
			impuesto se paga en forma de "ESTAMPILLAS" las cuales se compran en Servicios Centrales de la Universidad de Chile, calle Diagonal
			Paraguay 265, 1er piso (Centro de Atención de Alumnos). El horario de atención es de Lunes a Jueves de 09:00 a 13:00 hrs. Las
			ESTAMPILLAS debes portarlas al momento de retirar tu certificado en nuestra Escuela de Postgrado. El tiempo de entrega de tu
			certificado es de 05 días hábiles.
		</div>
		<div class="texto-subintro">Para cualquier consulta, por favor dirigirse a la Secretaría de Postgrado del Programa.</div>
		<div class="texto-saludate">Saluda atentamente</div>
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
	        <h4 class="modal-title">Enviando la Solicitud del Certificado   
	        	<img ng-src='/web-uchile-front-solicitudes/administracion-solicitudes/3d-loader.gif' height="35" width="35" />
	        </h4>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>