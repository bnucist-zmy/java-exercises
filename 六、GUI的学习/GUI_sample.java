import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Date;
public class GUI_sample extends Frame{
     //������� 
	 //��3�����
	 Button exit_button=new Button();
	 //��4�����
	 int if_ENTER_flag=1;   //���ڵ������ж���һ�������Ƿ�Ϊ�س���
	 TextField input_field=new TextField();
	 TextArea display_area=new TextArea();
	 //��5�����
	 Checkbox change_background_color_checkbox=new Checkbox("��5�ʸ�ѡ��");
	 Button change_color_button=new Button("��5����ͨ��ť");
	 //��6�����
	 ButtonGroup change_font_kind_buttongroup=new ButtonGroup();
	 JRadioButton button1=new JRadioButton("��ͨ");
	 JRadioButton button2=new JRadioButton("����");
	 JRadioButton button3=new JRadioButton("б��");
	 JButton change_font_kind_button=new JButton("��6�ʲ����ı�");
	 Panel change_font_panel=new Panel();
	 //��7�����
	 String font_size[]={"10","14","18"};
	 Label font_size_label=new Label("�����С");
	 Panel font_size_panel=new Panel();
	 Button font_size_button=new Button("��7�ʲ����ı�");
	 JComboBox font_size_combobox=new JComboBox(font_size);
	 //��8�����
	 boolean flag=false;//�����ж��Ƿ��Ѿ�ִ��˫���¼�
	 int clickNum=0;//�����ж��Ƿ��ִ��˫���¼�
	 
	 //Date lastdate=new Date();
	 //Date nowdate=new Date();
	 //int click_count=0;
	 //int if_ever_selected[]={0,0,0};
	 //String all_selected_str=new String();
	 //int first_init=1;
	 //int last_choice_index;
	 List mylist=new List();
     Label label1=new Label("˫��ѡ�е�����");
     Label label2=new Label("��ѡ�е�����");
     Label label3=new Label();   //������ʾ˫��ѡ�е�����
     Label label4=new Label();    //������ʾ��ѡ�е�����
	 //��9�����
     Label coordinate_label=new Label();
     
     //��10�����
     Button init_new_frame=new Button("���µĴ���");
     Frame new_frame;
	 
     
     
     //int click_count=0;
	 //int first_init=1;
	 //int last_choice_index;
	 //Object last_choice;
	 //String font_size[]={"10","14","18"};
	 //JComboBox font_size_combobox=new JComboBox(font_size);
	 //Label font_size_label=new Label("�����С");
	 //Panel font_size_panel=new Panel();
	 //Button font_size_button=new Button("��7�ʲ����ı�");
	 //Panel change_font_panel=new Panel();
	 //ButtonGroup change_font_kind_buttongroup=new ButtonGroup();
	 //JRadioButton button1=new JRadioButton("��ͨ");
	 //JRadioButton button2=new JRadioButton("����");
	 //JRadioButton button3=new JRadioButton("б��");
	 //JButton change_font_kind_button=new JButton("��6�ʲ����ı�");
	 //Button exit_button=new Button();
	 //Button change_color_button=new Button("��5����ͨ��ť");
	 //Checkbox change_background_color_checkbox=new Checkbox("��5�ʸ�ѡ��");
	 //TextField input_field=new TextField();
	 //TextArea display_area=new TextArea();
	 //String label4_str=new String();
	 //List mylist=new List();
     //Label label1=new Label("˫��ѡ�е�����");
     //Label label2=new Label("��ѡ�е�����");
     //Label label3=new Label();
     //Label label4=new Label();
     //Label coordinate_label=new Label();
     //Button init_new_frame=new Button("���µĴ���");
     //Frame new_frame;
     //Panel list_panel=new Panel();
	 
     public GUI_sample(){     //���캯��
		 try{
			 init();
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 private void init()throws Exception{    //��ʼ������
		 this.setLayout(null);
		 
		 //��4�����
		 input_field.setEditable(true);
		 display_area.setEditable(false);
		 input_field.setBounds(new Rectangle(70,70,200,30));
		 display_area.setBounds(new Rectangle(70,120,200,50));
		 input_field.addKeyListener(new KeyAdapter(){        //���ı�������Ӽ����¼��������������¼�������Ϊ������ʽ
			 public void keyTyped(KeyEvent e){
				 input_field_changed(e);
			 }
		 });  
		 //��5�����
		 change_background_color_checkbox.setBounds(70, 200, 100, 30);
		 change_color_button.setBounds(70,250 ,100, 30);
		 change_color_button.setBackground(Color.gray);
		 change_background_color_checkbox.addItemListener(new ItemListener(){    //�ڸ�ѡ�������ѡ���¼�������
			 public void itemStateChanged(ItemEvent e){
				 change_color_checkbox_performed();
			 }
		 });
		 //��6�����
		 change_font_kind_buttongroup.add(button1);
		 change_font_kind_buttongroup.add(button2);
		 change_font_kind_buttongroup.add(button3);
		 change_font_panel.add(button1);
		 change_font_panel.add(button2);
		 change_font_panel.add(button3);
		 change_font_panel.setBounds(70, 300, 250, 30);
		 change_font_kind_button.setBounds(70, 350, 200, 30);
	     button1.addActionListener(new ActionListener(){    //��������ѡ��ť����Ӽ�����
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
	     //��7�����
	     font_size_panel.add(font_size_label);
	     font_size_panel.add(font_size_combobox);
	     font_size_panel.setBounds(300, 300, 200, 30);
	     font_size_button.setBounds(300, 350, 150, 60);
        
	     font_size_combobox.addItemListener(new ItemListener(){   //�������б�����Ӽ�����
	    	 public void itemStateChanged(ItemEvent e){
	    		 font_size_changed(e);
	    	 }
	     });
	     //��8�����
	      mylist.setBounds(300,150,100,100);
	      mylist.add("����");
	      mylist.add("�Ϻ�");
	      mylist.add("���");
	      //mylist.setMultipleMode(true);
	      label1.setBounds(450,100,100, 30);
	      label3.setBounds(450, 150, 100, 30);
	      label2.setBounds(450, 200, 100, 30);
	      label4.setBounds(450, 250, 200, 30);
	      mylist.addMouseListener(new GUIsample_list_mouseClicked_Adapter(this));
	      
	      //��9�����
	      coordinate_label.setBounds(800, 800, 150, 30);
	      this.addMouseMotionListener(new GUI_sample_mouseMotionAdapter(this));
		 //��10�����
	      init_new_frame.setBounds(300,800,100,30);
	      init_new_frame.addMouseListener(new GUIsample_new_frame_Button_Adapter(this));
	      //��3�����
		 exit_button.setLabel("�˳�����");
		 exit_button.setBounds(new Rectangle(500,500,80,30));
		 exit_button.addMouseListener(new GUIsample_mouseClicked_Adapter(this));    //���˳���ť�������굥���¼�������

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
	 //����������
	 class GUIsample_mouseClicked_Adapter extends MouseAdapter{   //�˳���ť����굥���¼�������
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
	    final MouseEvent me=e;//�¼�Դ
        
	    adaptee.flag=false;//ÿ�ε������ʼ��˫���¼�ִ�б�־Ϊfalse

	    if (adaptee.clickNum == 1) {//��clickNum==1ʱִ��˫���¼�
	      adaptee.mouseDoubleClicked(me);//ִ��˫���¼�
	      adaptee.clickNum=0;//��ʼ��˫���¼�ִ�б�־Ϊ0
	      adaptee.flag=true;//˫���¼���ִ��,�¼���־Ϊtrue
	      return;
	    }
	    java.util.Timer timer=new java.util.Timer();

	    //��ʱ����ʼִ��,��ʱ0.2���ȷ���Ƿ�ִ�е����¼�
	    timer.schedule(new java.util.TimerTask() {
	      private int n=0;//��¼��ʱ��ִ�д���
	      public void run() {
	        if(adaptee.flag){//���˫���¼��Ѿ�ִ��,��ôֱ��ȡ������ִ��
	          n=0;
	          adaptee.clickNum=0;
	          this.cancel();
	          return;
	        }
	        if (n == 1) {//��ʱ���ȴ�0.2���,˫���¼���δ����,ִ�е����¼�
	          mouseSingleClicked(me);//ִ�е����¼�
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

	 
	 
	 

	 class GUI_sample_mouseMotionAdapter extends MouseMotionAdapter{     //�����ϵ�����ƶ��¼�������
		 private GUI_sample adaptee;
		 GUI_sample_mouseMotionAdapter(GUI_sample adaptee){
			 this.adaptee=adaptee;
		 }
		 public void mouseMoved(MouseEvent e){
			 adaptee.this_mouseMoved(e);
		 }
	 }
	 class GUIsample_new_frame_Button_Adapter extends MouseAdapter{  //���´��ڵİ�ť����굥��������
		 private GUI_sample adaptee;
		 GUIsample_new_frame_Button_Adapter(GUI_sample adaptee){
			 this.adaptee=adaptee;
		 }
		 public void mouseClicked(MouseEvent e){
			 adaptee.init_new_frame(e);
		 }
	 }

	 //�¼���������
	 public void button_mouseClicked(MouseEvent e){    //�˳���ť����굥���¼�����  
		 System.exit(0);
	 }
     public void input_field_changed(KeyEvent e){          //�ı������ݸı��¼�����
    	 
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
     public void change_color_checkbox_performed(){      //��ѡ��ѡ���¼�����
    	 if(change_background_color_checkbox.getState())
    		 change_color_button.setBackground(Color.cyan);
    	 else
    		 change_color_button.setBackground(Color.gray);
     }
     public void button1_actionperformed(){      //���尴ťѡ���¼�����
    	 if(button1.isSelected())
    		 change_font_kind_button.setFont(new Font("����",Font.PLAIN,12));


     }
     public void button2_actionperformed(){
    	 if(button2.isSelected())
    		 change_font_kind_button.setFont(new Font("����",Font.BOLD,12));

    	
     }
     public void button3_actionperformed(){
    	 if(button3.isSelected())
    		 change_font_kind_button.setFont(new Font("����",Font.ITALIC,12));

     }
     public void font_size_changed(ItemEvent e){       //�����б���ѡ���¼�����
    	 if(e.getStateChange()==ItemEvent.SELECTED){
    		 String str=(String)e.getItem();
    		 int font_size=Integer.parseInt(str);
    		 font_size_button.setFont(new Font("����",Font.PLAIN,font_size));
    		 
    	 }
     }
     public void mouseDoubleClicked(MouseEvent e){
    	 label3.setText(mylist.getSelectedItem());
     }
     public void mouseSingleClicked(MouseEvent e){
    	 label4.setText(mylist.getSelectedItem());
     }
     
     
/*     public void list_mouseClicked(MouseEvent e){     //�б�����굥���¼�����
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
     public void this_mouseMoved(MouseEvent e){     //����ƶ���ʾ�����¼�����
    	 int x=e.getX();
    	 int y=e.getY();
    	 String str="�������Ϊ("+Integer.toString(x)+","+Integer.toString(y)+")";
    	 coordinate_label.setText(str);
     }
     public void init_new_frame(MouseEvent e){        //���µĴ����¼�����
    	 new_frame=new Frame();
    	 new_frame.setSize(500, 500);
    	 new_frame.setVisible(true);
     }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          GUI_sample myGUIsample=new GUI_sample();
          myGUIsample.setTitle("�ҵ�Java GUI��ϰ");
          myGUIsample.setSize(1000,1000);
          myGUIsample.setVisible(true);
	}

}
