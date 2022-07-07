
package com.sicar.reporteador;

/*import java.math.BigDecimal;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import org.jdesktop.swingx.JXFindPanel;
import sicar.sutil.core.OSUtil;

import javax.swing.JTabbedPane;
import javax.swing.JTable;*/

/**
 *
 * @author marcos
 */
public class Graficador {

    /*public static void graficar(JTable tabla, JTabbedPane tabPane) {
        JXFindPanel panel = new JFXPanel();

        tabPane.addTab("Grafica", panel);

        tabPane.getTabComponentAt(tabPane.getTabCount() - 1);

        OSUtil.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AnchorPane anchor = new AnchorPane();
                panel.setScene(new Scene(anchor));

                LineChart<String, Number> chart = new LineChart<>(new CategoryAxis(), new NumberAxis());

                XYChart.Series<String, Number> series = new XYChart.Series<>();

                for (int i = 0; i < tabla.getModel().getRowCount(); i++) {

                    String fecha = tabla.getModel().getValueAt(i, 0).toString();
                    BigDecimal total = (BigDecimal) tabla.getModel().getValueAt(i, 1);

                    series.getData()
                            .add(new XYChart.Data<String, Number>(fecha, total));
                }

                chart.getData()
                        .add(series);

                anchor.getChildren()
                        .add(chart);

                AnchorPane.setTopAnchor(chart, 0.0);
                AnchorPane.setBottomAnchor(chart, 0.0);
                AnchorPane.setRightAnchor(chart, 0.0);
                AnchorPane.setLeftAnchor(chart, 0.0);
            }
        });
    }*/

}
