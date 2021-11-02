package ir.maktab58.homework9.service;

import ir.maktab58.homework9.dataaccess.BranchDataBaseAccess;
import ir.maktab58.homework9.models.Branch;
import ir.maktab58.homework9.models.Employee;

import java.util.ArrayList;

/**
 * @author Taban Soleymani
 */
public class BranchService {
    private final BranchDataBaseAccess branchAccess;

    public BranchService() {
        this.branchAccess = new BranchDataBaseAccess();;
    }

    public ArrayList<Branch> findAllBranchesAndSortedEmployees(EmployeeService employeeService) {
        ArrayList<Branch> branches = branchAccess.getAllBranches();
        for (Branch branch : branches) {
            ArrayList<Employee> employees = employeeService.findAndSortEmployees(branch);
            branch.setEmployees(employees);
        }
        return branches;
    }

    public ArrayList<Branch> findAllBranchesAndAllEmployees(EmployeeService employeeService) {
        ArrayList<Branch> branches = branchAccess.getAllBranches();
        for (Branch branch : branches) {
            ArrayList<Employee> employees = employeeService.findAllEmployees(branch);
            branch.setEmployees(employees);
        }
        return branches;
    }
}
