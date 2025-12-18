package com.entrevista.entrevista.services;

import com.entrevista.entrevista.dtos.request.RequestBookDto;
import com.entrevista.entrevista.entity.Book;
import com.entrevista.entrevista.exception.BookExisteException;
import com.entrevista.entrevista.exception.BookNotFoundException;
import com.entrevista.entrevista.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {this.bookRepository = bookRepository;}

    public Book createBook(RequestBookDto requestBookDto){

        if(bookRepository.existsByIsbn(requestBookDto.isbn())){
            throw new BookExisteException("Já Existe um Livro com esse ISBN");
        }
        if (requestBookDto.anoPublicacao() > 2025){
            throw new BookExisteException("Ano Invalido");
        }

        Book book = new Book();

        BeanUtils.copyProperties(requestBookDto,book);

        return bookRepository.save(book);
    }

    public List<Book> getall(){

        if (bookRepository.findAll().isEmpty()) {
            throw new BookExisteException("Nenhum Livro encontrado");
        }

        return bookRepository.findAll();
    }

    public Optional<Book> findbyid(Long id){
        if (bookRepository.findById(id).isEmpty()) {
            throw new BookNotFoundException("Livro com esse ID não encontrado");
        }

        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, RequestBookDto requestBookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Livro não encontrado"));

        if (!requestBookDto.isbn().equals(book.getIsbn())) {
            if (bookRepository.existsByIsbn(requestBookDto.isbn())) {
                throw new BookExisteException("Já Existe um Livro com esse ISBN");
            }
        }

        if (requestBookDto.anoPublicacao() > 2025) {
            throw new BookExisteException("Ano inválido");
        }

        BeanUtils.copyProperties(requestBookDto, book);

        return bookRepository.save(book);
    }
}
