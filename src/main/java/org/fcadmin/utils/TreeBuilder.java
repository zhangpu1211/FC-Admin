package org.fcadmin.utils;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Lists;
import org.fcadmin.dto.output.SideBarMenuVO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeBuilder {

    public static List<SideBarMenuVO> buildMenuTree(List<SideBarMenuVO> allNodes) {
        // 根节点
        List<SideBarMenuVO> root = Lists.newArrayList();
        allNodes.forEach(node -> {
            if (Integer.valueOf( node.getParentId() ) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findMenuChildren(node, allNodes);
        });
        if(CollUtil.isNotEmpty(root)){
            //对根节点排序
            List<SideBarMenuVO> sortedList = root.stream().sorted( Comparator.comparing( SideBarMenuVO::getSort ).reversed() ).collect( Collectors.toList());
            //先清空，在添加
            root.clear();
            root.addAll( sortedList );
        }
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static SideBarMenuVO findMenuChildren(SideBarMenuVO treeNode, List<SideBarMenuVO> treeNodes) {
        for (SideBarMenuVO it : treeNodes) {
            if (String.valueOf( treeNode.getId() ).equals(it.getParentId())) {
                if(CollUtil.isEmpty(treeNode.getChildren())){
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findMenuChildren(it, treeNodes));
            }
        }
        //对子节点排序
        if(CollUtil.isNotEmpty(treeNode.getChildren())){
            Stream<SideBarMenuVO> sorted = treeNode.getChildren().stream().sorted(Comparator.comparing(SideBarMenuVO::getSort).reversed());
            List<SideBarMenuVO> childrenSorted = sorted.collect( Collectors.toList());
            //先清空，在添加
            treeNode.getChildren().clear();
            treeNode.getChildren().addAll( childrenSorted );
        }
        return treeNode;
    }
}
