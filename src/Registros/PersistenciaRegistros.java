package Registros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaRegistros {

    // SALVAR REGISTROS NO CSV
    public static void salvarRegistrosCSV() {

        try {

            // Cria o arquivo CSV onde os registros serão armazenados
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("banco/registros.csv"));

            // Percorre todos os registros cadastrados
            for (int i = 0; i < RegistrosService.totalRegistros; i++) {

                RegistroColheita registro = RegistrosService.registros[i];

                // Escreve os dados separados por ";"
                writer.write(
                        registro.data + ";" +
                                registro.matriculaFuncionario + ";" +
                                registro.codigoTalhao + ";" +
                                registro.placaTrator + ";" +
                                registro.litros + ";" +
                                registro.destino);

                // Pula para a próxima linha do arquivo
                writer.newLine();
            }

            // Fecha o arquivo após finalizar a escrita
            writer.close();

            System.out.println("Registros salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar registros.");
        }
    }

    // CARREGAR REGISTROS DO CSV
    public static void carregarRegistrosCSV() {

        try {

            // Abre o arquivo CSV para leitura
            BufferedReader reader = new BufferedReader(
                    new FileReader("banco/registros.csv"));

            String linha;

            // Lê linha por linha do arquivo
            while ((linha = reader.readLine()) != null) {

                // Divide os dados utilizando ";" como separador
                String[] partes = linha.split(";");

                RegistroColheita registro = new RegistroColheita();

                // Recupera os dados do arquivo
                registro.data = partes[0];
                registro.matriculaFuncionario = partes[1];
                registro.codigoTalhao = partes[2];
                registro.placaTrator = partes[3];
                registro.litros = Double.parseDouble(partes[4]);
                registro.destino = partes[5];

                // Armazena o registro no vetor
                RegistrosService.registros[RegistrosService.totalRegistros] = registro;

                // Incrementa o contador de registros
                RegistrosService.totalRegistros++;
            }

            // Fecha o arquivo após finalizar a leitura
            reader.close();

            System.out.println("Registros carregados com sucesso!");

        } catch (IOException e) {

            // Caso o arquivo ainda não exista
            System.out.println("Arquivo de registros não encontrado.");
        }
    }
}