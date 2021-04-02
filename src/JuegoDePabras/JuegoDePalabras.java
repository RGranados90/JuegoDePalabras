
package JuegoDePabras;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Después de una fiesta de largas horas, al momento de pagar la cuenta, Juan y sus amigos
 * plantean jugar el juego de la suma más alta y quien gane el juego no debe pagar un céntimo
 * de la cuenta. El juego consiste en encontrar la suma más alta de valores consecutivos en
 * una secuencia de números; el ganador es el que responda más rápidamente.
 * Por ejemplo, en la secuencia 23, −1, −24, 2, 23 la suma más alta de valores consecutivos es
 * 25 y quien consiga este valor de primero gana el juego.
 * Juan está cansado de tener que pagar siempre las cuentas noche tras noche ya que nunca
 * gana el juego, por tal motivo, él está decidido a cambiar esa situación. Juan lo ha contratado
 * a usted para escribir un programa computarizado altamente eficiente que pueda vencer a los
 * demás competidores del juego.
 * Entrada (suma.in)
 * La entrada consiste de varios casos de prueba, cada uno definido por una línea compuesta
 * de una secuencia de N enteros separados por espacios en blanco X1, X2, . . ., XN. (1≤N≤105
 * , −103≤Xi≤103
 * para cada 1≤i≤N).
 * Salida (Pantalla)
 * Por cada caso de prueba, debe imprimir el valor de la suma más alta de los valores
 * consecutivos en X1, X2, . . ., XN.
 * Ejemplo
 * Entrada (suma.in)
 * 1 2 3 4 5 6 7 8 9
 * -1 -1 -1
 * 23 -1 -24 2 23
 * 1 -14 -4 14 -11 -7 6
 * Salida Estándar
 * 45
 * 0
 * 25
 * 14
 *
 * @author Granados
 */
public class JuegoDePalabras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String []vec;

        try{
            FileInputStream fstream = new FileInputStream("suma.in");

            DataInputStream entrada = new DataInputStream(fstream);

            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));

            String strLinea;
            while ((strLinea=buffer.readLine())!=null)   {


                vec = strLinea.split(" ");
                int mayor=0,mayor2=0;

                for (int i = 0; i < vec.length-1; i++) {
                    if(Integer.parseInt(vec[i])>mayor)
                        mayor=Integer.parseInt(vec[i]);

                    if(Integer.parseInt(vec[i])>0 && Integer.parseInt(vec[i+1])>=0) {

                        mayor2 = Integer.parseInt(vec[i]) + Integer.parseInt(vec[i + 1]);
                        if(mayor2>mayor) {
                            vec[i + 1] = Integer.toString(mayor2);
                            mayor= mayor2;
                        }
                    }

                    }

                System.out.println("el Mayor es: "+ mayor);
                }
            entrada.close();
        }catch (Exception e){
            System.err.println("Ocurrio un error: " + e.getMessage());
        }

    }

}