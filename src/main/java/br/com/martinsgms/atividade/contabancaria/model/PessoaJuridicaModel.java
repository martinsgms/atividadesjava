package br.com.martinsgms.atividade.contabancaria.model;

import java.util.List;

public class PessoaJuridicaModel extends PessoaModel
{
    private String nomeFantasia;

    public PessoaJuridicaModel(String nome, String nomeFantasia, List<ContaBancariaModel> contas)
    {
        super(nome, contas);
        this.nomeFantasia = nomeFantasia;
    }

}
