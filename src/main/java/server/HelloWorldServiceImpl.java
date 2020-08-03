package server;

import org.apache.thrift.TException;

public class HelloWorldServiceImpl implements thrift_demo.HelloWorldService.Iface {

    public HelloWorldServiceImpl() {
    }
    @Override
    public String sayHello(String username) throws TException {

               return "Hi,"+username+" Welcome to my World";
            }
}
