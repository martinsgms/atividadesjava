package br.com.martinsgms.atividade.contabancaria.model;

import java.util.List;

import br.com.martinsgms.atividade.contabancaria.model.ContaBancariaModel;
import br.com.martinsgms.atividade.contabancaria.model.PessoaModel;

public class PessoaFisicaModel extends PessoaModel
{
    public PessoaFisicaModel(String nome, List<ContaBancariaModel> contas)
    {
        super(nome, contas);
    }
}
