package Talhoes;

import java.util.Scanner;

public class cadastrarTalhao {

    static Scanner sc = new Scanner(System.in);

    public static void cadastrarTalhao() {

        Talhao talhao = new Talhao();

        System.out.println("\n===== CADASTRO TALHÃO =====");

        System.out.print("Código: ");
        talhao.codigo = sc.nextLine();

        if (codigoExiste(talhao.codigo)) {

            System.out.println("Código já cadastrado.");
            return;
        }

        System.out.print("Nome: ");
        talhao.nome = sc.nextLine();

        System.out.print("Variedade do café: ");
        talhao.variedadeCafe = sc.nextLine();

        System.out.print("Estimativa de litros: ");
        talhao.estimativaLitros = Double.parseDouble(sc.nextLine());

        System.out.print("Produção atual: ");
        talhao.producaoAtual = Double.parseDouble(sc.nextLine());

        menuTalhao.talhoes[menuTalhao.totalTalhoes] = talhao;

        menuTalhao.totalTalhoes++;

        persistenciaTalhao.salvarTalhoesCSV();

        System.out.println("Talhão cadastrado com sucesso.");
    }

    public static void listarTalhoes() {

        if (menuTalhao.totalTalhoes == 0) {

            System.out.println("Nenhum talhão cadastrado.");
            return;
        }

        System.out.println("\n===== LISTA DE TALHÕES =====");

        for (int i = 0; i < menuTalhao.totalTalhoes; i++) {

            Talhao talhao = menuTalhao.talhoes[i];

            System.out.println("----------------------");
            System.out.println("Código: " + talhao.codigo);
            System.out.println("Nome: " + talhao.nome);
            System.out.println("Variedade: " + talhao.variedadeCafe);
            System.out.println("Estimativa: " + talhao.estimativaLitros);
            System.out.println("Produção Atual: " + talhao.producaoAtual);
        }
    }

    public static void buscarTalhao() {

        System.out.print("Digite o código: ");

        String codigo = sc.nextLine();

        for (int i = 0; i < menuTalhao.totalTalhoes; i++) {

            Talhao talhao = menuTalhao.talhoes[i];

            if (talhao.codigo.equalsIgnoreCase(codigo)) {

                System.out.println("\nTalhão encontrado:");
                System.out.println("Código: " + talhao.codigo);
                System.out.println("Nome: " + talhao.nome);
                System.out.println("Variedade: " + talhao.variedadeCafe);
                System.out.println("Estimativa: " + talhao.estimativaLitros);
                System.out.println("Produção Atual: " + talhao.producaoAtual);

                return;
            }
        }

        System.out.println("Talhão não encontrado.");
    }

    public static boolean codigoExiste(String codigo) {

        for (int i = 0; i < menuTalhao.totalTalhoes; i++) {

            if (menuTalhao.talhoes[i].codigo.equalsIgnoreCase(codigo)) {

                return true;
            }
        }

        return false;
    }
}