package com.hotelbeds.supplierintegrations.hackertest.test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.hotelbeds.supplierintegrations.hackertest.models.Register;
import com.hotelbeds.supplierintegrations.hackertest.utils.FileUtils;
import com.hotelbeds.supplierintegrations.hackertest.utils.StringsUtils;
import com.hotelbeds.supplierintegrations.hackertest.utils.TimeUtils;

public class Test {

	
	@org.junit.Test
	public void testCompareTime() {
		double minutes = TimeUtils.compareTimes(1627508244,1627507944);
		assertEquals(5, minutes);
	}
	
	@org.junit.Test
	public void testGetCommaPositions() {
		ArrayList<Integer> lista = new ArrayList();
		lista.add(12);
		lista.add(22);
		lista.add(37);
		String cadena = "80.238.9.179,133612947,SIGNIN_SUCCESS,Will.Smith";
		ArrayList posiciones = StringsUtils.getCommaPositions(cadena);
		assertEquals(lista, posiciones);
	}
	
	@org.junit.Test
	public void testCreateRegister() {
		String cadena = "80.238.9.179,133612947,SIGNIN_SUCCESS,Will.Smith";
		Register reg = new Register(cadena);
		assertEquals("80.238.9.179", reg.getIp());
		assertEquals(133612947, reg.getDate());
		assertEquals("SIGNIN_SUCCESS", reg.getState());
		assertEquals("Will.Smith", reg.getName());
	}
	
	@org.junit.Test
	public void testGetFile() {
		BufferedReader br = FileUtils.readFile("D:\\logs.txt");
		assertNotNull(br);
	}
	
	

}
