import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class mymyframe {
	private Frame f;
	private TextField tf;
	private TextArea ta;
	private Button b;
	
	private Dialog d;
	private Label la;
	private Button bu;
	
	
	 
	mymyframe()
	{
		init();
		
	}
	
	public void init()
	{
		f=new Frame("My frame");
		f.setBounds(200,200,300,300);
		f.setLayout(new FlowLayout());
		b=new Button("ת��");
				
		tf=new TextField(20);
		ta=new TextArea(10,20);
		
		f.add(tf);
		f.add(b);
		f.add(ta);
		
		
		
		d=new Dialog(f,"�ҵĶԻ���",true);//true����������Ի��򣬶Ի����������Ŀ�ܾͲ��ܱ�����
		d.setBounds(300,300,250,200);
		d.setLayout(new FlowLayout());
         la=new Label();
         bu=new Button ("ȷ��");
         
         d.add(la);
         d.add(bu);
         
		
		event();
		f.setVisible(true);
		
	}
	
	private void event()
	{
		d.addWindowListener(new WindowAdapter()//����Ի����� ���Ի����Ϊ���ɼ�
		{
	public void windowClosing(WindowEvent e)
	{
		d.setVisible(false);
	}
		});
		
		bu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);
			}
		
		}
		);

	
		

		f.addWindowListener(new WindowAdapter()//�����ܲ�棬�������н���
				{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
				});
		
		tf.addKeyListener(new KeyAdapter()
				{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String dirPath=tf.getText();//��tf������·��
					File dir=new File(dirPath);
					if(dir.exists()&&dir.isDirectory())//dir��������Ŀ¼
					{
						ta.setText("");
						String []names=dir.list();
						for(String name:names)
						{
							ta.append(name+"\r\n");
						}
						
					}
					else//������ʾ�Ի���
					{
						la.setText("�������Ϣ"+dirPath+"��������������");
						d.setVisible(true);
					}
				}
					
			}
				});
		
		b.addActionListener(new ActionListener()
				{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					/*String text=tf.getText();
					ta.setText(text);
					tf.setText("");
					//System.out.println(text);*/
				String dirPath=tf.getText();//��tf������·��
				File dir=new File(dirPath);
				if(dir.exists()&&dir.isDirectory())//dir��������Ŀ¼
				{
					ta.setText("");
					String []names=dir.list();
					for(String name:names)
					{
						ta.append(name+"\r\n");
					}
					
				}
				else//������ʾ�Ի���
				{
					la.setText("�������Ϣ"+dirPath+"��������������");
					d.setVisible(true);
				}
				
			}
				}
				);
	}
public static  void main(String args[])
{
	new mymyframe();
}
}
