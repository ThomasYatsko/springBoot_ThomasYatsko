package p3.jdbctemplate.dao;

import java.util.List;
import java.util.Optional;

import p3.jpa.model.Cat;

public interface CatDAO extends JpaRepository<Cat, Long> 
{
//	public List<Cat> name(String name, String type);

	public Optional<Cat> findByType(String type);

//	Optional<Cat> findByld();
//
//	Optional<List<Cat>> findByType();
//
//	Optional<Cat> findById(Long id);
}