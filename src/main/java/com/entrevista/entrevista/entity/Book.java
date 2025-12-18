package com.entrevista.entrevista.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo",  nullable = false)
    private String titulo;

    @Column(name = "autor",  nullable = false)
    private String autor;

    @Column(name = "isbn",   nullable = false)
    private String isbn;

    @Column(name = "ano",   nullable = false)
    private Integer anoPublicacao;


    public Book() {
    }

    public Book(Long id, String titulo, String autor, String isbn, Integer anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
    }

}
