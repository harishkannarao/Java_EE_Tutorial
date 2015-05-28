package org.example.wsdl.helloworldservice;

import org.example.xsd.sayhello.SayHelloRequestType;
import org.example.xsd.sayhello.SayHelloResponseType;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "HelloWorldService", endpointInterface = "org.example.wsdl.helloworldservice.HelloWorldPortType")
public class HelloWorldServiceSoapEndpoint implements HelloWorldPortType{

    public static final String GREETING_EXPRESSION = "Hi %1s, your gender is %2s";

    @Override
    public SayHelloResponseType sayHello(@WebParam(name = "sayHelloRequestType", targetNamespace = "http://www.example.org/xsd/SayHello.xsd", partName = "parameters") SayHelloRequestType sayHelloRequestType) {
        SayHelloResponseType sayHelloResponseType = new SayHelloResponseType();
        sayHelloResponseType.setGreetings(
                String.format(GREETING_EXPRESSION, sayHelloRequestType.getName(), sayHelloRequestType.getGender())
        );
        return sayHelloResponseType;
    }
}
