package tmall.controller.impl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Activity;
import tmall.model.entity.Commodity;
import tmall.model.entityDao.daoImpl.ActivityDaoImpl;
import tmall.model.entityDao.daoInterface.ActivityDao;

import java.util.List;

public class ActivityController {

    private final XMLContext<Commodity> context = new ProxyXmlContext<>(Commodity.class);

    /**
     * @author Strange
     * @date: 2021/10/27 8:53
     * @description: 活动展示
     * @param:
     * @return:
     */
    public Object[] activityDisplay() {

        ActivityDao activityDao = new ActivityDaoImpl();
        List<Activity> activityList = activityDao.getAll();

        return activityList.toArray();
    }

}
