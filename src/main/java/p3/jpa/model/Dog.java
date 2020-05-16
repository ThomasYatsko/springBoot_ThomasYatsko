package p3.jpa.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dogs")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dog implements Serializable
{
	
	private static final long serialVersionUID = 3475699357687802015L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String type;
	
	
	public Dog(String name, String type) 
	{
		super();
		this.setName(name);
		this.setType(type);
	}

	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Long getId() 
	{
		return id;
	}


	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

}
