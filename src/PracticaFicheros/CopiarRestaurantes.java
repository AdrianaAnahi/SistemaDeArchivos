/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Adriana Chiluiza
 */
public class CopiarRestaurantes {
    public static void main(String[] args) {
        String archivoOrigen = "data\\Restaurantes.txt";
        String archivoDestino = "data\\Restaurantes2.txt";

        Pattern patronCodigoPostal = Pattern.compile("(\\d{5})$"); // Expresión regular para encontrar 5 dígitos al final de la línea

        int copiados = 0, ignorados = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOrigen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDestino))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                Matcher matcher = patronCodigoPostal.matcher(linea);

                if (matcher.find()) {
                    String codigoPostal = matcher.group(1);

                    if (codigoPostal.startsWith("6")) {
                        bw.write(linea);
                        bw.newLine();
                        copiados++;
                    } else {
                        ignorados++;
                    }
                } else {
                    ignorados++;
                }
            }

            System.out.println("Copia creada correctamente");
            System.out.println("Lineas copiadas: " + copiados);
            System.out.println("Lineas ignoradas: " + ignorados);

        } catch (IOException e) {
            System.err.println("Error procesando los archivos: " + e.getMessage());
        }
    }
}
