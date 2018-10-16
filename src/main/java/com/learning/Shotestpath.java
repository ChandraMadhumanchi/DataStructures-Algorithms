package com.learning;

public class Shotestpath {

	static final int V=9; 
	
	public static int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
	
	public void dijkstra(int graph[][], int src ) {
		
		int[] dist = new int[V];
		Boolean[] sptSet = new Boolean[V];
		
		for(int i = 0; i < V; i++){
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src] = 0;
		
		// Find shortest path for all vertices 
        for (int count = 0; count < V-1; count++) 
        { 
        	
        	int u = minDistance(dist, sptSet); 
        	  
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
            
         // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) 
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
            
        }
		
     // print the constructed distance array 
        printSolution(dist, V); 
		
	}
	// A utility function to print the constructed distance array 
    void printSolution(int dist[], int n) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+" tt "+dist[i]); 
    } 
    
	public static void main(String[] args) {

		/* Let us create the example graph discussed above */
	       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
	                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
	                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
	                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
	                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
	                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
	                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
	                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
	                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
	                                 }; 
	        Shotestpath t = new Shotestpath(); 
	        t.dijkstra(graph, 0); 
	}

}
