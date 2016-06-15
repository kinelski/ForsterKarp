package forsterkarp;

public class ForsterKarp {
    public static void main(String[] args) {
        
        Graph graph;
        HeldKarp hk = new HeldKarp();
        BruteForce bf = new BruteForce();
        
        System.out.println ("CTC-20: Projeto 2");
        System.out.println ("Trabalho feito por:");
        System.out.println ("Caio Cesar Saldanha Maia Orejuela Kinelski");
        System.out.println ("Gabriela Nalim Tourinho\n");
        
        System.out.println ("Verificação com Grafos Aleatórios");
        for (int i=1; i<=10; i++){
            graph = new Graph (6, 10);
            
            System.out.println ("Grafo de teste " + i + ":");
            graph.println();
            
            hk.initialize(graph);
            System.out.println ("Solução por Held Karp: " + hk.TSP() + "\n");
            
            System.out.println("Solução por Força Bruta: " + bf.TSP(graph) +"\n");
        }
        
        System.out.println ("Teste de Desempenho Médio");
        System.out.println ("A saída será gerada em um arquivo out.txt no formato");
        System.out.println ("adequado para a utilização em MATLAB.");
        
    }
}
