package ir.maktab58.homework9.models;

import java.util.Objects;

/**
 * @author Taban Soleymani
 */
public class Employee {
    int id;
    String fullName;
    long personnelCode;
    long salary;
    int enteringYear;

    public Employee(int id, String fullName, long personnelCode, long salary, int enteringYear) {
        this.id = id;
        this.fullName = fullName;
        this.personnelCode = personnelCode;
        this.salary = salary;
        this.enteringYear = enteringYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(long personnelCode) {
        this.personnelCode = personnelCode;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getEnteringYear() {
        return enteringYear;
    }

    public void setEnteringYear(int enteringYear) {
        this.enteringYear = enteringYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return personnelCode == employee.personnelCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personnelCode);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", personnelCode=" + personnelCode +
                ", salary=" + salary +
                ", enteringYear=" + enteringYear +
                '}';
    }
}