// Author: Evie Welch
// date 08/03/23

import java.util.ArrayList;

public class Exercise19_3 {

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		ArrayList<E> newList = new ArrayList<>();
		for(E element : list) {
			if(!newList.contains(element)) {
				newList.add(element);
			}
		}
		return newList;
		
	}
	
	public static void main(String[] args) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		    list.add(14);
		    list.add(24);
		    list.add(14);
		    list.add(42);
		    list.add(25);
		    
		    ArrayList<Integer> newList = removeDuplicates(list);
		    
		    System.out.print(newList);

	}

}
