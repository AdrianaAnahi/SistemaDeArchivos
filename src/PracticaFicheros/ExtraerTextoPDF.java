/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaFicheros;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author Adriana Chiluiza
 */
public class ExtraerTextoPDF {

    public static void main(String[] args) {
        String archivoPDF = "data/documento.pdf";  
        String archivoTexto = "data/salida.txt";

        try (FileInputStream fis = new FileInputStream(archivoPDF);
             FileOutputStream fos = new FileOutputStream(archivoTexto)) {

            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                // Filtrar caracteres: ASCII 32 a 127, y 10, 13
                if ((byteLeido >= 32 && byteLeido <= 127) || byteLeido == 10 || byteLeido == 13) {
                    fos.write(byteLeido);
                }
            }

            System.out.println("Archivo texto con caracteres filtrados creado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}

    
