import java.util.*;

public class DFS {
    
    static class edge{
        int src;
        int dest;
        int weight;

        edge(int s,int d,int w){
            this.dest=d;
            this.src=s;
            this.weight=w;
        }
    }

    static void CreateGraph(ArrayList<edge> graph[],int v){

        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<edge>();
        }

        //add vertext and thier value

        //index 0
        graph[0].add(new edge(0, 1,1));  
        graph[0].add(new edge(0, 2,1));  

        //index 1
        graph[1].add(new edge(1,0,1));
        graph[1].add(new edge(1,3,1));

        //index 2
        graph[2].add(new edge(2,0,1));
        graph[2].add(new edge(2,4,1));

        //index 3
        graph[3].add(new edge(3,1,1));
        graph[3].add(new edge(3,4,1));
        graph[3].add(new edge(3,5,1));


        graph[4].add(new edge(4,2,1));
        graph[4].add(new edge(4,3,1));
        graph[4].add(new edge(4,5,1));

        graph[5].add(new edge(5,3,1));
        graph[5].add(new edge(5,4,1));
        graph[5].add(new edge(5,6,1));
    }

    static void dfsTraversal(ArrayList<edge> graph[],int curr,boolean vis[]){

        System.out.println(curr);
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                dfsTraversal(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        
        int v=7;
        ArrayList<edge> graph[]=new ArrayList[v];
        CreateGraph(graph, v);

        boolean vis[]=new boolean[v];

        // dfsTraversal(graph,0,vis);


        // dfsTraversal for disconnected component 

        for(int i=0;i<v;i++){
            if(vis[i]==false){
                dfsTraversal(graph, i, vis);
            }

        }
    }
    } 



