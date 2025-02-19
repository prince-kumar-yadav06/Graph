import java.util.*;
public class BellmanFordAlgorithm{

    static class edge{
        int src;
        int dist;
        int weight;

        edge(int s,int d,int w){
            this.src=s;
            this.dist=d;
            this.weight=w;
        }
    }

    
    static void CreateGraph(ArrayList<edge> graph[],int v){
        
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<edge>();
        }
        
        //add vertext and thier value
        
        //index 0
        graph[0].add(new edge(0, 1,2));  
        graph[0].add(new edge(0, 2,4));  
        
        //index 1
        graph[1].add(new edge(1,2,-4));
        
        //index 2
        graph[2].add(new edge(2,3,2));
        
        //index 3
        graph[3].add(new edge(3,4,4));
        
        
        graph[4].add(new edge(4,1,-1));
        
    }
   public static void BellmanFord(ArrayList<edge> graph[],int src,int v){

    int dis[]=new int[v];

    for(int i=0;i<v;i++){
        if(i !=src){
            dis[i]=Integer.MAX_VALUE;
        }
    }

        for(int k=0;k<v-1;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<graph[i].size();j++){
                    edge e=graph[i].get(j);
                    int u=e.src;
                    int V=e.dist;

                    if(dis[u] != Integer.MAX_VALUE && dis[u] +e.weight < dis[V]){
                        dis[V]=dis[u] + e.weight;
                    }
                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(dis[i]+" ");
        }
    }
   

    public static void main(String args[]){

        int V=5;

        ArrayList<edge> graph[]=new ArrayList[V];

        CreateGraph(graph,V);

        BellmanFord(graph,0,V);
    }
}
