package com.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *  <img src="https://bkimg.cdn.bcebos.com/pic/060828381f30e9247408ecc146086e061c95f796?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U4MA==,g_7,xp_5,yp_5"/>
 *
 *
 * <img src="https://s1.ax1x.com/2020/09/29/0eUN8A.jpg"/>
 *  前序遍历: 一直输出左节点，当左节点为空时输出当前结点的右结点, 在输出当前结点的左节点
 * 中序遍历: 先找到左子树为空的节点
 * 后序遍历：
 DLR--前序遍历（根在前，从左往右，一棵树的根永远在左子树前面，左子树又永远在右子树前面 ）

 LDR--中序遍历（根在中，从左往右，一棵树的左子树永远在根前面，根永远在右子树前面）

 LRD--后序遍历（根在后，从左往右，一棵树的左子树永远在右子树前面，右子树永远在根前面）
 * @author mxz on 2020/09/29 16:56
 */
public class A07_ {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();
    // 中序遍历分左右子树

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 根据前序获取根节点
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length-1, 0);
    }

    /**
     * @param pre  前序array
     * @param preL 前序左
     * @param preR 前序右
     * @param inL  中序左
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        //根节点 分界点
        TreeNode root = new TreeNode(pre[preL]);
        // 获取根节点在中序中的位置
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL; //中序左 - 中序最左 = 左子树节点数
        //
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public Integer val;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }
}