package pizzaria;

import java.time.LocalDate;
import java.util.Scanner;

public class Pizzaria {

    public static void main(String[] args) {
        DAODiaTrabalho daoDiaT = new DAODiaTrabalho();
        DAOPizza daoPizza = new DAOPizza();
        DAOPedido daoPedido = new DAOPedido();

        Scanner scanner = new Scanner(System.in);
        int opcao;
        LocalDate dataEspecifica = LocalDate.of(2024, 10, 26);
        boolean executando = true;
        while (executando) {
            // Exibe o menu
            System.out.println("\n====== MENU =======");
            System.out.println("[1] Iniciar novo dia de trabalho");
            System.out.println("[2] Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("=== Iniciando novo dia de trabalho ===");

                    DiaTrabalho dia = daoDiaT.create(new DiaTrabalho(1, dataEspecifica));
                    System.out.println("Dia de trabalho criado: " + dia.getDia());
                    boolean noDiaDeTrabalho = true;

                    while (noDiaDeTrabalho) {
                        System.out.println("=== * MENU DE ACOES * ===");
                        System.out.println("[1] Menu Pizzas");
                        System.out.println("[2] Menu Pedido");
                        System.out.println("[3] Mostrar Relatorio do dia");
                        System.out.println("[4] Sair");
                        System.out.print("Escolha uma opcao: ");
                        int acao = scanner.nextInt();

                        switch (acao) {
                            case 1:
                                // Menu pizza
                                boolean noMenuPizza = true;
                                while (noMenuPizza) {
                                    System.out.println("\n====== MENU PIZZA =======");
                                    System.out.println("[1] Adicionar Pizza");
                                    System.out.println("[2] Exibir Pizzas");
                                    System.out.println("[3] Atualizar Preço de Pizza");
                                    System.out.println("[4] Remover Pizza");
                                    System.out.println("[5] Voltar ao menu de ações");
                                    System.out.print("Escolha uma opcao: ");
                                    int opcaoPizza = scanner.nextInt();
                                    scanner.nextLine(); // Limpa o buffer do scanner

                                    switch (opcaoPizza) {
                                        case 1:
                                            // Adicionar Pizza
                                            System.out.println("=== Criando Pizzas ===");
                                            Pizza calabresa = daoPizza.create(new Calabresa("Calabreso", 1, 20, "Grande", "Calabresa e molho de tomate", 60));
                                            Pizza frango = daoPizza.create(new Frango("Frango", 2, 30, "Media", "Frango, catupiry e molho de tomate", 40));
                                            Pizza nutella = daoPizza.create(new Nutella("Nutella", 3, 20, "Pequena", "Nutella e morango", 60));
                                            System.out.println(daoPizza.getAll());
                                            break;
                                        case 2:
                                            // Exibir Pizzas
                                            System.out.println("\n=== Pizzas disponíveis ===");
                                            System.out.println(daoPizza.getAll());
                                            break;
                                        case 3:
                                            // Atualizar Pizza
                                            System.out.print("=== Atualizar Pizza ===");
                                            Pizza pizzaUP = new Calabresa("Calabresinha", 1, 20, "Grande", "Calabresa e molho de tomate", 60);
                                            daoPizza.update(pizzaUP);
                                            System.out.print("Pizza atualizada com sucesso!");
                                            pizzaUP.getPizza(pizzaUP);
                                            break;
                                        case 4:
                                            // Remover Pizza
                                            System.out.println("\n=== Remover Pizza ===");
                                            Pizza pizzaSD = daoPizza.read(1);

                                            if (daoPizza.delete(pizzaSD)) {
                                                System.out.println("Exclusao com sucesso");
                                            } else {
                                                System.out.println("Exclusao nao realizada");
                                            }
                                            break;
                                        case 5:
                                            // Voltar ao menu de ações
                                            noMenuPizza = false;
                                            break;
                                        default:
                                            System.out.println("Opcao invalida. Tente novamente.");
                                    }
                                }
                                break;
                            case 2:
                                boolean noMenuPedido = true;
                                while (noMenuPedido) {
                                    System.out.println("\n====== MENU PEDIDO =======");
                                    System.out.println("[1] Criar Pedido");
                                    System.out.println("[2] Exibir Pedidos");
                                    System.out.println("[3] Exibir Pedido por cliente");
                                    System.out.println("[4] Deletar Pedido");
                                    System.out.println("[5] Voltar ao menu de ações");
                                    System.out.print("Escolha uma opcao: ");
                                    int opcaoPedido = scanner.nextInt();

                                    switch (opcaoPedido) {
                                        case 1:
                                            // Criar Pedido
                                            System.out.println("=== Criando um novo Pedido ===");
                                            Pedido pedido1 = daoPedido.create(new Pedido(1, 1));
                                            System.out.println("Digite o Id da pizza que deseja adicionar ao Pedido: ");
                                            Scanner leitor = new Scanner(System.in);

                                            int idPizza = leitor.nextInt();
                                            pedido1.addPizza(daoPizza.getPizza(idPizza));

                                            dia.addPedido(pedido1);
                                            System.out.println("Pedido adicionado com sucesso!");
                                            leitor.close();
                                            break;
                                        case 2:
                                            // Exibir Pedidos
                                            System.out.println("=== Exibir Todos Pedidos ===");
                                            daoPedido.getAll();
                                            break;
                                        case 3:
                                            // Exibir pedido especifico
                                            System.out.println("=== Exibir Pedido por Cliente ===");
                                            System.out.println("Digite o Id do cliente que deseja ver os pedidos: ");
                                            Scanner leitor2 = new Scanner(System.in);
                                            int idCliente = leitor2.nextInt();

                                            Pedido existeP = daoPedido.readIdCliente(idCliente);
                                            if (existeP != null) {
                                                existeP.ExibirPedido(existeP);
                                            } else {
                                                System.out.println("Id de cliente nao existente");
                                            }
                                            leitor2.close(); 
                                            break;
                                        case 4:
                                            // Deletar pedido
                                            System.out.println("\n=== Remover Pedido ===");
                                            Pedido pedidoSD = daoPedido.read(1);

                                            if (daoPedido.delete(pedidoSD)) {
                                                System.out.println("Exclusao com sucesso");
                                            } else {
                                                System.out.println("Exclusao nao realizada");
                                            }
                                            break;
                                        case 5:
                                            // Voltar ao menu de ações
                                            noMenuPedido = false;
                                            break;
                                        default:
                                            System.out.println("Opcao invalida. Tente novamente.");
                                    }
                                }
                                break;
                            case 3:
                                // Relatorio do dia de trabalho
                                dia.ExibirDiaTrabalho(dia);
                                break;
                            case 4:
                                // Finalizar o dia de trabalho
                                System.out.println("Dia de trabalho finalizado.");
                                noDiaDeTrabalho = false;
                                break;
                            default:
                                System.out.println("Opcao invalida. Tente novamente.");
                        }
                    }

                    break;
                case 2:
                    System.out.println("==== Saindo ... ====");
                    executando = false;
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
        
        scanner.close();
    }
}
