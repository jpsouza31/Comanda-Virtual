import produto.model.Produto;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {
    static Scanner ler = new Scanner(System.in);
    public static void main(String[] args)
    {
        while (true){
            System.out.println("========= Comanda Virtual =========");
            System.out.println("Selecione:");
            System.out.println("1 - Cadastrar novo cliente");
            System.out.println("2 - Cadastrar novo funcionário");
            System.out.println("3 - Novo produto");
            System.out.println("4 - Abrir nova comanda");
            System.out.println("5 - Listar Funcionários");
            System.out.println("5 - Listar Clientes");
            System.out.println("7 - Listar Comandas");
            System.out.println("8 - Listar Produtos");
            System.out.println("9 - Sair");
            Integer opcao = ler.nextInt();
            if(opcao == 1){}
            else if(opcao == 2){}
            else if(opcao == 3){}
            else if(opcao == 4){}
            else if(opcao == 5){}
            else if(opcao == 6){}
            else if(opcao == 7){}
            else if(opcao == 8){ listarProdutos(); }
            else if(opcao == 9){break;}
        }
    }

    private static void listarProdutos(){
        Produto.listarProdutos();
        System.out.println("Selecione:");
        System.out.println("1 - Adicionar novo produto");
        System.out.println("2 - Editar produto");
        System.out.println("3 - Excluir produto");
        System.out.println("4 - Voltar");
        Integer opcao = ler.nextInt();
        if(opcao == 1){
            System.out.println("*****Novo Produto*****");
            Produto produto = new Produto();
            System.out.println("Nome: ");
            ler.nextLine();
            produto.setNome(ler.nextLine());
            System.out.println("Preco: ");
            Float preco = ler.nextFloat();
            produto.setPreco(preco);
            System.out.println("Desconto: ");
            Integer desconto = ler.nextInt();
            produto.setDesconto(desconto);
            produto.save();
        }
        else if(opcao == 2){
            System.out.println("Id do produto que deseja editar: ");
            Integer id = ler.nextInt();
            Produto produto = Produto.findById(id);
            if(produto != null){
                System.out.println("*****Produto*****");
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preco: " + produto.getPreco());
                System.out.println("Desconto: " + produto.getDesconto());
                System.out.println("Novo nome: ");
                ler.nextLine();
                produto.setNome(ler.nextLine());
                System.out.println("Novo preco: ");
                produto.setPreco(ler.nextFloat());
                System.out.println("Novo desconto: ");
                produto.setDesconto(ler.nextInt());
                produto.update();
            }else{
                System.out.println("Produto não encontrado");
            }
        }
        else if(opcao == 3){
            System.out.println("Id do produto que deseja excluir: ");
            Integer id = ler.nextInt();
            Produto.deleteById(id);
        }
        else if(opcao == 4){return;}
    }
}
