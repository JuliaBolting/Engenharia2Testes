/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.engtrab1;

import java.util.Scanner;

/**
 *
 * @author Julia
 */
public class EngTrab1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();
        boolean executando = true;

        try {
            while (executando) {
                System.out.println("====== MENU DO SISTEMA DE VENDAS ======");
                System.out.println("1 - Adicionar Produto");
                System.out.println("2 - Editar Produto");
                System.out.println("3 - Remover Produto");
                System.out.println("4 - Listar Produtos");
                System.out.println("5 - Definir Forma de Pagamento");
                System.out.println("6 - Mostrar Resumo do Pedido");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Valor do produto: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        pedido.inserirProduto(new Produto(nome, valor));
                    }

                    case 2 -> {
                        pedido.listarProdutos();
                        System.out.print("Digite o índice do produto a editar: ");
                        int idxEditar = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo valor: ");
                        double novoValor = scanner.nextDouble();
                        scanner.nextLine();
                        pedido.editarProduto(idxEditar, novoNome, novoValor);
                        pedido.listarProdutos();
                    }

                    case 3 -> {
                        pedido.listarProdutos();
                        System.out.print("Digite o índice do produto a remover: ");
                        int idxRemover = scanner.nextInt();
                        scanner.nextLine();
                        pedido.removerProduto(idxRemover);
                    }

                    case 4 ->
                        pedido.listarProdutos();

                    case 5 -> {
                        System.out.println("Escolha a forma de pagamento:");
                        System.out.println("1 - Dinheiro");
                        System.out.println("2 - Débito");
                        System.out.println("3 - Crédito");
                        int forma = scanner.nextInt();
                        scanner.nextLine();
                        FormaPagamento fp = null;
                        int parcelas = 1;

                        switch (forma) {
                            case 1 ->
                                fp = FormaPagamento.DINHEIRO;
                            case 2 ->
                                fp = FormaPagamento.DEBITO;
                            case 3 -> {
                                fp = FormaPagamento.CREDITO;
                                System.out.print("Quantas parcelas? ");
                                parcelas = scanner.nextInt();
                                scanner.nextLine();
                            }
                            default ->
                                System.out.println("Opção inválida.");
                        }

                        if (fp != null) {
                            if (pedido.setFormaPagamento(fp, parcelas)) {
                                executando = false;
                            }
                        }
                    }

                    case 6 ->
                        pedido.mostrarResumo();

                    case 0 -> {
                        executando = false;
                        System.out.println("Encerrando o sistema...");
                    }

                    default ->
                        System.out.println("Opção inválida.");
                }

                System.out.println();
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Opção inválida " + e);
        }

    }
}
