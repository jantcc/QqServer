/**
 * ����:��������ĳ���ͻ��˵�ͨ�� 
 */
package com.qq.server.model;
import java.net.*;
import java.io.*;

import com.qq.common.*;
public class SerConClientThread extends Thread {
	Socket  s;
	public SerConClientThread(Socket s) {
		this.s= s;
	}	

	public void run() {
		// TODO �Զ����ɵķ������
		while(true){
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message ms = (Message) ois.readObject();
				System.out.println(ms.getSender()+"��"+ms.getGetter()+"˵"+ms.getCon());
				//ת��
				SerConClientThread sc =ManageCientThread.getClientThread(ms.getGetter());
				ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
				oos.writeObject(ms);
			
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
}
