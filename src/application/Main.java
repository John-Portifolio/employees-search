package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many employees will be registred?");
		int n = sc.nextInt();
		
		List<Employee> employees = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1));
			
			System.out.println("Id:");
			int id = sc.nextInt();
			while(hasId(employees, id)) {
				System.out.println("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			sc.nextLine();
			System.out.println("Name:");
			String name = sc.nextLine();
			System.out.println("Salary:");
			double salary = sc.nextDouble();
			Employee employee = new Employee(id, name, salary);
			employees.add(employee);
		}
		
		System.out.println("\nEnter the employee ID that will have salary increase: ");
		int id = sc.nextInt();
		
		Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("This id does not exist!");
		}else {
			System.out.println("Enter the percentage to increase on employee salary: ");
			int percentageToIncrease = sc.nextInt();
			emp.increaseSalary(percentageToIncrease);
		}
		
		System.out.println("------------------------------------------------------");
		
		System.out.println("List of employees: ");
		for (Employee employee : employees) {
			
			System.out.println("Employee #" + (employees.indexOf(employee) + 1) + " | Id: " + employee.getId() + ", Name: " + employee.getName() + 
					", Salary: " + employee.getSalary());
		}
		
		
	}
		public static boolean hasId(List<Employee> employees, int id ) {
			Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
			return emp != null;
	}
}