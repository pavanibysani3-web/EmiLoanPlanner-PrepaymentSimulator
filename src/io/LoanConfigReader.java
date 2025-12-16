package io;
	import java.io.*;
	import java.util.*;

	public class LoanConfigReader {

	    public static Map<String, String> readConfig() throws Exception {
	        Map<String, String> map = new HashMap<>();
	        BufferedReader br = new BufferedReader(new FileReader("loan.cfg"));
	        String line;

	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split("=");
	            map.put(parts[0].trim(), parts[1].trim());
	        }
	        br.close();
	        return map;
	    }
	}

