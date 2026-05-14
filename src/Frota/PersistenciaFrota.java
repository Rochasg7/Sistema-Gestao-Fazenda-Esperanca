package Frota;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class PersistenciaFrota {

    public static void salvarFrota() {

        try {

            BufferedWriter writer = new BufferedWriter(
                new FileWriter("frota.csv")
            );

            for (Frota trator : CadastroFrota.tratores) {

                if (trator != null) {

                    writer.write(
                        trator.placa + ";" +
                        trator.capacidade
                    );

                    writer.newLine();
                }
            }

            writer.close();

            System.out.println("Frota salva com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar frota.");
        }
    }

    public static void carregarFrota() {

        try {

            BufferedReader reader = new BufferedReader(
                new FileReader("frota.csv")
            );

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                Frota trator = new Frota();

                trator.placa = partes[0];

                trator.capacidade =
                    Double.parseDouble(partes[1]);

                CadastroFrota.tratores[
                    CadastroFrota.totalTratores
                ] = trator;

                CadastroFrota.totalTratores++;
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Arquivo de frota não encontrado.");
        }
    }
}