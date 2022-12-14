package com.sinchan.hibernateproject.requestDto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class WorkflowStartDto {

    private String journeyName;
    private String userId;
    private String userPassword;
    private Map<String, Object> variableMap;

    public WorkflowStartDto() {
        super();

    }

    public WorkflowStartDto(String journeyName, String userId, String userPassword, Map<String, Object> variableMap) {
        super();
        this.journeyName = journeyName;
        this.userId = userId;
        this.userPassword = userPassword;
        this.variableMap = variableMap;
    }
    
    

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getJourneyName() {
        return journeyName;
    }

    public void setJourneyName(String journeyName) {
        this.journeyName = journeyName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getVariableMap() {
        return variableMap;
    }

    public void setVariableMap(Map<String, Object> variableMap) {
        this.variableMap = variableMap;
    }

    @Override
    public String toString() {
        return "WorkflowStartDto [journeyName=" + journeyName + ", userId=" + userId + ", variableMap=" + variableMap
                + "]";
    }

}
