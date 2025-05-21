// DBManager – klasa narzędziowa do obsługi bazy danych SQLite (tworzenie tabeli wyników, zapis wyników).
package ludoclub.db;

import java.sql.*;

public class DBManager {
    private static final String DB_URL = "jdbc:sqlite:ludoclub.db";

    // Tworzy tabele do zapisu wyników
    public static void createTables() {
        String sql = "CREATE TABLE IF NOT EXISTS wyniki (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nick TEXT, " +
                "points INTEGER, " +
                "date TEXT" +
                ");";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Zapisuje wynik gracza do bazy
    public static void insertResult(String nick, int points, String date) {
        String sql = "INSERT INTO wyniki(nick, points, date) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nick);
            pstmt.setInt(2, points);
            pstmt.setString(3, date);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
