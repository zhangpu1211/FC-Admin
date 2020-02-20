package org.fcadmin.vo;

import lombok.Data;
import org.fcadmin.pojo.Menu;
import org.fcadmin.pojo.Meta;

import java.util.List;
@Data
public class MenuVO {
    private Integer id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Meta meta;
    private Integer parentId;
    private List<Menu> children;
}
