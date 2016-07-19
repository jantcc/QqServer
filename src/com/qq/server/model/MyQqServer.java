/**
 * 这是QQ服务器，它在监听，等待某个QQ客户端来连接
 */
package com.qq.server.model;
import java.net.*;
import java.io.*;
import java.util.*;

import com.qq.common.Message;
import com.qq.common.User;
public class MyQqServer {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MyQqServer mqs =new MyQqServer();
	}
	public MyQqServer() {
		// TODO 自动生成的构造函数存根
		try {
			System.out.println("我是服务器，我正在监听");
			//在9999端口监听
			ServerSocket ss = new ServerSocket(9999);
			//阻塞，等待连接
			while(true){
			Socket s =ss.accept();
			//一旦连接成功，接收客户端发来的信息;
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			User u =  (User) ois.readObject();
			Message ms = new Message();
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			if(u.getPasswd().equals("123456")){
				ms.setMesType("1");
				oos.writeObject(ms);
				
				//单开一个线程，保持与客户端通信.
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
