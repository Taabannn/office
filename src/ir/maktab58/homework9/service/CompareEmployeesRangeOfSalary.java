package ir.maktab58.homework9.service;

import ir.maktab58.homework9.exceptions.InvalidAmountOfSalaryEx;
import ir.maktab58.homework9.models.Employee;

import java.util.Comparator;

/**
 * @author Taban Soleymani
 */
public class CompareEmployeesRangeOfSalary implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getSalary() < 1000000 || o2.getSalary() < 1000000)
            throw new InvalidAmountOfSalaryEx("The amount of employees salary cannot be less than 1000000", 500);

        if (o1.getSalary() >= 1000000 && o1.getSalary() < 5000000)
            if (o2.getSalary() >= 1000000 && o2.getSalary() < 5000000)
                return 0;

        if (o1.getSalary() >= 5000000 && o1.getSalary() < 10000000)
            if (o2.getSalary() >= 5000000 && o2.getSalary() < 10000000)
                return 0;

        if (o1.getSalary() >= 10000000 && o2.getSalary() >= 10000000)
            return 0;

        return Long.compare(o1.getSalary(), o2.getSalary());
    }
}
