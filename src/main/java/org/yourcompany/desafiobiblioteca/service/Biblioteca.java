package org.yourcompany.desafiobiblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.yourcompany.desafiobiblioteca.model.Livro;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivrosDisponiveis() {
        System.out.println("Livros disponíveis para empréstimo:");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public void realizarEmprestimo() {
        Scanner scanner = new Scanner(System.in);
        listarLivrosDisponiveis();

        System.out.println("Digite o ID do livro que deseja emprestar:");
        int idLivro = scanner.nextInt();
        scanner.nextLine(); 

        Livro livro = buscarLivroPorId(idLivro);
        if (livro != null && livro.isDisponivel()) {
            System.out.println("Digite seu nome:");
            String nome = scanner.nextLine();

            livro.setDisponivel(false);
            System.out.println("O livro '" + livro.getTitulo() + "' foi emprestado com sucesso para " + nome + ".");
        } else {
            System.out.println("Livro não disponível ou ID inválido.");
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Você gostaria de ver os livros disponíveis? (SIM/NÃO)");
            opcao = scanner.nextLine().toUpperCase();

            if (opcao.equals("SIM")) {
                realizarEmprestimo();
            } else if (opcao.equals("NÃO")) {
                System.out.println("Encerrando o sistema...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}
