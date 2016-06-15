package forsterkarp;

public class Graph {
    private int numOfNodes;
    private int[][] adjMatrix;
    
    public Graph (int numOfNodes){
        this.numOfNodes = numOfNodes;
        adjMatrix = new int[numOfNodes][numOfNodes];
        
        for (int i=0; i<numOfNodes; i++)
            for (int j=0; j<numOfNodes; j++)
                adjMatrix[i][j] = -1;
    }
    
    public int getNumOfNodes(){
        return numOfNodes;
    }
    
    public int[][] getAdjMatrix (){
        return adjMatrix;
    }
    
    public void addEdge(int node1, int node2, int weight){
        adjMatrix[node1][node2] = weight;
        adjMatrix[node2][node1] = weight;
    }
}
