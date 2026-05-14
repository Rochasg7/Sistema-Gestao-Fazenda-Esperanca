    package Equipe;

    import java.util.Scanner;

    public class MenuEquipe {

        static Scanner sc = new Scanner(System.in);

        public static void menuEquipe() {

            int opcao;

            do {

                System.out.println("\n===== MENU FUNCIONÁRIOS =====");
                System.out.println("1 - Cadastrar Funcionário");
                System.out.println("2 - Listar Funcionários");
                System.out.println("3 - Buscar Funcionário");
                System.out.println("0 - Voltar");

                System.out.print("Opção: ");

                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {

                    case 1:
                        CadastroFuncionario.cadastrarFuncionario();
                        break;

                    case 2:
                        CadastroFuncionario.listarFuncionarios();
                        break;

                    case 3:
                        CadastroFuncionario.buscarFuncionario();
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