package Talhoes;

public class buscarTalhao {

    public static void buscarTalhao() {

        if (menuTalhao.totalTalhoes == 0) {

            System.out.println("=====Nenhum talhão cadastrado.=====");
            return;
        }

        System.out.println("\n===== TALHÕES CADASTRADOS =====");

        for (int i = 0; i < menuTalhao.totalTalhoes; i++) {

            System.out.println(
                    "Código: " + menuTalhao.talhoes[i].codigo +
                            " | Nome: " + menuTalhao.talhoes[i].nome);
        }

        System.out.print("\nDigite o código do talhão: ");

        String codigo = menuTalhao.sc.nextLine();

        for (int i = 0; i < menuTalhao.totalTalhoes; i++) {

            if (menuTalhao.talhoes[i].codigo.equals(codigo)) {

                System.out.println("\n===== TALHÃO ENCONTRADO =====");
                System.out.println("Código: " + menuTalhao.talhoes[i].codigo);
                System.out.println("Nome: " + menuTalhao.talhoes[i].nome);
                System.out.println("Variedade do café: " + menuTalhao.talhoes[i].variedadeCafe);
                System.out.println("Estimativa de litros: " + menuTalhao.talhoes[i].estimativaLitros);

                return;
            }
        }

        System.out.println("=====Talhão não encontrado.=====");
    }
}