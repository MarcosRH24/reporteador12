/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicar.reporteador;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author marcos
 */
public class EliminarColumnas {

    public void eliminarColumnas(JTable tabla) {
        //id
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                if (tabla.getColumnName(j).contains("_id")) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(j));
                }

            }
        }
        //sub
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                if (tabla.getColumnName(j).contains("sub")) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(j));
                }

            }
        }
        //status
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                if (tabla.getColumnName(j).contains("status") || tabla.getColumnName(j).contains("Status")) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(j));
                }

            }
        }
        //columnas nulas
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                if (!tabla.getColumnName(j).equalsIgnoreCase("total")) {
                    if (tabla.getValueAt(i, j) == null) {

                        tabla.removeColumn(tabla.getColumnModel().getColumn(j));
                    }
                }

            }
        }
        //boolean
        for (int i = 1; i < tabla.getColumnCount(); i++) {
            for (int j = 0; j < tabla.getRowCount(); j++) {
                if (tabla.getValueAt(j, i) instanceof Boolean) {
                    tabla.removeColumn(tabla.getColumnModel().getColumn(i));
                }
            }
        }
    }
    



    public void quitarCamelCase(JTable t, JTableHeader header) {
        for (int i = 0; i < t.getColumnCount(); i++) {
            for (int j = 0; j < t.getRowCount(); j++) {
                t.getValueAt(i, j);
                header = t.getTableHeader();
                TableColumnModel tableColumnModel = header.getColumnModel();
                TableColumn tableColumn = tableColumnModel.getColumn(i);
                for (String w : "camelValue".split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
                    tableColumn.setHeaderValue(w);
                    header.repaint();
                }
            }
        }

    }
}
