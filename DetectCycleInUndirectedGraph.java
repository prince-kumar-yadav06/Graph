import java.util.*;

public class DetectCycleInUndirectedGraph{

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
        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,4));

        graph[1].add(new edge(1,0));
        graph[1].add(new edge(1,2));
        graph[1].add(new edge(1,4));

        graph[2].add(new edge(2,1));
        graph[2].add(new edge(2,3));

        graph[3].add(new edge(3,2));

        graph[4].add(new edge(4,0));
        graph[4].add(new edge(4,1));
        graph[4].add(new edge(4,5));

        graph[5].add(new edge(5,4));


    }

   public static boolean IsCycle(ArrayList<edge> graph[],int curr,boolean vis[],int parent){

        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);

            if(vis[e.dest] && parent!= e.dest){
                return true;
            }

           else if(!vis[e.dest]){
                if(topologicalSortUtil(graph, e.dest, vis,curr )){
                    return true;
                }
            }
        }
        return false;
    }
   

    public static void main(String args[]){

        int v=6;
        boolean vis[]=new boolean[v];
        ArrayList<edge> graph[]=new ArrayList[v];

        creategraph(graph);

        System.out.println(IsCycle(graph,0,vis,-1));  //T.C=O(v+e)
    }
}
