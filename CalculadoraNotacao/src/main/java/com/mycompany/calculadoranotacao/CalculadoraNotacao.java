/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoranotacao;

/**
 *
 * @author 1jean
 */
import java.util.Stack;

public class CalculadoraNotacao {

    private int getPrecedencia(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1; // Operador inválido
    }

    public String infixParaPosfixa(String expressao) {
        StringBuilder resultado = new StringBuilder();
        Stack<Character> pilha = new Stack<>();
        String[] tokens = expressao.split("\\s+");

        for (String token : tokens) {
            char c = token.charAt(0);

            // Se for um operando (número), adiciona ao resultado
            if (Character.isDigit(c)) {
                resultado.append(token).append(" ");
            } 
            // Se for um parêntese de abertura, empilha
            else if (c == '(') {
                pilha.push(c);
            } 
            // Se for um parêntese de fechamento, desempilha até encontrar o de abertura
            else if (c == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    resultado.append(pilha.pop()).append(" ");
                }
                pilha.pop(); // Remove o '(' da pilha
            } 
            // Se for um operador
            else {
                while (!pilha.isEmpty() && getPrecedencia(c) <= getPrecedencia(pilha.peek())) {
                    resultado.append(pilha.pop()).append(" ");
                }
                pilha.push(c);
            }
        }

     
        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop()).append(" ");
        }

        return resultado.toString().trim();
    }
    

    public String prefixaParaPosfixa(String expressao) {
        Stack<String> pilha = new Stack<>();
        String[] tokens = expressao.split("\\s+");
        
        // Lê a expressão pré-fixa da direita para a esquerda
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (Character.isDigit(token.charAt(0))) {
                pilha.push(token);
            } else { // É um operador
                String op1 = pilha.pop();
                String op2 = pilha.pop();
                String temp = op1 + " " + op2 + " " + token;
                pilha.push(temp);
            }
        }
        return pilha.pop().trim();
    }


    public double calcularPosfixa(String expressaoPosfixa) {
        Stack<Double> pilha = new Stack<>();
        String[] tokens = expressaoPosfixa.split("\\s+");

        for (String token : tokens) {
            // Se for um número, empilha
            if (Character.isDigit(token.charAt(0))) {
                pilha.push(Double.parseDouble(token));
            } 
            // Se for um operador, desempilha dois operandos, calcula e empilha o resultado
            else {
                double val2 = pilha.pop();
                double val1 = pilha.pop();
                switch (token.charAt(0)) {
                    case '+':
                        pilha.push(val1 + val2);
                        break;
                    case '-':
                        pilha.push(val1 - val2);
                        break;
                    case '*':
                        pilha.push(val1 * val2);
                        break;
                    case '/':
                        if (val2 == 0) throw new UnsupportedOperationException("Divisão por zero não é permitida.");
                        pilha.push(val1 / val2);
                        break;
                }
            }
        }
        return pilha.pop();
    }


    public String posfixaParaInfixa(String expressaoPosfixa) {
        Stack<String> pilha = new Stack<>();
        String[] tokens = expressaoPosfixa.split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                pilha.push(token);
            } else {
                String op2 = pilha.pop();
                String op1 = pilha.pop();
                pilha.push("( " + op1 + " " + token + " " + op2 + " )");
            }
        }
        return pilha.pop();
    }
    

    public String posfixaParaPrefixa(String expressaoPosfixa) {
        Stack<String> pilha = new Stack<>();
        String[] tokens = expressaoPosfixa.split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                pilha.push(token);
            } else {
                String op2 = pilha.pop();
                String op1 = pilha.pop();
                pilha.push(token + " " + op1 + " " + op2);
            }
        }
        return pilha.pop();
    }
}
