package ir.maktab58.homework9.enumations;

import ir.maktab58.homework9.exceptions.InvalidAmountOfSalaryEx;

/**
 * @author Taban Soleymani
 */
public enum SalaryRange {
    RANGE1("between 1 to 5 million"),
    RANGE2("between 5 to 10 million"),
    RANGE3("over 10 million");

    private String range;

    SalaryRange(String range) {
        this.range = range;
    }

    public SalaryRange getVal (long salary) {
        if (salary >= 1000000 && salary < 5000000)
            return RANGE1;

        if (salary >= 5000000 && salary < 10000000)
            return RANGE2;

        if (salary >= 10000000)
            return RANGE3;

        throw new InvalidAmountOfSalaryEx("The amount of salary cannot be less than 1000000", 500);
    }

    public String getRange() {
        return range;
    }
}
