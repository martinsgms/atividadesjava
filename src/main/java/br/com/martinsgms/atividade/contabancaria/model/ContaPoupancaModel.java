package br.com.martinsgms.atividade.contabancaria.model;

import java.math.BigDecimal;

import br.com.martinsgms.atividade.contabancaria.exception.ValidationException;

public class ContaPoupancaModel extends ContaBancariaModel implements OperacoesConta
{
    private static final BigDecimal SAQUE_VALOR_MAXIMO = new BigDecimal(2_000);

    public ContaPoupancaModel(String numeroConta)
    {
        super(numeroConta);
    }

    @Override
    public void saque(BigDecimal valor)
    {
        if (valor.compareTo(SAQUE_VALOR_MAXIMO) > 0)
        {
            throw new ValidationException("O valor m�ximo para saque em Conta Poupan�a � R$ " + SAQUE_VALOR_MAXIMO);
        }

        // n�o especificado valida��o para saque maior que saldo

        super.saldo = super.saldo.subtract(valor);
    }

    @Override
    public void deposito(BigDecimal valor)
    {
        super.saldo = super.saldo.add(valor);
    }

    @Override
    public BigDecimal getSaldo()
    {
        return super.saldo;
    }
}
