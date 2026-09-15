/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaFicheros;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
/**
 *
 * @author Adriana Chiluiza
 */
public class ArchivoBMP {

    public static void main(String[] args) {
        String ruta = "data\\paisaje.bmp"; // Cambia esta ruta según tu archivo BMP

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("El archivo no existe");
            return;
        }

        try (RandomAccessFile raf = new RandomAccessFile(archivo, "r")) {

            // Leer los primeros 54 bytes (cabecera completa)
            byte[] cabecera = new byte[54];
            raf.readFully(cabecera);  // lectura en una sola orden

            // Accedemos al byte 30 (posición 30 empezando desde 0)
            int compresion = Byte.toUnsignedInt(cabecera[30]);

            System.out.println("Byte 30: " + compresion);

            if (compresion == 0) {
                System.out.println("Imagen NO COMPRIMIDA");
            } else {
                System.out.println("Imagen Comprimida (tipo: " + compresion + ")");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo BMP: " + e.getMessage());
        }
    }
}


