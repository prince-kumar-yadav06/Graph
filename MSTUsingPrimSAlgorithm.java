import java.util.*;
public classMSTUsingPrimSAlgorithm{

    static class edge{
        int src;
        int dest;
        int weight;

        edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }

    
    static void CreateGraph(ArrayList<edge> graph[],int v){
        
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<edge>();
        }
        
        //add vertext and thier value
        
        //index 0
        // graph[0].add(new edge(0, 1,10));  
        // graph[0].add(new edge(0, 2,15));  
        // graph[0].add(new edge(0, 3,30));  
        
        // //index 1
        // graph[1].add(new edge(1,0,10));
        // graph[1].add(new edge(1,3,40));
        
        // //index 2
        // graph[2].add(new edge(2,0,15));
        // graph[2].add(new edge(2,3,50));
        
        // //index 3
        // graph[3].add(new edge(3,1,40));
        // graph[3].add(new edge(3,2,50));

        //2nd input

        graph[1].add(new edge(1,2,2));

        graph[2].add(new edge(2,1,2));
        graph[2].add(new edge(2,3,3));

        graph[3].add(new edge(3,2,3));
        graph[3].add(new edge(3,1,10));
        
            
    }

    static class pair implements Comparable<pair>{
        int node;
        int cost;

        pair(int n,int p){
            this.node=n;
            this.cost=p;
        }
        @Override
        public int compareTo(pair p2){  // sort the edge based on cost
            return this.cost-p2.cost;
        }
    }
   public static void MST(ArrayList<edge> graph[],int v){

    PriorityQueue<pair> pq=new PriorityQueue<>();
    boolean vis[]=new boolean[v];

    pq.add(new pair(1, 0));

    int cost=0;

    while(!pq.isEmpty()){
        pair curr=pq.remove();

        if(!vis[curr.node]){
            vis[curr.node]=true;
            cost +=curr.cost;

            for(int i=0;i<graph[curr.node].size();i++){
                edge e=graph[curr.node].get(i);
                if(!vis[e.dest]){
                    pq.add(new pair(e.dest,e.weight));
                }
            }
        }
    }
    System.out.println(cost);
   }
   

    public static void main(String args[]){

        int V=5;

        ArrayList<edge> graph[]=new ArrayList[V];

        CreateGraph(graph,V);

        MST(graph, V);  //T.C=O(ElogE)

    }
}
