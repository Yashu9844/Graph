public class disjoint {
    static int n=7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for (int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public static int find(int x){
        if (x == par[x]){
            return x;
        }
        return find(par[x]);
    }

    public static void union(int a,int b){
            int parA = find(a);
            int parB = find(b);


            if (rank[parA] == rank[parB]){
                par[parB] = parA;
                rank[parA]++;
            }
            else if (rank[parB] > rank[parA]){
                par[parA] = parB;
            }
            else {
                par[parB] = parA;
            }

    }



    public static void main(String[] args) {

        init();
        union(1,3);
        System.out.println("the parent of value is "+ find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println("The parent of  value is "+find(3));
        System.out.println("The parent of  value is "+find(4));
        union(1,5);



    }
}
