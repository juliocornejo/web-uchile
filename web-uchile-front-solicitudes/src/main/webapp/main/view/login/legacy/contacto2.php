<?php 
$destinatario = "contacto@facilfood.cl";
$subject = "Contacto";
$desde = "From: ".$_POST["email"]."\nContent-Type: text/html; charset=utf-8";
$contingut = 'El siguiente mensaje fue enviado por '.$_POST["nombre"].':<br/><br/>';
$contingut .= $_POST['mensaje'];
mail($destinatario, $subject, $contingut, $desde);
?>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>FácilFood | Contacto</title>
    <!-- jQuery -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
    <!-- jQuery Alerts CSS -->
    <link href="sistema/inclusiones/jquery-alerts/jquery.alerts.css" rel="stylesheet" type="text/css"/>
    <!-- jQuery Alerts -->
    <script src="sistema/inclusiones/jquery-alerts/jquery.alerts.js" type="text/javascript"></script>
  </head>
  <body>
    <script type="text/javascript">
      jAlert('Su mensaje fue enviado correctamente.', 'Mensaje enviado', function(){
        window.open('contacto.php', '_self');
      });
    </script>
  </body>
</html>
