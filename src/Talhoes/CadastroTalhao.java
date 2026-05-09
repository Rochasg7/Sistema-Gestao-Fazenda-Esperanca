package talhoes;

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

        System.out.print("Código do Talhão: ");
        String codigo = sc.nextLine();

        // VERIFICA SE O CÓDIGO JÁ EXISTE
        for (Talhao talhao : talhoes) {

            if (talhao.codigo.equals(codigo)) {

                System.out.println("Já existe um talhão com esse código!");
                return;
            }
        }

        t.codigo = codigo;

        System.out.print("Nome do Talhão: ");
        t.nome = sc.nextLine();

        System.out.print("Variedade do café: ");
        t.variedadeCafe = sc.nextLine();

        System.out.print("Estimativa de litros: ");
        t.estimativaLitros = sc.nextDouble();
        sc.nextLine();

        talhoes.add(t);

        System.out.println("Talhão cadastrado!");
    }

    // LISTAR
    public static void listarTalhoes() {

        if (talhoes.isEmpty()) {
            System.out.println("Nenhum talhão cadastrado.");
            return;
        }

        System.out.println("\n===== TALHÕES =====");

        for (int i = 0; i < talhoes.size(); i++) {

            System.out.println(
                    (i + 1) + " - " + talhoes.get(i).nome);
        }

        System.out.print("\nEscolha um talhão: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        Talhao t = talhoes.get(escolha - 1);

        System.out.println("\n===== DADOS DO TALHÃO =====");
        System.out.println("Código: " + t.codigo);
        System.out.println("Nome: " + t.nome);
        System.out.println("Variedade: " + t.variedadeCafe);
        System.out.println("Estimativa: " + t.estimativaLitros);
    }

    // BUSCAR
    // BUSCAR
    public static void buscarTalhao() {

        System.out.print("Digite o código: ");
        String codigo = sc.nextLine();

        for (Talhao t : talhoes) {

            if (t.codigo.equals(codigo)) {

                System.out.println("\n===== TALHÃO ENCONTRADO =====");
                System.out.println("Código: " + t.codigo);
                System.out.println("Nome: " + t.nome);
                System.out.println("Variedade do café: " + t.variedadeCafe);
                System.out.println("Estimativa de litros: " + t.estimativaLitros);

                return;
            }
        }

        System.out.println("Talhão não encontrado.");
    }
}