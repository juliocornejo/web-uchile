<?php 
function obfuscate2($text) {
  $length = strlen($text);
  $scrambled = '';
  
  for ($i = 0; $i < $length; ++$i) {
    $scrambled .= '&#'.ord(substr($text, $i, 1)).';';
  }
  
  return $scrambled;
}
?>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>FácilFood | Pagos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
  </head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<div id="wrap"><div id="logo"></div>
<table id="Tabla_01" width="909" height="758" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="908" height="31" colspan="7">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_01.png" width="908" height="31" alt=""></td>
		<td width="1" height="31">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="31" alt=""></td>
	</tr>
	<tr>
		<td width="11" height="716" rowspan="6">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_02.png" width="11" height="716" alt=""></td>
		<td width="355" height="49" colspan="2" background="sistema/inclusiones/imagenes/promocional/contacto_03.png">
            <object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="355" height="40">
              <param name="movie" value="sistema/inclusiones/flash/boton_index.swf" /><param name="quality" value="high" /><param name="wmode" value="transparent" /><param name="swfversion" value="6.0.65.0" /><!-- Esta etiqueta param indica a los usuarios de Flash Player 6.0 r65 o posterior que descarguen la versin ms reciente de Flash Player. Elimnela si no desea que los usuarios vean el mensaje. --><param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf" /><!-- La siguiente etiqueta object es para navegadores distintos de IE. Ocltela a IE mediante IECC. -->
              <!--[if !IE]>-->
                <object type="application/x-shockwave-flash" data="sistema/inclusiones/flash/boton_index.swf" width="355" height="40">
                <!--<![endif]--><param name="quality" value="high" /><param name="wmode" value="transparent" /><param name="swfversion" value="6.0.65.0" /><param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf" /><!-- El navegador muestra el siguiente contenido alternativo para usuarios con Flash Player 6.0 o versiones anteriores. -->
                <div>
                  <h4>El contenido de esta página requiere una versión más reciente de Adobe Flash Player.</h4>
                  <p>
                    <a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Obtener Adobe Flash Player" width="112" height="33" /></a>
                  </p>
                </div>
                <!--[if !IE]>-->
                </object>
              <!--<![endif]-->
            </object>
          </td>
		<td width="494" height="49" colspan="3" bgcolor="#FFFFFF"></td>
		<td width="48" height="716" rowspan="6">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_05.png" width="48" height="716" alt=""></td>
		<td width="1" height="49">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="49" alt=""></td>
	</tr>
	<tr>
		<td width="849" height="122" colspan="5">
            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="849" height="121" hspace="0" vspace="0" align="top" id="FlashID2">
              <param name="movie" value="sistema/inclusiones/flash/pagar_banner.swf" /><param name="quality" value="high" /><param name="wmode" value="opaque" /><param name="swfversion" value="6.0.65.0" /><!-- Esta etiqueta param indica a los usuarios de Flash Player 6.0 r65 o posterior que descarguen la versión más reciente de Flash Player. Elimínela si no desea que los usuarios vean el mensaje. --><param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf" /><!-- La siguiente etiqueta object es para navegadores distintos de IE. Ocúltela a IE mediante IECC. -->
              <!--[if !IE]>-->
                <object data="sistema/inclusiones/flash/pagar_banner.swf" type="application/x-shockwave-flash" width="849" height="121" hspace="0" vspace="0" align="top">
                <!--<![endif]--><param name="quality" value="high" /><param name="wmode" value="opaque" /><param name="swfversion" value="6.0.65.0" /><param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf" /><!-- El navegador muestra el siguiente contenido alternativo para usuarios con Flash Player 6.0 o versiones anteriores. -->
                <div>
                  <h4>El contenido de esta página requiere una versión más reciente de Adobe Flash Player.</h4>
                  <p>
                    <a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Obtener Adobe Flash Player" width="112" height="33" /></a>
                  </p>
                </div>
                <!--[if !IE]>-->
                </object>
              <!--<![endif]-->
            </object>
          </td>
		<td width="1" height="122">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="122" alt=""></td>
	</tr>
	<tr>
		<td width="34" height="513" rowspan="3">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_07.jpg" width="34" height="513" alt=""></td>
		<td width="815" height="61" colspan="4">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_08.jpg" width="815" height="61" alt=""></td>
		<td width="1" height="61">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="61" alt=""></td>
	</tr>
	<tr>
		<td width="350" height="484" colspan="2" rowspan="3">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_09.jpg" width="350" height="484" alt=""></td>
		<td width="438" height="435" background="sistema/inclusiones/imagenes/promocional/pagos_10.jpg" id="texto_pagos">
                    <p>Como nuestra política es facilitarte la vida, hemos puesto a tu disposición variadas formas de pago.</p>
            <ul>
              <li>
                <b>Depósito bancario:</b>
                al momento de adquirir un plan de FácilFood deposita en la cuenta corriente dada al momento de realizar la suscripción y envíanos el comprobante de pago a <a href="&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#99;&#111;&#110;&#116;&#97;&#99;&#116;&#111;&#64;&#102;&#97;&#99;&#105;&#108;&#102;&#111;&#111;&#100;&#46;&#99;&#108;">&#99;&#111;&#110;&#116;&#97;&#99;&#116;&#111;&#64;&#102;&#97;&#99;&#105;&#108;&#102;&#111;&#111;&#100;&#46;&#99;&#108;</a>
                para habilitar tu cuenta de usuario.
                <br/>
              </li>

              <li>
                <b>Transferencia electrónica:</b>
                FácilFood, pone a tu disposición la tecnología para ahorrar y organizar tu alimentación, de la misma forma virtual en que esto lo puedes hacer, haciendo una transferencia electrónica desde el portal de internet de tu banco personal, sin moverte de tu casa.
                <br/>
              </li>
              <li>
                <b>Fácil, rápido y seguro</b>: escoge la forma que más te acomode con DineroMail puedes cancelar de muchas maneras, tarjetas de casas comerciales, tarjetas bancarias y cupones de pago Servipag.
              </li>
            </ul>

            <br/>
            <br/>
            <p>
              <a href="planes.php"><< VOLVER A LOS PLANES</a>
            </p>

        </td>
		<td width="27" height="452" rowspan="2">
		  <img src="sistema/inclusiones/imagenes/promocional/pagos_11.jpg" width="27" height="452" alt=""></td>
		<td width="1" height="435">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="435" alt=""></td>
	</tr>
	<tr>
		<td width="438" height="49" rowspan="2">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_12.jpg" width="438" height="49" alt=""></td>
		<td width="1" height="17">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="17" alt=""></td>
	</tr>
	<tr>
		<td width="34" height="32">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_13.png" width="34" height="32" alt=""></td>
		<td width="27" height="32">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_14.png" width="27" height="32" alt=""></td>
		<td width="1" height="32">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="32" alt=""></td>
	</tr>
	<tr>
		<td width="908" height="10" colspan="7">
			<img src="sistema/inclusiones/imagenes/promocional/pagos_15.png" width="908" height="10" alt=""></td>
		<td width="1" height="10">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="10" alt=""></td>
	</tr>
	<tr>
		<td width="11" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="11" height="1" alt=""></td>
		<td width="34" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="34" height="1" alt=""></td>
		<td width="321" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="321" height="1" alt=""></td>
		<td width="29" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="29" height="1" alt=""></td>
		<td width="438" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="438" height="1" alt=""></td>
		<td width="27" height="1">
			<img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="27" height="1" alt=""></td>
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
