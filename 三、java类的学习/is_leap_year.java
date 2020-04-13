package test2;
import java.util.*;
public class Class3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÄê·İ:");
		int year=sc.nextInt();
		if((year%4==0&&year%100!=0)||(year%400==0))
			System.out.println(year+"is a leap year.");
		else
			System.out.println(year+"is not a leap year.");
		sc.close();
	}

}
