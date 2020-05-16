package p3.jpa.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Cat
{
	private Long id;
	
	private String name;
	private String type; 
	
	
	public Cat(String name, String type) 
	{
		super();
		this.setName(name);
		this.setType(type);
	}


}
