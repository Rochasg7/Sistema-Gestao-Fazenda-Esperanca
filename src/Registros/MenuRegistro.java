package Registros;

import java.util.Scanner;

public class MenuRegistro {

    static Scanner sc = new Scanner(System.in);

    public static void menuRegistro() {

        int opcao;

        do {

            System.out.println("\n===== MENU COLHEITA =====");
            System.out.println("1 - Registrar Colheita");
            System.out.println("2 - Listar Registros");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    RegistrosService.registrarColheita();
                    break;

                case 2:
                    RegistrosService.listarRegistros();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

    }

}