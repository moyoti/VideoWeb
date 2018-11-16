package com.my.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: dongqihang
 * @Date: Created in 13:28 2018/11/14
 */
public class PicTransferClient extends Socket {
    private static final String SERVER_IP="127.0.0.1";
    private static final int SERVER_PORT=8898;
    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;

    public PicTransferClient() throws Exception {
        super(SERVER_IP,SERVER_PORT);
        this.client=this;
    }
    public void sendFile(File file) throws IOException {
        try {
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

}
