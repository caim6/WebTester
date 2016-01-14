package caim.study.jee.dao;

import caim.study.jee.entities.Test;

import java.util.List;


public interface TestDao extends IEntityDao<Test> {

    List<Test> getTestList(Integer offset, Integer count);

    Long getAllTestsCount();
}
