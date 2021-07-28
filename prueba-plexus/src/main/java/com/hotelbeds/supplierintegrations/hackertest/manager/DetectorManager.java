package com.hotelbeds.supplierintegrations.hackertest.manager;



import java.io.BufferedReader;
import java.util.ArrayList;

import com.hotelbeds.supplierintegrations.hackertest.detector.HackerDetector;
import com.hotelbeds.supplierintegrations.hackertest.models.Register;

public class DetectorManager implements HackerDetector {

	private ArrayList<Register> registros;
	private ArrayList<String> ips;
	
	public DetectorManager() {
		registros = new ArrayList<Register>();
		ips = new ArrayList<String>();
	}
	
	@Override
	public String parseLine(String line) {
		Register register = new Register(line);
		registros.add(register);
		
		return "OK";
	}
	
	public void check() {
		Checker checker;
		String ip;
		for(int i=0; registros.size() > i; i++) {
			 checker = new Checker(registros.get(i),registros,i);
			 ip = checker.run();
			 if(ip != null) {
				 addIP(ip);
			 }
		}
	}

	public ArrayList<String> getIps() {
		return ips;
	}
	
	private void addIP(String ip) {
		boolean anadir=true;
		for(int i=0; ips.size() > i && anadir; i++) {
			if(ips.get(i).equals(ip)){
				anadir = false;
			}
		}
		
		if(anadir) {
			ips.add(ip);
		}
	}

}
