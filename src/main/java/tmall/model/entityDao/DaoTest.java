package tmall.model.entityDao;

import tmall.model.entity.Commodity;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;

import java.util.List;

public class DaoTest {
    public static void main(String[] args) {

        CommodityDao commodityDao = new CommodityDaoImpl();

        Commodity commodity = commodityDao.create("1212", "11231", "1212", "12132", "2321", "12123");
        commodityDao.addToDb();

        List<Commodity> all = commodityDao.getAll();
        for (Commodity commodity1 : all) {
            System.out.println(commodity1);
        }

//        commodityDao.deleteById(commodity.getCommodityId());
    }
}
