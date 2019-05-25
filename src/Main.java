import funcionario.model.Funcionario;
import produto.model.Produto;

import java.util.Scanner;

public class Main {
    static Scanner ler = new Scanner(System.in);
    public static void main(String[] args)
    {
        while (true){
            System.out.println("========= Comanda Virtual =========");
            System.out.println("Selecione:");
            System.out.println("1 - Abrir nova comanda");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Listar Comandas");
            System.out.println("5 - Listar Produtos");
            System.out.println("6 - Sair");
            Integer opcao = ler.nextInt();
            if(opcao == 1){}
            else if(opcao == 2){listarFuncionarios();}
            else if(opcao == 3){}
            else if(opcao == 4){}
            else if(opcao == 5){listarProdutos();}
            else if(opcao == 6){break;}
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

    private static void listarFuncionarios(){
        Funcionario.listarFuncionarios();
        System.out.println("Selecione:");
        System.out.println("1 - Adicionar novo funcionário");
        System.out.println("2 - Editar dados do funcionário");
        System.out.println("3 - Excluir funcionário");
        System.out.println("4 - Voltar");
        Integer opcao = ler.nextInt();
        if(opcao == 1){
            System.out.println("*****Novo Funcionário*****");
            Funcionario funcionario = new Funcionario();
            System.out.println("Nome: ");
            ler.nextLine();
            funcionario.setNome(ler.nextLine());
            System.out.println("Email: ");
            String email = ler.next();
            funcionario.setEmail(email);
            System.out.println("CPF: ");
            String cpf = ler.next();
            funcionario.setCpf(cpf);
            System.out.println("Login: ");
            String login = ler.next();
            funcionario.setLogin(login);
            System.out.println("Senha: ");
            Integer senha = ler.nextInt();
            funcionario.setSenha(senha);
            funcionario.save();
        }
        else if(opcao == 2){
            System.out.println("Id do funcionário que deseja editar: ");
            Integer id = ler.nextInt();
            Funcionario funcionario = Funcionario.findById(id);
            if(funcionario != null){
                System.out.println("*****Funcionário*****");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Email: " + funcionario.getEmail());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Login: " + funcionario.getLogin());
                System.out.println("Senha: " + funcionario.getSenha());
                System.out.println("Novo nome: ");
                ler.nextLine();
                funcionario.setNome(ler.nextLine());
                System.out.println("Novo Email: ");
                funcionario.setEmail(ler.next());
                System.out.println("Novo Login: ");
                funcionario.setLogin(ler.next());
                System.out.println("Nova Senha: ");
                funcionario.setSenha(ler.nextInt());
                funcionario.update();
            }else{
                System.out.println("Funcionário não encontrado");
            }
        }
        else if(opcao == 3){
            System.out.println("Id do funcionário que deseja excluir: ");
            Integer id = ler.nextInt();
            Funcionario.deleteById(id);
        }
        else if(opcao == 4){return;}
    }
}
