package br.com.simmon.conexao;

import br.com.simmon.configuracao.configuracaoDAO.ConfiguracaoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao
{
  private Connection conexao;
  private String USER = "datasaude";
  private String SENHA = "sau09*123data";
  private String SERVER = "localhost";
  private String DATABASE_NAME = "datasaude";
  private String PORTA = "3306";

  public Conexao() {
  }

  public Connection abrirConexao() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.SERVER + ":" + this.PORTA + "/" + this.DATABASE_NAME, this.USER, this.SENHA);
      if (this.conexao != null) {
        System.out.println("Conexao criada");
      } else {
        System.out.println("Sem Conexao");
      }
    } catch (Exception var4) {
      if (var4.getMessage().toLowerCase().contains("unknown database")) {
        try {
          this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.SERVER + ":" + this.PORTA + "/", this.USER, this.SENHA);
          (new ConfiguracaoDAO(this.conexao)).createDatabase();
          this.abrirConexao();
        } catch (SQLException var3) {
        }
      }
    }

    return this.conexao;
  }

  public void fecharConexao() {
    try {
      this.conexao.close();
    } catch (Exception var2) {
    }

  }
}
