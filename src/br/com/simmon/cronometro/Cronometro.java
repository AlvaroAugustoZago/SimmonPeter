package br.com.simmon.cronometro;

//import br.com.quatro2.Peter.Arquivo;
import br.com.simmon.conexao.BancoCore;
import br.com.simmon.conexao.Conexao;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class Cronometro
{
    final long timeArquivo = calculaTime(15, false);
    final long timeUrl = calculaTime(24, true);
    private Timer timerArquivo = new Timer();
    private Timer timerUrl = new Timer();
    private TimerTask tarefaArquivo = new TimerTask()
    {
        public void run() { (new Thread()
        {
            public void run()
            {
                // Byte code:
                //   0: new java/io/File
                //   3: dup
                //   4: ldc 'arquivos'
                //   6: invokespecial <init> : (Ljava/lang/String;)V
                //   9: invokestatic filter : (Ljava/io/File;)[Ljava/io/File;
                //   12: astore_1
                //   13: aload_1
                //   14: arraylength
                //   15: istore_2
                //   16: iconst_0
                //   17: istore_3
                //   18: iload_3
                //   19: iload_2
                //   20: if_icmpge -> 320
                //   23: aload_1
                //   24: iload_3
                //   25: aaload
                //   26: astore #4
                //   28: aconst_null
                //   29: astore #5
                //   31: new java/io/BufferedReader
                //   34: dup
                //   35: new java/io/FileReader
                //   38: dup
                //   39: aload #4
                //   41: invokevirtual getPath : ()Ljava/lang/String;
                //   44: invokespecial <init> : (Ljava/lang/String;)V
                //   47: invokespecial <init> : (Ljava/io/Reader;)V
                //   50: astore #5
                //   52: getstatic java/lang/System.out : Ljava/io/PrintStream;
                //   55: aload #4
                //   57: invokevirtual getPath : ()Ljava/lang/String;
                //   60: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
                //   65: invokevirtual println : (Ljava/lang/String;)V
                //   68: aload #5
                //   70: invokevirtual readLine : ()Ljava/lang/String;
                //   73: new br/com/simmon/arquivo/CoreArquivo
                //   76: dup
                //   77: invokespecial <init> : ()V
                //   80: getfield csvDivisor : Ljava/lang/String;
                //   83: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
                //   86: astore #6
                //   88: new br/com/simmon/arquivo/CoreArquivo
                //   91: dup
                //   92: invokespecial <init> : ()V
                //   95: aload #5
                //   97: aload #6
                //   99: aload #4
                //   101: invokevirtual getPath : ()Ljava/lang/String;
                //   104: invokevirtual montaObj : (Ljava/io/BufferedReader;[Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
                //   107: astore #7
                //   109: new br/com/simmon/arquivo/CoreArquivo
                //   112: dup
                //   113: aload #7
                //   115: aload #4
                //   117: invokespecial <init> : (Ljava/util/List;Ljava/io/File;)V
                //   120: astore #8
                //   122: new br/com/simmon/conexao/Conexao
                //   125: dup
                //   126: invokespecial <init> : ()V
                //   129: astore #9
                //   131: aload #9
                //   133: invokevirtual abrirConexao : ()Ljava/sql/Connection;
                //   136: astore #10
                //   138: new br/com/simmon/arquivo/arquivoDAO/ArquivoDAO
                //   141: dup
                //   142: aload #10
                //   144: aload #4
                //   146: invokevirtual getPath : ()Ljava/lang/String;
                //   149: aload #7
                //   151: aload #8
                //   153: invokevirtual createTemp : ()Ljava/io/File;
                //   156: invokespecial <init> : (Ljava/sql/Connection;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)V
                //   159: astore #11
                //   161: aload #11
                //   163: invokevirtual inserir : ()V
                //   166: aload #11
                //   168: invokevirtual getLogs : ()Ljava/util/ArrayList;
                //   171: astore #12
                //   173: new br/com/simmon/log/logDAO/LogDAO
                //   176: dup
                //   177: aload #10
                //   179: invokespecial <init> : (Ljava/sql/Connection;)V
                //   182: astore #13
                //   184: aload #13
                //   186: aload #12
                //   188: invokevirtual inserir : (Ljava/util/ArrayList;)V
                //   191: aload #9
                //   193: invokevirtual fecharConexao : ()V
                //   196: aload #5
                //   198: ifnull -> 304
                //   201: aload #5
                //   203: invokevirtual close : ()V
                //   206: goto -> 304
                //   209: astore #6
                //   211: aload #6
                //   213: invokevirtual printStackTrace : ()V
                //   216: goto -> 304
                //   219: astore #6
                //   221: aload #6
                //   223: invokevirtual printStackTrace : ()V
                //   226: aload #5
                //   228: ifnull -> 304
                //   231: aload #5
                //   233: invokevirtual close : ()V
                //   236: goto -> 304
                //   239: astore #6
                //   241: aload #6
                //   243: invokevirtual printStackTrace : ()V
                //   246: goto -> 304
                //   249: astore #6
                //   251: aload #6
                //   253: invokevirtual printStackTrace : ()V
                //   256: aload #5
                //   258: ifnull -> 304
                //   261: aload #5
                //   263: invokevirtual close : ()V
                //   266: goto -> 304
                //   269: astore #6
                //   271: aload #6
                //   273: invokevirtual printStackTrace : ()V
                //   276: goto -> 304
                //   279: astore #14
                //   281: aload #5
                //   283: ifnull -> 301
                //   286: aload #5
                //   288: invokevirtual close : ()V
                //   291: goto -> 301
                //   294: astore #15
                //   296: aload #15
                //   298: invokevirtual printStackTrace : ()V
                //   301: aload #14
                //   303: athrow
                //   304: goto -> 314
                //   307: astore #5
                //   309: aload #5
                //   311: invokevirtual printStackTrace : ()V
                //   314: iinc #3, 1
                //   317: goto -> 18
                //   320: return
                // Line number table:
                //   Java source line number -> byte code offset
                //   #25	-> 0
                //   #27	-> 28
                //   #29	-> 31
                //   #30	-> 52
                //   #31	-> 68
                //   #32	-> 88
                //   #33	-> 109
                //   #34	-> 122
                //   #35	-> 131
                //   #36	-> 138
                //   #37	-> 161
                //   #38	-> 166
                //   #39	-> 173
                //   #40	-> 184
                //   #41	-> 191
                //   #47	-> 196
                //   #49	-> 201
                //   #52	-> 206
                //   #50	-> 209
                //   #51	-> 211
                //   #52	-> 216
                //   #42	-> 219
                //   #43	-> 221
                //   #47	-> 226
                //   #49	-> 231
                //   #52	-> 236
                //   #50	-> 239
                //   #51	-> 241
                //   #52	-> 246
                //   #44	-> 249
                //   #45	-> 251
                //   #47	-> 256
                //   #49	-> 261
                //   #52	-> 266
                //   #50	-> 269
                //   #51	-> 271
                //   #52	-> 276
                //   #47	-> 279
                //   #49	-> 286
                //   #52	-> 291
                //   #50	-> 294
                //   #51	-> 296
                //   #54	-> 301
                //   #57	-> 304
                //   #55	-> 307
                //   #56	-> 309
                //   #25	-> 314
                //   #59	-> 320
                // Local variable table:
                //   start	length	slot	name	descriptor
                //   88	108	6	cabecalho	[Ljava/lang/String;
                //   109	87	7	mapList	Ljava/util/List;
                //   122	74	8	coreArquivo	Lbr/com/simmon/arquivo/CoreArquivo;
                //   131	65	9	conec	Lbr/com/simmon/conexao/Conexao;
                //   138	58	10	conexao	Ljava/sql/Connection;
                //   161	35	11	arquivoDAO	Lbr/com/simmon/arquivo/arquivoDAO/ArquivoDAO;
                //   173	23	12	logs	Ljava/util/ArrayList;
                //   184	12	13	logDAO	Lbr/com/simmon/log/logDAO/LogDAO;
                //   211	5	6	e	Ljava/io/IOException;
                //   221	5	6	e	Ljava/io/FileNotFoundException;
                //   241	5	6	e	Ljava/io/IOException;
                //   251	5	6	e	Ljava/lang/Exception;
                //   271	5	6	e	Ljava/io/IOException;
                //   296	5	15	e	Ljava/io/IOException;
                //   31	273	5	br	Ljava/io/BufferedReader;
                //   309	5	5	e	Ljava/lang/Exception;
                //   28	286	4	arquivo	Ljava/io/File;
                //   0	321	0	this	Lbr/com/simmon/cronometro/Cronometro$1$1;
                // Local variable type table:
                //   start	length	slot	name	signature
                //   109	87	7	mapList	Ljava/util/List<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;
                //   173	23	12	logs	Ljava/util/ArrayList<Lbr/com/simmon/log/Log;>;
                // Exception table:
                //   from	to	target	type
                //   28	304	307	java/lang/Exception
                //   31	196	219	java/io/FileNotFoundException
                //   31	196	249	java/lang/Exception
                //   31	196	279	finally
                //   201	206	209	java/io/IOException
                //   219	226	279	finally
                //   231	236	239	java/io/IOException
                //   249	256	279	finally
                //   261	266	269	java/io/IOException
                //   279	281	279	finally
                //   286	291	294	java/io/IOException
            }
        }).start(); }
    };

//    private TimerTask tarefaUrl = new TimerTask()
//    {
//        public void run() { (new Thread()
//        {
//            public void run() {
//                try {
//                    Conexao conec = new Conexao();
//                    Connection conexao = conec.abrirConexao();
//                    BancoCore bancoCore = new BancoCore(conexao, null);
//                    String comando = "SELECT * FROM log_url";
//                    List<HashMap<String, String>> urls = bancoCore.selectMap(comando);
//                    for (HashMap<String, String> url : urls) {
//                        for (String tabela : url.keySet()) {
//                            Arquivo arquivo = new Arquivo((String)url.get(tabela));
//                            arquivo.buscarCSV();
//                            arquivo.realizaDownload();
//                        }
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start(); }
//    };


    public void lancarTarefas() {
        this.timerArquivo.scheduleAtFixedRate(this.tarefaArquivo, this.timeArquivo, this.timeArquivo);
        //this.timerUrl.scheduleAtFixedRate(this.tarefaUrl, this.timeUrl, this.timeUrl);
    }

    private long calculaTime(int tempo, boolean horas) {
        if (horas) {
            return (tempo * 3600000);
        }
        return (tempo * 60000);
    }
}
