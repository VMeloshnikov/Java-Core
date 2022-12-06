import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_homework_1 {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, (o1, o2) -> {
            if (o1.getSalary().compareTo(o2.getSalary()) != 0) {
                return o1.getSalary().compareTo(o2.getSalary());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Employee employee : staff) {
            System.out.println(employee);
        }
    }
}