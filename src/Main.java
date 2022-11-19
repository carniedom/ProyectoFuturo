import java.security.PrivilegedExceptionAction;

/*******************************
 * Código desarrollado por Carmelo Nieto Domene
 * Asignatura Entornos de Desarrollo 2022/2023
 */
public class Main {
    public static void main(String[] args) {
        //Se declara la variable para mostrar el mensaje del método veredicto
        String mensajeVeredicto;

        //Se muestra el nombre del estudiante
        System.out.println("Estudiante: " + args[0]);

        //Se llama al método veredicto
        mensajeVeredicto = veredicto(args[1],args[2]);

        //Se muestra el mensaje devuelto por el método veredicto
        System.out.println(mensajeVeredicto);
    }

    static String veredicto(String valor1,String valor2)
    {
        //Se inicializan las variables para el mensaje y para la validación de los argumentos
        String mensaje ="";
        Boolean chkValor1 = true;
        Boolean chkValor2 = true;

        //Se valida que se haya introducido un valor numérico en el primer argumento
        try{
            Integer.parseInt(valor1);
        } catch (Exception ex){
            //Si falla la validación, se pasa a false el flag y se guarda el mensaje
            chkValor1 = false;
            mensaje = "El valor introducido para el número de módulos NO es numérico.";
        }

        //Se valida que se haya introducido un valor numérico en el segundo argumento
        try{
            Integer.parseInt(valor2);
        } catch (Exception ex) {
            //Si falla la validación, se pasa a false el flag y se guarda el mensaje
            chkValor2 = false;
            mensaje = mensaje + " El valor introducido para las horas de estudio NO es numérico.";
        }

        //Si la validación de ambos valores es correcta, se pasa a ejecutar la lógica
        if (chkValor1 && chkValor2) {
            //Se define mensaje a mostrar si las horas de estudio son las mismas que el número de módulos
            if (valor1.equals(valor2)) {
                mensaje = "Bien. Pero una hora de estudio puede ser insuficiente";
            }
            //Se define el mensaje a mostrar si el número de módulos es superior a las horas de estudio
            else if (Integer.valueOf(valor1) > Integer.valueOf(valor2)) {
                mensaje = "Poco tiempo de estudio. Debes dedicar más tiempo";
            //Se define el mensaje a mostrar en el resto de comparativas entre los valroes
            } else {
                mensaje = "Ideal. Trabajas los contenidos en casa";
            }
        }
        //Se devuelve el mensaje
        return mensaje;
    }
}