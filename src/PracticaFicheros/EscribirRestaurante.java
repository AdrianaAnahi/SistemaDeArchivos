/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaFicheros;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Adriana Chiluiza
 */
public class EscribirRestaurante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ruta = "data\\";
        String archivo = "Restaurantes.txt";

        File f = new File(ruta + archivo); 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f, true))) {
            System.out.print("Nombre del restaurante: ");
            String nombre = scanner.nextLine();

            System.out.print("Direccion: ");
            String direccion = scanner.nextLine();

            System.out.print("Especialidad: ");
            String especialidad = scanner.nextLine();

            System.out.print("Precio promedio: ");
            String precio = scanner.nextLine();
            
            String nuevaLinea = String.format("\"%s\",\"%s\",\"%s\",\"%s\"", nombre, direccion, especialidad, precio);
            writer.newLine(); 
            writer.write(nuevaLinea);

            System.out.println("Restaurante agregado correctamente");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
