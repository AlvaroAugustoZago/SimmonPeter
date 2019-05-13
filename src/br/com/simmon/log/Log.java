package br.com.simmon.log;

public class Log {

    public Log(String nomeTabela, long date, String msgLog, Boolean importou, String url, String object) {
        this.nomeTabela = nomeTabela;
        this.date = date;
        this.msgLog = msgLog;
        this.importou = importou;
        this.url = new LogUrl(nomeTabela, url);
        this.object = object;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setMsgLog(String msgLog) {
        this.msgLog = msgLog;
    }

    public void setImportou(Boolean importou) {
        this.importou = importou;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public long getDate() {
        return date;
    }

    public String getMsgLog() {
        return msgLog;
    }

    public Boolean getImportou() {
        return importou;
    }

    public String getUrl() {
        return url.getUrl();
    }

    public void setUrl(String url) {
        this.url.setUrl(url);
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    private String nomeTabela;
    private long date;
    private String msgLog;
    private String object;
    private LogUrl url;
    private Boolean importou;
}
