package com.kong.qingwei.mapper;

import com.kong.qingwei.bean.MyLog;
import com.kong.qingwei.bean.MyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyLogMapper {
    int countByExample(MyLogExample example);

    int deleteByExample(MyLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(MyLog record);

    int insertSelective(MyLog record);

    List<MyLog> selectByExample(MyLogExample example);

    MyLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MyLog record, @Param("example") MyLogExample example);

    int updateByExample(@Param("record") MyLog record, @Param("example") MyLogExample example);

    int updateByPrimaryKeySelective(MyLog record);

    int updateByPrimaryKey(MyLog record);
}