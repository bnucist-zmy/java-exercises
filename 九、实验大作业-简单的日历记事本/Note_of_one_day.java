package java_final_exercise;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;

public class Note_of_one_day implements Runnable{
	 public int note_number=0;   //��¼����洢���ٸ�����¼
	 public int year,month,day;
	 public boolean[] is_saved=new boolean[25];     //��¼�����ĸ�ʱ������б���¼�洢
	 public Hashtable<Integer,String> specific_note=new Hashtable<Integer,String>();      
	 //����洢24Сʱ����¼��Hash��
	 
	 private boolean[]  is_alerted=new boolean[25];  //����¼�Ƿ��Ѿ�����
	 Note_of_one_day(int year,int month,int day){
		 this.year=year;
		 this.month=month;
		 this.day=day;
	 }
	 public void run(){      //��дrun������ʵ�����ѹ���
		 

		 int if_will_alert=1;    
		 //if_will_alert���������̶߳����Ƿ�������У��������ı���¼�л���δ���ѵģ����̶߳���������ڡ�
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
	 public void Save_a_note(int year,int month,int day,int hour,String content){   //����һ������¼
		 this.year=year;
		 this.month=month;
		 this.day=day;
		 specific_note.put(hour, content);
		 note_number++;
		 is_saved[hour]=true;
	 }
	 public void Delete_a_note(int year,int month,int day,int hour){     //ɾ��һ������¼
		 if(this.year==year&&this.month==month&&this.day==day)
			 specific_note.remove(hour);
		 note_number--;
		 is_saved[hour]=false;
	 }
	 public void check_if_alert(){     //����Ƿ�����,���ѷ�ʽΪJOptionPane.showMessageDialog
		 Calendar now_time=Calendar.getInstance();
		 int now_year=now_time.get(Calendar.YEAR);
		 int now_month=now_time.get(Calendar.MONTH)+1;
		 int now_day=now_time.get(Calendar.DAY_OF_MONTH);
		 int now_hour=now_time.get(Calendar.HOUR_OF_DAY);
		 if(year==now_year&&month==now_month&&day==now_day){
			 Enumeration e=specific_note.keys();      //����ö�ٱ������� ������
			 while(e.hasMoreElements()){
				 int hour=Integer.parseInt(e.nextElement().toString());
				 if(hour==now_hour&&is_alerted[hour]==false){
					 String message=specific_note.get(hour);
					 JOptionPane.showMessageDialog(null, message,"����¼����",JOptionPane.INFORMATION_MESSAGE);
					 is_alerted[hour]=true;
				 }
			 }
		 }
	 }
}
