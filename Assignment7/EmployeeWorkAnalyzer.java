import java.util.*;

class Employee {
    private String name;
    private List<Integer> workHours;

    public Employee(String name, List<Integer> workHours) {
        this.name = name;
        this.workHours = workHours;
    }

    public List<Integer> getWorkHours() {
        return workHours;
    }
}

public class EmployeeWorkAnalyzer {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", Arrays.asList(8, 8, 8, 8, 8))); // Total hours: 40
        employees.add(new Employee("Alice", Arrays.asList(9, 8, 8, 8, 8))); // Total hours: 41
        employees.add(new Employee("Bob", Arrays.asList(7, 8, 8, 8, 8))); // Total hours: 39
        employees.add(new Employee("Emily", Arrays.asList(8, 8, 7, 8, 8))); // Total hours: 39

        Map<String, Integer> countPerCategory = new HashMap<>();
        Map<String, Double> averageHoursPerCategory = new HashMap<>();

        for (Employee employee : employees) {
            List<Integer> workHours = employee.getWorkHours();
            int totalHours = workHours.stream().mapToInt(Integer::intValue).sum();
            String category = getWorkCategory(totalHours);
            countPerCategory.put(category, countPerCategory.getOrDefault(category, 0) + 1);

            double averageHours = totalHours / (double) workHours.size();
            averageHoursPerCategory.put(category,
                    averageHoursPerCategory.getOrDefault(category, 0.0) + averageHours);
        }

        System.out.println("Employee Work Hours Analysis:");
        for (String category : countPerCategory.keySet()) {
            int count = countPerCategory.get(category);
            double averageHours = averageHoursPerCategory.get(category) / count;
            System.out.printf("Category: %s, Employees: %d, Average Hours per Day: %.2f%n",
                    category, count, averageHours);
        }
    }

    private static String getWorkCategory(int totalHours) {
        if (totalHours > 40)
            return "More than 40 hours";
        else if (totalHours == 40)
            return "Exactly 40 hours";
        else
            return "Less than 40 hours";
    }
}