package model;

public class Card {
	private String id;
	private boolean closed;
	private String desc;
	private String name;
	
	public Card() {
		
	}
	
	public Card(String id, boolean closed, String desc, String name) {
		super();
		this.id = id;
		this.closed = closed;
		this.desc = desc;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
