/**
 * ���Ƿ������Ŀ��ƽ��棬�����������������رշ����������Թ���ɼ���û�
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
		// TODO �Զ����ɵķ������
		MyServerFrame msf =new MyServerFrame();
	}
	public MyServerFrame() {
		jp1 = new JPanel();
		jb1 = new JButton("����������");
		jb1.addActionListener(this);
		jb2 = new JButton("�رշ�����");
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==jb1){
			 new MyQqServer();
		}
	}
}
