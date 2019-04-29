<?php 
session_start();
include "sistema/conexion.php";
date_default_timezone_set('America/Santiago');
$email_usuario = $_POST['mail_usuario'];

$query = "SELECT login_usuario, password_usuario FROM usuarios WHERE mail_usuario='$email_usuario' LIMIT 1";
$result = mysql_query($query) or die (mysql_error());
$fila = mysql_fetch_row($result);
if (mysql_num_rows($result) != 0) {
  // Envio de correo al usuario
  $destinatario = $email_usuario;
  $subject = "Recordatorio datos de su cuenta FácilFood";
  $headers = "From: Soporte FácilFood <soporte@facilfood.cl>\nContent-Type: text/html; charset=utf-8";
  $varaiable = 'olvido_pass';
  include ("sistema/correo.php");
  mail($destinatario, $subject, $contingut, $headers);
} else {
  // El correo electronico no existe
  $destinatario = $email_usuario;
  $subject = "Recordatorio datos de su cuenta FácilFood";
  $headers = "From: Soporte FácilFood <soporte@facilfood.cl>\nContent-Type: text/html; charset=utf-8";
  $varaiable = 'olvido_pass_noexiste';
  include ("sistema/correo.php");
  mail($destinatario, $subject, $contingut, $headers);
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FácilFood | ¿Olvido su contraseña?</title>
<!-- CSS Web -->
<link href="sistema/inclusiones/css/facilfood.css" rel="stylesheet" type="text/css" />
<!-- Validaciones -->
<script src="sistema/inclusiones/js/validaciones.js" type="text/javascript"></script>
<!-- jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
<!-- jQuery Alerts CSS -->
<link href="sistema/inclusiones/jquery-alerts/jquery.alerts.css" rel="stylesheet" type="text/css"/>
<!-- jQuery Alerts -->
<script src="sistema/inclusiones/jquery-alerts/jquery.alerts.js" type="text/javascript"></script>
</head>
<body>
<script type="text/javascript">
      jAlert('Tus datos de ingreso fueron enviados a la dirección de correo proporcionado.', 'Datos enviados', function(){
        window.open('olvido-contrasena.php', '_top');
      });
    </script>
</body>
</html>
