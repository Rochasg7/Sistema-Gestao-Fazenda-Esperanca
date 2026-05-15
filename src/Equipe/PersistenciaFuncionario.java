package Equipe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaFuncionario {

    // SALVAR FUNCIONÁRIOS NO CSV
    public static void salvarFuncionariosCSV() {

        try {

            // Cria o arquivo CSV onde os funcionários serão armazenados
            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("funcionarios.csv")
                    );

            // Percorre todos os funcionários cadastrados
            for (int i = 0; i < CadastroFuncionario.totalFuncionarios; i++) {

                Funcionario funcionario =
                        CadastroFuncionario.funcionarios[i];

                // Escreve os dados separados por ";"
                writer.write(
                        funcionario.nome + ";" +
                        funcionario.matricula + ";" +
                        funcionario.tipoContrato
                );

                // Pula para a próxima linha do arquivo
                writer.newLine();
            }

            // Fecha o arquivo após finalizar a escrita
            writer.close();

            System.out.println("Funcionários salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar funcionários.");
        }
    }

    // CARREGAR FUNCIONÁRIOS DO CSV
    public static void carregarFuncionariosCSV() {

        try {

            // Abre o arquivo CSV para leitura
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("funcionarios.csv")
                    );

            String linha;

            // Lê linha por linha do arquivo
            while ((linha = reader.readLine()) != null) {

                // Divide os dados utilizando ";" como separador
                String[] partes = linha.split(";");

                Funcionario funcionario = new Funcionario();

                // Recupera os dados do arquivo
                funcionario.nome = partes[0];
                funcionario.matricula = partes[1];
                funcionario.tipoContrato = partes[2];

                // Armazena o funcionário no vetor
                CadastroFuncionario.funcionarios[
                        CadastroFuncionario.totalFuncionarios
                ] = funcionario;

                // Incrementa o contador de funcionários
                CadastroFuncionario.totalFuncionarios++;
            }

            // Fecha o arquivo após finalizar a leitura
            reader.close();

            System.out.println("Funcionários carregados com sucesso!");

        } catch (IOException e) {

            // Caso o arquivo ainda não exista
            System.out.println("Arquivo de funcionários não encontrado.");
        }
    }
}