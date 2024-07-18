package org.example.part02.ch12.code;

import java.util.Stack;

public class NodeEx {

    public static void main(String[] args) {
        Node<String> root = Node.of("1",
                Node.of("2",
                        Node.of("4",
                                Node.of("7"),
                                Node.of("8")),
                        Node.of("5")),
                Node.right("3",
                        Node.left("6",
                                Node.of("9"))));

        //traverseIterative(root);
        traverseRecursion(root);
    }

    static void traverseIterative(Node<String> root) {
        var temNodes = new Stack<Node<String>>(); // 반복의 현재 상태를 저장하기 위한 보조 변수
        var current = root;
        
        // 노드가 존재하지 않거나 nodeStack이 비어 있지 않을 때까지 반복
        while (!temNodes.isEmpty() || current != null) { // 가장 깊은 부분에 도달할 때까지 모든 노드를 저장
            if (current != null) {
                temNodes.push(current);
                current = current.left();
                continue;
            }

            // current == null을 만나면 temNodes에 저장된 마지막 노드를 current 로 설정
            current = temNodes.pop();

            // 노드 값 출력
            System.out.print(current.value());

            // 오른쪽 자식 노드로 이 과정을 반복한다.
            current = current.right();
        }
    }

    static void traverseRecursion(Node<String> node) {
        // 남아있는 노드가 없을 때 트리 순회를 중단하는 기본 조건
        if (node == null) {
            return;
        }

        // 왼쪽 자식 노드를 재귀적을 순회
        // 왼쪽 노드가 존재하는 한 계속해서 traverseRecursion 호출 
        traverseRecursion(node.left());

        // 왼쪽 자식 노드가 없다면 현재 노드의 값을 출력
        System.out.print(node.value());

        // 같은 방식으로 오른쪽 자식 노드 순회
        traverseRecursion(node.right());
    }
}
