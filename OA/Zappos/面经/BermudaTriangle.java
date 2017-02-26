public class BermudaTriangle {
	public static int bermudaTriangle (int x1, int y1, int x2, int y2, int x3, int y3, int px, int py, int bx, int by) {
		if (!isTriangle(x1, y1, x2, y2, x3, y3)) {
			return 0;
		}
		boolean p = inTriangle(x1, y1, x2, y2, x3, y3, px, py);
		boolean b = inTriangle(x1, y1, x2, y2, x3, y3, bx, by);
		if (p && b) {
			return 3;
		}
		else if (!p && !b) {
			return 4;
		}
		else if (p && !b) {
			return 1;
		}
		else{
			return 2;
		}
	}
	public static boolean isTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (y2 - y1) *(x3 - x2) != (y3 - y2) * (x2 - x1);
	}
	public static boolean inTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
		char line1 = lineSide(x1, y1, x3, y3, x, y);
		char line2 = lineSide(x2, y2, x1, y1, x, y);
		char line3 = lineSide(x3, y3, x2, y2, x, y);
		if (line1 == line2 && line2 == line3 && line1 != 'n' || line1 == '0' || line2 == '0' || line3 == '0') {
			return true;
		}
		else {
			return false;
		}
	}
	public static char lineSide(int x1, int y1, int x2, int y2, int x, int y) {
		int result = (y - y1) * (x2 - x1) - (y2 - y1) * (x - x1);
		/*else if (y1 == y2 && x1 != x2) {
			if (x <= Math.max(x1, x2) && x >= Math.min(x1, x2)) {
				return '0';
			}
			else {
				return 'n';
			}
		}*/
		/*else if (y1 != y2 && x1 == x2) {
			if (y <= Math.max(y1, y2) && y >= Math.min(y1, y2)) {
				return '0';
			}
			else {
				return 'n';
			}
		}*/
		if (result > 0) {
			return 'r';
		}
		else if (result < 0) {
			return 'l';
		}
		else {
			if (x <= Math.max(x1, x2) && x >= Math.min(x1, x2) && y <= Math.max(y1, y2) && y >= Math.min(y1, y2)) {
				return '0';
			}
			else {
				return 'n';
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(bermudaTriangle(3,1,7,1,5,5,1,1,2,2));

	}
}
