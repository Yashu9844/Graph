import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class traversalAdj {
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
    static void create(ArrayList<Edge> graph[]){
        for (int i=0;i< graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
            graph[0].add(new Edge(0,1,1));
            graph[1].add(new Edge(1,0,1));
            graph[1].add(new Edge(1,2,1));
            graph[1].add(new Edge(1,3,1));

            graph[2].add(new Edge(2 ,1 ,1));
            graph[2].add(new Edge(2,3,1));
            graph[2].add(new Edge(2,4,1));
            graph[3].add(new Edge(3,1,1));
            graph[3].add(new Edge(3,2,1));
            graph[4].add(new Edge(4,2,1));


    }

    static void bfs(ArrayList<Edge> graph[]){
        Queue<Integer> q =new LinkedList<>();
        boolean visit[] = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()){
            int curr = q.remove();
            if (!visit[curr]){
                System.out.print(curr+" ");
                visit[curr]  =true;
                for (int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dist);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        create(graph);
        bfs(graph);
    }
}
