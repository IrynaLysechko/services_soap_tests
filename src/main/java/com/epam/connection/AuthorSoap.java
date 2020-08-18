package com.epam.connection;

import com.epam.entity.Author;

import javax.xml.soap.*;

public class AuthorSoap {
    private Connection connection = new Connection();
    private SOAPMessage requestSOAPMessage;
    private SOAPMessage responseSOAPMessage;
    private SOAPConnection soapConnection;
    private SOAPBody soapBody;
    private final String libraryNameSpace = "lib";
    private final String libraryNamespaceURI = "libraryService";
    private final String soapEndpointUrl = "http://localhost:8080/ws";

    public SOAPMessage getAllAuthors() throws Exception {
        soapConnection = connection.callSoapWebService();
        requestSOAPMessage = connection.createSOAPMessage();
        soapBody = connection.createSoapEnvelope();

        SOAPElement getAuthorRequestElement = soapBody.addChildElement("getAuthorsRequest", libraryNameSpace);
        SOAPElement searchElement = getAuthorRequestElement.addChildElement("search", libraryNameSpace);
        SOAPElement sortOrderElement = searchElement.addChildElement("orderType", libraryNameSpace);
        sortOrderElement.addTextNode("asc");
        SOAPElement pageElement = searchElement.addChildElement("page", libraryNameSpace);
        pageElement.addTextNode("1");
        SOAPElement paginationElement = searchElement.addChildElement("pagination", libraryNameSpace);
        paginationElement.addTextNode("true");
        SOAPElement sizeElement = searchElement.addChildElement("size", libraryNameSpace);
        sizeElement.addTextNode("10");
        requestSOAPMessage.saveChanges();

        responseSOAPMessage = soapConnection.call(requestSOAPMessage, soapEndpointUrl);

        soapConnection.close();

        return responseSOAPMessage;
    }

    public SOAPMessage getAuthorUsingId(String authorId) throws SOAPException {
        soapConnection = connection.callSoapWebService();
        requestSOAPMessage = connection.createSOAPMessage();
        soapBody = connection.createSoapEnvelope();
        SOAPElement getAuthorRequestElement = soapBody.addChildElement("getAuthorRequest", libraryNameSpace);
        SOAPElement authorID = getAuthorRequestElement.addChildElement("authorId", libraryNameSpace);
        authorID.addTextNode(authorId);
        requestSOAPMessage.saveChanges();

        responseSOAPMessage = soapConnection.call(requestSOAPMessage, soapEndpointUrl);

        soapConnection.close();

        return responseSOAPMessage;
    }

    public SOAPMessage createNewAuthor(Author newAuthor) throws SOAPException {
        soapConnection = connection.callSoapWebService();
        requestSOAPMessage = connection.createSOAPMessage();
        soapBody = connection.createSoapEnvelope();

        SOAPElement createAuthorRequestElement = soapBody.addChildElement("createAuthorRequest", libraryNameSpace);
        SOAPElement author = createAuthorRequestElement.addChildElement("author", libraryNameSpace);
        SOAPElement authorIdElement = author.addChildElement("authorId", libraryNameSpace);
        authorIdElement.addTextNode(newAuthor.getAuthorId());
        SOAPElement name = author.addChildElement("authorName", libraryNameSpace);
        SOAPElement first = name.addChildElement("first", libraryNameSpace);
        first.addTextNode(newAuthor.getFirstName());
        SOAPElement second = name.addChildElement("second", libraryNameSpace);
        second.addTextNode(newAuthor.getSecondName());
        SOAPElement nationality = author.addChildElement("nationality", libraryNameSpace);
        nationality.addTextNode(newAuthor.getNationality());
        SOAPElement birth = author.addChildElement("birth", libraryNameSpace);
        SOAPElement date = birth.addChildElement("date", libraryNameSpace);
        date.addTextNode(newAuthor.getBirthDate());
        SOAPElement country = birth.addChildElement("country", libraryNameSpace);
        country.addTextNode(newAuthor.getBirthCountry());
        SOAPElement city = birth.addChildElement("city", libraryNameSpace);
        city.addTextNode(newAuthor.getBirthCity());
        SOAPElement authorDescription = author.addChildElement("authorDescription", libraryNameSpace);
        authorDescription.addTextNode(newAuthor.getDescription());

        requestSOAPMessage.saveChanges();

        responseSOAPMessage = soapConnection.call(requestSOAPMessage, soapEndpointUrl);

        soapConnection.close();

        return responseSOAPMessage;

    }

    public SOAPMessage updateAuthor (Author newAuthor) throws SOAPException {
        soapConnection = connection.callSoapWebService();
        requestSOAPMessage = connection.createSOAPMessage();
        soapBody = connection.createSoapEnvelope();

        SOAPElement updateAuthorRequestElement = soapBody.addChildElement("updateAuthorRequest", libraryNameSpace);
        SOAPElement author = updateAuthorRequestElement.addChildElement("author", libraryNameSpace);
        SOAPElement authorIdElement = author.addChildElement("authorId", libraryNameSpace);
        authorIdElement.addTextNode(newAuthor.getAuthorId());
        SOAPElement name = author.addChildElement("authorName", libraryNameSpace);
        SOAPElement first = name.addChildElement("first", libraryNameSpace);
        first.addTextNode(newAuthor.getFirstName());
        SOAPElement second = name.addChildElement("second", libraryNameSpace);
        second.addTextNode(newAuthor.getSecondName());
        SOAPElement nationality = author.addChildElement("nationality", libraryNameSpace);
        nationality.addTextNode(newAuthor.getNationality());
        SOAPElement birth = author.addChildElement("birth", libraryNameSpace);
        SOAPElement date = birth.addChildElement("date", libraryNameSpace);
        date.addTextNode(newAuthor.getBirthDate());
        SOAPElement country = birth.addChildElement("country", libraryNameSpace);
        country.addTextNode(newAuthor.getBirthCountry());
        SOAPElement city = birth.addChildElement("city", libraryNameSpace);
        city.addTextNode(newAuthor.getBirthCity());
        SOAPElement authorDescription = author.addChildElement("authorDescription", libraryNameSpace);
        authorDescription.addTextNode(newAuthor.getDescription());

        requestSOAPMessage.saveChanges();

        responseSOAPMessage = soapConnection.call(requestSOAPMessage, soapEndpointUrl);

        soapConnection.close();

        return responseSOAPMessage;
    }

    public SOAPMessage deleteAuthor(String authorId) throws SOAPException {
        soapConnection = connection.callSoapWebService();
        requestSOAPMessage = connection.createSOAPMessage();
        soapBody = connection.createSoapEnvelope();
        SOAPElement deleteAuthorRequestElement = soapBody.addChildElement("deleteAuthorRequest", libraryNameSpace);
        SOAPElement authorID = deleteAuthorRequestElement.addChildElement("authorId", libraryNameSpace);
        authorID.addTextNode(authorId);
        SOAPElement options = deleteAuthorRequestElement.addChildElement("options",libraryNameSpace);
        SOAPElement forcibly = options.addChildElement("forcibly",libraryNameSpace);
        forcibly.addTextNode("false");

        requestSOAPMessage.saveChanges();

        responseSOAPMessage = soapConnection.call(requestSOAPMessage, soapEndpointUrl);

        soapConnection.close();

        return responseSOAPMessage;
    }



}
