package automation;

public class CoolNumbers {
	static int count = 0;
	static int start = 6;
	static int stop = 3000;

	public static void main(String[] args) {
		CoolNumber(2520);

	}
// to find cool numbers

	public static void CoolNumber(int x) {

		for (int i = start; i < stop; i++) {
			if ((x % 3 == 1) && (x % 4 == 1) && (x % 5 == 1) && (x % 6 == 1)) {
				System.out.println (x);
			} else {
				System.out.println(x + "is not a cool number");
			}
		}
	}

	// to find count of cool numbers
	public static boolean isCoolNumber(int x) {
		return (x % 3 == 1) && (x % 4 == 1) && (x % 5 == 1) && (x % 6 == 1);
	}

	public static void countCoolNumbers(int stop) {
		for (int i = start; i < stop; i++) {
			if (isCoolNumber(i)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
