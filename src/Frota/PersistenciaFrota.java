package Frota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaFrota {

    // SALVAR FROTA NO CSV
    public static void salvarFrotaCSV() {

        try {

            // Cria o arquivo CSV onde os tratores serão armazenados
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("banco/frota.csv")
            );

            // Percorre todos os tratores cadastrados
            for (int i = 0; i < CadastroFrota.totalTratores; i++) {

                Frota trator = CadastroFrota.tratores[i];

                // Escreve os dados separados por ";"
                writer.write(
                        trator.placa + ";" +
                                trator.capacidade
                );

                // Pula para a próxima linha do arquivo
                writer.newLine();
            }

            // Fecha o arquivo após finalizar a escrita
            writer.close();

            System.out.println("Frota salva com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar frota.");
        }
    }

    // CARREGAR FROTA DO CSV
    public static void carregarFrotaCSV() {

        try {

            // Abre o arquivo CSV para leitura
            BufferedReader reader = new BufferedReader(
                    new FileReader("banco/frota.csv")
            );

            String linha;

            // Lê linha por linha do arquivo
            while ((linha = reader.readLine()) != null) {

                // Divide os dados utilizando ";" como separador
                String[] partes = linha.split(";");

                Frota trator = new Frota();

                // Recupera os dados do arquivo
                trator.placa = partes[0];

                trator.capacidade =
                        Double.parseDouble(partes[1]);

                // Armazena o trator no vetor
                CadastroFrota.tratores[
                        CadastroFrota.totalTratores
                ] = trator;

                // Incrementa o contador de tratores
                CadastroFrota.totalTratores++;
            }

            // Fecha o arquivo após finalizar a leitura
            reader.close();

            System.out.println("Frota carregada com sucesso!");

        } catch (IOException e) {

            // Caso o arquivo ainda não exista
            System.out.println("Arquivo de frota não encontrado.");
        }
    }
}