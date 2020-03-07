package org.fcadmin.mapper;

import org.apache.ibatis.annotations.Param;
import org.fcadmin.config.mapper.MyMapper;
import org.fcadmin.dto.output.SysUserListVO;
import org.fcadmin.dto.output.SysUserVO;
import org.fcadmin.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper extends MyMapper<SysUser> {
    List<SysUserListVO> getSysUserByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("sysUser") SysUser sysUser);

    Long getTotal(@Param("sysUser") SysUser sysUser);
}