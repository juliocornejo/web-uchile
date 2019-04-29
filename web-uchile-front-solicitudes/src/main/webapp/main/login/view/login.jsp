<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html ng-app="uchileApp" lang="en">
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
		
		<!-- Angular Modulos  -->	
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/app.js?version=1.0.1"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/login/index.js?version=1.0.1"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/login/controller/loginController.js?version=1.0.1"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/login/factory/loginFactory.js?version=1.0.1"></script>
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/login/service/loginService.js?version=1.0.1"></script>
		
		<script type="text/javascript">

		var login = ${login};
		var ficha = ${ficha};
		$( document ).ready(function() {
	     });	

		</script>

</head>
<body ng-controller="LoginController" ng-init="parsearLoginJson(); data = {};" class="body">

	<div class="banner">
		<img src='/web-uchile-front-solicitudes/assets/images/banner_1.jpg' border='0' alt="banner 1" class="bannerTop"/>
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
		  	<a id="pestanaLogin" 
				data-toggle="tab" 
				href="#antecedentes" 
				class="btn boton-activo" 
				style="color: #000;" >Login</a> 
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
			        <th>Usuario</th>
			        <th>Contraseña</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td style="font-size: 12px!important;">Login</td>
			        <td><input id="usuario" type="text" class="form-control" placeholder="usuario"></td>
			        <td><input id="contrasenha" type="password" class="form-control"  placeholder="*******"></td>
			      </tr>
			    </tbody>
			  </table>
		  	</div>
			<div id="msg" class="alert alert-danger" style="display: none;">
				
			</div>		  	
		  </div>
		  
		</div>
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="left">
			<p>
			  <button id="iniciar" type="button" class="btn botones-abajos"  ng-click="obtenerUsuarioLogin()">Iniciar sesión</button>
			  <button id="registrar" type="button" class="btn botones-abajos" ng-click="registrarUsuario()">Registra tu Cuenta</button>
			</p>
		</div>		
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-saludate" />
		<div class="texto-subintro"></div>
		<div class="texto-subintro"></div>
		<div class="texto-subintro">
		</div>
		<div class="texto-subintro"></div>
		<div class="texto-saludate"></div>
		<div class="texto-saludate"></div>
		<div class="texto-saludate"></div>
		<div class="texto-saludate"></div>

	</div>

	<!-- Modal -->
	<div id="cargandoModal" class="modal fade " role="dialog" tabindex="-1">
	  <div class="modal-dialog modalPrincipal" role="document">
	
	    <!-- Modal content-->
	    <div class="modal-content modelCargando">
	      <div class="modal-header">
	        <h4 class="modal-title">Enviando la Solicitud del Certificado   
	        	<img ng-src='/web-uchile-front-solicitudes/assets/images/3d-loader.gif' height="35" width="35" />
	        </h4>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>