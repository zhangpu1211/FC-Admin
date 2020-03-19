package org.fcadmin.service;

import org.fcadmin.dto.output.SysUserListVO;
import org.fcadmin.mapper.SysLogMapper;
import org.fcadmin.pojo.SysLog;
import org.fcadmin.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogService {
    @Autowired
    SysLogMapper sysLogMapper;

    public RespPageBean getLogList(Integer page, Integer size, SysLog sysLog) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<SysUserListVO> data = sysLogMapper.getSysLogByPage(page, size, sysLog);
        Long total = sysLogMapper.getTotal(sysLog);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
}
