package trading.app.interop.fix;

import com.devexperts.fast.client.fast.multicast.MulticastClientInputStream;
import com.devexperts.fast.client.openfast.OpenFastInput;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import org.openfast.Message;

import org.openfast.template.MessageTemplate;
import org.openfast.template.loader.MessageTemplateLoader;
import org.openfast.template.loader.XMLMessageTemplateLoader;

public class Main {

    /**
     * @param args See command line options added to "options" above.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Read message template
        InputStream templateSource = new FileInputStream("config//templates.xml");
        MessageTemplateLoader templateLoader = new XMLMessageTemplateLoader();
        MessageTemplate[] templates = templateLoader.load(templateSource);
        MessageTemplate tpl = templates[0];

        // Connect
        InetAddress group = InetAddress.getByName("194.247.133.77");
        MulticastSocket socket = new MulticastSocket(5001);
        socket.joinGroup(group);
        MulticastClientInputStream inputStream = new MulticastClientInputStream(socket);

        OpenFastInput fastInput = new OpenFastInput("input", inputStream);
        Message message = fastInput.readMessage();
        String str = message.getString(0);

        //FileOutputStream os = new FileOutputStream(outputFile, true)       

    }
}