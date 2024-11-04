package day_22_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {
    private final List<Vertex> vertexList;

    public Graph(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    public void addVertex(Vertex vertex) {
        vertexList.add(vertex);
    }

    public List<Vertex> dfsAlgorithm() {
        List<Vertex> path = new ArrayList<>();

        Stack<Vertex> queue = new Stack<>();
        Vertex start = vertexList.getFirst();

        queue.add(start);
        start.setVisited(true);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.pop();

            System.out.println("Jsem " + vertex);
            path.add(vertex);

            List<Vertex> neighbors = vertex.getNeighbors();
            for (Vertex neighbor : neighbors) {
                if (!neighbor.wasVisitedCheck()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
                System.out.println(" a mám souseda " + neighbor);
            }
        }

        for (Vertex v : vertexList) {
            v.setVisited(false);
        }

        return path;
    }
}
