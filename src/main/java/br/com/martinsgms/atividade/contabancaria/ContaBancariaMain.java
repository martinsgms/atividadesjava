package br.com.martinsgms.atividade.contabancaria;

import java.util.ArrayList;
import java.util.List;

import br.com.martinsgms.atividade.contabancaria.model.ContaCorrenteModel;
import br.com.martinsgms.atividade.contabancaria.model.ContaPoupancaModel;
import br.com.martinsgms.atividade.contabancaria.model.PessoaModel;
import br.com.martinsgms.atividade.contabancaria.service.CadastroService;

public class ContaBancariaMain
{
    public static List<PessoaModel> pessoasCadastradas = new ArrayList<>();

    public static void main(String[] args)
    {
        CadastroService cadastroService = new CadastroService();

        cadastroService.cadastrarPessoaFisica("João Silva", new ContaCorrenteModel("1010"), new ContaPoupancaModel("1010-1"));
        cadastroService.cadastrarPessoaJuridica("TNT", "TNT Cargas e Encomendas", new ContaCorrenteModel("2020"));

        pessoasCadastradas.forEach(System.out::println);
    }
}
