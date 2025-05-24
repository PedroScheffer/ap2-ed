package ex01;

public class Pedido {
    public String id;
    public String descricao;

    public Pedido(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Id:" + id +
                "\nDescricao:" + descricao;
    }
}
