package Talhoes;

import java.util.Scanner;

public class menuTalhao {

    static Scanner sc = new Scanner(System.in);

    // VETOR DE TALHÕES
    static Talhao[] talhoes = new Talhao[100];

    // CONTADOR
    static int totalTalhoes = 0;

    public static void menuTalhao() {

        int opcao;

        do {

            System.out.println("\n1 - Cadastrar Talhão");
            System.out.println("2 - Listar Talhões");
            System.out.println("3 - Buscar Talhão");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarTalhao.cadastrarTalhao();
                    break;

                case 2:
                    listarTalhao.listarTalhoes();
                    break;

                case 3:
                    buscarTalhao.buscarTalhao();
                    break;

                case 0:
                    System.out.println("Encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}