package forsterkarp;

public class HeldKarp {
    
    public int[][] dp;
    private int[][] adjMatrix;
    private int numOfNodes;
    private int numOfSubsets;
    
    public void initialize (Graph graph){
        adjMatrix = graph.getAdjMatrix();
        numOfNodes = graph.getNumOfNodes();
        numOfSubsets = (1 << numOfNodes);
        
        dp = new int[numOfNodes][numOfSubsets];
        
        for (int i=0; i<numOfNodes; i++)
            for (int j=0; j<numOfSubsets; j++)
                dp[i][j] = -2;
        
        for (int i=0; i<numOfNodes; i++)
            dp[i][0] = adjMatrix[i][0];
    }
    
    private boolean isBitSet (int x, int b){
        return ((1 << b) & x) != 0;
    }
    
    private int resetBit (int x, int b){
        return (x & (~(1 << b)));
    }
    
    private int TSP (int pos, int bitmask){
        if (dp[pos][bitmask] != -2)
            return dp[pos][bitmask];
        
        for (int i=0; i<numOfNodes; i++){
            if (i != pos && isBitSet(bitmask, i)){
                
                int prev = TSP(i, resetBit(bitmask, i));
                if (prev < 0 || adjMatrix[pos][i] < 0) prev = -1;
                else prev += adjMatrix[pos][i];
                
                if (dp[pos][bitmask] < 0) dp[pos][bitmask] = prev;
                else if (prev >= 0) dp[pos][bitmask] = Math.min (dp[pos][bitmask], prev);
                
            }
        }
        
        return dp[pos][bitmask];
    }
    
    public int TSP (){
        return TSP(0, numOfSubsets-2);
    }
    
}
