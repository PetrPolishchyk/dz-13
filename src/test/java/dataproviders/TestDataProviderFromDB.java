package dataproviders;

import employees.DBReader;
import org.testng.annotations.DataProvider;

public class TestDataProviderFromDB {

    @DataProvider(name = "employees")
    public static Object[][] employeesFromDB() {
        DBReader dbReader = new DBReader();

        return dbReader.getEmployeesFromDB().stream().map(employee -> new Object[]{employee.getId(), employee.getFirstName(),
                employee.getLastName(), employee.getEmail(), employee.getAge()}).toArray(Object[][]::new);
    }
}
