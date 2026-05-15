package Talhoes;

import java.util.Scanner;

public class menuTalhao {

    // Scanner utilizado para leitura das opções do menu
    static Scanner sc = new Scanner(System.in);

    // MENU TALHÕES
    public static void abrirMenuTalhao() {

        int opcao;

        do {

            System.out.println("\n===== MENU TALHÕES =====");

            System.out.println("1 - Cadastrar Talhão");
            System.out.println("2 - Listar Talhões");
            System.out.println("3 - Buscar Talhão");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();

            // Limpa o buffer do Scanner
            sc.nextLine();

            switch (opcao) {

                case 1:

                    CadastroTalhao.cadastrarTalhao();
                    break;

                case 2:

                    CadastroTalhao.listarTalhoes();
                    break;

                case 3:

                    CadastroTalhao.buscarTalhao();
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