import java.sql.*;

public class Main {
    static Connection con;
    static Statement stmt;

    public static Statement connection() throws SQLException { // Creating a method to connect to the database
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Company", "postgres",
                "root");
        Statement stmt = con.createStatement();
        return stmt;
    }

    public static void main(String[] args) {
        try {
            stmt = connection(); // Connecting to the database
            System.out.println(Project.getProjectCost(12, 10000)); //Calling methods for the example
            //Employees.addEmployee(15,"Nonna", "Tuxsell", 1516, "Recruiting Manager");
            //Employees.showEmployeeByID(15);
            //Employees.listOfEmployees();
            //Employees.updateEmployeeByID(10, "Cammi", "Flahive", 1256, "Programmer II");
            //Employees.deleteEmployeeByID(11);
            //Employees.setEmployeesSalary();
            //Positions.addPosition(7, "Network Administrator", 2100);
            //Positions.showPositionByID(5);
            //Positions.listOfPositions();
            //Positions.updatePositionByID(4, "IT Analyst", 1255);
            //Positions.deletePositionByID(2);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}