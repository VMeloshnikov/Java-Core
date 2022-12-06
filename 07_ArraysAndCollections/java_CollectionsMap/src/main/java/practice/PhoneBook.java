package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    TreeMap<String, Set<String>> phoneBook = new TreeMap<>();
    String checkName = "^[а-яА-яЁё]+$";
    String checkPhone = "[+?7-8]9\\d{9}";

    public boolean isName(String name) {
        return name.matches(checkName);
    }

    public boolean isPhone(String phone) {
        return phone.matches(checkPhone);
    }

    public void addContact(String phone, String name) {
        if (isName(name) && isPhone(phone)) {
            for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
                if (entry.getValue().contains(phone)) {
                    phoneBook.remove(entry.getKey());
                }
            }
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(phone);
            } else {
                TreeSet<String> phones = new TreeSet<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            }
        }
    }

    public String getContactByPhone(String phone) {
        String contactPhone = "";
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                String keyName = entry.getKey();
                StringJoiner number = new StringJoiner(",");
                for (String number1 : entry.getValue()) {
                    number.add(number1);
                }
                contactPhone = keyName + " - " + number;
            } else if (contactPhone.isEmpty()) {
                contactPhone = "";
            }
        }
        return contactPhone;
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            if (entry.getKey().contains(name)) {
                StringJoiner number = new StringJoiner(", ");
                for (String phone : entry.getValue()) {
                    number.add(phone);
                }
                names.add(name + " - " + number);
            }
        }
        return names;
    }

    public Set<String> getAllContacts() {
        TreeSet<String> allPhones = new TreeSet<>();
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            String keyName = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            StringJoiner number = new StringJoiner(", ");
            for (String phone : phoneNumbers) {
                number.add(phone);
            }
            allPhones.add(keyName + " - " + number);
        }
        return allPhones;
    }
}


