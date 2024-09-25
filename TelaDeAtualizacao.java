// Importar bibliotecas necessárias para criar a interface gráfica
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Definir a classe TelaDeAtualizacao que herda de JFrame
public class TelaDeAtualizacao extends JFrame {
    // Declaração de variáveis estáticas para os componentes da interface
    public static JLabel lblId; // Label para exibir o ID
    public static JComboBox<String> cbxId; // Combo box para selecionar o ID
    public static String[] ids; // Array de IDs

    public static JLabel lblNome; // Label para exibir o nome
    public static JTextField txtNome; // Campo de texto para digitar o nome

    public static JLabel lblEmail; // Label para exibir o e-mail
    public static JTextField txtEmail; // Campo de texto para digitar o e-mail

    public static JLabel lblSenha; // Label para exibir a senha
    public static JPasswordField txtSenha; // Campo de senha para digitar a senha

    public static JLabel lblNotificacoes; // Label para exibir notificações

    public static JButton btnAtualizar; // Botão para atualizar os dados
    public static JButton btnCancelar; // Botão para cancelar a operação

    // Construtor da classe TelaDeAtualizacao
    public TelaDeAtualizacao() {
        // Definir o título da janela
        super("Tela de Atualização");

        // Definir o layout da janela como GridLayout
        setLayout(new GridLayout(6, 1, 5, 5));

        // Criar um painel para o ID
        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        // Criar uma label para o ID
        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        // Popular o combo box com os IDs
        NavegadorDeRegistro.popularIds();
        cbxId = new JComboBox<>(ids);
        linha_id.add(cbxId);

        // Adicionar o painel ao conteúdo da janela
        add(linha_id);

        // Criar um painel para o nome
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        // Criar uma label para o nome
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);

        // Criar um campo de texto para o nome
        txtNome = new JTextField(20);
        linha_nome.add(txtNome);

        // Adicionar o painel ao conteúdo da janela
        add(linha_nome);

        // Criar um painel para o e-mail
        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        // Criar uma label para o e-mail
        lblEmail = new JLabel("Email", SwingConstants.RIGHT);
        linha_email.add(lblEmail);

        // Criar um campo de texto para o e-mail
        txtEmail = new JTextField(20);
        linha_email.add(txtEmail);

        // Adicionar o painel ao conteúdo da janela
        add(linha_email);

        // Criar um painel para a senha
        JPanel linha_senha = new JPanel(new GridLayout(1, 2));

        // Criar uma label para a senha
        lblSenha = new JLabel("Senha", SwingConstants.RIGHT);
        linha_senha.add(lblSenha);

        // Criar um campo de senha para a senha
        txtSenha = new JPasswordField(20);
        linha_senha.add(txtSenha);

        // Adicionar o painel ao conteúdo da janela
        add(linha_senha);

        // Criar um painel para os botões
        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        // Criar um botão para atualizar os dados
        btnAtualizar = new JButton("Atualizar");
        linha_botoes.add(btnAtualizar);

        // Criar um botão para cancelar a operação
        btnCancelar = new JButton("Cancelar");
        linha_botoes.add(btnCancelar);

        // Adicionar o painel ao conteúdo da janela
        add(linha_botoes);

        // Criar um painel para as notificações
        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        // Criar uma label para as notificações
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        // Adicionar o painel ao conteúdo da janela
        add(linha_notificacoes);

        // Adicionar um listener para o botão Atualizar
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Obter o ID selecionado do combo box
                String selectedId = (String) cbxId.getSelectedItem();

                // Obter o texto dos campos de texto
                String nome = txtNome.getText();
                String email = txtEmail.getText();
                String senha = new String(txtSenha.getPassword());

                // Realizar a operação de atualização
                updateUser(selectedId, nome, email, senha);

                // Mostrar uma notificação
                lblNotificacoes.setText(setHtmlFormat("Usuário atualizado com sucesso!"));
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Limpar os campos de texto
                txtNome.setText("");
                txtEmail.setText("");
                txtSenha.setText("");

                // Resetar o combo box
                cbxId.setSelectedIndex(0);

                // Mostrar uma notificação
                lblNotificacoes.setText(setHtmlFormat("Operação cancelada!"));
            }
        });

        cbxId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    // Obter o ID selecionado do combo box
                    String selectedId = (String) cbxId.getSelectedItem();

                    // Carregar os dados do usuário do banco de dados
                    loadUserData(selectedId);

                    // Mostrar uma notificação
                    lblNotificacoes.setText(setHtmlFormat("Dados do usuário carregados!"));
                }
            }
        });

        setSize(250, 300);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body><html>";
    }

    public static void main(String[] args) {
        TelaDeAtualizacao appTelaDePesquisa = new TelaDeAtualizacao();
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void updateUser(String id, String nome, String email, String senha) {
        // Implementar a lógica de atualização do usuário aqui
    }

    private void loadUserData(String id) {
        // Implementar a lógica de carregamento dos dados do usuário aqui
    }
}    