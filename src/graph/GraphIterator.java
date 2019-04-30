package graph;

import java.util.*;

/**
 * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
 * should return nodes at most once. If there is a choice between multiple next nodes,
 * always pick the lowest id node.
 */
public class GraphIterator implements Iterator<GraphIterator.Vertex> {
    private Graph g;
    private Vertex v;
    private Stack<Vertex> stack;
    private Set<Vertex> colored;
    private int graphSize;

    public static void main(String... args) {
        GraphImpl g = new GraphImpl();
        GraphIterator.Vertex[] v = new VertexImpl[13];
        for(int i = 0; i < 12; i++) {
            v[i] = new VertexImpl(i);
            g.addVertex(v[i]);
        }
        g.addEdge(v[0], v[1]);
        g.addEdge(v[1], v[2]);
        g.addEdge(v[2], v[3]);
        g.addEdge(v[3], v[7]);
        g.addEdge(v[3], v[6]);
        g.addEdge(v[3], v[8]);
        g.addEdge(v[2], v[4]);
        g.addEdge(v[4], v[8]);
        g.addEdge(v[4], v[9]);
        g.addEdge(v[0], v[10]);
        g.addEdge(v[10], v[11]);
        GraphIterator gi = new GraphIterator(g, v[0]);
        while(gi.hasNext()) {
            System.out.println(gi.next().getId());
        }

    }

    public GraphIterator(Graph g, Vertex v) {
        this.g = g;
        this.v = v;
        stack = new Stack<Vertex>();
        colored = new TreeSet<Vertex>();
        graphSize = g.getAllVertices().size();
    }

    @Override
    public boolean hasNext() {
        if (v != null && stack.isEmpty() && colored.isEmpty())
            return true;
        if (g == null || v == null || stack.isEmpty())
            return false;

        Vertex vertex = stack.peek();
        Vertex nextLowestNeighbour = lowest(vertex);

        if (nextLowestNeighbour != null) {
            return true;
        } else {
            while(nextLowestNeighbour == null && !stack.isEmpty()) {
                nextLowestNeighbour = lowest(stack.peek());
                if(nextLowestNeighbour == null)
                    stack.pop();

            }
            if (nextLowestNeighbour != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Vertex next() {
        if (g == null || v == null)
            return null;
        if (stack.empty() && colored.isEmpty()) {
            stack.add(v);
            colored.add(v);
            return v;
        }

        Vertex vertex = stack.peek();
        Vertex nextLowestNeighbour = lowest(vertex);
        if(nextLowestNeighbour != null) {
           stack.add(nextLowestNeighbour);
           colored.add(nextLowestNeighbour);
           return nextLowestNeighbour;
        } else  {
            while(nextLowestNeighbour == null && !stack.isEmpty()) {
                nextLowestNeighbour = lowest(stack.pop());
            }
            if (nextLowestNeighbour != null) {
                stack.add(nextLowestNeighbour);
                colored.add(nextLowestNeighbour);
                return nextLowestNeighbour;
            }
        }
        return null;
    }

    private Vertex lowest(Vertex vertex) {
        List<Vertex> neighbours = g.getNeighbours(vertex);
        Vertex lowest = null;
        for (int i = 0; i < neighbours.size(); i++) {
            Vertex vv = neighbours.get(i);
            if(vv == null || colored.contains(vv))
                continue;
            if (lowest == null)
                lowest = vv;

            if (vv.getId() < lowest.getId())
                lowest = vv;
        }
        return lowest;
    }

    public static int numberOfConnectedComponents(Graph g) {
        int n = 0;
        Collection<Vertex> undiscovered = (Collection<Vertex>) g.getAllVertices();

        if(undiscovered.size() == 0)
            return 0;
        GraphIterator gi = new GraphIterator(g, undiscovered.iterator().next());
        while(undiscovered.iterator().hasNext()) {
            while(gi.hasNext()) {
                undiscovered.remove(gi.next());
            }
            n++;
        }
        return n;
    }

    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
        List<Vertex> list = new ArrayList<Vertex>();
        Map<Vertex, Vertex> predecessors = new TreeMap<>();
        GraphIterator gi = new GraphIterator(g, v);
        if (g.getAllVertices().size() == 0 || v == null || u == null)
            return list;
        Vertex pre = gi.next();
        if (v == u) {
            list.add(pre);
            return list;
        }
        boolean found = false;
        while (gi.hasNext()) {
            Vertex next = gi.next();
            if (next == u) {
                found = true;
                predecessors.put(next, pre);
                break;
            }

            if (gi.hasNext()) {
                while (g.getNeighbours(pre).contains(next)) {
                    predecessors.put(next, pre);
                    next = gi.next();
                }
                for (Vertex nv : g.getNeighbours(next)) {
                    if (predecessors.containsKey(nv)) {
                        pre = nv;
                        break;
                    }
                }
                predecessors.put(next, pre);
                if (next == u) {
                    found = true;
                    break;
                }
            }
        }
        if (!found)
            return new ArrayList<Vertex>();

        for(Map.Entry<Vertex, Vertex> entry : ((TreeMap<Vertex, Vertex>) predecessors).entrySet()) {
            Vertex vv = entry.getKey();
            Vertex ww = entry.getValue();
            System.out.println("|" + vv.getId() + ":" + ww.getId() + "| ");
        }

        Vertex key = ((TreeMap<Vertex, Vertex>) predecessors).lastKey();
        while (key != v) {
            list.add(key);
            Vertex predecessor = predecessors.get(key);
            key = predecessor;
        }
        list.add(key);
        List<Vertex> newList = new ArrayList<Vertex>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }


    public interface Vertex {
        int getId();
    }

    public interface Graph {
        // Gets neighbours of v in this Graph
        public List<Vertex> getNeighbours(Vertex v);

        // Gets all vertices of this Graph
        public Collection<Vertex> getAllVertices();
    }
}

