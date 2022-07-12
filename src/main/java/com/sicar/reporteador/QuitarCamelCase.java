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
public class QuitarCamelCase {

    public void delCamelCase(JTable t) {
        for (int i = 0; i < t.getRowCount(); i++) {
            for (int j = 0; j < t.getColumnCount(); j++) {

                String quitar = t.getColumnName(j);
                //LinkedList<String> q2=splitCamelCaseString(quitar);
                String q2 =quitarCamelCase(quitar)/*.toUpperCase()*/;
                changeColumnName(t, j, q2);
                
                
                
            }

        }
    }
    public static String quitarCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " de "
        );
    }
    public void changeColumnName(JTable t,int column, String name){
        JTableHeader head = t.getTableHeader();
        TableColumnModel tcm = head.getColumnModel();
        TableColumn tabCM = tcm.getColumn(column);
        tabCM.setHeaderValue(name);
        t.repaint();
    }
}
