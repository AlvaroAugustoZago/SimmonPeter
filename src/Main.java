import br.com.simmon.arquivo.DataBase;
import br.com.simmon.configuracao.Configuracao;

public class Main {

    public Main() {
    }

    public static void main(String args[]) {
        (new Configuracao()).inicializar();
        DataBase dataBase = new DataBase();
        try {
            dataBase.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
