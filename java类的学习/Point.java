package test1_programme;

public class Point {
	private
		double x1,y1,x0,y0;
    public
    	Point(){
    	x0=0;y0=0;
    }
    	double get_x_coordinate(){
	         return x1;
}       double get_y_coordinate(){
	         return y1;
}       void set_coordinate(double new_x,double new_y){
	         x1=new_x;
	         y1=new_y;
}       void set_origin(double new_x0,double new_y0){
	          x0=new_x0;
	          y0=new_y0;
}
}
