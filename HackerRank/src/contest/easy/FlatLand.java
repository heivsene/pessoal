package contest.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FlatLand {
		
		public static void main(String[] args) {
			 Scanner in = new Scanner(System.in);
		        int n = in.nextInt();
		        int m = in.nextInt();
		        List<Integer> cities = new ArrayList<Integer>(n);
		        
		        Integer zero = Integer.valueOf(0);
		        for( int i = 0; i < n ; i++){
		        	cities.add(zero);
		        }
		        
		        List<Integer> stations = new ArrayList<Integer>(m); 
		        for(int c_i=0; c_i < m; c_i++){
		        	stations.add(in.nextInt());
		        }
		        
		        
		        if ( m == n ){
		        	System.out.println(0);
		        	in.close();
		        	System.exit(0);
		        }
	//	        System.out.println(cities);
	//	        System.out.println(stations);
		        Collections.sort(stations);
		        
	
		        //First Position
		        if ( stations.size() == 1 ){
		        	int index = stations.get(0).intValue();
		        	//Decrementar os começos;
		        	somarAntes(0, index, cities);
		        	
		        	//Incrementar o fim
		        	somarDepois(index, cities.size()-1, cities);
		        	
		        	in.close();
		        	System.exit(0);
		        }
		        
		      
		        
		        
	        	int index = stations.get(0).intValue();
	        	
	        	//Inicio;
	        	somarAntes(0, index, cities);
		        
	        	//Somando os Meios
	        	for ( int i = 1 ; i <= m-1 ; i++ ){
	        		int lower = stations.get(i-1).intValue();
	        		int upper = stations.get(i).intValue();
	        		int meio = (upper+lower)/2;
	        		somarDepois(lower, meio, cities);
	        		somarAntes(meio+1, upper, cities);
	        	}
	        	
	        	//Incrementar o fim
	        	index = stations.get(m-1).intValue();
	        	somarDepois(index, cities.size()-1, cities);
		        
		        
		        System.out.println(Collections.max(cities));
		        
		        
		        in.close();
	        	System.exit(0);
		        
		}
		
		static void somarAntes(int inicio, int end, List<Integer> cities){
			for ( int i = end; i >= inicio ; i-- ){
	    		int num = cities.get(i).intValue();
	    		num = num + end - i;
	    		cities.set(i, num);
	    	}
		}
		
		static void somarDepois(int inicio, int end, List<Integer> cities){
			for ( int i = end; i >= inicio ; i-- ){
	    		int num = cities.get(i).intValue();
	    		num = num + i - inicio;
	    		cities.set(i, num);
	    	}
		}

}
