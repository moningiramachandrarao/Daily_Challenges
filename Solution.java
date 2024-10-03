class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;    
        for(int i=0;i<nums.length;++i){
            sum+=nums[i];
        }
        long rem=sum%p;
        HashMap<Long,Integer>hm=new HashMap<>();
        sum=0;
        hm.put(0L, -1);
        int res=Integer.MAX_VALUE;
        if(rem==0){
            return 0;
        }
        for(int i=0;i<nums.length;++i){
            sum+=nums[i];
            sum%=p;
            long temp=(sum-rem+p)%p;
            if(hm.containsKey(temp)){
               res=Math.min(i-hm.get(temp),res);
            }
        hm.put(sum,i);
        }
        if(res==nums.length){
            return -1;
        }
        return res;
    }
}