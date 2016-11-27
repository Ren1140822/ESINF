/*
* A collection of graph algorithms.
 */
package graphbase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author DEI-ESINF
 */
public class GraphAlgorithms {

    /**
     * Performs breadth-first search of a Graph starting in a Vertex
     *
     * @param g Graph instance
     * @param vInf information of the Vertex that will be the source of the
     * search
     * @return qbfs a queue with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert) {

        if (!g.validVertex(vert)) {
            return null;
        }

        LinkedList<V> qbfs = new LinkedList<>();
        LinkedList<V> qaux = new LinkedList<>();
        boolean[] visited = new boolean[g.numVertices()];  //default initializ.: false

        qbfs.add(vert);
        qaux.add(vert);
        int vKey = g.getKey(vert);
        visited[vKey] = true;

        while (!qaux.isEmpty()) {
            vert = qaux.remove();
            for (Edge<V, E> edge : g.outgoingEdges(vert)) {
                V vAdj = g.opposite(vert, edge);
                vKey = g.getKey(vAdj);
                if (!visited[vKey]) {
                    qbfs.add(vAdj);
                    qaux.add(vAdj);
                    visited[vKey] = true;
                }
            }
        }
        return qbfs;
    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param visited set of discovered vertices
     * @param qdfs queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs) {

        visited[g.getKey(vOrig)] = true;

        for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
            V vAdj = g.opposite(vOrig, edge);
            int vKey = g.getKey(vAdj);
            if (!visited[vKey]) {
                qdfs.add(vAdj);
                DepthFirstSearch(g, vAdj, visited, qdfs);
            }
        }
    }

    /**
     * @param g Graph instance
     * @param vInf information of the Vertex that will be the source of the
     * search
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {

        if (!g.validVertex(vert)) {
            return null;
        }

        LinkedList<V> qdfs = new LinkedList<V>();
        qdfs.add(vert);
        boolean[] knownVertices = new boolean[g.numVertices()];
        DepthFirstSearch(g, vert, knownVertices, qdfs);
        return qdfs;
    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param visited set of discovered vertices
     * @param qdfs queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearchWithLimit(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs, int value, int limit) throws NullPointerException {
        visited[g.getKey(vOrig)] = true;

        for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
            V vAdj = g.opposite(vOrig, edge);
            int vKey = g.getKey(vAdj);
            if (!visited[vKey] && value <= limit) {
                value++;
                qdfs.add(vAdj);
                DepthFirstSearchWithLimit(g, vAdj, visited, qdfs, value, limit);
            }
        }
    }

    /**
     * @param g Graph instance
     * @param vInf information of the Vertex that will be the source of the
     * search
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearchWithLimit(Graph<V, E> g, V vert, int limit) {
        if (!g.validVertex(vert)) {
            return null;
        }

        LinkedList<V> qdfs = new LinkedList<V>();
        qdfs.add(vert);
        boolean[] knownVertices = new boolean[g.numVertices()];
        DepthFirstSearchWithLimit(g, vert, knownVertices, qdfs, 0, limit + 1);
        qdfs.removeFirst();
        return qdfs;
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param vDest Vertex that will be the end of the path
     * @param visited set of discovered vertices
     * @param path stack with vertices of the current path (the path is in
     * reverse order)
     * @param paths ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest, boolean[] visited,
            LinkedList<V> path, ArrayList<LinkedList<V>> paths) throws NullPointerException {
        visited[g.getKey(vOrig)] = true;
        path.add(vOrig);
        for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
            if (edge.getVDest().equals(vDest)) {
                path.add(vDest);
                paths.add(path);
                path.removeLast();

            } else if (visited[g.getKey(edge.getVDest())] == false) {

                allPaths(g, edge.getVDest(), vDest, visited, path, paths);
            }
        }
        visited[g.getKey(vOrig)] = false;
        path.removeLast();
    }

    /**
     * @param g Graph instance
     * @param voInf information of the Vertex origin
     * @param vdInf information of the Vertex destination
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {

        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        boolean visited[] = new boolean[500];
        LinkedList<V> path = new LinkedList();
        allPaths(g, vOrig, vDest, visited, path, paths);
        return paths;
    }

    public static <V, E>  LinkedList<V> graphCentrality(Graph<V, E> g) {
           LinkedList<V> returnVertexes  = new LinkedList<>();
        LinkedList<V> path = new LinkedList<>();
        int numVert = g.numVertices();
        V[] vertices = (V[]) g.allkeyVerts().clone();
        Map<V,Double> biggestShortestPath = new HashMap<>();
        for (V v : g.vertices()) {
            boolean visited[] = new boolean[numVert];
            int[] pathKeys = new int[numVert];
            double[] dist = new double[numVert];
            shortestPathLength(g, v, vertices, visited, pathKeys, dist);
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    if (dist[i] >dist[j]) {
                        if (biggestShortestPath.containsKey(v)) {
                            if (biggestShortestPath.get(v).intValue() <dist[i]) {
                                biggestShortestPath.remove(v);
                            }
                            biggestShortestPath.putIfAbsent(v, dist[i]);
                        } else {
                            biggestShortestPath.putIfAbsent(v,dist[i]);
                        }

                    }
                }
            }
        }
        Double aux = Double.POSITIVE_INFINITY;
        V returnVertex = null;
        for (V v : biggestShortestPath.keySet()) {
            if (biggestShortestPath.get(v) < aux) {
                aux = biggestShortestPath.get(v).doubleValue();
                returnVertex = v;
            }
        }
          for (V v : biggestShortestPath.keySet()) {
              if(biggestShortestPath.get(v).doubleValue() == aux)
              {
                  returnVertexes.add(v);
              }
          }
        return returnVertexes;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with nonnegative edge weights This implementation
     * uses Dijkstra's algorithm
     *
     * @param g Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param visited set of discovered vertices
     * @param pathkeys minimum path vertices keys
     * @param dist minimum distances
     */
    private static <V, E> void shortestPathLength(Graph<V, E> g, V vOrig, V[] vertices, boolean[] visited, int[] pathKeys, double[] dist) {

        for (V v : vertices) {
            dist[g.getKey(v)] = Double.POSITIVE_INFINITY;
            pathKeys[g.getKey(v)] = -1;
            visited[g.getKey(v)] = false;
        }

        dist[g.getKey(vOrig)] = 0;

        while (vOrig != null) {
            int vOrigValue = g.getKey(vOrig);
            visited[vOrigValue] = true;

            for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
                V vAdj = g.opposite(vOrig, edge);
                if (!visited[g.getKey(vAdj)] && dist[g.getKey(vAdj)] > dist[vOrigValue] + edge.getWeight()) {
                    dist[g.getKey(vAdj)] = dist[vOrigValue] + edge.getWeight();
                    pathKeys[g.getKey(vAdj)] = vOrigValue;
                }
            }

            vOrig = null;
            double minimunDistance = Double.POSITIVE_INFINITY;

            for (V ver : vertices) {
                int vId = g.getKey(ver);
                if (visited[vId] == false && dist[vId] < minimunDistance) {
                    vOrig = ver;
                    minimunDistance = dist[vId];
                }
            }
        }
    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf The path
     * is constructed from the end to the beginning
     *
     * @param g Graph instance
     * @param voInf information of the Vertex origin
     * @param vdInf information of the Vertex destination
     * @param pathkeys minimum path vertices keys
     * @param path stack with the minimum path (correct order)
     */
    private static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path) {

        int vDestID = g.getKey(vDest);

        int prevID = pathKeys[vDestID];
        V prevV = null;

        for (V v : verts) {
            if (g.getKey(v) == prevID) {
                prevV = v;
            }
        }
        path.add(vDest);

        if (!vOrig.equals(vDest)) {
            getPath(g, vOrig, prevV, verts, pathKeys, path);
        }
    }

    //shortest-path between voInf and vdInf
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {

        if (!g.validVertex(vOrig) || !g.validVertex(vDest)) {
            return -1d;
        }

        int numVert = g.numVertices();

        V[] vertices = (V[]) g.allkeyVerts().clone();
        boolean visited[] = new boolean[numVert];
        int[] pathKeys = new int[numVert];
        double[] dist = new double[numVert];

        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);
        shortPath.clear();
        if (!visited[g.getKey(vDest)]) {
            return -1d;
        }
        getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);

        LinkedList<V> pathInOrder = revPath(shortPath);
        shortPath.clear();
        while (!pathInOrder.isEmpty()) {
            shortPath.add(pathInOrder.removeFirst());
        }

        int vDestId = g.getKey(vDest);
        if (!visited[vDestId]) {
            return -1d;
        }
        return dist[vDestId];
    }

    /**
     * Reverses the path
     *
     * @param path stack with path
     */
    private static <V, E> LinkedList<V> revPath(LinkedList<V> path) {

        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();

        while (!pathcopy.isEmpty()) {
            pathrev.push(pathcopy.pop());
        }

        return pathrev;
    }

    private static <V, E> void getCommonDirectVertices(Graph<V, E> g, V v1, V v2, LinkedList<V> qdfs) {

        for (Edge<V, E> edge : g.outgoingEdges(v1)) {
            for (Edge<V, E> edge2 : g.outgoingEdges(v2)) {
                if (edge.getVDest().equals(edge2.getVDest())) {
                    if (!qdfs.contains(edge.getVDest())) {
                        qdfs.add(edge.getVDest());
                    }
                }
            }
        }
    }

    public static <V, E> LinkedList<V> getCommonDirectVertices(Graph<V, E> g, V vert, V vert2) {
        if (!g.validVertex(vert) || !g.validVertex(vert2)) {
            return null;
        }

        LinkedList<V> qdfs = new LinkedList<V>();

        getCommonDirectVertices(g, vert, vert2, qdfs);

        return qdfs;
    }
}
