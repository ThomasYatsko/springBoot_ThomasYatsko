package p3.jdbctemplate.dao;

 

import java.util.List;

 

import java.util.Optional;

 

import javax.transaction.Transactional;

 

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

 

 

import p3.jpa.model.Cat;

import p3.jpa.model.CatRowMapper;

 

@Repository

@Transactional

public class CatDAOImpl implements CatDAO 
{

      

       private static final Logger logger = LoggerFactory.getLogger(CatDAOImpl.class);

 

       @Autowired

       private JdbcTemplate jdbcTemplate;

      

       public List<Cat> findAll() 
       {

             String sql = "SELECT e.id, e.name, e.type FROM cats e";

             RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<Cat>(Cat.class);

 

             return jdbcTemplate.query(sql, rowMapper);

       }

 

       public Optional<Cat> findById(Long id) {

             Optional<Cat> oCat = Optional.ofNullable(null);

             String sql = "SELECT e.id, e.name, e.type FROM cats e WHERE e.id = ?";

             if (id != null) {

                    RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<Cat>(Cat.class);

 

                    Cat cats = jdbcTemplate.queryForObject(sql, rowMapper, id);

                    oCat = Optional.ofNullable(cats);

             } else {

                    logger.warn("findById unExpected null input, will do nothing, will return nulled Optional");             

             }

             return oCat;

       }

	public Optional<Cat> findByType(String type) 
	{
		 Optional<Cat> oCat = Optional.ofNullable(null);

         String sql = "SELECT e.id, e.name, e.type FROM cats e WHERE e.type = ?";

         if (type != null) 
         {

                RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<Cat>(Cat.class);



                Cat cats = jdbcTemplate.queryForObject(sql, rowMapper, type);

                oCat = Optional.ofNullable(cats);

         }
         else 
         {

                logger.warn("findByType unExpected null input, will do nothing, will return nulled Optional");             

         }
         return oCat;
	}

}

 
