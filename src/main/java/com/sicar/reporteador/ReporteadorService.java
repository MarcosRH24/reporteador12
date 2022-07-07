/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicar.reporteador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author marcos
 */
public class ReporteadorService {

    private Connection con;

    public int connect(String servidor, String base, String usuario, String clave) {
        try {
            String url = "jdbc:mysql://" + servidor + ":3306/" + base;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, usuario, clave);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int build(String sql, JTable table) {

        int correcta = 0;

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();

            DefaultTableModel modelo = (DefaultTableModel) table.getModel();

            //limpiar tabla
            modelo.setColumnCount(0);
            modelo.setRowCount(0);

            //agregar las columnas del resultado con su nombre
            for (int k = 1; k <= rsm.getColumnCount(); k++) {

                modelo.addColumn(rsm.getColumnName(k)/*.toUpperCase()*/);

            }

            //agregar renglones con los datos
            int renglon = 0;
            while (rs.next()) {

                modelo.insertRow(renglon, new String[rsm.getColumnCount()]);
                for (int k = 1; k <= rsm.getColumnCount(); k++) {
                    modelo.setValueAt(rs.getObject(k), renglon, k - 1);
                   

                }
                renglon++;
            }

            for (int i = 1; i < rsm.getColumnCount() + 1; i++) {

                TableColumn column = table.getColumnModel().getColumn(i - 1);
 
                if (java.sql.Types.TIMESTAMP == rsm.getColumnType(i)) {

                    column.setPreferredWidth(200);
                    column.setMinWidth(200);
                    column.setWidth(200);

                } else {
                    
                    column.setMinWidth(100);
                    column.setPreferredWidth(100);
                    column.setWidth(100);
                }

            }

        } catch (SQLException ex) {
            correcta = 0;
            System.out.println(ex.getMessage());
        }

        return correcta;

    }

    public static void setAnchoColumnas(JTable tabla, double... porcentajes) {
        double total = 0;
        int anchoTabla = tabla.getWidth();

        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            total += porcentajes[i];
        }

        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            TableColumn column = tabla.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (anchoTabla * (porcentajes[i] / total)));
        }
    }
//    public String obtenerDato(String consulta) {
//
//        String resultado = "";
//
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(consulta);
//            while (rs.next()) {
//                resultado = rs.getString(1);
//            }
//            return resultado;
//        } catch (Exception e) {
//            return resultado;
//        }
//    }

}
