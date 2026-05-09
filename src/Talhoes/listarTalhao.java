package Talhoes;

public class listarTalhao {

    public static void listarTalhoes() {

        if (menuTalhao.totalTalhoes == 0) {

            System.out.println("Nenhum talhão cadastrado.");
            return;
        }

        System.out.println("\n===== TALHÕES =====");

        for (int i = 0; i < menuTalhao.totalTalhoes; i++) {

            System.out.println(
                    (i + 1) + " - " +
                            menuTalhao.talhoes[i].nome);
        }

        System.out.print("\nEscolha um talhão: ");

        int escolha = menuTalhao.sc.nextInt();
        menuTalhao.sc.nextLine();

        // VALIDAÇÃO
        if (escolha < 1 || escolha > menuTalhao.totalTalhoes) {

            System.out.println("Talhão inválido.");
            return;
        }

        Talhao t = menuTalhao.talhoes[escolha - 1];

        System.out.println("\n===== DADOS DO TALHÃO =====");
        System.out.println("Código: " + t.codigo);
        System.out.println("Nome: " + t.nome);
        System.out.println("Variedade: " + t.variedadeCafe);
        System.out.println("Estimativa: " + t.estimativaLitros);
    }
}