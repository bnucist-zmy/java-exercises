package test1_programme;

public class Line extends Point{
	 double length;
	 double angle; 
	 public
		 Line(){}
		 void set_information(double new_x,double new_y,double new_length,double new_angle){
		 set_coordinate(new_x,new_y);
		 length=new_length;
		 angle=new_angle;
	 }   
	     void print_coordinate(){
	    	 double x2=get_x_coordinate()+length*Math.cos(angle/360*2*Math.PI);
	    	 double y2=get_y_coordinate()+length*Math.sin(angle/360*2*Math.PI);
	    	 System.out.println("x1="+get_x_coordinate()+"\n"+"y1="+get_y_coordinate()+"\n"+"x2="+x2+"\n"+"y2="+y2);
	     }
}