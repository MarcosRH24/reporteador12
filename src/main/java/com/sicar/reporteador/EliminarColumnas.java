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

    public void eliminarColumnasNulas(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                TableColumnModel tcm = tabla.getColumnModel();
                TableColumn columnaABorrar = tcm.getColumn(j);

                if (columnaABorrar.equals("null")) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(j));
                    
                }

            }
        }

    }

}
