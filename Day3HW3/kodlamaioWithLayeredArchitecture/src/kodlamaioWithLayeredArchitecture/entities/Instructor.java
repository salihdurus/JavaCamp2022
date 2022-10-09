package kodlamaioWithLayeredArchitecture.entities;

public class Instructor extends User{
	private String description;
	private String pictureUrl;

	public Instructor() {
		super();
	}

	public Instructor(int id, String firstName, String lastName, String description, String pictureUrl) {
		super(id,firstName,lastName);
		this.description = description;
		this.pictureUrl = pictureUrl;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}
