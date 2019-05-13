package br.com.simmon.arquivo;

import br.com.quatro2.Peter.Arquivo;
import br.com.simmon.cronometro.Cronometro;

public class DataBase {

    public DataBase() {
    }

    public void run(String args[]) {
        Cronometro cronometro = new Cronometro();
        cronometro.lancarTarefas();
        String as[] = args;
        int i = as.length;
        for (int j = 0; j < i; j++) {
            String arg = as[j];
            if (arg.equals("-initdb"))
                iniciarBases();
        }

    }

    private void iniciarBases() {
        String urlBases[] = {
                "http://dados.gov.br/dataset/ubs_construcao", "http://dados.gov.br/dataset/ubs_existentes", "http://dados.gov.br/dataset/ubs_funcionamento", "http://dados.gov.br/dataset/acs_equipes", "http://dados.gov.br/dataset/odm6_malaria", "http://tabnet.datasus.gov.br/cgi/deftohtm.exe?idb2012/d0203.def", "http://www2.datasus.gov.br/DATASUS/index.php?area=0203", "http://dados.gov.br/dataset/odm4_imunizacao", "http://dados.gov.br/dataset/odm6_dengue", "http://dados.gov.br/dataset/odm5_mortalidade_materna",
                "http://dados.gov.br/dataset/odm4_mortalidade_infantil", "http://dados.gov.br/dataset/cnes_ativo", "http://dados.gov.br/dataset/odm5_parto_normal", "http://dados.gov.br/dataset/wms_idsus_nt_probiiam", "http://dados.gov.br/dataset/wms_idsus_nt_probm15ut", "http://dados.gov.br/dataset/odm5_pre_natal", "http://dados.gov.br/dataset/wms_idsus_nt_prachoacd", "http://dados.gov.br/dataset/violencia_mortalidade", "http://dados.gov.br/dataset/mspainelsage_69", "http://dados.gov.br/dataset/mspainelsage_51",
                "http://dados.gov.br/dataset/mspainelsage_50", "http://dados.gov.br/dataset/mspainelsage_83", "http://dados.gov.br/dataset/mspainelsage_67", "http://dados.gov.br/dataset/mspainelsage_54", "http://dados.gov.br/dataset/mspainelsage_53", "http://dados.gov.br/dataset/mspainelsage_71", "http://dados.gov.br/dataset/mspainelsage_68", "http://dados.gov.br/dataset/mspainelsage_189", "http://dados.gov.br/dataset/mspainelsage_66", "http://dados.gov.br/dataset/mspainelsage_64",
                "http://dados.gov.br/dataset/odm6_malaria", "http://dados.gov.br/dataset/sismob_ubs", "http://dados.gov.br/dataset/upa_pre_func", "http://dados.gov.br/dataset/upa_pre_const", "http://dados.gov.br/dataset/upa_pac_func", "http://dados.gov.br/dataset/upa_pac_const", "http://dados.gov.br/dataset/upa_funcionamento_cnes", "http://dados.gov.br/dataset/hanseniase_incap_grau_2_2010", "http://dados.gov.br/dataset/hanseniase_novos_casos_2010", "http://dados.gov.br/dataset/mspainelsage_55"
        };
        String as[] = urlBases;
        int i = as.length;
        for (int j = 0; j < i; j++) {
            String link = as[j];
            Arquivo arquivo = new Arquivo(link);
            arquivo.buscarCSV();
            arquivo.realizaDownload();
        }

    }
}
