package caim.study.jee.services.impl;

import caim.study.jee.entities.Test;
import caim.study.jee.dao.TestDao;
import caim.study.jee.services.AdvancedTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
@Service
public class AdvancedTutorServiceImpl implements AdvancedTutorService {
    @Autowired
    protected TestDao testDao;
    @Override
    public List<Test> getAllTests() {return  testDao.findAll();
    }

}
