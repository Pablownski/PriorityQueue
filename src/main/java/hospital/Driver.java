package hospital;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        VectorHeap<Paciente> heapPacientes = new VectorHeap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                String sintoma = partes[1].trim();
                char prioridad = partes[2].trim().charAt(0);
                heapPacientes.add(new Paciente(nombre, sintoma, prioridad));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Orden de atención de pacientes:");
        while (!heapPacientes.isEmpty()) {
            System.out.println(heapPacientes.remove());
        }
    }
}
