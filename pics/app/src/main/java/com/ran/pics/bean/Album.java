package com.ran.pics.bean;


import java.util.ArrayList;

public class Album {
	private String owner;
	private String albumId;
	private String name;
	private String num;
	private String code;
	private ArrayList<Pic> picList;
	private String page;
	
    public Album(){
    	
    }
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<Pic> getPicList() {
		return picList;
	}
	public void setPicList(ArrayList<Pic> picList) {
		this.picList = picList;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
}
