/*
 * Copyright 2015, DEI-ISEP
 *
 * Developed for use within ISEP
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package graphMatrizAdj;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * Implementation of graph algorithms for a (undirected) graph structure 
 * Considering generic vertex V and edge E types
 * 
 * Works on AdjancyMatrixGraph objects
 * 
 * @author Luis Miguel Pinho
 * 
 */

public class GraphAlgorithms {

	private static <T> LinkedList<T> reverse(LinkedList <T> list){
		LinkedList<T> reversed = new LinkedList<T>();
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

		LinkedList<V> resultQueue = new LinkedList<V>();
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
		if (index == -1)
			return null;

		LinkedList<V> resultQueue = new LinkedList<V>();
		boolean [] knownVertices = new boolean[graph.numVertices];

		LinkedList<Integer> auxQueue = new LinkedList<Integer>();

		resultQueue.add(vertex);
		auxQueue.add(index);

		knownVertices[index]=true;

		while(!auxQueue.isEmpty()){
			index=auxQueue.remove(); 
			for (int i = 0 ; i < graph.numVertices ; i++){
				if(graph.edgeMatrix[index][i]!=null){
					int dest = i;
					if (!knownVertices[dest]){
						knownVertices[dest]=true;
						resultQueue.add(graph.vertices.get(dest));
						auxQueue.add(dest);
					}
				}
			}
		}
		return resultQueue;
	}



	/**
	 * Checks if a path exists between two vertices 
	 * Calls recursive version of the method.
	 *
	 * @param graph Graph object
	 * @param source Source vertex of path 
	 * @param dest Destination vertex of path
	 * @param path Queue with vertices in the path (empty if no path)
	 * @return false if vertices are not in graph
	 *
	 */

	public static <V,E> boolean existsPath(AdjacencyMatrixGraph<V,E> graph, V source, V dest, LinkedList<V> path) {

		int sourceIdx = graph.toIndex(source);
		if (sourceIdx == -1)
			return false;

		int destIdx = graph.toIndex(dest);
		if (destIdx == -1)
			return false;

		path.clear();
		LinkedList<V> auxStack= new LinkedList<V>();

		boolean [] knownVertices = new boolean[graph.numVertices];
		if(existsPath(graph, sourceIdx, destIdx, knownVertices, auxStack))
		{
			// reverse the order of the path (source to dest)
			Iterator<V> it = auxStack.iterator();
			while(it.hasNext())
				path.push(it.next());
			path.push(source);
			return true;

		}
		return false;
	}

	/**
	 * Actual path search 
	 * The method adds vertices to the stack 
	 *
	 * @param graph Graph object
	 * @param sourceIdx Index of source vertex 
	 * @param destIdx Index of destination vertex
	 * @param knownVertices previously discovered vertices
	 * @param auxStack stack of vertices in the path
	 * @return true if path exists
	 * 
	 */

	static <V,E> boolean existsPath(AdjacencyMatrixGraph<V,E> graph, int sourceIdx, int destIdx, boolean [] knownVertices, LinkedList<V> auxStack) {

		if(sourceIdx == destIdx)
			return true;
		knownVertices[sourceIdx] = true;                              
		for (int i = 0 ; i < graph.numVertices ; i++) {     
			if(graph.edgeMatrix[sourceIdx][i] != null && knownVertices[i] == false){
				auxStack.push(graph.vertices.get(i));
				if(existsPath(graph, i, destIdx, knownVertices, auxStack))
					return true;
				auxStack.pop();
			}
		}
		return false;
	}

	/**
	 * All paths between two vertices 
	 * Calls recursive version of the method.
	 *
	 * @param graph Graph object
	 * @param source Source vertex of path 
	 * @param dest Destination vertex of path
	 * @param path LinkedList with paths (queues)
	 * @return false if vertices not in the graph
	 *
	 */

	public static <V,E> boolean allPaths(AdjacencyMatrixGraph<V,E> graph, V source, V dest, LinkedList<LinkedList<V>> paths) {
		int sourceIdx = graph.toIndex(source);
		if (sourceIdx == -1)
			return false;

		int destIdx = graph.toIndex(dest);
		if (destIdx == -1)
			return false;

		paths.clear();
		LinkedList<V> auxStack= new LinkedList<V>();

		boolean [] knownVertices = new boolean[graph.numVertices];
		allPaths(graph, sourceIdx, destIdx, knownVertices, auxStack, paths);
		return true;
	}

	/**
	 * Actual paths search 
	 * The method adds vertices to the current path (stack of vertices)
	 * when destination is found, the current path is saved to the list of paths 
	 *
	 * @param graph Graph object
	 * @param sourceIdx Index of source vertex 
	 * @param destIdx Index of destination vertex
	 * @param knownVertices previously discovered vertices
	 * @param auxStack stack of vertices in the path
	 * @param path LinkedList with paths (queues)
	 * 
	 */

	static <V,E> void allPaths(AdjacencyMatrixGraph<V,E> graph, int sourceIdx, int destIdx, boolean [] knownVertices, LinkedList<V> auxStack, LinkedList<LinkedList<V>> paths) {
		auxStack.push(graph.vertices.get(sourceIdx));
		knownVertices[sourceIdx] = true;                              
		for (int i = 0 ; i < graph.numVertices ; i++) {     
			if(graph.edgeMatrix[sourceIdx][i] != null ){
				if(i == destIdx){
					auxStack.push(graph.vertices.get(i));
					paths.add(reverse(auxStack));  // order will be correct
					auxStack.pop();
				}				
				else
					if(knownVertices[i] == false)
						allPaths(graph, i, destIdx, knownVertices, auxStack, paths);
			}
		}
		knownVertices[sourceIdx] = false;                              
		auxStack.pop();
	}



	/**
	 * Transforms a graph into its transitive closure 
	 * uses the Floyd-Warshall algorithm
	 * 
	 * @param graph Graph object
	 * @param dummyEdge object to insert in the newly created edges
	 * @return the new graph 
	 */

	public static <V, E> AdjacencyMatrixGraph<V, E> transitiveClosure(AdjacencyMatrixGraph<V, E> graph, E dummyEdge){
		@SuppressWarnings("unchecked")
		AdjacencyMatrixGraph<V, E> newGraph = (AdjacencyMatrixGraph<V, E>) graph.clone();

		for(int k = 0 ; k < newGraph.numVertices ; k++)
			for (int i = 0 ; i < newGraph.numVertices ; i++)
				if(i!=k && newGraph.edgeMatrix[i][k] != null)
				{
					for (int j = 0 ; j < newGraph.numVertices ; j++)
						if( i != j && j != k && newGraph.edgeMatrix[k][j] != null)
							if(newGraph.edgeMatrix[i][j] == null)
								newGraph.insertEdge(i, j, dummyEdge);
				}
		return newGraph;
	}

}
