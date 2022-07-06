/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicar.reporteador;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author marcos
 */
public class Comando {

    ReporteadorService service;

    public void ctrlEnter(JTextArea txa, JTable tabla, JLabel labelStatus, JLabel labelResult,JLabel lTotal) {
        txa.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                char tecla = evt.getKeyChar();

                if ((tecla == '\n') && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    if (service == null) {
                        service = new ReporteadorService();
                        if (service.connect("Localhost", "sicar", "root", "testprueba") == 1) {
                        } else {
                            JOptionPane.showMessageDialog(null, "No Conectado a la BD");
                            System.exit(0);
                        }
                    }
                    long init = System.currentTimeMillis();
                    service.build(txa.getText(), tabla);
                    EliminarColumnas ec = new EliminarColumnas();
                    ec.eliminarColumnas_Id(tabla);
                    ec.eliminarColumnasNulas(tabla);

                    Total tl = new Total();
                    tl.ObtenerTotal(tabla,lTotal);

                    labelStatus.setText("Terminado en " + (System.currentTimeMillis() - init) + " ms");
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        labelResult.setText("Resultados " + (i + 1));
                    }
                }

            }
        });
    }

}
