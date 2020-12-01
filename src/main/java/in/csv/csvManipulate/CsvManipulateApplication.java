package in.csv.csvManipulate;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.csv.csvManipulate.serviceImpl.OpenStreetMapUtils;
import in.csv.csvManipulate.serviceImpl.ProcessCSVFile;

@SpringBootApplication
public class CsvManipulateApplication {

	/*
	 * Create a workbook ::::Create a sheet in workbook ::::Create a row in sheet
	 * ::::Add cells in sheet
	 */
	public static void main(String[] args) {
		SpringApplication.run(CsvManipulateApplication.class, args);

		ProcessCSVFile.writeIntoCSVFile();
		ProcessCSVFile.readFromCSVFile();
		
	}

}
