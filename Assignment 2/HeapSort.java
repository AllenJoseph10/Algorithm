import java.util.List;

public class HeapSort {
    public static int[] doHeapSort(int[] _arr) {
        heapSort(_arr);
        return _arr;
    }

    public static List<CosSimilarityPair> doHeapSort(List<CosSimilarityPair> _list) {
        //TODO Task 4.1
        heapSort(_list);
        return _list;
    }

    private static void heapSort(int[] _arr) {
        int n = _arr.length;

        for (int x = n / 2 - 1; x >= 0; x--)
            heapify(_arr, x, n);

        for (int y = n - 1; y > 0; y--) {
            int temp = _arr[0];
            _arr[0] = _arr[y];
            _arr[y] = temp;

            heapify(_arr, 0, y);
        }
    }

    private static void heapSort(List<CosSimilarityPair> _list) {
        //TODO Task 4.2
        int n = _list.size();
        for (int x = n/2 - 1; x >= 0; x--)
            heapify(_list, x ,n);

        for (int y = n -1; y > 0; y--) {
            CosSimilarityPair temp = _list.get(0);
            _list.set(0, _list.get(y));
            _list.set(y, temp);

            heapify(_list, 0, y);
        }
    }

    private static void heapify(int[] _tree, int _rootindex, int _n) {
        while (2 * _rootindex + 2 <= _n) {
            int rightChildIndex = 2 * _rootindex + 2;  //Index of the right child
            int leftChildIndex = 2 * _rootindex + 1;  //Index of the left child
            int smallest = leftChildIndex;

            if (rightChildIndex < _n && _tree[leftChildIndex] > _tree[rightChildIndex])
                smallest = rightChildIndex;
            if (_tree[_rootindex] <= _tree[smallest])
                break;

            //Swap the root with the largest node.
            int temp = _tree[_rootindex];
            _tree[_rootindex] = _tree[smallest];
            _tree[smallest] = temp;
            _rootindex = smallest;
        }
    }

    private static void heapify(List<CosSimilarityPair> _tree, int _rootindex, int _n) {
        //TODO Task 4.3
        while (2 * _rootindex + 2 <= _n) {
            int rightChildIndex = 2 * _rootindex + 2;
            int leftChildIndex = 2 * _rootindex + 1;
            int smallest = leftChildIndex;

            if (rightChildIndex < _n && _tree.get(leftChildIndex).getCosineSimilarity() > _tree.get(rightChildIndex).getCosineSimilarity())
                smallest = rightChildIndex;
            if (_tree.get(_rootindex).getCosineSimilarity() <= _tree.get(smallest).getCosineSimilarity())
                break;
            CosSimilarityPair temp = _tree.get(_rootindex);
            _tree.set(_rootindex, _tree.get(smallest));
            _tree.set(smallest, temp);
            _rootindex = smallest;
            }
        }
    }
