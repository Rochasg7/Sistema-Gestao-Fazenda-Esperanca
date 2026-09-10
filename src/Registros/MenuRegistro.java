package Registros;

import java.util.Scanner;

import Util.Entrada;

public class MenuRegistro {

    // Scanner único, compartilhado por todo o sistema (ver Util.Entrada)
    static Scanner sc = Entrada.sc;

    // MENU DE REGISTROS DE COLHEITA
    public static void abrirMenuRegistro() {

        int opcao;

        do {

            System.out.println("\n===== MENU COLHEITA =====");

            System.out.println("1 - Registrar Colheita");
            System.out.println("2 - Listar Registros");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();

            // Limpa o buffer do Scanner
            sc.nextLine();

            switch (opcao) {

                case 1:

                    // Abre o cadastro de registros de colheita
                    RegistrosService.registrarColheita();
                    break;

                case 2:

                    // Lista todos os registros cadastrados
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