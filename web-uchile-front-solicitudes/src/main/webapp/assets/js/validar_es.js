/**
 * validaciones varias.
 */

function soloNumeros(e) {
	// Si no se cumple la condicion...
	var key;
	if(window.event) // IE
	{
		key = e.keyCode;
	}
	else if(e.which) // Netscape/Firefox/Opera
	{
		key = e.which;
	}
	
	var tabkey = e.keyCode;
	
	if (key > 47 && key < 58)
	{	
		
		return true;
	}
	//permitir teclas backspace-tabulador-left-right y suprimir
	if (key == 8 || tabkey == 9 || tabkey == 37 || tabkey == 39 || tabkey == 46)
	{	
	
		return true;
	}
	else 
		{
		return false; 
		}
		
	
}


function soloNumerosComas(e) {
	// Si no se cumple la condicion...
	var key;
	if(window.event) // IE
	{
		key = e.keyCode;
	}
	else if(e.which) // Netscape/Firefox/Opera
	{
		key = e.which;
	}

	if (key < 47 || key > 58)
	{
		if(key == 8 || key == 44) // Detectar . (punto) y backspace (retroceso)
		{ return true; }
		else 
		{ return false; }
	}
	return true;
}

function validarRut(e){
	var key;
	if(window.event) // IE
	{
		key = e.keyCode;
	}
	else if(e.which) // Netscape/Firefox/Opera
	{
		key = e.which;
	}

	if (key < 48 || key > 57)
	{
		if(key == 46 || key == 8 || key == 107 || key == 75 || key == 45) // Detectar . (punto), backspace (retroceso),k (k min), (K may) y guion
		{ return true; }
		else 
		{ return false; }
	}
	return true;
}

function numberFormat2(numero){ 
	// Variable que contendra el resultado final 
	
	var resultado = ""; 
	// Si el numero empieza por el valor "-" (numero negativo) 
	if(numero[0]=="-") { 
		// Cogemos el numero eliminando los posibles puntos que tenga, y sin 
		// el signo negativo 
		nuevoNumero=numero.replace(/\./g,'').substring(1); 
		
	}
	else{ 
		// Cogemos el numero eliminando los posibles puntos que tenga 
		nuevoNumero=numero.replace(/\./g,''); 
	
	} 
		// Si tiene decimales, se los quitamos al numero 
	if(numero.indexOf(",")>=0) nuevoNumero=nuevoNumero.substring(0,nuevoNumero.indexOf(",")); 
		// Ponemos un punto cada 3 caracteres 
		
	for (var j, i = nuevoNumero.length - 1, j = 0; i >= 0; i--, j++) { 
		resultado = nuevoNumero.charAt(i) + ((j > 0) && (j % 3 == 0)? ".": "") + resultado; 
		
	}
	
	// Si tiene decimales, se lo añadimos al numero una vez forateado con 
	// los separadores de miles 
	if(numero.indexOf(",")>=0){  
		resultado+=numero.substring(numero.indexOf(",")); 
		
	}
	if(numero[0]=="-") { 
		// Devolvemos el valor añadiendo al inicio el signo negativo 
		return "-"+resultado; 
	}else{ 
		alert(resultado+' Resultado +aaa');
		document.form.cantidadProducto.value="aaaa";
		return '8'; 
	}	
		
}

function menuContextDisabled(){
	document.oncontextmenu=function(){return false};
		
}


function menuContextEnabled(){
	document.oncontextmenu=function(){return true};
}


function esEntero(x){
	var y = parseInt(x);
	if (isNaN(y)) 
	return false;
	return x == y && x.toString() == y.toString();
	}



// onmouseover="menuContextDisabled();"
//	onmouseout="menuContextEnabled();">



