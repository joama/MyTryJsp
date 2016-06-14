package chp04;

/**
 * Apple entity. @author MyEclipse Persistence Tools
 */

public class Apple implements java.io.Serializable {

	// Fields

	private String id;
	private String color;
	private float size;
	private float weight;

	// Constructors

	/** default constructor */
	public Apple() {

	}

	/** minimal constructor */
	public Apple(String id, String color) {
		this.id = id;
		this.color = color;
	}

	/** full constructor */
	public Apple(String id, String color, float size, float weight) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.weight = weight;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getSize() {
		return this.size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

}