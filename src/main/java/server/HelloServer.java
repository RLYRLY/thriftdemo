package server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import thrift_demo.HelloWorldService;


public class HelloServer {
    public  static final int server_port=7099;
    private static final String ip="localhost";


    private void startServer() {
        try {
            System.out.println("start server");

            TServerSocket serverSocket=new TServerSocket(server_port);
            TServer.Args args=new TServer.Args(serverSocket);
            TProcessor process = new HelloWorldService.Processor((HelloWorldService.Iface) new HelloWorldServiceImpl());
            TBinaryProtocol.Factory portFactory=new TBinaryProtocol.Factory(true,true);
            args.processor(process);
            args.protocolFactory(portFactory);

            TServer server=new TSimpleServer(args);
            server.serve();

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();

        }
    }

    public static void main(String args[]){
        new HelloServer().startServer();
    }




}
