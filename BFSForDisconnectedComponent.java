import java.util.*;

public class BFSForDisconnectedComponent {
    
    static class edge{
        int src;
        int dest;
        int weight;

        edge(int src,int dest,int wght){
            this.src=src;
            this.dest=dest;
            this.weight=wght;
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

    static void BFS(ArrayList<edge> graph[],int v,boolean vis[],int start){

        Queue<Integer> q=new LinkedList();

q.add(start);  //initilaize with souce

while(!q.isEmpty()){
    int curr=q.remove();

    if(!vis[curr]){
        System.out.println(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            q.add(e.dest);
        }
    }
    }
}
    public static void main(String args[]){

        int v=7;
        ArrayList<edge> graph[]=new ArrayList[v];
        CreateGraph(graph, v);

        // print dest of graph at index 1
        // for(int i=0;i<graph[1].size();i++){
        //     edge e=graph[1].get(i);
        //     System.out.println(e.dest);
        // }


        // disconnected component 
        // 1---2--3

        // 4--5--6


        // is code is work for both normal graph and disconnected component 
    boolean vis[]=new boolean[v];
    for(int i=0;i<v;i++){
        if(vis[i]==false){
            BFS(graph,v,vis,i);
        }
    }
    

        
}
    
    }


