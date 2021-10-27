package tmall.model.entityDao.daoImpl;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Activity;
import tmall.model.entityDao.daoInterface.ActivityDao;

import java.util.List;
import java.util.UUID;

public class ActivityDaoImpl implements ActivityDao {

    private final XMLContext<Activity> activityXMLContext = new ProxyXmlContext<>(Activity.class);

    private Activity activity;

    /**
     * 发布活动
     *
     * @param startTime    开始时间
     * @param endTime      结束时间
     * @param activityName 活动名称
     * @param discount     折扣
     * @return an Activity
     */
    @Override
    public Activity create(String startTime, String endTime, String activityName, String discount) {
        String activityId = UUID.randomUUID().toString();
        activity = new Activity(activityId, startTime, endTime, activityName, discount);
        return activity;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        activityXMLContext.add(activity);
    }

    /**
     * 获取活动详情
     *
     * @param activityId 活动id
     * @return an activity
     */
    @Override
    public Activity getById(String activityId) {
        return activityXMLContext.findById(activityId);
    }

    /**
     * 获取所有活动
     *
     * @return list activity
     */
    @Override
    public List<Activity> getAll() {
        return activityXMLContext .init();
    }
}
