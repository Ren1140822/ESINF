package graphMapAdj;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DEI-ESINF
 * @param <V>
 * @param <E>
 */
public class Graph<V, E> implements GraphInterface<V, E> {

    private int numVert;
    private int numEdge;
    private boolean isDirected;
    private Map<V, Vertex<V, E>> vertices;  //all Vertices of the graph 

    // Constructs an empty graph (either undirected or directed)
    public Graph(boolean directed) {
        numVert = 0;
        numEdge = 0;
        isDirected = directed;
        vertices = new LinkedHashMap<>();
    }

    public int numVertices() {
        return numVert;
    }

    public Iterable<V> vertices() {
        return vertices.keySet();
    }

    public boolean validVertex(V vert) {

        if (vertices.get(vert) == null) {
            return false;
        }

        return true;
    }

    public int getKey(V vert) {
    
        return vertices.get(vert).getKey();
    }

    public V[] allkeyVerts() {

        V[] keyverts = (V[]) new Object[numVert];

        for (Vertex<V, E> vert : vertices.values()) {
            keyverts[vert.getKey()] = vert.getElement();
        }

        return keyverts;
    }

    public int numEdges() {
        return numEdge;
    }

    public Iterable<Edge<V, E>> edges() {
        LinkedList<Edge<V, E>> list = new LinkedList();
        for (Vertex<V, E> ver : vertices.values()) {
            for (V v : ver.getAllAdjVerts()) {
                list.add(ver.getEdge(v));
            }

        }
        return list;
    }

    public Edge<V, E> getEdge(V vOrig, V vDest) {

        if (!validVertex(vOrig) || !validVertex(vDest)) {
            return null;
        }

        Vertex<V, E> vorig = vertices.get(vOrig);

        return vorig.getEdge(vDest);
    }

    public V[] endVertices(Edge<V, E> edge) {

        if (edge == null) {
            return null;
        }

        if (!validVertex(edge.getVOrig()) || !validVertex(edge.getVDest())) {
            return null;
        }

        Vertex<V, E> vorig = vertices.get(edge.getVOrig());

        if (!edge.equals(vorig.getEdge(edge.getVDest()))) {
            return null;
        }

        return edge.getEndpoints();
    }

    public V opposite(V vert, Edge<V, E> edge) {

        if (!validVertex(vert)) {
            return null;
        }

        Vertex<V, E> vertex = vertices.get(vert);

        return vertex.getAdjVert(edge);
    }

    public int outDegree(V vert) {

        if (!validVertex(vert)) {
            return -1;
        }

        Vertex<V, E> vertex = vertices.get(vert);

        return vertex.numAdjVerts();
    }

    public int inDegree(V vert) {

        if (!validVertex(vert)) {
            return -1;
        }

        int degree = 0;
        for (V otherVert : vertices.keySet()) {
            if (getEdge(otherVert, vert) != null) {
                degree++;
            }
        }

        return degree;
    }

    public Iterable<Edge<V, E>> outgoingEdges(V vert) {

        if (!validVertex(vert)) {
            return null;
        }

        Vertex<V, E> vertex = vertices.get(vert);

        return vertex.getAllOutEdges();
    }

    public Iterable<Edge<V, E>> incomingEdges(V vert) {

        if (!validVertex(vert)) {
            return null;
        }

        Vertex<V, E> vertex = vertices.get(vert);
        LinkedList<Edge<V, E>> list = new LinkedList();

        for (Vertex<V, E> ver : vertices.values()) {
            for (Edge<V, E> edge : ver.getAllOutEdges()) {
                if (edge.getVDest().equals(vertex.getElement())) {
                    list.add(edge);
                }
            }

        }
        return list;

    }

    public boolean insertVertex(V vert) {

        if (validVertex(vert)) {
            return false;
        }

        Vertex<V, E> vertex = new Vertex<>(numVert, vert);
        vertices.put(vert, vertex);
        numVert++;

        return true;
    }

    public boolean insertEdge(V vOrig, V vDest, E eInf, double eWeight) {

        if (getEdge(vOrig, vDest) != null) {
            return false;
        }

        if (!validVertex(vOrig)) {
            insertVertex(vOrig);
        }

        if (!validVertex(vDest)) {
            insertVertex(vDest);
        }

        Vertex<V, E> vorig = vertices.get(vOrig);
        Vertex<V, E> vdest = vertices.get(vDest);

        Edge<V, E> newEdge = new Edge<>(eInf, eWeight, vorig, vdest);
        vorig.addAdjVert(vDest, newEdge);
        numEdge++;

        //if graph is not direct insert other edge in the opposite direction 
        if (!isDirected) // if vDest different vOrig
        {
            if (getEdge(vDest, vOrig) == null) {
                Edge<V, E> otherEdge = new Edge<>(eInf, eWeight, vdest, vorig);
                vdest.addAdjVert(vOrig, otherEdge);
                numEdge++;
            }
        }

        return true;
    }

    public boolean removeVertex(V vert) {

       if (!validVertex(vert)) {
            return false;
        }
       vertices.remove(vert);
       return true;
    }

    public boolean removeEdge(V vOrig, V vDest) {

        if (!validVertex(vOrig) || !validVertex(vDest)) {
            return false;
        }

        Edge<V, E> edge = getEdge(vOrig, vDest);

        if (edge == null) {
            return false;
        }

        Vertex<V, E> vorig = vertices.get(vOrig);

        vorig.remAdjVert(vDest);
        numEdge--;

        //if graph is not direct 
        if (!isDirected) {
            edge = getEdge(vDest, vOrig);
            if (edge != null) {
                Vertex<V, E> vdest = vertices.get(vDest);
                vdest.remAdjVert(vOrig);
                numEdge--;
            }
        }
        return true;
    }

    //Returns a clone of the graph 
    public Graph<V, E> clone() {

        Graph<V, E> newObject = new Graph<>(this.isDirected);

        //insert all vertices
        for (V vert : vertices.keySet()) {
            newObject.insertVertex(vert);
        }

        //insert all edges
        for (V vert1 : vertices.keySet()) {
            for (Edge<V, E> e : this.outgoingEdges(vert1)) {
                if (e != null) {
                    V vert2 = this.opposite(vert1, e);
                    newObject.insertEdge(vert1, vert2, e.getElement(), e.getWeight());
                }
            }
        }

        return newObject;
    }

    /* equals implementation
     * @param the other graph to test for equality
     * @return true if both objects represent the same graph
     */
    public boolean equals(Object otherObj) {

        if (otherObj == null) {
            return false;
        }

        if (this == otherObj) {
            return true;
        }

        if (!(otherObj instanceof Graph<?, ?>)) {
            return false;
        }

        Graph<V, E> otherGraph = (Graph<V, E>) otherObj;

        if (numVert != otherGraph.numVertices() || numEdge != otherGraph.numEdges()) {
            return false;
        }

        //graph must have same vertices
        boolean eqvertex;
        for (V v1 : this.vertices()) {
            eqvertex = false;
            for (V v2 : otherGraph.vertices()) {
                if (v1.equals(v2)) {
                    eqvertex = true;
                }
            }

            if (!eqvertex) {
                return false;
            }
        }

        //graph must have same edges
        boolean eqedge;
        for (Edge<V, E> e1 : this.edges()) {
            eqedge = false;
            for (Edge<V, E> e2 : otherGraph.edges()) {
                if (e1.equals(e2)) {
                    eqedge = true;
                }
            }

            if (!eqedge) {
                return false;
            }
        }

        return true;
    }

    //string representation
    @Override
    public String toString() {
        String s = "";
        if (numVert == 0) {
            s = "\nGraph not defined!!";
        } else {
            s = "Graph: " + numVert + " vertices, " + numEdge + " edges\n";
            for (Vertex<V, E> vert : vertices.values()) {
                s += vert + "\n";
            }
        }
        return s;
    }
}