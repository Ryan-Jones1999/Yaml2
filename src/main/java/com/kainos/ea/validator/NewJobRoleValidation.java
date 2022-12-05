package com.kainos.ea.validator;

import com.kainos.ea.model.NewRole;

public class NewJobRoleValidation {

    public boolean NewRoleValidation(NewRole role){
        if(role.getJobFamilyID() < 1 || role.getBandLevelID() < 1 || role.getCapabilityID() < 1){
            return false;
        }

        if(role.getJobName().length() < 5){
            return false;
        }

        if(role.getJobResponsibility().length() < 10){
            return false;
        }

        return role.getSpecSummary().length() >= 8;

    }
}
