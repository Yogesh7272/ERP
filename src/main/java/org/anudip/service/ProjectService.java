package org.anudip.service;

import java.util.List;
import org.anudip.dao.ProjectDao;
import org.anudip.model.Project;

public class ProjectService {
    private ProjectDao projectDao;

    // Constructor to initialize ProjectDao
    public ProjectService() {
        this.projectDao = new ProjectDao();  // Initialize the DAO
    }

    // Method to add a new project
    public void addProject(Project project) {
        projectDao.addProject(project);
    }

    // Method to delete a project by ID
    public void deleteProject(int id) {
        projectDao.deleteProject(id);
    }

    // Method to get a project by ID
    public Project getProject(int id) {
        return projectDao.getProject(id);
    }

    // Method to update project details
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }

    // Method to list all projects
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }
}
