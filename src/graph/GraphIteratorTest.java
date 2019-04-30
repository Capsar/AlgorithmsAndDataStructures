package graph;

import org.junit.*;

import java.util.*;

public class GraphIteratorTest {
    @Test
    public void testDoubleVertex() {
        GraphImpl g = new GraphImpl();
        GraphIterator.Vertex v = new VertexImpl(0);
        GraphIterator.Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        Iterator<GraphIterator.Vertex> it = new GraphIterator(g, v);
        Assert.assertSame(v, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertSame(w, it.next());
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        GraphIterator.Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        Iterator<GraphIterator.Vertex> it = new GraphIterator(g, v);
        Assert.assertTrue(it.hasNext());
        Assert.assertSame(v, it.next());
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testSingleLoopingVVertex() {
        GraphImpl g = new GraphImpl();
        GraphIterator.Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        Assert.assertEquals(1, GraphIterator.numberOfConnectedComponents(g));
    }

    @Test
    public void testNotPossibleGraph() {
        GraphImpl g = new GraphImpl();
        GraphIterator.Vertex v = new VertexImpl(0);
        GraphIterator.Vertex z = new VertexImpl(3);
        g.addVertex(v);
        g.addVertex(z);
        Assert.assertEquals(2, GraphIterator.numberOfConnectedComponents(g));
    }
}
//
