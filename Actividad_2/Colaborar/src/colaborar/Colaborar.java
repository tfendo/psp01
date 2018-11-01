package colaborar;

/**
 *
 * @author HugoGuillin
 */
public class Colaborar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length==1){
            Process proceso=null;
            try{
                for (int i = 10; i <=100; i+=10) {
                    proceso=Runtime.getRuntime().exec("java -jar Lenguaje.jar "+i+ " " + args[0]);
                    System.out.println("Creado el proceso nº "+ (i/10));
                }                            
                                               
            }catch(SecurityException se){
                System.err.println("Se ha producido un error");
                System.err.println(se.toString());
            }catch(Exception ex){
                System.err.println("Ha ocurrido un error");
                System.err.println(ex.toString());
            }
        }else{
            System.err.println("Número incorrecto de parámetros");
            System.exit(1);
        }        
    }
    
}
