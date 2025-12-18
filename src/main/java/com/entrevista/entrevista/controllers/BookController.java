package com.entrevista.entrevista.controllers;

import com.entrevista.entrevista.dtos.request.RequestBookDto;
import com.entrevista.entrevista.dtos.response.ResponseBookDto;
import com.entrevista.entrevista.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {this.bookService = bookService;}

    @PostMapping
    public ResponseEntity<ResponseBookDto> save(@RequestBody RequestBookDto requestBookDto) {

        var book = bookService.createBook(requestBookDto);

        var response = ResponseBookDto.fromEntity(book);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping
    public ResponseEntity<List<ResponseBookDto>> findAll(){
        var listbook = bookService.getall();

        var response = listbook.stream().map(ResponseBookDto::fromEntity).toList();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBookDto> findById(@PathVariable Long id){
        return bookService.findbyid(id)
                .map(book -> ResponseEntity.ok(ResponseBookDto
                        .fromEntity(book)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBookDto> update(@PathVariable Long id,
                                                  @RequestBody RequestBookDto requestBookDto) {
        var book = bookService.updateBook(id, requestBookDto);

        var response = ResponseBookDto.fromEntity(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
