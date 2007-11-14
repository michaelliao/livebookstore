package example.chapter3;

import java.beans.PropertyEditorSupport;

public class ContactEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] ss = text.split("[ ]*\\;[ ]*");
        if(ss.length!=3)
            throw new IllegalArgumentException(text);
        Contact contact = new Contact();
        contact.setName(ss[0]);
        contact.setAddress(ss[1]);
        contact.setZip(ss[2]);
        setValue(contact);
    }

}
