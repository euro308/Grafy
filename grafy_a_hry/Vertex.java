package grafy_a_hry;
import java.util.*;

public class Vertex {
    private final String name;
    private boolean wasVisited;
    private final Map<Vertex, Integer> neighbors;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    @Override
    public String toString() {
        return name;
    }

    public void addNeighbor(Vertex neighbor, int weight) {
        neighbors.put(neighbor, weight);
    }

    public Map<Vertex, Integer> getNeighbors() {
        return neighbors;
    }

    public int getWeight(Vertex neighbor) {
        return neighbors.get(neighbor);
    }

    public boolean wasVisitedCheck() {
        return wasVisited;
    }

    public void setVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
