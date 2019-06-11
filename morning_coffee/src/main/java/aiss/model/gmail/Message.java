
package aiss.model.gmail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	private String id;
	private String threadId;
	private List<String> labelIds = null;
	private String snippet;
	private String historyId;
	private String internalDate;
	private Payload payload;
	private Integer sizeEstimate;
	private String raw;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public List<String> getLabelIds() {
		return labelIds;
	}

	public void setLabelIds(List<String> labelIds) {
		this.labelIds = labelIds;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public String getInternalDate() {
		return internalDate;
	}

	public void setInternalDate(String internalDate) {
		this.internalDate = internalDate;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public Integer getSizeEstimate() {
		return sizeEstimate;
	}

	public void setSizeEstimate(Integer sizeEstimate) {
		this.sizeEstimate = sizeEstimate;
	}

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

}
