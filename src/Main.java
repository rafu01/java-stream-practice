import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("a1", "n1", 1));
        employeeList.add(new Employee("a2", "n2", 2));
        employeeList.add(new Employee("a3", "n3", 2));
        employeeList.add(new Employee("a4", "n4", 2));
        employeeList.add(new Employee("a5", "n5", 2));
        employeeList.add(new Employee("a6", "n6", 3));
        employeeList.add(new Employee("a7", "n7", 3));
        employeeList.add(new Employee("a8", "n8", 4));

        // Group by age
        Map<Integer, List<Employee>> groupByAge = employeeList.stream()
                .collect(groupingBy(Employee::getAge));
        // convert to Map
        Map<String, Integer> convertToMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getAge));
        // count number of each age
        Map<Integer, Long> countEachAge = employeeList.stream()
                .collect(groupingBy(Employee::getAge, counting()));
        // sum each number of age
        Map<Integer, Integer> sumEachAge = employeeList.stream()
                .collect(groupingBy(Employee::getAge, summingInt(Employee::getAge)));

        countEachAge.keySet()
                .forEach(key -> System.out.println(key + " : " + countEachAge.get(key)));
        countEachAge.entrySet().forEach(keyValue -> System.out.println(keyValue.getKey() + "" + keyValue.getValue()));
        countEachAge.forEach((key, value) -> System.out.println(key + "" + value));

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        // find average
        nums.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
        // find average of odds
        nums.stream().filter(num -> num%2!=0).mapToDouble(Integer::doubleValue).average().orElse(0);
        // find distinct
        nums.stream().distinct();
    }
}