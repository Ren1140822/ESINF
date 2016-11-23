/*
* A collection of graph algorithms.
 */
package graphbase;

import java.util.ArrayList;
import java.util.LinkedList;

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
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs) throws NullPointerException {
        qdfs.add(vOrig);

        visited[g.getKey(vOrig)] = true;

        for (Edge<V, E> e : g.outgoingEdges(vOrig)) {
            if (!visited[g.getKey(e.getVDest())]) {
                DepthFirstSearch(g, e.getVDest(), visited, qdfs);
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
        LinkedList<V> list = new LinkedList<>();
        boolean[] visited = new boolean[550];
        try {
            DepthFirstSearch(g, vert, visited, list);
        } catch (NullPointerException ex) {
            return null;
        }
        return list;
    }
  /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param visited set of discovered vertices
     * @param qdfs queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearchWithLimit(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs,int value,int limit) throws NullPointerException {
        qdfs.add(vOrig);
        
        visited[g.getKey(vOrig)] = true;
        
        for (Edge<V, E> e : g.outgoingEdges(vOrig)) {
            if (!visited[g.getKey(e.getVDest())] && value<=limit) {
                value++;
                DepthFirstSearchWithLimit(g, e.getVDest(), visited, qdfs,value,limit);
            }
        }
    }
    /**
     * @param g Graph instance
     * @param vInf information of the Vertex that will be the source of the
     * search
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearchWithLimit(Graph<V, E> g, V vert,int limit) {
        LinkedList<V> list = new LinkedList<>();
        boolean[] visited = new boolean[550];
        try {
            DepthFirstSearchWithLimit(g, vert, visited, list,0,limit);
        } catch (NullPointerException ex) {
            return null;
        }
        return list;
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

      
    /**
   * Computes shortest-path distance from a source vertex to all reachable 
   * vertices of a graph g with nonnegative edge weights
   * This implementation uses Dijkstra's algorithm
   * @param g Graph instance
   * @param vOrig Vertex that will be the source of the path
   * @param visited set of discovered vertices
   * @param pathkeys minimum path vertices keys  
   * @param dist minimum distances
   */
    private static<V,E> void shortestPathLength(Graph<V,E> g, V vOrig, V[] vertices,
                                    boolean[] visited, int[] pathKeys, double[] dist){   
        
      for(V v: vertices){
            dist[g.getKey(v)] = Double.POSITIVE_INFINITY;
            pathKeys[g.getKey(v)] = -1;
            visited[g.getKey(v)] = false;
        }
        
        dist[g.getKey(vOrig)] = 0;
        
        while(vOrig != null){
            int vOrigValue = g.getKey(vOrig);
            visited[vOrigValue] = true;
            
            for(Edge<V,E> edge : g.outgoingEdges(vOrig)){
                V vAdj = g.opposite(vOrig, edge);
                if(!visited[g.getKey(vAdj)] && dist[g.getKey(vAdj)] > dist[vOrigValue] + edge.getWeight()){
                    dist[g.getKey(vAdj)] = dist[vOrigValue]+edge.getWeight();
                    pathKeys[g.getKey(vAdj)] = vOrigValue;
                }  
            }
            
            vOrig = null;
            double minimunDistance = Double.POSITIVE_INFINITY;
            
            for(V ver : vertices){
                int vId = g.getKey(ver);
                if (visited[vId] == false && dist[vId] < minimunDistance){
                    vOrig = ver;
                    minimunDistance = dist[vId];
                }
            }
        }  
    }
    
    /**
    * Extracts from pathKeys the minimum path between voInf and vdInf
    * The path is constructed from the end to the beginning
    * @param g Graph instance
    * @param voInf information of the Vertex origin
    * @param vdInf information of the Vertex destination 
    * @param pathkeys minimum path vertices keys  
    * @param path stack with the minimum path (correct order)
    */
    private static<V,E> void getPath(Graph<V,E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path){
    
           int vDestID = g.getKey(vDest);
        
        int prevID = pathKeys[vDestID];
        V prevV = null;
        
        for (V v: verts){
            if(g.getKey(v) == prevID){
                prevV = v;
            }
        }
        path.add(vDest);
        
        if(!vOrig.equals(vDest)){
            getPath(g, vOrig, prevV, verts, pathKeys, path);    
        }
    }

    
    
    
    //shortest-path between voInf and vdInf
    public static<V,E> double shortestPath(Graph<V,E> g, V vOrig, V vDest, LinkedList<V> shortPath){
      
          if(!g.validVertex(vOrig) || !g.validVertex(vDest)){
            return -1d;
        }
        
        int numVert = g.numVertices();
        
        V[] vertices = (V[]) g.allkeyVerts().clone();
        boolean visited[] = new boolean[numVert];
        int[] pathKeys = new int[numVert];
        double[] dist = new double[numVert];
        
        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);
        shortPath.clear();
        if(!visited[g.getKey(vDest)]){
            return -1d;
        }
        getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);
        
        LinkedList<V> pathInOrder = revPath(shortPath);
        shortPath.clear();
        while(!pathInOrder.isEmpty()){
            shortPath.add(pathInOrder.removeFirst());
        }
        
        int vDestId = g.getKey(vDest);
        if(!visited[vDestId]){
            return -1d;
        }
        
        return dist[vDestId];
        
        
    }
   
    /**
     * Reverses the path
     * @param path stack with path
     */
    private static<V,E> LinkedList<V> revPath(LinkedList<V> path){ 
   
       LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();
        
        while (!pathcopy.isEmpty())
            pathrev.push(pathcopy.pop());
        
        return pathrev ;
    }  
}
