package com.su.service;

import com.su.pojo.PageInfo;
import com.su.pojo.StudentClean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentCleanService {

    public PageInfo<StudentClean>  getStudentClean(@Param("s_studentid") Integer s_studentid, @Param("s_name") String s_name,
                                                   @Param("s_dormitoryid") Integer s_dormitoryid,
                                                   @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
    //添加
    public int addStudentClean(StudentClean studentClean);

    //根据id查看
    public StudentClean findStudentCleanbyid(Integer g_id);

    //编辑
    public int updateStudentClean(StudentClean studentClean);

    //删除
    public int  deleteStudentCleanbyid(Integer g_id);

    //查看全部
    public List<StudentClean> getAll();


}
