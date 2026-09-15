/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaFicheros;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author Adriana Chiluiza
 */
public class InfoFichero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la ruta del archivo o directorio: ");
        String ruta = scanner.nextLine();

        try {
        File archivo = new File(ruta);

        if (archivo.exists()) {
            System.out.println("El archivo o directorio existe");

            if (archivo.isDirectory()) {
                System.out.println("Se trata de un directorio");
            } else if (archivo.isFile()) {
                System.out.println("Se trata de un archivo");
                System.out.println("Nombre: " + archivo.getName());
                System.out.println("Tamano (bytes): " + archivo.length());
                System.out.println("Se puede leer " + archivo.canRead());
                System.out.println("Se puede escribir " + archivo.canWrite());
            }
        } else {
            System.out.println("El archivo o directorio no existe");
        }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al intentar acceder a la ruta");
            System.out.println("Detalles del error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

 
