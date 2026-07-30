class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;

        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int origClr = image[sr][sc];
        image[sr][sc] = color;

        int dx[] = new int[]{0,-1,1,0};
        int dy[] = new int[]{-1,0,0,1};

        while(!q.isEmpty()) {
           // int s = q.size();
            int []n = q.poll();

            int r = n[0];
            int c = n[1];
            for(int i=0;i<4;i++) {
                int ar = r + dx[i];
                int ac = c + dy[i];
                if (ar >=row || ac >= col || ar <0 || ac <0){
                    continue;
                }
                if ( image[ar][ac] == origClr && image[ar][ac] != color) {
                    image[ar][ac] = color;
                    q.add(new int[]{ar, ac});
                }
            }
            
        }

        return image;

    }
}