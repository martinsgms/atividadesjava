package br.com.martinsgms.atividade.contabancaria.model;

import java.util.List;

public abstract class PessoaModel
{
    protected String nome;

    protected List<ContaBancariaModel> contas;

    public PessoaModel(String nome, List<ContaBancariaModel> contas)
    {
        this.nome = nome;
        this.contas = contas;
    }

    @Override
    public String toString()
    {
        return this.nome;
    }
}
