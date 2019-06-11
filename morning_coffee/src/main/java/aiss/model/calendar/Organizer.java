
package aiss.model.calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "email",
    "displayName",
    "self"
})


@JsonIgnoreProperties(ignoreUnknown = true)
public class Organizer {

    @JsonProperty("email")
    private String email;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("self")
    private Boolean self;

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("self")
    public Boolean getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Boolean self) {
        this.self = self;
    }

}
