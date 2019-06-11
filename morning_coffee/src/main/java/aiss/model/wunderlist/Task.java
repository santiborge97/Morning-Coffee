
package aiss.model.wunderlist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "assignee_id",
    "created_at",
    "created_by_id",
    "due_date",
    "list_id",
    "revision",
    "starred",
    "title"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("assignee_id")
    private Integer assigneeId;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("created_by_id")
    private Integer createdById;
    @JsonProperty("due_date")
    private String dueDate;
    @JsonProperty("list_id")
    private Long listId;
    @JsonProperty("revision")
    private Integer revision;
    @JsonProperty("starred")
    private Boolean starred;
    @JsonProperty("title")
    private String title;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("assignee_id")
    public Integer getAssigneeId() {
        return assigneeId;
    }

    @JsonProperty("assignee_id")
    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("created_by_id")
    public Integer getCreatedById() {
        return createdById;
    }

    @JsonProperty("created_by_id")
    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    @JsonProperty("due_date")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("due_date")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("list_id")
    public Long getListId() {
        return listId;
    }

    @JsonProperty("list_id")
    public void setListId(Long listId) {
        this.listId = listId;
    }

    @JsonProperty("revision")
    public Integer getRevision() {
        return revision;
    }

    @JsonProperty("revision")
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    @JsonProperty("starred")
    public Boolean getStarred() {
        return starred;
    }

    @JsonProperty("starred")
    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

}
