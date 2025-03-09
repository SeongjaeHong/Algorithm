package level2;

import java.util.LinkedList;

// https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class 전력망을둘로나누기 {
    static class Node {
        int data;
        Node parent;
        LinkedList<Node> children = new LinkedList<>();
        int cntDescendant;

        Node(int data) {
            this.data = data;
        }

        boolean equals(int data) {
            return this.data != data;
        }
    }

    public int solution(int n, int[][] wires) {
        Node tree = makeTree(n, wires);
        int diff = tree.cntDescendant - tree.children.getFirst().cntDescendant * 2 - 1;
        if (diff < 0) {
            diff *= -1;
        }
        int answer = getDiff(diff, tree.children.getFirst(), tree);

        return answer;
    }

    int getDiff(int minDiff, Node tree, Node root) {
        System.out.println("minDiff = " + minDiff);
        int diff;
        for (Node node: tree.children) {
            diff = root.cntDescendant - node.cntDescendant * 2 - 1;
            if (diff == 0) {
                return 0;
            }

            if (diff < 0) {
                diff *= -1;
            }
            System.out.println("curDiff: " + diff + " (" + "Node: " + node.data + ")");

            if (diff < minDiff) {
                minDiff = diff;
            }

            diff = getDiff(minDiff, node, root);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    Node makeTree(int n, int[][] wires) {
        Node root = new Node(wires[0][0]);
        Node parent;
        Node child;
        child = new Node(wires[0][1]);
        child.parent = root;
        root.children.add(child);
        root.cntDescendant += 1;

        for (int i=1; i < n; i++) {
            Node parentNode = findParentNode(root, wires[i]);
            if (parentNode.equals(wires[i][0])) {
                child = new Node(wires[i][0]);
            } else {
                child = new Node(wires[i][1]);
            }
            child.parent = parentNode;
            parentNode.children.add(child);

            // 부모별 전체 자식 노드 개수 증가
            parentNode.cntDescendant += 1;
            parent = parentNode.parent;
            while (parent != root) {
                parent.cntDescendant += 1;
                parent = parent.parent;
            }
            root.cntDescendant += 1;
        }

        return root;
    }

    Node findParentNode(Node node, int[] data) {
        if (node.equals(data[0]) && node.equals(data[1])) {
            if (node.children.isEmpty()) {
                return null;
            }

            Node parentNode;
            for (Node child: node.children) {
                parentNode = findParentNode(child, data);
                if (parentNode != null) {
                    return parentNode;
                }
            }
        }

        return node;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int[][] arr2 = new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        int[][] arr3 = new int[][]{{1,2},{2,3},{3,4}};
        int[][] arr4 = new int[][]{{1,2}, {2,3}};
        전력망을둘로나누기 cls = new 전력망을둘로나누기();

        int[][] arr = arr1;
        Node tree = cls.makeTree(arr.length, arr);
//        printNode(tree);
        int diff = cls.solution(arr.length, arr);
        System.out.println("Solution = " + diff);
    }

    static void printNode(Node tree) {
        StringBuilder sb = new StringBuilder();
        sb.append(tree.data).append(": [");

        if (tree.children.isEmpty()) {
            return;
        }

        for (int i=0; i<tree.children.size()-1; i++) {
            sb.append(tree.children.get(i).data);
            sb.append("(").append(tree.children.get(i).cntDescendant).append(")");
            sb.append(", ");
        }
        sb.append(tree.children.getLast().data);
        sb.append("(").append(tree.children.getLast().cntDescendant).append(")");
        sb.append("]");
        System.out.println(sb);

        for (Node child: tree.children) {
            printNode(child);
        }
    }
}
