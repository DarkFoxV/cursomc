package com.darkfoxv.cursomc.domain;

import com.darkfoxv.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private EstadoPagamento estadoPagamento;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="pedido_id")
    @MapsId
    private  Pedido pedido;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
