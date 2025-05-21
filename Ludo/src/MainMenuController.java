// MainMenuController – obsługuje główne menu gry (nowa gra, wczytaj, wyjdź)
package ludoclub.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuController {
    public void start(Stage stage) {
        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 50; -fx-alignment: center;");

        Button newGameBtn = new Button("Nowa Gra");
        Button loadGameBtn = new Button("Wczytaj Grę");
        Button exitBtn = new Button("Wyjdź");

        // Przycisk: Nowa Gra
        newGameBtn.setOnAction(e -> {
            NewGameController ng = new NewGameController();
            ng.start(stage);
        });

        // Przycisk: Wczytaj Grę
        loadGameBtn.setOnAction(e -> {
            LoadGameController lg = new LoadGameController();
            lg.start(stage);
        });

        // Przycisk: Wyjdź
        exitBtn.setOnAction(e -> stage.close());

        root.getChildren().addAll(newGameBtn, loadGameBtn, exitBtn);

        Scene scene = new Scene(root, 350, 300);
        stage.setScene(scene);
        stage.setTitle("Ludo Club - Menu Główne");
        stage.show();
    }
}
