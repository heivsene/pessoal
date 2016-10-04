package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cavity-map
 * @author G0012477
 * Problem: Cavity Map
 * cd C:\workspace\HackerRank\bin\
 * java easy.CavityMap < ../resource/CavityMap.in
 *
 */
public class CavityMap {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = Integer.parseInt(in.nextLine());
	        List<char[]> mapa = new ArrayList<char[]>();
	        
	        for(int i = 0; i < t; i++){
	        	String linha = in.nextLine();
	        	char[] line = linha.toCharArray();
	        	mapa.add(line);
	        }
	        
	        solve(mapa);
	        in.close();
	    }
	    
	    private static void solve(List<char[]> mapa){
	    	StringBuilder sb = new StringBuilder();
	        if ( mapa.size() <= 2 ){
	        	for (char[] cs : mapa) {
	        		System.out.println(new String(cs));
				}
	        	return;
	        }
	        
	        sb.append(mapa.get(0));
	        sb.append(System.lineSeparator());
	        for ( int i = 1; i < (mapa.size()-1); i++ ){
	        	char[] lineCima = mapa.get(i-1);
	        	char[] lineAtual = mapa.get(i);
	        	char[] lineBaixo = mapa.get(i+1);
	        	
	        	sb.append(lineAtual[0]);
	        	for ( int j = 1 ; j < (lineAtual.length-1) ; j++ ){
	        		char cima, baixo, direita, esquerda, atual;
	        		atual = lineAtual[j];
	        		cima = lineCima[j];
	        		baixo = lineBaixo[j];
	        		direita = lineAtual[j+1];
	        		esquerda = lineAtual[j-1];
	        		
	        		if ( atual > cima && atual > baixo && atual > esquerda && atual > direita ){
	        			sb.append('X');
	        		} else {
	        			sb.append(atual);
	        		}
	        	}
	        	sb.append(lineAtual[lineAtual.length-1]);
	        	sb.append(System.lineSeparator());
	        }
	        
	        sb.append(mapa.get(mapa.size()-1));
	        
	        System.out.println(sb.toString());
	        
	    }
	    
}
