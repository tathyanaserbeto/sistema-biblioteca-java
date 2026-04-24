package biblioteca.models;

public class Autor {
    private final int idAutor;
    private String nome;
    private String dataNascimento;

    private static int contadorAutorId = 0;

    public Autor (String nome, String dataNascimento){
        this.idAutor = contadorAutorId++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
