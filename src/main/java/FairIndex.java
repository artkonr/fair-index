import java.util.*;

public class FairIndex {

    public static int countFairIndices(int[] a, int[] b) {
        List<Container> sums = new ArrayList<>();

        // insert first
        Container first = new Container(a[0], b[0]);
        sums.add(first);

        for (int i = 1; i < a.length; i++) {
            Container prev = sums.get(i - 1);
            Container curr = new Container(
                    prev.aSum + a[i],
                    prev.bSum + b[i]
            );
            sums.add(i, curr);
        }

        Container last = sums.get(sums.size() - 1);

        int count = 0;
        for (int i = 0; i < sums.size() - 1; i++) {
            Container curr = sums.get(i);
            boolean leftEqual = curr.aSum == curr.bSum;
            if (!leftEqual) {
                continue;
            }

            long aRight = last.aSum - curr.aSum;
            long bRight = last.bSum - curr.bSum;

            boolean rightEqual = aRight == bRight;
            if (!rightEqual) {
                continue;
            }

            boolean sidesEqual = curr.aSum == aRight;
            if (!sidesEqual) {
                continue;
            }

            count++;
        }

        return count;
    }

    private record Container(long aSum, long bSum) { }

}
