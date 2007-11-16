package example.chapter7;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.springframework.web.servlet.view.xslt.AbstractXsltView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestXsltView extends AbstractXsltView {

    @Override
    protected Source createXsltSource(Map model, String rootName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = document.createElement(rootName);
        // 添加<name>:
        String name = (String)model.get("name");
        Element nameNode = document.createElement("name");
        nameNode.appendChild(document.createTextNode(name));
        root.appendChild(nameNode);
        // 添加<time>:
        Date time = (Date)model.get("time");
        Element timeNode = document.createElement("time");
        timeNode.appendChild(document.createTextNode(time.toString()));
        root.appendChild(timeNode);
        return new DOMSource(root);
    }

}
