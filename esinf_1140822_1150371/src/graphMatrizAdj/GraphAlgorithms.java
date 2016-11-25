
package graphMatrizAdj;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * Implementation of graph algorithms for a (undirected) graph structure 
 * Considering generic vertex V and edge E types
 * 
 * Works on AdjancyMatrixGraph objects
 * 
 * @author DEI-ESINF
 * 
 */
public class GraphAlgorithms {

    private static <T> LinkedList<T> reverse(LinkedList <T> list){
        LinkedList<T> reversed = new LinkedList<>();
        Iterator<T> it = list.iterator();
        while(it.hasNext()) reversed.push(it.next());
        return reversed;
    }

    /**
     * Performs depth-first search of the graph starting at vertex.
     * Calls package recursive version of the method.
     *
     * @param graph Graph object
     * @param vertex Vertex of graph that will be the source of the search
     * @return queue of vertices found by search (including vertex), null if vertex does not exist
     *
     */
    public static <V,E> LinkedList<V> DFS(AdjacencyMatrixGraph<V,E> graph, V vertex) {

        int index = graph.toIndex(vertex);
        if (index == -1)
            return null;

        LinkedList<V> resultQueue = new LinkedList<>();
        resultQueue.add(vertex);
        boolean [] knownVertices = new boolean[graph.numVertices];
        DFS(graph, index, knownVertices, resultQueue);
        return resultQueue;
    }

    /**
     * Actual depth-first search of the graph starting at vertex.
     * The method adds discovered vertices (including vertex) to the queue of vertices
     *
     * @param graph Graph object
     * @param index Index of vertex of graph that will be the source of the search
     * @param known previously discovered vertices
     * @param verticesQueue queue of vertices found by search
     *
     */
    static <V,E> void DFS(AdjacencyMatrixGraph<V,E> graph, int index, boolean [] knownVertices, LinkedList<V> verticesQueue) {
        knownVertices[index] = true;                              
        for (int i = 0 ; i < graph.numVertices ; i++) {     
            if(graph.edgeMatrix[index][i] != null && knownVertices[i] == false){
                verticesQueue.add(graph.vertices.get(i));
                DFS(graph, i, knownVertices, verticesQueue);
            }
        }
    }

    /**
     * Performs breath-first search of the graph starting at vertex.
     * The method adds discovered vertices (including vertex) to the queue of vertices
     *	
     * @param graph Graph object
     * @param vertex Vertex of graph that will be the source of the search
     * @return queue of vertices found by search (including vertex), null if vertex does not exist
     *
     */
    public static <V,E> LinkedList<V> BFS(AdjacencyMatrixGraph<V,E> graph, V vertex) {
        int index = graph.toIndex(vertex);
        if (index == -1) return null;
        
        LinkedList<V> resultQueue = new LinkedList<>();
        LinkedList<V> auxiliarQueue = new LinkedList<>();
        resultQueue.add(vertex);
        auxiliarQueue.add(vertex);
        boolean [] visited = new boolean[graph.numVertices];
        visited[index] = true;
        
        while(!auxiliarQueue.isEmpty()){
            auxiliarQueue.remove(vertex);
            
            for(int i = 0; i < graph.outDegree(vertex); i++){
                V adjacentVertex = graph.endVertices(graph.edgeMatrix[index][i])[1];
                if(visited[i] == false){
                    resultQueue.add(adjacentVertex);
                    auxiliarQueue.add(adjacentVertex);
                    index = graph.toIndex(adjacentVertex);
                    visited[i] = true;
                }
            }
        }
        return resultQueue;
    }

    /**
     * All paths between two vertices 
     * Calls recursive version of the method.
     *
     * @param graph Graph object
     * @param VOrig Source vertex of path 
     * @param VDest Destination vertex of path
     * @param path LinkedList with paths (queues)
     * @return false if vertices not in the graph
     * 
     * LinkedList<LinkedList<V>> paths
     * 
     */
    public static <V,E> boolean allPaths(AdjacencyMatrixGraph<V,E> graph, V VOrig, V VDest, LinkedList<LinkedList<V>> paths, boolean[] visited, int cont) {
        int index = graph.toIndex(VOrig);
        if (index == -1) return false;
        
        visited[index] = true;
        LinkedList<V> path = new LinkedList<>();        
        for(int i = 0; i < index; i++){
            V VAdj = graph.endVertices(graph.edgeMatrix[index][i])[1];
            if(VDest == VAdj){
                path.push(VDest);
                paths.add(path);
                path.pop();
                cont++;
            }
            else if(visited[graph.toIndex(VAdj)] == false) allPaths(graph, VAdj, VDest, paths, visited, cont);
        }
        return visited[index] = false;
    }
    
    
    
    /**
     * Actual paths search 
     * The method adds vertices to the current path (stack of vertices)
     * when destination is found, the current path is saved to the list of paths 
     *
     * @param graph Graph object
     * @param sourceIdx Index of source vertex 
     * @param destIdx Index of destination vertex
     * @param visited previously discovered vertices
     * @param auxStack stack of vertices in the path
     * @param path LinkedList with paths (queues)
     * 
     */
    static <V,E> void allPaths(AdjacencyMatrixGraph<V,E> graph, int VOrigIdx, int VDestIdx, 
                                boolean [] visited, LinkedList<V> auxStack, LinkedList<LinkedList<V>> paths) {
        visited[VOrigIdx] = true;
        auxStack.push(graph.vertices.get(VOrigIdx));
        int index = graph.outDegree(graph.vertices.get(VOrigIdx));
        for(int i = 0; i < index; i++){
            V VAdj = graph.endVertices(graph.edgeMatrix[index][i])[1];
            if(graph.vertices.get(VDestIdx) == VAdj){
                auxStack.push(graph.vertices.get(VDestIdx));
                paths.add(auxStack);
                auxStack.pop();
            }
            else if(visited[graph.toIndex(VAdj)] == false) allPaths(graph, graph.toIndex(VAdj), VDestIdx, visited, auxStack, paths);
        }
        visited[VOrigIdx] = false;
        auxStack.pop();
    }

    /**
     * Transforms a graph into its transitive closure 
     * uses the Floyd-Warshall algorithm
     * 
     * A transitive closure is a matrix with the same vertices as the original
     * graph and an arc between the pairs of vertices that have a path to join them
     * 
     * @param graph Graph object
     * @param dummyEdge object to insert in the newly created edges
     * @return the new graph 
     */
    public static <V, E> AdjacencyMatrixGraph<V, E> transitiveClosure(AdjacencyMatrixGraph<V, E> graph, E dummyEdge){
        
        AdjacencyMatrixGraph<V, E> newGraph = (AdjacencyMatrixGraph<V, E>) graph.clone(); // Clones graph to newGraph
        
        for (int i = 0; i < newGraph.numVertices; i++){ // Rows
            for (int j = 0; j < newGraph.numVertices; j++){ // Columns
                if (i != j && newGraph.edgeMatrix[j][i] != null){ // If V[j] and V[i] are connected and are not the same vertex 
                    for (int k = 0; k < newGraph.numVertices; k++){ // Initializes V[k] to check if V[j] -> V[i] -> V[k] exists in the edge matrix 
                        if(j != k && i != k && newGraph.edgeMatrix[i][k] != null){ // If V[i] and V[k] are connected and are not the same vertex 
                            if(newGraph.edgeMatrix[j][k] == null){ // If the position of the arc is null
                                newGraph.insertEdge(j, k, dummyEdge); // Creates arc
                            }
                        }
                    }
                }
            }
        }
        return newGraph;
    }
}