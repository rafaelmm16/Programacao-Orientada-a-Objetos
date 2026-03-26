import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SistemaGUI extends JFrame {

    private ArrayList<Chamado> listaChamados = new ArrayList<>();
    private JTextField txtDescricao, txtIp;
    private JTextArea areaDisplay;

    public SistemaGUI() {
        setTitle("Sistema de Help Desk (POO)");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // --- PAINEL SUPERIOR (Formulário sem o ID) ---
        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Dados do Novo Chamado"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10) 
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 1: Descrição
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        painelFormulario.add(new JLabel("Descrição do Problema:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0;
        txtDescricao = new JTextField(20);
        painelFormulario.add(txtDescricao, gbc);

        // Linha 2: IP Afetado
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        painelFormulario.add(new JLabel("IP Afetado (Apenas Rede):"), gbc);

        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1.0;
        txtIp = new JTextField(15);
        painelFormulario.add(txtIp, gbc);

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

        // --- PAINEL INFERIOR (Console) ---
        areaDisplay = new JTextArea(10, 50);
        areaDisplay.setEditable(false); 
        JScrollPane scrollPane = new JScrollPane(areaDisplay);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Console do Sistema"));
        add(scrollPane, BorderLayout.SOUTH);

        // --- AÇÕES DOS BOTÕES ---
        btnAddGeral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String desc = txtDescricao.getText();
                if(!desc.trim().isEmpty()){
                    Chamado c = new Chamado(desc); // ID gerado automaticamente!
                    listaChamados.add(c);
                    areaDisplay.append("✅ Chamado Geral #" + c.getId() + " criado com sucesso!\n");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "A descrição não pode estar vazia.");
                }
            }
        });

        btnAddRede.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String desc = txtDescricao.getText();
                String ip = txtIp.getText();
                if(!desc.trim().isEmpty() && !ip.trim().isEmpty()){
                    ChamadoRede cr = new ChamadoRede(desc, ip); // ID gerado automaticamente!
                    listaChamados.add(cr);
                    areaDisplay.append("✅ Chamado de Rede #" + cr.getId() + " criado com sucesso!\n");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha a descrição e o IP.");
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
                        areaDisplay.append(c.obterDetalhes() + "\n\n");
                    }
                }
            }
        });

        btnResolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBusca = JOptionPane.showInputDialog("Digite o ID do chamado a resolver:");
                if (idBusca != null && !idBusca.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idBusca);
                        boolean encontrado = false;

                        for (Chamado c : listaChamados) {
                            if (c.getId() == id) {
                                if (c instanceof ChamadoRede) {
                                    String diag = JOptionPane.showInputDialog("Qual o diagnóstico da rede?");
                                    areaDisplay.append("🛠️ " + ((ChamadoRede) c).resolver(diag) + "\n");
                                } else {
                                    areaDisplay.append("🛠️ " + c.resolver() + "\n");
                                }
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, "Chamado não encontrado!");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, digite um número válido para o ID.");
                    }
                }
            }
        });
    }

    private void limparCampos() {
        txtDescricao.setText("");
        txtIp.setText("");
        txtDescricao.requestFocus(); // Volta o cursor para a descrição
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaGUI tela = new SistemaGUI();
            tela.setVisible(true);
        });
    }
}