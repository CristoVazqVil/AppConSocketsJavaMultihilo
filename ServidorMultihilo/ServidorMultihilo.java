package ServidorMultihilo;

import java.io.IOException;
import java.net.ServerSocket;

//Cristopher Vázquez Villa

public class ServidorMultihilo{
    public static void main(String[] args){
        int puerto = 8080;
        try (ServerSocket ss = new ServerSocket(puerto)){
            int cont = 0;
            System.out.println("Servidor escuchando en el puerto: " + puerto + "...");
            System.out.println("El servidor tiene " + cont + " clientes conectados");
            System.out.println("");

            while (true) {
                cont = cont + 1;
                HiloHandler cliente = new HiloHandler(ss.accept(), cont);
                Thread h1 = new Thread(cliente);
                h1.start();
            }

            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}