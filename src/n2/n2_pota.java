package n2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n2_pota {
	private static int[] array;
	
	public static void main(String[] args) {
		int lenghtArray;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o tamanho do vetor: ");
		
		try {
			lenghtArray = scan.nextInt();
		} catch (Exception e) {
			lenghtArray = generateRandomNumber(100, 5000);
			System.out.println("Vetor foi gerado com tamanho de " + lenghtArray);
		}
		
		array = new int[lenghtArray];
		array = fillArray(array);
		
		Map<Integer, Integer> statistics = generateStatistics(array);
		printResult(statistics);
		scan.nextLine();
	}
	
	public static int generateRandomNumber(int min, int max) {
		return (int)(Math.random()*((max-min)+1))+min; 
	}
	
	public static void printResult(Map<Integer, Integer> statistics) {
		for(int i=0; i<statistics.size(); i++) {
			System.out.println("O numero " + i + " apareceu "
					+ statistics.get(i) + " vezes");
		}
	}
	
	public static Map<Integer, Integer> generateStatistics(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<51; i++) {
			map.put(i, 0);
		}
		
		for (int value : arr) {
			map.put(value, map.get(value) + 1);
		}
		
		return map;
	}
	
	public static int[] fillArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = generateRandomNumber(0, 50);
		}
		return arr;
	}

}
