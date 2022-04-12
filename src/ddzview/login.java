package ddzview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ddz.Dao.Dao;
import com.ddz.model.User;



public class login extends JFrame{
	private  JButton btnlog= new JButton("登录");
	private JButton btncancel = new JButton("清除");
	private JButton btnzhuce = new JButton("注册");
	
	private JLabel top_lab;
	private JLabel user_name = new JLabel("用户名");
	private JLabel user_password = new JLabel("密码");
	
	private JTextField textname = new JTextField(20);
	 private JPasswordField  jps =  new JPasswordField(15); 
	private JSplitPane spane;
	
	private JPanel top_pane=new JPanel();
	
	private User user;
	
	
   public login(){
	       setTitle("斗地主登录窗口");
	       setBounds(200,300,600,500);
	        setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //
	 		//spane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	 		
	 		
	 		top_pane.setLayout(null);
	 		user_name.setBounds(200, 180, 40, 25);
	 		user_password.setBounds(200, 230, 40, 25);
	 		textname.setBounds(280, 180, 100, 25);
	 		jps.setBounds(280, 230, 100, 25);
	 		
	 		
	 		btnlog.setBounds(180, 275, 60, 30);

	 		btncancel.setBounds(280, 275, 60, 30);

	 		btnzhuce.setBounds(380, 275, 60, 30);
	 		
	 		top_pane.add(user_name);
	 		top_pane.add(user_password);
	 		top_pane.add(textname);
	 		top_pane.add(jps);
	 		
	 		top_pane.add(btnlog);
	 		top_pane.add(btncancel);
	 		top_pane.add(btnzhuce);
	 		
	 			
	 		btnlog.addActionListener(new BookLoginAction());
	 		btncancel.addActionListener(new RestAction());
	 		btnzhuce.addActionListener(new ZhuCeAction());
	 		
	 		this.add(top_pane);
	 		
   }
   class BookLoginAction implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			if(textname.getText()==null || textname.getText().trim().equals("")||jps.getText()==null||jps.getText().trim().contentEquals(""))  {
				JOptionPane.showMessageDialog(null, "用户名或密码格式错误");
                textname.setText("");
				jps.setText("");
                return;
                }
		     	
			    user = Dao.check(textname.getText(), jps.getText());
			    if(user.getName()==null) {
			    	JOptionPane.showMessageDialog(null, "没有该用户");
			    	textname.setText("");
					jps.setText("");
					return;
			    }
				try {
					
					ddzframe frame = new ddzframe(user);
					//playSound.playmusic();
					frame.setVisible(true);
					login.this.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} 
	}
	
   class ZhuCeAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new ZhuCeJFrame();
		login.this.setVisible(false);
		
		
	}
	   
   }
   
   class RestAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
			textname.setText("");
			jps.setText("");
			
		
	}
	   
   }

}
