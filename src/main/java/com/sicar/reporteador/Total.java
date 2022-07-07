package com.sicar.reporteador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

class Total {

    public void ObtenerTotal(JTable tabla) {
        double t = 0;
        double p = 0;
        for (int o = 0; o < tabla.getColumnCount(); o++) {
            if (tabla.getColumnName(o).equalsIgnoreCase("Total")) {
                if (tabla.getRowCount() > 0) {
                    
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        if (tabla.getValueAt(i, o)!=null) {
                            p = Double.parseDouble(tabla.getValueAt(i, o).toString());
                            t += p;
                        }                       

                    }
                    
                    JOptionPane.showMessageDialog(null, "Toltal " + t);

                } else {
                    JOptionPane.showConfirmDialog(null, "esta fila no se puede sumar,\n"
                            + "por favor seleccione otra");
                }
            }

        }

    }

}
//double dValue = rs.getDouble(k);
                    //int iValue = rs.getInt(k);