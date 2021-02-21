import java.sql.*;

public class Project extends Main {
    public static int getProjectCost(int projectDevelopmentTime, int costsOfCreatingAWorkingEnvironment) throws SQLException { //Creating a main method for calculating the cost of the project
        int cost = costsOfCreatingAWorkingEnvironment;
        int numberOfEmployees = 0;
        ResultSet rs = stmt.executeQuery("Select id from employees Order by id desc limit 1;");
        while (rs.next()) {
            numberOfEmployees = rs.getInt(1);
        }
        rs = stmt.executeQuery("Select salary from employees;");
        while (rs.next()) {
            cost += rs.getInt(1) * projectDevelopmentTime;
        }
        return cost;
    }
}
