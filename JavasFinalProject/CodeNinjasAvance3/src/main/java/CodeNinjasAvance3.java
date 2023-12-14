/**
 *
 * @author Kendra y Esteban
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CodeNinjasAvance3 {
    private static final int NORMALIZACION_PESO_MEDALLAS_ORO = 3;
    private static final int NORMALIZACION_PESO_MEDALLAS_PLATA = 2;
    private static final int NORMALIZACION_PESO_MEDALLAS_BRONCE = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> paises = new ArrayList<>();
        List<Integer> oro = new ArrayList<>();
        List<Integer> plata = new ArrayList<>();
        List<Integer> bronce = new ArrayList<>();
        List<Integer> puntajeTotal = new ArrayList<>();


        int numPaises = 0;
        int opcion;
        boolean programaIniciado = false;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Iniciar el programa");
            System.out.println("2. Registrar información de los países");
            System.out.println("3. Calcular puntaje total");
            System.out.println("4. Imprimir puntaje total de cada país");
            System.out.println("5. Imprimir país con más medallas de plata");
            System.out.println("6. Calcular e imprimir promedio de medallas de bronce");
            System.out.println("7. Imprimir medallero informativo");
            System.out.println("8. Ordenar los puntajes totales de mayor a menor");
            System.out.println("9. Imprimir puntajes totales de mayor a menor ordenados");
            System.out.println("10. Salir");
            System.out.println();

            System.out.print("Seleccione una opción: ");
            System.out.println();

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el salto de línea del buffer

                switch (opcion) {
                    case 1:
                        numPaises = iniciarPrograma(scanner);
                        programaIniciado = true; //Se cambia a tru cuando se ha seleccionado la opción 1
                        break;
                    case 2:
                        if (programaIniciado) { //Para que si programaIniciado continua en false, que se ejecute la funcion mostrarAlertaPorOrdenDeMenu(), y rompa el ciclo para volver al menu, y en caso contrario, si programaIniciado se encuentra en True debido a que ya se ingresó la opcion 1, para que entonces se ejecute el codigo con normalidad
                            registrarInformacionDatosPaises(scanner, paises, oro, plata, bronce, numPaises);
                        } else {
                            mostrarAlertaPorOrdenDeMenu();
                        }
                        break;
                    case 3:
                        if (programaIniciado) { //Para que si programaIniciado continua en false, que se ejecute la funcion mostrarAlertaPorOrdenDeMenu(), y rompa el ciclo para volver al menu, y en caso contrario, si programaIniciado se encuentra en True debido a que ya se ingresó la opcion 1, para que entonces se ejecute el codigo con normalidad
                           calculadoraDePuntajes(oro, plata, bronce, puntajeTotal, numPaises);
                           volverAlMenú(scanner);
                        } else {
                            mostrarAlertaPorOrdenDeMenu();
                        }
                        break;
                    case 4:
                        if (programaIniciado) { //Para que si programaIniciado continua en false, que se ejecute la funcion mostrarAlertaPorOrdenDeMenu(), y rompa el ciclo para volver al menu, y en caso contrario, si programaIniciado se encuentra en True debido a que ya se ingresó la opcion 1, para que entonces se ejecute el codigo con normalidad
                            imprimeTablaDePuntajes(paises, puntajeTotal, numPaises);
                            volverAlMenú(scanner);
                        } else {
                            mostrarAlertaPorOrdenDeMenu();
                        }
                        break;
                    case 5:
                        if (programaIniciado) { //Para que si programaIniciado continua en false, que se ejecute la funcion mostrarAlertaPorOrdenDeMenu(), y rompa el ciclo para volver al menu, y en caso contrario, si programaIniciado se encuentra en True debido a que ya se ingresó la opcion 1, para que entonces se ejecute el codigo con normalidad
                            imprimePaisConMasMedallasPlata(paises, plata);
                            volverAlMenú(scanner);
                        } else {
                            mostrarAlertaPorOrdenDeMenu();
                        }
                        break;
                    case 6:
                        if (programaIniciado) { //Para que si programaIniciado continua en false, que se ejecute la funcion mostrarAlertaPorOrdenDeMenu(), y rompa el ciclo para volver al menu, y en caso contrario, si programaIniciado se encuentra en True debido a que ya se ingresó la opcion 1, para que entonces se ejecute el codigo con normalidad
                            imprimePromedioMedallasBronce(bronce, numPaises);
                            volverAlMenú(scanner);
                        } else {
                            mostrarAlertaPorOrdenDeMenu();
                        }
                        break;
                    case 7: 
                        if (programaIniciado) { //Para que si programaIniciado continua en false, que se ejecute la funcion mostrarAlertaPorOrdenDeMenu(), y rompa el ciclo para volver al menu, y en caso contrario, si programaIniciado se encuentra en True debido a que ya se ingresó la opcion 1, para que entonces se ejecute el codigo con normalidad
                            imprimirMedalleroInformativo(paises, oro, plata, bronce);
                            volverAlMenú(scanner);
                        } else {
                            mostrarAlertaPorOrdenDeMenu();
                        }
                        break;
                    case 8: 
                        if (programaIniciado) { //Para que si programaIniciado continua en false, que se ejecute la funcion mostrarAlertaPorOrdenDeMenu(), y rompa el ciclo para volver al menu, y en caso contrario, si programaIniciado se encuentra en True debido a que ya se ingresó la opcion 1, para que entonces se ejecute el codigo con normalidad
                            mensajeCasoNumberOcho();
                            volverAlMenú(scanner);
                        } else {
                            mostrarAlertaPorOrdenDeMenu();
                        }
                        break;
                    case 9:
                        if (programaIniciado) { //Para que si programaIniciado continua en false, que se ejecute la funcion mostrarAlertaPorOrdenDeMenu(), y rompa el ciclo para volver al menu, y en caso contrario, si programaIniciado se encuentra en True debido a que ya se ingresó la opcion 1, para que entonces se ejecute el codigo con normalidad
                            ordenareImprimirPuntajes(puntajeTotal, paises);
                            volverAlMenú(scanner);
                        } else {
                            mostrarAlertaPorOrdenDeMenu();
                        }
                        break;
                    case 10:
                        System.out.println("Nos vemos, hasta pronto, sayonara!"); //Mensaje de despedida cuando el usuario decide salir del programa
                        break;         
           
                    default:
                        mostrarAlerta();
                }

            } catch (InputMismatchException e) {
                scanner.nextLine(); // Acá limpio selección en caso de entrada no válida
                mostrarAlerta();
                opcion = 0; // Acá asigno un valor inválido para que el bucle pueda seguir ejecutandose
            }
        } while (opcion != 10); //Para que mientras no se elija 10, el menu se siga repitiendo

        scanner.close();
    }

    
    public static void mostrarAlerta() {
        System.out.println("Opción inválida. Intente nuevamente."); //Mensaje que se muestra cuando se ingresa un valor que no es un int
    }
    
    public static void mostrarAlertaPorOrdenDeMenu() {
        System.out.println("Antes de usar esta opción debe haber elegido anteriormente la opción 1. Intente nuevamente."); //Mensaje que se muestra cuando se ingresa un valor sin antes haber ingresado 1
    }
    

    public static int iniciarPrograma(Scanner scanner) { //Aca se inicializa el programa y se recibe cuantos paises participan en el torneo
        System.out.println();
        System.out.print("Ingrese el número de países que participan en el torneo: ");
        int numPaises = scanner.nextInt();
        scanner.nextLine(); //Acá se limpia el salto de línea
        return numPaises;
    }

    public static void registrarInformacionDatosPaises(Scanner scanner, List<String> paises, List<Integer> oro,
            List<Integer> plata, List<Integer> bronce, int numPaises) {
        for (int i = 1; i <= numPaises; i++) { // Acá se itera sobre numPaises y se va agregando la informacion a las listas
            System.out.println();
            System.out.print("Ingrese el nombre del país " + i + ": ");
            paises.add(scanner.nextLine());

            System.out.print("Medallas de oro para " + paises.get(i - 1) + ": "); //Acá se restar 1 al índice de las listas porque inicialmente i se declaro como 1 para temas esteticos
            oro.add(scanner.nextInt());

            System.out.print("Medallas de plata para " + paises.get(i - 1) + ": "); //Acá se restar 1 al índice de las listas porque inicialmente i se declaro como 1 para temas esteticos
            plata.add(scanner.nextInt());

            System.out.print("Medallas de bronce para " + paises.get(i - 1) + ": "); //Acá se restar 1 al índice de las listas porque inicialmente i se declaro como 1 para temas esteticos
            bronce.add(scanner.nextInt());

            scanner.nextLine(); //Acá se limpia el salto de línea
            System.out.println();
        }
    }

    public static void calculadoraDePuntajes(List<Integer> oro, List<Integer> plata, List<Integer> bronce,
            List<Integer> puntajeTotal, int numPaises) {
        puntajeTotal.clear();
        for (int i = 0; i < numPaises; i++) {
            int puntaje = oro.get(i) * NORMALIZACION_PESO_MEDALLAS_ORO + plata.get(i) * NORMALIZACION_PESO_MEDALLAS_PLATA + bronce.get(i) * NORMALIZACION_PESO_MEDALLAS_BRONCE; //Acá se llama a los valores presentes en las listas de oro, plata y bronce y se multiplican por 3 2 y 1 respectivamente.  NORMALIZACION_PESO_MEDALLAS_ORO, NORMALIZACION_PESO_MEDALLAS_PLATA y NORMALIZACION_PESO_MEDALLAS_BRONCE almacenan a 3, 2 y 1 respectivamente
            puntajeTotal.add(puntaje); //Acá el resultado de puntaje se agrega a la lista puntajeTotal
        }
        System.out.println();
        System.out.println("El puntaje total fue calculado de manera exitosa. A continuación elija una opción del 4 al 9 para ver la información representada de distintas maneras.");
        System.out.println();
    }

    public static void imprimeTablaDePuntajes(List<String> paises, List<Integer> puntajeTotal, int numPaises) {
        System.out.println();
        System.out.println("Juegos olímpicos de Tokio 2020");
        System.out.println();
        System.out.println("Tabla de puntajes");
        System.out.println();

        //Esto de abajo es meramente estético, para que la tabla se vea bien. Pero funciona  calculando la longitud máxima del nombre de país en la lista 'paises' para saber cuantos espacios dejar y que no se vea fea la tabla
        int maxNombrePaisLength = 0;  
        for (String pais : paises) {
            if (pais.length() > maxNombrePaisLength) {
                maxNombrePaisLength = pais.length(); //Se  recorre la lista y se va actualizando la variable maxNombrePaisLength con el valor máximo encontrado.
            }
        }
        
        String formatString = "%-20s %s"; //FormatString se utiliza para imprimiar cada fila de la tabla. En este caso 2 filas, y "%-20s %s" es el ancho que van a ocupar
        System.out.println(String.format(formatString, "País", "Puntaje Total"));

        for (int i = 0; i < numPaises; i++) { //Se itera sobre la lista paises y puntajeTotal, para obtener cada país y su respectivo puntaje
            String nombrePais = paises.get(i);
            String espaciosStr = " ".repeat(maxNombrePaisLength - nombrePais.length() + 2); // Esto es para que si el nombre del país es largo, entonces que no invada la columna de Puntaje Total
            String puntajeStr = String.valueOf(puntajeTotal.get(i));
            System.out.println(String.format(formatString, nombrePais + espaciosStr, puntajeStr)); //Gracias a esta linea es que se logra imprimir de manera satisfactoria la tabla de puntajes
        }
        System.out.println();
    }

    public static void imprimePaisConMasMedallasPlata(List<String> paises, List<Integer> plata) {
        int maxPlata = Collections.max(plata); //Acá se obtiene el valor máximo en la lista de medallas de plata (plata)
        int indexMaxPlata = plata.indexOf(maxPlata); //Acá se obtiene el indice relacionado al valor meximo de la lista de medallas de plata (plata)
        System.out.println();
        System.out.println("El país con más medallas de plata es: " + paises.get(indexMaxPlata));
        System.out.println();
    }

    public static void imprimePromedioMedallasBronce(List<Integer> bronce, int numPaises) {
        int totalMedallasBronce = 0;
        for (int i = 0; i < numPaises; i++) {
            totalMedallasBronce += bronce.get(i); // Acá se recorre el arreglo 'bronce' para obtener el total de medallas de bronce
        }
        double promedioBronce = (double) totalMedallasBronce / numPaises; //Acá obtenemos el promedio (mediana) tomando el total de medallas bronce y diviendolo entre la cantidad de paises
        System.out.println();
        System.out.println("El promedio de medallas de bronce es de: " + promedioBronce);
        System.out.println();
    }

    public static void imprimirMedalleroInformativo(List<String> paises, List<Integer> oro, List<Integer> plata, List<Integer> bronce) {
        System.out.println();
        System.out.println("Juegos olímpicos de Tokio 2020");
        System.out.println();
        System.out.println("Medallero Informativo:");
        System.out.println();

        int maxNombreLength = 0; //Al igual que arriba, esto funciona para poder encontrar el tamaño maximo del nombre de un pais y asi poder alinear la tabla
        for (String pais : paises) {
            if (pais.length() > maxNombreLength) {
                maxNombreLength = pais.length();
            }
        }

        String formatString = "%-" + (maxNombreLength + 8) + "s %-18s %-18s %-18s"; //Al igual que arriba, esta linea funciona para definir el ancho de las columnas y que la tabla se vea bien, de esta manera los nombres de los paises más largos no invadirian las  columnas de medallas
        System.out.println(String.format(formatString, "País", "Medallas de oro", "Medallas de plata", "Medallas de bronce"));

        for (int i = 0; i < paises.size(); i++) { //Acá se imprime el reporte de medallas de cada pais
            String nombrePais = paises.get(i);
            String medallasOro = oro.get(i).toString();
            String medallasPlata = plata.get(i).toString();
            String medallasBronce = bronce.get(i).toString();

            System.out.println(String.format(formatString, nombrePais, medallasOro, medallasPlata, medallasBronce));
        }
    }

    public static void ordenareImprimirPuntajes(List<Integer> puntajeTotal, List<String> paises) {
    List<Integer> copiaPuntajeTotal = new ArrayList<>(puntajeTotal);
    List<String> copiaPaises = new ArrayList<>(paises);

    int n = copiaPuntajeTotal.size();

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (copiaPuntajeTotal.get(j) < copiaPuntajeTotal.get(j + 1)) {
                // Si el puntaje en j es menor que el puntaje en la posición j+1,
                // entonces intercambiamos los elementos en ambas listas (copiaPuntajeTotal y copiaPaises)
                Collections.swap(copiaPuntajeTotal, j, j + 1);
                Collections.swap(copiaPaises, j, j + 1);
            }
        }
    }

    imprimirPuntajesOrdenados(copiaPuntajeTotal, copiaPaises);

}

    
    public static void mensajeCasoNumberOcho() { //Esta funcion es especificamente para imprimir un texto.
        System.out.println();
        System.out.println("Puntaje ordenado de manera satisfactoria. Los países y sus respectivos puntajes ordenados de mayor a menor se podrán ver seleccionando la opción 9 del Menú.");
        System.out.println();
    }

    public static void imprimirPuntajesOrdenados(List<Integer> copiaPuntajeTotal, List<String> copiaPaises) {
        System.out.println();
        System.out.println("Juegos olímpicos de Tokio 2020");
        System.out.println();
        System.out.println("Tabla de posiciones");
        System.out.println();

        String formatString = "%-20s %s"; //Al igual que arriba, esta linea funciona para definir el ancho de las columnas y que la tabla se vea bien, de esta manera los nombres de los paises más largos no invadirian las  columnas de puntaje
        System.out.println(String.format(formatString, "País", "Puntaje Total"));

        for (int i = 0; i < copiaPaises.size(); i++) {
            System.out.println(String.format(formatString, copiaPaises.get(i), copiaPuntajeTotal.get(i)));
        }
        System.out.println();
    }
    
    public static void volverAlMenú(Scanner scanner){
    System.out.println("Presione Enter para volver al menú ");
    scanner.nextLine(); 
    }
            
}
