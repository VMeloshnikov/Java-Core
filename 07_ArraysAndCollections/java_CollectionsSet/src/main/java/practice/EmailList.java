package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    Set<String> mailSet = new TreeSet<>();
    String anyMail;


    public boolean validEmail(String email) {
        String opportunity = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(opportunity);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void add(String email) {
        anyMail = (email != null && !email.isEmpty()) ? email.toLowerCase() : "";
        if (validEmail(anyMail)) {
            mailSet.add(anyMail);
        }
    }

    public List<String> getSortedEmails() {
        return new ArrayList<>(mailSet);

        }
    }
