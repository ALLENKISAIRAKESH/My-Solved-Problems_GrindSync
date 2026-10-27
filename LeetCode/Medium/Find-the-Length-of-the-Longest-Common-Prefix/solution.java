class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        HashSet<String> s = new HashSet<>();
        
        for(int x : arr1){
            
            String t = x + "";
            String p = "";
            
            for(char c : t.toCharArray()){
                p += c;
                s.add(p);
            }
        }
        
        int ans = 0;
        
        for(int x : arr2){
            
            String t = x + "";
            String p = "";
            
            for(char c : t.toCharArray()){
                
                p += c;
                
                if(s.contains(p)){
                    ans = Math.max(ans, p.length());
                }
            }
        }
        
        return ans;
    }
}