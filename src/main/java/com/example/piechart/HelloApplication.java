package com.example.piechart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {
    Button button;
    Button label;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        FlowPane root=new FlowPane();
        PieChart pieChart=new PieChart();
        ObservableList<PieChart.Data> data= FXCollections.observableArrayList();
        data.addAll(new PieChart.Data("java",49),new PieChart.Data("js",70),new PieChart.Data("phyton",75),new PieChart.Data("Frame Works",80));
        pieChart.setData(data);
         button=new Button("play");
         button.setOnAction(this);
         label=new Button("label");
         label.setOnAction(this);
        root.getChildren().addAll(pieChart,label,button);
        stage.setTitle("Hello!");
        Scene scene=new Scene(root);

        stage.setScene(scene);
      //  stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource().equals(button)){
            button.setBackground(Background.fill(Color.LIGHTBLUE));
            label.setText("you click label");
        }
        if (event.getSource().equals(label)){
            label.setBackground(Background.fill(Color.RED));
            button.setText("you click button");
        }
    }
}