package br.com.simmon.arquivo.arquivoDAO;

import br.com.simmon.arquivo.CoreArquivo;
import br.com.simmon.arquivo.arquivoInterface.ArquivoDAOInterface;
import br.com.simmon.conexao.BancoCore;
import br.com.simmon.configuracao.configuracaoDAO.ConfiguracaoDAO;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class ArquivoDAO
  extends BancoCore
  implements ArquivoDAOInterface
{
  private String nomeTabela = null;
  private List<HashMap<String, String>> campos = null;
  private CoreArquivo coreArquivo = null;
  
  public ArquivoDAO(Connection conexao, String arquivoCSV, List<HashMap<String, String>> arquivo, File file) {
    super(conexao, arquivoCSV.replace("arquivos/", "").replace(".csv", ""));
    this.nomeTabela = arquivoCSV.replace("arquivos/", "").replace(".csv", "");
    this.campos = arquivo;
    this.coreArquivo = new CoreArquivo(arquivo, file);
    this.campos = this.coreArquivo.arrumaCampos();
    verificaTable();
  }
  
  public void verificaTable() {
    List<String> listTables = (new ConfiguracaoDAO(getConexao())).verificaTables();
    if (!listTables.contains(this.nomeTabela)) {
      createTable();
    }
  }










  
  public void createTable() {
    // Byte code:
    //   0: aload_0
    //   1: getfield nomeTabela : Ljava/lang/String;
    //   4: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield campos : Ljava/util/List;
    //   14: iconst_0
    //   15: invokeinterface get : (I)Ljava/lang/Object;
    //   20: checkcast java/util/HashMap
    //   23: invokevirtual keySet : ()Ljava/util/Set;
    //   26: astore_2
    //   27: iconst_0
    //   28: istore_3
    //   29: iload_3
    //   30: aload_2
    //   31: invokeinterface toArray : ()[Ljava/lang/Object;
    //   36: arraylength
    //   37: if_icmpge -> 92
    //   40: iload_3
    //   41: aload_2
    //   42: invokeinterface toArray : ()[Ljava/lang/Object;
    //   47: arraylength
    //   48: iconst_1
    //   49: isub
    //   50: if_icmpne -> 71
    //   53: aload_1
    //   54: aload_2
    //   55: invokeinterface toArray : ()[Ljava/lang/Object;
    //   60: iload_3
    //   61: aaload
    //   62: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   67: astore_1
    //   68: goto -> 86
    //   71: aload_1
    //   72: aload_2
    //   73: invokeinterface toArray : ()[Ljava/lang/Object;
    //   78: iload_3
    //   79: aaload
    //   80: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   85: astore_1
    //   86: iinc #3, 1
    //   89: goto -> 29
    //   92: aload_1
    //   93: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_1
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual cria : (Ljava/lang/String;)V
    //   104: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #38	-> 0
    //   #39	-> 10
    //   #40	-> 27
    //   #41	-> 40
    //   #42	-> 53
    //   #44	-> 71
    //   #40	-> 86
    //   #48	-> 92
    //   #49	-> 99
    //   #50	-> 104
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   29	63	3	i	I
    //   0	105	0	this	Lbr/com/simmon/arquivo/arquivoDAO/ArquivoDAO;
    //   10	95	1	comando	Ljava/lang/String;
    //   27	78	2	keys	Ljava/util/Set;
    // Local variable type table:
    //   start	length	slot	name	signature
    //   27	78	2	keys	Ljava/util/Set<Ljava/lang/String;>;
  }










  
  public void dropTable() {
    // Byte code:
    //   0: aload_0
    //   1: getfield nomeTabela : Ljava/lang/String;
    //   4: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual drop : (Ljava/lang/String;)V
    //   15: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #54	-> 0
    //   #55	-> 10
    //   #56	-> 15
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	16	0	this	Lbr/com/simmon/arquivo/arquivoDAO/ArquivoDAO;
    //   10	6	1	comando	Ljava/lang/String;
  }










  
  public void inserir() {
    // Byte code:
    //   0: aload_0
    //   1: getfield campos : Ljava/util/List;
    //   4: invokeinterface iterator : ()Ljava/util/Iterator;
    //   9: astore_1
    //   10: aload_1
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 88
    //   19: aload_1
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast java/util/HashMap
    //   28: astore_2
    //   29: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   32: aload_0
    //   33: getfield campos : Ljava/util/List;
    //   36: aload_2
    //   37: invokeinterface indexOf : (Ljava/lang/Object;)I
    //   42: aload_0
    //   43: getfield campos : Ljava/util/List;
    //   46: invokeinterface size : ()I
    //   51: aload_0
    //   52: getfield nomeTabela : Ljava/lang/String;
    //   55: <illegal opcode> makeConcatWithConstants : (IILjava/lang/String;)Ljava/lang/String;
    //   60: invokevirtual println : (Ljava/lang/String;)V
    //   63: aload_0
    //   64: aload_2
    //   65: invokevirtual inserir : (Ljava/util/HashMap;)Z
    //   68: ifne -> 85
    //   71: aload_0
    //   72: getfield coreArquivo : Lbr/com/simmon/arquivo/CoreArquivo;
    //   75: invokevirtual moveError : ()V
    //   78: aload_0
    //   79: invokevirtual dropTable : ()V
    //   82: goto -> 88
    //   85: goto -> 10
    //   88: aload_0
    //   89: getfield coreArquivo : Lbr/com/simmon/arquivo/CoreArquivo;
    //   92: invokevirtual moveSuccess : ()V
    //   95: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #59	-> 0
    //   #60	-> 29
    //   #61	-> 63
    //   #62	-> 71
    //   #63	-> 78
    //   #64	-> 82
    //   #66	-> 85
    //   #67	-> 88
    //   #68	-> 95
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   29	56	2	arkv	Ljava/util/HashMap;
    //   0	96	0	this	Lbr/com/simmon/arquivo/arquivoDAO/ArquivoDAO;
    // Local variable type table:
    //   start	length	slot	name	signature
    //   29	56	2	arkv	Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;
  }










  
  public boolean inserir(HashMap<String, String> arquivo) {
    // Byte code:
    //   0: aload_0
    //   1: getfield nomeTabela : Ljava/lang/String;
    //   4: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_2
    //   10: ldc ''
    //   12: astore_3
    //   13: iconst_0
    //   14: istore #4
    //   16: iload #4
    //   18: aload_1
    //   19: invokevirtual keySet : ()Ljava/util/Set;
    //   22: invokeinterface toArray : ()[Ljava/lang/Object;
    //   27: arraylength
    //   28: if_icmpge -> 95
    //   31: iload #4
    //   33: aload_1
    //   34: invokevirtual keySet : ()Ljava/util/Set;
    //   37: invokeinterface toArray : ()[Ljava/lang/Object;
    //   42: arraylength
    //   43: iconst_1
    //   44: isub
    //   45: if_icmpne -> 70
    //   48: aload_3
    //   49: aload_1
    //   50: invokevirtual keySet : ()Ljava/util/Set;
    //   53: invokeinterface toArray : ()[Ljava/lang/Object;
    //   58: iload #4
    //   60: aaload
    //   61: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   66: astore_3
    //   67: goto -> 89
    //   70: aload_3
    //   71: aload_1
    //   72: invokevirtual keySet : ()Ljava/util/Set;
    //   75: invokeinterface toArray : ()[Ljava/lang/Object;
    //   80: iload #4
    //   82: aaload
    //   83: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   88: astore_3
    //   89: iinc #4, 1
    //   92: goto -> 16
    //   95: aload_2
    //   96: aload_3
    //   97: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore_2
    //   103: ldc ''
    //   105: astore #4
    //   107: iconst_0
    //   108: istore #5
    //   110: iload #5
    //   112: aload_1
    //   113: invokevirtual keySet : ()Ljava/util/Set;
    //   116: invokeinterface toArray : ()[Ljava/lang/Object;
    //   121: arraylength
    //   122: if_icmpge -> 169
    //   125: iload #5
    //   127: aload_1
    //   128: invokevirtual keySet : ()Ljava/util/Set;
    //   131: invokeinterface toArray : ()[Ljava/lang/Object;
    //   136: arraylength
    //   137: iconst_1
    //   138: isub
    //   139: if_icmpne -> 154
    //   142: aload #4
    //   144: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   149: astore #4
    //   151: goto -> 163
    //   154: aload #4
    //   156: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   161: astore #4
    //   163: iinc #5, 1
    //   166: goto -> 110
    //   169: aload_2
    //   170: aload #4
    //   172: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: iconst_0
    //   179: istore #5
    //   181: iload #5
    //   183: aload_1
    //   184: invokevirtual keySet : ()Ljava/util/Set;
    //   187: invokeinterface toArray : ()[Ljava/lang/Object;
    //   192: arraylength
    //   193: if_icmpge -> 233
    //   196: aload_0
    //   197: iload #5
    //   199: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   202: aload_1
    //   203: invokevirtual values : ()Ljava/util/Collection;
    //   206: invokeinterface toArray : ()[Ljava/lang/Object;
    //   211: iload #5
    //   213: aaload
    //   214: invokevirtual toString : ()Ljava/lang/String;
    //   217: ldc '"'
    //   219: ldc ''
    //   221: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual addParams : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   227: iinc #5, 1
    //   230: goto -> 181
    //   233: aload_0
    //   234: aload_2
    //   235: aload_1
    //   236: invokevirtual inserir : (Ljava/lang/String;Ljava/util/HashMap;)Z
    //   239: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #73	-> 0
    //   #74	-> 10
    //   #75	-> 13
    //   #76	-> 31
    //   #77	-> 48
    //   #79	-> 70
    //   #75	-> 89
    //   #82	-> 95
    //   #83	-> 103
    //   #84	-> 107
    //   #85	-> 125
    //   #86	-> 142
    //   #88	-> 154
    //   #84	-> 163
    //   #92	-> 169
    //   #93	-> 178
    //   #94	-> 196
    //   #93	-> 227
    //   #96	-> 233
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   16	79	4	i	I
    //   110	59	5	i	I
    //   181	52	5	i	I
    //   0	240	0	this	Lbr/com/simmon/arquivo/arquivoDAO/ArquivoDAO;
    //   0	240	1	arquivo	Ljava/util/HashMap;
    //   10	230	2	comando	Ljava/lang/String;
    //   13	227	3	k	Ljava/lang/String;
    //   107	133	4	par	Ljava/lang/String;
    // Local variable type table:
    //   start	length	slot	name	signature
    //   0	240	1	arquivo	Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;
  }









  
  public boolean deletar() { return false; }
}
