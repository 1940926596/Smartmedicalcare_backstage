package com.example.aerial;

import java.util.HashMap;
import java.util.Map;

public class test {
    int aa = 1;

    Boolean a;
    public void setAa(int aa) {
        this.aa = aa;
    }

    public static void main(String[] args) {


        Integer i = new Integer(1000);
        Integer j = i;
        System.out.println(i.hashCode() == j.hashCode());
        j = 2000;
        System.out.println(j);
        System.out.println(i);

        test test1 = new test();


        ThreadDemo threadDemo = new ThreadDemo();

        threadDemo.run();

    }

    int changeInt(String a) {

        return 0;
    }

    int changeInt1(int a) {
        a = 1004;
        return 0;
    }
}

class ThreadDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable 方法调用");
    }
}

class UnionFind {
    // 记录每个节点的父节点
    private Map<Integer, Integer> parent;
    // 记录节点所在连通分量的节点个数
    private Map<Integer, Integer> count;

    public UnionFind(int[] nums) {
        parent = new HashMap<>();
        count = new HashMap<>();
        // 初始化父节点为自身
        for (int num : nums) {
            parent.put(num, num);
            count.put(num, 1);
        }
    }

    // 寻找x的父节点，实际上也就是x的最远连续右边界
    public Integer find(int x) {
        if (!parent.containsKey(x)) {
            return null;
        }
        // 遍历找到x的父节点
        while (x != parent.get(x)) {
            // 进行路径压缩
            parent.put(x, parent.get(parent.get(x)));
            x = parent.get(x);
        }
        return x;
    }

    // 合并两个连通分量，用来将num并入到num+1的连续区间中
    // 返回值为x所在连通分量的节点个数
    public int union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return count.get(rootX);
        }
        parent.put(rootX, rootY);
        // 更新该根结点连通分量的节点个数
        count.put(rootY, count.get(rootX) + count.get(rootY));
        return count.get(rootY);
    }
}
class Solution {

    public int longestConsecutive(int[] nums) {
        // 去除nums为空的特例
        if (nums == null || nums.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(nums);
        int ans = 1;
        // 一次遍历即可
        for (int num : nums) {
            if (uf.find(num + 1) != null) {
                // union会返回num所在连通分量的节点个数
                ans = Math.max(ans, uf.union(num, num + 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}