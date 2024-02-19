import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cheapestFlight {
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

   public static class Info{
        int v;
        int cost;
        int stops;

        public  Info(int v,int c,int s){
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

 static void create(int flight[][],ArrayList<Edge> graph[]){
        for (int i=0;i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0;i< flight.length;i++){
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];


            Edge e = new Edge(src,dest,wt);
            graph[dest].add(e);
        }
    }
    static  int cheapest(int n,int flight[][],int src,int dest,int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        create(flight,graph);

        int dist[] = new int [n];
        for (int i=0;i<n;i++){
            if (i != src){
                dist[i] = Integer.MAX_VALUE;

            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src , 0 , 0 ));

        while (!q.isEmpty()){
             Info curr = q.remove();

             if (curr.stops > k){
                 break;

             }

             for (int i=0;i<graph[curr.v].size();i++){
                 Edge e =graph[curr.v].get(i);
                 int u= e.src;
                 int v =e.dist;
                 int wt = e.wt;

                 if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                     dist[v] = dist[u] + wt;
                     q.add(new Info(v, dist[v], curr.stops + 1));
                 }



             }


        }

        if (dist[dest] == Integer.MAX_VALUE){
            return -1;
        }

        else{
            return dist[dest];
        }
    }



    public static void main(String[] args) {



        int n=4;

        int flight[][]={{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src =0,dst =3,k=1;


        System.out.println(cheapest(n,flight,src,dst,k));
    }
}
