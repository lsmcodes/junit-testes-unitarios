package io.github.lsmcodes.junit;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitApplication {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(JunitApplication.class, args);

		Conversor conversor = new Conversor();

		boolean mostrarMenu = true;
		String opcao;

		while (mostrarMenu) {
			System.out.println("\nMenu:\n"
					+ "1 - Converter celsius para fahrenheit\n"
					+ "2 - Converter fahrenheit para celsius\n"
					+ "Para sair, apenas digite qualquer outro numero");

			opcao = scanner.nextLine();

			switch (opcao) {
				case "1":
					System.out.println("Digite o valor:");
					double celsius = Double.parseDouble(scanner.nextLine());

					conversor.setValorAtual(celsius);
					double celsiusParaFahrenheit = conversor.converterCelsiusParaFahrenheit();
					System.out.println(celsius + "°C é igual a " + celsiusParaFahrenheit + "°F");

					break;
				case "2":
					System.out.println("Digite o valor:");
					double fahrenheit = Double.parseDouble(scanner.nextLine());

					conversor.setValorAtual(fahrenheit);
					double fahrenheitParaCelsius = conversor.converterFahrenheitParaCelsius();
					System.out.println(fahrenheit + "°F é igual a " + fahrenheitParaCelsius + "°C");

					break;
				default:
					mostrarMenu = false;
					break;
			}
		}
	}

}