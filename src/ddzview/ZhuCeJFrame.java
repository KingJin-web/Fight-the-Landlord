package ddzview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ddz.Dao.Dao;

public class ZhuCeJFrame extends JFrame{
	private JButton btndet = new JButton("确定");
	private JButton btncancel = new JButton("取消");
	
	private JLabel user_name = new JLabel("用户名");
	private JLabel password = new JLabel("密码");
	private JLabel password_determine = new JLabel("确认密码");
	
	private JTextField textname = new JTextField(15);
	private JPasswordField jps = new JPasswordField(15);
	private JPasswordField jps_bk = new JPasswordField(15);
	
	
	public ZhuCeJFrame (){
		
		//this.username=username;
		setTitle("注册");
	       setBounds(200,300,600,500);
	        setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	       setLayout(null);
	       
		user_name.setBounds(200,130,40,25);
 		password.setBounds(200, 180, 40, 25);
 		password_determine.setBounds(200, 230, 70, 25);
 		
 		textname.setBounds(280, 130, 100, 25);
 		jps.setBounds(280, 180, 100, 25);
 		jps_bk.setBounds(280, 230, 100, 25);
 		
 		btndet.setBounds(200, 275, 60, 30);
 		btncancel.setBounds(300, 275, 60, 30);

 		this.add(btncancel);
 		this.add(btndet);
 		this.add(jps);
 		this.add(jps_bk);
 		this.add(password);
 		this.add(password_determine);
 		this.add(textname);
 		this.add(user_name);
		
		//ImageIcon bookAddIcon=CreatecdIcon.add("newBookorderImg.jpg");
		//label_5.setIcon(bookAddIcon);
		//label_5.setPreferredSize(new Dimension(400, 80));
		//label_5.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		//getContentPane().add(label_5, BorderLayout.NORTH);
		//label_5.setText("新书定购(LOGO图片)");
		
		btndet.addActionListener(new SubmitAction());
		btncancel.addActionListener(new CancelAction());
		
		
	}
	
	class SubmitAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "密码不能大于十五位");
			int i=0;
			//Dao.check(textname.getText(), jps.getText());
			if(textname.getText()==null||textname.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				return;
			}
			if(jps.getText()==null||jps.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			if(jps_bk.getText()==null||jps_bk.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "确认密码不能为空");
				return;
			}
			if(!jps_bk.getText().equals(jps.getText())) {
				JOptionPane.showMessageDialog(null, "两次密码不匹配，请重新输入");
				jps.setText("");
				jps_bk.setText("");
				return;
			}
			
		 i=	Dao.addUser(textname.getText().trim(),jps.getText().trim());
		 if(i==1) {
			 JOptionPane.showMessageDialog(null, "注册成功！");
		 }
			
			
			
		}
		
	}
	
	class CancelAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ZhuCeJFrame.this.setVisible(false);
			new login();
		}
		
	}

}
