package ex01;

public class Pilha<T> {
    private No<T> topo;

    public Pilha() {
        this.topo = null;
    }

    public void empilhar(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public T desempilhar() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
            return null;
        }
        T dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }

    public void exibir() {
        No<T> atual = topo;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}