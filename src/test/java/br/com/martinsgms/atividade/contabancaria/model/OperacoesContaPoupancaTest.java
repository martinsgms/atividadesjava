package br.com.martinsgms.atividade.contabancaria.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.martinsgms.atividade.contabancaria.exception.ValidationException;

public class OperacoesContaPoupancaTest
{
    @Test
    public void testSaque()
    {
        OperacoesConta cp = new ContaPoupancaModel("1010");

        cp.deposito(new BigDecimal(10_000));
        cp.saque(new BigDecimal(1_000));

        assertEquals(new BigDecimal(9_000), cp.getSaldo());
    }

    @Test
    public void testSaqueInvalido()
    {
        OperacoesConta cp = new ContaPoupancaModel("1010");
        cp.deposito(new BigDecimal(10_000));

        assertThrows(ValidationException.class, () -> cp.saque(new BigDecimal(3_000)));
        assertEquals(new BigDecimal(10_000), cp.getSaldo());
    }
}
