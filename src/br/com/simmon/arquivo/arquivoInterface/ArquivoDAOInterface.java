package br.com.simmon.arquivo.arquivoInterface;

import java.util.HashMap;

public interface ArquivoDAOInterface {

    void createTable();

    void dropTable();

    boolean inserir(HashMap<String, String> var1);

    boolean deletar();
}
