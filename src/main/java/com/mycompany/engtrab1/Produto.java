/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.engtrab1;

/**
 *
 * @author Julia
 */
public class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void editarProduto(String novoNome, double novoValor) {
        setNome(novoNome);
        setValor(novoValor);
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valor=" + valor + '}';
    }
    
}
