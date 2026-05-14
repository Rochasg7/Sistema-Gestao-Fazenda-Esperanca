package Registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Persistencia {

    public static void salvarRegistros() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("registros.csv"));

            for (RegistroColheita registro : RegistrosService.registros) {

                writer.write(
                    registro.data + ";" +
                    registro.matriculaFuncionario + ";" +
                    registro.codigoTalhao + ";" +
                    registro.placaTrator + ";" +
                    registro.litros + ";" +
                    registro.destino
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Registros salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar registros.");
        }
    }

    public static void carregarRegistros() {

    try {

        BufferedReader reader = new BufferedReader(new FileReader("registros.csv"));

        String linha;

        while ((linha = reader.readLine()) != null) {

            String[] partes = linha.split(";");

            RegistroColheita registro = new RegistroColheita();

            registro.data = partes[0];
            registro.matriculaFuncionario = partes[1];
            registro.codigoTalhao = partes[2];
            registro.placaTrator = partes[3];
            registro.litros = Double.parseDouble(partes[4]);
            registro.destino = partes[5];

            RegistrosService.registros.add(registro);
        }

        reader.close();

    } catch (IOException e) {

        System.out.println("Arquivo de registros não encontrado.");
    }
}

}