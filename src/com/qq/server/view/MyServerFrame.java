/**
 * 这是服务器的控制界面，可以启动服务器，关闭服务器，可以管理可监控用户
 */
package com.qq.server.view;
import java.awt.*;

import javax.swing.*;

import com.qq.server.model.MyQqServer;

import java.awt.event.*;
public class MyServerFrame extends JFrame implements ActionListener {
	JPanel jp1;
	JButton jb1,jb2;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MyServerFrame msf =new MyServerFrame();
	}
	public MyServerFrame() {
		jp1 = new JPanel();
		jb1 = new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2 = new JButton("关闭服务器");
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jb1){
			 new MyQqServer();
		}
	}
}
