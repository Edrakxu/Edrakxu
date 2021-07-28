package com.hotelbeds.supplierintegrations.hackertest.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;

import com.hotelbeds.supplierintegrations.hackertest.models.Register;
import com.hotelbeds.supplierintegrations.hackertest.resources.States;
import com.hotelbeds.supplierintegrations.hackertest.utils.TimeUtils;
import com.sun.tools.sjavac.Log;

public class Checker /*implements Callable<String>*/ {
	
	private final int TRYS = 5;
	private final double MINUTES = 5;
	private Register register;
	private ArrayList<Register> registros;
	private int posicion;
	
	public Checker(Register register,ArrayList<Register>  registros,int posicion) {
		this.register = register;
		this.registros = registros;
		this.posicion = posicion;
	}
	
	public String run() {
		
		String ip = null;
		Register comparer;
		int counter = 0;
		boolean check= true;
		
		for(int i=posicion; registros.size() > i &&  check; i++)
        {	
			comparer = registros.get(i);
			//Se mira que sea la misma ip
			if(register.getIp().equalsIgnoreCase(comparer.getIp())) {
				//Se comprueba que desde la primera ip que se selecciona con la ultima este dentro del perido de 5 minutos
				if(MINUTES>TimeUtils.compareTimes(register.getDate(), comparer.getDate())) {
					//Comprobar ha fallado el login
	    		    if(comparer.getState().equalsIgnoreCase(States.SIGNIN_FAILURE)) {
	    			    counter++;
	    		    }
	    		    
	    		    if(counter >= TRYS) {
	        		    check = false;
	        		    ip = register.getIp();
	        	    }
    		    }else {
    		    	check = false;
    		    }
			}
        }
		
		return ip;
	}

}
