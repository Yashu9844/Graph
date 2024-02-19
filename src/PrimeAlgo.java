import java.util.*;

public class PrimeAlgo {

    public static class  Edge{
        int src;

        int dist;
        int wt;


        public Edge(int src,int dist,int wt){
            this.src = src;
            this.dist = dist;
            this.wt = wt;


        }


    }


    static  class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int c){
            this.v = v;
            this.cost = c;
        }


        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }

    }


    static void prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalCost =0;
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!vis[curr.v]){
                vis[curr.v] = true;
                finalCost+=curr.cost;

                for (int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dist,e.wt));

                }
            }
        }
        System.out.println("Final cost is "+ finalCost);
    }
    static void create(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0, 3,30));



        graph[1].add(new Edge(1, 0,10));
        graph[1].add(new Edge(1, 3,40));



        graph[2].add(new Edge(2, 0,15));
        graph[2].add(new Edge(2, 3,50));



        graph[3].add(new Edge(3, 1,40));
        graph[3].add(new Edge(3, 2,50));


    }












    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);
        prims(graph);

    }
}

