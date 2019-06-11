
package aiss.model.gmail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageList {

    private List<Message> messages = null;
    private String nextPageToken;
    private Integer resultSizeEstimate;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public Integer getResultSizeEstimate() {
        return resultSizeEstimate;
    }

    public void setResultSizeEstimate(Integer resultSizeEstimate) {
        this.resultSizeEstimate = resultSizeEstimate;
    }

}
