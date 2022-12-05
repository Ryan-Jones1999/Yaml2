package com.kainos.ea.service;

import com.kainos.ea.dao.JobDao;
import com.kainos.ea.exception.DatabaseException;
import com.kainos.ea.exception.RoleNotAddedException;
import com.kainos.ea.model.JobRole;
import com.kainos.ea.model.NewRole;
import java.sql.SQLException;
import java.util.List;

public class NewRoleService {
    public JobDao jobDao;

    public NewRoleService(JobDao dao){
        this.jobDao = dao;
    }

    public List<JobRole> populateFamilyLists() throws DatabaseException, SQLException {
        List<JobRole> family;
        family = jobDao.populateFamilyLists();

        assert family.size() >= 1 : "Error in view family";
        return family;
    }
    public List<JobRole> populateCapabiltyLists() throws DatabaseException, SQLException {
        List<JobRole> capability;
        capability = jobDao.populateCapabilityList();

        assert capability.size() >= 1 : "Error in view capabilities";

        return capability;
    }

    public List<JobRole> populateBandLists() throws DatabaseException, SQLException {
        List<JobRole> band;
        band = jobDao.populateBandLevelList();

        assert band.size() >= 1 : "Error in view bands";
        return band;
    }

    public NewRole addNewRole(NewRole newRole) throws DatabaseException, SQLException, RoleNotAddedException {
        NewRole newrole = jobDao.postNewjobrole(newRole);

        assert newrole.getJobName().length() >= 1 : "Error in adding new role";

        return newrole;
    }
}