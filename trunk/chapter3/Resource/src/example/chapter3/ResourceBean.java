package example.chapter3;

import java.io.IOException;

import org.springframework.core.io.Resource;

public class ResourceBean {

    public void setUrlResource(Resource resource) throws IOException {
        System.out.println(resource.getURL());
    }

    public void setClasspathResource(Resource resource) throws IOException {
        System.out.println(resource.getFile());
    }

    public void setFileResource(Resource resource) throws IOException {
        System.out.println(resource.getFile());
    }

}
