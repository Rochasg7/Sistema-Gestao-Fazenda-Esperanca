package Equipe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Dados.Registros;

public class PersistenciaFuncionario {

    public static void salvarFuncionariosCSV() {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("Dados/funcionarios.csv")
            );

            writer.write("Nome;Matricula;Contrato");
            writer.newLine();

            for (int i = 0; i < Registros.totalFuncionarios; i++) {

                Funcionario funcionario = Registros.funcionarios[i];

                writer.write(
                        funcionario.nome + ";" +
                        funcionario.matricula + ";" +
                        funcionario.tipoContrato
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Funcionários salvos com sucesso.");

        } catch (IOException e) {

            System.out.println("Erro ao salvar arquivo.");
        }
    }
}