package ir.maktab58.homework9.dataaccess;

import ir.maktab58.homework9.models.Branch;
import ir.maktab58.homework9.models.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Taban Soleymani
 */
public class EmployeeDataBaseAccess extends DataBaseAccess {
    public EmployeeDataBaseAccess() {
        super();
    }

    public ArrayList<Employee> getLastFiveYearsEmployees(Branch branch){
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from employee where branch_id=" + branch.getId() + " and entering_year > (select max(entering_year) from employee) - 5");
                ArrayList<Employee> employees = new ArrayList<>();
                while (resultSet.next()) {
                    Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getInt(3), resultSet.getInt(4),
                            resultSet.getInt(5));
                    employees.add(employee);
                }
                return employees;
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }

    public ArrayList<Employee> getAllEmployees(Branch branch){
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from employee where branch_id=" + branch.getId());
                ArrayList<Employee> employees = new ArrayList<>();
                while (resultSet.next()) {
                    Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getInt(3), resultSet.getInt(4),
                            resultSet.getInt(5));
                    employees.add(employee);
                }
                return employees;
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }
}
