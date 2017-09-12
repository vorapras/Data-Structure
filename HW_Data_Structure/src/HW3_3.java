import java.util.Scanner;

public class HW3_3 {

	public static void main(String[] args) {
		String[][] match = new String[10][2];
		for (int i = 0; i < match.length; i++) {
			for (int j = 0; j < match[0].length; j++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please input team's name and score");
				match[i][j] = sc.nextLine();
			}
		}
		
		for (int i = 0; i < match.length; i++) {
			for (int j = 0; j < match[0].length; j++) {
				System.out.print(match[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}
