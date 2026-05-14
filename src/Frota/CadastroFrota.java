package Frota;

import java.util.Scanner;

public class CadastroFrota {

    // Scanner usado para leitura dos dados digitados pelo usuário
    static Scanner sc = new Scanner(System.in);

    // Vetor responsável por armazenar todos os tratores cadastrados
    static Frota tratores[] = new Frota[100];

    // Controla quantos tratores já foram cadastrados
    static int totalTratores = 0;

    // MÉTODO RESPONSÁVEL PELO CADASTRO DE NOVOS TRATORES
    public static void cadastrarTrator() {

        // Verifica se o limite máximo do vetor foi atingido
        if(totalTratores >= 100) {

            System.out.println("Limite máximo de tratores atingido!");

            return;
        }

        // Cria um novo objeto do tipo Frota
        Frota novoTrator = new Frota();

        System.out.println("=== CADASTRO DE TRATOR ===");

        // Recebe a placa do trator
        System.out.println("Placa: ");
        novoTrator.placa = sc.nextLine();

        // Verifica se a placa já existe no sistema, para evitar cadastro duplicado
        if(placaExiste(novoTrator.placa)) {

            System.out.println("Placa já cadastrada!");

            return;
        }

        // Recebe a capacidade máxima do trator
        System.out.println("Capacidade: ");
        novoTrator.capacidade = sc.nextDouble();

        // Limpa o buffer do Scanner
        sc.nextLine();

        // Armazena o trator no vetor
        tratores[totalTratores] = novoTrator;

        // Incrementa o contador de tratores cadastrados
        totalTratores++;

        System.out.println("Trator cadastrado com sucesso!");
    }

    // LISTAGEM DOS TRATORES CADASTRADOS
    public static void listarTratores() {

        System.out.println("=== LISTA DE TRATORES ===");

        if (totalTratores == 0){
            System.out.println("Nenhum trator cadastrado.");
            return;
        }

        // Percorre o vetor mostrando os tratores cadastrados
        for(int i = 0; i < totalTratores; i++) {

            System.out.println("Placa: " + tratores[i].placa);

            System.out.println("Capacidade: " + tratores[i].capacidade);

            System.out.println("----------------------");
        }
    }

    // VERIFICA SE UMA PLACA JÁ EXISTE NO SISTEMA
    public static boolean placaExiste(String placaDigitada) {

        // Percorre todos os tratores cadastrados
        for(int i = 0; i < totalTratores; i++) {

            // equalsIgnoreCase ignora letras maiúsculas/minúsculas
            if(tratores[i].placa.equalsIgnoreCase(placaDigitada)) {

                return true;
            }
        }

        return false;
    }

    // VALIDA SE A CARGA ESTÁ DENTRO DA CAPACIDADE
    public static boolean validarCapacidade(String placaDigitada, double litros) {

        // Procura o trator pela placa
        for(int i = 0; i < totalTratores; i++) {

            if(tratores[i].placa.equalsIgnoreCase(placaDigitada)) {

                // Verifica se a quantidade transportada
                // está dentro da capacidade máxima
                if(litros <= tratores[i].capacidade) {

                    return true;

                } else {

                    return false;
                }
            }
        }

        // Caso a placa não seja encontrada
        return false;
    }

// BUSCAR TRATOR
    public static void buscarTrator() {

        System.out.println("\n=== BUSCAR TRATOR ===");

        System.out.print("Digite a placa: ");

        String placaDigitada = sc.nextLine();

    // Percorre todos os tratores cadastrados
        for(int i = 0; i < totalTratores; i++) {

            if(tratores[i].placa.equalsIgnoreCase(placaDigitada)) {

            System.out.println("\n===== TRATOR ENCONTRADO =====");

            System.out.println("Placa: " + tratores[i].placa);

            System.out.println("Capacidade: " + tratores[i].capacidade);

            return;
        }
    }

    System.out.println("Trator não encontrado.");
    }
}