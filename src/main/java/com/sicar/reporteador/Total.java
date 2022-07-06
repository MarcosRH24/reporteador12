package com.sicar.reporteador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author marcos
 */
class Total {

//    public void Btotal(JButton BTotal, JTable tabla) {
////        
//        BTotal.addActionListener((ActionEvent e) -> {
//            int columnSelected = tabla.getSelectedColumn();
//            if (columnSelected >= 0) {
//                Totalizar(tabla);
//            } else {
//                JOptionPane.showMessageDialog(null, "Seleccione primero la columna que desea sumar");
//            }
//        });
//    }
//
//    public void Totalizar(JTable tabla) {
//        double t = 0;
//        double p = 0;
//        int columna = tabla.getSelectedColumn();
//        if (tabla.getRowCount() > 0) {
//            for (int i = 0; i < tabla.getRowCount(); i++) {
//                p = Double.parseDouble(tabla.getValueAt(i, columna).toString());
//                t += p;
//            }
//
//            JOptionPane.showMessageDialog(null, "Toltal " + t);
//
//        } else {
//            JOptionPane.showConfirmDialog(null, "esta fila no se puede sumar,\n"
//                    + "por favor seleccione otra");
//        }
//
//    }
    public void ObtenerTotal(JTable tabla, JLabel LTotal) {
        double t = 0;
        double p = 0;
        for (int o = 0; o < tabla.getColumnCount(); o++) {
            if (tabla.getColumnName(o).equalsIgnoreCase("Total")) {
                if (tabla.getRowCount() > 0) {
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        if (tabla.getValueAt(i, o) instanceof Double) {
                            p = Double.parseDouble(tabla.getValueAt(i, o).toString());
                            t += p;
                        }else if (tabla.getValueAt(i, o) instanceof Integer) {
                            p = Double.parseDouble(tabla.getValueAt(i, o).toString());
                            t += p;
                        }

                    }
                    LTotal.setText("                         Total: " + t);
                    //JOptionPane.showMessageDialog(null, "Toltal " + t);

                } else {
                    JOptionPane.showConfirmDialog(null, "esta fila no se puede sumar,\n"
                            + "por favor seleccione otra");
                }
            }

        }

    }

}
