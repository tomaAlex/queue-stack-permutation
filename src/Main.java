import java.util.Arrays;

/**
 * Test the Mixer does in fact generate all the possible correct permutations
 * of a given list of elements to permute.
 */
public class Main {

    public static void main(String[] args) {
        Integer[] elementsToPermute = new Integer[] { 1, 2, 3, 4 };
        Mixer mixer = new Mixer(Arrays.asList(elementsToPermute));
        mixer.generatePermutations();
    }

}
