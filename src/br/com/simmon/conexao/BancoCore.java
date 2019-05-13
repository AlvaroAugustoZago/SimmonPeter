package br.com.simmon.conexao;

import br.com.simmon.log.Log;
import com.google.gson.Gson;

import java.sql.*;
import java.util.*;

public class BancoCore {

    public BancoCore(Connection conexao, String nomeTabela) {
        params = new ArrayList();
        logs = new ArrayList();
        this.conexao = conexao;
        this.nomeTabela = nomeTabela;
    }

    public void addParams(Integer position, String param) {
        params.add(position.intValue(), param);
    }

    public boolean inserir(String comando) {
        return inserir(comando, null);
    }

    public boolean inserir(String comando, HashMap arquivo) {
        String campos[] = comando.split(nomeTabela)[1].split("values")[0].split(",");
        try {
            PreparedStatement p = conexao.prepareStatement(comando);
            if (params.size() > 0) {
                for (int i = 0; i < campos.length; i++)
                    p.setString(i + 1, (String) params.get(i));

            }
            p.execute();
        } catch (SQLException e) {
            getLogs().add(new Log(nomeTabela, (new Date()).getTime(), e.getMessage(), Boolean.valueOf(false), "", (new Gson()).toJson(arquivo)));
            return false;
        }
        getLogs().add(new Log(nomeTabela, (new Date()).getTime(), "Adicionados com sucesso", Boolean.valueOf(true), "", (new Gson()).toJson(arquivo)));
        return true;
    }

    public void cria(String comando) {
        try {
            PreparedStatement p = conexao.prepareStatement(comando);
            p.execute();
        } catch (SQLException sqlexception) {
        }
    }

    public void drop(String comando) {
        try {
            PreparedStatement p = conexao.prepareStatement(comando);
            p.execute();
        } catch (SQLException sqlexception) {
        }
    }

    public List selectList(String comando) {
        List listTables = new ArrayList();
        try {
            Statement stmt = conexao.createStatement();
            for (ResultSet rs = stmt.executeQuery(comando); rs.next(); listTables.add(rs.getString(rs.getRow()))) ;
        } catch (Exception exception) {
        }
        return listTables;
    }

    public List selectMap(String comando) {
        List listTables = new ArrayList();
        try {
            Statement stmt = conexao.createStatement();
            HashMap a;
            for (ResultSet rs = stmt.executeQuery(comando); rs.next(); listTables.add(a)) {
                a = new HashMap();
                a.put(rs.getString("nomeTabela"), rs.getString("url"));
            }

        } catch (Exception exception) {
        }
        return listTables;
    }

    public Connection getConexao() {
        return conexao;
    }

    public ArrayList getLogs() {
        return logs;
    }

    private Connection conexao;
    private ArrayList params;
    private ArrayList logs;
    private String nomeTabela;
}
