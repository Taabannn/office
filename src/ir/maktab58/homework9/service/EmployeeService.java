package ir.maktab58.homework9.service;

import ir.maktab58.homework9.dataaccess.EmployeeDataBaseAccess;
import ir.maktab58.homework9.exceptions.IllegalFullName;
import ir.maktab58.homework9.exceptions.IllegalPersonnelCode;
import ir.maktab58.homework9.exceptions.InvalidAmountOfSalaryEx;
import ir.maktab58.homework9.models.Branch;
import ir.maktab58.homework9.models.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Taban Soleymani
 */
public class EmployeeService {
    private final EmployeeDataBaseAccess employeeAccess;

    public EmployeeService()  {
        this.employeeAccess = new EmployeeDataBaseAccess();
    }

    public ArrayList<Employee> findAndSortEmployees(Branch branch) {
        ArrayList<Employee> employees = employeeAccess.getLastFiveYearsEmployees(branch);
        validateEmployeesInformation(employees);
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                CompareEmployeesEnteringYear comparator1 = new CompareEmployeesEnteringYear();
                int result = comparator1.compare(o1, o2);
                if (result == 0) {
                    CompareEmployeesRangeOfSalary comparator2 = new CompareEmployeesRangeOfSalary();
                    result = comparator2.compare(o1, o2);
                    if (result == 0) {
                        CompareEmployeesPersonnelCode comparator3 = new CompareEmployeesPersonnelCode();
                        return comparator3.compare(o1, o2);
                    }
                }
                return result;
            }
        });
        return employees;
    }

    public ArrayList<Employee> findAllEmployees(Branch branch) {
        ArrayList<Employee> employees = employeeAccess.getAllEmployees(branch);
        validateEmployeesInformation(employees);
        return employeeAccess.getAllEmployees(branch);
    }

    public void validateEmployeesInformation(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getSalary() < 1000000)
                throw new InvalidAmountOfSalaryEx("The salary cannot be less than 1000000", 500);

            if (!FullNameValidator.isValid(employee.getFullName()))
                throw new IllegalFullName(employee.getFullName() + " is not valid full name", 500);

            if (PersonnelCodeValidator.isValid(employee.getPersonnelCode()))
                throw new IllegalPersonnelCode(employee.getPersonnelCode() + "is not valid personnel code", 500);
        }
    }
}
