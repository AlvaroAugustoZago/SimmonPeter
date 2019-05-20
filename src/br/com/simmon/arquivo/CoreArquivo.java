//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package br.com.simmon.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CoreArquivo {
  private List<HashMap<String, String>> campos = null;
  private File file = null;
  private InputStream inStream = null;
  private OutputStream outStream = null;
  private String linha = "";
  public String csvDivisor = ",";

  public CoreArquivo(List<HashMap<String, String>> campos, File file) {
    this.campos = campos;
    this.file = file;
  }

  public CoreArquivo() {
  }

  public void moveError() {
    File f = this.file.getParentFile();
    String var10002 = this.file.getParent();
    File error = new File(var10002 + "/ERROR/" + this.file.getName());
    File fileError = new File(this.file.getParent() + "/ERROR");
    if (!Arrays.asList(f.listFiles()).contains(fileError)) {
      fileError.mkdirs();
    }

    try {
      this.moveFile(this.file, fileError, error);
    } catch (IOException var5) {
      var5.printStackTrace();
    }

  }

  public void moveSuccess() {
    File f = this.file.getParentFile();
    String var10002 = this.file.getParent();
    File success = new File(var10002 + "/SUCCESS/" + this.file.getName());
    File fileSuccess = new File(this.file.getParent() + "/SUCCESS");
    if (!Arrays.asList(f.listFiles()).contains(fileSuccess)) {
      fileSuccess.mkdirs();
    }

    try {
      this.moveFile(this.file, fileSuccess, success);
    } catch (IOException var5) {
      var5.printStackTrace();
    }

  }

  public void moveTemp() {
    File f = this.file.getParentFile();
    String var10002 = this.file.getParent();
    File success = new File(var10002 + "/TEMP/" + this.file.getName());
    File fileSuccess = new File(this.file.getParent() + "/TEMP");
    if (!Arrays.asList(f.listFiles()).contains(fileSuccess)) {
      fileSuccess.mkdirs();
    }

    try {
      this.moveFile(this.file, fileSuccess, success);
    } catch (IOException var5) {
      var5.printStackTrace();
    }

  }

  public void moveFile(File from, File to, File file) throws IOException {
    if (to.exists() && to.isDirectory()) {
      try {
        this.inStream = new FileInputStream(from);
        this.outStream = new FileOutputStream(file);
        byte[] buffer = new byte[1024];

        int length;
        while((length = this.inStream.read(buffer)) > 0) {
          this.outStream.write(buffer, 0, length);
        }

        this.inStream.close();
        this.outStream.close();
        if (!file.getName().endsWith(".temp")) {
          from.delete();
        }

        System.out.println("File is copied successful!");
      } catch (IOException var6) {
      }

      PrintStream var10000 = System.out;
      String var10001 = from.getName();
      var10000.println("arquivo:" + var10001 + " para:" + to.getName() + " no:" + file.getPath());
    }

  }

  public File createTemp() throws IOException {
    return this.rename(this.file);
  }

  public List<HashMap<String, String>> arrumaCampos() {
    List<HashMap<String, String>> c = new ArrayList();
    Iterator var2 = this.campos.iterator();

    while(var2.hasNext()) {
      HashMap<String, String> cam = (HashMap)var2.next();
      HashMap<String, String> ca = new HashMap();
      Iterator var5 = cam.keySet().iterator();

      while(var5.hasNext()) {
        String key = (String)var5.next();
        if (key.equals("long")) {
          ca.put("longi", (String)cam.get(key));
        } else {
          ca.put(key, (String)cam.get(key));
        }
      }

      c.add(ca);
    }

    return c;
  }

  public File rename(File oldFile) {
    String newNameFile = "";
    String var10000;
    if (oldFile.getName().startsWith("_")) {
      var10000 = oldFile.getAbsolutePath().split(oldFile.getName())[0];
      newNameFile = var10000 + oldFile.getName().split("_", 2)[1];
    } else {
      var10000 = oldFile.getAbsolutePath().split(oldFile.getName())[0];
      newNameFile = var10000 + "_" + oldFile.getName();
    }

    this.file = new File(newNameFile);
    String var10001;
    PrintStream var3;
    if (oldFile.renameTo(this.file)) {
      var3 = System.out;
      var10001 = oldFile.getName();
      var3.println("File name changed succesful from:" + var10001 + " to: " + this.file.getName());
    } else {
      var3 = System.out;
      var10001 = oldFile.getName();
      var3.println("Rename failed from:" + var10001 + " to: " + this.file.getName());
    }

    return this.file;
  }

  public ArrayList<HashMap<String, String>> montaObj(BufferedReader br, String[] cabecalho, String arquivoCSV) throws Exception {
    ArrayList objs = new ArrayList();

    while((this.linha = br.readLine()) != null) {
      HashMap<String, String> campo = new HashMap();
      String[] data = this.linha.split(this.csvDivisor);

      for(int i = 0; i < data.length; ++i) {
        campo.put(cabecalho[i], data[i]);
      }

      objs.add(campo);
    }

    return objs;
  }

  public static File[] filter(File file) {
    FilenameFilter filter = new FilenameFilter() {
      public boolean accept(File file, String s) {
        return (!s.toLowerCase().contains("error") && !s.toLowerCase().contains("success") && !s.toLowerCase().contains("temp") || !file.isDirectory()) && !s.startsWith("_") && !s.endsWith(".temp");      }
    };
    return file.listFiles(filter);
  }

  public String getCsvDivisor() {
    return this.csvDivisor;
  }
}
