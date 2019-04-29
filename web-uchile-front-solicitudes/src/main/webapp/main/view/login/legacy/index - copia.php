<?php 
session_start();
if ($_COOKIE['id_usuario'] != "") {
  $_SESSION['id_usuario'] = $_COOKIE['id_usuario'];
  $_SESSION['login'] = $_COOKIE['login'];
  $_SESSION['nombre_user'] = $_COOKIE["nombre"];
  $_SESSION['apellido'] = $_COOKIE["apellido"];
  $_SESSION['nivel'] = $_COOKIE["nivel"];
  $_SESSION['estado'] = $_COOKIE["estado"];
  header("location:sistema/index.php");
}
?>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="google-site-verification" content="nAZ57ZS-HG8y1XKxVFRt6BMTFBlxWBbzlaI-J_vSXOU" />
    <title>FácilFood | Planificar es la receta</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="planificar, planificacion, recetas, comidas, cocinar, ingredientes, alimentos, cocina, ahorro, sano" />
    <meta name="description" content="La solución para ahorrar tiempo y dinero, planificando y gestionando tus comidas." />
	<!-- Google Webmasters -->
    <meta name="verify-v1" content="PPOA+KiLE8a9rXJcxLA688+EPu8h4jKQ8LPN7IBSe7Q=" />
	<!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico" />
	<!-- CSS Web -->
    <link href="sistema/inclusiones/css/facilfood.css" rel="stylesheet" type="text/css" />
	<!-- Mootools -->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/mootools/1.2.3/mootools-yui-compressed.js"></script>
	<!-- Sexy Lightbox 2 -->
    <script type="text/javascript" src="sistema/inclusiones/sexy-lightbox/sexylightbox.v2.3.mootools.js"></script>
	<!-- Sexy Lightbox 2 CSS -->
    <link rel="stylesheet" href="sistema/inclusiones/sexy-lightbox/sexylightbox.css" type="text/css" media="all" />
    <script src="sistema/inclusiones/scripts/swfobject_modified.js" type="text/javascript"></script>
  </head>
  <body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
    <div id="wrap"><div id="logo"></div>
  <table id="Tabla_01" width="909" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="908" height="31" colspan="7">
        <img src="sistema/inclusiones/imagenes/promocional/index_01.png" width="908" height="31" alt="" /></td>
      <td width="1" height="31">
        <img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="31" alt="" /></td>
    </tr>
    <tr>
      <td width="11" height="716" rowspan="5">
        <img src="sistema/inclusiones/imagenes/promocional/index_02.png" width="11" height="716" alt="" /></td>
      <td width="355" height="49" colspan="2" style="background-image:url(sistema/inclusiones/imagenes/promocional/contacto_03.png)"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="355" height="40" align="absbottom" id="FlashID">
		  <param name="movie" value="sistema/inclusiones/flash/boton_index.swf">
		  <param name="quality" value="high">
		  <param name="wmode" value="transparent">
		  <param name="swfversion" value="6.0.65.0">
		  <!-- Esta etiqueta param indica a los usuarios de Flash Player 6.0 r65 o posterior que descarguen la versión más reciente de Flash Player. Elimínela si no desea que los usuarios vean el mensaje. -->
		  <param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf">
		  <!-- La siguiente etiqueta object es para navegadores distintos de IE. Ocúltela a IE mediante IECC. -->
		  <!--[if !IE]>-->
		  <object data="sistema/inclusiones/flash/boton_index.swf" type="application/x-shockwave-flash" width="355" height="40" align="absbottom">
		    <!--<![endif]-->
		    <param name="quality" value="high">
		    <param name="wmode" value="transparent">
		    <param name="swfversion" value="6.0.65.0">
		    <param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf">
		    <!-- El navegador muestra el siguiente contenido alternativo para usuarios con Flash Player 6.0 o versiones anteriores. -->
		    <div>
		      <h4>El contenido de esta p&aacute;gina requiere una versi&oacute;n m&aacute;s reciente de Adobe Flash Player.</h4>
		      <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Obtener Adobe Flash Player" width="112" height="33" /></a></p>
	        </div>
		    <!--[if !IE]>-->
	      </object>
		  <!--<![endif]-->
	    </object></td>
		<td width="494" height="49" colspan="3" background="sistema/inclusiones/imagenes/promocional/index_04.png">
    	<table width="100" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>
                  <div align="center">
                    <a href="que-es.php" onmouseout="Image23.src='sistema/inclusiones/imagenes/como_3.png';" onmouseover="Image23.src='sistema/inclusiones/imagenes/como_4.png';"><img src="sistema/inclusiones/imagenes/como_3.png" name="Image23" border="0" id="Image23" alt="¿Qué es?" /></a>
                  </div>
                </td>
                  <td>
                  <div align="center"></div>
                </td>
              </tr>
            </table>
    </td>
		<td width="48" height="717" rowspan="6">
			<img src="sistema/inclusiones/imagenes/promocional/index_05.png" width="48" height="717" alt=""></td>
		<td width="1" height="49">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="49" alt=""></td>
	</tr>
	<tr>
		<td width="849" height="245" colspan="5">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="849" height="245" hspace="0" vspace="0" align="top" id="FlashID2">
        <param name="movie" value="sistema/inclusiones/flash/index_banner.swf" />
        <param name="quality" value="high" />
        <param name="wmode" value="opaque" />
        <param name="swfversion" value="6.0.65.0" />
        <!-- Esta etiqueta param indica a los usuarios de Flash Player 6.0 r65 o posterior que descarguen la versión más reciente de Flash Player. Elimínela si no desea que los usuarios vean el mensaje. -->
        <param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf" />
        <!-- La siguiente etiqueta object es para navegadores distintos de IE. Ocúltela a IE mediante IECC. -->
        <!--[if !IE]>-->
        <object data="sistema/inclusiones/flash/index_banner.swf" type="application/x-shockwave-flash" width="849" height="245" hspace="0" vspace="0" align="top">
          <!--<![endif]-->
          <param name="quality" value="high" />
          <param name="wmode" value="opaque" />
          <param name="swfversion" value="6.0.65.0" />
          <param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf" />
          <!-- El navegador muestra el siguiente contenido alternativo para usuarios con Flash Player 6.0 o versiones anteriores. -->
          <div>
            <h4>El contenido de esta página requiere una versión más reciente de Adobe Flash Player.</h4>
            <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Obtener Adobe Flash Player" width="112" height="33" /></a></p>
            </div>
          <!--[if !IE]>-->
          </object>
        <!--<![endif]-->
      </object></td>
		<td width="1" height="245">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="245" alt=""></td>
	</tr>
	<tr>
		<td width="581" height="146" colspan="4" background="sistema/inclusiones/imagenes/promocional/index_07.jpg"></td>
		<td width="268" height="422" rowspan="3">
<a href="planes.php"><img src="sistema/inclusiones/imagenes/promocional/index_08.jpg" alt="" width="268" height="422" border="0"></a></td>
		<td width="1" height="146">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="146" alt=""></td>
	</tr>
	<tr>
		<td width="56" height="276" rowspan="2" background="sistema/inclusiones/imagenes/promocional/index_09.jpg"></td>
		<td width="318" height="42" colspan="2" background="sistema/inclusiones/imagenes/promocional/index_10.jpg"></td>
		<td width="207" height="276" rowspan="2" background="sistema/inclusiones/imagenes/promocional/index_11.jpg"></td>
		<td width="1" height="42">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="42" alt=""></td>
	</tr>
	<tr>
<td width="318" height="234" colspan="2" valign="top" background="sistema/inclusiones/imagenes/promocional/index_12.jpg" id="lista" onclick="window.location.href='que-es.php'" style="cursor:pointer"></td>
		<td width="1" height="234">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="234" alt=""></td>
	</tr>
	<tr>
		<td width="860" height="10" colspan="6" rowspan="2" background="sistema/inclusiones/imagenes/promocional/index_13.png"></td>
		<td width="1" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="1" alt=""></td>
	</tr>
	<tr>
		<td width="48" height="9">
			<img src="sistema/inclusiones/imagenes/promocional/index_14.png" width="48" height="9" alt=""></td>
		<td width="1" height="9">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="9" alt=""></td>
	</tr>
	<tr>
		<td width="11" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="11" height="1" alt=""></td>
		<td width="56" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="56" height="1" alt=""></td>
		<td width="299" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="299" height="1" alt=""></td>
		<td width="19" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="19" height="1" alt=""></td>
		<td width="207" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="207" height="1" alt=""></td>
		<td width="268" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="268" height="1" alt=""></td>
		<td width="48" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="48" height="1" alt=""></td>
		<td width="1" height="1"></td>
	</tr>
</table>
      <?php include ("pie.php"); ?>
    </div>
	<script type="text/javascript">
      // Iniciamos Sexy Lightbox 2
      window.addEvent('domready', function(){
        SexyLightbox = new SexyLightBox({
          imagesdir: 'sistema/inclusiones/sexy-lightbox/sexyimages',
		  'Skin' : { 'verde' : {
          'hexcolor': '#A0D218',
          'captionColor': '#FFFFFF',
	        'background-color': '#FFF',
	        'opacity': 0.6
	       }},
	       'color' : 'verde'
        });
      });
    </script>
  </body>
</html>