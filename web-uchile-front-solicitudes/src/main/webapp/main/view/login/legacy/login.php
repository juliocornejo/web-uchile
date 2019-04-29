<div id="Sexy-login" class="login">
  <form action="sistema/comprueba.php" name="formulario" method="post" id="loginform">
    <table>
      <tr>
        <td><label for="login"><font size="2">Nombre de usuario:</font></label></td>
        <td><input name="login" id="login" type="text" style="width:150px;" /></td>
      </tr>
      <tr>
        <td><label for="pass"><font size="2">Contraseña:</font></label></td>
        <td><input name="pass" id="pass" type="password" style="width:150px;" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><a href="olvido-contrasena.php"><font size="-6">¿Olvidó su contraseña?</font></a></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input name="recor" id="recor" type="checkbox" onclick="cambiar();">
          <label for="recor"><font size="2">Recordar mis datos en este equipo.</font></label>
          <input type="hidden" name="recordar" value="" id="recordar"></td>
      </tr>
      <br/>
      <tr>
        <td colspan="2" align="center"><input type="image" src="sistema/inclusiones/imagenes/botones/iniciarSesion.png" title="Iniciar sesión" alt="Iniciar sesión" onclick="return SexyLoginInit();"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center"></td>
      </tr>
    </table>
    <input type="hidden" value="" id="evaluando" name="evaluando" />
  </form>
</div>
<div id="Sexy-loading" class="login loading" style="display:none;"> Cargando... </div>
<div id="Sexy-error" class="login error" style="display:none;"> Nombre de usuario o contraseña incorrectos. <br />
  <br />
  <a href="#" id="again">¿Deseas volver a intentarlo?</a> </div>
<div id="Sexy-inactivo" class="login error" style="display:none;"> El usuario se encuentra inactivo hasta confirmar el pago. <br />
  <br />
</div>
<script type="text/javascript">
function cambiar()
{
if (document.getElementById('recor').checked)
	document.getElementById('recordar').value="recordar";
else
	document.getElementById('recordar').value="";
}
	var Sexy_FirstTime = 0;	
	function SexyLoginInit() {
		if(Sexy_FirstTime) {
			$('loginform').send();
			return false;
		} else {
			Sexy_FirstTime = 1;
		}  
		$('again').addEvent('click', function(event) {
			event.stop();
			$('Sexy-error').setStyle('display', 'none');
			$('Sexy-loading').setStyle('display', 'none');
			$('Sexy-login').setStyle('display', 'block');
		});
		$('loginform').set('send', {
			onRequest: function() {
				$('Sexy-loading').setStyle('display', 'block');
				$('Sexy-login').setStyle('display', 'none');
			},      
		onComplete: function(response) {
			$('Sexy-loading').setStyle('display', 'none');
			if(response == "ok") {
				document.location.href = "sistema/index.php";
			}	else if(response == "no") {
				$('Sexy-error').setStyle('display', 'block');
			}	else if(response == "inactivo") {
				$('Sexy-inactivo').setStyle('display', 'block');
			}	else {
				$('Sexy-login').setStyle('display', 'block');
			}
		}});
		$('loginform').send();
		return false;
	};
</script>
