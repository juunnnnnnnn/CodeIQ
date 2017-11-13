package standardOutput;

import java.util.Scanner;

class StandardOutput {
	public static void main(String[]args){
		Scanner cin = new Scanner(System.in);
		String line;
		for(;cin.hasNext();){
			line = cin.nextLine();
			System.out.println(line.toUpperCase());
			System.out.println(line);

		}

	}

}
