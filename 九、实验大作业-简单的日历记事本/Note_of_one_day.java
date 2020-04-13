package java_final_exercise;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;

public class Note_of_one_day implements Runnable{
	 public int note_number=0;   //记录当天存储多少个备忘录
	 public int year,month,day;
	 public boolean[] is_saved=new boolean[25];     //记录当天哪个时间段已有备忘录存储
	 public Hashtable<Integer,String> specific_note=new Hashtable<Integer,String>();      
	 //具体存储24小时备忘录的Hash表
	 
	 private boolean[]  is_alerted=new boolean[25];  //备忘录是否已经提醒
	 Note_of_one_day(int year,int month,int day){
		 this.year=year;
		 this.month=month;
		 this.day=day;
	 }
	 public void run(){      //重写run方法来实现提醒功能
		 

		 int if_will_alert=1;    
		 //if_will_alert用来控制线程对象是否继续运行，如果当天的备忘录中还有未提醒的，则线程对象继续存在。
		 while(if_will_alert==1){
	    	 check_if_alert();
	    	 if_will_alert=0;
			 for(int i=1;i<25;i++)
				 if(is_alerted[i]==false&&is_saved[i]==true)
					 	if_will_alert=1;
	    	 try{
	    		 Thread.sleep(1000);

	    	 }
	    	 catch(Exception e){
	    		 System.out.println("timing error");
	    	 }
	     }
	 }
	 public void Save_a_note(int year,int month,int day,int hour,String content){   //保存一条备忘录
		 this.year=year;
		 this.month=month;
		 this.day=day;
		 specific_note.put(hour, content);
		 note_number++;
		 is_saved[hour]=true;
	 }
	 public void Delete_a_note(int year,int month,int day,int hour){     //删除一条备忘录
		 if(this.year==year&&this.month==month&&this.day==day)
			 specific_note.remove(hour);
		 note_number--;
		 is_saved[hour]=false;
	 }
	 public void check_if_alert(){     //检查是否提醒,提醒方式为JOptionPane.showMessageDialog
		 Calendar now_time=Calendar.getInstance();
		 int now_year=now_time.get(Calendar.YEAR);
		 int now_month=now_time.get(Calendar.MONTH)+1;
		 int now_day=now_time.get(Calendar.DAY_OF_MONTH);
		 int now_hour=now_time.get(Calendar.HOUR_OF_DAY);
		 if(year==now_year&&month==now_month&&day==now_day){
			 Enumeration e=specific_note.keys();      //利用枚举遍历所有 “键”
			 while(e.hasMoreElements()){
				 int hour=Integer.parseInt(e.nextElement().toString());
				 if(hour==now_hour&&is_alerted[hour]==false){
					 String message=specific_note.get(hour);
					 JOptionPane.showMessageDialog(null, message,"备忘录提醒",JOptionPane.INFORMATION_MESSAGE);
					 is_alerted[hour]=true;
				 }
			 }
		 }
	 }
}
