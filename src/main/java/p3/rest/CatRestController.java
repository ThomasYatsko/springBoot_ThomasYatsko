package p3.rest;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import p3.jdbctemplate.dao.CatDAO;
import p3.jpa.model.Cat;
import p3.jpa.model.Dog;

@RestController
@RequestMapping(path = "/rest/v1/cats")
public class CatRestController 
{
	private static final Logger logger = LoggerFactory.getLogger(DogRestController.class);
	
	@Autowired
	private CatDAO catDAO;
	
	@RequestMapping(value="/echoMessage", method=RequestMethod.GET)
	
	public String echoMessage(@RequestParam(value="msg", defaultValue="Hello Tom") String message) 
	{
		logger.debug("echoMessage with message:{}", message);
		return "echoMessage echoed: " + message;
	}
	
	@ApiOperation(value = "To test this REST end point is alive via echo",
			  notes = "An optional message value can be passed into this echo service, via msg query param, to use in echoed String",
			  response = String.class)
public String echoMessage1(@ApiParam(value = "optional message value to pass", required = false) @RequestParam(value="msg", defaultValue="Hello ilker") String message) {
// NOTE ilker below is without optional swagger api param info. Above is equivalent to below enhanced with swagger param info
//public String echoMessage(@RequestParam(value="msg", defaultValue="Hello ilker") String message) {
	logger.debug("echoMessage with message:{}", message);
	return "echoMessage echoed: " + message;
}

	@GetMapping("/all")
	public List<Cat> findAll()
	{
		List<Cat> cats = catDAO.findAll();
		return cats;
	}
	
	@GetMapping({"/findById/{id}"})
	public Optional<Cat> findById(@PathVariable Long id)
	{
		Optional<Cat> cat = catDAO.findById(id);
		return cat;
	}
	
	@GetMapping({"/findByType/{type}"})
	public  Optional<Cat> findByType(@PathVariable String type) {
		Optional<Cat> cats = catDAO.findByType(type);
		return cats;
	}
	
}
