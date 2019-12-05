package com.fsd.taskmanagement.app.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID", updatable = false, nullable = false)
    private Long projectId;

    @Column(name="PROJECT_NAME", nullable = false)
    private String projectName;

    @Column(name = "PRIORITY")
    private long priority;

    @Column(name="START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name="END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name="IS_COMPLETED", nullable = false)
    private Boolean completed;

    @OneToOne
    @JoinColumn(name="MANAGER_ID", nullable=true)
    private User manager;

    @OneToMany(mappedBy = "project", fetch=FetchType.EAGER)
    @JsonManagedReference
    private Set<Task> tasklist;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Set<Task> getTasklist() {
        return tasklist;
    }

    public void setTasklist(Set<Task> tasklist) {
        this.tasklist = tasklist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectId.equals(project.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }
}

