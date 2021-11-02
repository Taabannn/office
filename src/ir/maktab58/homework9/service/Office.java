package ir.maktab58.homework9.service;

import ir.maktab58.homework9.enumations.SalaryRange;
import ir.maktab58.homework9.models.Branch;
import ir.maktab58.homework9.models.Employee;

import java.util.ArrayList;

/**
 * @author Taban Soleymani
 */
public class Office {
    private EmployeeService employeeService = new EmployeeService();
    private BranchService branchService = new BranchService();

    public void printEmployeesInformation() {
        try {
            ArrayList<Branch> branches = branchService.findAllBranchesAndSortedEmployees(employeeService);
            for (Branch branch : branches) {
                System.out.println("*".repeat(150));
                System.out.println(branch);
                System.out.format("%4s%16s%25s%16s%25s", "row", "entering-year", "salary-range", "personnel-code", "full-name\n");
                ArrayList<Employee> employees = branch.getEmployees();
                printRowsInEmployeesTable(employees);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());;
        }
    }

    private void printRowsInEmployeesTable(ArrayList<Employee> employees) {
        int row = 0;
        int lastYear = 0;
        long lastSalaryAmount = 0;
        for (Employee employee : employees) {
            if (employees.indexOf(employee) == 0) {
                row = 1;
                lastYear = employee.getEnteringYear();
                lastSalaryAmount = employee.getSalary();
                System.out.format("%4s%16s%25s%16s%25s", row, employee.getEnteringYear(), SalaryRange.RANGE1.getVal(employee.getSalary()).getRange(), employee.getPersonnelCode(), employee.getFullName() + "\n");
                continue;
            }

            if (employee.getEnteringYear() == lastYear) {
                if (SalaryRange.RANGE1.getVal(lastSalaryAmount).getRange().equals(SalaryRange.RANGE1.getVal(employee.getSalary()).getRange()))
                    System.out.format("%4s%16s%25s%16s%25s", " ", " ", " ", employee.getPersonnelCode(), employee.getFullName() + "\n");
                else
                    System.out.format("%4s%16s%25s%16s%25s", " ", " ", SalaryRange.RANGE1.getVal(employee.getSalary()).getRange(), employee.getPersonnelCode(), employee.getFullName() + "\n");
                lastSalaryAmount = employee.getSalary();
            } else {
                lastYear = employee.getEnteringYear();
                row++;
                System.out.format("%4s%16s%25s%16s%25s", row, employee.getEnteringYear(), SalaryRange.RANGE1.getVal(employee.getSalary()).getRange(), employee.getPersonnelCode(), employee.getFullName() + "\n");
                lastSalaryAmount = employee.getSalary();
            }
        }
    }

    public void printAllEmployeesInformation() {
        try {
            ArrayList<Branch> branches = branchService.findAllBranchesAndAllEmployees(employeeService);
            for (Branch branch : branches) {
                System.out.println(branch);
                ArrayList<Employee> employees = branch.getEmployees();
                for (Employee employee : employees) {
                    System.out.println(employee);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
