package com.epam.connection;

import com.epam.entity.Author;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.soap.Node;

import javax.xml.soap.*;

import java.io.IOException;
import java.util.Iterator;

public class AuthorSoapTest {
    private AuthorSoap authorSoap = new AuthorSoap();

    //Create new author
    @Test
    public void createNewAuthor() throws SOAPException, IOException {
        Author author = new Author();
        author.setAuthorId("59");
        author.setFirstName("Iryna");
        author.setSecondName("Lysechko");
        author.setNationality("Ukrainian");
        author.setBirthDate("1997-05-14");
        author.setBirthCountry("Ukraine");
        author.setBirthCity("Lviv");
        author.setDescription("Starter author");

        SOAPMessage soapMessage = authorSoap.createNewAuthor(author);
        soapMessage.writeTo(System.out);
        SOAPBody body = soapMessage.getSOAPBody();

        Iterator itr = body.getChildElements();

        Node node = (Node) itr.next();
        Node node1 = (Node) node.getFirstChild();
        Node node2 = (Node) node1.getFirstChild();
        String authorId = node2.getValue();

        Assert.assertEquals("Cannot create author", author.getAuthorId(), authorId);
    }

    //Negative test case - author with such ID exist -> fault
    @Test
    public void createNewAuthor_whenAuthorWithSuchIdAlreadyExist() throws SOAPException, IOException {

        Author author = new Author();
        author.setAuthorId("1290");
        author.setFirstName("Iryna");
        author.setSecondName("Lysechko");
        author.setNationality("Ukrainian");
        author.setBirthDate("1997-05-14");
        author.setBirthCountry("Ukraine");
        author.setBirthCity("Lviv");
        author.setDescription("Starter author");

        String errorMessage = "Author with id " + author.getAuthorId() + " already exists";

        SOAPMessage soapMessage = authorSoap.createNewAuthor(author);
        soapMessage.writeTo(System.out);
        SOAPFault soapFault = soapMessage.getSOAPPart().getEnvelope().getBody().getFault();
        String message = soapFault.getFaultString();
        Assert.assertEquals(errorMessage, message);
    }

    //get author use ID - when take author -> compare two ID
    @Test
    public void getAuthorUseId() throws SOAPException, IOException {
        final String authorId = "1290";

        SOAPMessage message = authorSoap.getAuthorUsingId(authorId);
        message.writeTo(System.out);

        Iterator iterator = message.getSOAPBody().getChildElements();

        Node node = (Node) iterator.next();
        Node node1 = (Node) node.getFirstChild();
        Node node2 = (Node) node1.getFirstChild();
        String authorIdFromResponse = node2.getValue();

        Assert.assertEquals(authorId, authorIdFromResponse);
    }

    @Test
    public void deleteAuthor() throws SOAPException, IOException {
        Author author = new Author();
        author.setAuthorId("7654");
        author.setFirstName("Oleg");
        author.setSecondName("Lysechko");
        author.setNationality("Ukrainian");
        author.setBirthDate("1997-05-14");
        author.setBirthCountry("Ukraine");
        author.setBirthCity("Lviv");
        author.setDescription("Starter author");
        String successDelete = "Successfully deleted author " + author.getAuthorId() ;

        SOAPMessage soapMessage = authorSoap.createNewAuthor(author);

        SOAPMessage soapMessage1 = authorSoap.deleteAuthor(author.getAuthorId());
        soapMessage.writeTo(System.out);

        Iterator iterator = soapMessage1.getSOAPBody().getChildElements();
        Node node = (Node) iterator.next();
        Node node1 = (Node) node.getFirstChild();
        String status = node1.getValue();

        Assert.assertEquals(successDelete,status);
    }
    @Test
    public void updateAuthor_whenUpdated_check() throws SOAPException, IOException {

        Author author = new Author();
        author.setAuthorId("59");
        author.setFirstName("Oleg");
        author.setSecondName("Lysechko");
        author.setNationality("Ukrainian");
        author.setBirthDate("1997-05-14");
        author.setBirthCountry("Ukraine");
        author.setBirthCity("Lviv");
        author.setDescription("Starter author");
        String successDelete = "Successfully deleted author " + author.getAuthorId() ;

        SOAPMessage soapMessage = authorSoap.updateAuthor(author);
        soapMessage.writeTo(System.out);

        SOAPMessage message = authorSoap.deleteAuthor(author.getAuthorId());
        Iterator iterator1 = message.getSOAPBody().getChildElements();
        Node nodeF = (Node) iterator1.next();
        Node nodeS = (Node) nodeF.getFirstChild();
        String status = nodeS.getValue();
        Assert.assertEquals(successDelete,status);
    }

    @Test
    public void getAllAuthor() throws Exception {
        SOAPMessage message = authorSoap.getAllAuthors();
        message.writeTo(System.out);
        MimeHeaders mimeHeaders = message.getMimeHeaders();

        Iterator iterator = mimeHeaders.getAllHeaders();
        while (iterator.hasNext()){
            MimeHeader mimeHeader = (MimeHeader) iterator.next();
            String string = mimeHeader.getName() + " " + mimeHeader.getValue();
            System.out.println(string);
        }
    }
}

