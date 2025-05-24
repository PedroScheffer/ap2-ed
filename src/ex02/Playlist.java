package ex02;

public class Playlist {
    private Musica inicio;
    private Musica fim;
    private Musica atual;

    public Playlist() {
        this.inicio = null;
        this.fim = null;
        this.atual = null;
    }

    public void adicionarNoFim(String titulo, String artista, String album, int duracao) {
        Musica nova = new Musica(titulo, artista, album, duracao);
        if (inicio == null) {
            inicio = nova;
            fim = nova;
            atual = nova;
        } else {
            fim.proxima = nova;
            nova.anterior = fim;
            fim = nova;
        }
    }

    public void adicionarNoInicio(String titulo, String artista, String album, int duracao) {
        Musica nova = new Musica(titulo, artista, album, duracao);
        if (inicio == null) {
            inicio = nova;
            fim = nova;
            atual = nova;
        } else {
            nova.proxima = inicio;
            inicio.anterior = nova;
            inicio = nova;
        }
    }

    public void removerPorTitulo(String titulo) {
        if (inicio == null) {
            System.out.println("Playlist vazia.");
            return;
        }

        Musica atual = inicio;
        while (atual != null) {
            if (atual.titulo.equalsIgnoreCase(titulo)) {
                if (atual.anterior != null) {
                    atual.anterior.proxima = atual.proxima;
                } else {
                    inicio = atual.proxima;
                }
                if (atual.proxima != null) {
                    atual.proxima.anterior = atual.anterior;
                } else {
                    fim = atual.anterior;
                }
                System.out.println("Música removida: " + titulo);
                return;
            }
            atual = atual.proxima;
        }
        System.out.println("Música não encontrada.");
    }

    public void proximaMusica() {
        if (atual == null || atual.proxima == null) {
            System.out.println("Não há próxima música.");
        } else {
            atual = atual.proxima;
            System.out.println("Música atual: " + atual);
        }
    }

    public void musicaAnterior() {
        if (atual == null || atual.anterior == null) {
            System.out.println("Não há música anterior.");
        } else {
            atual = atual.anterior;
            System.out.println("Música atual: " + atual);
        }
    }

    public void tocarMusica() {
        if (atual == null) {
            System.out.println("Nenhuma música na playlist.");
        } else {
            System.out.println("Reproduzindo: " + atual);
        }
    }

    public void listarMusicas() {
        if (inicio == null) {
            System.out.println("Playlist vazia.");
            return;
        }

        Musica atual = inicio;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.proxima;
        }
    }

    public void ordenarPorTitulo() {
        if (inicio == null) return;

        for (Musica i = inicio; i != null; i = i.proxima) {
            for (Musica j = i.proxima; j != null; j = j.proxima) {
                if (i.titulo.compareToIgnoreCase(j.titulo) > 0) {
                    trocarDados(i, j);
                }
            }
        }
        System.out.println("Playlist ordenada por título.");
    }

    public void ordenarPorArtista() {
        if (inicio == null) return;

        for (Musica i = inicio; i != null; i = i.proxima) {
            for (Musica j = i.proxima; j != null; j = j.proxima) {
                if (i.artista.compareToIgnoreCase(j.artista) > 0) {
                    trocarDados(i, j);
                }
            }
        }
        System.out.println("Playlist ordenada por artista.");
    }

    private void trocarDados(Musica a, Musica b) {
        String tempTitulo = a.titulo;
        String tempArtista = a.artista;
        String tempAlbum = a.album;
        int tempDuracao = a.duracao;

        a.titulo = b.titulo;
        a.artista = b.artista;
        a.album = b.album;
        a.duracao = b.duracao;

        b.titulo = tempTitulo;
        b.artista = tempArtista;
        b.album = tempAlbum;
        b.duracao = tempDuracao;
    }
}