package tmall.XMLRepository;



import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import tmall.XMLRepository.util.Assert;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public interface XMLContext<T> {

    /**
     * 数据存储
     *
     * @param entity 实例类
     */
    void save(T... entity);


    /**
     * 解析XML文件：通过XML文件创建实例
     *
     * @param entity 传入类，eg:User.class
     * @return 返回该类的实例对象
     */
    List<T> init(Class<T> entity);

    /**
     * 根据ID删除XML数据库中的数据
     *
     * @param id 需要删除元素的id
     */
    void deleteById(String id);

    /**
     * 根据ID寻找对象
     *
     * @param id 元素ID
     * @return 返回相同ID组成的对象
     */
    T findById(String id);


    /**
     * 数据更新
     * @param oldValue 旧值
     * @param newValue 新值
     * @return 返回对象
     */
    T updateById(String oldValue, String newValue);

}
