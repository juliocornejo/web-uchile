<?php 
function obfuscate($text) {
  $length = strlen($text);
  $scrambled = '';
  
  for ($i = 0; $i < $length; ++$i) {
    $scrambled .= '&#'.ord(substr($text, $i, 1)).';';
  }
  
  return $scrambled;
}
?>
<div class="pie">
  <b>FácilFood&copy;</b>
  Todos los derechos reservados &nbsp;|&nbsp; <a href="http://comercialmente.cl" target="_blank">Desarrollado por Comercialmente</a>
  &nbsp;|&nbsp; <a href="<?php echo obfuscate('mailto:contacto@facilfood.cl') ?>">Contacto</a>
  | <a href="http://blog.facilfood.cl" target="_blank">Blog</a>
  &nbsp;|&nbsp; <a href="http://twitter.com/facilfood" target="_blank"><img src="http://facilfood.cl/sistema/inclusiones/imagenes/twitter.gif" style="vertical-align:bottom" border="0" alt="Twitter" /> Síguenos en Twitter</a> &nbsp;|&nbsp; <a href="http://www.facebook.com/facilfood" target="_blank"><img src="http://facilfood.cl/sistema/inclusiones/imagenes/facebook.gif" style="vertical-align:bottom" border="0" alt="Facebook" /> Facebook</a> &nbsp;|&nbsp; <a href="condiciones.php" target="_blank">Condiciones de uso</a>
  <br/>
  <br/>
</div>
<!-- Inicio Google Analytics FácilFood.cl -->
<script type="text/javascript">
  var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
  document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
  try {
    var pageTracker = _gat._getTracker("UA-9139702-3");
    pageTracker._trackPageview();
  } 
  catch (err) {
  }
</script>
<!-- Fin Google Analytics FácilFood.cl -->
