import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void sysoSudoku(char[][] board){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public int initTable(char[][] board){
		int min;
		while(true){
			boolean[][][] table = new boolean[9][9][10];
			putTrue(board,table);
	    	min = 10;
	    	for(int i=0;i<9;i++){
	    		for(int j=0;j<9;j++){
	    			int ct = 0;
	    			if(board[i][j]=='.'){
	    				int pot = 0;
	    				for(int k=1;k<=9;k++){
	    					if(!table[i][j][k]){
	    						ct++;
	    						pot = k;
	    					}
	    				}
	    				min = Math.min(min, ct);
	    				if(ct==1){
	    					board[i][j] = (char) ('0'+pot);
    						break;
	    				}
	    			}
	    		}
	    	}
	    	if(min==10||min>1){
	    		break;
	    	}
		}
		return min;
	}
	
	public void putTrue(char[][] board,boolean[][][] table){
		for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[i][j]!='.'){
    				for(int k=0;k<9;k++){
    					table[i][j][k] = true;
    				}
    				for(int k=0;k<9;k++){
    					table[i][k][board[i][j]-'0']=true;
    				}
    				for(int k=0;k<9;k++){
    					table[k][j][board[i][j]-'0']=true;
    				}
    				int left_i = (i/3)*3;
    				int left_j = (j/3)*3;
    				for(int k1=left_i;k1<=left_i+2;k1++){
    					for(int k2=left_j;k2<=left_j+2;k2++){
    						table[k1][k2][board[i][j]-'0']=true;
    					}
    				}
    			}
    		}
    	}
	}
	
	public List<Integer> findMin(char[][] board){
		List<Integer> result = new ArrayList<Integer>();
		boolean[][][] table = new boolean[9][9][10];
		putTrue(board,table);
		int pi = 0,pj = 0;
		List<Integer> tmp = new ArrayList<Integer>();
    	int min = 10;
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			int ct = 0;
    			if(board[i][j]=='.'){
    				for(int k=1;k<=9;k++){
    					if(!table[i][j][k]){
    						ct++;
    					}
    				}
    				if(ct<min){
    					min = ct;
    					pi = i;
    					pj = j;
    					tmp.clear();
    					for(int k=1;k<=9;k++){
    						if(!table[i][j][k]){
    							tmp.add(k);
    						}
    					}
    				}
    			}
    		}
    	}
    	result.add(pi);
    	result.add(pj);
    	result.addAll(tmp);
		return result;
	}
	
	public int updateBoard(char[][] board){
		int min;
		List<Integer> savei = new ArrayList<Integer>();
		List<Integer> savej = new ArrayList<Integer>();
		while(true){
			boolean[][][] table = new boolean[9][9][10];
			putTrue(board,table);
	    	min = 10;
	    	for(int i=0;i<9;i++){
	    		for(int j=0;j<9;j++){
	    			int ct = 0;
	    			if(board[i][j]=='.'){
	    				int pot = 0;
	    				for(int k=1;k<=9;k++){
	    					if(!table[i][j][k]){
	    						ct++;
	    						pot = k;
	    					}
	    				}
	    				if(ct==0){
	    					int size = savei.size();
	    					for(int k=0;k<size;k++){
	    						board[savei.get(k)][savej.get(k)]='.';
	    					}
	    					return 0;
	    				}
	    				min = Math.min(min, ct);
	    				if(ct==1){
	    					board[i][j] = (char) ('0'+pot);
	    					savei.add(i);
	    					savej.add(j);
    						break;
	    				}
	    			}
	    		}
	    	}
	    	if(min==10||min>1){
	    		break;
	    	}
		}
		return min;
	}
	
	public boolean search(List<Integer> pans,char[][] board){
		int size = pans.size();
		char[][] copyBoard = new char[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				copyBoard[i][j] = board[i][j];
			}
		}
		for(int tmpi=2;tmpi<size;tmpi++){
			board[pans.get(0)][pans.get(1)] = (char)('0'+pans.get(tmpi));
			int result = updateBoard(board);
			if(result==10){
				return true;
			}
			if(result==0){
				continue;
			}
			List<Integer> newpans = findMin(board);
	    	if(search(newpans,board))return true;
	    	else{
	    		for(int i=0;i<9;i++){
	    			for(int j=0;j<9;j++){
	    				board[i][j] = copyBoard[i][j];
	    			}
	    		}
	    	}
		}
		board[pans.get(0)][pans.get(1)] = '.';
		return false;
	}
	
    public void solveSudoku(char[][] board) {
    	int result = initTable(board);
    	if(result==10){
    		return;
    	}
    	List<Integer> pans = findMin(board);
    	search(pans,board);
    }
    
    public static void main(String[] args) {
		char[][] board = new char[9][9];
		board[0] = "..9748...".toCharArray();
		board[1] = "7........".toCharArray();
		board[2] = ".2.1.9...".toCharArray();
		board[3] = "..7...24.".toCharArray();
		board[4] = ".64.1.59.".toCharArray();
		board[5] = ".98...3..".toCharArray();
		board[6] = "...8.3.2.".toCharArray();
		board[7] = "........6".toCharArray();
		board[8] = "...2759..".toCharArray();
		
//		board[0] = "53..7....".toCharArray();
//		board[1] = "6..195...".toCharArray();
//		board[2] = ".98....6.".toCharArray();
//		board[3] = "8...6...3".toCharArray();
//		board[4] = "4..8.3..1".toCharArray();
//		board[5] = "7...2...6".toCharArray();
//		board[6] = ".6....28.".toCharArray();
//		board[7] = "...419..5".toCharArray();
//		board[8] = "....8..79".toCharArray();
		
		board[0] = "...2...63".toCharArray();
		board[1] = "3....54.1".toCharArray();
		board[2] = "..1..398.".toCharArray();
		board[3] = ".......9.".toCharArray();
		board[4] = "...538...".toCharArray();
		board[5] = ".3.......".toCharArray();
		board[6] = ".263..5..".toCharArray();
		board[7] = "5.37....8".toCharArray();
		board[8] = "47...1...".toCharArray();				
		
		Solution obj = new Solution();
		obj.solveSudoku(board);
	}
}