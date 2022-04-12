package ddzview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.ddz.Dao.Dao;
import com.ddz.model.His_Ach;
import com.ddz.model.User;


public class menuJframe extends JFrame{
	
	 private User user;
	 private JButton his_ach = new JButton("历史战绩");
	 
	 
      public menuJframe(User user) {
    	  this.user= user;
    	  
    	  
    	  his_ach.addActionListener(new  myActionListener());
    	  his_ach.setBounds(50,50,40,20);
    	  this.add(his_ach);
    	setBounds(300,200,200,200);
  	    setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	    
      }

	
	private Object[][] getselect(List list) {
		Object[][] s = new Object[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			His_Ach his = (His_Ach) list.get(i);
			s[i][0] = his.getTime();

			s[i][1]=his.getResult();
			

		}
		return s;

	}
	public void his_achFrame() {
		 JFrame jf = new JFrame("历史战绩");
		 jf.setSize(300,300);
	        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        // 创建内容面板，使用边界布局
	        JPanel panel = new JPanel(new BorderLayout());

	        // 表头（列名）
	        Object[] columnNames = {"时间", "结果"};

	        // 表格所有行数据
	        Object[][] results=getselect(Dao.selectHis_ach(user.getName()));
	        if(results.length==0) {
	        	Object[][] s = new Object[1][2];
	        	s[0][0] = new String("无数据");

				s[0][1]=new String("无数据");
				
				results=s;
	        }

	        // 创建一个表格，指定 所有行数据 和 表头
	        JTable table = new JTable(results, columnNames);

	        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
	        panel.add(table.getTableHeader(), BorderLayout.NORTH);
	        // 把 表格内容 添加到容器中心
	        panel.add(table, BorderLayout.CENTER);

	        jf.setContentPane(panel);
	        jf.pack();
	        jf.setLocationRelativeTo(null);
	        jf.setVisible(true);
	        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
	

	}
	      
      class myActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuJframe.this.setVisible(false);
				his_achFrame();
			}
  		  
  	  }
   
}
