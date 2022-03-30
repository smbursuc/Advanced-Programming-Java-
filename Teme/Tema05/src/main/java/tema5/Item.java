package tema5;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Article.class, name = "Article"),
        @JsonSubTypes.Type(value = Book.class, name = "Book")
})

public abstract class Item {
	
	private String identifier;
	private String location;
	private String title;
	
	
	public Item()
	{
		
	}
	
	public Item(String identifier, String title, String location)
	{
		this.identifier=identifier;
		this.title=title;
		this.location=location;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
		
	

}
