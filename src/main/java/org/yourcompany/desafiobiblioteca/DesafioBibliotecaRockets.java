

package org.yourcompany.desafiobiblioteca;

import java.time.LocalDate;

import org.yourcompany.desafiobiblioteca.model.Autor;
import org.yourcompany.desafiobiblioteca.model.Livro;
import org.yourcompany.desafiobiblioteca.service.Biblioteca;

/**
 *
 * @author Aninha Dal Molin
 */
public class DesafioBibliotecaRockets {

    public static void main(String[] args) {


        Autor autor1 = new Autor(1, "J.K. Rowling", LocalDate.of(1965, 7, 31));
        Autor autor2 = new Autor(2, "J.R.R. Tolkien", LocalDate.of(1892, 1, 3));

        Livro livro1 = new Livro(1, "Harry Potter e a Pedra Filosofal", autor1);
        Livro livro2 = new Livro(2, "O Senhor dos Anéis", autor2);
        
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        biblioteca.iniciar();
    }

    
}
