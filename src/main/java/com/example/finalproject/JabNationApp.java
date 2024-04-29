package com.example.finalproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.RangeSlider;

public class JabNationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        GridPane top = createColoredBox(Color.BLACK);
        GridPane top2 = createColoredBox(Color.DARKRED);
        GridPane down = createColoredBox(Color.LIGHTGRAY);


        VBox filterBox = new VBox();
        VBox infoBox = new VBox();
        GridPane mainPane = new GridPane();

        top.setPrefSize(12000, 40);
        top2.setPrefSize(12000, 110);

        ImageView logoImageView = new ImageView(new Image("file:///Users/andrejbojko/Downloads/logo3.png"));
        logoImageView.setFitWidth(130);
        logoImageView.setFitHeight(100);

        Button addBoxerButton = new Button("Add Boxer");
        addBoxerButton.setOnAction(e -> openAddBoxerDialog());

        Button deleteBoxerButton = new Button("Delete Boxer");

        Button boxerList = new Button("Boxers List");

        Button addFight = new Button("Add Fight");
        Button deleteFight = new Button("Delete Fight");
        Button matchesList = new Button("Matches List");

        Button signUp = new Button("Sign Up");
        Button login = new Button("Login");

        top.setPadding(new Insets(10));
        top.add(signUp, 0, 0);

        GridPane.setMargin(signUp, new Insets(0, 40, 0, 20));
        top.add(login, 1, 0);

        GridPane.setMargin(login, new Insets(0, 0, 0, 0));

        top2.setPadding(new Insets(10));
        top2.add(addBoxerButton, 0, 0);

        GridPane.setMargin(addBoxerButton, new Insets(0, 100, 0, 20));
        top2.add(deleteBoxerButton, 1, 0);

        GridPane.setMargin(deleteBoxerButton, new Insets(0, 100, 0, 0));
        top2.add(boxerList, 2, 0);

        GridPane.setMargin(boxerList, new Insets(0, 60, 0, 0));
        top2.add(logoImageView, 3, 0);
        top2.add(addFight, 4, 0);

        GridPane.setMargin(addFight, new Insets(0, 0, 0, 60));
        top2.add(deleteFight, 5, 0);

        GridPane.setMargin(deleteFight, new Insets(0, 0, 0, 100));
        top2.add(matchesList, 6, 0);

        GridPane.setMargin(matchesList, new Insets(0, 20, 0, 100));

        filterBox.setPadding(new Insets(10));
        Label filters = new Label("Filters:");
        filters.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold;");

        CheckComboBox<String> nationChoiceBox = new CheckComboBox<>();
        nationChoiceBox.getItems().addAll("USA", "UK", "Germany", "France", "Japan");
        Button chooseAllNationsButton = new Button("Choose All");
        chooseAllNationsButton.setOnAction(e -> {
            if (nationChoiceBox.getCheckModel().getCheckedItems().isEmpty()) {
                nationChoiceBox.getCheckModel().checkAll();
            } else {
                nationChoiceBox.getCheckModel().clearChecks();
            }
        });

        CheckComboBox<String> divisionChoiceBox = new CheckComboBox<>();
        divisionChoiceBox.getItems().addAll("Flyweight", "Featherweight", "Lightweight", "Welterweight", "Middleweight", "Light Heavyweight", "Heavyweight", "Super Heavyweight");
        Button chooseAllDivisionsButton = new Button("Choose All");
        chooseAllDivisionsButton.setOnAction(e -> {
            if (divisionChoiceBox.getCheckModel().getCheckedItems().isEmpty()) {
                divisionChoiceBox.getCheckModel().checkAll();
            } else {
                divisionChoiceBox.getCheckModel().clearChecks();
            }
        });

        Slider ageSlider = new Slider(0, 120, 18);
        RangeSlider ageRangeSlider = new RangeSlider(0, 120, 18, 60);

        Slider heightSlider = new Slider(0, 240, 180);
        RangeSlider heightRangeSlider = new RangeSlider(0, 240, 160, 200);

        Slider reachSlider = new Slider(0, 240, 180);
        RangeSlider reachRangeSlider = new RangeSlider(0, 240, 160, 200);

        ageSlider.setShowTickLabels(true);
        ageSlider.setShowTickMarks(true);
        heightSlider.setShowTickLabels(true);
        heightSlider.setShowTickMarks(true);
        reachSlider.setShowTickLabels(true);
        reachSlider.setShowTickMarks(true);

        Label ageRangeLabel = new Label("Age: " + ageSlider.getValue());
        Label heightRangeLabel = new Label("Height: " + heightSlider.getValue());
        Label reachRangeLabel = new Label("Reach: " + reachSlider.getValue());

        ageSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            ageRangeLabel.setText("Age Range: " + newValue.intValue());
        });

        ageRangeSlider.lowValueProperty().addListener((observable, oldValue, newValue) -> {
            ageSlider.setMin(newValue.intValue());
            ageRangeLabel.setText("Age Range: " + newValue.intValue() + " - " + ageRangeSlider.highValueProperty().getValue().intValue());
        });

        ageRangeSlider.highValueProperty().addListener((observable, oldValue, newValue) -> {
            ageSlider.setMax(newValue.intValue());
            ageRangeLabel.setText("Age Range: " + ageRangeSlider.lowValueProperty().getValue().intValue() + " - " + newValue.intValue());
        });


        heightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            heightRangeLabel.setText("Height Range: " + newValue.intValue());
        });

        heightRangeSlider.lowValueProperty().addListener((observable, oldValue, newValue) -> {
            heightSlider.setMin(newValue.intValue());
            heightRangeLabel.setText("Height Range: " + newValue.intValue() + " - " + heightRangeSlider.highValueProperty().getValue().intValue());
        });

        heightRangeSlider.highValueProperty().addListener((observable, oldValue, newValue) -> {
            heightSlider.setMax(newValue.intValue());
            heightRangeLabel.setText("Age Range: " + heightRangeSlider.lowValueProperty().getValue().intValue() + " - " + newValue.intValue());
        });


        reachSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            reachRangeLabel.setText("Reach Range: " + newValue.intValue());
        });

        reachRangeSlider.lowValueProperty().addListener((observable, oldValue, newValue) -> {
            reachSlider.setMin(newValue.intValue());
            reachRangeLabel.setText("Reach Range: " + newValue.intValue() + " - " + reachRangeSlider.highValueProperty().getValue().intValue());
        });

        reachRangeSlider.highValueProperty().addListener((observable, oldValue, newValue) -> {
            reachSlider.setMax(newValue.intValue());
            reachRangeLabel.setText("Reach Range: " + reachRangeSlider.lowValueProperty().getValue().intValue() + " - " + newValue.intValue());
        });

        CheckBox activeFightersCheckBox = new CheckBox("Active");
        CheckBox inactiveFightersCheckBox = new CheckBox("Inactive");

        VBox.setMargin(nationChoiceBox, new Insets(0, 0, 10, 0));
        VBox.setMargin(chooseAllNationsButton, new Insets(0, 0, 30, 0));
        VBox.setMargin(filters, new Insets(0, 0, 30, 0));
        VBox.setMargin(divisionChoiceBox, new Insets(0, 0, 10, 0));
        VBox.setMargin(chooseAllDivisionsButton, new Insets(0, 0, 30, 0));
        VBox.setMargin(ageRangeLabel, new Insets(0, 0, 30, 0));
        VBox.setMargin(heightRangeLabel, new Insets(0, 0, 30, 0));
        VBox.setMargin(reachRangeLabel, new Insets(0, 0, 30, 0));
        VBox.setMargin(activeFightersCheckBox, new Insets(10, 0, 5, 0));


        filterBox.getChildren().addAll(
                filters,
                new Label("Nations:"),
                nationChoiceBox,
                chooseAllNationsButton,
                new Label("Weight Divisions:"),
                divisionChoiceBox,
                chooseAllDivisionsButton,
                new Label("Age:"),
                ageRangeSlider,
                ageRangeLabel,
                new Label("Height:"),
                heightRangeSlider,
                heightRangeLabel,
                new Label("Reach:"),
                reachRangeSlider,
                reachRangeLabel,
                new Label("Active Status:"),
                activeFightersCheckBox,
                inactiveFightersCheckBox
        );
        filterBox.setPrefWidth(300);

        TableView<Boxer> tableView = new TableView<>();
        tableView.setPrefSize(600, 600);

        TableColumn<Boxer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Boxer, String> nicknameColumn = new TableColumn<>("Nickname");
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));

        TableColumn<Boxer, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<Boxer, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Boxer, String> recordColumn = new TableColumn<>("Record");
        recordColumn.setCellValueFactory(new PropertyValueFactory<>("record"));

        TableColumn<Boxer, String> divisionColumn = new TableColumn<>("Division");
        divisionColumn.setCellValueFactory(new PropertyValueFactory<>("division"));

        TableColumn<Boxer, Double> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<Boxer, Double> heightColumn = new TableColumn<>("Height");
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Boxer, Double> reachColumn = new TableColumn<>("Reach");
        reachColumn.setCellValueFactory(new PropertyValueFactory<>("reach"));

        TableColumn<Boxer, String> nationColumn = new TableColumn<>("Nation");
        nationColumn.setCellValueFactory(new PropertyValueFactory<>("nation"));

        TableColumn<Boxer, Boolean> activeColumn = new TableColumn<>("Active");
        activeColumn.setCellValueFactory(new PropertyValueFactory<>("active"));

        tableView.getColumns().addAll(
                nameColumn, nicknameColumn, surnameColumn, ageColumn,
                recordColumn, divisionColumn, weightColumn, heightColumn, reachColumn, nationColumn, activeColumn);

        ObservableList<Boxer> boxers = FXCollections.observableArrayList(
                new Boxer("John", "The Champ", "Doe", 30, "20-0", "Middleweight", 70, 185, 190, "USA", true),
                new Boxer("Mike", "Iron Fist", "Smith", 25, "15-3", "Flyweight", 60, 170, 169, "UK", true),
                new Boxer("Alex", "The Beast", "Johnson", 28, "18-2", "Heavyweight", 90, 190, 195, "France", false)
        );
        tableView.setItems(boxers);

        ScrollPane listBox = new ScrollPane(tableView);
        listBox.setPrefWidth(600);


        mainPane.add(filterBox, 0, 0);
        mainPane.add(listBox, 1, 0);
        mainPane.add(infoBox, 2, 0);

        root.add(top, 0, 0);
        root.add(top2, 0, 1);
        root.add(mainPane, 0, 2);
        root.add(down, 0, 3);
        down.setPrefSize(12000, 60);


        Scene scene = new Scene(root, 1200, 900);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JabNation App");
        primaryStage.show();

        // Обработчик событий для отображения информации о выбранном боксере в InfoBox
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                infoBox.getChildren().clear();
                Label nameLabel = new Label("Name: " + newSelection.getName());
                Label nicknameLabel = new Label("Nickname: " + newSelection.getNickname());
                Label surnameLabel = new Label("Surname: " + newSelection.getSurname());
                Label ageLabel = new Label("Age: " + newSelection.getAge());
                Label recordLabel = new Label("Record: " + newSelection.getRecord());
                Label divisionLabel = new Label("Division: " + newSelection.getDivision());
                Label weightLabel = new Label("Weight: " + newSelection.getWeight());
                Label heightLabel = new Label("Height: " + newSelection.getHeight());
                Label reachLabel = new Label("Reach: " + newSelection.getReach());
                Label nationLabel = new Label("Nation: " + newSelection.getNation());
                Label activeLabel = new Label("Active: " + (newSelection.isActive() ? "Yes" : "No"));

                infoBox.getChildren().addAll(nameLabel, nicknameLabel, surnameLabel, ageLabel, recordLabel,
                        divisionLabel, weightLabel, heightLabel, reachLabel, nationLabel, activeLabel);
            }
        });
    }

    private GridPane createColoredBox(Color color) {
        GridPane box = new GridPane();
        box.setStyle("-fx-background-color: " + toRGBCode(color) + ";");
        return box;
    }

    private String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    private void openAddBoxerDialog() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setTitle("Add Boxer");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        TextField nameField = new TextField();
        TextField surnameField = new TextField();

        gridPane.add(new Label("Name:"), 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(new Label("Surname:"), 0, 1);
        gridPane.add(surnameField, 1, 1);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            System.out.println("Added Boxer: " + name + " " + surname);

            dialogStage.close();
        });

        gridPane.add(addButton, 0, 2, 2, 1);
        Scene scene = new Scene(gridPane);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    public class Boxer {
        private String name;
        private String nickname;
        private String surname;
        private int age;
        private String record;
        private String division;
        private double weight;
        private double height;
        private double reach;
        private String nation;
        private boolean active;

        public Boxer(String name, String nickname, String surname, int age, String record, String division, double weight, double height, double reach, String nation, boolean active) {
            this.name = name;
            this.nickname = nickname;
            this.surname = surname;
            this.age = age;
            this.record = record;
            this.division = division;
            this.weight = weight;
            this.height = height;
            this.reach = reach;
            this.nation = nation;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getRecord() {
            return record;
        }

        public void setRecord(String record) {
            this.record = record;
        }

        public String getDivision() {
            return division;
        }

        public void setDivision(String division) {
            this.division = division;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getReach() {
            return reach;
        }

        public void setReach(double reach) {
            this.reach = reach;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}






