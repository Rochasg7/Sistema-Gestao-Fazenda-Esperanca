package Talhoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class persistenciaTalhao {

    // SALVAR TALHÕES NO CSV
    public static void salvarTalhoesCSV() {

        try {

            // Cria o arquivo CSV onde os dados serão armazenados
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("talhoes.csv"));

            // Percorre todos os talhões cadastrados
            for (int i = 0; i < CadastroTalhao.totalTalhoes; i++) {

                Talhao talhao = CadastroTalhao.talhoes[i];

                // Escreve os dados do talhão separados por ";"
                writer.write(
                        talhao.codigo + ";" +
                                talhao.nome + ";" +
                                talhao.variedadeCafe + ";" +
                                talhao.estimativaLitros + ";" +
                                talhao.producaoAtual);

                // Pula para a próxima linha do arquivo
                writer.newLine();
            }

            // Fecha o arquivo após finalizar a escrita
            writer.close();

            System.out.println("Talhões salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar talhões.");
        }
    }

    // CARREGAR TALHÕES DO CSV
    public static void carregarTalhoes() {

        try {

            // Abre o arquivo CSV para leitura
            BufferedReader reader = new BufferedReader(
                    new FileReader("talhoes.csv"));

            String linha;

            // Lê linha por linha do arquivo
            while ((linha = reader.readLine()) != null) {

                // Divide os dados utilizando ";" como separador
                String[] partes = linha.split(";");

                Talhao talhao = new Talhao();

                // Recupera os dados do arquivo e coloca no objeto
                talhao.codigo = partes[0];
                talhao.nome = partes[1];
                talhao.variedadeCafe = partes[2];
                talhao.estimativaLitros = Double.parseDouble(partes[3]);
                talhao.producaoAtual = Double.parseDouble(partes[4]);

                // Armazena o talhão no vetor
                CadastroTalhao.talhoes[CadastroTalhao.totalTalhoes] = talhao;

                // Incrementa o contador de talhões
                CadastroTalhao.totalTalhoes++;
            }

            // Fecha o arquivo após finalizar a leitura
            reader.close();

            System.out.println("Talhões carregados com sucesso!");

        } catch (IOException e) {

            // Caso o arquivo ainda não exista
            System.out.println("Arquivo de talhões não encontrado.");
        }
    }
}