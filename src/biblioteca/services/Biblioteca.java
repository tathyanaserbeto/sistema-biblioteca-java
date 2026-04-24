package biblioteca.services;

import biblioteca.models.Autor;
import biblioteca.models.Cliente;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Autor> autores = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarLivroPorId(int idLivro) {
        for (Livro l : livros) {
            if (l.getIdLivro() == idLivro) {
                return l;
            }
        }
        return null;
    }

    public void listarLivrosDisponiveis() {
        for (Livro l : livros) {
            if (l.isDisponivel()) {
                System.out.println(l.getIdLivro() + " - " + l.getTitulo() + " - " + l.getAutor());
            }
        }
    }

    public void listarLivrosEmprestados() {
        for (Emprestimo e : emprestimos) {
            if (e.getDataDevolucao() == null) {
                System.out.println( e.getLivro().getIdLivro() + " - " +
                        e.getLivro().getTitulo() + " | Cliente: " +
                        e.getCliente().getNome()
                );
            }
        }
    }

    public void listarEmprestimosPorCliente(String nomeCliente) {

        boolean encontrou = false;

        for (Emprestimo e : emprestimos) {
            if (e.getCliente().getNome().equalsIgnoreCase(nomeCliente)
                    && e.getDataDevolucao() == null) {

                System.out.println(
                        e.getLivro().getIdLivro() + " - " +
                                e.getLivro().getTitulo()
                );
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum empréstimo encontrado para esse cliente.");
        }
    }

    public void realizarEmprestimo(int idLivro, Cliente cliente){

        Livro livro = buscarLivroPorId(idLivro);

        if (livro == null || !livro.isDisponivel()) {
            System.out.println("Livro indisponível.");
            return;
        }

        livro.emprestar();

        Emprestimo emprestimo = new Emprestimo(livro, new Cliente(cliente.getNome(), cliente.getEmail()));
        emprestimos.add(emprestimo);

        System.out.println("Empréstimo realizado com sucesso para " + cliente.getNome() + "!");
    }

    public void devolverLivro(int idLivro, String nomeCliente) {

        for (Emprestimo e : emprestimos) {

            if (e.getCliente().getNome().equalsIgnoreCase(nomeCliente)
                    && e.getLivro().getIdLivro() == idLivro
                    && e.getDataDevolucao() == null) {

                e.setDataDevolucao(java.time.LocalDateTime.now());
                e.getLivro().setDisponivel(true);

                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado.");
    }

    public Cliente buscarOuCriarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }

        Cliente novo = new Cliente(nome, "nao-informado");
        clientes.add(novo);
        return novo;
    }

    //InicializarDados
    public void inicializarDados(){

        //AUTOR
        Autor georgeRrMartin = new Autor("George R. R. Martin", "1948");
        Autor jKRowling = new Autor("J. K. Rowling", "1965");
        Autor stephenKing = new Autor("Stephen King", "1947");
        Autor harukiMurakami = new Autor("Haruki Murakami", "1949");
        Autor chimamandaNgoziAdichie = new Autor("Chimamanda Ngozi Adichie", "1977");
        Autor collenHoover = new Autor("Colleen Hoover", "1979");
        Autor neilGaiman = new Autor("Neil Gaiman", "1960");
        Autor pauloCoelho = new Autor("Paulo Coelho", "1947");
        Autor yuvalNoahHarari = new Autor("Yuval Noah Harari", "1976");
        Autor breneBrown = new Autor("Brené Brown", "1965");

        autores.add(georgeRrMartin);
        autores.add(jKRowling);
        autores.add(stephenKing);
        autores.add(harukiMurakami);
        autores.add(chimamandaNgoziAdichie);

        //LIVROS
        Livro gameOfThrones1 = new Livro("A Guerra dos Tronos", georgeRrMartin);
        Livro gameOfThrones2 = new Livro("A Fúria dos Reis", georgeRrMartin);
        Livro harryPotter1 = new Livro("Harry Potter e a Pedra Filosofal", jKRowling);
        Livro harryPotter2 = new Livro("Harry Potter e o Prisioneiro de Azkaban", jKRowling);
        Livro stephenKing1 = new Livro("It: A Coisa", stephenKing);
        Livro stephenKing2 = new Livro("O Iluminado", stephenKing);
        Livro murakami1 = new Livro("Kafka à Beira-Mar", harukiMurakami);
        Livro murakami2 = new Livro("Norwegian Wood", harukiMurakami);
        Livro adichie1 = new Livro("Americanah", chimamandaNgoziAdichie);
        Livro adichie2 = new Livro("Sejamos Todos Feministas", chimamandaNgoziAdichie);

        livros.add(gameOfThrones1);
        livros.add(gameOfThrones2);
        livros.add(harryPotter1);
        livros.add(harryPotter2);
        livros.add(stephenKing1);
        livros.add(stephenKing2);
        livros.add(murakami1);
        livros.add(murakami2);
        livros.add(adichie1);
        livros.add(adichie2);
    }

}
