package compulsory5;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Article.class, name = "Article"),
        @JsonSubTypes.Type(value = Book.class, name = "Book")
})

public abstract class Item {
	
	private String id;
	private String title;
	private String location; // file name or Web page

	private Map<String, Object> tags = new HashMap<>();
	
	public Item()
	{
		
	}
	
	public Item(String id, String title, String location)
	{
		this.id=id;
		this.title=title;
		this.location=location;
	}

	public void addTag(String key, Object obj) {
		tags.put(key, obj);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
