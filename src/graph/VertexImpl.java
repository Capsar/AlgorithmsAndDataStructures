package graph;

import java.util.Objects;

public class VertexImpl implements GraphIterator.Vertex, Comparable<GraphIterator.Vertex>{
    int id;

    public VertexImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(GraphIterator.Vertex o) {
        Objects.requireNonNull(o);
        return Integer.compare(this.getId(), o.getId());
    }
}
