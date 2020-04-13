package test1_programme;

import java.util.*;


public class Test1 {

	public static void main(String[] args) {
		Line sample_line;
		sample_line=new Line();
		Scanner sc = new Scanner(System.in);
		System.out.println("输入长度：");
		double new_length=sc.nextDouble();
		System.out.println("输入角度：");
		double new_angle=sc.nextDouble();
		sample_line.set_information(0, 0, new_length, new_angle);
		sample_line.print_coordinate();
        sc.close();
	}

}
