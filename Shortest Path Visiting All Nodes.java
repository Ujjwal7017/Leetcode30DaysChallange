class Solution {
    public int shortestPathLength(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int len = graph.length;
        int mask = 1 << len;
        int[][] dist = new int[mask][len];
        
        for(int i = 0; i < dist.length; i ++){
            Arrays.fill(dist[i], Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < len; i ++){
            dist[1 << i][i] = 0;
            queue.offer(new int[]{1 << i, i});
        }
        
        while(! queue.isEmpty()){
            int[] info = queue.poll();
            int state = info[0];
            int node = info[1];
            if(state == mask - 1)
                return dist[state][node];
            for(int j : graph[node]){
                if(dist[state | (1 << j)][j] == Integer.MIN_VALUE){
                    dist[state|(1 << j)][j] = dist[state][node] + 1;
                    queue.offer(new int[]{state | (1 << j), j});
                }else{
                    continue;
                }
            }
        }
        
        return -1;
    }
}
