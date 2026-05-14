package Equipe;

import Equipe.PersistenciaFuncionario;

import java.util.Scanner;

import Dados.Registros;

public class CadastroFuncionario {

    static Scanner sc = new Scanner(System.in);

    public static void cadastrarFuncionario() {

        Funcionario funcionario = new Funcionario();

        System.out.println("\n===== CADASTRO FUNCIONÁRIO =====");

        System.out.print("Nome: ");
        funcionario.nome = sc.nextLine();

        System.out.print("Matrícula: ");
        funcionario.matricula = sc.nextLine();

        if (matriculaExiste(funcionario.matricula)) {

            System.out.println("Matrícula já cadastrada.");
            return;
        }

        System.out.print("Tipo de contrato: ");
        funcionario.tipoContrato = sc.nextLine();

        Registros.funcionarios[Registros.totalFuncionarios] = funcionario;

        Registros.totalFuncionarios++;

        PersistenciaFuncionario.salvarFuncionariosCSV();

        System.out.println("Funcionário cadastrado com sucesso.");
    }

    public static void listarFuncionarios() {

        if (Registros.totalFuncionarios == 0) {

            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\n===== LISTA DE FUNCIONÁRIOS =====");

        for (int i = 0; i < Registros.totalFuncionarios; i++) {

            Funcionario funcionario = Registros.funcionarios[i];

            System.out.println("----------------------");
            System.out.println("Nome: " + funcionario.nome);
            System.out.println("Matrícula: " + funcionario.matricula);
            System.out.println("Contrato: " + funcionario.tipoContrato);
        }
    }

    public static void buscarFuncionario() {

        System.out.print("Digite a matrícula: ");

        String matricula = sc.nextLine();

        for (int i = 0; i < Registros.totalFuncionarios; i++) {

            Funcionario funcionario = Registros.funcionarios[i];

            if (funcionario.matricula.equalsIgnoreCase(matricula)) {

                System.out.println("\nFuncionário encontrado:");
                System.out.println("Nome: " + funcionario.nome);
                System.out.println("Matrícula: " + funcionario.matricula);
                System.out.println("Contrato: " + funcionario.tipoContrato);

                return;
            }
        }

        System.out.println("Funcionário não encontrado.");
    }

    public static boolean matriculaExiste(String matricula) {

        for (int i = 0; i < Registros.totalFuncionarios; i++) {

            if (Registros.funcionarios[i].matricula.equalsIgnoreCase(matricula)) {

                return true;
            }
        }

        return false;
    }
}