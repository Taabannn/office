package ir.maktab58.homework9.models;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Taban Soleymani
 */
public class Branch {
    int id;
    String branchName;
    String country;
    String county;
    String city;
    String Address;
    ArrayList<Employee> employees = new ArrayList<>();

    public Branch(int id, String branchName, String country, String county, String city, String address) {
        this.id = id;
        this.branchName = branchName;
        this.country = country;
        this.county = county;
        this.city = city;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return id == branch.id && branchName.equals(branch.branchName) && country.equals(branch.country) && county.equals(branch.county) && city.equals(branch.city) && Address.equals(branch.Address) && employees.equals(branch.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchName, country, county, city, Address, employees);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", country='" + country + '\'' +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
