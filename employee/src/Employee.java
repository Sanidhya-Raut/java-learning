import java.math.BigDecimal;

public class Employee {
    int id;
    String name;
    Double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display(){
        System.out.println(this.toString());
    }

    public void increaseSalary(Double percentage){
        double increasceSalary = salary*percentage/100;
        salary += increasceSalary;
    }
}
