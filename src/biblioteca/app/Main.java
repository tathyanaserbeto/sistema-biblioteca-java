package biblioteca.app;

import java.util.Scanner;
import biblioteca.services.Biblioteca;
import biblioteca.models.Cliente;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.inicializarDados();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1 - Pegar livro emprestado");
            System.out.println("2 - Devolver livro");
            System.out.println("3 - Sair");

            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    biblioteca.listarLivrosDisponiveis();

                    System.out.println("Digite o ID do livro:");
                    int idEmprestimo = Integer.parseInt(sc.nextLine());

                    System.out.println("Digite seu nome:");
                    String nomeCliente = sc.nextLine();

                    Cliente cliente = biblioteca.buscarOuCriarCliente(nomeCliente);

                    biblioteca.realizarEmprestimo(idEmprestimo, cliente);
                    break;

                case 2:
                    System.out.println("Digite seu nome:");
                    String nome = sc.nextLine();

                    biblioteca.listarEmprestimosPorCliente(nome);

                    System.out.println("Digite o ID do livro que deseja devolver:");
                    int idLivro = Integer.parseInt(sc.nextLine());

                    biblioteca.devolverLivro(idLivro, nome);

                    break;
                case 3:
                    System.out.println("Encerrando sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}