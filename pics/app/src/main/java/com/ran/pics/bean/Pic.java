package com.ran.pics.bean;

import java.io.File;
import java.io.Serializable;

public class Pic implements Serializable {
    private String id;
    private String url;
    private String name;
    private String linkUrl;
    private String showUrl;
    private String ext;
    private String width;
    private String height;
    private String findUrl;
    private String recommend;
    private String love;
    private String thumbnail;
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

    public Pic(){

    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getShowUrl() {
		return showUrl;
	}
	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getFindUrl() {
		return findUrl;
	}
	public void setFindUrl(String findUrl) {
		this.findUrl = findUrl;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public File getLocalFile() {
		return localFile;
	}

	public void setLocalFile(File localFile) {
		this.localFile = localFile;
	}
}
