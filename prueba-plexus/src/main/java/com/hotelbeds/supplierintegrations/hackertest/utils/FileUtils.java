package com.hotelbeds.supplierintegrations.hackertest.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.sun.tools.sjavac.Log;


public class FileUtils {
	
	public static BufferedReader readFile(String fileName) {
		
		BufferedReader br = null;
	    try {
	       //Crear un objeto BufferedReader al que se le pasa 
	       //   un objeto FileReader con el nombre del fichero
	       br = new BufferedReader(new FileReader(fileName));
	       //Leer la primera línea, guardando en un String
	       
	    }
	    catch (FileNotFoundException e) {
	    	//Log.error("Error: Fichero no encontrado");
	    	//Log.error(e.getMessage());
	    }
	    
	    return br;
	}
}
