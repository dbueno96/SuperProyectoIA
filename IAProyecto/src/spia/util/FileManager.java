package spia.util;

import java.io.*;
import java.util.ArrayList;

/**
 * FileManager FileManager.java
 * @date 02/04/2015
 * @author Jhon Jairo Pantoja. Código: 1125572
 * @author Álvaro Jose Lobatón Restrepo. Código: 1130054
 */
public class FileManager {
    /**
     * Atributos privados de la clase.
     */
    private final String fileName;
    private final ArrayList<String> fileContainer;
    private final File file;
    
    /**
     * [FileManager Class' Constructor with parameter, file name.]
     * @param  fileName [String correspondiente al nombre del archivo a gestionar]
     */
    public FileManager(String fileName){
        this.fileName = fileName;
        file = new File(this.fileName);
        fileContainer = new ArrayList<>();        
    }
    /**
     * [FileManager Class' Constructor with parameter, file name.]
     * @param  file [File Correspondiente al archivo a gestionar]
     */
    public FileManager(File file){
        this.file = file;
        this.fileName = file.getName();
        fileContainer = new ArrayList<>();
    }
    /**
     * [clearFileContainer Metodo encargado de vaciar el contenedor del archivo.]
     */
    public void clearFileContainer(){
        fileContainer.clear();
    }
    /**
     * [deleteFile Metodo encargado de borrar el archivo.]
     * @return boolean [Correspondiente a si se eliminó o no.]
     */
    public boolean deleteFile(){
        return file.delete();
    }
    /**
     * [showFileContent Metodo encargado de mostrar el contenido del archivo por consola.]
     */
    public void showFileContent(){
        for (String fileContainer1 : fileContainer) {
            System.out.println(fileContainer1);
        }
    }
    /**
     * [getFileName Metodo encargado de retornar el nombre del archivo.]
     * @return String [Correspondiente al nombre del archivo.]
     */
    public String getFileName(){
        return fileName;
    }
    /**
     * [getFileContainer Metodo encargado de retornar el contenedor del archivo.]
     * @return ArrayList que contiene las lineas del archivo.
     */
    public ArrayList<String> getFileContainer(){
        return fileContainer;
    }
    /**
     * [getFileContent Metodo encargado de retornar un String que contiene el contenido total del archivo.]
     * @return String [Contiene el contenido total del archivo]
     */
    public String getFileContent(){
        String content = "";
        for(int i = 0; i < fileContainer.size(); i++){
            content += fileContainer.get(i);
            if(i != (fileContainer.size() - 1)){
                content += "\n";
            }
        }
        return content;
    }
    /**
     * [readFile Metodo encargado de leer un archivo.]
     */
    public void readFile(){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
           fileReader = new FileReader (file);
           bufferedReader = new BufferedReader(fileReader);
           String line;
           while((line = bufferedReader.readLine()) != null){
               fileContainer.add(line);
           }              
        }
        catch(IOException e){
            System.out.println("readFile() Error: " + e.getMessage());
        }finally{
           try{                    
              if( null != fileReader ){   
                 fileReader.close();     
              }                  
           }catch (IOException e){ 
               System.out.println("readFile() Error: " + e.getMessage());
           }
        }
    }
    /**
     * [writeFile Metodo encargado de escribir un archivo.]
     * @param newLine [String correspondiente a la nueva linea que contendra el archivo.]
     * @param concatenate [Boolean true si se desea concatenar la nueva linea con el contenido anterior del archivo, 
     *                     false encaso de que se desee cambiar o su contenido o crear el archivo con el nuevo contenido.]
     */
    public void writeFile(String newLine, boolean concatenate){
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        
        try
        {
            fileWriter = new FileWriter(file, concatenate);
            printWriter = new PrintWriter(fileWriter);
            printWriter.write(newLine); 
        } catch (IOException e) {
            System.out.println("writeFile() Error: " + e.getMessage());
        } finally {
           try {               
                if (null != fileWriter){
                    fileWriter.close();               
                }                
           } catch (IOException e) {
               System.out.println("writeFile() Error: " + e.getMessage());
           }
        }
    }

}

