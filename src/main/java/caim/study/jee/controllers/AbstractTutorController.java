package caim.study.jee.controllers;

import caim.study.jee.services.AdvancedTutorService;
import caim.study.jee.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractTutorController extends AbstractController {

	@Autowired
	protected TutorService tutorService;
	
	@Autowired
	protected AdvancedTutorService advancedTutorService;



}
