//Importação das bibliotecas
import java.sql.*;
import java.util.*; 

// Classe NavegadorDeRegistro que estende TelaDeAtualizacao
public class NavegadorDeRegistro extends TelaDeAtualizacao {
    
    // Método para popular IDs a partir do banco de dados
    public static void popularIds() {
        try {
            ArrayList<String> idsTemp = new ArrayList<>(); // Lista temporária para armazenar IDs
            idsTemp.add("Selecione aqui o id"); // Adiciona a opção de seleção
            Connection conexao = MySQLConnector.conectar(); // Estabelece conexão com o banco de dados
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;"; // SQL para selecionar todos os IDs
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // Cria um statement
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds); // Executa a consulta SQL
            while (rstSqlPopularIds.next()) { // Itera sobre os resultados
                idsTemp.add(rstSqlPopularIds.getString("id")); // Adiciona cada ID à lista temporária
            }
            ids = idsTemp.toArray(new String[0]); // Converte a lista para um array
            stmSqlPopularIds.close(); // Fecha o statement
        } catch (Exception e) {
            // Se houver erro, exibe mensagem de erro e imprime no console
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    // Método para atualizar um ID
    public static void atualizarId() {
        try {
            String atualizarNome = ""; // Inicializa string para nome
            String atualizarEmail = ""; // Inicializa string para email
            String atualizarSenha = ""; // Inicializa string para senha

            // Verifica se o nome foi alterado
            if (txtNome.getText().trim().equals(nomeAtual) == false) {
                atualizarNome = "`nome` = '" + txtNome.getText() + "'"; // Se sim, prepara a atualização
            }

            // Verifica se o email foi alterado
            if (txtEmail.getText().trim().equals(emailAtual) == false) {
                if (atualizarNome.length() > 0) {
                    atualizarEmail = " and "; // Adiciona "and" se já há uma atualização de nome
                }
                atualizarEmail += "`email` = '" + txtEmail.getText() + "'"; // Prepara a atualização de email
            }

            // Verifica se a senha foi alterada
            if (String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual) == false) {
                if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                    atualizarSenha = " and "; // Adiciona "and" se já há atualizações de nome ou email
                }
                atualizarSenha += "`senha` = '" + String.valueOf(txtSenha.getPassword()) + "'"; // Prepara a atualização de senha
            }

            // Se houve alterações, executa a atualização no banco de dados
            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
                Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados
                String strSqlAtualizarId = "update `db_senac`.`tbl_senac` set " + atualizarNome + atualizarEmail + atualizarSenha + " where `id` = " + cbxId.getSelectedItem().toString() + ";"; // SQL para atualização
                // System.out.println(strSqlAtualizarId); // Linha comentada para depuração
                Statement stmSqlAtualizarId = conexao.createStatement(); // Cria um statement para a atualização
                stmSqlAtualizarId.addBatch(strSqlAtualizarId); // Adiciona a atualização ao batch
                stmSqlAtualizarId.executeBatch(); // Executa o batch
                // Atualiza as variáveis atuais
                nomeAtual = txtNome.getText();
                emailAtual = txtEmail.getText();
                senhaAtual = String.valueOf(txtSenha.getPassword());
                stmSqlAtualizarId.close(); // Fecha o statement
                lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi atualizado com sucesso!"); // Mensagem de sucesso
            } else {
                lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString()); // Mensagem se não houve alterações
            }
        } catch (Exception e) {
            // Se houver erro, exibe mensagem de erro e imprime no console
            lblNotificacoes.setText(setHtmlFormat("Não foi possível atualizar o id! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    // Método para limpar os campos de entrada
    public static void limparCampos() {
        txtNome.setText(""); // Limpa o campo de nome
        txtEmail.setText(""); // Limpa o campo de email
        txtSenha.setText(""); // Limpa o campo de senha
        cbxId.setSelectedIndex(0); // Reseta a seleção de ID
    }

    // Método para atualizar os campos com os dados do ID selecionado
    public static void atualizarCampos(String id) {
        try {
            // Verifica se um ID válido foi selecionado
            if (cbxId.getSelectedIndex() > 0) {
                Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + id + ";"; // SQL para selecionar dados do ID
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // Cria um statement
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos); // Executa a consulta
                if (rstSqlAtualizarCampos.next()) { // Se houver resultados
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome")); // Atualiza campo de nome
                    nomeAtual = txtNome.getText(); // Atualiza variável de nome atual
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email")); // Atualiza campo de email
                    emailAtual = txtEmail.getText(); // Atualiza variável de email atual
                    txtSenha.setText(rstSqlAtualizarCampos.getString("senha")); // Atualiza campo de senha
                    senhaAtual = String.valueOf(txtSenha.getPassword()); // Atualiza variável de senha atual
                    lblNotificacoes.setText("Campos atualizados com sucesso!"); // Mensagem de sucesso
                } else {
                    lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente."); // Mensagem de erro
                }
                stmSqlAtualizarCampos.close(); // Fecha o statement
            } else {
                lblNotificacoes.setText("Selecione um id para continuar."); // Mensagem se nenhum ID foi selecionado
                limparCampos(); // Limpa os campos
            }
        } catch (Exception e) {
            // Se houver erro, exibe mensagem de erro e imprime no console
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
}
