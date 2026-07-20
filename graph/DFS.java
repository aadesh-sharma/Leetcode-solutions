package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {


    public static void main(String args[]) {
        int V = 5;
        List<Integer>[] adj =  new ArrayList[V];

        for(int i=0;i<V;i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0, 3));
        adj[2].addAll(Arrays.asList(0, 4));
        adj[3].add(1);
        adj[4].add(2);

        boolean[] visited = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfs(adj, i, visited, ans);
            }
        }
        for(int x: ans) {
            System.out.print(x + " ");
        }
    }

    public static void dfs(List<Integer>[] adj, int src, boolean[] visited, List<Integer> ans) {
        visited[src] = true;
        ans.add(src);
        for(int x: adj[src]){
            if(!visited[x]) {
                dfs(adj, x, visited, ans);
            }
        }




    }
}
