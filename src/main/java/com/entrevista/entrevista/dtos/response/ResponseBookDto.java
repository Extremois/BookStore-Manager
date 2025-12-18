package com.entrevista.entrevista.dtos.response;

import com.entrevista.entrevista.entity.Book;

public record ResponseBookDto(Long id,
                              String titulo,
                              String autor,
                              String isbn,
                              Integer anoPublicacao){

    public static ResponseBookDto fromEntity(Book book){
        return new ResponseBookDto(
                book.getId(),
                book.getTitulo(),
                book.getAutor(),
                book.getIsbn(),
                book.getAnoPublicacao()
        );
    }
}
