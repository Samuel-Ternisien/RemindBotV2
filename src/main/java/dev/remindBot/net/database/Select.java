package dev.remindBot.net.database;


import java.sql.*;


public class Select {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:data.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS test ("
                + "	id integer PRIMARY KEY,"
                + "	name text NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:data.db";
        Connection conn = null;
        try {
            System.out.println("Connected");
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the test table
     */
    public void selectAll(){
        String sql = "SELECT id, name FROM test";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String name) {
        String sql = "INSERT INTO test(name) VALUES(?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
        Select app = new Select();
        app.insert("test");
        app.selectAll();
    }

}