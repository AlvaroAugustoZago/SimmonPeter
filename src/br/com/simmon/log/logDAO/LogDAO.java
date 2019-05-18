package br.com.simmon.log.logDAO;

import br.com.simmon.conexao.BancoCore;
import br.com.simmon.log.Log;
import br.com.simmon.log.logInterface.LogDAOInterface;
import java.sql.Connection;
import java.util.ArrayList;

public class LogDAO
        extends BancoCore
        implements LogDAOInterface
{
    public LogDAO(Connection conexao) { super(conexao, "log"); }



    public void createTable() {
        String comando = "create table log (nomeTabela TEXT,dataInsercao BIGINT,msgLog TEXT,importou CHAR)";




        cria(comando);

        comando = "create table log_url (nomeTabela TEXT,url TEXT)";


        cria(comando);

        comando = "create table log_arquivo (nomeTabela TEXT,descricao TEXT)";


        cria(comando);
    }

    @Override
    public void inserir(ArrayList logs) {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual iterator : ()Ljava/util/Iterator;
        //   4: astore_2
        //   5: aload_2
        //   6: invokeinterface hasNext : ()Z
        //   11: ifeq -> 79
        //   14: aload_2
        //   15: invokeinterface next : ()Ljava/lang/Object;
        //   20: checkcast br/com/simmon/log/Log
        //   23: astore_3
        //   24: aload_3
        //   25: invokevirtual getNomeTabela : ()Ljava/lang/String;
        //   28: aload_3
        //   29: invokevirtual getDate : ()J
        //   32: aload_3
        //   33: invokevirtual getMsgLog : ()Ljava/lang/String;
        //   36: aload_3
        //   37: invokevirtual getImportou : ()Ljava/lang/Boolean;
        //   40: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;JLjava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;
        //   45: astore #4
        //   47: aload_0
        //   48: aload #4
        //   50: invokevirtual inserir : (Ljava/lang/String;)Z
        //   53: pop
        //   54: aload_3
        //   55: invokevirtual getNomeTabela : ()Ljava/lang/String;
        //   58: aload_3
        //   59: invokevirtual getUrl : ()Ljava/lang/String;
        //   62: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   67: astore #4
        //   69: aload_0
        //   70: aload #4
        //   72: invokevirtual inserir : (Ljava/lang/String;)Z
        //   75: pop
        //   76: goto -> 5
        //   79: return
        // Line number table:
        //   Java source line number -> byte code offset
        //   #38	-> 0
        //   #39	-> 24
        //   #40	-> 25
        //   #41	-> 29
        //   #42	-> 33
        //   #43	-> 37
        //   #44	-> 47
        //   #45	-> 54
        //   #46	-> 55
        //   #47	-> 59
        //   #48	-> 69
        //   #49	-> 76
        //   #51	-> 79
        // Local variable table:
        //   start	length	slot	name	descriptor
        //   47	29	4	comando	Ljava/lang/String;
        //   24	52	3	log	Lbr/com/simmon/log/Log;
        //   0	80	0	this	Lbr/com/simmon/log/logDAO/LogDAO;
        //   0	80	1	logs	Ljava/util/ArrayList;
        // Local variable type table:
        //   start	length	slot	name	signature
        //   0	80	1	logs	Ljava/util/ArrayList<Lbr/com/simmon/log/Log;>;
    }
}
