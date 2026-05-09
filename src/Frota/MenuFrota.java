package Frota;

import java.util.Scanner;

public class MenuFrota {

    static Scanner sc = new Scanner(System.in);

    public static void menuFrota() {

        int opcao;

        do {

            System.out.println("\n===== MENU FROTA =====");

            System.out.println("1 - Cadastrar Trator");
            System.out.println("2 - Listar Tratores");
            System.out.println("3 - Buscar Trator");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();

            // Limpa o buffer do Scanner
            sc.nextLine();

            switch(opcao) {

                case 1:

                    CadastroFrota.cadastrarTrator();

                    break;

                case 2:

                    CadastroFrota.listarTratores();

                    break;

                case 3:

                    CadastroFrota.buscarTrator();

                    break;

                case 0:

                    System.out.println("Voltando...");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while(opcao != 0);
    }
}