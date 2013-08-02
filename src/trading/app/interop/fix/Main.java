package trading.app.interop.fix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.openfast.template.MessageTemplate;
import org.openfast.template.loader.MessageTemplateLoader;
import org.openfast.template.loader.XMLMessageTemplateLoader;



public class Main  {

    /**
     * @param args See command line options added to "options" above.
     */
    public static void main(String[] args) throws FileNotFoundException {


InputStream templateSource = new FileInputStream("config//templates.xml");
MessageTemplateLoader templateLoader = new XMLMessageTemplateLoader();
MessageTemplate[] templates = templateLoader.load(templateSource);
MessageTemplate tpl  = templates[0];

    }
}