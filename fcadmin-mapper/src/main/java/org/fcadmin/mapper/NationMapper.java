package org.fcadmin.mapper;

import org.fcadmin.pojo.Nation;
import org.springframework.stereotype.Repository;

@Repository
public interface NationMapper extends tk.mybatis.mapper.common.Mapper<Nation>, tk.mybatis.mapper.common.MySqlMapper<Nation> {
}