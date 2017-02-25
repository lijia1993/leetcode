public class Solution {
    public int compareVersion(String version1, String version2) {
    	while(true){
    		int dotPos1 = version1.indexOf('.');
    		int dotPos2 = version2.indexOf('.');
    		int cur1 = 0;
    		if(dotPos1==-1){
    			cur1 = Integer.parseInt(version1);
    		}
    		else{
    			String numStr = version1.substring(0, dotPos1);
    			version1 = version1.substring(dotPos1+1);
    			cur1 = Integer.parseInt(numStr);
    		}
    		int cur2 = 0;
    		if(dotPos2==-1){
    			cur2 = Integer.parseInt(version2);
    		}
    		else{
    			String numStr = version2.substring(0, dotPos2);
    			version2 = version2.substring(dotPos2+1);
    			cur2 = Integer.parseInt(numStr);
    		}
    		if(cur1>cur2) return 1;
    		if(cur1<cur2) return -1;
    		if(dotPos1==-1&&dotPos2==-1) return 0;
    		if(dotPos1==-1&&dotPos2!=-1){
    			int count=0;
    			while(true){
    				int dotPos = version2.indexOf('.');
    				if(dotPos==-1){
    					count = Integer.parseInt(version2);
    					if(count>0) return -1;
    					else return 0;
    				}
    				version2 = version2.substring(dotPos+1);
    			}
    		}
    		if(dotPos1!=-1&&dotPos2==-1){
    			int count=0;
    			while(true){
    				int dotPos = version1.indexOf('.');
    				if(dotPos==-1){
    					count = Integer.parseInt(version1);
    					if(count>0) return 1;
    					else return 0;
    				}
    				version1 = version1.substring(dotPos+1);
    			}
    		}
    	}
    }
}