package io.github.ashleysaintlouis.convidados;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadoRepository extends JpaRepository<Convidado, String> {
    
}
