package ddzview;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.ddz.Dao.Dao;
import com.ddz.model.User;


public class ddzframe extends JFrame{
	private JButton his_ach = new JButton("历史战绩");
	private JLabel star_game = new JLabel(new ImageIcon("images/6-10.png"));
	private JLabel backgroud_label ;
	private ImageIcon backgroud;
	public Container container = null;
	private JPanel pane;
	//private JLabel star_game;
	
	private JLabel user_label;
	private JLabel money_label;
	private JLabel username = new JLabel("用户名");
	private int money;
	private User user;
	private JLabel money_num = new JLabel("金币");
	private JLabel menu;
	
	private JLabel icon = new JLabel();
	//@SuppressWarnings("deprecation")
	public ddzframe (User user){
		
		this.user =user;
		money_label = new JLabel(user.getMoney()+"");
		user_label = new JLabel(user.getName());
		setTitle("");
		//setVisible(true);
		backgroud=new ImageIcon("images/6-12.png");
		backgroud_label = new JLabel(backgroud);
		
		
		
		 money_num.setBounds(215,20,40,20);
	       
	        username.setBounds(50,20,40,20);
	        
	        money_label.setBounds(220,50,40,30);
	       
	        user_label.setBounds(50,50,80,30);
	        
			his_ach.setBounds(120, 230, 110, 80);
			
			star_game.setBounds(250, 230, 180, 80);
			//this.add(star_game);
			//star_game = new JLabel(new ImageIcon("images/6-10.png") );
			//star_game.setVisible(false);
			//star_game.setBounds(450, 230, 200, 64);
			//
			
			
			menu= new JLabel(new ImageIcon("images/6-6.png"));
			menu.setBounds(630,30,60,60);
			
			star_game.addMouseListener(new MouseListener() {

				public void mouseClicked(MouseEvent e) {
					ddzframe.this.setVisible(false);
					new Main( ddzframe.this.user);
				}

				public void mousePressed(MouseEvent e) {}

				public void mouseReleased(MouseEvent e) {}

				public void mouseEntered(MouseEvent e) {}

				public void mouseExited(MouseEvent e) {}
			
			});
			menu.addMouseListener(new MouseListener() {

				public void mouseClicked(MouseEvent e) {

					new menuJframe(user);
				}

				public void mousePressed(MouseEvent e) {}

				public void mouseReleased(MouseEvent e) {}

				public void mouseEntered(MouseEvent e) {}

				public void mouseExited(MouseEvent e) {}
				
			});
			
		pane=(JPanel)this.getContentPane();
		pane.setOpaque(false);
		pane.setLayout(null);

		this.getLayeredPane().setLayout(null);
		pane.add(money_num);
		pane.add(menu);
		pane.add(money_label);
		pane.add(star_game);
		pane.add(user_label);
		pane.add(username);
		pane.add(money_num);
		this.getLayeredPane().add(backgroud_label,new Integer(Integer.MIN_VALUE));
		backgroud_label.setBounds(0,0,717,585);
		setBounds(400,300,712,585);
	    setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	}

}

