package employees;

import com.rd.employee.Employee;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Executions {
    DBReader dbReader = new DBReader();

    @Test
    public void getEmployeesFromDBToConsole(){
        System.out.println(dbReader.getEmployeesFromDB());
    }

    @Test
    public void getEmployeesFromDBToArray(){
        List<Employee> currentDBEmployees = new ArrayList<>();
        currentDBEmployees = dbReader.getEmployeesFromDB();
    }
    @Test
    public void addNewEmployee(){
        dbReader.insertNewEmployee(10, "Dmitriy", "Zagorodniy", "dim@gmail.com", 50);
        dbReader.insertNewEmployee(11, "Olena", "Kiropka", "kir@gmail.com", 80);
    }
    @Test
    public void updateCurrentEmployeesAge(){
        dbReader.updateAgeOfEmployeeById(10, 55);
    }
    @Test
    public void deleteCurrentEmployee(){
        dbReader.deleteEmployeeById(11);
    }
}
