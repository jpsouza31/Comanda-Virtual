package comanda.modal;

import cliente.model.Cliente;
import produto.model.Produto;

import java.util.Date;
import java.util.List;

public class Comanda {
    private Cliente cliente;
    private Date horarioEntrada;
    private Date horarioSaida;
    private List<Produto> produtos;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Date getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Date horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produto produto){
        this.produtos.add(produto);
    }
}
