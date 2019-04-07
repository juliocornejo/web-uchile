//package com.manashiki.uchilearte.solicitud.test;
//
//import static org.junit.Assert.*;
//
//import java.text.ParseException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//
//import com.manashiki.uchilearte.solicitud.web.model.HotelBusquedaParametrosModel;
//
//public class TestParserUrl {
//
//	@Test
//	public void test() {
//		Map<String, String[]> parametersMapOld = new HashMap<String, String[]>();
//		
//		String[] tipoArray = new String[1];
//		tipoArray[0] = "ciudades";
//		parametersMapOld.put("tipo", tipoArray);
//		String[] nombreArray = new String[1];
//		nombreArray[0] = "432";
//		parametersMapOld.put("zona", nombreArray);
//		String[] fechasArray = new String[1];
//		fechasArray[0] = "03-08-2016!24-08-2016";
//		parametersMapOld.put("fechas", fechasArray);
//		String[] habitacionesArray = new String[1];
//		habitacionesArray[0] = "2";
//		parametersMapOld.put("habitaciones", habitacionesArray);
//		String[] personasArray = new String[1];
//		personasArray[0] = "4*2*5*8*0*0!2*1*4*0*0*0!0*0*0*0*0*0!0*0*0*0*0*0";
//		parametersMapOld.put("personas", personasArray);
//		String[] estrellasArray = new String[1];
//		estrellasArray[0] = "3";
//		parametersMapOld.put("estrellas", estrellasArray);
//		
//		Map<String, String[]> parametersMapNew = new HashMap<String, String[]>();
//		
//		String[] arrayFechas = new String[1];
//		arrayFechas[0] = "03-08-2016!24-08-2016";
//		parametersMapNew.put("fecha", arrayFechas);
//		
//		String[] arrayNumeroHabitaciones = new String[1];
//		arrayNumeroHabitaciones[0] = "2";
//		parametersMapNew.put("habitaciones", arrayNumeroHabitaciones);
//		
//		String[] arrayNinos = new String[2];
//		arrayNinos[0] = "2";
//		arrayNinos[1] = "1";
//		parametersMapNew.put("ninos", arrayNinos);
//		
//		String[] arrayAdultos = new String[2];
//		arrayAdultos[0] = "4";
//		arrayAdultos[1] = "2";
//		parametersMapNew.put("adultos", arrayAdultos);
//		
//		String[] arrayEdades = new String[2];
//		arrayEdades[0] = "5,8";
//		arrayEdades[1] = "4";
//		parametersMapNew.put("edad", arrayEdades);
//		
//		String[] arrayEstrellas = new String[1];
//		arrayEstrellas[0] = "3";
//		parametersMapNew.put("estrellas", arrayEstrellas);
//		
//		/**String[] arrayHotel  = new String[1];
//		arrayHotel[0] = "";
//		parametersMapNew.put("fecha", arrayHotel);**/
//		
//		String[] arrayZona = new String[1];
//		arrayZona[0] = "432";
//		parametersMapNew.put("zona", arrayZona);
//		
//		
//	
//
//	}
//	
//	
//}
