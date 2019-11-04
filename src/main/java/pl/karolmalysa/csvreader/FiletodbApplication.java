package pl.karolmalysa.csvreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;
import pl.karolmalysa.csvreader.repository.CSVReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

import static pl.karolmalysa.csvreader.repository.XMLReader.readXML;

@SpringBootApplication
public class FiletodbApplication {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SpringApplication.run(FiletodbApplication.class, args);


		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj ścieżkę do pliku");
		String path = scan.nextLine();

		if (path.endsWith(".xml")){
			readXML(path);
		}else
		if(path.endsWith(".txt")){
			CSVReader.readCSV(path);
		}else
			System.out.println("nieobsługiwanyformat");

	}

}
