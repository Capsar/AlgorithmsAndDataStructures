package graph;

import java.util.*;
import java.util.stream.Collectors;

public class GraphImpl implements GraphIterator.Graph {

    private Set<GraphIterator.Vertex> vertices = new HashSet<>();
    private Set<Map.Entry<GraphIterator.Vertex, GraphIterator.Vertex>> edges = new HashSet<>();

    @Override
    public List<GraphIterator.Vertex> getNeighbours(GraphIterator.Vertex v) {
        return edges.stream()
                .filter(entry -> Objects.equals(entry.getKey(), v) || Objects.equals(entry.getValue(), v))
                .map(entry -> Objects.equals(entry.getKey(), v) ? entry.getValue() : entry.getKey())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<GraphIterator.Vertex> getAllVertices() {
        return new HashSet<>(vertices);
    }

    public void addVertex(GraphIterator.Vertex v) {
        vertices.add(v);
    }

    public void addEdge(GraphIterator.Vertex v, GraphIterator.Vertex w) {
        edges.add(new AbstractMap.SimpleEntry<>(v, w));
    }
}
