package hospital;

import java.util.ArrayList;

/**
 * Implementación de un Heap usando un ArrayList.
 */
public class VectorHeap<E extends Comparable<E>> implements Prioridad<E> {
    protected ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    protected int parent(int i) { return (i - 1) / 2; }
    protected int left(int i) { return 2 * i + 1; }
    protected int right(int i) { return 2 * i + 2; }

    protected void percolateUp(int i) {
        while (i > 0) {
            int parent = parent(i);
            if (data.get(i).compareTo(data.get(parent)) < 0) {
                E temp = data.get(i);
                data.set(i, data.get(parent));
                data.set(parent, temp);
                i = parent;
            } else break;
        }
    }
/**
     * Mueve el elemento en la posición i hacia abajo en el heap.
     * @param i La posición del elemento a mover.
     */
    protected void pushDownRoot(int i) {
        int heapSize = data.size();
        while (i < heapSize) {
            int left = left(i);
            int right = right(i);
            int smallest = i;

            if (left < heapSize && data.get(left).compareTo(data.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < heapSize && data.get(right).compareTo(data.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != i) {
                E temp = data.get(i);
                data.set(i, data.get(smallest));
                data.set(smallest, temp);
                i = smallest;
            } else break;
        }
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }
/**
     * Devuelve el valor mínimo del heap sin eliminarlo.
     * @return El valor mínimo o null si el heap está vacío.
     */
    @Override
    public E remove() {
        if (isEmpty()) return null;
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        if (!isEmpty()) pushDownRoot(0);
        return minVal;
    }
/**
     * Devuelve el valor mínimo del heap sin eliminarlo.
     * @return El valor mínimo o null si el heap está vacío.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
