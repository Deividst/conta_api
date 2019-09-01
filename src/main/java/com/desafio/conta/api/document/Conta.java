package com.desafio.conta.api.document;


import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "conta")
public class Conta {

    @Id
    private String id;

    @NotBlank
    @Size(max = 6)
    @Pattern(regexp = "[0-9]+")
    private String numero;

    @NotBlank
    @Size(max = 4)
    @Pattern(regexp = "[0-9]+")
    private String agencia;

    @NotBlank
    @Size(max = 11)
    @Pattern(regexp = "[0-9]+")
    @CPF
    private String cpf;
    private Boolean status;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;

}
