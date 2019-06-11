
package aiss.model.wunderlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"title",
"owner_type",
"owner_id",
"list_type",
"public",
"revision",
"created_at",
"type",
"created_by_request_id"
})
public class WunderList {

@JsonProperty("id")
private Integer id;
@JsonProperty("title")
private String title;
@JsonProperty("owner_type")
private String ownerType;
@JsonProperty("owner_id")
private Integer ownerId;
@JsonProperty("list_type")
private String listType;
@JsonProperty("public")
private Boolean _public;
@JsonProperty("revision")
private Integer revision;
@JsonProperty("created_at")
private String createdAt;
@JsonProperty("type")
private String type;
@JsonProperty("created_by_request_id")
private String createdByRequestId;

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("owner_type")
public String getOwnerType() {
return ownerType;
}

@JsonProperty("owner_type")
public void setOwnerType(String ownerType) {
this.ownerType = ownerType;
}

@JsonProperty("owner_id")
public Integer getOwnerId() {
return ownerId;
}

@JsonProperty("owner_id")
public void setOwnerId(Integer ownerId) {
this.ownerId = ownerId;
}

@JsonProperty("list_type")
public String getListType() {
return listType;
}

@JsonProperty("list_type")
public void setListType(String listType) {
this.listType = listType;
}

@JsonProperty("public")
public Boolean getPublic() {
return _public;
}

@JsonProperty("public")
public void setPublic(Boolean _public) {
this._public = _public;
}

@JsonProperty("revision")
public Integer getRevision() {
return revision;
}

@JsonProperty("revision")
public void setRevision(Integer revision) {
this.revision = revision;
}

@JsonProperty("created_at")
public String getCreatedAt() {
return createdAt;
}

@JsonProperty("created_at")
public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("created_by_request_id")
public String getCreatedByRequestId() {
return createdByRequestId;
}

@JsonProperty("created_by_request_id")
public void setCreatedByRequestId(String createdByRequestId) {
this.createdByRequestId = createdByRequestId;
}

}