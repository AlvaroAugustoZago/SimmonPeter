package br.com.simmon.cronometro;

import br.com.quatro2.Peter.Arquivo;
import br.com.simmon.conexao.BancoCore;
import br.com.simmon.conexao.Conexao;

import java.sql.Connection;
import java.util.*;

public class Cronometro {

    public Cronometro() {
        timerArquivo = new Timer();
        timerUrl = new Timer();
        tarefaArquivo = new TimerTask() {

            public void run() {
                (new Object()             /* anonymous class not found */
                class _anm1 {
                }

).start();
            }

            final Cronometro this$0;


            {
                this.this$0 = Cronometro.this;
                super();
            }
        };
        tarefaUrl = new TimerTask() {

            public void run() {
                (new Thread() {

                    public void run() {
                        try {
                            Conexao conec = new Conexao();
                            Connection conexao = conec.abrirConexao();
                            BancoCore bancoCore = new BancoCore(conexao, null);
                            String comando = "SELECT * FROM log_url";
                            List urls = bancoCore.selectMap(comando);
                            for (Iterator iterator = urls.iterator(); iterator.hasNext(); ) {
                                HashMap url = (HashMap) iterator.next();
                                Iterator iterator1 = url.keySet().iterator();
                                while (iterator1.hasNext()) {
                                    String tabela = (String) iterator1.next();
                                    Arquivo arquivo = new Arquivo((String) url.get(tabela));
                                    arquivo.buscarCSV();
                                    arquivo.realizaDownload();
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    final _cls2 this$1;


                    {
                        this.this$1 = _cls2.this;
                        super();
                    }
                }).start();
            }

            final Cronometro this$0;


            {
                this.this$0 = Cronometro.this;
                super();
            }
        };
    }

    public void lancarTarefas() {
        timerArquivo.scheduleAtFixedRate(tarefaArquivo, timeArquivo, timeArquivo);
        timerUrl.scheduleAtFixedRate(tarefaUrl, timeUrl, timeUrl);
    }

    private long calculaTime(int tempo, boolean horas) {
        if (horas)
            return (long) (tempo * 0x36ee80);
        else
            return (long) (tempo * 60000);
    }

    final long timeArquivo = calculaTime(15, false);
    final long timeUrl = calculaTime(24, true);
    private Timer timerArquivo;
    private Timer timerUrl;
    private TimerTask tarefaArquivo;
    private TimerTask tarefaUrl;
}
