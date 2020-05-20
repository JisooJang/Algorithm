package programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
https://programmers.co.kr/learn/courses/30/lessons/42583
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다.
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0	[]	[]	[7,4,5,6]
1~2	[]	[7]	[4,5,6]
3	[7]	[4]	[5,6]
4	[7]	[4,5]	[6]
5	[7,4]	[5]	[6]
6~7	[7,4,5]	[6]	[]
8	[7,4,5,6]	[]	[]
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 */
public class TruckCrossingBridge {
    public static void main(String[] args) {
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(2, 10, truck_weights));
    }

    public static class BridgeQueue {
        int maxWeight = 0;
        int size = 0;
        Queue<Integer> elements = new LinkedList<>();
        int totalWeight = 0;
        int time = 0;

        BridgeQueue(int size, int maxWeight) {
            this.size = size;
            this.maxWeight = maxWeight;
        }

        boolean push(int element) {
            // 큐가 비어있을 때
            this.time++;
            // 사이즈 체크
            if(elements.size() < this.size)  {
                // 무게 체크
                if((element + totalWeight) <= this.maxWeight) {
                    this.elements.add(element);
                    this.totalWeight += element;
                } else {
                    this.elements.add(0);
                    return false;
                }
            } else {
                // element 사이즈가 maxSize에 도달한 경우
                int weight = this.elements.remove();
                this.totalWeight -= weight;
                if((element + totalWeight) <= this.maxWeight) {
                    this.elements.add(element);
                    this.totalWeight += element;
                    return true;
                } else {
                    this.elements.add(0);
                    return false;
                }
            }
            return true;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int lastCount = 0;
        BridgeQueue queue = new BridgeQueue(bridge_length, weight);
        for(int i=0 ; i<truck_weights.length ; i++) {
            while(true) {
                if (queue.push(truck_weights[i])) break;
            }
        }
        return queue.time + bridge_length;
        // bridge_length를 더하는 이유는, 마지막 원소는 1번만 돌고 바로 true를 얻어와 내부 while문을 빠져나오기 때문.
        // 따라서 마지막 원소가 다리를 모두 건널때까지, bridge_length 값을 더해줘야함.
    }
}
