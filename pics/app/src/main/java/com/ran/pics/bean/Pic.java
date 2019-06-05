package com.ran.pics.bean;

import com.ran.pics.adapter.itemtype.PicItem;

import java.io.File;
import java.io.Serializable;

public abstract class Pic implements Serializable {
	private File localFile;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    private boolean isChecked;

    public boolean isLoadFailed() {
        return isLoadFailed;
    }

    public void setLoadFailed(boolean isLoadFailed) {
        this.isLoadFailed = isLoadFailed;
    }

    private boolean isLoadFailed;

    public abstract String getId();
	public abstract String getName();
	public abstract String getLinkUrl();
	public abstract String getWidth();
	public abstract String getHeight();
	public abstract String getFindUrl();
	public abstract String getThumbnail();

	public File getLocalFile() {
		return localFile;
	}

	public void setLocalFile(File localFile) {
		this.localFile = localFile;
	}

    public abstract int getItemType();
}
