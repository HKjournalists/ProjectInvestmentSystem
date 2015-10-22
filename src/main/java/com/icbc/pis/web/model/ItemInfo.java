package com.icbc.pis.web.model;

import java.util.ArrayList;

public class ItemInfo {

	private String id;

	private String text;

	private String url;

	private String itemType;

	private String icon;

	private String parent;
	private int order;

	public ItemInfo(String id, String text, String url, String itemType, String icon, String parent, int order) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.itemType = itemType;
		this.icon = icon;
		this.parent = parent;
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

}
