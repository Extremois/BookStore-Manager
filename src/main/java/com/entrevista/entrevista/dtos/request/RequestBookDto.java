package com.entrevista.entrevista.dtos.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestBookDto(@NotBlank(message = "Titulo não pode ser vazio")
                             String titulo,
                             @NotBlank(message = "Autor não pode ser vazio")
                             String autor,
                             @NotBlank(message = "ISBN não pode ser vazio")
                             String isbn,
                             @NotNull(message = "Ano de publicação é obrigatório")
                             @Max(value = 2025, message = "Ano inválido")
                             Integer anoPublicacao){
}
