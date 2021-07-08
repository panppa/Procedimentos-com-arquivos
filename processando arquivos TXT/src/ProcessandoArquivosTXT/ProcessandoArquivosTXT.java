/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessandoArquivosTXT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class ProcessandoArquivosTXT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        

        
              
        System.out.println("Digite o nome do diretório que deseja abrir: \n Ex: C:\\\\Users\\\\"+System.getProperty("user.name")+"\\\\Documents\\\\NetBeansProjects\\\\processando arquivos TXT\\\\arquivos");
        String endereco = in.nextLine();
        
        File arquivos = new File (endereco);
        
        
        //menu
        System.out.println("\n\n\n\n\n\n\n\n --------------------------------------------\n1)Buscar palavra mais comum\n2)Procurar palavra específica\n");
        String esc = in.nextLine();
        
        if(esc.equals("1")){
            System.out.println("Digite o número de caracteres que a palavra deve ter: ");
            int numchar = in.nextInt();
            maiscomum(arquivos, numchar);
        }else{
            if (esc.equals("2")){
                System.out.println("Escolha uma palavra para procurar: ");
                String search = in.nextLine();
                buscar(arquivos, search);    
            }
        }
        
            
    }
    
    
    
    //------------ implementar no futuro
    
    /*public static File findDir(File root, String name){
    File[] files = root.listFiles();
    
    if(files != null){
    
    for (File f : files){
    System.out.println(f.getName());
    if(f.getName().equals(name)){
    //Achado
    return f;
    }
    
    }
    }else{
    //pasta vazia
    System.out.println("esta pasta está vazia");
    }
    //não achado
    System.out.println("O arquivo procurado não se encontra neste diretório.");
    return null;
    }*/
    
    
    public static void buscar(File dir, String search) {
        File listFile[] = dir.listFiles();
        for (File listFile1 : listFile) {
            if (listFile1.exists() && listFile1.canRead()){
                    //if(listFile1.getName()){ -------------------------------------------- implementar no futuro (apenas TXT   
                try(FileReader marcaLeitura = new FileReader(listFile1)){
                    if(listFile1.exists() && listFile1.canRead()){

                        BufferedReader bufLeitura = new BufferedReader(marcaLeitura);

                        String linha = bufLeitura.readLine();
                        int numlinha=1;
                        while(linha != null){
                            numlinha++;
                            //System.out.println(linha);
                            linha = bufLeitura.readLine();
                            try {
                                String listWords[] = linha.split(" ");
                                for(String listWords1 : listWords){
                                    if (listWords1.equals(search)){
                                        System.out.println("Arquivo: "+listFile1.getName()+" Linha: " + numlinha);
                                    }
                                }
                            } catch (Exception e) {
                                   //mudando de arquivo...
                            }
                            
                        }

                    }else{
                        System.out.println("Arquivo não disponivel para leitura.");
                    }
                }catch(FileNotFoundException ex){
                    System.out.println("Arquivo não existe.");
                }catch(IOException ex){
                    System.out.println("Arquivo não pode ser lido ou foi corrompido");
                }
            }        
        }            
                
        
        //-------------------------implementar no futuro
        /*if (pasta != 0){
        System.out.println("Escolha uma pasta ou arquivo para abrir.");
        Scanner in = new Scanner(System.in);
        String endereco = in.nextLine();
        File diraux;
        
        try {
        diraux = findDir(dir, endereco);
        walkin(diraux);
        } catch (Exception e) {
        System.out.println("Null pointer exception");
        }
        }*/
    }

    private static void maiscomum(File dir,int numchar) {
        File listFile[] = dir.listFiles();
        for (File listFile1 : listFile) {
            if (listFile1.exists() && listFile1.canRead()){
                    //if(listFile1.getName()){ -------------------------------------------- implementar no futuro (apenas TXT   
                try(FileReader marcaLeitura = new FileReader(listFile1)){
                    if(listFile1.exists() && listFile1.canRead()){

                        BufferedReader bufLeitura = new BufferedReader(marcaLeitura);

                        String linha = bufLeitura.readLine();
                        int numlinha=1;
                        while(linha != null){
                            numlinha++;
                            //System.out.println(linha);
                            linha = bufLeitura.readLine();
                            try {
                                String listWords[] = linha.split(" ");
                                for(String listWords1 : listWords){
                                    if (listWords1.length()== numchar){ 
                                        System.out.println("Arquivo: "+listFile1.getName()+" Linha: " + numlinha);
                                    }
                                }
                            } catch (Exception e) {
                                   //mudando de arquivo...
                            }
                            
                        }

                    }else{
                        System.out.println("Arquivo não disponivel para leitura.");
                    }
                }catch(FileNotFoundException ex){
                    System.out.println("Arquivo não existe.");
                }catch(IOException ex){
                    System.out.println("Arquivo não pode ser lido ou foi corrompido");
                }
            }        
        }
    }
}
    