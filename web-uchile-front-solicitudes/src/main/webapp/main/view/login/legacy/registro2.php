<?php 
session_start();
if ($_GET[variable] != registro) {
  header("Location: index.php");
} else {
  include "sistema/conexion.php";
  date_default_timezone_set('America/Santiago');
  // Obtengo el nombre de la región
  $query = "SELECT * FROM regiones where codigo = ".$_POST['regiones'];
  $result = mysql_query($query) or die (mysql_error());
	if (!$result) {
    echo 'Could not run query: ' . mysql_error();
    exit;
	}
  $rs = mysql_fetch_row($result);
  $region = $rs[1];
  // Obtengo el nombre de la comuna
  $query2 = "SELECT * FROM comunas where codigoInterno = ".$_POST['comunas'];
  $result2 = mysql_query($query2) or die (mysql_error());
  $rs2 = mysql_fetch_row($result2);
	if (!$rs2) {
    echo 'Could not run query: ' . mysql_error();
    exit;
	}
  $ciudad = $rs2[1];
  // Recibo los datos del formulario
  $nombre_usuario = $_POST['nombre_usuario'];
  $apellido_usuario = $_POST['apellido_usuario'];
  $sexo_usuario = $_POST['sexo'];
  $nacimiento_usuario = $_POST['dia'].'/'.$_POST['mes'].'/'.$_POST['ano'];
  $login_usuario = $_POST['login_usuario'];
  $password_usuario = $_POST['password_usuario'];
  $mail_usuario = $_POST['mail_usuario'];
  $region_usuario = $_POST['regiones'];
  $ciudad_usuario = $_POST['comunas'];
  $plan_usuario = $_POST['plan'];
  $pago_usuario = $_POST['pago'];
  if ($_POST['comosupo'] == 'Otro') {
    $comosupo_usuario = $_POST['comosupo'].': '.$_POST['otro'];
  } else {
    $comosupo_usuario = $_POST['comosupo'];
  }
  $fecha_usuario = date("d/m/Y");
  mysql_query($query) or die (mysql_error());
  $query = "INSERT INTO usuarios 
	(nombre_usuario,
	apellido_usuario,
	sexo_usuario,
	nacimiento_usuario,
	login_usuario,
	password_usuario,
	region_usuario,
	ciudad_usuario,
	plan_usuario,
	pago_usuario,
	mail_usuario,
	nivel_usuario,
	estado_usuario,
	fecha_usuario,
	comosupo_usuario)
	values 
	('$nombre_usuario',
	'$apellido_usuario',
	'$sexo_usuario',
	'$nacimiento_usuario',
	'$login_usuario',
	'$password_usuario',
	'$region_usuario',
	'$ciudad_usuario',
	'$plan_usuario',
	'$pago_usuario',
	'$mail_usuario',
	'2',
	'Inactivo',
	'$fecha_usuario',
	'$comosupo_usuario')";
  // Envio de correo al usuario
  $destinatario = $mail_usuario;
  $subject = "Su cuenta FácilFood";
  $headers = "From: Ventas FácilFood <ventas@facilfood.cl>\nContent-Type: text/html; charset=utf-8";
  $varaiable = 'registro_usuario';
  include ("sistema/correo.php");
  mysql_query($query) or die (mysql_error());
  mail($destinatario, $subject, $contingut, $headers);
  // Envio de correo al administrador
  $destinatario = "ventas@facilfood.cl";
  $subject = "Nuevo usuario registrado";
  $headers = "From: Ventas FácilFood <ventas@facilfood.cl>\nContent-Type: text/html; charset=utf-8";
  $varaiable = 'registro_admin';
  include ("sistema/correo.php");
  mail($destinatario, $subject, $contingut, $headers);
  
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FácilFood | Registro</title>
<!-- jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
<!-- jQuery Alerts CSS -->
<link href="sistema/inclusiones/jquery-alerts/jquery.alerts.css" rel="stylesheet" type="text/css"/>
<!-- jQuery Alerts -->
<script src="sistema/inclusiones/jquery-alerts/jquery.alerts.js" type="text/javascript"></script>
</head>
<body>
<?php 
    if ($_POST['pago'] == 'dineromail') {
      if ($_POST['plan'] == 'anual') {
        
    ?>
<form name="formulario1" action='https://chile.dineromail.com/Shop/Shop_Ingreso.asp' method='post'>
  <input type='hidden' name='NombreItem' value='Membresia anual FacilFood'>
  <input type='hidden' name='TipoMoneda' value='1'>
  <input type='hidden' name='PrecioItem' value='29700.00'>
  <input type='hidden' name='E_Comercio' value='116229'>
  <input type='hidden' name='NroItem' value='-'>
  <input type='hidden' name='DireccionExito' value='http://'>
  <input type='hidden' name='DireccionFracaso' value='http://'>
  <input type='hidden' name='DireccionEnvio' value='1'>
  <input type='hidden' name='Mensaje' value='1'>
  <input type='hidden' name='MediosPago' value='4,5,6,21,23,2,7'>
</form>
<script type="text/javascript">
      jAlert('Su cuenta de usuario ha sido creada correctamente.<br/><br/>A continuación se redirigirá a la página de DineroMail para efectuar el pago.', 'Usuario registrado', function(){
        document.formulario1.submit();
      });
    </script>
<?php 
    }
    if ($_POST['plan'] == 'semestral') {
      
    ?>
<form name="formulario2" action='https://chile.dineromail.com/Shop/Shop_Ingreso.asp' method='post'>
  <input type='hidden' name='NombreItem' value='Membresia semestral FacilFood'>
  <input type='hidden' name='TipoMoneda' value='1'>
  <input type='hidden' name='PrecioItem' value='19800.00'>
  <input type='hidden' name='E_Comercio' value='116229'>
  <input type='hidden' name='NroItem' value='-'>
  <input type='hidden' name='DireccionExito' value='http://'>
  <input type='hidden' name='DireccionFracaso' value='http://'>
  <input type='hidden' name='DireccionEnvio' value='1'>
  <input type='hidden' name='Mensaje' value='1'>
  <input type='hidden' name='MediosPago' value='4,5,6,21,23,2,7'>
</form>
<script type="text/javascript">
      jAlert('Su cuenta de usuario ha sido creada correctamente.<br/><br/>A continuación se redirigirá a la página de DineroMail para efectuar el pago.', 'Usuario registrado', function(){
        document.formulario2.submit();
      });
    </script>
<?php 
    }
    if ($_POST['plan'] == 'mensual') {
      
    ?>
<form name="formulario3" action='https://chile.dineromail.com/Shop/Shop_Ingreso.asp' method='post'>
  <input type='hidden' name='NombreItem' value='Membresia mensual FacilFood'>
  <input type='hidden' name='TipoMoneda' value='1'>
  <input type='hidden' name='PrecioItem' value='4950.00'>
  <input type='hidden' name='E_Comercio' value='116229'>
  <input type='hidden' name='NroItem' value='-'>
  <input type='hidden' name='DireccionExito' value='http://'>
  <input type='hidden' name='DireccionFracaso' value='http://'>
  <input type='hidden' name='DireccionEnvio' value='1'>
  <input type='hidden' name='Mensaje' value='1'>
  <input type='hidden' name='MediosPago' value='4,5,6,21,23,2,7'>
</form>
<script type="text/javascript">
      jAlert('Su cuenta de usuario ha sido creada correctamente.<br/><br/>A continuación se redirigirá a la página de DineroMail para efectuar el pago.', 'Usuario registrado', function(){
        document.formulario3.submit();
      });
    </script>
<?php 
    }
    } else {
      
    ?>
<form name="formulario" method="post" action="bancos.php?variable=registro">
  <input type="hidden" name="tipo" value="<?php echo $_POST['pago'];?>" />
  <input type="hidden" name="periodo" value="<?php echo $_POST['plan'];?>" />
  <input type="hidden" name="nombre_usuario" value="<?php echo $nombre_usuario;?>" />
  <input type="hidden" name="email_usuario" value="<?php echo $mail_usuario;?>" />
  <input type="hidden" name="apellido_usuario" value="<?php echo $apellido_usuario;?>" />
</form>
<script type="text/javascript">
      jAlert('Su cuenta de usuario fue creada correctamente.<br/>Revise su correo en los proximos minutos para recibir más información.<br/><br/>*Si el correo no se encuentra en su bandeja de entrada, revise su carpeta de "Spam".', 'Usuario registrado', function(){
        document.formulario.submit();
      });
    </script>
<?php 
    }
    ?>
</body>
</html>
<?php } ?>