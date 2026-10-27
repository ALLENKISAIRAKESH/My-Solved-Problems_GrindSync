class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // 🔥 use primitive array instead of Integer[] (avoid boxing)
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // custom quick sort (faster than Arrays.sort with comparator)
        quickSort(idx, positions, 0, n - 1);

        // 🔥 use int[] as stack (faster than Deque)
        int[] stack = new int[n];
        int top = -1;

        for (int id : idx) {
            if (directions.charAt(id) == 'R') {
                stack[++top] = id;
            } else {
                while (top >= 0 && healths[id] > 0) {
                    int j = stack[top];

                    if (healths[j] < healths[id]) {
                        healths[id]--;
                        healths[j] = 0;
                        top--;
                    } 
                    else if (healths[j] > healths[id]) {
                        healths[j]--;
                        healths[id] = 0;
                    } 
                    else {
                        healths[j] = 0;
                        healths[id] = 0;
                        top--;
                    }
                }
            }
        }

        // 🔥 pre-size result to avoid resizing
        List<Integer> res = new ArrayList<>(n);
        for (int h : healths) {
            if (h > 0) res.add(h);
        }

        return res;
    }

    // 🔥 custom quicksort (no comparator overhead)
    private void quickSort(int[] idx, int[] pos, int l, int r) {
        if (l >= r) return;

        int pivot = pos[idx[(l + r) >>> 1]];
        int i = l, j = r;

        while (i <= j) {
            while (pos[idx[i]] < pivot) i++;
            while (pos[idx[j]] > pivot) j--;

            if (i <= j) {
                int tmp = idx[i];
                idx[i] = idx[j];
                idx[j] = tmp;
                i++; j--;
            }
        }

        quickSort(idx, pos, l, j);
        quickSort(idx, pos, i, r);
    }
}