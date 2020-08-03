package client;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import server.HelloServer;
import thrift_demo.HelloWorldService;

public class HelloClient {
    public  static final int server_port=7099;
    private static final String ip="localhost";

    public void startClient(String username){

        TTransport tTransport=null;
        try{

            tTransport=new TSocket(ip, server_port);

            TProtocol protocol=new TBinaryProtocol(tTransport);
            HelloWorldService.Client client=new HelloWorldService.Client(protocol);
            tTransport.open();

            String result=client.sayHello(username);
            System.out.println("result: "+result);



        }catch (Exception e){
        e.printStackTrace();
        }
    }

    public static void main(String[] args){

        new HelloClient().startClient("renliuyang");
    }


}
