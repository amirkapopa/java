package com.example.lab10u2510164;

// u2510164 AMIR PULATOV - Lab 10: Football Player Registration Form (JavaFX)
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lab10_U2510164 extends Application {

    // ---------- the controls (fields, so the buttons can reach them) ----------
    private TextField nameField = new TextField();
    private TextField ageField = new TextField();
    private TextField positionField = new TextField();

    private RadioButton rbProfessional = new RadioButton("Professional");
    private RadioButton rbAmateur = new RadioButton("Amateur");
    private ToggleGroup categoryGroup = new ToggleGroup();

    private ChoiceBox<String> skillBox = new ChoiceBox<>();

    private Button btnSubmit = new Button("Submit");
    private Button btnClear = new Button("Clear");

    @Override
    public void start(Stage stage) {
        // 1. Set up the controls
        Label title = new Label("Football Player Registration");

        rbProfessional.setToggleGroup(categoryGroup);   // only one can be selected
        rbAmateur.setToggleGroup(categoryGroup);

        skillBox.getItems().addAll("Beginner", "Intermediate", "Advanced");

        // 2. Lay them out in a grid: grid.add(control, column, row)
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Player Name:"), 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(new Label("Age:"), 0, 1);
        grid.add(ageField, 1, 1);

        grid.add(new Label("Position:"), 0, 2);
        grid.add(positionField, 1, 2);

        grid.add(new Label("Category:"), 0, 3);
        grid.add(new VBox(6, rbProfessional, rbAmateur), 1, 3);

        grid.add(new Label("Skill Level:"), 0, 4);
        grid.add(skillBox, 1, 4);

        // 3. Buttons in a row: Submit left, Clear pushed to the right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox buttons = new HBox(btnSubmit, spacer, btnClear);

        // 4. What each button does when clicked
        btnSubmit.setOnAction(e -> submitForm());
        btnClear.setOnAction(e -> clearForm());

        // 5. Put everything in the window and show it
        VBox root = new VBox(15, title, grid, buttons);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 420, 360);
        stage.setTitle("Football Player Registration");
        stage.setScene(scene);
        stage.show();
    }

    // Submit: read every input and print it in the required format
    private void submitForm() {
        String name = nameField.getText();
        String position = positionField.getText();

        // Age must be a whole number
        int age;
        try {
            age = Integer.parseInt(ageField.getText().trim());
        } catch (NumberFormatException ex) {
            System.out.println("Error: Age must be a number.");
            return;
        }

        // Category: which radio button is selected
        String category;
        if (rbProfessional.isSelected()) {
            category = "Professional";
        } else if (rbAmateur.isSelected()) {
            category = "Amateur";
        } else {
            category = "Not selected";
        }

        // Skill level: getValue() is null if nothing was chosen
        String skill = skillBox.getValue();
        if (skill == null) {
            skill = "Not selected";
        }

        System.out.println("----- Player Info -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Position: " + position);
        System.out.println("Category: " + category);
        System.out.println("Skill Level: " + skill);
    }

    // Clear: empty all fields and remove all selections
    private void clearForm() {
        nameField.clear();
        ageField.clear();
        positionField.clear();
        categoryGroup.selectToggle(null);
        skillBox.setValue(null);
        System.out.println("Form cleared.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}