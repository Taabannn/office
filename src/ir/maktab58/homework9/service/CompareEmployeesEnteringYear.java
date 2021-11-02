package ir.maktab58.homework9.service;

import ir.maktab58.homework9.models.Employee;

import java.util.Comparator;

/**
 * @author Taban Soleymani
 */
public class CompareEmployeesEnteringYear implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        Integer o1EnteringYear = o1.getEnteringYear();
        Integer o2EnteringYear = o2.getEnteringYear();
        return o2EnteringYear.compareTo(o1EnteringYear);
    }
}
