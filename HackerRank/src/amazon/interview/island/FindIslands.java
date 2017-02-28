package amazon.interview.island;

public class FindIslands {
	
	private static boolean visited[][];
	private static int map[][];
	private static int count = 0;
	
	
	public static void main(String[] args) {
		//Loading image
		map = createImageMap();

		//Creating an empty unvisited map
		visited = new boolean[map.length][map[0].length];


		for (int j = 0 ; j < map.length; j++ ){
			for ( int i = 0 ; i < map[0].length; i++ ){
				if ( !isVisited(j, i) ) {
					if ( isIsland(j, i) ){
						count++;
						doRecursiveSearch(j,i);
					}
				}
			}
		}
		
		System.out.println("There are "+count+" Islands.");
		
		
	}

	private static void doRecursiveSearch(int j, int i) {
		visit(j, i);
		
		for ( int b = -1 ; b <= 1; b++ ){
			for ( int a = -1 ; a <= 1; a++ ){
				//check for the origin
				if ( a == 0 && b == 0)
					continue;
				
				//check for edges
				if ( (j + b < 0) || (j + b > map.length-1) || 
					 (i + a < 0) || (i + a > map[0].length-1)) {
					continue;
				}
			
				if ( !isVisited(j+b, i+a) ) {
					if ( isIsland(j+b, i+a) ){
						doRecursiveSearch(j+b,i+a);
					}
				}
				
			}
		}
	}

	private static void visit(int j, int i){
		visited[j][i] = true;
	}
	
	private static boolean isVisited(int j, int i){
		return visited[j][i];
	}
	
	private static boolean isIsland(int j, int i){
		return map[j][i]==1;

	}

	
	private static int[][] createImageMap() {
		int arr[][] = new int[][]{
		  { 1, 1, 0, 0, 0, 1, 0, 0, 1, 1 },
		  { 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
		  { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
		  { 1, 1, 0, 0, 0, 1, 0, 0, 1, 0 },
		  { 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 }
		};
		return arr;
	}

}
