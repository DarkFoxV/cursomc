package com.darkfoxv.cursomc.domain;

import com.darkfoxv.cursomc.domain.enums.EstadoPagamento;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class PagamentoComCartao extends Pagamento {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao(Long id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
