package grafy_a_hry;

import java.util.HashMap;
import java.util.Map;

public class NodeTable {

    private final Map<Vertex, Integer> vertexPathLengthMap = new HashMap<>();
    private final Map<Vertex, Vertex> vertexPreviousVertexMap = new HashMap<>();

    void addVertex(Vertex v, int priority, Vertex previous) {
        vertexPathLengthMap.put(v, priority);
        vertexPreviousVertexMap.put(v, previous);
    }

    int findPathLength(Vertex v) {
        return vertexPathLengthMap.get(v);
    }

    Vertex findPreviousVertex(Vertex v) {
        return vertexPreviousVertexMap.get(v);
    }

    boolean doesMapContainVertex(Vertex v) {
        return vertexPathLengthMap.containsKey(v);
    }
}
