package br.com.martinsgms.atividade.contabancaria.model;

import java.math.BigDecimal;

import br.com.martinsgms.atividade.contabancaria.exception.ValidationException;

public class ContaCorrenteModel extends ContaBancariaModel implements OperacoesConta
{
    private static final BigDecimal DEPOSITO_VALOR_MAXIMO = new BigDecimal(5_000);

    public ContaCorrenteModel(String numeroConta)
    {
        super(numeroConta);
    }

    @Override
    public void saque(BigDecimal valor)
    {
        // não especificado validação para saque maior que saldo

        super.saldo = super.saldo.subtract(valor);
    }

    @Override
    public void deposito(BigDecimal valor)
    {
        if (valor.compareTo(DEPOSITO_VALOR_MAXIMO) > 0)
        {
            throw new ValidationException("O valor máximo para depósito em Conta Corrente é R$ " + DEPOSITO_VALOR_MAXIMO);
        }

        super.saldo = super.saldo.add(valor);
    }

    @Override
    public BigDecimal getSaldo()
    {
        return super.saldo;
    }
}
