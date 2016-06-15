/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsterkarp;

import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public class BruteForce {
    private int[] nodes, pre;
    private int[][] perm;
    private int numOfNodes;
    private int cost;
    private int line;
    
    public int TSP(Graph graph){
        numOfNodes = graph.getNumOfNodes();
        nodes = new int[numOfNodes];
        cost=1000;
        line=0;
        
        for (int i=0; i<numOfNodes; i++){
            nodes[i]=i;
        }
        
        //gerar matriz de todas as permutações possíveis dos vértices
        int fact = 1;
        for (int i=1; i<=nodes.length; i++) {
            fact *= i;
        }
        permutation(nodes, fact);
        
        //percorrer matriz e calcular o custo de todas as viagens
        for (int i=0; i<fact; i++){
            int c = 0;
          
            for (int j=0; j<numOfNodes-1; j++){
                if(graph.getAdjMatrix()[perm[i][j]][perm[i][j+1]]!=-1)
                    c = c+graph.getAdjMatrix()[perm[i][j]][perm[i][j+1]];
                else c=2000;
            }
            if (graph.getAdjMatrix()[perm[i][numOfNodes-1]][perm[i][0]]!=-1)
                c = c+graph.getAdjMatrix()[perm[i][numOfNodes-1]][perm[i][0]];
            else c=2000;
            
            if (c<cost)
                cost=c;
        }
        
        if (cost==1000)
            return -1;
        else
            return cost;
    }
    
    
    public void permutation(int[] nodes, int fact){
        perm = new int[fact][numOfNodes];
        pre = new int[0];
        permutation(pre,nodes);   
    }
    
    public void permutation(int[] prefix, int[] nodes){
        int n = nodes.length;
        if (n==0){
            for (int i=0; i<prefix.length; i++){
                perm[line][i]=prefix[i];
            }
            line++;
        }
        else
            for (int i=0; i<n; i++){
                int[] prefix2 = new int[prefix.length+1];
                int[] nodes2 = new int[n-1];
                
                for (int j=0; j<prefix2.length; j++){
                    if (j<prefix.length)
                        prefix2[j]=prefix[j];
                    else 
                        prefix2[j]=nodes[i];
                }
                
                for (int k=0; k<nodes2.length; k++){
                    if(k<i)
                        nodes2[k]=nodes[k];
                    else
                        nodes2[k]=nodes[k+1];
                }
                
                permutation(prefix2,nodes2);   
            }
        
    }
}
