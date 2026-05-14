package Equipe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Dados.Registros;

public class PersistenciaFuncionario {

    public static void salvarFuncionariosCSV() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("funcionarios.csv")
                    );

            for (int i = 0; i < Registros.totalFuncionarios; i++) {

                Funcionario funcionario =
                        Registros.funcionarios[i];

                writer.write(
                        funcionario.nome + ";" +
                        funcionario.matricula + ";" +
                        funcionario.tipoContrato
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Funcionários salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar funcionários.");
        }
    }

    public static void carregarFuncionariosCSV() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("funcionarios.csv")
                    );

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                Funcionario funcionario = new Funcionario();

                funcionario.nome = partes[0];
                funcionario.matricula = partes[1];
                funcionario.tipoContrato = partes[2];

                Registros.funcionarios[
                        Registros.totalFuncionarios
                ] = funcionario;

                Registros.totalFuncionarios++;
            }

            reader.close();

            System.out.println("Funcionários carregados com sucesso!");

        } catch (IOException e) {

            System.out.println("Arquivo de funcionários não encontrado.");
        }
    }
}