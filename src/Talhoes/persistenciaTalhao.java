package Talhoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class persistenciaTalhao {

    public static void salvarTalhoesCSV() {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("talhoes.csv"));

            for (int i = 0; i < menuTalhao.totalTalhoes; i++) {

                Talhao talhao = menuTalhao.talhoes[i];

                writer.write(
                        talhao.codigo + ";" +
                                talhao.nome + ";" +
                                talhao.variedadeCafe + ";" +
                                talhao.estimativaLitros + ";" +
                                talhao.producaoAtual);

                writer.newLine();
            }

            writer.close();

            System.out.println("Talhões salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar talhões.");
        }
    }

    public static void carregarTalhoes() {

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader("talhoes.csv"));

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                Talhao talhao = new Talhao();

                talhao.codigo = partes[0];
                talhao.nome = partes[1];
                talhao.variedadeCafe = partes[2];
                talhao.estimativaLitros = Double.parseDouble(partes[3]);
                talhao.producaoAtual = Double.parseDouble(partes[4]);

                menuTalhao.talhoes[menuTalhao.totalTalhoes] = talhao;

                menuTalhao.totalTalhoes++;
            }

            reader.close();

            System.out.println("Talhões carregados com sucesso!");

        } catch (IOException e) {

            System.out.println("Arquivo de talhões não encontrado.");
        }
    }
}