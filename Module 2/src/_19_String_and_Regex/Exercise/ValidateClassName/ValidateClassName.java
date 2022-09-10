package _19_String_and_Regex.Exercise.ValidateClassName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String CLASSNAME_REGEX = "^([ACP])+(\\d{4})+([G-M])$";
    public ValidateClassName() {
        pattern = Pattern.compile(CLASSNAME_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
