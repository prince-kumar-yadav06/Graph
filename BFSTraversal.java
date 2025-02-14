import java.util.*;

public class BFS{   //T.C=O(x) x is no of edge at particular x;

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

    public static void main(String args[]){

        int v=7;
        ArrayList<edge> []graph=new ArrayList[v];

        //initialise by empty arraylist

        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
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


Queue<Integer> q=new LinkedList();

q.add(0);  //initilaize with souce
boolean vis[]=new boolean[graph.length];

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
}
