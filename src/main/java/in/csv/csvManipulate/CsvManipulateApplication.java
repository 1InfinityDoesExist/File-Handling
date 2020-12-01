package in.csv.csvManipulate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

import in.csv.csvManipulate.serviceImpl.ProcessCSVFile;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class })
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
