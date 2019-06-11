
package aiss;


public class WunderlistRequest {

    private String client_id;
    private String client_secret;
    private String code;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String clientId) {
        this.client_id = clientId;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String clientSecret) {
        this.client_secret = clientSecret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
