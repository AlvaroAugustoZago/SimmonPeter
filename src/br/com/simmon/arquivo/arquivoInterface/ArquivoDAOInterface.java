package br.com.simmon.arquivo.arquivoInterface;

import java.util.HashMap;

public interface ArquivoDAOInterface {

    public abstract void createTable();

    public abstract void dropTable();

    public abstract boolean inserir(HashMap hashmap);

    public abstract boolean deletar();
}
