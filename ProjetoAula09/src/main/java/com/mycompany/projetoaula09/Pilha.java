/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaula09;

/**
 *
 * @author 1jean
 */
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Pilha<T> {

    private ArrayList<T> elementos;

    public Pilha() {
        this.elementos = new ArrayList<>();
    }

    public void push(T elemento) {
        elementos.add(elemento);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }
}
