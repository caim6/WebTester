package caim.study.jee.dao;

import caim.study.jee.entities.Test;

import java.util.List;

/**
 * Created by caim6 on 08.11.2015.
 */
public interface TestDao extends IEntityDao<Test> {

    List<Test> getTestList(Integer offset, Integer count);

    Long getAllTestsCount();
}
