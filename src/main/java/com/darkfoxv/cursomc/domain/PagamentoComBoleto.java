package com.darkfoxv.cursomc.domain;

import com.darkfoxv.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class PagamentoComBoleto extends Pagamento {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date DateVencimento;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date DataPagamento;

    public PagamentoComBoleto(Long id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataPagamento, Date dateVencimento) {
        super(id, estadoPagamento, pedido);
        DataPagamento = dataPagamento;
        DateVencimento = dateVencimento;
    }
}
