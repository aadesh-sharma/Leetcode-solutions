import java.util.*;

class CycleDetectUndirectedDfs {
    // DFS function to detect cycle
    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        // Mark current node visited
        visited[node] = true;

        // Traverse neighbors
        for (int neighbor : adj.get(node)) {

            // If neighbor not visited, recurse
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adj, visited)) return true;
            }

            // If neighbor visited and not parent, cycle exists
            else if (neighbor != parent) {
                return true;
            }
        }

        // No cycle found from this path
        return false;
    }

    // Function to check cycle in graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example: Graph with 5 nodes and a cycle
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1);

        Solution sol = new Solution();
        if (sol.isCycle(V, adj))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycle found");
    }
}
