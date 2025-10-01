import java.util.HashMap;
import java.util.Map;

class EmployeeNotFound extends Exception {
    public EmployeeNotFound(String message) {
        super(message);
    }
}

class EmployeeMap {
    private Map<Integer, String> employeeMap;

    public EmployeeMap() {
        employeeMap = new HashMap<>();
    }

    public void addEmployee(int id, String name) {
        employeeMap.put(id, name);
    }

    public String getEmployeeName(int id) throws EmployeeNotFound{
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFound("Error: Employee ID not found!");
        }
        return employeeMap.get(id);
    }

    public void displayAllEmployees() {
        System.out.println("Employee Map:");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        EmployeeMap em = new EmployeeMap();

        System.out.println("Adding employees...");
        em.addEmployee(101, "Lakshay");
        em.addEmployee(102, "Mukesh");
        em.addEmployee(103, "Tapesh");

        em.displayAllEmployees();

        try {
            System.out.println("Name for ID 102: " + em.getEmployeeName(102));
        } catch (EmployeeNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Name for ID 999: " + em.getEmployeeName(999));
        } catch (EmployeeNotFound e) {
            System.out.println("Name for ID 999: " + e.getMessage());
        }
    }
}

