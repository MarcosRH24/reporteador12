package com.sicar.reporteador.consum;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


/**
 *
 * @author marcos
 */
public class Descargar {

    public void descargar(JButton boton, JTextArea text) {
        boton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HttpClientApp cli = new HttpClientApp();
                cli.consumir(text);

            }
        });
    }
}
