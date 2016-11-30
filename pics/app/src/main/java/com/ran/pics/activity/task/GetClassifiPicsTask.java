package com.ran.pics.activity.task;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by fanyiran on 16/11/30.
 */

public class GetClassifiPicsTask {
    private Task task;

    public void execute(ArrayList<String> keyWordList){
        if(task != null)
            task.cancel(true);
        else
            task = new Task(keyWordList);
    }

    class Task extends AsyncTask {
        private ArrayList<String> keyWordList;

        public Task(ArrayList<String> keyWordList){
            this.keyWordList = keyWordList;
        }

        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }
    }
}
