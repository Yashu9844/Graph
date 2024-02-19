import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class allPaths {

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
          graph[0].add(new Edge(0,3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));


        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

public static void print(ArrayList<Edge> graph[],int src , int dest,String path){

        if (src == dest){
            System.out.println(path+src);
            return;
        }
    for (int i=0;i<graph[src].size();i++){
        Edge e = graph[src].get(i);
        print(graph,e.dist,dest,path+src);
    }


}



    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);


        int src=5 ,dest=1;

        print(graph,src,dest," ");
    }
}

