package day_22_10;
import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private final String name;
    private boolean wasVisited;
    private final List<Vertex> neighbors;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }

    public void addNeighbor(Vertex neighbor) {
        neighbors.add(neighbor);
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public boolean wasVisitedCheck() {
        return wasVisited;
    }

    public void setVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
