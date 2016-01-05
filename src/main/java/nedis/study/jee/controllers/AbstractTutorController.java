package nedis.study.jee.controllers;

import nedis.study.jee.services.AdvancedTutorService;
import nedis.study.jee.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author nedis
 * @version 1.0
 */
public abstract class AbstractTutorController extends AbstractController {

	@Autowired
	protected TutorService tutorService;
	
	@Autowired
	protected AdvancedTutorService advancedTutorService;



}
