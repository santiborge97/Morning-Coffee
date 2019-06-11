
package aiss.model.calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "method",
    "minutes"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultReminder {

    @JsonProperty("method")
    private String method;
    @JsonProperty("minutes")
    private Integer minutes;

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("minutes")
    public Integer getMinutes() {
        return minutes;
    }

    @JsonProperty("minutes")
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

}
