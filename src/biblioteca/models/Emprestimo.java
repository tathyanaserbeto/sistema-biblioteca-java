package biblioteca.models;

import java.time.LocalDateTime;

public class Emprestimo {
    private final int idEmprestimo;
    private Livro livro;
    private Cliente cliente;
    private final LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    private static int contadorEmprestimoId = 1;

    public Emprestimo (Livro livro, Cliente cliente){
        this.idEmprestimo = contadorEmprestimoId++;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDateTime.now();
        this.dataDevolucao = null;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }


    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
