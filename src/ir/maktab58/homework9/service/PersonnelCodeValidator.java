package ir.maktab58.homework9.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Taban Soleymani
 */
public class PersonnelCodeValidator {
    private static final String PERSONNEL_CODE_PATTERN = "\\d{10}";

    private static final Pattern pattern = Pattern.compile(PERSONNEL_CODE_PATTERN);

    public static boolean isValid(final long personnelCode) {
        Matcher matcher = pattern.matcher(String.valueOf(personnelCode));
        return matcher.matches();
    }
}
