package com.my.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: dongqihang
 * @Date: Created in 12:13 2018/11/3
 */
public class SendHttpRequest {
    private String tarurl="localhost:8081/res/upload";
    public void sendRequest(String filename, File file){
        try {
            URL url=new URL(tarurl);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.addRequestProperty("FileName",filename);
            connection.setRequestProperty("content-type", "text/html");
            BufferedOutputStream out=new BufferedOutputStream(connection.getOutputStream());
            FileInputStream fileInputStream=new FileInputStream(file);
            byte[] bytes=new byte[1024];
            int numReadByte=0;
            while ((numReadByte=fileInputStream.read(bytes,0,1024))>0){
                out.write(bytes,0,numReadByte);
            }
            out.flush();
            fileInputStream.close();
            DataInputStream in=new DataInputStream(connection.getInputStream());
            System.out.println(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String tarurl="http://localhost:8081/res/upload";
        // 换行符
        final String newLine = "\r\n";
        final String boundaryPrefix = "--";
        // 定义数据分隔线
        String BOUNDARY = "========7d4a6d158c9";
        URL url= null;

        try {
            url = new URL(tarurl);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.addRequestProperty("FileName","fn");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-type", "multipart/form-data; boundary=" + BOUNDARY);
            BufferedOutputStream out=new BufferedOutputStream(connection.getOutputStream());
            File file=new File("D:\\weixinproject\\app.json");
            StringBuilder sb = new StringBuilder();
            sb.append(boundaryPrefix);
            sb.append(BOUNDARY);
            sb.append(newLine);
            sb.append("Content-Disposition: form-data;name=\"video\";filename=\"" + "\\weixinproject\\app.json"
                    + "\"" + newLine);
//            sb.append("Content-Type:application/octet-stream");
            sb.append("Content-Type:multipart/form-data");
            sb.append(newLine);
            sb.append("Content-Transfer-Encoding: binary");
            sb.append(newLine);
            sb.append(newLine);
            out.write(sb.toString().getBytes());
            System.out.println(sb.toString());
            FileInputStream fileInputStream=new FileInputStream(file);
            DataInputStream dis=new DataInputStream(fileInputStream);
            int bytes = 0;
            byte[] bufferOut =new byte[(int) file.length()];
            bytes =dis.read(bufferOut);
            out.write(bufferOut,0,bytes);
//            byte[] bytes=new byte[1024];
//            int numReadByte=0;
//            while ((numReadByte=fileInputStream.read(bytes,0,1024))>0){
//                out.write(bytes,0,numReadByte);
//            }
//            out.write(newLine.getBytes());
            dis.close();
//            fileInputStream.close();
            byte[] end_data = (newLine + boundaryPrefix + BOUNDARY + boundaryPrefix + newLine)
                    .getBytes();
            out.write(end_data);
            out.flush();
            out.close();
            DataInputStream in=new DataInputStream(connection.getInputStream());
            BufferedReader d  = new BufferedReader(new InputStreamReader(in));
            String count;
            while ((count = d.readLine()) != null){
                String u = count.toUpperCase();
                System.out.println(u);
            }
            d.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
