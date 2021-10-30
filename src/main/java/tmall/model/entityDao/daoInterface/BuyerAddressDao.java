package tmall.model.entityDao.daoInterface;

import tmall.model.entity.BuyerAddress;

import java.util.List;

public interface BuyerAddressDao {

    BuyerAddress getById(String buyerAddressId);

    List<BuyerAddress> getBuyerAddresses(String buyerId);
}
