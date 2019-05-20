//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package br.com.simmon.arquivo.arquivoDAO;

import br.com.simmon.arquivo.CoreArquivo;
import br.com.simmon.arquivo.arquivoInterface.ArquivoDAOInterface;
import br.com.simmon.conexao.BancoCore;
import br.com.simmon.configuracao.configuracaoDAO.ConfiguracaoDAO;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArquivoDAO extends BancoCore implements ArquivoDAOInterface {
  private String nomeTabela = null;
  private List<HashMap<String, String>> campos = null;
  private CoreArquivo coreArquivo = null;

  public ArquivoDAO(Connection conexao, String arquivoCSV, List<HashMap<String, String>> arquivo, File file) {
    super(conexao, arquivoCSV.replace("arquivos/", "").replace(".csv", ""));
    this.nomeTabela = arquivoCSV.replace("arquivos/", "").replace(".csv", "");
    this.campos = arquivo;
    this.coreArquivo = new CoreArquivo(arquivo, file);
    this.campos = this.coreArquivo.arrumaCampos();
    this.verificaTable();
  }

  public void verificaTable() {
    List<String> listTables = (new ConfiguracaoDAO(this.getConexao())).verificaTables();
    if (!listTables.contains(this.nomeTabela)) {
      this.createTable();
    }

  }

  public void createTable() {
    String comando = "create table " + this.nomeTabela + "(";
    Set<String> keys = ((HashMap)this.campos.get(0)).keySet();

    for(int i = 0; i < keys.toArray().length; ++i) {
      if (i == keys.toArray().length - 1) {
        comando = comando + keys.toArray()[i] + " TEXT";
      } else {
        comando = comando + keys.toArray()[i] + " TEXT, ";
      }
    }

    comando = comando + ")";
    this.cria(comando);
  }

  public void dropTable() {
    String comando = "drop table " + this.nomeTabela;
    this.drop(comando);
  }

  public void inserir() {
    Iterator var1 = this.campos.iterator();

    while(var1.hasNext()) {
      HashMap<String, String> arkv = (HashMap)var1.next();
      PrintStream var10000 = System.out;
      int var10001 = this.campos.indexOf(arkv);
      var10000.println("inserindo " + var10001 + "/" + this.campos.size() + "da tabela:" + this.nomeTabela);
      if (!this.inserir(arkv)) {
        this.coreArquivo.moveError();
        this.dropTable();
        break;
      }
    }

    this.coreArquivo.moveSuccess();
  }

  public boolean inserir(HashMap<String, String> arquivo) {
    String comando = "insert into " + this.nomeTabela + " ( ";
    String k = "";

    for(int i = 0; i < arquivo.keySet().toArray().length; ++i) {
      if (i == arquivo.keySet().toArray().length - 1) {
        k = k + arquivo.keySet().toArray()[i];
      } else {
        k = k + arquivo.keySet().toArray()[i] + ",";
      }
    }

    comando = comando + k + " ) values (";
    String par = "";

    int i;
    for(i = 0; i < arquivo.keySet().toArray().length; ++i) {
      if (i == arquivo.keySet().toArray().length - 1) {
        par = par + "?";
      } else {
        par = par + "?, ";
      }
    }

    comando = comando + par + ")";

    for(i = 0; i < arquivo.keySet().toArray().length; ++i) {
      this.addParams(i, arquivo.values().toArray()[i].toString().replaceAll("\"", ""));
    }

    return this.inserir(comando, arquivo);
  }

  public boolean deletar() {
    return false;
  }
}
