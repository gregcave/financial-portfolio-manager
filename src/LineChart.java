import javafx.application.Application;
import javafx.event.EventDispatcher;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class LineChart extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        NumberAxis x = new NumberAxis(2015,2018,1);
        x.setLabel("Year");


        NumberAxis y =new NumberAxis(0,800,50);
        y.setLabel("Stock in pounds");

        javafx.scene.chart.LineChart chart = new javafx.scene.chart.LineChart(x,y);

        XYChart.Series attributes = new XYChart.Series();
        XYChart.Series attributes2 = new XYChart.Series();

        attributes.setName("Netflix");
        attributes.getData().add(new XYChart.Data(2015,400));
        attributes.getData().add(new XYChart.Data(2016,300));
        attributes.getData().add(new XYChart.Data(2017,500));
        attributes.getData().add(new XYChart.Data(2018,650));



        attributes2.setName("Amazon");
        attributes2.getData().add(new XYChart.Data(2015,100));
        attributes2.getData().add(new XYChart.Data(2016,222));
        attributes2.getData().add(new XYChart.Data(2017,500));
        attributes2.getData().add(new XYChart.Data(2018,400));



        chart.getData().add(attributes);
        chart.getData().add(attributes2);



        Group group = new Group(chart);
        Scene scene = new Scene(group,800,600);
        primaryStage.setTitle("Line Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(800);



    }
}