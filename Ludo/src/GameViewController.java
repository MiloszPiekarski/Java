// GameViewController – wyświetla planszę, obsługuje turę, rzut kostką, wizualizację pionków.
package ludoclub.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import ludoclub.model.Game;
import ludoclub.model.Player;
import ludoclub.model.Pawn;

import java.util.Random;

public class GameViewController {
    private Game game;
    private Label statusLabel;
    private GridPane boardGrid;
    private Label diceLabel;
    private int diceRoll = 0;

    public GameViewController(Game game) {
        this.game = game;
    }

    // Tworzy główne okno planszy
    public void start(Stage stage) {
        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        statusLabel = new Label("Tura gracza: " + game.getCurrentPlayer().getUsername());
        diceLabel = new Label("Rzuć kostką!");

        Button rollDiceBtn = new Button("Rzuć kostką");
        rollDiceBtn.setOnAction(e -> rollDice());

        // Tworzenie planszy LUDO
        boardGrid = new GridPane();
        boardGrid.setAlignment(Pos.CENTER);
        boardGrid.setHgap(4);
        boardGrid.setVgap(4);
        boardGrid.setPrefSize(440, 440);
        drawBoard();

        Button saveBtn = new Button("Zapisz grę");
        saveBtn.setOnAction(e -> saveGame());

        Button menuBtn = new Button("Wróć do menu");
        menuBtn.setOnAction(e -> {
            MainMenuController mmc = new MainMenuController();
            mmc.start(stage);
        });

        root.getChildren().addAll(statusLabel, diceLabel, rollDiceBtn, boardGrid, saveBtn, menuBtn);

        Scene scene = new Scene(root, 540, 700);
        stage.setScene(scene);
        stage.setTitle("Ludo Club - Gra");
        stage.show();
    }

    // Rysuje planszę i pionki
    private void drawBoard() {
        boardGrid.getChildren().clear();

        // Uproszczona plansza 11x11, rogi to domy graczy
        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                StackPane cell = new StackPane();
                cell.setPrefSize(36, 36);
                cell.setStyle("-fx-border-color: gray; -fx-background-color: white;");

                // Kolorowe rogi - domy
                if ((row < 4 && col < 4)) {
                    cell.setStyle("-fx-background-color: red; -fx-border-color: gray;");
                } else if (row < 4 && col > 6) {
                    cell.setStyle("-fx-background-color: blue; -fx-border-color: gray;");
                } else if (row > 6 && col < 4) {
                    cell.setStyle("-fx-background-color: green; -fx-border-color: gray;");
                } else if (row > 6 && col > 6) {
                    cell.setStyle("-fx-background-color: yellow; -fx-border-color: gray;");
                }

                boardGrid.add(cell, col, row);
            }
        }

        // Umieszcza pionki na planszy (tu uproszczenie: wszystkie na starcie w [0,0])
        for (Player p : game.getPlayers()) {
            for (Pawn pawn : p.getPawns()) {
                Circle circle = new Circle(12, Color.valueOf(p.getColorName()));
                Tooltip.install(circle, new Tooltip(p.getUsername()));
                boardGrid.add(circle, 0, 0); // TODO: aktualna pozycja pionka
            }
        }
    }

    // Obsługa rzutu kostką
    private void rollDice() {
        Random rand = new Random();
        diceRoll = rand.nextInt(6) + 1;
        diceLabel.setText("Wyrzucono: " + diceRoll);
        statusLabel.setText("Tura gracza: " + game.getCurrentPlayer().getUsername() + ". Wyrzucono: " + diceRoll);
        // TODO: po rzucie kostką umożliwić ruch pionkiem
    }

    // Zapis stanu gry do pliku
    private void saveGame() {
        try (java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(
                new java.io.FileOutputStream("savegame.ser"))) {
            out.writeObject(game);
            System.out.println("Stan gry zapisany!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
