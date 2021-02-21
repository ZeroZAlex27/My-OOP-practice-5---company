import java.sql.*;

public class Employees extends Main {
    public static void addEmployee(int id, String name, String surname, int salary, String position) throws SQLException { // Creating a method for adding employees
        stmt.executeQuery("Insert into employees (id, name, surname, salary, position) values (" + id + ", '" + name + "', '"
                + surname + "', " + salary + ", '" + position + "');");
    }

    public static void showEmployeeByID(int id) throws SQLException { // Creating a method for viewing employee data by ID
        ResultSet rs = stmt.executeQuery("Select * from employees Where id =" + id + ";");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5));
        }
    }

    public static void listOfEmployees() throws SQLException { // Creating a method for showing a full list of employees
        ResultSet rs = stmt.executeQuery("Select * from employees;");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5));
        }
    }

    public static void updateEmployeeByID(int id, String name, String surname, int salary, String position) throws SQLException { //Creating a method to change employee data
        stmt.executeQuery("Update employees Set name = '" + name + "', surname = '" + surname + "', salary = " + salary + ", position = '" + position + "' Where id = " + id + ";");
    }

    public static void deleteEmployeeByID(int id) throws SQLException { // Creating a method for deleting employees by ID
        stmt.executeQuery("Delete from employees Where id =" + id + ";");
    }

    public static void setEmployeesSalary() throws SQLException { // Creating a method for setting specific salaries associated with employee positions
        ResultSet rs = stmt.executeQuery("Select id from positions Order by id desc limit 1;");
        int numberOfPositions = 0;
        while (rs.next()){
            numberOfPositions = rs.getInt(1);
        }
        rs = stmt.executeQuery("Select id from employees Order by id desc limit 1;");
        int numberOfEmployees = 0;
        while (rs.next()){
            numberOfEmployees = rs.getInt(1);
        }
        for (int i = 1; i <= numberOfPositions; i++) {
            String nameOfPosition = "null";
            int salaryOfPosition = 0;
            rs = stmt.executeQuery("Select name, salary from positions Where id =" + i + ";");
            while (rs.next()){
                nameOfPosition = rs.getString(1);
                salaryOfPosition = rs.getInt(2);
            }
            for (int j = 1; j <= numberOfEmployees; j++) {
                rs = stmt.executeQuery("Select position from employees Where id =" + j + ";");
                String currentPosition = "null";
                while (rs.next()) {
                    currentPosition = rs.getString(1);
                }
                if (nameOfPosition.equals(currentPosition)) {
                    rs = stmt.executeQuery("Update employees Set salary =" + salaryOfPosition + "Where id =" + j + ";");
                }
            }
        }
    }
}
