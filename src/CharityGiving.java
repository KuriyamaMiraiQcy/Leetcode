import java.util.PriorityQueue;

public class CharityGiving {
    public String[] order(float[] money) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        queue.add(n1);
        queue.add(n2);
        queue.add(n3);

        String res[] = new String[money.length];

        for (int i = 0; i < money.length; i ++) {
            Node temp = queue.poll();
            temp.currentMoney += money[i];
            queue.add(temp);
            res[i] = temp.name;
        }

        return res;
    }

    class Node implements Comparable {
        String name;
        float currentMoney;

        Node(String name) {
            this.name = name;
            currentMoney = 0;
        }

        @Override
        public int compareTo(Object o) {
            if (this == o) {
                return 0;
            }

            Node temp = (Node)o;
            if (this.currentMoney < temp.currentMoney) {
                return -1;
            } else if (this.currentMoney > temp.currentMoney) {
                return 1;
            } else {
                return this.name.compareTo(temp.name);
            }
        }
    }

    public static void main(String[] args) {
        CharityGiving a = new CharityGiving();
        String[] c =a.order(new float[]{12.3f,20.5f,4.3f,5.66f,10f,23.65f,});
        for (String str:c) {
            System.out.print(str);
        }

        System.out.println();
        c =a.order(new float[]{12f,20f,4f,8f,8f,8f,3f});
        for (String str:c) {
            System.out.print(str);
        }
    }
}
