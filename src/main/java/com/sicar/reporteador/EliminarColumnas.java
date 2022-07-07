/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicar.reporteador;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author marcos
 */
public class EliminarColumnas {

    public EliminarColumnas() {
    }

    public void eliminarColumnas_Id(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                if (tabla.getColumnName(j).contains("_id")) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(j));
                }

            }
        }
    }

    public void eliminarSub(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                if (tabla.getColumnName(j).contains("sub")) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(j));
                }

            }
        }
    }

    public void eliminarStatus(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                if (tabla.getColumnName(j).contains("status") || tabla.getColumnName(j).contains("Status")) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(j));
                }

            }
        }
    }
//
//    public void eliminarColumnasNulas(JTable tabla) {
//        for (int i = 0; i < tabla.getRowCount(); i++) {
//            for (int j = 0; j < tabla.getColumnCount(); j++) {
//                //TableColumnModel tcm = tabla.getColumnModel();
//                //TableColumn columnaABorrar = tcm.getColumn(j);
//                
//                if (tabla.getValueAt(i, j)==null) {
//                    tabla.removeColumn(tabla.getColumnModel().getColumn(j));
//                }
//                
//                    
//
//
//
//            }
//        }
//
//    }

    public void eliminarFilasVacias(JTable table) {
        for (int i = 1; i < table.getColumnCount(); i++) {
            for (int j = 0; j < table.getRowCount(); j++) {

                TableColumn t = table.getColumnModel().getColumn(i);
                if (t.getCellRenderer().equals("null")) {
                    table.removeColumn(table.getColumnModel().getColumn(j));
                }

            }
        }

    }

    public void eliminarBoolean(JTable tabla) {
        for (int i = 1; i < tabla.getColumnCount(); i++) {
            for (int j = 0; j < tabla.getRowCount(); j++) {
                if (tabla.getValueAt(j, i) instanceof Boolean) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(i));
                }
            }

        }
    }

}
