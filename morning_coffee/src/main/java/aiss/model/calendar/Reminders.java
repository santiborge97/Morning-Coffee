
package aiss.model.calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "useDefault"
})


@JsonIgnoreProperties(ignoreUnknown = true)
public class Reminders {

    @JsonProperty("useDefault")
    private Boolean useDefault;

    @JsonProperty("useDefault")
    public Boolean getUseDefault() {
        return useDefault;
    }

    @JsonProperty("useDefault")
    public void setUseDefault(Boolean useDefault) {
        this.useDefault = useDefault;
    }

}
