/**
 * 功能:服务器和某个客户端的通信 
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
		// TODO 自动生成的方法存根
		while(true){
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message ms = (Message) ois.readObject();
				System.out.println(ms.getSender()+"给"+ms.getGetter()+"说"+ms.getCon());
				//转发
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
