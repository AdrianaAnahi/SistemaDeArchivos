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
public class EncriptarPDF {
 public static void main(String[] args) {  
        String archivoOriginal = "data/documento.pdf";
        String archivoEncriptado = "data/encriptado.pdf";
        String archivoDesencriptado = "data/desencriptado.pdf";

        intercambiarPrimerosBytes(archivoOriginal, archivoEncriptado); //Encriptar

        intercambiarPrimerosBytes(archivoEncriptado, archivoDesencriptado); //Desencriptar
    }

    public static void intercambiarPrimerosBytes(String archivoEntrada, String archivoSalida) {
        try (FileInputStream fis = new FileInputStream(archivoEntrada);
             FileOutputStream fos = new FileOutputStream(archivoSalida)) {

            int byte1 = fis.read();
            int byte2 = fis.read();

            if (byte1 == -1 || byte2 == -1) {
                System.err.println("Archivo pequeño para intercambiar bytes");
                return;
            }

            fos.write(byte2);
            fos.write(byte1);

            int byteActual;
            while ((byteActual = fis.read()) != -1) {
                fos.write(byteActual);
            }

            System.out.println("Archivo procesado: " + archivoSalida);

        } catch (IOException e) {
            System.err.println("Error al procesar archivos: " + e.getMessage());
        }
    }
}

   
