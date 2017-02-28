package ebanx;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Template {
	
	static class FrequencyComparator implements Comparator<Integer> {
        Map<Integer,Integer> refMap;
        public FrequencyComparator(Map<Integer,Integer> base) {
            this.refMap = base;
        }

        @Override
        public int compare(Integer k1, Integer k2) {
            Integer val1 = refMap.get(k1);
            Integer val2 = refMap.get(k2);

            int num = val1.compareTo(val2)  ;
            // if frequencies are same then compare number itself
            return  num == 0 ? k1.compareTo(k2)   : num;
        }
    }

	
	static void customSort(int[] arr) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for ( int i=0; i<arr.length; i++){
			if ( map.containsKey(arr[i]) )
				map.put(arr[i], map.get(arr[i])+1);
			else 
				map.put(arr[i], 1);
		}

		System.out.println(map);
		
		Collection<Integer> values = map.values();
		Set<Integer> valuesSet = new HashSet<Integer>();
		for (Integer integer : values) {
			valuesSet.add(integer);
		}
		
		for (Integer i : valuesSet) {
			System.out.println(i);	
		}
		
		FrequencyComparator comp = new FrequencyComparator(map);
        TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(comp);
        sortedMap.putAll(map);
        for(Integer i : sortedMap.keySet()) {
            int frequencey = sortedMap.get(i);
            for(int count  = 1 ; count <= frequencey ; count++) {
                System.out.print(i + " " );
            }
        }
		
		

    }

	public static void main(String[] args) {
		
		customSort(new int[]{5,3,1,2,2,4});
		
		String a = "ADEEEEEE";
		String b = "BC";
		String c;
		
		int lenghtA = a.length();
		int lenghtB = b.length();
		int minLenght = lenghtB;
		StringBuilder sb = new StringBuilder();
		
		//Swap
		if ( lenghtB > lenghtA ){
			minLenght = lenghtA;
		}
		
		int i = 0;
		for( ; i < minLenght; i++ ){
			sb.append(a.charAt(i));
			sb.append(b.charAt(i));
		}
		
		if ( lenghtA > lenghtB ){
			sb.append(a.substring(i));
		} else {
			sb.append(b.substring(i));
		}
		
		
		System.out.println(sb.toString());
		
//		Scanner in = new Scanner(System.in);
//		int T, A, div, mod;
//
//		String line = in.nextLine();
//		T = Integer.parseInt(line);
//
//		StringBuilder sb;
//
//		for (int i = 0; i < T; i++) {
//			sb = new StringBuilder();
//			line = in.nextLine();
//			A = Integer.parseInt(line);
//
//			int pivot = getPivot(A);
//
//			if (pivot < 0) {
//				System.out.println("-1");
//			} else {
//				int repeat = pivot / 3;
//				while (repeat-- != 0) {
//					sb.append("555");
//				}
//
//				repeat = (A - pivot) / 5;
//				while (repeat-- != 0) {
//					sb.append("33333");
//				}
//
//				System.out.println(sb.toString());
//			}
//
//		}
//
//		in.close();
	}

}
