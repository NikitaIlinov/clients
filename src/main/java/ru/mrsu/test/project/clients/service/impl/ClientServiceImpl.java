package ru.mrsu.test.project.clients.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import ru.mrsu.test.project.clients.jpa.ClientRepository;
import ru.mrsu.test.project.clients.model.Client;
import ru.mrsu.test.project.clients.service.ClientService;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ResourceLoader resourceLoader;

    @Override
    public List<Client> getClients() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:client.xml");
            InputStream inputStream = resource.getInputStream();
            parser = factory.createXMLStreamReader(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        List<Client> clients = new ArrayList<>();
        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("client")) {
                        clients.add(new Client(

                                Integer.parseInt(parser.getAttributeValue(0)),
                                parser.getAttributeValue(1),
                                parser.getAttributeValue(2),
                                Integer.parseInt(parser.getAttributeValue(3))
                        ));
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

    @Override
    public void  setClients() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:client.xml");
            InputStream inputStream = resource.getInputStream();
            parser = factory.createXMLStreamReader(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        List<Client> clients = new ArrayList<>();
        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("client")) {
                        clients.add(new Client(

                                Integer.parseInt(parser.getAttributeValue(0)),
                                parser.getAttributeValue(1),
                                parser.getAttributeValue(2),
                                Integer.parseInt(parser.getAttributeValue(3))
                        ));
                    }
                }
            }
            clientRepository.saveAll(clients);
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
    }
}

