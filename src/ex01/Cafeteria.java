package ex01;

import java.util.Scanner;

public class Cafeteria {

    public static void main(String[] args) {
        Fila<Pedido> pedidosPendentes = new Fila<>();
        Pilha<Pedido> pedidosCancelados = new Pilha<>();
        Scanner scan = new Scanner(System.in);
        int opcao = -1;
        int contador = 1;

        while (opcao != 0) {
            System.out.println("Informe uma Opção:");
            System.out.println("1 - Adicionar Pedido");
            System.out.println("2 - Atender Pedido");
            System.out.println("3 - Cancelar Pedido");
            System.out.println("4 - Listar Pedidos Pendentes");
            System.out.println("5 - Listar Pedidos Cancelados");
            System.out.println("6 - Restaurar Pedido");
            System.out.println("0 - Encerrar");
            opcao = scan.nextInt();
            scan.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Informe a descrição do pedido:");
                    String descricao = scan.nextLine();
                    Pedido novoPedido = new Pedido(String.valueOf(contador), descricao);
                    pedidosPendentes.enfileirar(novoPedido);
                    System.out.println("Pedido adicionado: " + novoPedido);
                    contador++;
                    break;

                case 2:
                    Pedido atendido = pedidosPendentes.desenfileirar();
                    if (atendido != null) {
                        System.out.println("Pedido atendido: " + atendido);
                    }
                    break;

                case 3:
                    Pedido cancelado = pedidosPendentes.desenfileirar();
                    if (cancelado != null) {
                        pedidosCancelados.empilhar(cancelado);
                        System.out.println("Pedido cancelado: " + cancelado);
                    }
                    break;

                case 4:
                    System.out.println("Pedidos Pendentes:");
                    pedidosPendentes.exibir();
                    break;

                case 5:
                    System.out.println("Pedidos Cancelados:");
                    pedidosCancelados.exibir();
                    break;

                case 6:
                    Pedido restaurado = pedidosCancelados.desempilhar();
                    if (restaurado != null) {
                        pedidosPendentes.enfileirar(restaurado);
                        System.out.println("Pedido restaurado: " + restaurado);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scan.close();
    }
}