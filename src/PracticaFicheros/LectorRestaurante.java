/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaFicheros;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Adriana Chiluiza
 */
public class LectorRestaurante {
    public static void main(String[] args) {
        
        String ruta = "data\\";
        String archivo = "Restaurantes.txt";

        File f = new File(ruta + archivo);
        

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea = br.readLine(); // Leer cabecera y descartarla si quieres
            System.out.println("Restaurantes con codigo postal que empieza por 6:\n");

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                if (partes.length >= 5) {
                    String zipcode = partes[4].trim();

                    if (zipcode.startsWith("6")) {
                        System.out.println(linea);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

   
