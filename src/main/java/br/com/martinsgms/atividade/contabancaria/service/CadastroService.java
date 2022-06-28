package br.com.martinsgms.atividade.contabancaria.service;

import java.util.Arrays;

import br.com.martinsgms.atividade.contabancaria.ContaBancariaMain;
import br.com.martinsgms.atividade.contabancaria.model.ContaBancariaModel;
import br.com.martinsgms.atividade.contabancaria.model.PessoaFisicaModel;
import br.com.martinsgms.atividade.contabancaria.model.PessoaJuridicaModel;
import br.com.martinsgms.atividade.contabancaria.validation.CadastroValidator;

public class CadastroService
{
    private CadastroValidator validator = new CadastroValidator();

    public void cadastrarPessoaFisica(String nome, ContaBancariaModel... contas)
    {
        validator.validarPessoaFisica(nome, contas);

        ContaBancariaMain.pessoasCadastradas.add(new PessoaFisicaModel(nome, Arrays.asList(contas)));
    }

    public void cadastrarPessoaJuridica(String nome, String nomeFantasia, ContaBancariaModel... contas)
    {
        validator.validarPessoaJuridica(nome, nomeFantasia, contas);

        ContaBancariaMain.pessoasCadastradas.add(new PessoaJuridicaModel(nome, nomeFantasia, Arrays.asList(contas)));
    }
}
