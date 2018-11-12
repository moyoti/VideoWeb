package com.my.util;

import java.io.*;
import java.net.Socket;

/**
 * @Author: dongqihang
 * @Date: Created in 21:51 2018/11/5
 */
public class FileTransferClient extends Socket {
    private static final String SERVER_IP="127.0.0.1";
    private static final int SERVER_PORT=8899;
    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;
    public FileTransferClient() throws IOException {
        super(SERVER_IP,SERVER_PORT);
        this.client=this;
        System.out.println("init client");
    }
    public void sendFile(File file) throws IOException {
        try {


//            File file = new File(pathName);
            if (file.exists()) {
                fis = new FileInputStream(file);
                dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();
                System.out.println("=======开始传输=======");
                byte[] bytes = new byte[1024];
                int length = 0;
                int progress = 0;
                while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                    progress += length;
//                    System.out.println("| " + (100 * progress / file.length()) + "% |");
                }
                System.out.println();
                System.out.println("=========finish=========");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            if(fis !=null){
                fis.close();
            }
            if(dos!=null){
                dos.close();
            }
            client.close();
        }
    }

    public static void main(String[] args) {
        try{
            FileTransferClient client=new FileTransferClient();
            File file = new File("D:\\upload\\pic\\xianggang.avi");
            client.sendFile(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
