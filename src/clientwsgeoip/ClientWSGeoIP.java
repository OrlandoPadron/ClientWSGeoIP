/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwsgeoip;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author orlan
 */
public class ClientWSGeoIP {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException, IOException, Exception {
        
        String s = "http://www.webservicex.net/geoipservice.asmx/GetGeoIPContext";
        URL url = new URL(s);
        Scanner scan = new Scanner(url.openStream());
        String source = ""; 
        while (scan.hasNext()){
            source += scan.nextLine();
            
        }
        System.out.println("SALIDA DEL SOURCE: " + source);
        
        Serializer serializer = new Persister(); 
        GeoIP geoip = new GeoIP();
        serializer.read(geoip, source);
        System.out.println("ReturnCode: " + geoip.getCountryName());

    }
    
}
