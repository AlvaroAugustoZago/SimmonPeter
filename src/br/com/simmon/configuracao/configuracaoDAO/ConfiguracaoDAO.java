package br.com.simmon.configuracao.configuracaoDAO;

import br.com.simmon.conexao.BancoCore;
import br.com.simmon.configuracao.configuracaoDAOInterface.ConfiguracaoDAOInterface;

import java.sql.Connection;
import java.util.List;

public class ConfiguracaoDAO extends BancoCore
        implements ConfiguracaoDAOInterface {

    public ConfiguracaoDAO(Connection conexao) {
        super(conexao, null);
    }

    public List verificaTables() {
        String comando = "show tables;";
        return selectList(comando);
    }

    public void createDatabase() {
        String comando = "create database healer";
        cria(comando);
    }
}
