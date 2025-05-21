import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    public List<Vertex<V>> getPath(Vertex<V> destination) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> v = destination; v != null; v = parentMap.get(v))
            path.add(0, v);
        return path;
    }
}
