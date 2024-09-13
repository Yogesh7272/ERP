package org.anudip.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name", length = 100)
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Temporal(TemporalType.DATE)
    @Column(name = "deadline")
    private Date deadline;

	public Project() {
	}

	public Project(int projectId, String projectName, Client client, Date deadline) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.client = client;
		this.deadline = deadline;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

    


}
