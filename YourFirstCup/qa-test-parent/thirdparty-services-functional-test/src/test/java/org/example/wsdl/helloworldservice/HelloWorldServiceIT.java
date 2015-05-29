package org.example.wsdl.helloworldservice;

import org.example.xsd.sayhello.SayHelloRequest;
import org.example.xsd.sayhello.SayHelloResponse;
import org.junit.Test;

import javax.xml.ws.BindingProvider;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class HelloWorldServiceIT {

    private static final String appUrl = System.getProperty("appServerUrl", "http://localhost:8080");
    private static final String serviceEndpointUrl = appUrl + "/thirdparty-soap-service-test-support-war/HelloWorldService";
    private static final String wsdlUrl = serviceEndpointUrl + "?wsdl";
    private HelloWorldPortType helloWorldServiceProxy;

    public HelloWorldServiceIT() {
        try {
            helloWorldServiceProxy = new HelloWorldService(new URL(wsdlUrl)).getHelloWorldPort();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        BindingProvider bindingProvider = (BindingProvider) helloWorldServiceProxy;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, serviceEndpointUrl);
    }

    @Test
    public void shouldGetGreetingMessageFromThirdPartyService() {
        SayHelloRequest request = new SayHelloRequest();
        request.setName("Harish");
        request.setGender("Male");
        SayHelloResponse response = helloWorldServiceProxy.sayHello(request);
        String expectedMessage = String.format("Hi %1s, your gender is %2s",request.getName(), request.getGender());
        assertEquals(expectedMessage, response.getGreetings());
    }
}
