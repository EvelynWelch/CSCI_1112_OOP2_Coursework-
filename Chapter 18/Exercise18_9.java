// author: Evie Welch
// date: 03/06/23

public class Exercise18_9 {
	public static void reverseDisplay(String value) {
		reverseDisplay(value, value.length() -1);
	}
	private static void reverseDisplay(String value, int index) {
		if(index < 0) {
			System.out.println("");
		} else {
			System.out.print(value.charAt(index));
			reverseDisplay(value, (index -1));
		}
	}
	public static void main(String[] args) {
		String s = "Lorem ipsum dolor sit amet";
		System.out.println(s);
		reverseDisplay(s);
	}
}
