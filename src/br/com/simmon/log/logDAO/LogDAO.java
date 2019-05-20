package br.com.simmon.log.logDAO;

import br.com.simmon.conexao.BancoCore;
import br.com.simmon.log.Log;
import br.com.simmon.log.logInterface.LogDAOInterface;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

public class LogDAO extends BancoCore implements LogDAOInterface {
    public LogDAO(Connection conexao) {
        super(conexao, "log");
    }

    public void createTable() {
        String comando = "create table log (nomeTabela TEXT,dataInsercao BIGINT,msgLog TEXT,importou CHAR)";
        this.cria(comando);
        comando = "create table log_url (nomeTabela TEXT,url TEXT)";
        this.cria(comando);
        comando = "create table log_arquivo (nomeTabela TEXT,descricao TEXT)";
        this.cria(comando);
    }
    @Override
    public void inserir(ArrayList logs) {
        Iterator var2 = logs.iterator();

        while(var2.hasNext()) {
            Log log = (Log)var2.next();
            String var10000 = log.getNomeTabela();
            String comando = "insert into log (nomeTabela,dataInsercao,msgLog,importou) values('" + var10000 + "'," + log.getDate() + ",'" + log.getMsgLog() + "'," + log.getImportou() + ");";
            this.inserir(comando);
            var10000 = log.getNomeTabela();
            comando = "insert into log_url (nomeTabela, url) values('" + var10000 + "'," + log.getUrl() + ");";
            this.inserir(comando);
        }

    }
}
