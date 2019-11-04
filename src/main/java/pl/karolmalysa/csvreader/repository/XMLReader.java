package pl.karolmalysa.csvreader.repository;

import org.springframework.stereotype.Repository;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class XMLReader {

    public static void readXML(String filePath) throws SAXException, IOException, ParserConfigurationException {
        Path inputPath = Paths.get(filePath);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser saxParser = null;
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        DefaultHandler handler = new DefaultHandler(){

            boolean bName = false;
            boolean bSurname = false;
            boolean bAge = false;
            boolean bCity = false;
            boolean bContact = false;

            //tag identyficator
            public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException{

                if(qName.equalsIgnoreCase("name")){
                    bName = true;
                }
                if(qName.equalsIgnoreCase("surname")){
                    bSurname = true;
                }
                if(qName.equalsIgnoreCase("age")){
                    bAge = true;
                }
                if(qName.equalsIgnoreCase("city")){
                    bCity = true;
                }
                if(qName.equalsIgnoreCase("contact")){
                    bContact = true;
                }
            }

            public void endElement(String uri, String localName, String qName)throws SAXException{

            }


            public void characters(char ch[], int start, int lenght) throws SAXException{

                if(bName){
                    System.out.println("name: "+ new String(ch, start, lenght));
                    bName=false;
                }
                if(bSurname){
                    System.out.println("surname: "+ new String(ch, start, lenght));
                    bSurname=false;
                }
                if(bAge){
                    System.out.println("age: "+ new String(ch, start, lenght));
                    bAge=false;
                }
                if(bCity){
                    System.out.println("city: "+ new String(ch, start, lenght));
                    bCity=false;
                }
                if(bContact){
                    System.out.println("contact: "+ new String(ch, start, lenght));
                    bContact=false;
                }

            }
        };
        try {
            saxParser.parse(filePath, handler);
        }catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
