package level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/68936
public class 쿼드압축후개수세기 {
    public int[] solution(int[][] arr) {
        return compress(arr);
    }

    static int[] compress(int[][] arr) {
        int[] result = new int[2];
        int value = arr[0][0];
        boolean isSame = false;
        for (int[] line : arr) {
            for (int v : line) {
                if (v != value) {
                    isSame = false;
                    break;
                }
                isSame = true;
            }
            if (!isSame) break;
        }
        if (isSame) {
            if (value == 0) {
                return new int[]{1, 0};
            } else {
                return new int[]{0, 1};
            }
        } else if (arr.length == 2) {
            int[] tmp = new int[2];
            tmp[arr[0][0]] += 1;
            tmp[arr[0][1]] += 1;
            tmp[arr[1][0]] += 1;
            tmp[arr[1][1]] += 1;
            return tmp;
        }

        int[] subResult;
        for (int[][] splitArr: split(arr)) {
            subResult = compress(splitArr);
            result[0] += subResult[0];
            result[1] += subResult[1];
        }

        return result;
    }

    static int[][][] split(int[][] arr) {
        int size = arr.length / 2;
        int[][][] splitArr = new int[4][size][size];

        int rowStart = 0;
        int colStart = 0;
        for (int c = 0; c < 4; c++) {
            switch (c) {
                case 0:
                    rowStart = 0;
                    colStart = 0;
                    break;
                case 1:
                    rowStart = size;
                    break;
                case 2:
                    rowStart = 0;
                    colStart = size;
                    break;
                case 3:
                    rowStart = size;
                    colStart = size;
                    break;
            }

            for (int i = rowStart; i < rowStart + size; i++) {
                System.arraycopy(arr[i], colStart, splitArr[c][i - rowStart], 0, size);
            }
        }

        return splitArr;
    }


    public static void main(String[] args) {
        int[][] size = new int[][]{
                {1,1,0,0},
                {1,0,0,0},
                {1,0,0,1},
                {1,1,1,1}};
//        int[][][] splitArr = split(size);
//        for (int[][] tmp: splitArr) {
//            System.out.println("tmp.toString() = " + Arrays.deepToString(tmp));
//        }
        int[] arr = compress(size);
        System.out.println(arr[0] + ", " + arr[1]);
    }
}
