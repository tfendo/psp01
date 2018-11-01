package lenguaje;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HugoGuillin
 */
public class Lenguaje {
    
    /**
     * @param args Argumentos pasados por línea de comandos.
     * El primer argumento indica la cantidad de palabras a generar.
     * El segundo argumento indica el fichero en el que se escribirán las palabras generadas.
     */
    public static void main(String[] args) {
        if(args.length==2){ //Se comprueba que se pasan el nº correcto de argumentos
            RandomAccessFile raf=null;
            FileLock fl=null;
            int palabras=0;
            try{ //Se comprueba que el primer argumento sea válido para que no se caiga el programa
                palabras =Integer.parseInt(args[0]);
            }catch(NumberFormatException nfe){
                System.err.println("El primer argumento debe ser de tipo int");
                System.err.println(nfe.toString());
            }
            ArrayList<String> lista=creaPalabras(palabras); //Se rellena una lista con palabras aleatorias
            
            for (String l : lista) {
                try {
                    raf = new RandomAccessFile(args[1], "rwd");
                    
                    //************ INICIO DE LA SECCIÓN CRÍTICA **************
                    
                    fl=raf.getChannel().lock(); //Se obtiene el bloqueo del fichero
                    raf.seek(raf.length()); //Se sitúa el cursor para escribir al final de documento
                    raf.writeChars(l+"\n"); //Se escribe una entrada de la lista y se crea un salto de línea

                    fl.release(); //Se libera el bloqueo sobre el archivo
                    fl=null;
                    
                    // ********** FIN SECCIÓN CRÍTICA ************************

                } catch (FileNotFoundException ex) {
                    System.err.println("Ha ocurrido un error");
                    System.err.println(ex.toString());

                } catch (IOException ex) {
                    System.err.println("No se ha podido crear el archivo");
                    System.err.println(ex.toString());
                }finally{
                    try {
                        if (raf != null) {
                            raf.close();
                        }
                        if (fl != null) {
                            fl.release();
                        }
                        
                    } catch (IOException ex) {
                        System.err.println(ex.toString());
                    }
                }
                
            }
        }else{
            System.err.println("***** NÚMERO INCORRECTO DE ARGUMENTOS *****");
            System.err.println("Debes indicar el número de palabras a generar y el archivo donde se guardarán las palabras");
            System.exit(1);
        }
        
        System.out.println("*** Fichero actualizado correctamente ***");
    }
    
    
    /**
     * Genera palabras de longitud aleatoria compuestas por letras aleatorias
     * @param cantidad Número de palabras a generar
     * @return Una lista rellena con las palabras generadas
     */
    private static ArrayList<String> creaPalabras(int cantidad){
        ArrayList<String> a=new ArrayList<String>();
        StringBuilder sb;
        Random r=new Random();
        int num;
        String [] letras={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
        
        for (int i = 0; i < cantidad; i++) {
            num=(int)(Math.random()*26)+1; // Se genera un nº aleatorio que determina la longitud de la palabra y asegura que al menos genera un 1
            sb=new StringBuilder();
            for (int j = 0; j < num; j++) {
                sb.append(letras[r.nextInt(27)]); //Agrega letras aleatoriamente al StringBuilder desde el array "letras" para crear palabras
            }
            a.add(sb.toString());
        }
        return a;
    }
    
}
