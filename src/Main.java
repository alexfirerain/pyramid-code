public class Main {
        static int[] TEST = { 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52 };


    public static void main(String[] args) {
        build(TEST);
    }

    /**
     * Fills a level-mask array up reflecting which level in a balanced binary tree
     * every single number in a given array would be at.
     * @param arr   a given array to be analyzed for the supposed tree structure.
     * @param left   a starting index of the array's segment to be analyzed.
     * @param right  an ending index of the array's segment to be analyzed.
     * @param level  a current level of the tree which the function is invoked on.
     * @param levels a target array to be filled up with levels' notations.
     */
    static void mark(int[] arr, int left, int right, int level, int[] levels) {
        if (left == right) {
            levels[left] = level;
            return;
        }
        int middle = (left + right) / 2;
        levels[middle] = level;
        mark(arr, left, middle - 1, level + 1, levels);
        mark(arr, middle + 1, right, level + 1, levels);
    }

    /**
     * Prints a tree-like representation of the given array out,
     * assuming it is a balanced binary-tree with 2^n - 1 elements.
     * @param arr an array to be analyzed for a tree-similarity and plotted.
     */
    static void build(int[] arr) {
        int[] levels = new int[arr.length];
        mark(arr, 0, arr.length - 1, 0, levels);
        StringBuilder plotter = new StringBuilder();

        int levelsTotal = (int) Math.ceil(Math.log(arr.length + 1) / Math.log(2));

        for (int level = 0; level < levelsTotal ; level++) {
            for (int i = 0; i < arr.length; i++)
                plotter.append(levels[i] == level ? arr[i] : "  ");
            plotter.append("\n");
        }
        System.out.println(plotter);
    }



}