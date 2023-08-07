package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Empregado;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Quantos funcionários será cadastrado: ");
		int num = sc.nextInt();

		ArrayList<Empregado> lista = new ArrayList<>();

		System.out.println("Cadastre seus funcionários: ");
		for (int i = 0; i < num; i++) {
			System.out.println("\n--------------------------------");
			System.out.printf("%d° funcionário", i + 1);

			System.out.print("\nID: ");
			int id = sc.nextInt();
			while (procurarID(lista, id)) {
				System.out.println("\nEste ID já existe... Tente novamente: ");
				System.out.println("\nDigite novamente\nID: ");
				id = sc.nextInt();
			}
			sc.nextLine();

			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			Double salario = sc.nextDouble();

			lista.add(new Empregado(id, nome, salario));

		}

		System.out.println("\n--------------------------------");
		System.out.println("Vamos aumentar o salário de um funcionáro: ");
		System.out.print("Digite a ID do funcionário: ");

		while (true) {
			int id = sc.nextInt();

			Empregado empregado = lista.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);

			if (empregado == null) {
				System.out.println("\n--------------------------------");
				System.out.println("ID digitada não existe: ");
				System.out.print("Digite a ID do funcionário: ");

			} else {
				System.out.print("Porcentagem de aumento salárial: ");
				int porcento = sc.nextInt();
				empregado.aumentoSalario(porcento);
				break;
			}
		}

		System.out.println("\n--------------------------------");
		System.out.println("Lista de funcionários atualizado: ");

		for (Empregado x : lista) {
			System.out.println(x.toString());
			System.out.println();
		}

		sc.close();
	}

	public static Boolean procurarID(List<Empregado> lista, int id) {
		Empregado emp = lista.stream().filter(var -> var.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
