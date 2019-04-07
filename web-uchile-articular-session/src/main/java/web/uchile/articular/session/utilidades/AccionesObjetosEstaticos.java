package web.uchile.articular.session.utilidades;

import javax.faces.model.SelectItem;

public class AccionesObjetosEstaticos {

	public static SelectItem[] listarDiasNacimiento(){
		SelectItem[] listaDiasNacimiento = new SelectItem[32];
		int ivariableMostar;
		int ivariableValor;
		listaDiasNacimiento[0] = new SelectItem("0", "Seleccione Dia");
		for(int i=1;i<=31;i++){
			ivariableMostar = i;
			ivariableValor = i;
			listaDiasNacimiento[i] = new SelectItem(ivariableMostar+"", ivariableValor+"");
		}

		return listaDiasNacimiento;
	}

	public static SelectItem[] listarMesesNacimiento(){
		SelectItem[] listaMesesNacimiento = new SelectItem[13];
		listaMesesNacimiento[0] = new SelectItem("0", "Seleccione Mes");
		listaMesesNacimiento[1] = new SelectItem("1", "Enero");
		listaMesesNacimiento[2] = new SelectItem("2", "Febrero");
		listaMesesNacimiento[3] = new SelectItem("3", "Marzo");
		listaMesesNacimiento[4] = new SelectItem("4", "Abril");
		listaMesesNacimiento[5] = new SelectItem("5", "Mayo");
		listaMesesNacimiento[6] = new SelectItem("6", "Junio");
		listaMesesNacimiento[7] = new SelectItem("7", "Julio");
		listaMesesNacimiento[8] = new SelectItem("8", "Agosto");
		listaMesesNacimiento[9] = new SelectItem("9", "Septiembre");
		listaMesesNacimiento[10] = new SelectItem("10", "Octubre");
		listaMesesNacimiento[11] = new SelectItem("11", "Noviembre");
		listaMesesNacimiento[12] = new SelectItem("12", "Diciembre");
		return listaMesesNacimiento;
	}

	public static SelectItem[] listarAniosNacimiento(){
		SelectItem[] listaAniosNacimiento = new SelectItem[120];
		SelectItem[] retListaAniosNacimiento = new SelectItem[120];
		int base = 1900;
		int limiteFinal = base+118;
		int contador =1;
		
		for(int i=base; i<=limiteFinal; i++ ){
			listaAniosNacimiento[contador] = new SelectItem(i+"", i+"");
			contador++;
		}

		for(int oo=1; oo<contador; oo++ ){
			retListaAniosNacimiento[oo] = new SelectItem(listaAniosNacimiento[contador-oo].getValue(), listaAniosNacimiento[contador-oo].getLabel());
		}
		
		retListaAniosNacimiento[0] = new SelectItem("0", "Seleccione Año");

		return retListaAniosNacimiento;
	}

	public static SelectItem[] listarGeneros(){
		SelectItem[] listaGenero = new SelectItem[3];
		listaGenero[0] = new SelectItem("0", "Seleccione Genero");
		listaGenero[1] = new SelectItem("1", "Masculino");
		listaGenero[2] = new SelectItem("2", "Femenino");
		return listaGenero;
	}
	
	public static SelectItem[] listarDocumentoIdentificacion(){
		SelectItem[] listaDocumentoIdentificacion = new SelectItem[3];
		listaDocumentoIdentificacion[0] = new SelectItem("0", "Seleccione Documento");
		listaDocumentoIdentificacion[1] = new SelectItem("1", "RUT");
		listaDocumentoIdentificacion[2] = new SelectItem("2", "Pasaporte");
		return listaDocumentoIdentificacion;
	}

	public static SelectItem[] listarNacionalidades(){
		SelectItem[] listaNacionalidades = new SelectItem[194];
		int i=0;
		listaNacionalidades [i] =   new SelectItem("0", "Seleccione Nacionalidad");
		listaNacionalidades	[i++] =	new SelectItem("0","	Afgano/na");
		listaNacionalidades	[i++] =	new SelectItem("1","	Albanés/sa");
		listaNacionalidades	[i++] =	new SelectItem("2","	Alemán/na");
		listaNacionalidades	[i++] =	new SelectItem("3","	Andorrano/na");
		listaNacionalidades	[i++] =	new SelectItem("4","	Angoleño/ña");
		listaNacionalidades	[i++] =	new SelectItem("5","	Antiguano/na");
		listaNacionalidades	[i++] =	new SelectItem("6","	Saudí o saudita");
		listaNacionalidades	[9] =	new SelectItem("7","	Argelino/na");
		listaNacionalidades	[10] =	new SelectItem("8","	Argentino/a");
		listaNacionalidades	[11] =	new SelectItem("9","	Armenio/nia");
		listaNacionalidades	[11] =	new SelectItem("10","	Australiano/na");
		listaNacionalidades	[12] =	new SelectItem("11","	Austríaco/ca");
		listaNacionalidades	[13] =	new SelectItem("12","	Azerbaiyano/na");
		listaNacionalidades	[14] =	new SelectItem("13","	Bahameño/ña");
		listaNacionalidades	[15] =	new SelectItem("14","	Bangladesí	");
		listaNacionalidades	[16] =	new SelectItem("15","	Barbadense");
		listaNacionalidades	[17] =	new SelectItem("16","	Bareiní");
		listaNacionalidades	[18] =	new SelectItem("17","	Belga");
		listaNacionalidades	[19] =	new SelectItem("18","	Beliceño/ña");
		listaNacionalidades	[20] =	new SelectItem("19","	Beninés/sa");
		listaNacionalidades	[21] =	new SelectItem("20","	Bielorruso/sa");
		listaNacionalidades	[22] =	new SelectItem("21","	Birmano/na");
		listaNacionalidades	[23] =	new SelectItem("22","	Boliviano/a");
		listaNacionalidades	[24] =	new SelectItem("23","	Bosnio/nia");
		listaNacionalidades	[25] =	new SelectItem("24","	Botsuano/na");
		listaNacionalidades	[26] =	new SelectItem("25","	Brasileño/a");
//		listaNacionalidades	[27] =	new SelectItem("26","	Bruneano/na");
		listaNacionalidades	[27] =	new SelectItem("27","	Búlgaro/ra");
		listaNacionalidades	[28] =	new SelectItem("28","	Burkinés");
		listaNacionalidades	[29] =	new SelectItem("29","	Burundés/sa");
		listaNacionalidades	[30] =	new SelectItem("30","	Butanés/sa");
		listaNacionalidades	[31] =	new SelectItem("31","	Caboverdiano/na");
		listaNacionalidades	[32] =	new SelectItem("32","	Camboyano/na");
		listaNacionalidades	[33] =	new SelectItem("33","	Camerunés/sa");
		listaNacionalidades	[34] =	new SelectItem("34","	Canadiense");
		listaNacionalidades	[35] =	new SelectItem("35","	Catarí");
		listaNacionalidades	[36] =	new SelectItem("36","	Chadiano/na");
		listaNacionalidades	[37] =	new SelectItem("37","	Chileno/a");
		listaNacionalidades	[38] =	new SelectItem("38","	Chino/na");
		listaNacionalidades	[39] =	new SelectItem("39","	Chipriota");
		listaNacionalidades	[40] =	new SelectItem("40","	Colombiano/a");
		listaNacionalidades	[41] =	new SelectItem("41","	Comorense");
		listaNacionalidades	[42] =	new SelectItem("42","	Norcoreano/na");
		listaNacionalidades	[43] =	new SelectItem("43","	Surcoreano/na");
		listaNacionalidades	[44] =	new SelectItem("44","	Marfileño/ña");
		listaNacionalidades	[45] =	new SelectItem("45","	Costarricense");
		listaNacionalidades	[46] =	new SelectItem("46","	Croata");
		listaNacionalidades	[47] =	new SelectItem("47","	Cubano/a");
		listaNacionalidades	[48] =	new SelectItem("48","	Danés/sa");
		listaNacionalidades	[49] =	new SelectItem("49","	Dominiqués");
		listaNacionalidades	[50] =	new SelectItem("50","	Ecuatoriano/a");
		listaNacionalidades	[51] =	new SelectItem("51","	Egipcio/cia");
		listaNacionalidades	[52] =	new SelectItem("52","	Salvadoreño/ña");
		listaNacionalidades	[53] =	new SelectItem("53","	Emiratí");
		listaNacionalidades	[54] =	new SelectItem("54","	Eritreo/a");
		listaNacionalidades	[55] =	new SelectItem("55","	Eslovaco/ca");
		listaNacionalidades	[56] =	new SelectItem("56","	Esloveno/na");
		listaNacionalidades	[57] =	new SelectItem("57","	Español/la");
		listaNacionalidades	[58] =	new SelectItem("58","	Estadounidense");
		listaNacionalidades	[59] =	new SelectItem("59","	Estonio/nia");
		listaNacionalidades	[60] =	new SelectItem("60","	Etíope");
		listaNacionalidades	[61] =	new SelectItem("61","	Filipino/na");
		listaNacionalidades	[62] =	new SelectItem("62","	Finlandés/sa");
		listaNacionalidades	[63] =	new SelectItem("63","	Fiyiano/na");
		listaNacionalidades	[64] =	new SelectItem("64","	Francés/sa");
		listaNacionalidades	[65] =	new SelectItem("65","	Gabonés/sa");
		listaNacionalidades	[66] =	new SelectItem("66","	Gambiano/na");
		listaNacionalidades	[67] =	new SelectItem("67","	Georgiano/na");
		listaNacionalidades	[68] =	new SelectItem("68","	Ghanés/sa");
		listaNacionalidades	[69] =	new SelectItem("69","	Granadino/a");
		listaNacionalidades	[70] =	new SelectItem("70","	Griego/ga");
		listaNacionalidades	[71] =	new SelectItem("71","	Guatemalteco/a");
		listaNacionalidades	[72] =	new SelectItem("72","	Ecuatoguineano/na");
		listaNacionalidades	[73] =	new SelectItem("73","	Guineano/na");
		listaNacionalidades	[74] =	new SelectItem("74","	Guineano/na");
		listaNacionalidades	[75] =	new SelectItem("75","	Guyanés/esa");
		listaNacionalidades	[76] =	new SelectItem("76","	Haitiano/a");
		listaNacionalidades	[77] =	new SelectItem("77","	Hondureño/a");
		listaNacionalidades	[78] =	new SelectItem("78","	Húngaro/ra");
		listaNacionalidades	[79] =	new SelectItem("79","	Indio/dia");
		listaNacionalidades	[80] =	new SelectItem("80","	Indonesio/sia");
		listaNacionalidades	[81] =	new SelectItem("81","	Iraquí");
		listaNacionalidades	[82] =	new SelectItem("82","	Iraní");
		listaNacionalidades	[83] =	new SelectItem("83","	Irlandés/sa");
		listaNacionalidades	[84] =	new SelectItem("84","	Islandés/sa");
		listaNacionalidades	[85] =	new SelectItem("85","	Marshalés/sa");
		listaNacionalidades	[86] =	new SelectItem("86","	Salomonense");
		listaNacionalidades	[87] =	new SelectItem("87","	Israelí");
		listaNacionalidades	[88] =	new SelectItem("88","	Italiano/na");
		listaNacionalidades	[89] =	new SelectItem("89","	Jamaicano/na");
		listaNacionalidades	[90] =	new SelectItem("90","	Japonés/sa");
		listaNacionalidades	[91] =	new SelectItem("91","	Jordano/na");
		listaNacionalidades	[92] =	new SelectItem("92","	Kazajo/ja");
		listaNacionalidades	[93] =	new SelectItem("93","	Keniata");
		listaNacionalidades	[94] =	new SelectItem("94","	Kirguís");
		listaNacionalidades	[95] =	new SelectItem("95","	Kiribatiano/na");
		listaNacionalidades	[96] =	new SelectItem("96","	Kuwaití");
		listaNacionalidades	[97] =	new SelectItem("97","	Laosiano/na");
		listaNacionalidades	[98] =	new SelectItem("98","	Lesotense");
		listaNacionalidades	[99] =	new SelectItem("99","	Letón/na");
		listaNacionalidades	[100] =	new SelectItem("100","	Libanés/sa");
		listaNacionalidades	[101] =	new SelectItem("101","	Liberiano/na");
		listaNacionalidades	[102] =	new SelectItem("102","	Libio/a");
		listaNacionalidades	[103] =	new SelectItem("103","	liechtensteiniano/na");
		listaNacionalidades	[104] =	new SelectItem("104","	Lituano/na");
		listaNacionalidades	[105] =	new SelectItem("105","	Luxemburgués/sa");
		listaNacionalidades	[106] =	new SelectItem("106","	Malgache");
		listaNacionalidades	[107] =	new SelectItem("107","	Malasio/sia");
		listaNacionalidades	[108] =	new SelectItem("108","	Malauí");
		listaNacionalidades	[109] =	new SelectItem("109","	Maldivo/va");
		listaNacionalidades	[110] =	new SelectItem("110","	Maliense");
		listaNacionalidades	[111] =	new SelectItem("111","	Maltés/sa");
		listaNacionalidades	[112] =	new SelectItem("112","	Marroquí");
		listaNacionalidades	[113] =	new SelectItem("113","	Mauriciano/na");
		listaNacionalidades	[114] =	new SelectItem("114","	Mauritano/na");
		listaNacionalidades	[115] =	new SelectItem("115","	Mexicano/a");
		listaNacionalidades	[116] =	new SelectItem("116","	Micronesio/sia");
		listaNacionalidades	[117] =	new SelectItem("117","	Moldavo/va");
		listaNacionalidades	[118] =	new SelectItem("118","	Monegasco/ca");
		listaNacionalidades	[119] =	new SelectItem("119","	Mongol/la");
		listaNacionalidades	[120] =	new SelectItem("120","	Montenegrino/na");
		listaNacionalidades	[121] =	new SelectItem("121","	Mozambiqueño/ña");
		listaNacionalidades	[122] =	new SelectItem("122","	Namibio/bia");
		listaNacionalidades	[123] =	new SelectItem("123","	Nauruano/na");
		listaNacionalidades	[124] =	new SelectItem("124","	Nepalí");
		listaNacionalidades	[125] =	new SelectItem("125","	Nicaragüense");
		listaNacionalidades	[126] =	new SelectItem("126","	Nigerino/na");
		listaNacionalidades	[127] =	new SelectItem("127","	Nigeriano /na");
		listaNacionalidades	[128] =	new SelectItem("128","	Noruego/ga");
		listaNacionalidades	[129] =	new SelectItem("129","	Neozelandés/sa");
		listaNacionalidades	[130] =	new SelectItem("130","	Omaní");
		listaNacionalidades	[131] =	new SelectItem("131","	Neerlandés/sa");
		listaNacionalidades	[132] =	new SelectItem("132","	Pakistaní");
		listaNacionalidades	[133] =	new SelectItem("133","	Palauano/na");
		listaNacionalidades	[134] =	new SelectItem("134","	Panameño/ña");
		listaNacionalidades	[135] =	new SelectItem("135","	Papú");
		listaNacionalidades	[136] =	new SelectItem("136","	Paraguayo/a");
		listaNacionalidades	[137] =	new SelectItem("137","	Peruano/a");
		listaNacionalidades	[138] =	new SelectItem("138","	Polaco/ca");
		listaNacionalidades	[139] =	new SelectItem("139","	Portugués/sa");
		listaNacionalidades	[140] =	new SelectItem("140","	Británico/ca");
		listaNacionalidades	[141] =	new SelectItem("141","	Centroafricano/na");
		listaNacionalidades	[142] =	new SelectItem("142","	Checo/ca");
		listaNacionalidades	[143] =	new SelectItem("143","	Macedonio/nia");
		listaNacionalidades	[144] =	new SelectItem("144","	Congoleño/ña");
		listaNacionalidades	[145] =	new SelectItem("145","	Congoleño/ña");
		listaNacionalidades	[146] =	new SelectItem("146","	Dominicano/na");
		listaNacionalidades	[147] =	new SelectItem("147","	Sudafricano/na");
		listaNacionalidades	[148] =	new SelectItem("148","	Ruandés/sa");
		listaNacionalidades	[149] =	new SelectItem("149","	Rumano/na");
		listaNacionalidades	[150] =	new SelectItem("150","	Ruso/sa");
		listaNacionalidades	[151] =	new SelectItem("151","	Samoano/na");
		listaNacionalidades	[152] =	new SelectItem("152","	Cristobaleño/ña");
		listaNacionalidades	[153] =	new SelectItem("153","	Sanmarinense");
		listaNacionalidades	[154] =	new SelectItem("154","	Sanvicentino/na");
		listaNacionalidades	[155] =	new SelectItem("155","	Santalucense");
		listaNacionalidades	[156] =	new SelectItem("156","	Santotomense");
		listaNacionalidades	[157] =	new SelectItem("157","	Senegalés/sa");
		listaNacionalidades	[158] =	new SelectItem("158","	Serbio/a");
		listaNacionalidades	[159] =	new SelectItem("159","	Seychellense");
		listaNacionalidades	[160] =	new SelectItem("160","	Sierraleonés/sa");
		listaNacionalidades	[161] =	new SelectItem("161","	Singapurense");
		listaNacionalidades	[162] =	new SelectItem("162","	Sirio/ria");
		listaNacionalidades	[163] =	new SelectItem("163","	Somalí");
		listaNacionalidades	[164] =	new SelectItem("164","	Esrilanqués/sa");
		listaNacionalidades	[165] =	new SelectItem("165","	Suazi");
		listaNacionalidades	[166] =	new SelectItem("166","	Sursudanés/sa");
		listaNacionalidades	[167] =	new SelectItem("167","	Sudanés/sa");
		listaNacionalidades	[168] =	new SelectItem("168","	Sueco/ca");
		listaNacionalidades	[169] =	new SelectItem("169","	Suizo/za");
		listaNacionalidades	[170] =	new SelectItem("170","	Surinamés/esa");
		listaNacionalidades	[171] =	new SelectItem("171","	Tailandés/sa");
		listaNacionalidades	[172] =	new SelectItem("172","	Tanzano/na");
		listaNacionalidades	[173] =	new SelectItem("173","	Tayiko/ka");
		listaNacionalidades	[174] =	new SelectItem("174","	Timorense");
		listaNacionalidades	[175] =	new SelectItem("175","	Togolés/sa");
		listaNacionalidades	[176] =	new SelectItem("176","	Tongano/na");
		listaNacionalidades	[177] =	new SelectItem("177","	Trinitense");
		listaNacionalidades	[178] =	new SelectItem("178","	Tunecino/na");
		listaNacionalidades	[179] =	new SelectItem("179","	Turkmeno/na");
		listaNacionalidades	[180] =	new SelectItem("180","	Turco/ca");
		listaNacionalidades	[181] =	new SelectItem("181","	Tuvaluano/na");
		listaNacionalidades	[182] =	new SelectItem("182","	Ucraniano/na");
		listaNacionalidades	[183] =	new SelectItem("183","	Ugandés/sa");
		listaNacionalidades	[184] =	new SelectItem("184","	Uruguayo/a");
		listaNacionalidades	[185] =	new SelectItem("185","	Uzbeko/ka");
		listaNacionalidades	[186] =	new SelectItem("186","	Vanuatuense");
		listaNacionalidades	[187] =	new SelectItem("187","	Venezolano/a");
		listaNacionalidades	[188] =	new SelectItem("188","	Vietnamita");
		listaNacionalidades	[189] =	new SelectItem("189","	Yemení");
		listaNacionalidades	[190] =	new SelectItem("190","	Yibutiano/na");
		listaNacionalidades	[191] =	new SelectItem("191","	Zambiano/na");
		listaNacionalidades	[192] =	new SelectItem("192","	Zimbabuense");

		return listaNacionalidades;
	}
}