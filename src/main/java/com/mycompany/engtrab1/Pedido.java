/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.engtrab1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julia
 */
public class Pedido {

    private List<Produto> produtos;
    private FormaPagamento formaPagamento;
    private int parcelas;

    public Pedido() {
        this.produtos = new ArrayList<>();
    }

    public void inserirProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int index) {
        if (index >= 0 && index < produtos.size()) {
            produtos.remove(index);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void editarProduto(int index, String novoNome, double novoValor) {
        if (index >= 0 && index < produtos.size()) {
            produtos.get(index).editarProduto(novoNome, novoValor);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no pedido.");
            return;
        }

        int i = 0;
        for (Produto p : produtos) {
            System.out.println(i+"- Produto: "+ p.getNome()+" Valor: "+p.getValor());
            i++;
        }
    }

    public double getValorTotal() {
        return produtos.stream().mapToDouble(Produto::getValor).sum();
    }

    public boolean setFormaPagamento(FormaPagamento formaPagamento, int parcelas) {
        if (produtos.isEmpty()) {
            System.out.println("Não é possível registrar forma de pagamento sem produtos.");
            return false;
        }

        if (formaPagamento == FormaPagamento.CREDITO) {
            double valorParcela = getValorTotal() / parcelas;
            if (valorParcela < 20.0) {
                System.out.println("Cada parcela deve ser maior que R$ 20,00. Valor atual: R$ " + valorParcela);
                return false;
            }
            this.parcelas = parcelas;
        } else {
            this.parcelas = 0;
        }

        this.formaPagamento = formaPagamento;
        mostrarResumo();
        return true;
    }

    public void mostrarResumo() {
        System.out.println("\n===== RESUMO DO PEDIDO =====");
        listarProdutos();
        System.out.println("Total: R$ " + String.format("%.2f", getValorTotal()));
        if (formaPagamento != null) {
            System.out.println("Forma de Pagamento: " + formaPagamento);
            if (formaPagamento == FormaPagamento.CREDITO) {
                System.out.println("Parcelado em " + parcelas + "x de R$ " + String.format("%.2f", getValorTotal() / parcelas));
            }
        } else {
            System.out.println("Forma de pagamento ainda não definida.");
        }
        System.out.println("=============================\n");
    }

}
