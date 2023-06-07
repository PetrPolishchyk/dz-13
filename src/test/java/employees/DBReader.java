package employees;

import com.rd.employee.Employee;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER_NAME = "postgres";
    private final static String USER_PASSWORD = "postgres";
    private final static String QUERY_SELECT_ALL = "select * from employee";
    private final static String QUERY_INSERT = "INSERT INTO employee (id, firstname, lastname, email, age) values (?, ?, ?, ?, ?)";
    private final static String QUERY_UPDATE = "update employee set age = ? where id = ?";
    private final static String QUERY_DELETE = "delete from employee where id = ?";

    //select
    public List<Employee> getEmployeesFromDB() {
        List<Employee> employees = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)){
            Statement sqlStatement =  connection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery(QUERY_SELECT_ALL);

            while (resultSet.next()){
                Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("email"),
                        resultSet.getInt("age"));
                employees.add(employee);
            }
        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Something wrong with current connection. " +
                    "Check the URL [%s]", URL));
        }

        return employees;
    }

    //insert
    public void insertNewEmployee(int id, String firstname, String lastname, String email, int age) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstname);
            preparedStatement.setString(3, lastname);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, age);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Something wrong with current connection. " +
                    "Check the URL [%s]", URL));
        }
    }

    //update
    public void updateAgeOfEmployeeById(int id, int age) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Something wrong with current connection. " +
                    "Check the URL [%s]", URL));
        }
    }

    //delete
    public void deleteEmployeeById(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Something wrong with current connection. " +
                    "Check the URL [%s]", URL));
        }
    }
}
