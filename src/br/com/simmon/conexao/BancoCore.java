//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package br.com.simmon.conexao;

import br.com.simmon.log.Log;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BancoCore {
    private Connection conexao;
    private ArrayList<String> params = new ArrayList();
    private ArrayList<Log> logs = new ArrayList();
    private String nomeTabela;

    public BancoCore(Connection conexao, String nomeTabela) {
        this.conexao = conexao;
        this.nomeTabela = nomeTabela;
    }

    public void addParams(Integer position, String param) {
        this.params.add(position, param);
    }

    public boolean inserir(String comando) {
        return this.inserir(comando, (HashMap)null);
    }

    public boolean inserir(String comando, HashMap<String, String> arquivo) {
        String[] campos = comando.split(this.nomeTabela)[1].split("values")[0].split(",");

        try {
            PreparedStatement p = this.conexao.prepareStatement(comando);
            if (this.params.size() > 0) {
                for(int i = 0; i < campos.length; ++i) {
                    p.setString(i + 1, (String)this.params.get(i));
                }
            }

            p.execute();
        } catch (SQLException var6) {
            this.getLogs().add(new Log(this.nomeTabela, (new Date()).getTime(), var6.getMessage(), false, "", (new Gson()).toJson(arquivo)));
            return false;
        }

        this.getLogs().add(new Log(this.nomeTabela, (new Date()).getTime(), "Adicionados com sucesso", true, "", (new Gson()).toJson(arquivo)));
        return true;
    }

    public void cria(String comando) {
        try {
            PreparedStatement p = this.conexao.prepareStatement(comando);
            p.execute();
        } catch (SQLException var4) {
        }

    }

    public void drop(String comando) {
        try {
            PreparedStatement p = this.conexao.prepareStatement(comando);
            p.execute();
        } catch (SQLException var4) {
        }

    }

    public List<String> selectList(String comando) {
        ArrayList listTables = new ArrayList();

        try {
            Statement stmt = this.conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);

            while(rs.next()) {
                listTables.add(rs.getString(rs.getRow()));
            }
        } catch (Exception var5) {
        }

        return listTables;
    }

    public List<HashMap<String, String>> selectMap(String comando) {
        ArrayList listTables = new ArrayList();

        try {
            Statement stmt = this.conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);

            while(rs.next()) {
                HashMap<String, String> a = new HashMap();
                a.put(rs.getString("nomeTabela"), rs.getString("url"));
                listTables.add(a);
            }
        } catch (Exception var6) {
        }

        return listTables;
    }

    public Connection getConexao() {
        return this.conexao;
    }

    public ArrayList<Log> getLogs() {
        return this.logs;
    }
}
