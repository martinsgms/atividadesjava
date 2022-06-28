package br.com.martinsgms.atividade.contabancaria.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.martinsgms.atividade.contabancaria.exception.ValidationException;

public class OperacoesContaCorrenteTest
{
    @Test
    public void testDeposito()
    {
        OperacoesConta cc = new ContaCorrenteModel("2020");

        BigDecimal valorDeposito = new BigDecimal(1_000);
        cc.deposito(valorDeposito);

        assertEquals(valorDeposito, cc.getSaldo());
    }

    @Test
    public void testDepositoInvalido()
    {
        OperacoesConta cc = new ContaCorrenteModel("2020");

        assertThrows(ValidationException.class, () -> cc.deposito(new BigDecimal(10_000)));
        assertEquals(BigDecimal.ZERO, cc.getSaldo());
    }

    @Test
    public void testSaque()
    {
        OperacoesConta cc = new ContaCorrenteModel("1010");

        cc.deposito(new BigDecimal(3_000));
        cc.saque(new BigDecimal(1_000));

        assertEquals(new BigDecimal(2_000), cc.getSaldo());
    }
}
