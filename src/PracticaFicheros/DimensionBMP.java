/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaFicheros;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Adriana Chiluiza
 */
public class DimensionBMP {

    public static void main(String[] args) {
        String ruta = "data\\paisaje.bmp"; 

        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            raf.seek(18);
            int ancho = leerEnteroLittleEndian(raf);

            raf.seek(22);
            int alto = leerEnteroLittleEndian(raf);

            System.out.println("Dimensiones de la imagen BMP:");
            System.out.println("Ancho: " + ancho + " pixeles");
            System.out.println("Alto : " + alto + " pixeles");

        } catch (IOException e) {
            System.err.println("Error leyendo el archivo BMP: " + e.getMessage());
        }
    }

    public static int leerEnteroLittleEndian(RandomAccessFile raf) throws IOException {
        int b1 = raf.readUnsignedByte();
        int b2 = raf.readUnsignedByte();
        int b3 = raf.readUnsignedByte();
        int b4 = raf.readUnsignedByte();
        return (b4 << 24) | (b3 << 16) | (b2 << 8) | b1;
    }
}

  
