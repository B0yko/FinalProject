package com.example.finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoxerManagementApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Boxer Management App");

        // Create menu items
        MenuItem addBoxerMenuItem = new MenuItem("Add Boxer");
        MenuItem editBoxerMenuItem = new MenuItem("Edit Boxer");
        MenuItem deleteBoxerMenuItem = new MenuItem("Delete Boxer");
        MenuItem addMatchMenuItem = new MenuItem("Add Match");
        MenuItem editMatchMenuItem = new MenuItem("Edit Match");
        MenuItem deleteMatchMenuItem = new MenuItem("Delete Match");
        MenuItem exitMenuItem = new MenuItem("Exit");

        // Create menus
        Menu boxerMenu = new Menu("Boxer");
        boxerMenu.getItems().addAll(addBoxerMenuItem, editBoxerMenuItem, deleteBoxerMenuItem);

        Menu matchMenu = new Menu("Match");
        matchMenu.getItems().addAll(addMatchMenuItem, editMatchMenuItem, deleteMatchMenuItem);

        Menu fileMenu = new Menu("File");
        fileMenu.getItems().add(exitMenuItem);

        // Create menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, boxerMenu, matchMenu);

        // Create content area (placeholder)
        VBox contentArea = new VBox();
        contentArea.setPadding(new Insets(10));
        contentArea.getChildren().add(new Label("Welcome to Boxer Management App!"));

        // Create main dashboard
        BorderPane dashboardPane = new BorderPane();
        dashboardPane.setTop(menuBar);
        dashboardPane.setCenter(contentArea);

        // Create scene
        Scene scene = new Scene(dashboardPane, 800, 600);

        // Set scene and show stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
