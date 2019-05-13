package br.com.simmon.configuracao.configuracaoDAOInterface;

import java.util.List;

public interface ConfiguracaoDAOInterface {

    public abstract List verificaTables();

    public abstract void createDatabase();
}
