package Relatorios;

import Equipe.CadastroFuncionario;
import Equipe.Funcionario;

import Frota.CadastroFrota;
import Frota.Frota;

import Talhoes.CadastroTalhao;
import Talhoes.Talhao;

import Registros.RegistrosService;
import Registros.RegistroColheita;

public class RelatorioService {

    // RELATÓRIO DE FUNCIONÁRIOS
    public static void relatorioFuncionarios() {

        System.out.println("\n===== RELATÓRIO DE FUNCIONÁRIOS =====");

        if (CadastroFuncionario.totalFuncionarios == 0) {

            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (int i = 0;
             i < CadastroFuncionario.totalFuncionarios;
             i++) {

            Funcionario funcionario =
                    CadastroFuncionario.funcionarios[i];

            System.out.println("----------------------------------");

            System.out.println("Nome: "
                    + funcionario.nome);

            System.out.println("Matrícula: "
                    + funcionario.matricula);

            System.out.println("Tipo de Contrato: "
                    + funcionario.tipoContrato);
        }

        System.out.println("----------------------------------");

        System.out.println("Total de funcionários: "
                + CadastroFuncionario.totalFuncionarios);
    }

    // RELATÓRIO DA FROTA
    public static void relatorioFrota() {

        System.out.println("\n===== RELATÓRIO DA FROTA =====");

        if (CadastroFrota.totalTratores == 0) {

            System.out.println("Nenhum trator cadastrado.");
            return;
        }

        for (int i = 0;
             i < CadastroFrota.totalTratores;
             i++) {

            Frota trator =
                    CadastroFrota.tratores[i];

            System.out.println("----------------------------------");

            System.out.println("Placa: "
                    + trator.placa);

            System.out.println("Capacidade: "
                    + trator.capacidade + " litros");
        }

        System.out.println("----------------------------------");

        System.out.println("Total de tratores: "
                + CadastroFrota.totalTratores);
    }

    // RELATÓRIO DE TALHÕES
    public static void relatorioTalhoes() {

        System.out.println("\n===== RELATÓRIO DE TALHÕES =====");

        if (CadastroTalhao.totalTalhoes == 0) {

            System.out.println("Nenhum talhão cadastrado.");
            return;
        }

        for (int i = 0;
             i < CadastroTalhao.totalTalhoes;
             i++) {

            Talhao talhao =
                    CadastroTalhao.talhoes[i];

            System.out.println("----------------------------------");

            System.out.println("Código: "
                    + talhao.codigo);

            System.out.println("Nome: "
                    + talhao.nome);

            System.out.println("Variedade do Café: "
                    + talhao.variedadeCafe);

            System.out.println("Estimativa: "
                    + talhao.estimativaLitros + " litros");

            System.out.println("Produção Atual: "
                    + talhao.producaoAtual + " litros");
        }

        System.out.println("----------------------------------");

        System.out.println("Total de talhões: "
                + CadastroTalhao.totalTalhoes);
    }

    // RELATÓRIO DE COLHEITA
    public static void relatorioColheita() {

        System.out.println("\n===== RELATÓRIO DE COLHEITA =====");

        if (RegistrosService.totalRegistros == 0) {

            System.out.println("Nenhum registro encontrado.");
            return;
        }

        double totalLitros = 0;

        for (int i = 0;
             i < RegistrosService.totalRegistros;
             i++) {

            RegistroColheita registro =
                    RegistrosService.registros[i];

            System.out.println("----------------------------------");

            System.out.println("Data: "
                    + registro.data);

            System.out.println("Funcionário: "
                    + registro.matriculaFuncionario);

            System.out.println("Talhão: "
                    + registro.codigoTalhao);

            System.out.println("Trator: "
                    + registro.placaTrator);

            System.out.println("Litros Colhidos: "
                    + registro.litros);

            System.out.println("Destino: "
                    + registro.destino);

            totalLitros += registro.litros;
        }

        System.out.println("----------------------------------");

        System.out.println("Total colhido: "
                + totalLitros + " litros");
    }

    // RELATÓRIO GERAL
    public static void relatorioGeral() {

        System.out.println("\n===== RELATÓRIO GERAL DA FAZENDA =====");

        System.out.println("Funcionários cadastrados: "
                + CadastroFuncionario.totalFuncionarios);

        System.out.println("Tratores cadastrados: "
                + CadastroFrota.totalTratores);

        System.out.println("Talhões cadastrados: "
                + CadastroTalhao.totalTalhoes);

        System.out.println("Registros de colheita: "
                + RegistrosService.totalRegistros);
    }
}