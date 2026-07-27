class RottenOranges {

    public static void main(String args[]){
        
            //grid = [[2,1,1],[1,1,0],[0,1,1]]
            int[][] g = new int[3][3];
        

            RottenOranges ro = new RottenOranges();
            System.out.println(ro.orangesRotting(g));   
    }

    public int orangesRotting(int[][] g) {

        int res =0;
        int rotten = 0;
        int fresh = 0;
        int row = g.length;
        int col = g[0].length;
        Queue<int[]> rottenArr = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                if (g[i][j] == 2) {
                    rottenArr.add(new int[]{i,j});
                    rotten++;
                }
                else if (g[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh ==0) return 0;

        int timeRes = -1;
        int dx[] = {0,-1,1,0};
        int dy[] = {-1,0,0,1};
        while(!rottenArr.isEmpty()) {
            int size = rottenArr.size();
            for(int j=0;j<size;j++) {
                int [] src = rottenArr.poll();
                int ar = src[0];
                int ac = src[1];
                for(int i=0;i<4;i++) {
                    int r = ar+dx[i];
                    int c = ac+dy[i];

                    if (!(r<0 || r>=row || c<0 || c>=col) &&
                        g[r][c]==1) {
                        rottenArr.add(new int[]{r,c});
                        g[r][c] = 2;
                        fresh--;
                    }
                }
            }

            timeRes ++;
        }
        System.out.println(fresh);
        return (fresh == 0)? timeRes : -1;
    }
}



