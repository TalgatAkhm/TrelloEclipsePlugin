package model;

import java.util.List;

public class Board {
	private String id;
	private String name;
	private String desc;
	private String descData;
	private boolean closed;
	private String idOrganization;
	private boolean pinned;
	private String url;
	private String shortUrl;
	private boolean starred;
	private List<Object> memberships;

	public Board(String id, String name, String desc, String descData, boolean closed, String idOrganization,
			boolean pinned, String url, String shortUrl, boolean starred, List<Object> memberships) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.descData = descData;
		this.closed = closed;
		this.idOrganization = idOrganization;
		this.pinned = pinned;
		this.url = url;
		this.shortUrl = shortUrl;
		this.starred = starred;
		this.memberships = memberships;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDescData() {
		return descData;
	}

	public void setDescData(String descData) {
		this.descData = descData;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public String getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(String idOrganization) {
		this.idOrganization = idOrganization;
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public boolean isStarred() {
		return starred;
	}

	public void setStarred(boolean starred) {
		this.starred = starred;
	}

	public List<Object> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Object> memberships) {
		this.memberships = memberships;
	}

}
