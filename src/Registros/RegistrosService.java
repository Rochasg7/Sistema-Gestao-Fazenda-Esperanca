package Registros;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrosService {

    public static ArrayList<RegistroColheita> registros = new ArrayList<>();

    public static void registrarColheita() {
        Scanner sc = new Scanner(System.in);

        RegistroColheita registro = new RegistroColheita();

        System.out.println("Digite a data:");
        registro.data = sc.nextLine();

        System.out.println("Digite a matrícula do funcionário:");
        registro.matriculaFuncionario = sc.nextInt();

        System.out.println("Digite o código do talhão:");
        registro.codigoTalhao = sc.nextInt();

        sc.nextLine();

        System.out.println("Digite a placa do trator:");
        registro.placaTrator = sc.nextLine();

        System.out.println("Digite a quantidade de litros:");
        registro.litros = sc.nextDouble();

        sc.nextLine();

        System.out.println("Digite o destino:");
        registro.destino = sc.nextLine();

        registros.add(registro);

    System.out.println("Registro realizado com sucesso!");
    }

    public static void listarRegistros() {

        for (RegistroColheita registro : registros) {

        System.out.println("Data: " + registro.data);
        System.out.println("Matrícula: " + registro.matriculaFuncionario);
        System.out.println("Talhão: " + registro.codigoTalhao);
        System.out.println("Placa: " + registro.placaTrator);
        System.out.println("Litros: " + registro.litros);
        System.out.println("Destino: " + registro.destino);

        System.out.println("---------------------------");
    }
    }

}


