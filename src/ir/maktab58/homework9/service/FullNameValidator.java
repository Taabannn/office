package ir.maktab58.homework9.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Taban Soleymani
 */
public class FullNameValidator {
    private static final String FULL_NAME_PATTERN = "^[\\p{L} .'-]+$"; //unicode

    private static final Pattern pattern = Pattern.compile(FULL_NAME_PATTERN);

    public static boolean isValid(final String fullName) {
        Matcher matcher = pattern.matcher(fullName);
        return matcher.matches();
    }
}
