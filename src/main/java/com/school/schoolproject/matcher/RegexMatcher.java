package com.school.schoolproject.matcher;

import java.util.regex.Pattern;

public class RegexMatcher {

    public static boolean matchEmail(String email){
        String regexPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        return Pattern.matches(regexPattern,email);

    }
}
