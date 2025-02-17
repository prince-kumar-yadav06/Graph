import java.util.*;

public class TopologicalSorting{

    static class edge{
        int src;
        int dest;

        edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void creategraph(ArrayList<edge> graph[]){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<edge>();
        }
        graph[2].add(new edge(2,3));

        graph[3].add(new edge(3,1));

        graph[4].add(new edge(4,0));
        graph[4].add(new edge(4,1));

        graph[5].add(new edge(5,0));
        graph[5].add(new edge(5,2));

    }

   public static void topologicalSortUtil(ArrayList<edge> graph[],int curr,boolean vis[],Stack<Integer> st){

        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);

            if(!vis[e.dest]){
                topologicalSortUtil(graph, e.dest, vis, st);
            }
        }
        st.push(curr);
    }
   public static void topologicalSort(ArrayList<edge> graph[],int v){

        boolean vis[]=new boolean[v];

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<v;i++){
            if(!vis[i]){
                topologicalSortUtil(graph,i,vis,st);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    public static void main(String args[]){

        int v=6;
        ArrayList<edge> graph[]=new ArrayList[v];

        creategraph(graph);

        topologicalSort(graph,v);  //T.C=O(v+e)
    }
}
