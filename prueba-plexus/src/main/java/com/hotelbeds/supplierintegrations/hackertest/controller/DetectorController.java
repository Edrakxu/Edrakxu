package com.hotelbeds.supplierintegrations.hackertest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotelbeds.supplierintegrations.hackertest.manager.DetectorManager;
import com.hotelbeds.supplierintegrations.hackertest.utils.FileUtils;
import com.hotelbeds.supplierintegrations.hackertest.utils.TimeUtils;
import com.sun.tools.sjavac.Log;


@Controller
public class DetectorController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String checkLogs(Model model) {
		Date start = new Date();
		
		//Leer fichero
		DetectorManager dt = new DetectorManager();
		BufferedReader br = FileUtils.readFile("D:\\logs.txt");
		String text;
		try {
			text = br.readLine();
			//Repetir mientras no se llegue al final del fichero
	       while(text != null)
	       {
	           //Lanzar checkeo
	    	   dt.parseLine(text);
	           //Leer la siguiente línea
	           text = br.readLine();
	       }
	       
	       dt.check();
		} catch (IOException e) {
			Log.error("Error al leer el fichero");
	    	Log.error(e.getMessage());
		}
		
		Date end = new Date();
		
		model.addAttribute("mens",  "Start:" +TimeUtils.rfc2822(start)+" End: "+TimeUtils.rfc2822(end)+" Ips sospechosas:"+dt.getIps().toString());
		return "home";
	}
	

}
