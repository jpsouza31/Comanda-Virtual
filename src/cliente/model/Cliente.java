package cliente.model;

import pessoa.model.Pessoa;
import produto.model.Produto;

import java.util.Scanner;

public class Cliente extends Pessoa {
    private Produto[] produtosPreferidos;
    static Scanner ler = new Scanner(System.in);

    //Novo Cadastro
    public static Cliente cadastrar(){
        Cliente novo = new Cliente();
        System.out.println("Nome: ");
        novo.setNome(ler.next());
        System.out.println("Email: ");
        novo.setEmail(ler.next());
        System.out.println("CPF: ");
        novo.setCpf(ler.nextDouble());
        return novo;
    }

    public Produto[] getProdutosPreferidos() {
        return produtosPreferidos;
    }

    public void setProdutosPreferidos(Produto[] produtosPreferidos) {
        this.produtosPreferidos = produtosPreferidos;
    }
}
