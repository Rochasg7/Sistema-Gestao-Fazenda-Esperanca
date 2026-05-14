import java.util.Scanner;

import Registros.RegistrosService;
import Registros.MenuRegistro;
import Equipe.MenuEquipe;
import Frota.MenuFrota;
import Frota.PersistenciaFrota;
import Talhoes.menuTalhao;
import Registros.Persistencia;

public class SistemaPrincipal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Persistencia.carregarRegistros();
        PersistenciaFrota.carregarFrota();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA FAZENDA =====");
            System.out.println("1 - Talhões");
            System.out.println("2 - Funcionários");
            System.out.println("3 - Frota");
            System.out.println("4 - Colheita");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    menuTalhao.menuTalhao();
                    break;
                case 2:
                    MenuEquipe.menuEquipe();
                    break;
                case 3:
                    MenuFrota.menuFrota();
                    break;
                case 4:
                    MenuRegistro.menuRegistro();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Módulo não implementado.");
            }

        } while (opcao != 0);
    }
}