package br.com.simmon.conexao;

import java.sql.Connection;




public class Conexao
{
  private Connection conexao;
  private String USER = "datasaude";
  private String SENHA = "sau09*123data";
  private String SERVER = "localhost";
  private String DATABASE_NAME = "datasaude";
  private String PORTA = "3306";











  
  public Connection abrirConexao() {
    // Byte code:
    //   0: ldc 'com.mysql.cj.jdbc.Driver'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: pop
    //   6: aload_0
    //   7: aload_0
    //   8: getfield SERVER : Ljava/lang/String;
    //   11: aload_0
    //   12: getfield PORTA : Ljava/lang/String;
    //   15: aload_0
    //   16: getfield DATABASE_NAME : Ljava/lang/String;
    //   19: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: aload_0
    //   25: getfield USER : Ljava/lang/String;
    //   28: aload_0
    //   29: getfield SENHA : Ljava/lang/String;
    //   32: invokestatic getConnection : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/sql/Connection;
    //   35: putfield conexao : Ljava/sql/Connection;
    //   38: aload_0
    //   39: getfield conexao : Ljava/sql/Connection;
    //   42: ifnull -> 56
    //   45: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   48: ldc 'Conexao criada'
    //   50: invokevirtual println : (Ljava/lang/String;)V
    //   53: goto -> 64
    //   56: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   59: ldc 'Sem Conexao'
    //   61: invokevirtual println : (Ljava/lang/String;)V
    //   64: goto -> 134
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual getMessage : ()Ljava/lang/String;
    //   72: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   75: ldc 'unknown database'
    //   77: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   80: ifeq -> 134
    //   83: aload_0
    //   84: aload_0
    //   85: getfield SERVER : Ljava/lang/String;
    //   88: aload_0
    //   89: getfield PORTA : Ljava/lang/String;
    //   92: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: aload_0
    //   98: getfield USER : Ljava/lang/String;
    //   101: aload_0
    //   102: getfield SENHA : Ljava/lang/String;
    //   105: invokestatic getConnection : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/sql/Connection;
    //   108: putfield conexao : Ljava/sql/Connection;
    //   111: new br/com/simmon/configuracao/configuracaoDAO/ConfiguracaoDAO
    //   114: dup
    //   115: aload_0
    //   116: getfield conexao : Ljava/sql/Connection;
    //   119: invokespecial <init> : (Ljava/sql/Connection;)V
    //   122: invokevirtual createDatabase : ()V
    //   125: aload_0
    //   126: invokevirtual abrirConexao : ()Ljava/sql/Connection;
    //   129: pop
    //   130: goto -> 134
    //   133: astore_2
    //   134: aload_0
    //   135: getfield conexao : Ljava/sql/Connection;
    //   138: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #20	-> 0
    //   #22	-> 6
    //   #23	-> 38
    //   #24	-> 45
    //   #26	-> 56
    //   #37	-> 64
    //   #28	-> 67
    //   #29	-> 68
    //   #31	-> 83
    //   #32	-> 111
    //   #33	-> 125
    //   #35	-> 130
    //   #34	-> 133
    //   #38	-> 134
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   68	66	1	e	Ljava/lang/Exception;
    //   0	139	0	this	Lbr/com/simmon/conexao/Conexao;
    // Exception table:
    //   from	to	target	type
    //   0	64	67	java/lang/Exception
    //   83	130	133	java/sql/SQLException
  }










  
  public void fecharConexao() {
    try {
      this.conexao.close();
    } catch (Exception exception) {}
  }
}
