import java.math.BigDecimal;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1,"Ram", 1200.90));
        empList.add(new Employee(2,"Rahim", 1000.90));
        empList.add(new Employee(3,"Rohan", 2000.90));
        empList.add(new Employee(4,"Rajesh", 5200.90));
        empList.add(new Employee(5,"Ramakant", 78200.90));


        for (Employee emp: empList){
            emp.display();
        }
        for (Employee emp: empList){
            emp.increaseSalary(10d);
        }
        System.out.println("--------------10% Increase--------");
        for (Employee emp: empList){
            emp.display();
        }

    }
}