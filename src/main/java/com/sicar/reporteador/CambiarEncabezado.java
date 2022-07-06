/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicar.reporteador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author marcos
 */
public class CambiarEncabezado{


    private JTableHeader header;
    private JPopupMenu renamePopup;
    private JTextField text;
    private TableColumn column;

    public CambiarEncabezado(JTable table) {
        table = new JTable(10, 5);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        header = table.getTableHeader();
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    editColumnAt(event.getPoint());
                }
            }
        });

        text = new JTextField();
        text.setBorder(null);
        text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                renameColumn();
            }
        });

        renamePopup = new JPopupMenu();
        renamePopup.setBorder(new MatteBorder(0, 1, 1, 1, Color.DARK_GRAY));
        renamePopup.add(text);
    }

    private void editColumnAt(Point p) {
        int columnIndex = header.columnAtPoint(p);

        if (columnIndex != -1) {
            column = header.getColumnModel().getColumn(columnIndex);
            Rectangle columnRectangle = header.getHeaderRect(columnIndex);

            text.setText(column.getHeaderValue().toString());
            renamePopup.setPreferredSize(
                    new Dimension(columnRectangle.width, columnRectangle.height - 1));
            renamePopup.show(header, columnRectangle.x, 0);

            text.requestFocusInWindow();
            text.selectAll();
        }
    }
    private void renameColumn() {
        column.setHeaderValue(text.getText());
        renamePopup.setVisible(false);
        header.repaint();
    }

}
