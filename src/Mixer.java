import java.util.*;

/**
 * Having given a list of elements, do all the possible permutations of those elements
 * by only using a stack and a queue.
 */
public class Mixer {

    private final Queue<Object> queue;
    private final Stack<Object> stack;

    public Mixer(List<Object> elementsToPermute) {
        queue = new LinkedList<>();
        stack = new Stack<>();
        queue.addAll(elementsToPermute);
    }

    /**
     * Show the current state of the queue, which is the currently obtained permutation.
     */
    private void showPermutation() {
        Object[] elements = queue.toArray();
        for (int i = 0; i < elements.length; i++) {
            if (i == elements.length - 1) System.out.println(elements[i]);
            else System.out.print(elements[i] + ", ");
        }
    }

    /**
     * Recursively permute all the group sizes the specified amount of times.
     * @param groupSize The group size to be permuted.
     * @param permutations How many times to permute the specified group.
     */
    private void permuteGroups(int groupSize, int permutations) {
        if (groupSize <= 0) return;
        permuteGroups(groupSize - 1, permutations + 1);
        for (int i = 0; i < permutations; i++) {
            permute(groupSize);
            permuteGroups(groupSize - 1, permutations + 1);
            showPermutation();
        }
    }

    /**
     * Create all the permutations of the given list in the frst place.
     */
    public void generatePermutations() {
        showPermutation();
        permuteGroups(queue.size() - 1, 1);
    }

    /**
     * With the help of the stack, permute the asked number of elements from the stack.
     * @param numbersToPermute The number of elements to be permuted from the stack.
     */
    private void permute(int numbersToPermute) {
        for (int i = 0; i < numbersToPermute; i++)
            stack.push(queue.remove());
        for (int i = 0; i < numbersToPermute; i++)
            queue.add(stack.pop());
    }

}
