package org.example.wsdl.helloworldservice;

import org.example.xsd.sayhello.SayHelloRequestType;
import org.example.xsd.sayhello.SayHelloResponseType;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.ws.BindingProvider;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class HelloWorldServiceIT {

    private static final String appUrl = System.getProperty("appServerUrl", "http://localhost:8080");
    private static final String serviceEndpointUrl = appUrl + "/thirdparty-soap-service-test-support-war/HelloWorldService";
    private static final String wsdlUrl = serviceEndpointUrl + "?wsdl";
    private HelloWorldPortType helloWorldServiceProxy;

    public HelloWorldServiceIT() {
        helloWorldServiceProxy = new HelloWorldService().getHelloWorldPort();

        BindingProvider bindingProvider = (BindingProvider) helloWorldServiceProxy;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, serviceEndpointUrl);
    }

    @Test
    @Ignore
    public void shouldGetGreetingMessageFromThirdPartyService() {
        SayHelloRequestType request = new SayHelloRequestType();
        request.setName("Harish");
        request.setGender("Male");
        SayHelloResponseType response = helloWorldServiceProxy.sayHello(request);
        String expectedMessage = String.format("Hi %1s, your gender is %2s",request.getName(), request.getGender());
        assertEquals(expectedMessage, response.getGreetings());
    }
}
