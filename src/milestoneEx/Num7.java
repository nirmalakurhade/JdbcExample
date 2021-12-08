package milestoneEx;

import java.util.Scanner;

public class Num7 {
 public static void main(String[] args) {
	int i,j,n;
	System.out.println("Enter no.of rows");
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	for(i=1;i<=n;i++) {
		for(j=1;j<=n;j++) {
			if(i==1||i==5||j==1||j==5)
				System.out.print("#");
				else
					System.out.print("*");
			}
		
	System.out.println();
	}
 }
}

