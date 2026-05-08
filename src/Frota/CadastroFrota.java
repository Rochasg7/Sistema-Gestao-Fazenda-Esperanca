package Frota;

import java.util.Scanner;

public class CadastroFrota {
    static Scanner sc = new Scanner(System.in);

    static Frota tratores[] = new Frota[100];
    static int totalTratores = 0;

    public static void cadastrarTrator() {
        Frota novoTrator = new Frota();
        
        System.out.println("---CADASTRO DE TRATOR---");
        System.out.println("Placa: ");
        novoTrator.placa = sc.nextLine();

        System.out.println("Capacidade: ");
        novoTrator.capacidade = sc.nextDouble();

        sc.nextLine();
        
        tratores[totalTratores] = novoTrator;
        
        totalTratores++;

        System.out.println("Trator cadastrado!");
    }
}
