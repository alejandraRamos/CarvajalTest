package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	/**
	 * Counter of entered ranges
	 */
	private static int rangeCount;
	/**
	 * Array to save entered range's list
	 */
	private static ArrayList<int[]> rangeList; 
	
	/**
	 * Is a menu that allow to user input the needed information to solve problem.
	 * @param index Counter of entered ranges
	 */
	public static void inputNewRange(int index) throws InputMismatchException {

		System.out.println("Usted debe ingresar unos números que formaran el rango " + index);

		System.out.println("Por favor introduzca el número minímo del rango:");
		int inputNumber1 = 0;
		Scanner inputScanner1 = new Scanner(System.in);
		inputNumber1 = inputScanner1.nextInt();

		System.out.println("Por favor introduzca el número máximo del rango:");
		int inputNumber2 = 0;
		Scanner inputScanner2 = new Scanner(System.in);
		inputNumber2 = inputScanner2.nextInt();

		System.out.println(
				"Entrada recibida por teclado es: \"" + "[" + inputNumber1 + " , " + inputNumber2 + "]" + "\"");
		
		int[] range = {inputNumber1,inputNumber2};
		rangeList.add(range);
	}
	
	/**
	 * This method allow sort the range's list input by user
	 */
	public static void sortRanges() {
		Collections.sort(rangeList, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				boolean first = (arr1[1] == arr2[1]);

				if (first) {
					return 0;
				}
				return (arr1[1] < arr2[1]) ? -1 : 1;
			}
		});
	}
	
	/**
	 * Given two arrays, this method find if there is an intersection between them.
	 * @param range1 first array to compare
	 * @param range2 second array to compare
	 * @return true, if there is an intersection between two arrays. false, if isn't.
	 */
	public static boolean hasIntersection(int[] range1, int[] range2) {
		boolean hasIntersection=false;
			
		if(range1[1] >= range2[0]) {
			hasIntersection=true;
			int[] newRange = {range1[0], range2[1]};
			rangeList.remove(range1);
			rangeList.remove(range2);
			rangeList.add(newRange);
			sortRanges();

		}
		return hasIntersection;
	}
	
	/**
	 * This method start the program 
	 * @param args
	 */
	public static void main(String[] args) {
		rangeCount=1;
		rangeList = new ArrayList<>();
		boolean flag=true;
		
		while (flag) {
			try {
				inputNewRange(rangeCount);
				flag=false;
			} catch (InputMismatchException e) {
				System.out.println("Debe ingresar un número, intente nuevamente");
			}

		}
		
		boolean exitFlag=true;
		while (exitFlag) {
			System.out.println("Si desea ingresar otro rango de números, presione 1");
			System.out.println("En caso contrario, presione 2");

			int inputOption = 0;
			Scanner inputScanner3 = new Scanner(System.in);
			inputOption = inputScanner3.nextInt();
			switch (inputOption) {
			case 1:
				rangeCount++;
				flag = true;
				while (flag) {
					try {
						inputNewRange(rangeCount);
						flag = false;
					} catch (InputMismatchException e) {
						System.out.println("Debe ingresar un número, intente nuevamente");
					}

				}
				break;
			case 2:
				exitFlag = false;
				break;
			default:
				System.out.println("Ingresaste una opción invalida, intente nuevamente");
			}
		}
		
		sortRanges(); //all ranges causes intersections or no ranges causes intersections, have a O(n) complexity
		
		//show the range's list entered by user in a sorted way 
		System.out.println("Los rangos que usted ingresó son:");
		for (int[] inputRangeList : rangeList) { //all ranges causes intersections or no ranges causes intersections, have a O(n) complexity
			System.out.println(Arrays.toString(inputRangeList));
		}
		//is responsible for iterating through each element of the array looking for intersections between them
		for(int i=0; i<rangeList.size();) { // If no ranges causes intersections, have a O(n) complexity. If all ranges causes intersections, have a O(n^2) complexity  
			boolean hasIntersectionFlag=false;
			if(!((i+1)>=rangeList.size())) {
				hasIntersectionFlag= hasIntersection(rangeList.get(i),rangeList.get(i+1));
			}
			if(hasIntersectionFlag) {
				i=0;
			}else {
				i++;
			}
		}
		
		//show the resulting range's list 
		System.out.println("Los rangos resultantes son: "); 
		for (int[] solveRangeList : rangeList) {// If no ranges causes intersections, have a O(n) complexity. If all ranges causes intersections, have a O(1) complexity
			System.out.println(Arrays.toString(solveRangeList));
		}
		

	}

}
