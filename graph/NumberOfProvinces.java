package graph;

public class NumberOfProvinces {

    public static void main(String args[]) {
        int[][] g = new int[3][3];
        g[0] = new int[]{1, 1, 0};
        g[1] = new int[]{1, 1, 0};
        g[2] = new int[]{0, 0, 1};

        int V = g.length;
        boolean vis[] = new boolean[V];
        int c =0;
        for(int i=0;i<V;i++) {
            if (vis[i] == false) {
                c++;
                dfs(g, vis, i);
            }
        }
        
        System.out.println(c);
    }

    public static void dfs(int [][]g, boolean vis[], int src) {
        vis[src] = true;

        for(int child = 0; child < g[src].length; child++) {
            if (vis[child] == false && g[src][child] == 1) {
                dfs(g, vis, child);
            }
        }
    }
}
