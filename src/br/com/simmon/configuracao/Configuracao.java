package br.com.simmon.configuracao;

import br.com.simmon.conexao.Conexao;
import br.com.simmon.configuracao.configuracaoDAO.ConfiguracaoDAO;
import br.com.simmon.log.logDAO.LogDAO;

import java.sql.Connection;
import java.util.List;

public class Configuracao {

    public Configuracao() {
    }

    public void inicializar() {
        Conexao conec = new Conexao();
        Connection conexao = conec.abrirConexao();
        List listTables = (new ConfiguracaoDAO(conexao)).verificaTables();
        if (!listTables.contains("log")) {
            LogDAO logDAO = new LogDAO(conexao);
            logDAO.createTable();
        }
    }
}
