import java.awt.*;
import java.awt.event.*;

public class myframe {
private Frame f;
private Button b;
private TextField tf;
myframe()
{
	init();
}

public void init()
{
	f=new Frame ("�ҵĿ��");
	f.setSize(500,300);
	f.setLocation(200, 100);
	f.setLayout( new FlowLayout());
	b=new Button ("����һ����ť");
	tf=new TextField(10);
	f.add(b);
	f.add(tf);
	event();
	f.setVisible(true);
	
	
			
}
private void event()
{  
	f.addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
	);

	b.addActionListener(new ActionListener()
			{
		

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.exit(0);
			System.out.println("�ұ������");
		}
			});
	
	/*b.addMouseListener(new MouseAdapter()
			{ private  int count =0;
		
		public void mouseClicked(MouseEvent e)
		{ 
			
			//if(e.getClickCount()==2)
				System.out.println("�����"+count++);
		
		}
			});
	b.addMouseListener(new MouseAdapter()
			{private int a =0;
		public void mouseEntered(MouseEvent e)
		{
			System.out.println("������"+a++);
			
		}
			});*/
	
	b.addKeyListener(new KeyAdapter()
			{
		public void keyPressed(KeyEvent e)
		{ /*if(e.getKeyCode()==27)
			System.exit(0);*/
			/*if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
				System.exit(0);*/
			if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_ENTER)
				System.exit(0);
			//System.out.println(e.getKeyChar()+"..."+e.getKeyCode());
			//System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"..."+e.getKeyCode());
		}
			});
	
	
	tf.addKeyListener(new KeyAdapter()
			{
		public void keyPressed(KeyEvent e)
		{
				if(!(e.getKeyCode()>=0&&e.getKeyCode()<=9))
					System.out.println(e.getKeyCode()+"����");
				e.consume();
						
		}
			
			});
}
	public static void main(String[] args) {
		new myframe();
		// TODO Auto-generated method stub

	}

}
