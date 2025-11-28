/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetoaula09;

/**
 *
 * @author 1jean
 */
public class InversorDePalavras {

    public static void main(String[] args) {
        String frase1 = "UM CIENTISTA DA COMPUTAÇAO E UM TECNÓLOGO EM SISTEMAS PARA INTERNET DEVEM RESOLVER OS PROBLEMAS LOGICAMENTE";
        System.out.println("Frase Original 1: " + frase1);
        String resultado1 = inverterLetrasDasPalavras(frase1);
        System.out.println("Frase Resultante 1: " + resultado1);

        System.out.println();

        String frase2 = "ESARF :ATERCES ODALERAHCAB ME AICNEIC AD OAÇATUPMOC E O OGOLÓNCET ME SAMETSIS ARAP TENRETNI OD FI ONAIOG SUPMAC SOHNIRROM OÃS SO SEROHLEM SOSRUC ED OAÇATUPMOC OD ODATSE ED .SAIOG";
        System.out.println("Frase Original 2: " + frase2);
        String resultado2 = inverterLetrasDasPalavras(frase2);
        System.out.println("Frase Resultante 2: " + resultado2);
    }

    public static String inverterLetrasDasPalavras(String fraseOriginal) {
        if (fraseOriginal == null || fraseOriginal.isEmpty()) {
            return "";
        }

        String[] palavras = fraseOriginal.split(" ");
        StringBuilder fraseInvertida = new StringBuilder();
        Pilha<Character> pilha = new Pilha<>();

        for (String palavra : palavras) {
            for (char letra : palavra.toCharArray()) {
                pilha.push(letra);
            }
            while (!pilha.isEmpty()) {
                fraseInvertida.append(pilha.pop());
            }
            fraseInvertida.append(" ");
        }
        
        return fraseInvertida.toString().trim();
    }
}
