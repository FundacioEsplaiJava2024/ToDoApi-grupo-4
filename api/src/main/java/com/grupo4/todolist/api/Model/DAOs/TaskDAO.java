package com.grupo4.todolist.api.Model.DAOs;

import java.util.ArrayList;
import java.util.List;

import com.grupo4.todolist.api.Model.Entities.Task;

public class TaskDAO {
    int displayLimit = 100; //Variable in charge of displaying the number of elements, will change later based on the parameters.

    public static List<Task> getTasks(){
        List<Task> result = new ArrayList<>();
        Task a,b,c;
        result.add(a = new Task("a1","test","c1"));
        result.add(b = new Task("a2","test2","c2"));
        result.add(c = new Task("a3","test3","c1"));
        return result;
    }

	public static int insert(Task task) {
		int result = -1;
        if(task!=null){
            result = 1;
        }else{{  
            result = 0;
        }}
        return result;
	}
}
