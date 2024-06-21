package com.darkfoxv.cursomc.domain.enums;

import lombok.Getter;

@Getter
public enum EstadoPagamento {
    PENDENTE(1, "Pessoa Física"),
    QUITADO(2, "Pessoa Física"),
    CANCELADO(3, "Pessoa Jurídica");

    private final int code;
    private final String description;

    private EstadoPagamento(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static EstadoPagamento toEnum(Integer code){
        if(code == null){
            return null;
        }

        for(EstadoPagamento x : EstadoPagamento.values()){
            if(code.equals(x.getCode())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + code);
    }
}
