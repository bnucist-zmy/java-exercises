package java_final_exercise;
import java.util.Calendar;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Hashtable;

public class CalendarPad extends JFrame {      //CalendarPad 是主类，程序的起点，其Frame分为两部分
	//左侧画板内容在CalendarPad里添加,右侧画板内容在NotePad里实现，然后再直接添加NotePad到CalendarPad的Frame中
	
	int year,month,day;   //日历面板的年月日变量
	JTextField day_units[]=new JTextField[42]; //一个月的日期单元，用于添加在7X7的网格之中构成一个月的日期格式
	JLabel week_title[]= new JLabel[7];     //日历上的星期几标题
	String day_name[]={"日","一","二","三","四","五","六"};
	Calendar mycalendar;           //CalendarPad的日历变量
	int what_day_of_first_day;   //某一月第一天是周几;
	NotePad mynotepad;           //备忘录面板
	Show_time current_time_panel;          //实时时间显示
	JPanel leftPanel=new JPanel();      //主面板的左侧大面板
	JPanel rightPanel=new JPanel();      //主面板的右侧大面板
	JTextField year_display=new JTextField(4);  //显示年份的文本框
	JButton next_year=new JButton("下年");  //下一年按钮
	JButton last_year=new JButton("上年");   //上一年按钮
	JTextField month_display=new JTextField(2);   //显示月份的文本框
	JButton next_month=new JButton("下月");   //下一月按钮
	JButton last_month=new JButton("上月");   //上一月按钮
	Box box=Box.createHorizontalBox();     //横排列容器
	
	CalendarPad(){
		mycalendar=Calendar.getInstance();     //日历对象初始化，以现在日期初始化
		JPanel leftCenter= new JPanel();   //左侧大面板的中心面板，中心面板绘制日历样式
		JPanel leftNorth=new JPanel();      //左侧大面板的北侧面板，北侧面板添加 上年，下年，上月，下月 按钮 以及显示当前年、月
		current_time_panel=new Show_time();     //实时时间显示
		leftCenter.setLayout(new GridLayout(7,7));      //设置布局为7X7，以便绘制日历
		this.year=mycalendar.get(Calendar.YEAR);      //设置CalendarPad的内部时间
		this.month=mycalendar.get(Calendar.MONTH)+1;
		this.day=mycalendar.get(Calendar.DAY_OF_MONTH);
		for(int i=0;i<7;i++){        //日历的第一行标题，日，一，二，三，四，五，六
			week_title[i]=new JLabel();
			week_title[i].setText(day_name[i]);
			week_title[i].setBorder(BorderFactory.createRaisedBevelBorder());
			leftCenter.add(week_title[i]);
		}
		week_title[0].setForeground(Color.red);
		week_title[6].setForeground(Color.blue);
		for(int i=0;i<42;i++){       //绘制日历
			day_units[i]=new JTextField();
			day_units[i].addMouseListener(new Mouseclick_day_adapter(this));  //在单独的日期上添加鼠标事件监听器
			day_units[i].setEditable(false);
			leftCenter.add(day_units[i]);
		}
		last_year.addActionListener(new ActionListener(){   //给四个按钮 上年、下年、上月、下月添加监听器
			public void actionPerformed(ActionEvent e){
				year_change_Pressed(e);
			}
		});
		next_year.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				year_change_Pressed(e);
			}
		});
		last_month.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				month_change_Pressed(e);
			}
		});
		next_month.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				month_change_Pressed(e);
			}
		});
		box.add(last_year);
		box.add(next_year);
		box.add(last_month);
		box.add(next_month);
		box.add(year_display);
		box.add(month_display);
		box.validate();
		leftNorth.add(box);
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(leftNorth,BorderLayout.NORTH);
		leftPanel.add(leftCenter, BorderLayout.CENTER);
		leftPanel.add(current_time_panel, BorderLayout.SOUTH);
		new Thread(current_time_panel).start();
		leftPanel.validate();
		Container con=getContentPane();
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel);
		con.add(split,BorderLayout.CENTER);
	    con.validate();
        mynotepad=new NotePad();
        rightPanel.add(mynotepad);
        Set_daypanel_display(year,month);   //根据给定的年和月绘制日历
        this.validate();
	}
	public void Set_daypanel_display(int year,int month){   //绘制日历
		mycalendar.set(year, month-1,1);
		what_day_of_first_day=mycalendar.get(Calendar.DAY_OF_WEEK)-1;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			Set_day_number(what_day_of_first_day,31);
		}
		else if(month==4||month==6||month==9||month==11){
			Set_day_number(what_day_of_first_day,30);
		}
		else if(month==2){
			if((year%4==0&&year%100!=0)||(year%400==0)){
				Set_day_number(what_day_of_first_day,29);
			}
			else{
				Set_day_number(what_day_of_first_day,28);
			}
		}
	}
	public void Set_day_number(int start,int total_number){    //具体绘制日历里每一天的编号
		int n=1;
		for(int i=start;i<start+total_number;i++){
			day_units[i].setText(""+n);
			if(n==day){
				day_units[i].setForeground(Color.green);
				day_units[i].setFont(new Font("TimesRoman",Font.BOLD,20));
			}
			else{
				day_units[i].setFont(new Font("TimesRoman",Font.BOLD,12));
				day_units[i].setForeground(Color.black);
			}
			if(i%7==6){
				day_units[i].setForeground(Color.blue);
			}
			if(i%7==0){
				day_units[i].setForeground(Color.red);
			}
			n++;
		}
		for(int i=0;i<start;i++){
			day_units[i].setText("");
		}
		for(int i=start+total_number;i<42;i++){
			day_units[i].setText("");
		}	
	}
/*	public int getYear(){
		return year;
	}
	public int getMonth(){
		return month;
	}
	public int getDay(){
		return day;
	}*/
/*	public void setYear(int y){
		year=y;
		mynotepad.setYear(year);
	}
	public void setMonth(int m){
		month=m;
		mynotepad.setMonth(month);
	}
	public void setDay(int d){
		day=d;
		mynotepad.setDay(day);
	}*/

	class Mouseclick_day_adapter extends MouseAdapter{   //鼠标单击日期事件适配器
		private CalendarPad adaptee;
		Mouseclick_day_adapter(CalendarPad adaptee){
			this.adaptee=adaptee;
		}
		public void mouseClicked(MouseEvent e){
			adaptee.choose_oneday(e);
		}
	}
	public void choose_oneday(MouseEvent e){            //鼠标单击日历的某一天事件处理方法
		JTextField source=(JTextField)e.getSource();
		try{
			int selected_day=Integer.parseInt(source.getText());
			mynotepad.setinfo(year, month, selected_day);
			mynotepad.Set_display_label(year,month,selected_day);
			mynotepad.get_note_content(year,month,selected_day);
			
			
		}
		catch(Exception error){
			System.out.println("choose_oneday wrong");
		}
	}
	public void year_change_Pressed(ActionEvent e){         //单击更改年份按钮事件处理方法
		if(e.getSource()==last_year){
			year=year-1;
			year_display.setText(""+year);
			Set_daypanel_display(year,month);
			mynotepad.setinfo(year, month, day);
			mynotepad.Set_display_label(year, month, day);
		}
		else if(e.getSource()==next_year){
			year=year+1;
			year_display.setText(""+year);
			Set_daypanel_display(year,month);
			mynotepad.setinfo(year, month, day);
			mynotepad.Set_display_label(year, month, day);
		}
		
	}
	public void month_change_Pressed(ActionEvent e){       //单击更改月份事件处理方法
		if(e.getSource()==last_month){
			if(month>=2){
				month=month-1;
				month_display.setText(""+month);
				Set_daypanel_display(year,month);
				mynotepad.setinfo(year, month, day);
				mynotepad.Set_display_label(year, month, day);
			}
			else if(month==1){
				month=12;
				month_display.setText(""+month);
				Set_daypanel_display(year,month);
				mynotepad.setinfo(year, month, day);
				mynotepad.Set_display_label(year, month, day);
			}
		}
		if(e.getSource()==next_month){
			if(month<12){
				month=month+1;
				month_display.setText(""+month);
				Set_daypanel_display(year,month);
				mynotepad.setinfo(year, month, day);
				mynotepad.Set_display_label(year, month, day);
			}
			else if(month==12){
				month=1;
				month_display.setText(""+month);
				Set_daypanel_display(year,month);
				mynotepad.setinfo(year, month, day);
				mynotepad.Set_display_label(year, month, day);
			}
		}
	}

    
    class Show_time extends JPanel implements Runnable{   //一个用于显示实时时间的类
    	Calendar now_time;
    	int now_year,now_month,now_day,now_hour,now_minute,now_second;
    	JTextField time_area;
    	Show_time(){
    		time_area=new JTextField(17);
    		this.add(time_area);
    		this.setVisible(true);
    	}
    	public void run(){
    	     while(true){
    	    	 repaint();
    	    	 try{
    	    		 Thread.sleep(1000);

    	    	 }
    	    	 catch(Exception e){
    	    		 System.out.println("draw time error");
    	    	 }
    	     }
    	}
    	public void paint(Graphics g){
    		super.paint(g);
    		now_time=Calendar.getInstance();
    		now_year=now_time.get(Calendar.YEAR);
    		now_month=now_time.get(Calendar.MONTH)+1;
    		now_day=now_time.get(Calendar.DAY_OF_MONTH);
    		now_hour=now_time.get(Calendar.HOUR_OF_DAY);
    		now_minute=now_time.get(Calendar.MINUTE);
    		now_second=now_time.get(Calendar.SECOND);
    		String s=""+now_year+"年"+now_month+"月"+now_day+"日"+now_hour+"时"+now_minute+"分"+now_second+"秒";
    		time_area.setText(s);
    		time_area.setFont(new Font("TimesRoman",Font.BOLD,12));
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 CalendarPad test=new CalendarPad();
	 test.setTitle("我的Java日历备忘录");
	 test.setBounds(100,50,600,600);
     test.setVisible(true);
	}

}
