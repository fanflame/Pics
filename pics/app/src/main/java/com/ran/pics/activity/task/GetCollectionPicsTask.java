package com.ran.pics.activity.task;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;

import com.ran.pics.bean.BaiduJson;
import com.ran.pics.bean.Pic;

import java.io.File;
import java.util.ArrayList;

public class GetCollectionPicsTask {
    private Context context;
    private CollectionPicsTask collectionPicsTask;
    private OnGetCollectionPicsListener onGetCollectionPicsListener;

    public GetCollectionPicsTask(Context context,
                                 OnGetCollectionPicsListener onGetCollectionPicsListener) {
        this.context = context;
        this.onGetCollectionPicsListener = onGetCollectionPicsListener;
    }

    public void execute(String filePath) {
        (collectionPicsTask = new CollectionPicsTask(filePath)).executeOnExecutor(ExecutorUtils.getDefaultExecutor());
    }

    public void cancleTask() {
        if (collectionPicsTask != null)
            collectionPicsTask.cancel(true);

    }

    public interface OnGetCollectionPicsListener {
        void onGetCollectionPics(ArrayList<Pic> result);
    }

    class CollectionPicsTask extends AsyncTask<Void, Void, ArrayList<Pic>> {
        private String filePath;

        public CollectionPicsTask(String filePath) {
            this.filePath = filePath;
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
        protected ArrayList<Pic> doInBackground(Void... params) {
            if (filePath == null)
                return null;
//            if(Environment.getExternalStorageState() != Environment.MEDIA_MOUNTED)
//                return null;
            File file = new File(Environment.getExternalStorageDirectory()+filePath);
            if(!file.exists()){
                file.mkdirs();
                return null;
            }
            File[] files = file.listFiles();
            if(files == null)
                return null;
            int size = files.length;
            ArrayList<Pic> resultList = new ArrayList<Pic>(size);
            Pic picTemp;
            for (int i = 0; i < size; i++) {
                picTemp = new BaiduJson.ImgsBean();
                picTemp.setLocalFile(new File(file.getAbsolutePath(),files[i].getName()));
                resultList.add(picTemp);
            }
            return resultList;
        }

        @Override
        protected void onPostExecute(ArrayList<Pic> result) {
            if (onGetCollectionPicsListener != null)
                onGetCollectionPicsListener.onGetCollectionPics(result);
            super.onPostExecute(result);
        }
    }
}
