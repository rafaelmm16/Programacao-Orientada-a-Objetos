import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando a ferramenta de entrada de dados e a lista para armazenar os chamados
        Scanner scanner = new Scanner(System.in);
        ArrayList<Chamado> listaChamados = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU DE HELP DESK ===");
            System.out.println("1. Abrir Novo Chamado Geral");
            System.out.println("2. Abrir Novo Chamado de Rede");
            System.out.println("3. Listar Todos os Chamados");
            System.out.println("4. Resolver um Chamado");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado (quebra de linha)

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do chamado: ");
                    int idGeral = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Descreva o problema: ");
                    String descGeral = scanner.nextLine();
                    
                    // Instanciando e guardando o novo objeto na lista
                    Chamado novoGeral = new Chamado(idGeral, descGeral);
                    listaChamados.add(novoGeral);
                    System.out.println("Chamado geral registrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o ID do chamado: ");
                    int idRede = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Descreva o problema de rede: ");
                    String descRede = scanner.nextLine();
                    
                    System.out.print("Qual o IP da máquina afetada? ");
                    String ipAfetado = scanner.nextLine();
                    
                    // Instanciando a subclasse e guardando na lista (Polimorfismo em ação!)
                    ChamadoRede novoRede = new ChamadoRede(idRede, descRede, ipAfetado);
                    listaChamados.add(novoRede);
                    System.out.println("Chamado de rede registrado com sucesso!");
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE CHAMADOS ---");
                    if (listaChamados.isEmpty()) {
                        System.out.println("Nenhum chamado registrado no momento.");
                    } else {
                        // Percorre a lista e chama o método de exibir os detalhes
                        for (Chamado c : listaChamados) {
                            System.out.println(c.obterDetalhes());
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do chamado que deseja resolver: ");
                    int idResolver = scanner.nextInt();
                    scanner.nextLine();
                    boolean encontrado = false;

                    for (Chamado c : listaChamados) {
                        if (c.getId() == idResolver) {
                            // Verifica se o objeto é uma instância da subclasse ChamadoRede
                            if (c instanceof ChamadoRede) {
                                System.out.print("Digite o diagnóstico de rede: ");
                                String diag = scanner.nextLine();
                                // Faz o cast (conversão) para acessar o método sobrecarregado
                                ((ChamadoRede) c).resolver(diag);
                            } else {
                                c.resolver(); // Chama o método padrão
                            }
                            encontrado = true;
                            break; // Interrompe a busca após encontrar
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Chamado ID " + idResolver + " não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        scanner.close(); // Boa prática: fechar o scanner ao final do programa
    }
}