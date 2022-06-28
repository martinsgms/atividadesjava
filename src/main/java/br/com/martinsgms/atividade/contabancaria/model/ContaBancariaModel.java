package br.com.martinsgms.atividade.contabancaria.model;

import java.math.BigDecimal;

public abstract class ContaBancariaModel
{
    protected String numeroConta;
    protected BigDecimal saldo = BigDecimal.ZERO;

    public ContaBancariaModel(String numeroConta)
    {
        this.numeroConta = numeroConta;
    }
}
