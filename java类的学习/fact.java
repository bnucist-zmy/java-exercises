package test2;

import java.util.*;
public class Class2 {
//Fact class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum=1;
		System.out.println("ÊäÈënµÄÖµ:");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
			sum*=i;
		System.out.println("sum="+sum);
		sc.close();
	}

}
