/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicar.reporteador;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author marcos
 */
public class Exporter {

    public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("files de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar file");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File fileXLS = new File(ruta);
                if (fileXLS.exists()) {
                    fileXLS.delete();
                }
                fileXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream file = new FileOutputStream(fileXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        if (!t.getColumnName(c).contains("_id")) {
                            Cell celda = fila.createCell(c);
                            
                            if (f == 0) {
                                if (t.getValueAt(f, c)!=null) {
                                    if (t.getColumnName(c)!=null) {
                                        celda.setCellValue(t.getColumnName(c));
                                    }
                                }
                                
                            }

                        }                     
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {

                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) !=null) {
                            if (t.getValueAt(f, c) instanceof Double) {
                                celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }
                        }

                    }

                }
                libro.write(file);
                file.close();
                Desktop.getDesktop().open(fileXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

}
