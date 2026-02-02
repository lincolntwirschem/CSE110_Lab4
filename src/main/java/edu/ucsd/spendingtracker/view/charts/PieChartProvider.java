package edu.ucsd.spendingtracker.view.charts;
import java.util.Map;

import edu.ucsd.spendingtracker.model.Category;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class PieChartProvider implements IChartProvider{
    @Override
    public Node createChart(Map<Category, Double> data) {
        PieChart chart = new PieChart();

        data.forEach((cat, sum) -> {
            PieChart.Data d = new PieChart.Data(cat.name(), sum);
            String color = cat.color;
            chart.getData().add(d);
            d.getNode().setStyle(
                "-fx-pie-color: " + color + ";"
            );
        });

        chart.setLegendVisible(false);
        return chart;
    }

    @Override 
    public String getDisplayName(){
        return "Pie Chart";
    }
}
