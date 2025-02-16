import java.util.*;

public class PrintAllpathOfGraph {
    
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

    static void PrintAllPath(ArrayList<edge> graph[],int curr,int dest ,boolean vis[],String path){

        //base case
        if(curr==dest){
            System.out.println(path);
            return ;
        }
    
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
           if(!vis[curr]){
            vis[curr]=true;  //mark visited during recursion
            PrintAllPath(graph, e.dest, dest, vis, path+e.dest);
            vis[curr]=false; //mark unvisited during backtrack 
           }
        }
}

    public static void main(String[] args) {
        
        int v=7;
        ArrayList<edge> graph[]=new ArrayList[v] ;

        CreateGraph(graph, v);

        int src=0;
        int dest=1;
        boolean vis[]=new boolean[v];
        PrintAllPath(graph, src, dest, vis,"0");  //T.C=O(v^v)
       }
    } 



