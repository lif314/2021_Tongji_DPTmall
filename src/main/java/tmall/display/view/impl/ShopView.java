package tmall.display.view.impl;

import tmall.controller.impl.ActivityBuilder;
import tmall.controller.impl.ComFactory;
import tmall.controller.impl.CommodityFactory;
import tmall.controller.impl.ShopController;
import tmall.display.view.View;
import tmall.model.entity.Commodity;
import tmall.model.entity.Coupon;
import tmall.model.entity.Order;
import tmall.model.entity.Shop;
import tmall.model.entityDao.daoImpl.CommodityDaoImpl;
import tmall.model.entityDao.daoImpl.CouponDaoImpl;
import tmall.model.entityDao.daoImpl.OrderDaoImpl;
import tmall.model.entityDao.daoInterface.CommodityDao;
import tmall.model.entityDao.daoInterface.CouponDao;
import tmall.model.entityDao.daoInterface.OrderDao;
import tmall.tmallSystem.TMallSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShopView extends View {
    @Override
    public Object show(Object... args) {

        ShopController shopController = new ShopController();
        if (TMallSystem.getSeller() !=null) {
            String shopId = (String) TMallSystem.getAttribute().get("attribute");
            Shop currentShop = shopController.getShop(shopId);
            System.out.println("==========欢迎来到店铺 "+currentShop.getShopName()+" ==========");
            System.out.println("店铺简介: "+currentShop.getDescription());
//            System.out.println("return: "+ Arrays.toString(args));
//            System.out.println("已获得"+shopId);
            System.out.println();
            System.out.println("=========店铺商品列表========");
            List<Commodity> commodityList = (List<Commodity>) args[0];
            Integer index1 = 1;
            for (Commodity commodity:commodityList) {
                System.out.print(index1.toString() +'、');
                System.out.println(commodity.getCname());
                System.out.println("分类: "+ commodity.getCategory());
                System.out.println("价格: "+ commodity.getPrice());
                System.out.println("库存: "+ commodity.getStoreNum());
                System.out.println("简介: "+ commodity.getDescription());
                index1++;
            }
            System.out.println("=========店铺订单列表========");
            // 注：llf尚未实现这里的DAO接口,实现后即可恢复下面几行代码
//            List<Order> orderList = (List<Order>) args[2];
//            Integer index2 = 1;
//            for (Order order:orderList) {
//                System.out.print(index2.toString() +'、');
//                System.out.println("订单编号: "+order.getOrderId());
//                System.out.println("订单状态: "+ order.getStatus());
//                System.out.println("订单创建时间: "+order.getCreateTime());
//                index2++;
//            }
            System.out.println("=========店铺优惠券列表========");
            List<Coupon> couponList = (List<Coupon>) args[1];
            Integer index3 = 1;
            for (Coupon coupon:couponList) {
                System.out.print(index3.toString() +'、');
                System.out.println(coupon.getStartTime()+" to "+coupon.getEndTime()+ " 满"+ coupon.getFull()+"减"+coupon.getMinus());
                index3++;
            }
            /*
             * 定义店铺内操作
             */
            while(true){
                System.out.println("\n=======请选择您想进行的操作========\n1.上架商品\n2.发布优惠券\n3.发货\n4.下架商品\n5.删除优惠券\n6.退出店铺");
                Scanner cmd = new Scanner(System.in);
                String str = cmd.next();
                if(Objects.equals(str, "1")){
                    System.out.println("请输入待上架的商品信息（名称、类别、价格、库存、描述，空格分隔）：");
                    ComFactory comFactory = new ComFactory(shopId);
                    Scanner info = new Scanner(System.in);
                    String cname = info.next();
                    String category = info.next();
                    String price = info.next();
                    String storeNum = info.next();
                    String description = info.next();
                    String tips = comFactory.add(cname, category, price, storeNum, description);
                    System.out.println(tips);
                }else if(Objects.equals(str, "2")){
                    System.out.println("请输入待发布的优惠券信息：（开始时间、截止时间、使用条件、减免金额，空格分隔）");
                    Scanner info = new Scanner(System.in);
                    String startTime = info.next();
                    String endTime = info.next();
                    String full = info.next();
                    String minus = info.next();
                    ActivityBuilder activityBuilder = new ActivityBuilder(shopId);
                    activityBuilder.addCoupon(startTime, endTime, full, minus);
                    System.out.println("优惠券发布成功！");
                }else if(Objects.equals(str, "3")){
                    System.out.println("请输入要发货的订单id：");
                    Scanner id = new Scanner(System.in);
                    String ID = id.next();
                    OrderDao orderDao = new OrderDaoImpl();
                    List<Order> orders = orderDao.getAllByShopId(shopId);
                    for(Order order : orders){
                        if(order.getOrderId().equals(ID)){
                            shopController.shipOrder(ID);
                            System.out.println("订单发货成功！");
                            break;
                        }
                    }
                    System.out.println("未找到该订单！");
                }else if(Objects.equals(str, "4")){
                    System.out.println("请输入要下架的商品id：");
                    Scanner id = new Scanner(System.in);
                    String ID = id.next();
                    CommodityDao commodityDao = new CommodityDaoImpl();
                    List<Commodity> commodities = commodityDao.getAllByShopId(shopId);
                    for(Commodity commodity:commodities){
                        if(commodity.getCommodityId().equals(ID)){
                            shopController.deleteCommodity(ID);
                            System.out.println("商品下架成功！");
                            break;
                        }
                    }
                    System.out.println("未找到该商品！");
                }else if(Objects.equals(str, "5")){
                    System.out.println("请输入要删除的优惠券id：");
                    Scanner id = new Scanner(System.in);
                    String ID = id.next();
                    CouponDao couponDao = new CouponDaoImpl();
                    List<Coupon> coupons = couponDao.getAllByShopId(shopId);
                    for(Coupon coupon:coupons){
                        if(coupon.getCouponId().equals(ID)){
                            shopController.deleteCoupon(ID);
                            System.out.println("优惠券删除成功！");
                            break;
                        }
                    }
                    System.out.println("未找到该优惠券！");
                }else if(Objects.equals(str, "6")){
                    System.out.println("您已安全离开店铺后台！");
                    break;
                }else{
                    System.out.println("请输入正确的命令！");
                }
            }
        } else if (TMallSystem.getBuyer()!=null){
            for (Object o:args){
                System.out.println(args);
            }
        }

        return null;
    }
}
