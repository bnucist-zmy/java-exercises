package my_calculator;
import java.util.Scanner;
public class main_pro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		double a,b;
		char choice;
		String s;
		System.out.println("请输入两个数据a和b:");
	    a=sc.nextDouble();
	    b=sc.nextDouble();
		System.out.println("请输入+、-、*、/ 来选择功能：");
		s=sc.next();
		choice=s.charAt(0);
		calculator_class test_sample=new calculator_class();
		switch(choice){
		case '+':
			System.out.println("a+b="+test_sample.Addition(a,b));
			break;
		case '-':
			System.out.println("a-b="+test_sample.Subtraction(a,b));
			break;
		case '*':
			System.out.println("a*b="+test_sample.Multiplication(a,b));
			break;
		case '/':
			System.out.println("a/b="+test_sample.Division(a,b));
			break;
		default:
			break;
				
		}
		System.out.println("the max number between "+a+" "+b+"is "+Math.max(a,b));
		System.out.println("the absolute value of a-b is "+Math.abs(a-b));
		sc.close();
	}

}
