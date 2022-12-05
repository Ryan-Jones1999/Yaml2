package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewRole {

    protected String jobName;

    protected String jobResponsibility;

    protected String specSummary;

    protected int capabilityID;

    protected int bandLevelID;

    protected int jobFamilyID;

    @JsonCreator
    public NewRole(
            @JsonProperty("jobName") String jobName,
            @JsonProperty("jobResponsibility") String jobResponsibility,
            @JsonProperty("specSummary") String spec,
            @JsonProperty("jobFamilyId") int jobFamilyID,
            @JsonProperty("bandLevelId") int bandLevelID,
            @JsonProperty("capabilityId") int capabilityID
    ) {
        setJobName(jobName);
        setJobResponsibility(jobResponsibility);
        setSpecSummary(spec);
        setJobFamilyID(jobFamilyID);
        setBandLevelID(bandLevelID);
        setCapabilityID(capabilityID);
    }
}
