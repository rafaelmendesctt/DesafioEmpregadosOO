package application;

import java.util.Locale;
import java.util.Scanner;
	
import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nome do departamento: ");
		String nameDepartment = scanner.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDayDepartment = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Telefone: ");
		String phone = scanner.nextLine();
		Department dept = new Department(nameDepartment, payDayDepartment, new Address(email, phone));

		System.out.print("Quantos funcionários tem o departamento? ");
		int cont = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < cont; i++) {
			System.out.println("Dados do funcionário " + i + 1 + ": ");
			System.out.print("Nome: ");
			String nameEmployee = scanner.nextLine();
			System.out.print("Salário: ");
			double salaryEmployee = scanner.nextDouble();
			scanner.nextLine();

			dept.addEmployee(new Employee(nameEmployee, salaryEmployee));
		}

		showReport(dept);

		scanner.close();
	}

	public static void showReport(Department dept) {
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO: ");
		System.out.printf("Departamento Vendas = R$ %.2f%n", dept.payroll());
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários: ");
		for (Employee e : dept.getEmployees()) {
			System.out.println(e.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}
}
