package com.entrevista.entrevista.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record RequestBookDto(@NotBlank(message = "Titulo não pode ser vazio")
                             String titulo,
                             @NotBlank(message = "Autor não pode ser vazio")
                             String autor,
                             @NotBlank(message = "ISBN não pode ser vazio")
                             String isbn,
                             @NotBlank(message = "Ano de publicação é obrigatório")
                             Integer anoPublicacao){
}
