package Registros;

import java.util.Scanner;

public class RegistrosService {

    // Scanner utilizado para leitura dos dados
    static Scanner sc = new Scanner(System.in);

    // Vetor responsável por armazenar os registros de colheita
    public static RegistroColheita[] registros =
            new RegistroColheita[100];

    // Controla quantos registros já foram cadastrados
    public static int totalRegistros = 0;

    // REGISTRAR COLHEITA
    public static void registrarColheita() {

        // Verifica se o limite máximo foi atingido
        if (totalRegistros >= 100) {

            System.out.println("Limite máximo de registros atingido!");

            return;
        }

        RegistroColheita registro = new RegistroColheita();

        System.out.println("\n===== REGISTRO DE COLHEITA =====");

        // Recebe a data da colheita
        System.out.print("Digite a data: ");
        registro.data = sc.nextLine();

        // Recebe a matrícula do funcionário responsável
        System.out.print("Digite a matrícula do funcionário: ");
        registro.matriculaFuncionario = sc.nextLine();

        // Recebe o código do talhão
        System.out.print("Digite o código do talhão: ");
        registro.codigoTalhao = sc.nextLine();

        // Recebe a placa do trator utilizado
        System.out.print("Digite a placa do trator: ");
        registro.placaTrator = sc.nextLine();

        // Recebe a quantidade de litros colhidos
        System.out.print("Digite a quantidade de litros: ");
        registro.litros = Double.parseDouble(sc.nextLine());

        // Recebe o destino da carga
        System.out.print("Digite o destino: ");
        registro.destino = sc.nextLine();

        // Armazena o registro no vetor
        registros[totalRegistros] = registro;

        // Incrementa o contador de registros
        totalRegistros++;

        // Salva os registros no arquivo CSV
        PersistenciaRegistros.salvarRegistrosCSV();

        System.out.println("Registro realizado com sucesso!");
    }

    // LISTAR REGISTROS
    public static void listarRegistros() {

        // Verifica se existe pelo menos um registro cadastrado
        if (totalRegistros == 0) {

            System.out.println("Nenhum registro encontrado.");
            return;
        }

        System.out.println("\n===== LISTA DE REGISTROS =====");

        // Percorre todos os registros cadastrados
        for (int i = 0; i < totalRegistros; i++) {

            RegistroColheita registro = registros[i];

            System.out.println("---------------------------");

            System.out.println("Data: " + registro.data);
            System.out.println("Matrícula: " + registro.matriculaFuncionario);
            System.out.println("Talhão: " + registro.codigoTalhao);
            System.out.println("Placa: " + registro.placaTrator);
            System.out.println("Litros: " + registro.litros);
            System.out.println("Destino: " + registro.destino);
        }
    }

    // BUSCAR REGISTRO POR DATA
    public static void buscarRegistro() {

        System.out.println("\n===== BUSCAR REGISTRO =====");

        System.out.print("Digite a data do registro: ");

        String dataDigitada = sc.nextLine();

        // Percorre todos os registros cadastrados
        for (int i = 0; i < totalRegistros; i++) {

            RegistroColheita registro = registros[i];

            // Verifica se a data corresponde
            if (registro.data.equalsIgnoreCase(dataDigitada)) {

                System.out.println("\n===== REGISTRO ENCONTRADO =====");

                System.out.println("Data: " + registro.data);
                System.out.println("Matrícula: " + registro.matriculaFuncionario);
                System.out.println("Talhão: " + registro.codigoTalhao);
                System.out.println("Placa: " + registro.placaTrator);
                System.out.println("Litros: " + registro.litros);
                System.out.println("Destino: " + registro.destino);
                return;
            }
        }

        System.out.println("Registro não encontrado.");
    }
}