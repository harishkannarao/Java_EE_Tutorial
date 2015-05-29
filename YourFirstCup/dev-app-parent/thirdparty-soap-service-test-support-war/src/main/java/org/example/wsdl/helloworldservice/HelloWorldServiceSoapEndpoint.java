package org.example.wsdl.helloworldservice;


import org.example.xsd.sayhello.SayHelloRequest;
import org.example.xsd.sayhello.SayHelloResponse;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "HelloWorldService", serviceName = "HelloWorldService", portName="HelloWorldPort", endpointInterface = "org.example.wsdl.helloworldservice.HelloWorldPortType")
public class HelloWorldServiceSoapEndpoint implements HelloWorldPortType{

    public static final String GREETING_EXPRESSION = "Hi %1s, your gender is %2s";

    @Override
    public SayHelloResponse sayHello(@WebParam(name = "sayHelloRequestType", targetNamespace = "http://www.example.org/xsd/SayHello.xsd", partName = "parameters") SayHelloRequest sayHelloRequest) {
        SayHelloResponse sayHelloResponse = new SayHelloResponse();
        sayHelloResponse.setGreetings(
                String.format(GREETING_EXPRESSION, sayHelloRequest.getName(), sayHelloRequest.getGender())
        );
        return sayHelloResponse;
    }
}
