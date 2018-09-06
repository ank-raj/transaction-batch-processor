package com.amb.batch.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransactionsBatchProcessor {

	public static void main(String[] args) throws IOException {
		System.out.println("Start >>>>");
		TransactionsBatchProcessor obj = new TransactionsBatchProcessor();
		obj.readFile("data.txt");
		obj.readFile("info.txt");
		System.out.println("<<<< End");
	}

	public void readFile(String fileName) throws IOException
	{
		FileInputStream inputStream=null;

		try {
			// Getting ClassLoader obj
			ClassLoader classLoader = getClass().getClassLoader();
			// Getting resource(File) from class loader
			File configFile=new File(classLoader.getResource(fileName).getFile());
			inputStream = new FileInputStream(configFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			inputStream.close();
		}
	}
}
