//package web.uchile.articular.session.utilidades;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
//
//public class Orddenamiento {
//	
//	
//	
//	public static void main(String args[]){
//		
//		ProgramaUniversidadDTO ProgramaUniversidadDTOA= new ProgramaUniversidadDTO("ZZZ");
//		ProgramaUniversidadDTO ProgramaUniversidadDTOB= new ProgramaUniversidadDTO("XXX");
//		ProgramaUniversidadDTO ProgramaUniversidadDTOC= new ProgramaUniversidadDTO("ABX");
//		ProgramaUniversidadDTO ProgramaUniversidadDTOD= new ProgramaUniversidadDTO("KIU");
//		
//		List<ProgramaUniversidadDTO> listaProgramaUniversidad = new ArrayList<ProgramaUniversidadDTO>();
//		
//		listaProgramaUniversidad.add(ProgramaUniversidadDTOA);
//		listaProgramaUniversidad.add(ProgramaUniversidadDTOB);
//		listaProgramaUniversidad.add(ProgramaUniversidadDTOC);
//		listaProgramaUniversidad.add(ProgramaUniversidadDTOD);
//		listaProgramaUniversidad.add(ProgramaUniversidadDTOB);
//		
//		Collections.sort(listaProgramaUniversidad, (x, y) -> x.getNombreProgramaUniversidad().compareToIgnoreCase(y.getNombreProgramaUniversidad()));
//		
//		System.out.println(listaProgramaUniversidad);
//	}
//}
