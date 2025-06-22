package com.project.main;

import com.project.data.DataLoader;
import com.project.recipes.Base;
import com.project.recipes.BaseGenerator;
import com.project.recipes.RecipeManager;
import javafx.scene.Scene;
import com.project.recipes.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import java.util.List;

public class HelloController {
    @FXML private Button searchRecipeButton;
    @FXML private Button listRecipesButton;
    @FXML private Button baseGeneratorButton;
    @FXML private Button exitButton;
    @FXML private VBox contentPane;

    private RecipeManager recipeManager;
    private BaseGenerator baseGenerator;

    @FXML
    public void initialize() {
        DataLoader dataLoader = new DataLoader();
        recipeManager = new RecipeManager(dataLoader);
        baseGenerator = new BaseGenerator(dataLoader);
    }

    @FXML
    private void showSearchRecipe() {
        VBox vbox = new VBox(10);
        TextField searchField = new TextField();
        searchField.setPromptText("Digite o nome da receita");

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        Button backButton = new Button("Voltar");

        // Popup com lista de sugestões
        Popup suggestionPopup = new Popup();
        ListView<String> suggestionList = new ListView<>();
        suggestionList.setPrefWidth(300);
        suggestionPopup.getContent().add(suggestionList);
        suggestionPopup.setAutoHide(true);

        searchField.textProperty().addListener((obs, oldText, newText) -> {
            if (newText.trim().isEmpty()) {
                suggestionPopup.hide();
            } else {
                List<Recipe> filtered = recipeManager.searchMaterials(newText);
                List<String> names = filtered.stream().map(Recipe::getName).toList();
                suggestionList.getItems().setAll(names);

                if (!names.isEmpty()) {
                    if (!suggestionPopup.isShowing()) {
                        double x = searchField.localToScreen(searchField.getBoundsInLocal()).getMinX();
                        double y = searchField.localToScreen(searchField.getBoundsInLocal()).getMaxY();
                        suggestionPopup.show(searchField, x, y);
                    }
                } else {
                    suggestionPopup.hide();
                }
            }
        });

        suggestionList.setOnMouseClicked(e -> {
            String selected = suggestionList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                searchField.setText(selected);
                suggestionPopup.hide();
                resultArea.clear();
                Recipe recipe = recipeManager.getRecipeByName(selected);
                if (recipe != null) {
                    resultArea.appendText("══════════════════════\n");
                    resultArea.appendText("Receita: " + recipe.getName() + "\n");
                    resultArea.appendText("Ingredientes: " + String.join(", ", recipe.getIngredients()) + "\n");
                    resultArea.appendText("Biomas: " + String.join(", ", recipe.getBiomes()) + "\n");
                    resultArea.appendText("Dica: " + recipe.getTip() + "\n");
                    resultArea.appendText("══════════════════════\n");
                }
            }
        });

        backButton.setOnAction(e -> {
            suggestionPopup.hide();
            contentPane.getChildren().clear();
        });

        vbox.getChildren().addAll(searchField, resultArea, backButton);
        contentPane.getChildren().setAll(vbox);
    }

    @FXML
    private void showListRecipes() {
        Stage stage = new Stage();
        TableView<Recipe> table = new TableView<>();
        TableColumn<Recipe, String> nameCol = new TableColumn<>("Receita");
        nameCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        TableColumn<Recipe, String> ingredientsCol = new TableColumn<>("Ingredientes");
        ingredientsCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.join(", ", cellData.getValue().getIngredients())));
        TableColumn<Recipe, String> biomesCol = new TableColumn<>("Biomas");
        biomesCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.join(", ", cellData.getValue().getBiomes())));
        TableColumn<Recipe, String> tipCol = new TableColumn<>("Dica");
        tipCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTip()));
        table.getColumns().addAll(nameCol, ingredientsCol, biomesCol, tipCol);
        table.getItems().addAll(recipeManager.getAllRecipes());
        Scene scene = new Scene(table, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Listar Receitas");
        stage.show();
    }

    @FXML
    private void showBaseGenerator() {
        Stage stage = new Stage();
        VBox vbox = new VBox(10);
        ChoiceBox<String> areaChoice = new ChoiceBox<>();
        areaChoice.getItems().addAll("Kelp Forest", "Grassy Plateaus", "Mushroom Forest", "Bubble Zone", "Lost River", "Inactive Lava Zone");
        areaChoice.setValue("Kelp Forest");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        Button generateButton = new Button("Gerar Base");
        generateButton.setOnAction(e -> {
            String biome = areaChoice.getValue();
            resultArea.clear();
            List<Base> bases = baseGenerator.generateBaseByArea(biome);
            if (bases.isEmpty()) {
                resultArea.setText("Nenhuma base encontrada para este bioma.");
            } else {
                for (Base base : bases) {
                    resultArea.appendText("══════════════════════\n");
                    resultArea.appendText("Base em: " + base.getBiome() + "\n");
                    resultArea.appendText("Progressão: " + base.getProgression() + "\n");
                    resultArea.appendText("Tamanho: " + base.getSize() + "\n");
                    resultArea.appendText("Estruturas: " + String.join(", ", base.getStructures()) + "\n");
                    resultArea.appendText("Dica: " + base.getTip() + "\n");
                    resultArea.appendText("══════════════════════\n");
                }
            }
        });
        vbox.getChildren().addAll(new Label("Selecione o Bioma:"), areaChoice, generateButton, resultArea);
        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Gerador de Bases");
        stage.show();
    }

    @FXML
    private void exit() {
        ((Stage) exitButton.getScene().getWindow()).close();
    }
}