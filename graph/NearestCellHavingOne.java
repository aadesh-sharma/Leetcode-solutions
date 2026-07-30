class NearestCellHavingOne {
    public int[][] updateMatrix(int[][] mat) {
        
        int n= mat.length;
        int m = mat[0].length;
        int [][]dm = new int[n][m];
        boolean [][]vis = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (mat[i][j]==0) {
                    q.add(new Node(i,j,0));
                    vis[i][j] =true;
                }
                else {
                    vis[i][j]=false;
                }
            }
        }
        int []dx = {0,-1,1,0};
        int []dy = {-1,0,0,1};

          
	
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().sec;
            int step = q.peek().third;
            q.poll();
            
            dm[r][c] = step;
            for(int i=0;i<4;i++){
                int ar = dx[i]+r;
                int ac = dy[i]+c;
                if (ar<n && ar>=0 && ac>=0 && ac<m && vis[ar][ac]==false ) {
                    q.add(new Node(ar,ac,step+1));
                    vis[ar][ac] =true;
                }
            }
        }
        return dm;
    }

}

class Node {
    int first;
    int sec;
    int third;
    public Node(int x, int y, int z){
        this.first = x;
        this.sec=y;
        this.third =z;
    }
}