package com.se.listener;


import com.se.bean.BookType;
import com.se.bean.UserType;
import com.se.service.IBookTypeService;
import com.se.service.IUserTypeService;
import com.se.service.impl.BookTypeServiceImpl;
import com.se.service.impl.UserTypeServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author 赵越超
 * @version 1.0
 * @title: ProductTypeListener
 * @projectName XiaoMi_SXND
 * @description:
 * @date 2020/1/6   9:24
 */
@WebListener
public class TypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //取出所有商品类型，并且放入全局作用域中，供项目在任何地方使用商品类型集合
        //监听器无法使用spring的依赖注入
        IBookTypeService bookTypeService=new BookTypeServiceImpl();
        List<BookType> list1=bookTypeService.findAllBookTypes();
        servletContextEvent.getServletContext().setAttribute("bookTypeLists",list1);
        
        //学生老师全局
        IUserTypeService userTypeService=new UserTypeServiceImpl();
        List<UserType> list2=userTypeService.findAllUserTypes();
        servletContextEvent.getServletContext().setAttribute("userTypeLists",list2);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
