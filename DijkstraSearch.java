import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Double> distances = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distances.get(current) + weight;
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    parentMap.put(neighbor, current);
                    pq.add(neighbor);
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
