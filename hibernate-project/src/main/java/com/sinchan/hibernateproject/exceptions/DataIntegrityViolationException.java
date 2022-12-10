package com.sinchan.hibernateproject.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
    String resourceName;
    String fieldName;
    Object fieldValue;

    public DataIntegrityViolationException() {
    }

    public DataIntegrityViolationException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: %s ", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return this.fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

}
