import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalBFS {

    public static class  Edge{
        int src;

        int dist;



        public Edge(int src,int dist){
            this.src = src;
            this.dist = dist;


        }


    }
    static void create(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));


        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }



    public static void calcInd(ArrayList<Edge> graph[] , int Intdeg[]){
        for (int i=0;i< graph.length;i++){
            int v =i;
            for (int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                Intdeg[e.dist]++;

            }
        }
    }
public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcInd(graph,indeg);
        Queue<Integer> q =new LinkedList<>();

        for (int i=0;i< indeg.length;i++){
            if (indeg[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");


            for (int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dist]--;
                if (indeg[e.dist] == 0){
                    q.add(e.dist);
                }
            }
        }

    System.out.println();
}




    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);
        topSort(graph);
    }
}


