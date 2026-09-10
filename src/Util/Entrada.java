package Util;

import java.util.Scanner;

// Scanner único, compartilhado por todo o sistema.
// Evita o bug de ter vários Scanners lendo o mesmo System.in
// (o que pode causar NoSuchElementException e opções "puladas").
public class Entrada {

    public static final Scanner sc = new Scanner(System.in);
}
