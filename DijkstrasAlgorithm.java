import java.util.*;
public class DijkstrasAlgorithm{

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
        graph[1].add(new edge(1,3,7));
        graph[1].add(new edge(1,2,1));
        
        //index 2
        graph[2].add(new edge(2,4,3));
        
        //index 3
        graph[3].add(new edge(3,5,1));
        
        
        graph[4].add(new edge(4,3,1));
        graph[4].add(new edge(4,5,5));
        
    }

        public static class Pair implements Comparable<Pair>{
            int node; 
            int dist;
    
            public Pair(int n,int d){
                this.node=n;
                this.dist=d;
            }
            @Override
            public int compareTo(Pair p2){
                return this.dist-p2.dist; //ascending order
            }
        }
    public static void dijkstra(ArrayList<edge> graph[],int src,int V){  //O(E+ ElogV)  e=traverse every edge and elogv by priority queue;

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int dis[]=new int[V];

        //intialize dis with infinity
        for(int i=0;i<V;i++){
            if(i != src){

                dis[i]=Integer.MAX_VALUE;
            }
        }

        boolean vis[]=new boolean[V];

        pq.add(new Pair(0,0));  //assign src=0,dist=0; in starting

        while(!pq.isEmpty()){
            Pair curr=pq.remove();  //shortest distance;

            if(!vis[curr.node]){
                vis[curr.node]=true;

                for(int i=0;i<graph[curr.node].size();i++){
                    edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dist;

                    if(dis[u] + e.weight < dis[v]){
                        dis[v]= dis[u] + e.weight;
                        pq.add(new Pair(v,dis[v]));
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.print(dis[i]+" ");
        }
        
    }

    public static void main(String args[]){

        int V=6;

        ArrayList<edge> graph[]=new ArrayList[V];

        CreateGraph(graph,V);

        dijkstra(graph,0,V);
    }
}
