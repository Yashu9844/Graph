import java.util.ArrayList;

public class detectionCycle {

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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));


        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));


        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));


        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));




        graph[4].add(new Edge(4, 3));

    }



    public  static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i=0;i<graph.length;i++){
            if (!vis[i]){
                if (detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        vis[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            // CASE 3
            if(!vis[e.dist]) {
                if (detectCycleUtil(graph, vis, e.dist,curr)){
                    return true;
                }

            }
            // CASE 1
        else if (vis[e.dist] && e.dist != par){
            return true;
            }

        //CASE 2 -> do nothing

    }
    return false;
    }



        public static void main(String[] args) {
            int V=5;
            ArrayList<Edge>[] graph = new ArrayList[V];
            create(graph);
            System.out.println(detectCycle(graph));
    }
}
