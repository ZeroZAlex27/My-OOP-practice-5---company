import java.sql.*;

public class Positions extends Main {
    public static void addPosition(int id, String name, int salary) throws SQLException { // Creating a method for adding positions
        stmt.executeQuery("Insert into positions (id, name, salary) values (" + id + ", '" + name + "', " + salary + ");");
    }

    public static void showPositionByID(int id) throws SQLException { // Creating a method for viewing position data by ID
        ResultSet rs = stmt.executeQuery("Select * from positions Where id =" + id + ";");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }
    }

    public static void listOfPositions() throws SQLException { // Creating a method for showing a full list of positions
        ResultSet rs = stmt.executeQuery("Select * from positions;");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }
    }

    public static void updatePositionByID(int id, String name, int salary) throws SQLException { //Creating a method to change position data
        stmt.executeQuery("Update employees Set name = '" + name + "', salary = " + salary + " Where id = " + id + ";");
    }

    public static void deletePositionByID(int id) throws SQLException { // Creating a method for deleting positions by ID
        stmt.executeQuery("Delete from positions Where id =" + id + ";");
    }
}
