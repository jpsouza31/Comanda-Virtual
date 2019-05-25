package cliente.model;

import pessoa.model.Pessoa;
import produto.model.Produto;

import java.util.Scanner;

public class Cliente extends Pessoa {
    private Produto[] produtosPreferidos;
    static Scanner ler = new Scanner(System.in);

    public Produto[] getProdutosPreferidos() {
        return produtosPreferidos;
    }

    public void setProdutosPreferidos(Produto[] produtosPreferidos) {
        this.produtosPreferidos = produtosPreferidos;
    }
}
