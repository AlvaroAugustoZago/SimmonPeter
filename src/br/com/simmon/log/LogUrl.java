package br.com.simmon.log;


public class LogUrl {

    public LogUrl() {
    }

    public LogUrl(String nomeTabela, String url) {
        this.nomeTabela = nomeTabela;
        this.url = url;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String nomeTabela;
    public String url;
}
