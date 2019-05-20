package br.com.simmon.cronometro;

//import br.com.quatro2.Peter.Arquivo;

import br.com.simmon.conexao.BancoCore;
import br.com.simmon.conexao.Conexao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import br.com.simmon.arquivo.CoreArquivo;
import br.com.simmon.arquivo.arquivoDAO.ArquivoDAO;
import br.com.simmon.log.Log;
import br.com.simmon.log.logDAO.LogDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Cronometro {
    final long timeArquivo = calculaTime(15, false);
    final long timeUrl = calculaTime(24, true);
    private Timer timerArquivo = new Timer();
    private Timer timerUrl = new Timer();
    private TimerTask tarefaArquivo = new TimerTask() {
        public void run() {
            (new Thread() {
                public void run() {
                    File[] var1 = CoreArquivo.filter(new File("arquivos"));
                    int var2 = var1.length;

                    for (int var3 = 0; var3 < var2; ++var3) {
                        File arquivo = var1[var3];

                        try {
                            BufferedReader br = null;

                            try {
                                br = new BufferedReader(new FileReader(arquivo.getPath()));
                                System.out.println("Lendo o Arquivo:" + arquivo.getPath());
                                String[] cabecalho = br.readLine().split((new CoreArquivo()).csvDivisor);
                                List<HashMap<String, String>> mapList = (new CoreArquivo()).montaObj(br, cabecalho, arquivo.getPath());
                                CoreArquivo coreArquivo = new CoreArquivo(mapList, arquivo);
                                Conexao conec = new Conexao();
                                Connection conexao = conec.abrirConexao();
                                ArquivoDAO arquivoDAO = new ArquivoDAO(conexao, arquivo.getPath(), mapList, coreArquivo.createTemp());
                                arquivoDAO.inserir();
                                ArrayList<Log> logs = arquivoDAO.getLogs();
                                LogDAO logDAO = new LogDAO(conexao);
                                logDAO.inserir(logs);
                                conec.fecharConexao();
                            } catch (FileNotFoundException var25) {
                                var25.printStackTrace();
                            } catch (Exception var26) {
                                var26.printStackTrace();
                            } finally {
                                if (br != null) {
                                    try {
                                        br.close();
                                    } catch (IOException var24) {
                                        var24.printStackTrace();
                                    }
                                }

                            }
                        } catch (Exception var28) {
                            var28.printStackTrace();
                        }
                    }

                }
            }).start();
        }
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
