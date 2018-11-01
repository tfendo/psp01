
package ordenarnumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author HugoGuillin
 */
public class OrdenarNumeros {

    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>(); //Lista donde se guardarán los números
        Scanner entrada=new Scanner(System.in); //Objeto para manipular las entradas de datos
        int num, tam;
        boolean b=false;
        
        System.out.println("Introduce numeros enteros y el programa los ordenará de menor a mayor."
                + "\nCualquier entrada distinta de un número entero finaliza la entrada de datos");
        do {
            if(entrada.hasNextInt()){ //Compruebo si el dato que contiene la entrada es un número
                num=entrada.nextInt(); //Si es así, lo asigno a la variable num y lo añado a la lista
                a.add(num);
            }else{ //Si la entrada no contiene un número, se finaliza la entrada de datos a la lista
                b=true;
            }           
        } while (!b); 
        
        Collections.sort(a); //Ordeno la lista para su posterior presentación
        tam=a.size(); //Calculo el tamaño de la lista para informar del número de entradas ordenadas
        
        System.out.println("\n***Lista de números ordenada***");
        for (Integer i : a) {
            System.out.println("\t"+i);
        }
        System.out.println("*******************************");
        
        System.out.println("\n### Se han ordenado un total de "+tam+" números ###");
    }
    
}
