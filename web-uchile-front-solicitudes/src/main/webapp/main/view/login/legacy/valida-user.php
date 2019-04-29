<?php 
//session_start();
if (!isset($_SESSION['id_usuario'])) {
  
?>
<script type="text/javascript">
  window.open('prueba.php', '_top');
  //detalles.php?id_receta=" + id + "&porciones=" + porciones,"width=600, height=500, scrollbars=yes, menubar=no, location=no, resizable=no"
</script>
<?php 
}
?>
