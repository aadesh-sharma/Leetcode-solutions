class SurroundedRegions {
    public void solve(char[][] b) {
        
        int n = b.length;
        int m = b[0].length;

        fill(n,m,b);
    }

    private void fill(int n, int m,char[][]b){
        int vis[][] = new int[n][m];
        int dx[] = {0,-1,1,0};
        int dy[]= {-1,0,0,1};
        //first row
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && b[0][i]=='O'){
                dfs(0,i,b,vis,dx,dy);
            }
        //last row
            if(vis[n-1][i]==0 && b[n-1][i]=='O'){
                dfs(n-1,i,b,vis,dx,dy);
            }
        }
        //first column
        for(int i=0;i<n;i++){
             if(vis[i][0]==0 && b[i][0]=='O'){
                dfs(i,0,b,vis,dx,dy);
            }
             if(vis[i][m-1]==0 && b[i][m-1]=='O'){
                dfs(i,m-1,b,vis,dx,dy);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (vis[i][j]==0 && b[i][j]=='O'){
                    b[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(int r, int c,char[][]mat, int[][]vis,int []dx,int dy[] ){
        vis[r][c] = 1;
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<4;i++){
            int ar = dx[i]+r;
            int ac = dy[i]+c;
            if(ar<n && ar>=0 && ac<m && ac>=0 && vis[ar][ac]==0 && mat[ar][ac]=='O'){
                dfs(ar,ac,mat,vis,dx,dy);
            }
        }
    }
}