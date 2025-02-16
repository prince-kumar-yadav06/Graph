import java.util.*;

public class CycleDEtection{
    
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

    // rec to check repeted edge 
public static boolean DetecCycle(ArrayList<edge> graph[],int curr,boolean vis[],boolean rec[]){

    vis[curr]=true;
    rec[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        edge e=graph[curr].get(i);

        if(rec[e.dest]==true){
            return true;
        }
        else if(!vis[e.dest]){
            if(DetecCycle(graph, e.dest, vis, rec)){
                return true;
            }
        }
    }
    vis[curr]=false; // mark vis as false during backtraking
    return false;
}


    public static void main(String[] args) {
        
        int v=7;
        ArrayList<edge> graph[]=new ArrayList[v] ;

        CreateGraph(graph, v);

        int src=0;
        boolean vis[]=new boolean[v];
        boolean rec[]=new boolean[v]; //rec to check repeated edge

        System.out.println(DetecCycle(graph, src, vis,rec));  //T.C=O(v^v)
       }
    } 



