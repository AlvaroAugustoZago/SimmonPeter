package br.com.simmon.log;


public class LogArquivo {

    public LogArquivo() {
    }

    public LogArquivo(String nomeTabela, String url) {
        this.nomeTabela = nomeTabela;
        descricao = url;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String url) {
        descricao = url;
    }

    public String nomeTabela;
    public String descricao;
}
