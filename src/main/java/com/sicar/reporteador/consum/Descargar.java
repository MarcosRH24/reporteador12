package com.sicar.reporteador.consum;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;



/**
 *
 * @author marcos
 */
public class Descargar {

    public String consumir() {
        try {

            URL url = new URL("http://localhost:8080/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("ocurrio un error: " + responseCode);
            } else {
                StringBuilder informationQuery = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationQuery.append(scanner.nextLine());
                }
                scanner.close();
                String st = informationQuery.toString();
                
                return st;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
