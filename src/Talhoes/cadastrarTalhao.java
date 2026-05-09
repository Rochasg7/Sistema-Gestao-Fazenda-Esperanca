package Talhoes;

public class cadastrarTalhao {

    public static void cadastrarTalhao() {

        Talhao t = new Talhao();

        System.out.print("Código do Talhão: ");

        String codigo = menuTalhao.sc.nextLine();

        // VERIFICA SE O CÓDIGO JÁ EXISTE
        for (int i = 0; i < menuTalhao.totalTalhoes; i++) {

            if (menuTalhao.talhoes[i].codigo.equals(codigo)) {

                System.out.println("=====Já existe um talhão com esse código!=====");
                return;
            }
        }

        t.codigo = codigo;

        System.out.print("Nome do Talhão: ");
        t.nome = menuTalhao.sc.nextLine();

        System.out.print("Variedade do café: ");
        t.variedadeCafe = menuTalhao.sc.nextLine();

        System.out.print("Estimativa de litros: ");
        t.estimativaLitros = menuTalhao.sc.nextDouble();

        menuTalhao.sc.nextLine();

        menuTalhao.talhoes[menuTalhao.totalTalhoes] = t;

        menuTalhao.totalTalhoes++;

        System.out.println("=====Talhão cadastrado!=====");
    }
}