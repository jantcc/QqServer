/**
 * ����QQ�����������ڼ������ȴ�ĳ��QQ�ͻ���������
 */
package com.qq.server.model;
import java.net.*;
import java.io.*;
import java.util.*;

import com.qq.common.Message;
import com.qq.common.User;
public class MyQqServer {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MyQqServer mqs =new MyQqServer();
	}
	public MyQqServer() {
		// TODO �Զ����ɵĹ��캯�����
		try {
			System.out.println("���Ƿ������������ڼ���");
			//��9999�˿ڼ���
			ServerSocket ss = new ServerSocket(9999);
			//�������ȴ�����
			while(true){
			Socket s =ss.accept();
			//һ�����ӳɹ������տͻ��˷�������Ϣ;
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			User u =  (User) ois.readObject();
			Message ms = new Message();
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			if(u.getPasswd().equals("123456")){
				ms.setMesType("1");
				oos.writeObject(ms);
				
				//����һ���̣߳�������ͻ���ͨ��.
				SerConClientThread scct = new SerConClientThread(s);
			    scct.start();
			    ManageCientThread.addClientThread(u.getUserId(), scct);
			} else{
				ms.setMesType("2");
				oos.writeObject(ms);
				s.close();
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
