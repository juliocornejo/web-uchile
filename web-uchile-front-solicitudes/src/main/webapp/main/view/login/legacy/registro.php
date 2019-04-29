<?php 
$plan = $_POST[plan];


require_once ('sistema/inclusiones/xajax/xajax.inc.php'); //incluimos la librelia xajax
include ("sistema/conexion.php");
function ciudades($id_region, $id_ciudad) {
  $respuesta = new xajaxResponse(); //Creamos el objeto xajax
  $inputDestino = "divRegiones"; //indicamos el ID del tag HTML de destino. en este caso el DIV que contiene el selector
  $propiedadInputDestino = "innerHTML"; //indicamos la propiedad que deseamos que se modifique. Colocaremos el selector dentro del DIV
  //indicamos el nuevo valor que este tendrá. Cadena HTML
  include ("sistema/conexion.php");
  $valorAAsignar = '<select id="comunas" name="comunas" style="width:207px">';
  $valorAAsignar .= '<option value="">Selecciona tu comuna...</option>';
  
  $consulta = mysql_query("SELECT * FROM comunas WHERE padre='".$id_region."' ORDER BY nombre ASC") or die (mysql_error());
  while ($Rec = mysql_fetch_array($consulta)) {
    $valorAAsignar .= '<option value="'.$Rec["codigoInterno"].'"';
    if ($id_ciudad == $Rec["codigoInterno"])
      $valorAAsignar .= ' selected="selected"';
    $valorAAsignar .= ' >'.$Rec["nombre"].'</option>';
  }
  $valorAAsignar .= '</select>';

  
  $respuesta->addAssign($inputDestino, $propiedadInputDestino, $valorAAsignar);
  return $respuesta;
  
}


function valida_login($login_usuario, $email) {
  $respuesta2 = new xajaxResponse(); //Creamos el objeto xajax
  
  $propiedadInputDestino = "innerHTML"; //indicamos la propiedad que deseamos que se modifique. Colocaremos el selector dentro del DIV
  //indicamos el nuevo valor que este tendrá. Cadena HTML
  include ("sistema/conexion.php");
  $valorAAsignar = '';
  
  if ($login_usuario != '0' and $email == '0') {
    $inputDestino = "divLogin"; //indicamos el ID del tag HTML de destino. en este caso el DIV que contiene el selector
    $query = "SELECT * FROM usuarios WHERE login_usuario='".$login_usuario."'";
    $consulta = mysql_query($query) or die (mysql_error());
    $array = mysql_fetch_array($consulta);
    if ($array['login_usuario'] == $login_usuario) {
      $valorAAsignar .= '<span style="font-size:10px;color:red">El login ingresado ya existe</span>';
      $valorAAsignar .= '<input type="hidden" name="login_valido" value="1"/>';
    } else {
      $valorAAsignar .= '<input type="hidden" name="login_valido" value="0"/>';
    }
  }

  
  if ($login_usuario == '0' and $email != '0') {
    $inputDestino = "divEmail"; //indicamos el ID del tag HTML de destino. en este caso el DIV que contiene el selector
    $query = "SELECT * FROM usuarios WHERE mail_usuario='".$email."'";
    $consulta = mysql_query($query) or die (mysql_error());
    $array = mysql_fetch_array($consulta);
    if ($array['mail_usuario'] == $email) {
      $valorAAsignar .= '<span style="font-size:10px;color:red">El e-mail ingresado ya existe</span>';
      $valorAAsignar .= '<input type="hidden" name="email_valido" value="1"/>';
    } else {
      $valorAAsignar .= '<input type="hidden" name="email_valido" value="0"/>';
    }
  }
  
  $respuesta2->addAssign($inputDestino, $propiedadInputDestino, $valorAAsignar);
  return $respuesta2;
  
}

$xajax = new xajax(); // Crea un nuevo objeto xajax
$xajax->setCharEncoding("UTF-8"); // le indica la codificación que debe utilizar
$xajax->decodeUTF8InputOn(); // decodifica los caracteres extraños
$xajax->registerFunction("valida_login"); //Registramos la función para indicar que se utilizará con xajax.
$xajax->registerFunction("ciudades"); //Registramos la función para indicar que se utilizará con xajax.
$xajax->processRequests();
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>FácilFood | Registro</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Favicon -->
<link href="favicon.ico" rel="shortcut icon" />
<!-- CSS Web -->
<link href="sistema/inclusiones/css/facilfood.css" rel="stylesheet" type="text/css" />
<!-- Validaciones -->
<script src="sistema/inclusiones/js/validaciones.js" type="text/javascript"></script>
<!-- Valida email -->
<script src="sistema/inclusiones/js/validaEmail.js" type="text/javascript"></script>
<!-- Capitalize -->
<script src="sistema/inclusiones/js/capitalize.js" type="text/javascript"></script>
<!-- Solo letras -->
<script src="sistema/inclusiones/js/soloLetras.js" type="text/javascript"></script>
<!-- Mootools -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/mootools/1.2.3/mootools-yui-compressed.js"></script>
<!-- Sexy Lightbox 2 -->
<script type="text/javascript" src="sistema/inclusiones/sexy-lightbox/sexylightbox.v2.3.mootools.js"></script>
<!-- Sexy Lightbox 2 CSS -->
<link rel="stylesheet" href="sistema/inclusiones/sexy-lightbox/sexylightbox.css" type="text/css" media="all" />
<?php $xajax->printJavascript("sistema/inclusiones/xajax"); //imprime el codigo javascript necesario para que funcione todo. ?>
</head>
<body bgcolor="#FFFFFF">
<div id="wrap">
  <div id="logo"></div>
  <table id="Tabla_01" width="909" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="908" height="31" colspan="4" style="background-image:url(sistema/inclusiones/imagenes/promocional/registro_01.png)"></td>
      <td width="1" height="31"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="31" alt="" /></td>
    </tr>
    <tr>
      <td width="11" height="706" rowspan="4" style="background-image:url(sistema/inclusiones/imagenes/promocional/registro_02.png)"></td>
      <td width="355" height="49" style="background-image:url(sistema/inclusiones/imagenes/promocional/registro_03.png)"><object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="355" height="40">
          <param name="movie" value="sistema/inclusiones/flash/boton_index.swf" />
          <param name="quality" value="high" />
          <param name="wmode" value="transparent" />
          <param name="swfversion" value="6.0.65.0" />
          <!-- Esta etiqueta param indica a los usuarios de Flash Player 6.0 r65 o posterior que descarguen la versión más reciente de Flash Player. Elimínela si no desea que los usuarios vean el mensaje. -->
          <param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf" />
          <!-- La siguiente etiqueta object es para navegadores distintos de IE. Ocúltela a IE mediante IECC. -->
          <!--[if !IE]>-->
          <object type="application/x-shockwave-flash" data="sistema/inclusiones/flash/boton_index.swf" width="355" height="40">
            <!--<![endif]-->
            <param name="quality" value="high" />
            <param name="wmode" value="transparent" />
            <param name="swfversion" value="6.0.65.0" />
            <param name="expressinstall" value="sistema/inclusiones/scripts/expressInstall.swf" />
            <!-- El navegador muestra el siguiente contenido alternativo para usuarios con Flash Player 6.0 o versiones anteriores. -->
            <div>
              <h4>El contenido de esta p&aacute;gina requiere una versi&oacute;n m&aacute;s reciente de Adobe Flash Player.</h4>
              <p> <a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Obtener Adobe Flash Player" width="112" height="33" /></a> </p>
            </div>
            <!--[if !IE]>-->
          </object>
          <!--<![endif]-->
        </object></td>
      <td width="494" height="49" style="background-image:url(sistema/inclusiones/imagenes/promocional/registro_04.png)" align="left"></td>
      <td width="48" height="123" rowspan="2" style="background-image:url(sistema/inclusiones/imagenes/promocional/registro_05.png)"></td>
      <td width="1" height="49"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="49" alt="" /></td>
    </tr>
    <tr>
      <td width="849" height="122" colspan="2" rowspan="2"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="849" height="121" hspace="0" vspace="0" align="top" id="FlashID2">
          <param name="movie" value="sistema/inclusiones/flash/registro_banner.swf" />
          <param name="quality" value="high" />
          <param name="wmode" value="opaque" />
          <param name="swfversion" value="6.0.65.0" />
          <!-- Esta etiqueta param indica a los usuarios de Flash Player 6.0 r65 o posterior que descarguen la versión más reciente de Flash Player. Elimínela si no desea que los usuarios vean el mensaje. -->
          <param name="expressinstall" value="../Scripts/expressInstall.swf" />
          <!-- La siguiente etiqueta object es para navegadores distintos de IE. Ocúltela a IE mediante IECC. -->
          <!--[if !IE]>-->
          <object data="sistema/inclusiones/flash/registro_banner.swf" type="application/x-shockwave-flash" width="849" height="121" hspace="0" vspace="0" align="top">
            <!--<![endif]-->
            <param name="quality" value="high" />
            <param name="wmode" value="opaque" />
            <param name="swfversion" value="6.0.65.0" />
            <param name="expressinstall" value="../Scripts/expressInstall.swf" />
            <!-- El navegador muestra el siguiente contenido alternativo para usuarios con Flash Player 6.0 o versiones anteriores. -->
            <div>
              <h4>El contenido de esta página requiere una versión más reciente de Adobe Flash Player.</h4>
              <p> <a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Obtener Adobe Flash Player" width="112" height="33" /></a> </p>
            </div>
            <!--[if !IE]>-->
          </object>
          <!--<![endif]-->
        </object></td>
      <td width="1" height="74"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="74" alt="" /></td>
    </tr>
    <tr>
      <td width="48" height="583" rowspan="2" style="background-image:url(sistema/inclusiones/imagenes/promocional/registro_07.png)"></td>
      <td width="1" height="48"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="48" alt="" /></td>
    </tr>
    <tr>
      <td width="849" colspan="2" align="center" valign="top" id="Tabla_registro"><div> <img src="sistema/inclusiones/imagenes/promocional/titulo_registro.gif" width="410" height="31" alt="" /> </div>
        <div id="div">
          <form name="formulario" method="post" action="registro2.php?variable=registro" onsubmit="return validaRegistro()">
            <table width="100%" border="0" align="center">
              <tr class="tabla">
                <td width="173" align="left"><label for="nombre_usuario">Nombre: *</label></td>
                <td align="left" colspan="2"><input type="text" name="nombre_usuario" id="nombre_usuario" onkeypress="return soloLetras(event);" onchange="capitalize(this);" style="width:200px"/></td>
                <td width="204" align="left"><span class="validacion" id="validanombre">Ingresa tu nombre</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="apellido_usuario">Apellidos: *</label></td>
                <td align="left" colspan="2"><input name="apellido_usuario" id="apellido_usuario" type="text" onchange="capitalize(this);" style="width:200px" onkeypress="return soloLetras(event);"/></td>
                <td align="left"><span class="validacion" id="validaapellidos">Ingresa tus apellidos</span></td>
              </tr>
              <tr class="tabla">
                <td align="left">Sexo: *</td>
                <td align="left" colspan="2"><input name="sexo" id="masculino" type="radio" value="Masculino" />
                  <label for="masculino">Masculino</label>
                  <input name="sexo" id="femenino" type="radio" value="Femenino" />
                  <label for="femenino">Femenino</label></td>
                <td align="left"><span class="validacion" id="validasexo">Selecciona tu sexo</span></td>
              </tr>
              <tr class="tabla">
                <td align="left">Fecha de nacimiento: *</td>
                <td align="left" colspan="2"><select name="dia">
                    <option value="">Día</option>
                    <?php 
                        for ($i = 1; $i <= 31; $i++) {
                          if (strlen($i) < 2) {
                            echo '<option value="0'.$i.'">0'.$i.'</option>';
                          } else {
                            echo '<option value="'.$i.'">'.$i.'</option>';
                          }
                        }
                        ?>
                  </select>
                  <select name="mes">
                    <option value="">Mes</option>
                    <option value="01">Enero</option>
                    <option value="02">Febrero</option>
                    <option value="03">Marzo</option>
                    <option value="04">Abril</option>
                    <option value="05">Mayo</option>
                    <option value="06">Junio</option>
                    <option value="07">Julio</option>
                    <option value="08">Agosto</option>
                    <option value="09">Septiembre</option>
                    <option value="10">Octubre</option>
                    <option value="11">Noviembre</option>
                    <option value="12">Diciembre</option>
                  </select>
                  <select name="ano">
                    <option value="">Año</option>
                    <?php 
                        for ($i = 2009; $i >= 1900; $i--) {
                          echo '<option value="'.$i.'">'.$i.'</option>';
                        }
                        ?>
                  </select></td>
                <td align="left"><span class="validacion" id="validanacimiento">Selecciona tu fecha de nacimiento</span> <span class="validacion" id="validanacimientoano">Selecciona tu año de nacimiento</span> <span class="validacion" id="validanacimientomes">Selecciona tu mes de nacimiento</span> <span class="validacion" id="validanacimientodia">Selecciona tu día de nacimiento</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="login_usuario">Nombre de usuario: *</label></td>
                <td align="left" colspan="2"><input name="login_usuario" id="login_usuario" type="text" style="width:200px" onchange="xajax_valida_login(this.value,'0');"/></td>
                <td align="left"><div id="divLogin">
                    <input type="hidden" name="login_valido" value="0"/>
                  </div>
                  <span class="validacion" id="validalogin">Ingresa un nombre de usuario</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="password_usuario">Contraseña: *</label></td>
                <td align="left" colspan="2"><input name="password_usuario" id="password_usuario" type="password" style="width:200px"/></td>
                <td align="left"><span class="validacion" id="validacontrasena">Ingresa una contraseña</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="password_usuario2">Confirmar contraseña: *</label></td>
                <td align="left" colspan="2"><input name="password_usuario2" id="password_usuario2" type="password" style="width:200px"/></td>
                <td align="left"><span class="validacion" id="validacontrasena2">Ingresa nuevamente la contraseña</span> <span class="validacion" id="validacontrasena3">Las contraseñas ingresadas no coinciden</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="mail_usuario">Email: *</label></td>
                <td align="left" colspan="2"><input name="mail_usuario" id="mail_usuario" type="text" style="width:200px" onchange="xajax_valida_login('0',this.value)"/></td>
                <td align="left"><div id="divEmail">
                    <input type="hidden" name="email_valido" value="0"/>
                  </div>
                  <span class="validacion" id="validaemail">Ingresa tu email</span> <span class="validacion" id="validaemail1">El email ingresado no es válido</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="mail_usuario2">Confirmar email: *</label></td>
                <td align="left" colspan="2"><input name="mail_usuario2" id="mail_usuario2" type="text" style="width:200px"/></td>
                <td align="left"><span class="validacion" id="validaemail2">Ingresa nuevamente tu email</span> <span class="validacion" id="validaemail3">Los email ingresados no coinciden</span> <span class="validacion" id="validaemail4">El email ingresado no es válido</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="regiones">Región: *</label></td>
                <td align="left" colspan="2"><?php 
                      include "sistema/conexion.php";
                      $query = "select * from regiones order by nombre";
                      $resultado = mysql_query($query) or die (mysql_error());
                      
                      ?>
                  <select id="regiones" name="regiones" size="1" onchange="xajax_ciudades(this.value,'-1')" style="width:207px">
                    <option value="">Seleccione tu región...</option>
                    <?php 
                        while ($fila = mysql_fetch_array($resultado)) {
                          
                        ?>
                    <option value="<?php echo $fila['codigo'];?>"><?php echo $fila['nombre']; ?></option>
                    <?php } ?>
                  </select></td>
                <td align="left"><span class="validacion" id="validaregion">Selecciona tu región</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="comunas">Comuna: *</label></td>
                <td align="left" colspan="2"><div id="divRegiones">
                    <select id="comunas" name="comunas" style="width:207px">
                      <option value="">Selecciona tu comuna...</option>
                    </select>
                  </div></td>
                <td align="left"><span class="validacion" id="validaciudad">Selecciona tu comuna</span></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="plan">Plan: *</label></td>
                <td align="left" colspan="2"><select name="plan" id="plan" style="width:207px">
                    <option value="mensual"<?php if ($plan == 'mensual') echo selected; ?>>Mensual</option>
                    <option value="semestral"<?php if ($plan == 'semestral') echo selected; ?>>Semestral</option>
                    <option value="anual"<?php if ($plan == 'anual') echo selected; ?>>Anual</option>
                  </select></td>
                <td align="left"></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="pago">Forma de pago: *</label></td>
                <td align="left" colspan="2"><select name="pago" id="pago" style="width:207px">
                    <option value="transferencia">Transferencia</option>
                    <option value="deposito">Deposito</option>
                    <option value="dineromail">DineroMail</option>
                  </select></td>
                <td align="left"></td>
              </tr>
              <tr class="tabla">
                <td align="left"><label for="comosupo">¿Cómo supo de nosotros?</label></td>
                <td align="left" colspan="2"><select name="comosupo" id="comosupo" style="width:207px" onchange="if(this.value == 'Otro') document.getElementById('otro').style.visibility = 'visible'; else document.getElementById('otro').style.visibility = 'hidden';">
                    <option value="">-Opciones-</option>
                    <option value="Buscador">Buscador</option>
                    <option value="Amigo o conocido">Amigo o conocido</option>
                    <option value="Publicidad">Publicidad</option>
                    <option value="Otro">Otro</option>
                  </select></td>
                <td align="left"></td>
              </tr>
              <tr id="otro" style="visibility:hidden">
                <td align="left"><label for="otro">Especifique: *</label></td>
                <td colspan="2" align="left"><input type="text" name="otro" style="width:200px"/></td>
                <td></td>
              </tr>
              <tr class="tabla">
                <td colspan="3" align="center"><input type="checkbox" name="acepto" id="acepto"/>
                  <label for="acepto"> Estoy de acuerdo con las <a href="condiciones.php" target="_blank">Condiciones de uso</a>. </label></td>
                <td align="left"><span class="validacion" id="validaacepto">Debes aceptar las condiciones de uso</span></td>
              </tr>
              <tr class="tabla">
                <td colspan="3" align="center"><input name="ingresar" type="image" src="sistema/inclusiones/imagenes/botones/enviar.png" title="Enviar" alt="enviar" /></td>
                <td></td>
              </tr>
              <tr>
                <td colspan="3" align="center"><p class="pie"> <b>Los campos marcados con * son obligatorios.</b> </p></td>
                <td></td>
              </tr>
            </table>
          </form>
        </div></td>
      <td width="1" height="535"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="535" alt="" /></td>
    </tr>
    <tr>
      <td width="908" height="20" colspan="4" style="background-image:url(sistema/inclusiones/imagenes/promocional/registro_09.png)"></td>
      <td width="1" height="20"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="1" height="20" alt="" /></td>
    </tr>
    <tr>
      <td width="11" height="1"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="11" height="1" alt="" /></td>
      <td width="355" height="1"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="355" height="1" alt="" /></td>
      <td width="494" height="1"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="494" height="1" alt="" /></td>
      <td width="48" height="1"><img src="sistema/inclusiones/imagenes/promocional/espacio.gif" width="48" height="1" alt="" /></td>
      <td width="1" height="1"></td>
    </tr>
  </table>
  <?php include ("pie.php"); ?>
</div>
<script type="text/javascript">
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
