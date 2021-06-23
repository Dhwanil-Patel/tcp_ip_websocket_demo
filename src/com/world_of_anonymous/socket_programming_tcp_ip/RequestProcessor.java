package com.world_of_anonymous.socket_programming_tcp_ip;

import java.io.*;
import java.net.*;
class RequestProcessor extends Thread //for multi-threaded server
{
    private Socket socket;
    RequestProcessor(Socket socket)
    {
        this.socket=socket;
        start(); // will load the run method
    }
    public void run() {
        try {
            //Declaring properties and streams
            int x;

            //getting input stream and its reader, for reading request or acknowledgement
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            StringBuffer stringBuffer=new StringBuffer();
            while(true) {
                x=inputStreamReader.read();
                if(x=='#' || x==-1) break; //reads until terminator
                stringBuffer.append((char)x);
            }
            String request=stringBuffer.toString();
            System.out.println("Request : "+request);
            //parsing and extracting Request data
            int temp1=request.indexOf(",");
            int temp2=request.indexOf(",",temp1+1);
            String part1=request.substring(0,temp1);
            String part2=request.substring(temp1+1,temp2);
            String part3=request.substring(temp2+1);
            int rollNumber=Integer.parseInt(part1);
            String name=part2;
            String gender=part3;
            System.out.println("Roll number : "+rollNumber);
            System.out.println("Name : "+name);
            System.out.println("Gender : "+gender);

            // handle data & sending response
            String response="Data saved#";

            //get output stream and its writer, for sending response or acknowledgement
            OutputStream outputStream=socket.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            outputStreamWriter.write(response);
            outputStreamWriter.flush(); // response sent
            System.out.println("Response sent");
            socket.close(); //terminating connection
        } catch(Exception exception) {
            System.out.println(exception);
        }
    }
}
