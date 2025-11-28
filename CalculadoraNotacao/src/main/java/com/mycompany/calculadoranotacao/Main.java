/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoranotacao;

/**
 *
 * @author 1jean
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraNotacao calculadora = new CalculadoraNotacao();

        while (true) {
            System.out.println("\n--- Calculadora de Notacoes ---");
            System.out.println("Escolha o tipo de notacao da expressao de entrada:");
            System.out.println("1. Infixa (ex: ( 3 + 5 ) * 2)");
            System.out.println("2. Pos-fixa (ex: 3 5 + 2 *)");
            System.out.println("3. Pre-fixa (ex: * + 3 5 2)");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            int escolha = -1;
            try {
                escolha = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, insira um número.");
                continue;
            }

            if (escolha == 0) {
                System.out.println("Encerrando o programa.");
                break;
            }
            
            if (escolha < 1 || escolha > 3) {
                 System.out.println("Opção inválida. Tente novamente.");
                 continue;
            }

            System.out.print("Digite a expressão (com espaços entre números e operadores): ");
            String expressaoEntrada = scanner.nextLine();
            
            String expressaoPosfixa = "";

            try {
                switch (escolha) {
                    case 1: // Infixa
                        expressaoPosfixa = calculadora.infixParaPosfixa(expressaoEntrada);
                        break;
                    case 2: // Pós-fixa
                        expressaoPosfixa = expressaoEntrada;
                        break;
                    case 3: // Pré-fixa
                        expressaoPosfixa = calculadora.prefixaParaPosfixa(expressaoEntrada);
                        break;
                }

                // A partir da Pós-fixa, calcula e gera as outras
                double resultado = calculadora.calcularPosfixa(expressaoPosfixa);
                String expressaoInfixa = calculadora.posfixaParaInfixa(expressaoPosfixa);
                String expressaoPrefixa = calculadora.posfixaParaPrefixa(expressaoPosfixa);
                
                System.out.println("\n--- Resultados ---");
                System.out.println("Resultado do Cálculo: " + resultado);
                System.out.println("Notação Infixa:     " + expressaoInfixa);
                System.out.println("Notação Pós-fixa:    " + expressaoPosfixa);
                System.out.println("Notação Pré-fixa:    " + expressaoPrefixa);

            } catch (Exception e) {
                System.err.println("\nErro ao processar a expressão: " + e.getMessage());
                System.err.println("Por favor, verifique se a expressão está formatada corretamente.");
            }
        }

        scanner.close();
    }
}