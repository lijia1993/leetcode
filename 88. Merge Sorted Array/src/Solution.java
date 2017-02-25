public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if(n==0)return;
    	if(m==0){
    		for(int i=0;i<=n-1;i++){
    			nums1[i]=nums2[i];
    		}
    		return;
    	}
        int p1=0,p2=0;
        int startPos=0;
        int end1 = m-1;
        int end2 = n-1;
        while(true){
        	if(p1>end1||p2>end2){
        		break;
        	}
        	while(nums1[p1]<=nums2[p2]&&p1+1<=end1){
        		p1++;
        	}
        	if(nums1[p1]<=nums2[p2]&&p1==end1){
        		for(int i=p2;i<=end2;i++){
        			end1++;
        			nums1[end1]=nums2[i];
        		}
        		break;
        	}
        	startPos = p2;
        	while(nums2[p2]<=nums1[p1]&&p2+1<=end2){
        		p2++;
        	}
        	if(nums2[p2]<=nums1[p1]&&p2==end2){
        		int moves = end2-startPos+1;
        		for(int i=end1;i>=p1;i--){
        			nums1[i+moves]=nums1[i];
        		}
        		for(int i=startPos;i<=p2;i++){
        			nums1[p1+i-startPos]=nums2[i];
        		}
        		end1+=moves;
        		p1+=moves;
        		break;
        	}
        	int moves = p2-startPos;
    		for(int i=end1;i>=p1;i--){
    			nums1[i+moves]=nums1[i];
    		}
    		for(int i=startPos;i<=p2-1;i++){
    			nums1[p1+i-startPos]=nums2[i];
    		}
    		end1+=moves;
    		p1+=moves;
        }
    }
    
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[] nums1 = new int[2];
    	nums1[0]=2;
    	nums1[1]=0;

    	int[] nums2 = new int[1];
    	nums2[0]=1;
//    	nums2[1]=5;
//    	int[] nums2 = new int[0];
    	obj.merge(nums1, 1, nums2, 1);
    	System.out.println(1);
	}
}