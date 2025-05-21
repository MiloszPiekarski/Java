// NewGameController – konfiguruje nową grę (wybór graczy, nicki, kolory), uruchamia planszę.
package ludoclub.gui;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import ludoclub.model.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class NewGameController {
    private final Game game = new Game();
    private final ArrayList<TextField> playerNameFields = new ArrayList<>();
    private final ArrayList<ComboBox<String>> playerTypeBoxes = new ArrayList<>();
    private final String[] COLORS = { "RED", "BLUE", "GREEN", "YELLOW" };

    public void start(Stage stage) {
        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 40; -fx-alignment: center;");

        Label title = new Label("Konfiguracja nowej gry LUDO CLUB");
        root.getChildren().add(title);

        // Konfigurator 4 graczy (nick + Player/Bot)
        for (int i = 0; i < 4; i++) {
            HBox h = new HBox(10);
            ComboBox<String> typeBox = new ComboBox<>();
            typeBox.getItems().addAll("Player", "Bot");
            typeBox.getSelectionModel().select(0);

            TextField nameField = new TextField();
            nameField.setPromptText("Nick gracza #" + (i + 1));

            h.getChildren().addAll(new Label("Gracz " + (i+1)), typeBox, nameField);
            playerTypeBoxes.add(typeBox);
            playerNameFields.add(nameField);
            root.getChildren().add(h);
        }

        Button startBtn = new Button("Start!");
        startBtn.setOnAction(e -> {
            game.getPlayers().clear();
            for (int i = 0; i < 4; i++) {
                String type = playerTypeBoxes.get(i).getValue();
                String name = playerNameFields.get(i).getText();
                if (name == null || name.isEmpty()) name = "Anonim" + (i+1);

                User u;
                if (type.equals("Bot")) {
                    u = new Bot(name, COLORS[i]);
                } else {
                    u = new Player(name, COLORS[i]);
                }

                game.addPlayer((Player)u);

                // Dodaj pionki gracza
                for (int p = 0; p < 4; p++) {
                    Pawn pawn = new Pawn((Player) u);
                    ((Player)u).addPawn(pawn);
                }
            }
            // Przejście do okna gry
            GameViewController gameView = new GameViewController(game);
            gameView.start(stage);
        });

        root.getChildren().add(startBtn);

        Scene scene = new Scene(root, 480, 400);
        stage.setScene(scene);
    }
}
