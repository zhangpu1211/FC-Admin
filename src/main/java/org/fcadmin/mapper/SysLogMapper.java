package org.fcadmin.mapper;

import org.apache.ibatis.annotations.Param;
import org.fcadmin.config.mapper.MyMapper;
import org.fcadmin.dto.output.SysUserListVO;
import org.fcadmin.pojo.SysLog;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.utils.RespPageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysLogMapper extends MyMapper<SysLog> {

    List<SysUserListVO> getSysLogByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("sysLog") SysLog sysLog);

    Long getTotal(@Param("sysLog")SysLog sysLog);
}