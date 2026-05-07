package Talhoes;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroTalhao {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Talhao> talhoes = new ArrayList<>();

    public static void main(String[] args) {

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
                    cadastrarTalhao();
                    break;

                case 2:
                    listarTalhoes();
                    break;

                case 3:
                    buscarTalhao();
                    break;

                case 0:
                    System.out.println("Encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    // CADASTRAR
    public static void cadastrarTalhao() {

        Talhao t = new Talhao();

        System.out.print("Código: ");
        t.codigo = sc.nextLine();

        System.out.print("Nome: ");
        t.nome = sc.nextLine();

        System.out.print("Variedade do café: ");
        t.variedadeCafe = sc.nextLine();

        System.out.print("Estimativa: ");
        t.estimativaLitros = sc.nextDouble();
        sc.nextLine();

        talhoes.add(t);

        System.out.println("Talhão cadastrado!");
    }

    // LISTAR
    public static void listarTalhoes() {

        for (Talhao t : talhoes) {

            System.out.println("\nCódigo: " + t.codigo);
            System.out.println("Nome: " + t.nome);
            System.out.println("Variedade: " + t.variedadeCafe);
            System.out.println("Estimativa: " + t.estimativaLitros);
        }
    }

    // BUSCAR
    public static void buscarTalhao() {

        System.out.print("Digite o código: ");
        String codigo = sc.nextLine();

        for (Talhao t : talhoes) {

            if (t.codigo.equals(codigo)) {

                System.out.println("\nTalhão encontrado!");
                System.out.println("Nome: " + t.nome);
                return;
            }
        }

        System.out.println("Talhão não encontrado.");
    }
}