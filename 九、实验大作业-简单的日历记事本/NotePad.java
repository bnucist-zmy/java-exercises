package java_final_exercise;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;

public class NotePad extends JPanel implements ActionListener{      
	 //备忘录面板
	 //上方用于显示备忘录对应的时间,中间是显示备忘录内容，下方是两个按钮
     JTextArea text=new JTextArea(10,10);         //用于输入和查看备忘录内容
     JButton save_note=new JButton("保存备忘录");     //保存备忘录按钮
     JButton delete_note=new JButton("删除备忘录");      //删除备忘录按钮
     Hashtable<String,Note_of_one_day> if_contain_note=new Hashtable<String,Note_of_one_day>();   
     //集合类型，用于存放某一天的备忘录，键是某一天的日期，值是Note_of_one_day对象
     
     JLabel display_label;     //显示备忘录对应的时间
     
     
     int year,month,day,hour;
     
     NotePad(){
         //设置NotePad的初始年月日时和Calendar同步，都是程序启动时的时间
    	 Calendar start_calendar=Calendar.getInstance();
    	 year=start_calendar.get(Calendar.YEAR);
    	 month=start_calendar.get(Calendar.MONTH)+1;
    	 day=start_calendar.get(Calendar.DAY_OF_MONTH);
    	 hour=start_calendar.get(Calendar.HOUR_OF_DAY);
    	 //设置备忘录的时间展示面板
    	 display_label=new JLabel(""+year+"年"+month+"月"+day+"日"+hour+"时",JLabel.CENTER);
    	 display_label.setFont(new Font("TimesRoman",Font.BOLD,16));
    	 display_label.setForeground(Color.blue);
    	 
    	 JPanel south_panel=new JPanel();
    	 save_note.addActionListener(this);
    	 delete_note.addActionListener(this);
    	 this.setLayout(new BorderLayout());
    	 this.add(display_label,BorderLayout.NORTH);
    	 south_panel.add(save_note);
    	 south_panel.add(delete_note);
    	 this.add(south_panel, BorderLayout.SOUTH);
    	 this.add(new JScrollPane(text), BorderLayout.CENTER);
    	 
     }

     public void actionPerformed(ActionEvent e){   //点击按钮的事件处理
    	 if(e.getSource()==save_note){
    		 Save_contents(year,month,day);
    	 }
    	 else if(e.getSource()==delete_note){
    		 Delete_contents(year,month,day);
    	 }
     }
/*     public void setYear(int year)
     {   this.year=year;
     }
    public int getYear()
     {    return year;
     }
    public void setMonth(int month)
     {   this.month=month;
     } 
     public int getMonth()
     {   return month;
     } 
     public void setDay(int day)
     {   this.day=day;
     }
     public int getDay()
      {   return day;
      }*/
     public void setinfo(int year,int month,int day){    //设置NotePad的时间
    	 this.year=year;
    	 this.month=month;
    	 this.day=day;
     }
     public void Set_display_label(int year,int month,int day){   //设置记事本页面的时间显示区
    	 display_label.setText(""+year+"年"+month+"月"+day+"日"+hour+"时");
     }
/*     public void Set_text(String s){
    	 text.setText(s);
     }*/
     public void get_note_content(int year,int month,int day){    //尝试获取备忘录内容
    	 String key_of_day=""+year+""+month+""+day;
    	 
    	 if(if_contain_note.containsKey(key_of_day)){         //如果某一天的备忘录存在
    		 int note_count=if_contain_note.get(key_of_day).note_number;
    		 boolean[] if_exist=if_contain_note.get(key_of_day).is_saved;       //这些用来获取该天的备忘录存储于哪些时间段
    		 Object[] hour_array=new Object[note_count];
    		 int j=0;
    		 for(int i=1;i<=24;i++){
    			 if(if_exist[i]==true){
    				 hour_array[j]=i;
    				 j++;
    			 }
    		 }
    		 
    		 try{
    			 String op=JOptionPane.showInputDialog(this,"请选择要查看哪个小时的备忘录","提示",JOptionPane.QUESTION_MESSAGE,null,hour_array,hour_array[0]).toString();
    			 int hour=Integer.parseInt(op);
        		 String content=(if_contain_note.get(key_of_day)).specific_note.get(hour);
        		 text.setText(content);
    		 
    		 }
    		 catch(Exception e){
    			 return;
    		 }
    	 }
    	 else{
    		 String message="当天没有备忘录";
    		 text.setText("");
    		 JOptionPane.showMessageDialog(null, message,"提示",JOptionPane.INFORMATION_MESSAGE); 
    	 }
     }
     public void Save_contents(int year,int month,int day){   //保存备忘录
    	 String content=text.getText();
    	 String key_of_day=""+year+""+month+""+day;
    	 if(if_contain_note.containsKey(key_of_day)){       //如果当天已有备忘录存在，则询问备忘录存储于另外哪个小时
    		 int note_count=if_contain_note.get(key_of_day).note_number;
    		 boolean[] if_exist=if_contain_note.get(key_of_day).is_saved;
    		 Object[] hour_array=new Object[24-note_count];
    		 int j=0;
    		 for(int i=1;i<=24;i++){
    			 if(if_exist[i]==false){
    				 hour_array[j]=i;
    				 j++;
    			 }
    		 }
    		 try{
    			 String op=JOptionPane.showInputDialog(this,"请选择要保存备忘录于哪个小时","提示",JOptionPane.QUESTION_MESSAGE,null,hour_array,hour_array[0]).toString();
    		 //if(op==null||op=="") return;
    		     int selected_hour=Integer.parseInt(op);
    		     this.hour=selected_hour;
    		     if_contain_note.get(key_of_day).Save_a_note(year, month, day, selected_hour, content);
    		     JOptionPane.showMessageDialog(null, "备忘录保存成功","提示",JOptionPane.INFORMATION_MESSAGE);
    		 }
    		 catch(Exception e){
    			 return;
    		 }
    	}
    	 else{                               //当天是第一次创建备忘录
    		 if_contain_note.put(key_of_day, new Note_of_one_day(year,month,day));
    		 Object[] hours={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};       //要注意这里Object数组里的数据为Integer类型，不能直接转换为(String)Integer
        	 
    		 try{
    			 String op=JOptionPane.showInputDialog(this,"请选择要保存备忘录于哪个小时","提示",JOptionPane.QUESTION_MESSAGE,null,hours,hours[0]).toString(); 
    			 int selected_hour=Integer.parseInt(op);
    			 this.hour=selected_hour;
    			 if_contain_note.get(key_of_day).Save_a_note(year, month, day, selected_hour, content);
    			 new Thread(if_contain_note.get(key_of_day)).start();
    			 JOptionPane.showMessageDialog(null, "备忘录保存成功","提示",JOptionPane.INFORMATION_MESSAGE);
    		 }
    		 catch(Exception e){
    			 return;
    		 }
    	}
    	 text.setText("");
     }
     public void Delete_contents(int year,int month,int day){    //删除备忘录
    	 String key_of_day=""+year+""+month+""+day;
    	 if(if_contain_note.containsKey(key_of_day)){
    		 int note_count=if_contain_note.get(key_of_day).note_number;
    		 boolean[] if_exist=if_contain_note.get(key_of_day).is_saved;
    		 Object[] hour_array=new Object[note_count];
    		 int j=0;
    		 for(int i=1;i<=24;i++){
    			 if(if_exist[i]==true){
    				 hour_array[j]=i;
    				 j++;
    			 }
    		 }
        	 try{
    		 String op=JOptionPane.showInputDialog(this,"请选择要删除哪个小时的备忘录","提示",JOptionPane.QUESTION_MESSAGE,null,hour_array,hour_array[0]).toString();
        	 int selected_hour=Integer.parseInt(op);
        	 this.hour=selected_hour;
        	 if_contain_note.get(key_of_day).Delete_a_note(year, month, day, selected_hour);
    		 if(if_contain_note.get(key_of_day).note_number==0){
    			 if_contain_note.remove(key_of_day);
    		 }
    		 JOptionPane.showMessageDialog(null, "备忘录删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
    		 text.setText("");
             }
        	 catch(Exception e){
        		 return;
        	 }
    	 }
    	 else{
    		 String m=""+year+"年"+month+"月"+day+"无日志记录";
    		 JOptionPane.showMessageDialog(null, m,"提示",JOptionPane.INFORMATION_MESSAGE);
    	 }
     }


}
