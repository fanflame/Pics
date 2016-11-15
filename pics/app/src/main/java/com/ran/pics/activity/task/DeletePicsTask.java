package com.ran.pics.activity.task;

import android.content.Context;
import android.os.AsyncTask;

import com.ran.pics.bean.Pic;

import java.io.File;
import java.util.ArrayList;

public class DeletePicsTask {
    private Context context;
    private Task task;
    private OnDeletePicsCompleteListener ondeletePicsCompleteListener;

    public DeletePicsTask(Context context,
                          OnDeletePicsCompleteListener ondeletePicsCompleteListener) {
        this.context = context;
        this.ondeletePicsCompleteListener = ondeletePicsCompleteListener;
    }

    public void execute(ArrayList<Pic> picList) {
        (task = new Task(picList)).executeOnExecutor(ExecutorUtils.getDefaultExecutor());
    }

    public void cancleTask() {
        if (task != null)
            task.cancel(true);

    }

    public interface OnDeletePicsCompleteListener {
        void onDeletePicsComplete(boolean result);
    }

    class Task extends AsyncTask<Void, Void, Boolean> {
        private ArrayList<Pic> picList;

        public Task(ArrayList<Pic> picList) {
            this.picList = picList;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            if (picList == null)
                return false;
            int count = picList.size();
            Pic picTemp;
            File fileTemp;
            for (int i = 0; i < count; i++) {
                picTemp = picList.get(i);
                if((fileTemp = new File(picTemp.getLinkUrl())).exists())
                    fileTemp.delete();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (ondeletePicsCompleteListener != null)
                ondeletePicsCompleteListener.onDeletePicsComplete(result);
            super.onPostExecute(result);
        }
    }
}
