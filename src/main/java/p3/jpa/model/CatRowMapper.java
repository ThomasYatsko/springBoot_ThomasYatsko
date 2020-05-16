package p3.jpa.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CatRowMapper implements RowMapper<Cat>
{

	@Override
	public Cat mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Cat cat = new Cat();
		cat.setId(rs.getLong("id"));
		cat.setName(rs.getString("name"));
		return cat;
	}

}
