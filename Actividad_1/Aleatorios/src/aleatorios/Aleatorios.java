package aleatorios;

/**
 *
 * @author HugoGuillin
 */
public class Aleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {//Se generan 40 numero aleatorios y se presentan por la salida estandar
            System.out.println("\t"+Math.round(Math.random()*100));
        }
        
        //Además de para informar del fin de la lista para este programa,
        //esta frase sirve para marcar el fin de los datos para el programa OrdenarNumeros
        System.out.println("*** Fin de la lista ***"); 
    }
    
}
