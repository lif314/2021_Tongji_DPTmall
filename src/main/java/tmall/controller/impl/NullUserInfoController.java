package tmall.controller.impl;

import tmall.controller.Interface.UserInfoController;

/**
 * UserInfoController的空对象
 */
public class NullUserInfoController implements UserInfoController {
    @Override
    public Object getInfo(String ID) {
        return null;
    }

    @Override
    public Boolean editInfo(String ID) {
        return null;
    }
}
