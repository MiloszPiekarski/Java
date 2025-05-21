// Main – klasa startowa JavaFX, uruchamia menu i inicjuje bazę danych
package ludoclub;

import javafx.application.Application;
import javafx.stage.Stage;
import ludoclub.gui.MainMenuController;
import ludoclub.db.DBManager;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        DBManager.createTables(); // Tworzy tabele w bazie przy starcie
        MainMenuController menu = new MainMenuController();
        menu.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args); // Uruchamia aplikację JavaFX
    }
}
