<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html ng-app="solicitudCertificadoExito" lang="en">
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
		<script type="text/javascript" src="/web-uchile-front-solicitudes/main/controllers/solicitudCertificadoExitoController.js?version=1.0.1"></script>

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
		

</head>
	<body class="body" ng-controller="SolicitudCertificadoExitoController" ng-init="leerSolicitudCertificadoExito(); data = {};">
		<div class="banner">
			<img src='/web-uchile-front-solicitudes/administracion-solicitudes/banner_1.jpg' border='0' alt="banner 1" />
		</div>		
		<div class="main-container footer">
			<div class="panel panel-default">
			  <div class="panel-heading">Su solicitud ha sido registrada</div>
			  <div class="panel-body">
					<div class="texto-intro">IMPORTANTE: La respuesta oficial a tu
						solicitud será enviada a tu Correo Electrónico por la Escuela de
						Postgrado de la Facultad de Artes. La Escuela de
						Postgrado es la única fuente de información oficial respecto de la
						tramitación de estas solicitudes.
					</div>		  
			  </div>
			</div>
			<button id="salir" type="button" class="btn botones-abajos" ng-click="cerrarVentana()">Finalizar</button>
		</div>
	</body>
</html>