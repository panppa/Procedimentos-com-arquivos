/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessandoArquivosTXT;

import java.io.File;
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
        File arquivos = new File ("C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\processando arquivos TXT\\arquivos");
        System.out.println(arquivos.getAbsolutePath());
        
        
        walkin(arquivos);
        
        
                
                System.out.println("Digite o nome do diretório que deseja abrir");
                in.nextLine();
            
        }
    
    
    
    
    
    private String findDir(File root, String name){
        if (root.getName().equals(name)){        
            return root.getAbsolutePath();
        }

        File[] files = root.listFiles();

        if(files != null){
            for (File f : files){
                if(f.isDirectory()){   
                    String myResult = findDir(f, name);
                    if (myResult != null) {
                        //Achado
                        return myResult;
                    }     
                }
            }
        }
        //Não existe
        return null;
    }
    
    
    public static void walkin(File dir) {

    File listFile[] = dir.listFiles();
    if (listFile != null) {
        for (File listFile1 : listFile) {
            if (listFile1.isDirectory()) {
                System.out.println("\n├─--------------"+listFile1.getName());
                walkin(listFile1);
            } else {
                System.out.println("├─-" + listFile1.getName());
            }
        }
    }
    else{
        System.out.println("Esta pasta ou aquivo não existe");
    }
}
}
