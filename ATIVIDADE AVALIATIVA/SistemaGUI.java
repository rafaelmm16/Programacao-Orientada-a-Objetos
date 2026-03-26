import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// A classe herda de JFrame para se tornar uma janela
public class SistemaGUI extends JFrame {
    
    private ArrayList<Chamado> listaChamados = new ArrayList<>();
    
    // Componentes da tela
    private JTextField txtId, txtDescricao, txtIp;
    private JTextArea areaDisplay;

    public SistemaGUI() {
        // Configurações básicas da janela
        setTitle("Sistema de Help Desk (POO)");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // --- PAINEL SUPERIOR (Formulário) ---
        JPanel painelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Chamado"));

        painelFormulario.add(new JLabel("ID do Chamado:"));
        txtId = new JTextField();
        painelFormulario.add(txtId);

        painelFormulario.add(new JLabel("Descrição do Problema:"));
        txtDescricao = new JTextField();
        painelFormulario.add(txtDescricao);

        painelFormulario.add(new JLabel("IP Afetado (Apenas para Rede):"));
        txtIp = new JTextField();
        painelFormulario.add(txtIp);

        add(painelFormulario, BorderLayout.NORTH);

        // --- PAINEL CENTRAL (Botões) ---
        JPanel painelBotoes = new JPanel(new FlowLayout());
        
        JButton btnAddGeral = new JButton("Criar Chamado Geral");
        JButton btnAddRede = new JButton("Criar Chamado Rede");
        JButton btnResolver = new JButton("Resolver Chamado");
        JButton btnListar = new JButton("Listar Todos");

        painelBotoes.add(btnAddGeral);
        painelBotoes.add(btnAddRede);
        painelBotoes.add(btnResolver);
        painelBotoes.add(btnListar);

        add(painelBotoes, BorderLayout.CENTER);

        // --- PAINEL INFERIOR (Tela de exibição) ---
        areaDisplay = new JTextArea(10, 50);
        areaDisplay.setEditable(false); // O usuário não pode digitar aqui
        JScrollPane scrollPane = new JScrollPane(areaDisplay);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Console do Sistema"));
        
        add(scrollPane, BorderLayout.SOUTH);

        // --- AÇÕES DOS BOTÕES ---

        btnAddGeral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    String desc = txtDescricao.getText();
                    Chamado c = new Chamado(id, desc);
                    listaChamados.add(c);
                    areaDisplay.append("Chamado Geral #" + id + " criado com sucesso!\n");
                    limparCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o ID é um número válido.");
                }
            }
        });

        btnAddRede.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    String desc = txtDescricao.getText();
                    String ip = txtIp.getText();
                    ChamadoRede cr = new ChamadoRede(id, desc, ip);
                    listaChamados.add(cr);
                    areaDisplay.append("Chamado de Rede #" + id + " criado com sucesso!\n");
                    limparCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique os dados inseridos.");
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaDisplay.append("\n--- LISTA DE CHAMADOS ---\n");
                if (listaChamados.isEmpty()) {
                    areaDisplay.append("Nenhum chamado registrado.\n");
                } else {
                    for (Chamado c : listaChamados) {
                        areaDisplay.append(c.obterDetalhes() + "\n");
                    }
                }
                areaDisplay.append("-------------------------\n");
            }
        });

        btnResolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBusca = JOptionPane.showInputDialog("Digite o ID do chamado a resolver:");
                if (idBusca != null && !idBusca.isEmpty()) {
                    int id = Integer.parseInt(idBusca);
                    boolean encontrado = false;

                    for (Chamado c : listaChamados) {
                        if (c.getId() == id) {
                            // Polimorfismo e Type Casting
                            if (c instanceof ChamadoRede) {
                                String diag = JOptionPane.showInputDialog("Qual o diagnóstico da rede?");
                                areaDisplay.append(((ChamadoRede) c).resolver(diag) + "\n");
                            } else {
                                areaDisplay.append(c.resolver() + "\n");
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "Chamado não encontrado!");
                    }
                }
            }
        });
    }

    // Método auxiliar para limpar os campos após adicionar
    private void limparCampos() {
        txtId.setText("");
        txtDescricao.setText("");
        txtIp.setText("");
    }

    // Ponto de entrada do programa
    public static void main(String[] args) {
        // Inicializa a interface gráfica
        SwingUtilities.invokeLater(() -> {
            SistemaGUI tela = new SistemaGUI();
            tela.setVisible(true);
        });
    }
}