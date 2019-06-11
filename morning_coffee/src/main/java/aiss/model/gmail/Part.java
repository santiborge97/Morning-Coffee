
package aiss.model.gmail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Part {

    private String partId;
    private String mimeType;
    private String filename;
    private List<Header_> headers = null;
    private Body_ body;

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Header_> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header_> headers) {
        this.headers = headers;
    }

    public Body_ getBody() {
        return body;
    }

    public void setBody(Body_ body) {
        this.body = body;
    }

}
