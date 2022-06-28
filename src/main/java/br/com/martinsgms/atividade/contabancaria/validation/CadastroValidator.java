package br.com.martinsgms.atividade.contabancaria.validation;

import java.util.Arrays;
import java.util.List;

import br.com.martinsgms.atividade.contabancaria.exception.ValidationException;
import br.com.martinsgms.atividade.contabancaria.model.ContaBancariaModel;
import br.com.martinsgms.atividade.contabancaria.model.ContaCorrenteModel;
import br.com.martinsgms.atividade.contabancaria.model.ContaPoupancaModel;

public class CadastroValidator
{
    private static final String RC_PF_DEVE_POSSUIR_EXATAMENTE_UMA_CONTA_CORRENTE = "Pessoa F�sica deve possuir exatamente uma Conta Corrente.";
    private static final String RC_PF_DEVE_POSSUIR_EXATAMENTE_UMA_CONTA_POUPANCA = "Pessoa F�sica deve possuir exatamente uma Conta Poupan�a.";

    private static final String RC_PJ_SEM_CONTA_CORRENTE = "Pessoa Jur�dica deve possuir no m�nimo uma Conta Corrente.";

    private static final String RC_NOME_INVALIDO = "Nome inv�lido";
    private static final String RC_PESSOA_SEM_CONTA = "N�o � permitido Pessoa sem conta.";

    public void validarPessoaFisica(String nome, ContaBancariaModel... contas)
    {
        List<ContaBancariaModel> contasList = validaConta(contas);

        validaNome(nome);

        if (contasList.stream().filter(ContaCorrenteModel.class::isInstance).count() != 1)
        {
            throw new ValidationException(RC_PF_DEVE_POSSUIR_EXATAMENTE_UMA_CONTA_CORRENTE);
        }

        if (contasList.stream().filter(ContaPoupancaModel.class::isInstance).count() != 1)
        {
            throw new ValidationException(RC_PF_DEVE_POSSUIR_EXATAMENTE_UMA_CONTA_POUPANCA);
        }
    }

    public void validarPessoaJuridica(String nome, String nomeFantasia, ContaBancariaModel... contas)
    {
        validaNome(nome);
        validaNome(nomeFantasia);

        List<ContaBancariaModel> contasList = validaConta(contas);

        if (contasList.stream().filter(ContaCorrenteModel.class::isInstance).count() < 1)
        {
            throw new ValidationException(RC_PJ_SEM_CONTA_CORRENTE);
        }
    }

    private void validaNome(String nome)
    {
        if (nome == null || nome.trim().equals(""))
        {
            throw new ValidationException(RC_NOME_INVALIDO);
        }
    }

    private List<ContaBancariaModel> validaConta(ContaBancariaModel... contas)
    {
        if (contas == null || contas.length < 1)
        {
            throw new ValidationException(RC_PESSOA_SEM_CONTA);
        }

        return Arrays.asList(contas);
    }
}
