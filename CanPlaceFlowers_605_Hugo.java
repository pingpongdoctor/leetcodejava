public class CanPlaceFlowers_605_Hugo {
    /*
    You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int k = n;
        int len = flowerbed.length;

        if (len == 1 && flowerbed[0] == 0){
            return true;
        }
        // int last_tree_index = 0;
        if (len > 1 && flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            k--;
        } 
        for (int i = 1; i< len - 1; i++){
            if (flowerbed[i] == 0){
                if (flowerbed[i-1] == 0 && flowerbed[i + 1] == 0){
                    flowerbed[i] = 1;
                    k--;
                    // System.out.println("i = " + i + " - k = " + k);
                }
            }
            if (k == 0){
                return true;
            }
        }

        if (len >= 3 && flowerbed[len - 2] == 0 && flowerbed[len-1]==0){
            k--;
        }
        return !(k > 0);
    }
}
