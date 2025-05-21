// User – abstrakcyjna klasa bazowa dla Player i Bot, trzyma nazwę i kolor (jako String).
package ludoclub.model;
import javafx.scene.paint.Color;


import javafx.scene.paint.Color;
import java.io.Serializable;

public abstract class User implements Serializable {
    protected String username;
    protected String colorName; // SERIALIZOWALNE!
    protected transient Color color; // NIE serializujemy!

    public User(String username, String colorName){
        this.username = username;
        this.colorName = colorName;
        this.color = Color.valueOf(colorName); // Ustaw od razu!
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getColorName() { return colorName; }
    public void setColorName(String colorName) {
        this.colorName = colorName;
        this.color = Color.valueOf(colorName); // Od razu odśwież kolor!
    }

    // UWAGA: ZAWSZE korzystaj z tej metody w GUI do rysowania!
    public Color getColor() {
        // Jeśli color == null (np. po wczytaniu z pliku), zbuduj na podstawie colorName
        if (color == null && colorName != null)
            color = Color.valueOf(colorName);
        return color;
    }

    public abstract String getUserType();
}
