package forsterkarp;

import java.util.ArrayList;
import java.util.Random;

public class Graph {
    private int numOfNodes, numOfEdges;
    private int[][] adjMatrix;
    private Random random = new Random();
    
    public Graph (int numOfNodes, int numOfEdges){
        this.numOfNodes = numOfNodes;
        this.numOfEdges = numOfEdges;
        adjMatrix = new int[numOfNodes][numOfNodes];
        
        for (int i=0; i<numOfNodes; i++)
            for (int j=0; j<numOfNodes; j++)
                adjMatrix[i][j] = -1;
        
        for (int i=0; i<numOfEdges; i++){
            int edge = random.nextInt(numOfNodes*numOfNodes);
            int r = edge%numOfNodes;
            int l = edge/numOfNodes;
            if (r==l || adjMatrix[r][l]!=-1)
                i--;
            else{
                addEdge(l,r,random.nextInt(10)+1);
            }
        }
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
