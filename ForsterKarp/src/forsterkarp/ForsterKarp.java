package forsterkarp;

public class ForsterKarp {

    public static void main(String[] args) {
        Graph graph = new Graph(6,10);
        
        int[][] matrix = graph.getAdjMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        
    }
    
}
