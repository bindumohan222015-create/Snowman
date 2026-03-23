/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao.impl;

import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.db.dao.AbstractHibernateDao;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ProjectDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaoImpl extends AbstractHibernateDao implements ProjectDao {

    @Override
    public Project retrieveProject(int projectId) {
        return (Project) getCurrentSession().get(Project.class, projectId);
    }

    @Override
    public void saveProject(Project project) {
        getCurrentSession().saveOrUpdate(project);
    }

    @Override
    public void removeProject(int projectId) {
        Project project = retrieveProject(projectId);
        if (project != null) {
            getCurrentSession().delete(project);
        }
    }
}
