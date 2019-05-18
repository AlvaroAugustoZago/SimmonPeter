package br.com.simmon.arquivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
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









  
  public CoreArquivo() {}









  
  public void moveError() {
    // Byte code:
    //   0: aload_0
    //   1: getfield file : Ljava/io/File;
    //   4: invokevirtual getParentFile : ()Ljava/io/File;
    //   7: astore_1
    //   8: new java/io/File
    //   11: dup
    //   12: aload_0
    //   13: getfield file : Ljava/io/File;
    //   16: invokevirtual getParent : ()Ljava/lang/String;
    //   19: aload_0
    //   20: getfield file : Ljava/io/File;
    //   23: invokevirtual getName : ()Ljava/lang/String;
    //   26: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: invokespecial <init> : (Ljava/lang/String;)V
    //   34: astore_2
    //   35: new java/io/File
    //   38: dup
    //   39: aload_0
    //   40: getfield file : Ljava/io/File;
    //   43: invokevirtual getParent : ()Ljava/lang/String;
    //   46: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   51: invokespecial <init> : (Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_1
    //   56: invokevirtual listFiles : ()[Ljava/io/File;
    //   59: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   62: aload_3
    //   63: invokeinterface contains : (Ljava/lang/Object;)Z
    //   68: ifne -> 76
    //   71: aload_3
    //   72: invokevirtual mkdirs : ()Z
    //   75: pop
    //   76: aload_0
    //   77: aload_0
    //   78: getfield file : Ljava/io/File;
    //   81: aload_3
    //   82: aload_2
    //   83: invokevirtual moveFile : (Ljava/io/File;Ljava/io/File;Ljava/io/File;)V
    //   86: goto -> 96
    //   89: astore #4
    //   91: aload #4
    //   93: invokevirtual printStackTrace : ()V
    //   96: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #29	-> 0
    //   #30	-> 8
    //   #31	-> 35
    //   #32	-> 55
    //   #33	-> 71
    //   #36	-> 76
    //   #39	-> 86
    //   #37	-> 89
    //   #38	-> 91
    //   #40	-> 96
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   91	5	4	e	Ljava/io/IOException;
    //   0	97	0	this	Lbr/com/simmon/arquivo/CoreArquivo;
    //   8	89	1	f	Ljava/io/File;
    //   35	62	2	error	Ljava/io/File;
    //   55	42	3	fileError	Ljava/io/File;
    // Exception table:
    //   from	to	target	type
    //   76	86	89	java/io/IOException
  }









  
  public void moveSuccess() {
    // Byte code:
    //   0: aload_0
    //   1: getfield file : Ljava/io/File;
    //   4: invokevirtual getParentFile : ()Ljava/io/File;
    //   7: astore_1
    //   8: new java/io/File
    //   11: dup
    //   12: aload_0
    //   13: getfield file : Ljava/io/File;
    //   16: invokevirtual getParent : ()Ljava/lang/String;
    //   19: aload_0
    //   20: getfield file : Ljava/io/File;
    //   23: invokevirtual getName : ()Ljava/lang/String;
    //   26: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: invokespecial <init> : (Ljava/lang/String;)V
    //   34: astore_2
    //   35: new java/io/File
    //   38: dup
    //   39: aload_0
    //   40: getfield file : Ljava/io/File;
    //   43: invokevirtual getParent : ()Ljava/lang/String;
    //   46: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   51: invokespecial <init> : (Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_1
    //   56: invokevirtual listFiles : ()[Ljava/io/File;
    //   59: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   62: aload_3
    //   63: invokeinterface contains : (Ljava/lang/Object;)Z
    //   68: ifne -> 76
    //   71: aload_3
    //   72: invokevirtual mkdirs : ()Z
    //   75: pop
    //   76: aload_0
    //   77: aload_0
    //   78: getfield file : Ljava/io/File;
    //   81: aload_3
    //   82: aload_2
    //   83: invokevirtual moveFile : (Ljava/io/File;Ljava/io/File;Ljava/io/File;)V
    //   86: goto -> 96
    //   89: astore #4
    //   91: aload #4
    //   93: invokevirtual printStackTrace : ()V
    //   96: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #43	-> 0
    //   #44	-> 8
    //   #45	-> 35
    //   #46	-> 55
    //   #47	-> 71
    //   #50	-> 76
    //   #53	-> 86
    //   #51	-> 89
    //   #52	-> 91
    //   #54	-> 96
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   91	5	4	e	Ljava/io/IOException;
    //   0	97	0	this	Lbr/com/simmon/arquivo/CoreArquivo;
    //   8	89	1	f	Ljava/io/File;
    //   35	62	2	success	Ljava/io/File;
    //   55	42	3	fileSuccess	Ljava/io/File;
    // Exception table:
    //   from	to	target	type
    //   76	86	89	java/io/IOException
  }









  
  public void moveTemp() {
    // Byte code:
    //   0: aload_0
    //   1: getfield file : Ljava/io/File;
    //   4: invokevirtual getParentFile : ()Ljava/io/File;
    //   7: astore_1
    //   8: new java/io/File
    //   11: dup
    //   12: aload_0
    //   13: getfield file : Ljava/io/File;
    //   16: invokevirtual getParent : ()Ljava/lang/String;
    //   19: aload_0
    //   20: getfield file : Ljava/io/File;
    //   23: invokevirtual getName : ()Ljava/lang/String;
    //   26: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: invokespecial <init> : (Ljava/lang/String;)V
    //   34: astore_2
    //   35: new java/io/File
    //   38: dup
    //   39: aload_0
    //   40: getfield file : Ljava/io/File;
    //   43: invokevirtual getParent : ()Ljava/lang/String;
    //   46: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   51: invokespecial <init> : (Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_1
    //   56: invokevirtual listFiles : ()[Ljava/io/File;
    //   59: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   62: aload_3
    //   63: invokeinterface contains : (Ljava/lang/Object;)Z
    //   68: ifne -> 76
    //   71: aload_3
    //   72: invokevirtual mkdirs : ()Z
    //   75: pop
    //   76: aload_0
    //   77: aload_0
    //   78: getfield file : Ljava/io/File;
    //   81: aload_3
    //   82: aload_2
    //   83: invokevirtual moveFile : (Ljava/io/File;Ljava/io/File;Ljava/io/File;)V
    //   86: goto -> 96
    //   89: astore #4
    //   91: aload #4
    //   93: invokevirtual printStackTrace : ()V
    //   96: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #58	-> 0
    //   #59	-> 8
    //   #60	-> 35
    //   #61	-> 55
    //   #62	-> 71
    //   #65	-> 76
    //   #68	-> 86
    //   #66	-> 89
    //   #67	-> 91
    //   #69	-> 96
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   91	5	4	e	Ljava/io/IOException;
    //   0	97	0	this	Lbr/com/simmon/arquivo/CoreArquivo;
    //   8	89	1	f	Ljava/io/File;
    //   35	62	2	success	Ljava/io/File;
    //   55	42	3	fileSuccess	Ljava/io/File;
    // Exception table:
    //   from	to	target	type
    //   76	86	89	java/io/IOException
  }









  
  public void moveFile(File from, File to, File file) throws IOException {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual exists : ()Z
    //   4: ifeq -> 142
    //   7: aload_2
    //   8: invokevirtual isDirectory : ()Z
    //   11: ifeq -> 142
    //   14: aload_0
    //   15: new java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial <init> : (Ljava/io/File;)V
    //   23: putfield inStream : Ljava/io/InputStream;
    //   26: aload_0
    //   27: new java/io/FileOutputStream
    //   30: dup
    //   31: aload_3
    //   32: invokespecial <init> : (Ljava/io/File;)V
    //   35: putfield outStream : Ljava/io/OutputStream;
    //   38: sipush #1024
    //   41: newarray byte
    //   43: astore #4
    //   45: aload_0
    //   46: getfield inStream : Ljava/io/InputStream;
    //   49: aload #4
    //   51: invokevirtual read : ([B)I
    //   54: dup
    //   55: istore #5
    //   57: ifle -> 75
    //   60: aload_0
    //   61: getfield outStream : Ljava/io/OutputStream;
    //   64: aload #4
    //   66: iconst_0
    //   67: iload #5
    //   69: invokevirtual write : ([BII)V
    //   72: goto -> 45
    //   75: aload_0
    //   76: getfield inStream : Ljava/io/InputStream;
    //   79: invokevirtual close : ()V
    //   82: aload_0
    //   83: getfield outStream : Ljava/io/OutputStream;
    //   86: invokevirtual close : ()V
    //   89: aload_3
    //   90: invokevirtual getName : ()Ljava/lang/String;
    //   93: ldc '.temp'
    //   95: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   98: ifne -> 106
    //   101: aload_1
    //   102: invokevirtual delete : ()Z
    //   105: pop
    //   106: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   109: ldc 'File is copied successful!'
    //   111: invokevirtual println : (Ljava/lang/String;)V
    //   114: goto -> 119
    //   117: astore #4
    //   119: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   122: aload_1
    //   123: invokevirtual getName : ()Ljava/lang/String;
    //   126: aload_2
    //   127: invokevirtual getName : ()Ljava/lang/String;
    //   130: aload_3
    //   131: invokevirtual getPath : ()Ljava/lang/String;
    //   134: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   139: invokevirtual println : (Ljava/lang/String;)V
    //   142: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #72	-> 0
    //   #74	-> 14
    //   #75	-> 26
    //   #76	-> 38
    //   #79	-> 45
    //   #80	-> 60
    //   #82	-> 75
    //   #83	-> 82
    //   #85	-> 89
    //   #86	-> 101
    //   #88	-> 106
    //   #90	-> 114
    //   #89	-> 117
    //   #91	-> 119
    //   #93	-> 142
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   45	69	4	buffer	[B
    //   57	57	5	length	I
    //   0	143	0	this	Lbr/com/simmon/arquivo/CoreArquivo;
    //   0	143	1	from	Ljava/io/File;
    //   0	143	2	to	Ljava/io/File;
    //   0	143	3	file	Ljava/io/File;
    // Exception table:
    //   from	to	target	type
    //   14	114	117	java/io/IOException
  }









  
  public File createTemp() throws IOException { return rename(this.file); }




  
  public List<HashMap<String, String>> arrumaCampos() {
    List<HashMap<String, String>> c = new ArrayList<HashMap<String, String>>();
    for (HashMap<String, String> cam : this.campos) {
      HashMap<String, String> ca = new HashMap<String, String>();
      for (String key : cam.keySet()) {
        if (key.equals("long")) {
          ca.put("longi", (String)cam.get(key)); continue;
        } 
        ca.put(key, (String)cam.get(key));
      } 
      
      c.add(ca);
    } 
    return c;
  }






  
  public File rename(File oldFile) {
    // Byte code:
    //   0: ldc ''
    //   2: astore_2
    //   3: aload_1
    //   4: invokevirtual getName : ()Ljava/lang/String;
    //   7: ldc '_'
    //   9: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   12: ifeq -> 49
    //   15: aload_1
    //   16: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   19: aload_1
    //   20: invokevirtual getName : ()Ljava/lang/String;
    //   23: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   26: iconst_0
    //   27: aaload
    //   28: aload_1
    //   29: invokevirtual getName : ()Ljava/lang/String;
    //   32: ldc '_'
    //   34: iconst_2
    //   35: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   38: iconst_1
    //   39: aaload
    //   40: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: goto -> 72
    //   49: aload_1
    //   50: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual getName : ()Ljava/lang/String;
    //   57: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   60: iconst_0
    //   61: aaload
    //   62: aload_1
    //   63: invokevirtual getName : ()Ljava/lang/String;
    //   66: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_2
    //   72: aload_0
    //   73: new java/io/File
    //   76: dup
    //   77: aload_2
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: putfield file : Ljava/io/File;
    //   84: aload_1
    //   85: aload_0
    //   86: getfield file : Ljava/io/File;
    //   89: invokevirtual renameTo : (Ljava/io/File;)Z
    //   92: ifeq -> 120
    //   95: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   98: aload_1
    //   99: invokevirtual getName : ()Ljava/lang/String;
    //   102: aload_0
    //   103: getfield file : Ljava/io/File;
    //   106: invokevirtual getName : ()Ljava/lang/String;
    //   109: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: invokevirtual println : (Ljava/lang/String;)V
    //   117: goto -> 142
    //   120: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   123: aload_1
    //   124: invokevirtual getName : ()Ljava/lang/String;
    //   127: aload_0
    //   128: getfield file : Ljava/io/File;
    //   131: invokevirtual getName : ()Ljava/lang/String;
    //   134: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   139: invokevirtual println : (Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield file : Ljava/io/File;
    //   146: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #120	-> 0
    //   #121	-> 3
    //   #122	-> 15
    //   #124	-> 49
    //   #126	-> 72
    //   #127	-> 84
    //   #128	-> 95
    //   #130	-> 120
    //   #132	-> 142
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	147	0	this	Lbr/com/simmon/arquivo/CoreArquivo;
    //   0	147	1	oldFile	Ljava/io/File;
    //   3	144	2	newNameFile	Ljava/lang/String;
  }






  
  public ArrayList<HashMap<String, String>> montaObj(BufferedReader br, String[] cabecalho, String arquivoCSV) throws Exception {
    ArrayList<HashMap<String, String>> objs = new ArrayList<HashMap<String, String>>();
    while ((this.linha = br.readLine()) != null) {
      HashMap<String, String> campo = new HashMap<String, String>();
      String[] data = this.linha.split(this.csvDivisor);
      for (int i = 0; i < data.length; i++) {
        campo.put(cabecalho[i], data[i]);
      }
      objs.add(campo);
    } 
    return objs;
  }
  
  public static File[] filter(File file) {
    FilenameFilter filter = new FilenameFilter()
      {
        public boolean accept(File file, String s) {
          if (((s.toLowerCase().contains("error") || s
            .toLowerCase().contains("success") || s.toLowerCase().contains("temp")) && file.isDirectory()) || s.startsWith("_") || s.endsWith(".temp")) {
            return false;
          }
          return true;
        }
      };
    
    return file.listFiles(filter);
  }

  
  public String getCsvDivisor() { return this.csvDivisor; }
}
