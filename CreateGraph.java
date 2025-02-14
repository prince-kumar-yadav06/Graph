import java.util.*;

public class CreateGraph{   //T.C=O(x) x is no of edge at particular x;

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

        int v=4;
        ArrayList<edge> []graph=new ArrayList[v];

        //initialise by empty arraylist

        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }

        //add vertext and thier value

        //index 0
        graph[0].add(new edge(0, 2,3));  

        //index 1
        graph[1].add(new edge(1,2,1));
        graph[1].add(new edge(1,3,4));

        //index 2
        graph[2].add(new edge(2,0,5));
        graph[2].add(new edge(2,1,4));
        graph[2].add(new edge(2,3,9));

        //index 3
        graph[3].add(new edge(3,1,7));
        graph[3].add(new edge(3,0,8));
        graph[3].add(new edge(3,2,9));



for(int i=0;i<graph[2].size();i++){
    edge e=graph[2].get(i);
    System.out.println(e.src);  //print src value of index 2
    System.out.println(e.dest);   //print dest value of index 2
    System.out.println(e.weight);   //print weight value of index 2
}

    }
}
