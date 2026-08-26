class Solution { 
    public int[] threeEqualParts(int[] arr) { 
        int ones = 0; 
        for (int i : arr) if (i == 1) ones++; 

        if (ones == 0) return new int[]{0, 2}; 

        if (ones % 3 != 0) return new int[]{-1, -1}; 

        int point1 = 0, point2 = 0, point3 = 0; 
        int unit = ones / 3; 
        int oneCounter = 0; 

        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] == 1) { 
                if (oneCounter == 0) point1 = i; 
                else if (oneCounter == unit) point2 = i; 
                else if (oneCounter == 2 * unit) point3 = i; 

                oneCounter++; 
            } 
        } 

        while (point3 < arr.length) { 
            if (arr[point1] != arr[point2] || arr[point2] != arr[point3]) 
                return new int[]{-1, -1}; 

            point1++; 
            point2++; 
            point3++; 
        } 

        return new int[]{point1 - 1, point2}; 
    } 
}