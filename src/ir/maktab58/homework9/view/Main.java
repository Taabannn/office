package ir.maktab58.homework9.view;

import ir.maktab58.homework9.service.Office;

/**
 * @author Taban Soleymani
 */
public class Main {
    public static void main(String[] args) {
        Office office = new Office();
//        System.out.println("This is all employees Information:(and branches are included too)");
//        office.printAllEmployeesInformation();
//        System.out.println("This is sorted employees Information of each branch:(employees who are working in branches less than 5 years)");
        office.printEmployeesInformation();
    }
}
