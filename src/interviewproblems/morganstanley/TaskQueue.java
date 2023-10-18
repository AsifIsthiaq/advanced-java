package interviewproblems.morganstanley;

import java.util.ArrayList;
import java.util.List;

/**
 * Task queues, which allow for asynchronou performance,
 * are an important part of modern processing architectures.
 * Information about a system consisting of several batch processing queues is given.
 * Each queue has three parameters:
 * 1. the maximum number of tasks it can process in a single batch
 * 2. the time it takes to process a single batch of tasks in that queue
 * 3. the number of tasks the queue must process
 * Given this Information, calculate the minimum time needed to process a set of tasks by the systern.
 * Example
 * n=2
 * batchSize = [4,3]
 * processing Time = [6,5]
 * numTasks=[8, 8]
 * Queue 0 can process a maximum of 4 tasks
 * output:15
 * My Explanation:
 * 2 ta queue ase concorently run korbe
 * ami each set of task ke akta kore queue te dia dibo
 * je queue ta execute korte sob theke beshi time lagbe setai ans
 * cause baki queue gula agei kaj sesh kore bose thkbe jeta last e sesh hobe setar theke
 * jehetu sob kaj sesh hote hobe we need to wait for last\late queue to finish executing
 * and returns its execution time as result.
 */
public class TaskQueue {
    public static long minTime(List<Integer> batchSize, List<Integer> processingTime, List<Integer> numTasks) {
        long maxTime = Long.MIN_VALUE;
        int queueSize = batchSize.size();
        for(int i=0;i<queueSize;i++){
            int t = numTasks.get(i) % batchSize.get(i);
            // suppose 19 ta task batch 3 taile minium 6 iteration to lagbei taile 18 task complete but r akta baki
            // thkbe tai aro akbar batch cholbe total 7 iteration time7*5 =35
            int temp = (numTasks.get(i) / batchSize.get(i)) + (t==0 ? 0:1);
            maxTime = Math.max(maxTime, (long)processingTime.get(i)*temp);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        List<Integer> batchSize = new ArrayList<Integer>() {{
            add(4);
            add(3);
        }};
        List<Integer> processingTime = new ArrayList<Integer>() {{
            add(6);
            add(5);
        }};
        List<Integer> numTasks = new ArrayList<Integer>() {{
            add(8);
            add(8);
        }};
        long result = minTime(batchSize, processingTime, numTasks);
        System.out.println("Test Case 1: " + result);

        List<Integer> batchSize2 = new ArrayList<Integer>() {{
            add(4);
            add(3);
        }};
        List<Integer> processingTime2 = new ArrayList<Integer>() {{
            add(6);
            add(5);
        }};
        List<Integer> numTasks2 = new ArrayList<Integer>() {{
            add(8);
            add(19);
        }};
        long result2 = minTime(batchSize2, processingTime2, numTasks2);
        System.out.println("Test Case 2: " + result2);
    }

}

