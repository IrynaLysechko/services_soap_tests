package com.epam.connection;

import javax.xml.soap.*;

public class Connection {
    private static SOAPMessage soapMessage;
    private static SOAPConnection soapConnection;
    private final static String libraryNameSpace = "lib";
    private final static String libraryNamespaceURI = "libraryService";

    public SOAPConnection callSoapWebService() throws SOAPException {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        soapConnection = soapConnectionFactory.createConnection();
        return soapConnection;
    }

    public SOAPMessage createSOAPMessage() throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        soapMessage = messageFactory.createMessage();
        return soapMessage;
    }

    public SOAPBody createSoapEnvelope() throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(libraryNameSpace, libraryNamespaceURI);
        return envelope.getBody();
    }
}
