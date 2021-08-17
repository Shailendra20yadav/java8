
import java.util.*;
import java.util.stream.Collectors;

public class MapOperation {

  public static void main(String[] args) {

      sortMap();
  }

    private static void sortMap() {
        Employee e1 = new Employee(101, "CHETAN", 3000);
        HashMap<Integer, Employee> hm  = new HashMap<>();
        hm.put(101, e1);
        hm .put(100,new Employee(100,"abc", 1000));

        System.out.println("Sort by value");

        hm.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName))).forEach(e->{
            System.out.println(e.getKey()+"= "+e.getValue().getName());
        });

        HashMap<Integer, Employee> hm2 = hm.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(en -> en.getKey(), en ->en.getValue(), (en1,en2)->en1, LinkedHashMap::new));
        System.out.println("Sort by key");
        hm2.entrySet().forEach(e->{

            System.out.println(e.getKey()+"= "+e.getValue().getName());

        });

        //
    }

    private static void convertListToMap(){

        List<Employee> list = List.of(new Employee(1,"test",1000));

        Map<Integer,String> map = list.stream().filter(Objects::nonNull).collect(Collectors.toMap(Employee::getId,Employee::getName));

        //

        Optional<String> op = Optional.ofNullable("Test");
        op.ifPresentOrElse(s -> s.toLowerCase(Locale.ROOT), () -> op.orElseThrow());

    }

}


class Employee
{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}





