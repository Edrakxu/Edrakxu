package com.hotelbeds.supplierintegrations.hackertest.utils;

import java.sql.Array;
import java.util.ArrayList;

public class StringsUtils {
	
	public static final char COMMA = ',';
	
	public static ArrayList getCommaPositions(String string) {
		
		ArrayList<Integer> positions = new ArrayList();
		int posicion;
        //se busca la primera vez que aparece
        posicion = string.indexOf(COMMA);
        while (posicion != -1) { //mientras se encuentre el caracter
        	positions.add(posicion);
            //se sigue buscando a partir de la posición siguiente a la encontrada                                 
            posicion = string.indexOf(COMMA,posicion+1);
        }
		
		return positions;
	}
}
