package my_calculator;
import java.util.Scanner;
public class calculator_class implements calculator_interface{
     public double Addition(double a,double b){
    	 return a+b;
     }
     public double Subtraction(double a,double b){
    	 return a-b;
     }
     public double Multiplication(double a,double b){
    	 return a*b;
     }
	public double Division(double a,double b){
		try{
		     double result;
		     int divisor=0;
			 if(b==0)  result=(int)a/divisor;
			 else result=a/b;
			 return  result;
		}
		catch(ArithmeticException ae){
			System.out.println("���ݱ�0����"+ae.getMessage());
			System.out.println("������Ϊ��"+a+"���������������");
			Scanner sc = new Scanner(System.in); 
			double new_parameter=sc.nextDouble();
			sc.close();
			return a/new_parameter;
		}
	}
}
