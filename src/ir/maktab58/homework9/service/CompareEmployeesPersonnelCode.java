package ir.maktab58.homework9.service;

import ir.maktab58.homework9.models.Employee;

import java.util.Comparator;

/**
 * @author Taban Soleymani
 */
public class CompareEmployeesPersonnelCode implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        Long o1PersonnelCode = o1.getPersonnelCode();
        Long o2PersonnelCode = o2.getPersonnelCode();
        return o1PersonnelCode.compareTo(o2PersonnelCode);
    }
}
