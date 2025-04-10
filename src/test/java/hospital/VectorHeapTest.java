package hospital;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VectorHeapTest {

    @Test
    public void testAddAndRemovePaciente() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        Paciente p1 = new Paciente("Paciente A", "Dolor leve", 'C');
        Paciente p2 = new Paciente("Paciente B", "Emergencia", 'A');

        heap.add(p1);
        heap.add(p2);

        // El paciente con prioridad 'A' debe salir primero
        assertEquals(p2, heap.remove());
        assertEquals(p1, heap.remove());
        assertTrue(heap.isEmpty());
    }
}
