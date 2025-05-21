// LoadGameController – pozwala użytkownikowi wczytać ostatni zapis gry
package ludoclub.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ludoclub.model.Game;

public class LoadGameController {
    public void start(Stage stage) {
        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 50; -fx-alignment: center;");

        Button loadBtn = new Button("Wczytaj ostatnią grę");
        loadBtn.setOnAction(e -> {
            Game game = loadGame();
            if (game != null) {
                GameViewController gvc = new GameViewController(game);
                gvc.start(stage);
            }
        });

        Button backBtn = new Button("Wróć do menu");
        backBtn.setOnAction(e -> {
            MainMenuController mmc = new MainMenuController();
            mmc.start(stage);
        });

        root.getChildren().addAll(loadBtn, backBtn);
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
    }

    // Wczytuje grę z pliku
    private Game loadGame() {
        try (java.io.ObjectInputStream in = new java.io.ObjectInputStream(
                new java.io.FileInputStream("savegame.ser"))) {
            return (Game) in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
