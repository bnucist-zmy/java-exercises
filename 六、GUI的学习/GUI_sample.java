import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Date;
public class GUI_sample extends Frame{
     //组件区： 
	 //第3问组件
	 Button exit_button=new Button();
	 //第4问组件
	 int if_ENTER_flag=1;   //用于第四问判断上一次输入是否为回车键
	 TextField input_field=new TextField();
	 TextArea display_area=new TextArea();
	 //第5问组件
	 Checkbox change_background_color_checkbox=new Checkbox("第5问复选框");
	 Button change_color_button=new Button("第5问普通按钮");
	 //第6问组件
	 ButtonGroup change_font_kind_buttongroup=new ButtonGroup();
	 JRadioButton button1=new JRadioButton("普通");
	 JRadioButton button2=new JRadioButton("黑体");
	 JRadioButton button3=new JRadioButton("斜体");
	 JButton change_font_kind_button=new JButton("第6问测试文本");
	 Panel change_font_panel=new Panel();
	 //第7问组件
	 String font_size[]={"10","14","18"};
	 Label font_size_label=new Label("字体大小");
	 Panel font_size_panel=new Panel();
	 Button font_size_button=new Button("第7问测试文本");
	 JComboBox font_size_combobox=new JComboBox(font_size);
	 //第8问组件
	 boolean flag=false;//用来判断是否已经执行双击事件
	 int clickNum=0;//用来判断是否该执行双击事件
	 
	 //Date lastdate=new Date();
	 //Date nowdate=new Date();
	 //int click_count=0;
	 //int if_ever_selected[]={0,0,0};
	 //String all_selected_str=new String();
	 //int first_init=1;
	 //int last_choice_index;
	 List mylist=new List();
     Label label1=new Label("双击选中的内容");
     Label label2=new Label("被选中的内容");
     Label label3=new Label();   //用于显示双击选中的内容
     Label label4=new Label();    //用于显示被选中的内容
	 //第9问组件
     Label coordinate_label=new Label();
     
     //第10问组件
     Button init_new_frame=new Button("打开新的窗口");
     Frame new_frame;
	 
     
     
     //int click_count=0;
	 //int first_init=1;
	 //int last_choice_index;
	 //Object last_choice;
	 //String font_size[]={"10","14","18"};
	 //JComboBox font_size_combobox=new JComboBox(font_size);
	 //Label font_size_label=new Label("字体大小");
	 //Panel font_size_panel=new Panel();
	 //Button font_size_button=new Button("第7问测试文本");
	 //Panel change_font_panel=new Panel();
	 //ButtonGroup change_font_kind_buttongroup=new ButtonGroup();
	 //JRadioButton button1=new JRadioButton("普通");
	 //JRadioButton button2=new JRadioButton("黑体");
	 //JRadioButton button3=new JRadioButton("斜体");
	 //JButton change_font_kind_button=new JButton("第6问测试文本");
	 //Button exit_button=new Button();
	 //Button change_color_button=new Button("第5问普通按钮");
	 //Checkbox change_background_color_checkbox=new Checkbox("第5问复选框");
	 //TextField input_field=new TextField();
	 //TextArea display_area=new TextArea();
	 //String label4_str=new String();
	 //List mylist=new List();
     //Label label1=new Label("双击选中的内容");
     //Label label2=new Label("被选中的内容");
     //Label label3=new Label();
     //Label label4=new Label();
     //Label coordinate_label=new Label();
     //Button init_new_frame=new Button("打开新的窗口");
     //Frame new_frame;
     //Panel list_panel=new Panel();
	 
     public GUI_sample(){     //构造函数
		 try{
			 init();
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 private void init()throws Exception{    //初始化函数
		 this.setLayout(null);
		 
		 //第4问组件
		 input_field.setEditable(true);
		 display_area.setEditable(false);
		 input_field.setBounds(new Rectangle(70,70,200,30));
		 display_area.setBounds(new Rectangle(70,120,200,50));
		 input_field.addKeyListener(new KeyAdapter(){        //在文本框上添加键盘事件监听器，按键事件适配器为匿名格式
			 public void keyTyped(KeyEvent e){
				 input_field_changed(e);
			 }
		 });  
		 //第5问组件
		 change_background_color_checkbox.setBounds(70, 200, 100, 30);
		 change_color_button.setBounds(70,250 ,100, 30);
		 change_color_button.setBackground(Color.gray);
		 change_background_color_checkbox.addItemListener(new ItemListener(){    //在复选框上添加选项事件监听器
			 public void itemStateChanged(ItemEvent e){
				 change_color_checkbox_performed();
			 }
		 });
		 //第6问组件
		 change_font_kind_buttongroup.add(button1);
		 change_font_kind_buttongroup.add(button2);
		 change_font_kind_buttongroup.add(button3);
		 change_font_panel.add(button1);
		 change_font_panel.add(button2);
		 change_font_panel.add(button3);
		 change_font_panel.setBounds(70, 300, 250, 30);
		 change_font_kind_button.setBounds(70, 350, 200, 30);
	     button1.addActionListener(new ActionListener(){    //在三个单选按钮上添加监听器
	    	 public void actionPerformed(ActionEvent e){
	    		 button1_actionperformed();
	    	 }
	     });
	     button2.addActionListener(new ActionListener(){
	    	 public void actionPerformed(ActionEvent e){
	    		 button2_actionperformed();
	    	 }
	     });
	     button3.addActionListener(new ActionListener(){
	    	 public void actionPerformed(ActionEvent e){
	    		 button3_actionperformed();
	    	 }
	     });
	     //第7问组件
	     font_size_panel.add(font_size_label);
	     font_size_panel.add(font_size_combobox);
	     font_size_panel.setBounds(300, 300, 200, 30);
	     font_size_button.setBounds(300, 350, 150, 60);
        
	     font_size_combobox.addItemListener(new ItemListener(){   //在下拉列表上添加监听器
	    	 public void itemStateChanged(ItemEvent e){
	    		 font_size_changed(e);
	    	 }
	     });
	     //第8问组件
	      mylist.setBounds(300,150,100,100);
	      mylist.add("北京");
	      mylist.add("上海");
	      mylist.add("天津");
	      //mylist.setMultipleMode(true);
	      label1.setBounds(450,100,100, 30);
	      label3.setBounds(450, 150, 100, 30);
	      label2.setBounds(450, 200, 100, 30);
	      label4.setBounds(450, 250, 200, 30);
	      mylist.addMouseListener(new GUIsample_list_mouseClicked_Adapter(this));
	      
	      //第9问组件
	      coordinate_label.setBounds(800, 800, 150, 30);
	      this.addMouseMotionListener(new GUI_sample_mouseMotionAdapter(this));
		 //第10问组件
	      init_new_frame.setBounds(300,800,100,30);
	      init_new_frame.addMouseListener(new GUIsample_new_frame_Button_Adapter(this));
	      //第3问组件
		 exit_button.setLabel("退出程序");
		 exit_button.setBounds(new Rectangle(500,500,80,30));
		 exit_button.addMouseListener(new GUIsample_mouseClicked_Adapter(this));    //在退出按钮上添加鼠标单击事件监听器

		 this.add(exit_button);
		 this.add(input_field);
		 this.add(display_area);
		 this.add(change_background_color_checkbox);
		 this.add(change_color_button);
		 this.add(change_font_kind_button);
		 this.add(change_font_panel);
		 this.add(font_size_button);
		 this.add(font_size_panel);
		 this.add(mylist);
		 this.add(label1);
		 this.add(label2);
		 this.add(label3);
		 this.add(label4);
         this.add(coordinate_label);
         this.add(init_new_frame);
	 }
	 //适配器区：
	 class GUIsample_mouseClicked_Adapter extends MouseAdapter{   //退出按钮的鼠标单击事件适配器
		 private GUI_sample adaptee;
		 GUIsample_mouseClicked_Adapter(GUI_sample adaptee){
			 this.adaptee=adaptee;
		 }
		 public void mouseClicked(MouseEvent e){
			 adaptee.button_mouseClicked(e);
		 }
	 }
	  class GUIsample_list_mouseClicked_Adapter extends MouseAdapter {

	 private GUI_sample adaptee;
	 GUIsample_list_mouseClicked_Adapter(GUI_sample adaptee){
		 this.adaptee=adaptee;
	 }
	  public void mouseClicked(MouseEvent e) {
	    final MouseEvent me=e;//事件源
        
	    adaptee.flag=false;//每次点击鼠标初始化双击事件执行标志为false

	    if (adaptee.clickNum == 1) {//当clickNum==1时执行双击事件
	      adaptee.mouseDoubleClicked(me);//执行双击事件
	      adaptee.clickNum=0;//初始化双击事件执行标志为0
	      adaptee.flag=true;//双击事件已执行,事件标志为true
	      return;
	    }
	    java.util.Timer timer=new java.util.Timer();

	    //定时器开始执行,延时0.2秒后确定是否执行单击事件
	    timer.schedule(new java.util.TimerTask() {
	      private int n=0;//记录定时器执行次数
	      public void run() {
	        if(adaptee.flag){//如果双击事件已经执行,那么直接取消单击执行
	          n=0;
	          adaptee.clickNum=0;
	          this.cancel();
	          return;
	        }
	        if (n == 1) {//定时器等待0.2秒后,双击事件仍未发生,执行单击事件
	          mouseSingleClicked(me);//执行单击事件
	          adaptee.flag = true;
	          adaptee.clickNum=0;
	          n=0;
	          this.cancel();
	          return;
	        }
	        clickNum++;
	        n++;
	      }
	    },new java.util.Date(),500);
	  }
	  }

	 
	 
	 

	 class GUI_sample_mouseMotionAdapter extends MouseMotionAdapter{     //窗口上的鼠标移动事件适配器
		 private GUI_sample adaptee;
		 GUI_sample_mouseMotionAdapter(GUI_sample adaptee){
			 this.adaptee=adaptee;
		 }
		 public void mouseMoved(MouseEvent e){
			 adaptee.this_mouseMoved(e);
		 }
	 }
	 class GUIsample_new_frame_Button_Adapter extends MouseAdapter{  //打开新窗口的按钮的鼠标单击适配器
		 private GUI_sample adaptee;
		 GUIsample_new_frame_Button_Adapter(GUI_sample adaptee){
			 this.adaptee=adaptee;
		 }
		 public void mouseClicked(MouseEvent e){
			 adaptee.init_new_frame(e);
		 }
	 }

	 //事件处理区：
	 public void button_mouseClicked(MouseEvent e){    //退出按钮的鼠标单击事件处理  
		 System.exit(0);
	 }
     public void input_field_changed(KeyEvent e){          //文本框内容改变事件处理
    	 
    	 if(e.getKeyChar()== KeyEvent.VK_ENTER){
    		 display_area.setText("");
    		 if_ENTER_flag=0;
    	 }
    	 else if (e.getKeyChar()== KeyEvent.VK_BACK_SPACE){
        	 display_area.setText(input_field.getText());
         }
    	 else{
    		 //display_area.setText(input_field.getText());
    		 if(if_ENTER_flag==1){
    			 String str=Character.toString(e.getKeyChar());
    		     display_area.append(str);
    		 }
    		 else{
    			 String str=Character.toString(e.getKeyChar());
    			 display_area.setText(input_field.getText());
    			 display_area.append(str);
    			 if_ENTER_flag=1;
    		 }
    	 }
     }
     public void change_color_checkbox_performed(){      //复选框选中事件处理
    	 if(change_background_color_checkbox.getState())
    		 change_color_button.setBackground(Color.cyan);
    	 else
    		 change_color_button.setBackground(Color.gray);
     }
     public void button1_actionperformed(){      //字体按钮选中事件处理
    	 if(button1.isSelected())
    		 change_font_kind_button.setFont(new Font("宋体",Font.PLAIN,12));


     }
     public void button2_actionperformed(){
    	 if(button2.isSelected())
    		 change_font_kind_button.setFont(new Font("宋体",Font.BOLD,12));

    	
     }
     public void button3_actionperformed(){
    	 if(button3.isSelected())
    		 change_font_kind_button.setFont(new Font("宋体",Font.ITALIC,12));

     }
     public void font_size_changed(ItemEvent e){       //下拉列表项选中事件处理
    	 if(e.getStateChange()==ItemEvent.SELECTED){
    		 String str=(String)e.getItem();
    		 int font_size=Integer.parseInt(str);
    		 font_size_button.setFont(new Font("宋体",Font.PLAIN,font_size));
    		 
    	 }
     }
     public void mouseDoubleClicked(MouseEvent e){
    	 label3.setText(mylist.getSelectedItem());
     }
     public void mouseSingleClicked(MouseEvent e){
    	 label4.setText(mylist.getSelectedItem());
     }
     
     
/*     public void list_mouseClicked(MouseEvent e){     //列表上鼠标单击事件处理
    	 if(first_init==1){
    		 lastdate.getTime();
    		 first_init=0;
    	 }
    	 */
    	 
/*    	 if(e.getClickCount()==2){
    		 label3.setText(mylist.getSelectedItem());
    	 }
    	 else{
    		 label4.setText(mylist.getSelectedItem());
    	 }
    	 */
    	 
/*    	 if(first_init==1){
    		 last_choice_index=mylist.getSelectedIndex();
    		 first_init=0;
    	 }
    	 click_count++;
    	 if(click_count==2&&mylist.getSelectedIndex()==last_choice_index){
    		 label3.setText(mylist.getSelectedItem());
    		 click_count=0;
    	 }
    	 else{
    		 click_count=1;
    		 last_choice_index=mylist.getSelectedIndex();
    	 }
    	 */
    	 
/*    	 int select_index=mylist.getSelectedIndex();
    	 if(if_ever_selected[select_index]==0){
    		 if_ever_selected[select_index]=1;
    		 all_selected_str=all_selected_str+mylist.getSelectedItem()+" ";
    		 label4.setText(all_selected_str);
    	 }*/

/*    	 
     }*/
     public void this_mouseMoved(MouseEvent e){     //鼠标移动显示坐标事件处理
    	 int x=e.getX();
    	 int y=e.getY();
    	 String str="鼠标坐标为("+Integer.toString(x)+","+Integer.toString(y)+")";
    	 coordinate_label.setText(str);
     }
     public void init_new_frame(MouseEvent e){        //打开新的窗口事件处理
    	 new_frame=new Frame();
    	 new_frame.setSize(500, 500);
    	 new_frame.setVisible(true);
     }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          GUI_sample myGUIsample=new GUI_sample();
          myGUIsample.setTitle("我的Java GUI练习");
          myGUIsample.setSize(1000,1000);
          myGUIsample.setVisible(true);
	}

}
