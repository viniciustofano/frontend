// Importando pacotes necessários para criar uma interface gráfica
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Declaração da classe TelaDeAtualizacao que estende JFrame
public class TelaDeAtualizacao extends JFrame {
    // Declaração de variáveis estáticas para armazenar componentes da interface
    public static JLabel lblId; // Label para exibir o texto "Id:"
    public static JComboBox<String> cbxId; // Combo box para selecionar o ID
    public static String[] ids; // Array de strings para armazenar os IDs

    public static JLabel lblNome; // Label para exibir o texto "Nome:"
    public static JTextField txtNome; // Campo de texto para digitar o nome
    public static String nomeAtual; // Variável para armazenar o nome atual

    public static JLabel lblEmail; // Label para exibir o texto "Email:"
    public static JTextField txtEmail; // Campo de texto para digitar o email
    public static String emailAtual; // Variável para armazenar o email atual

    public static JLabel lblSenha; // Label para exibir o texto "Senha:"
    public static JPasswordField txtSenha; // Campo de senha para digitar a senha
    public static String senhaAtual; // Variável para armazenar a senha atual

    public static JLabel lblNotificacoes; // Label para exibir notificações

    public static JButton btnAtualizar; // Botão para atualizar os dados
    public static JButton btnCancelar; // Botão para cancelar a operação

    // Construtor da classe TelaDeAtualizacao
    public TelaDeAtualizacao() {
        // Chamada ao construtor da classe pai JFrame com o título "Tela de Atualização"
        super("Tela de Atualização");
        // Definição do layout da janela como um grid layout com 6 linhas e 1 coluna
        setLayout(new GridLayout(6,1,5,5));

        // Criação de um painel para a linha do ID
        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        // Criação da label para exibir o texto "Id:"
        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        // Adição da label ao painel
        linha_id.add(lblId);

        // Chamada ao método para popular o combo box com os IDs
        NavegadorDeRegistro.popularIds();
        // Criação do combo box para selecionar o ID
        cbxId = new JComboBox(ids);
        // Adição do combo box ao painel
        linha_id.add(cbxId);
        // Adição do painel à janela
        add(linha_id);

        // Criação de um painel para a linha do nome
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        // Criação da label para exibir o texto "Nome:"
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        // Adição da label ao painel
        linha_nome.add(lblNome);
        // Criação do campo de texto para digitar o nome
        txtNome = new JTextField(20);
        // Adição do campo de texto ao painel
        linha_nome.add(txtNome);
        // Adição do painel à janela
        add(linha_nome);

        // Criação de um painel para a linha do email
        JPanel linha_email = new JPanel(new GridLayout(1, 2));
        // Criação da label para exibir o texto "Email:"
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        // Adição da label ao painel
        linha_email.add(lblEmail);
        // Criação do campo de texto para digitar o email
        txtEmail = new JTextField(20);
        // Adição do campo de texto ao painel
        linha_email.add(txtEmail);
        // Adição do painel à janela
        add(linha_email);

        // Criação de um painel para a linha da senha
        JPanel linha_senha = new JPanel(new GridLayout(1, 2));
        // Criação da label para exibir o texto "Senha:"
        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        // Adição da label ao painel
        linha_senha.add(lblSenha);
        // Criação do campo de senha para digitar a senha
        txtSenha = new JPasswordField(20);
        // Adição do campo de senha ao painel
        linha_senha.add(txtSenha);
        // Adição do painel à janela
        add(linha_senha);

            // Criação de um painel para as notificações
    JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));
    // Criação da label para exibir as notificações
    lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
    // Adição da label ao painel
    linha_notificacoes.add(lblNotificacoes);
    // Adição do painel à janela
    add(linha_notificacoes);

    // Adição de um listener para o botão de atualizar
    btnAtualizar.addActionListener(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Chamada ao método para atualizar o ID
                NavegadorDeRegistro.atualizarId();
            }
        }
    );

    // Adição de um listener para o botão de cancelar
    btnCancelar.addActionListener(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Chamada ao método para limpar os campos
                NavegadorDeRegistro.limparCampos();
            }
        }
    );

    // Adição de um listener para o combo box de IDs
    cbxId.addItemListener(
        new ItemListener() {
        @Override
            public void itemStateChanged(ItemEvent event) {
                // Verificação se o item foi selecionado
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    // Chamada ao método para atualizar os campos
                    NavegadorDeRegistro.atualizarCampos(cbxId.getSelectedItem().toString());
                }
            } 
        }
    );

    // Definição do tamanho da janela
    setSize(250, 300);
    // Criação de um ícone para a janela
    ImageIcon img = new ImageIcon("./senac-logo.png");
    // Definição do ícone para a janela
    setIconImage(img.getImage());
    // Exibição da janela
    setVisible(true);
    // Foco no combo box de IDs
    cbxId.requestFocus();
}

// Método para formatar uma string como HTML
public static String setHtmlFormat(String strTexto) {
    // Retorno da string formatada como HTML
    return "<html><body>" + strTexto + "</body></html>";
}

// Método principal
public static void main(String[] args) {
    // Criação de uma instância da classe TelaDeAtualizacao
    TelaDeAtualizacao appTelaDeAtualizacao = new TelaDeAtualizacao();
    // Definição da operação para fechar a janela
    appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
