
import java.util.Scanner;

public class Sistema {
    private Usuario usuarios[];
    private Servico servicos[];
    private Produto produtos[];
    private static int qtdadeServicos;
    private static int qtdadeProdutos;
    private static int idUsuarios;
    private int idUsuarioLogado;
    private Scanner sc;

    public Sistema() {
        servicos = new Servico[50];
        usuarios = new Usuario[50];
        produtos = new Produto[50];
        qtdadeServicos = 0;
        qtdadeProdutos = 0;
        idUsuarios = 0;
        idUsuarioLogado = -1;
        sc = new Scanner(System.in);
        menuUsuario();
    }

    public void menuUsuario() {
        int opcao;
        do {
            System.out.println("---Menu de Usuário---");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Efetuar Login");
            System.out.println("3 - Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    efetuarLogin();
                    break;
                case 3:
                    System.out.println("Saindo!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 3);
    }

    public void menuServicos() {
        int opcao;
        do {
            System.out.println("---Serviços---");
            System.out.println("1 - Cadastrar serviço");
            System.out.println("2 - Listar serviços");
            System.out.println("3 - Sair");
            
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarServico();
                    break;
                case 2:
                    listarServicos();
                    break;
                case 3:
                    System.out.println("Voltando para o menu de gerenciamento!!!");
                    menuSelecao();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 3);
    }
    
    public void menuProdutos() {
        int opcao;
        do {
            System.out.println("---Produtos---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Sair");
            
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    System.out.println("Voltando para o menu de gerenciamento!!!");
                    menuSelecao();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 3);
    }
    
    public void menuSelecao() {
        int opcao;
        do {
            System.out.println("---Menu de Gerenciamento---");
            System.out.println("1 - Gerenciar Serviços");
            System.out.println("2 - Gerenciar Produtos");
            System.out.println("3 - Relatório de Serviços e Produtos");
            System.out.println("4 - Sair");
            
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    menuServicos();
                    break;
                case 2:
                    menuProdutos();
                    break;
                case 3:
                    relatorioServicosProdutos();
                    break;    
                case 4:
                    System.out.println("Voltando para o menu de usuário!!!");
                    idUsuarioLogado = -1;
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 3);
    }
    
    public void relatorioServicosProdutos() {
        System.out.println("---Serviços e Produtos cadastrados no sistema---");
        System.out.println("---Serviços---");
        listarServicos();
        System.out.println("---Produtos---"); 
        listarProdutos();
   }

    public void listarServicos() {
        if (qtdadeServicos > 0) {
            for (int i = 0; i < qtdadeServicos; ++i) {
                System.out.println("Serviço: " + servicos[i].getNome()
                        + "\nDescrição: " + servicos[i].getDescricao()
                        + "\nValor: R$" + servicos[i].getValor()
                        + "\nResponsável: " + usuarios[servicos[i].getIdUser()].getNome() 
                        + "\nTelefone: " + usuarios[servicos[i].getIdUser()].getTelefone());
            }
        } else {
            System.out.println("Não existem serviços cadastrados");
        }
    }
    
    public void listarProdutos() {
        if (qtdadeProdutos > 0) {
            for (int i = 0; i < qtdadeProdutos; ++i) {
                System.out.println("Produto: " + produtos[i].getNome()
                        + "\nCategoria: " + produtos[i].getCategoria()
                        + "\nValidade: R$" + produtos[i].getValidade()
                        + "\nPreço: R$" + produtos[i].getPreco()
                        + "\nResponsável: " + usuarios[produtos[i].getIdUser()].getNome() 
                        + "\nTelefone: " + usuarios[produtos[i].getIdUser()].getTelefone());
            }
        } else {
            System.out.println("Não existem produtos cadastrados");
        }
    }

    public void cadastrarServico() {
        if (qtdadeServicos < 50) {
            System.out.println("---Cadastro de Serviço---");
            sc.nextLine();
            servicos[qtdadeServicos] = new Servico();
            System.out.println("Entre com o nome do serviço:");
            String nome = sc.nextLine();
            servicos[qtdadeServicos].setNome(nome);
            System.out.println("Entre a descrição do serviço:");
            String descricao = sc.nextLine();
            servicos[qtdadeServicos].setDescricao(descricao);
            System.out.println("Entre com o valor do serviço:");
            double valor = sc.nextDouble();
            servicos[qtdadeServicos].setValor(valor);
            servicos[qtdadeServicos].setIdUser(idUsuarioLogado);
            qtdadeServicos++;
        } else {
            System.out.println("Limite de cadastros atingido (50)!");
        }
    }
    
    public void cadastrarProduto() {
        if (qtdadeProdutos < 50) {
            System.out.println("---Cadastro de Produto---");
            sc.nextLine();
            produtos[qtdadeProdutos] = new Produto();
            System.out.println("Entre com o nome do produto:");
            String nome = sc.nextLine();
            produtos[qtdadeProdutos].setNome(nome);
            System.out.println("Entre com a categoria do produto:");
            String categoria = sc.nextLine();
            produtos[qtdadeProdutos].setCategoria(categoria);
            System.out.println("Entre com a validade do produto:");
            String validade = sc.nextLine();
            produtos[qtdadeProdutos].setValidade(validade);
            System.out.println("Entre com o preço do produto:");
            double preco = sc.nextDouble();
            produtos[qtdadeProdutos].setPreco(preco);
            produtos[qtdadeProdutos].setIdUser(idUsuarioLogado);
            qtdadeProdutos++;
        } else {
            System.out.println("Limite de cadastros atingido (50)!");
        }
    }

    public void efetuarLogin() {
        System.out.println("---Tela de Login---");
        sc.nextLine();
        System.out.println("Entre com seu login:");
        String login = sc.nextLine();
        System.out.println("Entre com sua senha:");
        String senha = sc.nextLine();
        if (idUsuarios > 0) {
            for (int i = 0; i < idUsuarios; ++i) {
                if (usuarios[i].getLogin().equals(login)
                        && usuarios[i].getSenha().equals(senha)) {
                    idUsuarioLogado = i;
                    System.out.println("Bem-vindo " + usuarios[idUsuarioLogado].getNome());
                    menuSelecao();
                    return;
                }
            }
            System.out.println("Usuário não encontrado!");
        }else{
            System.out.println("Ainda não há nenhum usuário cadastrado!");
        }
    }

    public void cadastrarUsuario() {
        if (idUsuarios < 50) {
            System.out.println("---Cadastro de Usuário---");
            sc.nextLine();
            usuarios[idUsuarios] = new Usuario();
            System.out.println("Entre com seu nome:");
            String nome = sc.nextLine();
            usuarios[idUsuarios].setNome(nome);
            System.out.println("Entre com seu cpf:");
            String cpf = sc.nextLine();
            usuarios[idUsuarios].setCpf(cpf);
            System.out.println("Entre com seu telefone:");
            String telefone = sc.nextLine();
            usuarios[idUsuarios].setTelefone(telefone);
            System.out.println("Entre com seu nome de usuário(login):");
            String login = sc.nextLine();
            usuarios[idUsuarios].setLogin(login);
            System.out.println("Entre com sua senha:");
            String senha = sc.nextLine();
            usuarios[idUsuarios].setSenha(senha);
            usuarios[idUsuarios].setId(idUsuarios);
            idUsuarios++;
        } else {
            System.out.println("Limite de usuários atingido(50)!");
        }
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.menuUsuario();
    }
}
