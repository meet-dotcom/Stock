package com.ming.stock;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ming.stock.mapper.SysUserMapper;
import com.ming.stock.pojo.entity.SysUser;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestPageHelper {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    public void test01(){
        Integer page=2;
        Integer pagesixe=5;
        PageHelper.startPage(page,pagesixe);
        List<SysUser> all=sysUserMapper.findAll();
        //将查询到的page对象封装到PageInfo下就可以
        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(all);
        //获取分页的详细信息
        int pageNum = sysUserPageInfo.getPageNum();//获取当前页面
        int pages= sysUserPageInfo.getPageSize();//每一页的代下
        long total = sysUserPageInfo.getTotal();//总的记录数
        List<SysUser> list = sysUserPageInfo.getList();//当前页的具体内容
        int size = sysUserPageInfo.getSize();//当前页面的记录数
        System.out.println(all);
    }
}