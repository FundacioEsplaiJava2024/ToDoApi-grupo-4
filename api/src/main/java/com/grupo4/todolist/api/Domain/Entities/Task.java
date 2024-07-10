package com.grupo4.todolist.api.Domain.Entities;

public class Task {
    private String taskId;
    private String taskName;
    private String sourceColumn;
    
    public Task(String taskId, String taskName, String sourceColumn) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.sourceColumn = sourceColumn;
    }

    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getSourceColumn() {
        return sourceColumn;
    }
    public void setSourceColumn(String sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (taskId == null) {
            if (other.taskId != null)
                return false;
        } else if (!taskId.equals(other.taskId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", sourceColumn=" + sourceColumn + "]";
    }

    
    
    
    

}
