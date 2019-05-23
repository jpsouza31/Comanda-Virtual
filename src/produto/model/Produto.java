package produto.model;

import produto.dao.ProdutoDAO;
import java.util.List;

public class Produto {
    private Integer id;
    private String nome;
    private Float preco;
    private Integer desconto;

    public void save(){
        try {
            ProdutoDAO.save(this);
            System.out.println("Produto '"+ this.getNome() +"' inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(){
        try {
            ProdutoDAO.updateProduto(this);
            System.out.println("Produto '"+ this.getNome() +"' atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(Integer id){
        try {
            ProdutoDAO.removeById(Produto.findById(id).getId());
            System.out.println("Produto excluido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Produto findById(Integer id){
        return ProdutoDAO.getById(id);
    }

    public static void listarProdutos(){
        List<Produto> produtos = ProdutoDAO.getProdutos();
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado!");
        }else{
            System.out.println("ID        Nome        Preco        Desconto");
            for(Produto produto: produtos){
                System.out.println(produto.getId() +
                        "         " + produto.getNome() + "        " +
                        produto.getPreco() + "            " + produto.getDesconto());
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }
}
