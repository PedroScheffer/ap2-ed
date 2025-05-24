package ex01;

public class Fila<T> {
    private No<T> inicio;
    private No<T> fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public void enfileirar(T dado) {
        No<T> novoNo = new No<>(dado);
        if (fim != null) {
            fim.proximo = novoNo;
        }
        fim = novoNo;
        if (inicio == null) {
            inicio = fim;
        }
    }

    public T desenfileirar() {
        if (inicio == null) {
            System.out.println("A fila está vazia.");
            return null;
        }
        T dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return dado;
    }

    public void exibir() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}