
package graphMatrizAdj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.User;

/**
 *
 * @author DEI-ESINF
 */
public class EdgeAsDoubleGraphAlgorithms {

    /**
     * Determina o caminho mais curto entre um vértice e todos os outros, usando o algoritmo de Dijkstra
     * 
     * @param graph Grafo
     * @param VOrigIndex Índice do vértice de origem 
     * @param visitedVertices boolean[] que sabe se um vértice já foi visitado ou não
     * @param verticesIndex Índice dos vértices no path mais curto
     * @param minDist distáncias mínimas no path
     *
     */
    private static <V> void shortestPath(AdjacencyMatrixGraph<V,Double> graph, int VOrigIndex, boolean[] visitedVertices, int[] verticesIndex, double [] minDist)	{
        /* Põe todas distâncias mínimas até cada vértice, a infinito*/
        for (int i = 0; i < graph.numVertices; i++){
            minDist[i] = Double.MAX_VALUE;
        }
        minDist[VOrigIndex] = 0; // Distância mínima do vértice de origem é 0 porque a procura começa nele
		while (VOrigIndex != -1){
			visitedVertices[VOrigIndex] = true; // Vértice de origem marcado como visitado

			for (int i = 0; i < graph.numVertices ; i++){ // para todos os vértices do grafo
				if( graph.privateGet(VOrigIndex,i) != null){ // Se a aresta entre o índice do vértice de origem e i existir
					if(!visitedVertices[i] && minDist[i] > minDist[VOrigIndex] + graph.privateGet(VOrigIndex,i)){ // Se i ainda não tiver sido visitado e minDist[i] == infinito 
						minDist[i] = minDist[VOrigIndex] + graph.privateGet(VOrigIndex,i); // minDist[i] = minDist[VOrig] + edge
						verticesIndex[i] = VOrigIndex; // Vértice anterior a i é VOrig
					}
                                }
                        }
			Double min=Double.MAX_VALUE;
			VOrigIndex = -1 ; // Se for o último vértice, termina o ciclo
                        /* Ciclo que torna o índice seguinte no vértice de origem */
			for (int i = 0; i < graph.numVertices; i++){
				if (!visitedVertices[i] && minDist[i] < min){ // Se o vértice não tiver sido visitado e minDist[i] < min
					min = minDist[i]; // min = minDist[i]
					VOrigIndex = i ; // O índice seguinte é o vértice de origem
				}
			}
		}
    }


    /**
     * Determina o caminho mais curto entre dois vértices usando o algoritmo de Dijkstra
     * 
     * @param graph Grafo
     * @param VOrig Vértice de origem
     * @param VDest Vértice de destino
     * @param path LinkedList que contém todos os vértices de um determinado path
     * @return distáncia mínima, -1 se os vértices não estiverem no grafo ou se o path não existir
     *
     */
    public static <V> LinkedList<V> shortestPath(AdjacencyMatrixGraph<V, Double> graph, V VOrig, V VDest, LinkedList<V> path){
        
        double [] minDist = new double[graph.numVertices]; // Distâncias mínimas do path
        int[] verticesIndex = new int[graph.numVertices]; // Índice dos vértices do path mais pequeno
        boolean[] visitedVertices = new boolean[graph.numVertices]; // Vértices já visitados
        
        int VOrigIndex = graph.toIndex(VOrig);
        if(VOrigIndex == -1){
            path.add(VOrig);
            return path;
        } // Se retornar -1, o vértice não existe no graph
        int VDestIndex = graph.toIndex(VDest);
        if(VDestIndex == -1){
            path.add(VDest);
            return path;
        } // Se retornar -1, o vértice não existe no graph
        
        for(int i = 0; i < graph.numVertices; i++){ // Para todos os vértices do graph
            minDist[i] = Double.MAX_VALUE; // Double.MAX_VALUE representa ∞ porque a distância mínima entre os vértices é desconhecida
            verticesIndex[i] = -1; // -1 porque o path mínimo entre os vértices é desconhecido
        }
        
        shortestPath(graph, VOrigIndex, visitedVertices, verticesIndex, minDist); // Calcula o caminho mais curto entre todos os vértices
        
        if(visitedVertices[VDestIndex] == false){
            path.add(VDest);
            return path;
        } // Se retornar -1, significa que o vértice de destino não foi visitado, logo, não existe no path
        
        recreatePath(graph, VOrigIndex, VDestIndex, verticesIndex, path); // O método recreatePath() retorna o path na ordem inversa, logo, temos que reverter

	LinkedList<V> stack = new LinkedList<V>();  //cria uma stack

	while(!path.isEmpty()){ // Enquanto o path não estiver vazio
            stack.push(path.remove()); // Remove os vértices do path e adiciona à stack
        }
        while(!stack.isEmpty()){ // Enquanto a stack não estiver vazia
            path.add(stack.pop()); // Fazendo agora pop à stack, adiciona ao path os vértices na ordem correta
        }
        return path;
    }


    /**
     * Recria o path mínimo entre dois vertices, a partir do resultado do algorítmo de Dijkstra
     * 
     * @param graph Grafo
     * @param VOrigIndex Índice do vértice de origem
     * @param VDestIndex Índice do vértice de destino
     * @param verticesIndex Índice dos vértices no caminho mais curto
     */
    private static <V> void recreatePath(AdjacencyMatrixGraph<V, Double> graph, int VOrigIndex, int VDestIndex, int[] verticesIndex, LinkedList<V> path){

        path.add(graph.vertices.get(VDestIndex)); // Adiciona o vértice de destino à stack
        if (VOrigIndex != VDestIndex){ // Se o vértice de origem não for o vértice de destino
            VDestIndex = verticesIndex[VDestIndex]; // O índice do vértice de destino passa a ser o índice do vértice anterior  
            recreatePath(graph, VOrigIndex, VDestIndex, verticesIndex, path); // 
        }
    }

    /**
     * Creates new graph with minimum distances between all pairs
     * uses the Floyd-Warshall algorithm
     * 
     * @param graph Graph object
     * @return the new graph 
     */

    public static <V> AdjacencyMatrixGraph<V, Double> minDistGraph(AdjacencyMatrixGraph<V, Double> graph){
        AdjacencyMatrixGraph<V, Double> newGraph = (AdjacencyMatrixGraph<V, Double>) graph.clone();
        
        for(int k = 0 ; k < newGraph.numVertices ; k++){
            for (int i = 0 ; i < newGraph.numVertices ; i++){
                if(i!=k && newGraph.privateGet(i,k) != null){
                    for (int j = 0 ; j < newGraph.numVertices ; j++){
                        if( i != j && j != k && newGraph.privateGet(k,j) != null){
                            if(newGraph.privateGet(i,j) == null){
                                newGraph.insertEdge(i, j, newGraph.privateGet(i,k) + newGraph.privateGet(k,j));
                            } else {
                                if (newGraph.privateGet(i,j) > newGraph.privateGet(i,k) + newGraph.privateGet(k,j)){
                                    newGraph.privateSet(i,j,newGraph.privateGet(i,k) + newGraph.privateGet(k,j));
                                }
                            }
                        }
                    }
                }
            }
        }
        return newGraph;
    }
    
       public List<User> amigosNasProximidades() {
        double proximidade = 50; // valor defenido para o range maximo de proximidade
        List<User> list_am = new ArrayList<>();
        
        
        
    return list_am;
       } 
}
