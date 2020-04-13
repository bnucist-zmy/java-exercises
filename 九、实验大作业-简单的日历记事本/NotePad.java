package java_final_exercise;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;

public class NotePad extends JPanel implements ActionListener{      
	 //����¼���
	 //�Ϸ�������ʾ����¼��Ӧ��ʱ��,�м�����ʾ����¼���ݣ��·���������ť
     JTextArea text=new JTextArea(10,10);         //��������Ͳ鿴����¼����
     JButton save_note=new JButton("���汸��¼");     //���汸��¼��ť
     JButton delete_note=new JButton("ɾ������¼");      //ɾ������¼��ť
     Hashtable<String,Note_of_one_day> if_contain_note=new Hashtable<String,Note_of_one_day>();   
     //�������ͣ����ڴ��ĳһ��ı���¼������ĳһ������ڣ�ֵ��Note_of_one_day����
     
     JLabel display_label;     //��ʾ����¼��Ӧ��ʱ��
     
     
     int year,month,day,hour;
     
     NotePad(){
         //����NotePad�ĳ�ʼ������ʱ��Calendarͬ�������ǳ�������ʱ��ʱ��
    	 Calendar start_calendar=Calendar.getInstance();
    	 year=start_calendar.get(Calendar.YEAR);
    	 month=start_calendar.get(Calendar.MONTH)+1;
    	 day=start_calendar.get(Calendar.DAY_OF_MONTH);
    	 hour=start_calendar.get(Calendar.HOUR_OF_DAY);
    	 //���ñ���¼��ʱ��չʾ���
    	 display_label=new JLabel(""+year+"��"+month+"��"+day+"��"+hour+"ʱ",JLabel.CENTER);
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

     public void actionPerformed(ActionEvent e){   //�����ť���¼�����
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
     public void setinfo(int year,int month,int day){    //����NotePad��ʱ��
    	 this.year=year;
    	 this.month=month;
    	 this.day=day;
     }
     public void Set_display_label(int year,int month,int day){   //���ü��±�ҳ���ʱ����ʾ��
    	 display_label.setText(""+year+"��"+month+"��"+day+"��"+hour+"ʱ");
     }
/*     public void Set_text(String s){
    	 text.setText(s);
     }*/
     public void get_note_content(int year,int month,int day){    //���Ի�ȡ����¼����
    	 String key_of_day=""+year+""+month+""+day;
    	 
    	 if(if_contain_note.containsKey(key_of_day)){         //���ĳһ��ı���¼����
    		 int note_count=if_contain_note.get(key_of_day).note_number;
    		 boolean[] if_exist=if_contain_note.get(key_of_day).is_saved;       //��Щ������ȡ����ı���¼�洢����Щʱ���
    		 Object[] hour_array=new Object[note_count];
    		 int j=0;
    		 for(int i=1;i<=24;i++){
    			 if(if_exist[i]==true){
    				 hour_array[j]=i;
    				 j++;
    			 }
    		 }
    		 
    		 try{
    			 String op=JOptionPane.showInputDialog(this,"��ѡ��Ҫ�鿴�ĸ�Сʱ�ı���¼","��ʾ",JOptionPane.QUESTION_MESSAGE,null,hour_array,hour_array[0]).toString();
    			 int hour=Integer.parseInt(op);
        		 String content=(if_contain_note.get(key_of_day)).specific_note.get(hour);
        		 text.setText(content);
    		 
    		 }
    		 catch(Exception e){
    			 return;
    		 }
    	 }
    	 else{
    		 String message="����û�б���¼";
    		 text.setText("");
    		 JOptionPane.showMessageDialog(null, message,"��ʾ",JOptionPane.INFORMATION_MESSAGE); 
    	 }
     }
     public void Save_contents(int year,int month,int day){   //���汸��¼
    	 String content=text.getText();
    	 String key_of_day=""+year+""+month+""+day;
    	 if(if_contain_note.containsKey(key_of_day)){       //����������б���¼���ڣ���ѯ�ʱ���¼�洢�������ĸ�Сʱ
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
    			 String op=JOptionPane.showInputDialog(this,"��ѡ��Ҫ���汸��¼���ĸ�Сʱ","��ʾ",JOptionPane.QUESTION_MESSAGE,null,hour_array,hour_array[0]).toString();
    		 //if(op==null||op=="") return;
    		     int selected_hour=Integer.parseInt(op);
    		     this.hour=selected_hour;
    		     if_contain_note.get(key_of_day).Save_a_note(year, month, day, selected_hour, content);
    		     JOptionPane.showMessageDialog(null, "����¼����ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
    		 }
    		 catch(Exception e){
    			 return;
    		 }
    	}
    	 else{                               //�����ǵ�һ�δ�������¼
    		 if_contain_note.put(key_of_day, new Note_of_one_day(year,month,day));
    		 Object[] hours={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};       //Ҫע������Object�����������ΪInteger���ͣ�����ֱ��ת��Ϊ(String)Integer
        	 
    		 try{
    			 String op=JOptionPane.showInputDialog(this,"��ѡ��Ҫ���汸��¼���ĸ�Сʱ","��ʾ",JOptionPane.QUESTION_MESSAGE,null,hours,hours[0]).toString(); 
    			 int selected_hour=Integer.parseInt(op);
    			 this.hour=selected_hour;
    			 if_contain_note.get(key_of_day).Save_a_note(year, month, day, selected_hour, content);
    			 new Thread(if_contain_note.get(key_of_day)).start();
    			 JOptionPane.showMessageDialog(null, "����¼����ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
    		 }
    		 catch(Exception e){
    			 return;
    		 }
    	}
    	 text.setText("");
     }
     public void Delete_contents(int year,int month,int day){    //ɾ������¼
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
    		 String op=JOptionPane.showInputDialog(this,"��ѡ��Ҫɾ���ĸ�Сʱ�ı���¼","��ʾ",JOptionPane.QUESTION_MESSAGE,null,hour_array,hour_array[0]).toString();
        	 int selected_hour=Integer.parseInt(op);
        	 this.hour=selected_hour;
        	 if_contain_note.get(key_of_day).Delete_a_note(year, month, day, selected_hour);
    		 if(if_contain_note.get(key_of_day).note_number==0){
    			 if_contain_note.remove(key_of_day);
    		 }
    		 JOptionPane.showMessageDialog(null, "����¼ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
    		 text.setText("");
             }
        	 catch(Exception e){
        		 return;
        	 }
    	 }
    	 else{
    		 String m=""+year+"��"+month+"��"+day+"����־��¼";
    		 JOptionPane.showMessageDialog(null, m,"��ʾ",JOptionPane.INFORMATION_MESSAGE);
    	 }
     }


}
