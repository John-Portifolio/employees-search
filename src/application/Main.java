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
			sc.nextLine();
			System.out.println("Name:");
			String name = sc.nextLine();
			System.out.println("Salary:");
			double salary = sc.nextDouble();
			Employee employee = new Employee(id, name, salary);
			employees.add(employee);
		}
		
		System.out.println("Enter the employee ID that will have salary increase: ");
		int idToUpdate = sc.nextInt();
		System.out.println("Enter the percentage to increase on employee salary: ");
		int percentageToIncrease = sc.nextInt();
		
		for (Employee employee : employees) {
			if (employee.getId() == idToUpdate) {
				
				double increaseAmount = employee.getSalary() * (percentageToIncrease / 100);
				double newSalary = employee.getSalary() + increaseAmount;
				employee.setSalary(newSalary);
			}
		}
		
		System.out.println("List of employees: ");
		for (Employee employee : employees) {
			
			System.out.println("Id: " + employee.getId() + ", Name: " + employee.getName() + 
					", Salary: " + employee.getSalary());
		}
	}
}
