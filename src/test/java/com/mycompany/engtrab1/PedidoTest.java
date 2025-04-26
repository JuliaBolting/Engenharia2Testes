/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.engtrab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Julia
 */
public class PedidoTest {

    @Test
    public void testInserirProduto() {
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Notebook", 2500.00);
        pedido.inserirProduto(produto);

        assertEquals(2500.00, pedido.getValorTotal());
    }

    @Test
    public void testRemoverProduto() {
        Pedido pedido = new Pedido();
        Produto p1 = new Produto("Mouse", 100.00);
        Produto p2 = new Produto("Teclado", 200.00);

        pedido.inserirProduto(p1);
        pedido.inserirProduto(p2);
        pedido.removerProduto(0);

        assertEquals(200.00, pedido.getValorTotal());
    }

    @Test
    public void testEditarProduto() {
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Cadeira", 400.00);
        pedido.inserirProduto(produto);

        pedido.editarProduto(0, "Cadeira Gamer", 600.00);
        assertEquals(600.00, pedido.getValorTotal());
    }

    @Test
    public void testFormaPagamentoCreditoValido() {
        Pedido pedido = new Pedido();
        pedido.inserirProduto(new Produto("TV", 1000.00));
        boolean resultado = pedido.setFormaPagamento(FormaPagamento.CREDITO, 5);

        assertTrue(resultado); // parcelas = 200.00, que é > 20
    }

    @Test
    public void testFormaPagamentoDebitoValido() {
        Pedido pedido = new Pedido();
        pedido.inserirProduto(new Produto("TV", 1000.00));
        boolean resultado = pedido.setFormaPagamento(FormaPagamento.DEBITO, 5);

        assertTrue(resultado); // parcelas = 200.00, que é > 20
    }

    @Test
    public void testFormaPagamentoDinheiroValido() {
        Pedido pedido = new Pedido();
        pedido.inserirProduto(new Produto("TV", 1000.00));
        boolean resultado = pedido.setFormaPagamento(FormaPagamento.DINHEIRO, 5);

        assertTrue(resultado); // parcelas = 200.00, que é > 20
    }

    @Test
    public void testFormaPagamentoCreditoInvalido() {
        Pedido pedido = new Pedido();
        pedido.inserirProduto(new Produto("Cabo USB", 50.00));
        boolean resultado = pedido.setFormaPagamento(FormaPagamento.CREDITO, 5);

        assertFalse(resultado); // parcelas = 10.00, que é < 20
    }

    @Test
    public void testFormaPagamentodebitoInvalido() {
        Pedido pedido = new Pedido();
        pedido.inserirProduto(new Produto("Cabo USB", 50.00));
        boolean resultado = pedido.setFormaPagamento(FormaPagamento.DEBITO, 5);

        assertFalse(resultado); // parcelas = 10.00, que é < 20
    }

    @Test
    public void testFormaPagamentoDinheiroInvalido() {
        Pedido pedido = new Pedido();
        pedido.inserirProduto(new Produto("Cabo USB", 50.00));
        boolean resultado = pedido.setFormaPagamento(FormaPagamento.DINHEIRO, 5);

        assertFalse(resultado); // parcelas = 10.00, que é < 20
    }

    @Test
    public void testFormaPagamentoSemProdutos() {
        Pedido pedido = new Pedido();
        boolean resultado = pedido.setFormaPagamento(FormaPagamento.DEBITO, 1);

        assertFalse(resultado);
    }

    @Test
    public void testMostrarProduto() {
        Pedido pedido = new Pedido();
        pedido.inserirProduto(new Produto("Monitor", 800.00));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        pedido.mostrarResumo();

        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("Monitor"));
    }
    
}
