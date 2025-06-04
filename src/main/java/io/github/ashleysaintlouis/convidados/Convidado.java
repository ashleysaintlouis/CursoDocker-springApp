package io.github.ashleysaintlouis.convidados;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Convidado {
    private String nome;
    private String cpf;
}

