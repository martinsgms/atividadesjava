package br.com.martinsgms.atividade.contabancaria.model;

import java.math.BigDecimal;

public interface OperacoesConta
{
    void saque(BigDecimal valor);

    void deposito(BigDecimal valor);

    BigDecimal getSaldo();
}
