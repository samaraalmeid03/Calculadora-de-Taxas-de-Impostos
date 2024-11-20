package exercicioFixacaoAbstract.application;

import exercicioFixacaoAbstract.entities.Company;
import exercicioFixacaoAbstract.entities.Individual;
import exercicioFixacaoAbstract.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        //Define o padrão de localização como EUA (para uso do ponto como separador de casas decimais)
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); //Configura o Scanner para seguir o padrão de localização definido

        //Cria uma lista para armazenar os pagadores de impostos (tax payers)
        List<TaxPayer> listOfPayers= new ArrayList<>();

        //Solicita ao usuário o número de contribuintes que serão cadastrados
        System.out.print("Enter the number of tax payers: ");
        int numberOfPayers = sc.nextInt();

        //Loop para coletar os dados de cada contribuinte (pagador de impostos)
        for (int i=1; i<= numberOfPayers; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char choice = sc.next().charAt(0);
            sc.nextLine(); //Limpeza de buffer
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if (choice == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                listOfPayers.add(new Individual(name, anualIncome, healthExpenditures)); //Instancia um objeto do tipo Individual e adiciona à lista
            }
            else if (choice == 'c') {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                listOfPayers.add(new Company(name, anualIncome, numberOfEmployees)); //Instancia um objeto do tipo Company e adiciona à lista
            }
            else {
                System.out.print("Enter a valid value!");
                i--; //Decrementa o índice para permitir ao usuário refazer a entrada
            }
        }

        //Exibe os nomes das pessoas físicas ou jurídicas e o valor dos impostos a serem pagos
        System.out.println("\nTAXES PAID: ");
        for (TaxPayer taxPayers : listOfPayers) {
            System.out.printf(taxPayers.getName() + ": $ %.2f%n", taxPayers.tax());
        }

        // Calcula e exibe a soma total dos impostos a serem pagos por todos os contribuintes
        double sum = 0.0;
        for (TaxPayer taxPayers : listOfPayers) {
            sum += taxPayers.tax();
        }
        System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", sum)); //Exibe o resultado da soma das taxas

        sc.close(); //Fechamento do scanner para desalocar recursos
    }
}
