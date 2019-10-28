
public class GleichheitArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 4, 3 };
		int[] array2 = { 1, 4, 3 };

		boolean vergleich = arrayCheck(array1, array2);

		if (vergleich == true) {
			System.out.println("Arrays sind gleich!");
		} else {
			System.out.println("Arrays sind nicht gleich!");
		}
	}

	public static boolean arrayCheck(int[] a, int[] b) {
		if (a == null || b == null || a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

}
