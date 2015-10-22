package com.icbc.pis.datastruct;

import java.util.ArrayList;
import java.util.Collections;

public class MenuItem implements Comparable<MenuItem> {

	private String icon;

	private boolean hasChild;

	private String text;

	private String url;
	private int order;

	private ArrayList<MenuItem> children;

	public MenuItem(String icon, String text, String url, boolean hasChild, ArrayList<MenuItem> children, int order) {
		super();
		this.icon = icon;
		this.hasChild = hasChild;
		this.text = text;
		this.url = url;
		this.children = children;
		this.order = order;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
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

	public ArrayList<MenuItem> getChildren() {
		return this.children;
	}

	public void setChildren(ArrayList<MenuItem> children) {
		this.children = children;
	}

	public void addChildren(MenuItem children) {
		if (this.children == null)
			this.children = new ArrayList();
		this.children.add(children);
	}

	public void SortChildren() {
		if (this.hasChild) {
			for (MenuItem one : this.children) {
				one.SortChildren();
			}
			Collections.sort(this.children);
		}
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int compareTo(MenuItem o) {
		// TODO Auto-generated method stub
		if (this.order > o.getOrder())
			return 0;
		else
			return -1;
	}

}
