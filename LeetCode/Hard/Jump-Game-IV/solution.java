class Solution {
    public int minJumps(int[] a) {
        int n = a.length;
        if(n==1) return 0;
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i =0;i<n;i++){
            mp.computeIfAbsent(a[i],k->new ArrayList<>()).add(i);
        }
        Queue<Integer>q=new LinkedList<>();
        boolean[] v= new boolean[n];
        q.offer(0);
        v[0]=true;
        int st =0;
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-->0){
                int i =q.poll();
                if(i==n-1) return st;
                if(i+1<n && !v[i+1]){
                    v[i+1]=true;
                    q.offer(i+1);
                }
                if(i-1>=0 && !v[i-1]){
                    v[i-1]=true;
                    q.offer(i-1);
                }
                for(int x : mp.get(a[i])){
                    if(!v[x]){
                        v[x]=true;
                        q.offer(x);
                    }

                }
                mp.get(a[i]).clear();

            }
            st++;
        }
        return -1;
    }
}