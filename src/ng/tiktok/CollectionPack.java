package ng.tiktok;

import java.util.Arrays;

public class CollectionPack {
     int minimumCards(int[] cardTypes){
         int n = cardTypes.length;
         int max = cardTypes[0];
         for (int num : cardTypes){
             max = Math.max(num,max);
         }
         int min = Integer.MAX_VALUE;
         for (int i = 2 ; i<n ; i++){
             int sum = 0;
             for (int j = 0;j<n;j++){
                 sum+=cardTypes[j]%i;
             }
             min = Math.min(min,sum);
         }
         return min;
     }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 计算多个数的最大公约数
    public static int gcdArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static int cardPackets(int[] cardTypes) {
        int totalCards = Arrays.stream(cardTypes).sum();
        int minAdditionalCards = Integer.MAX_VALUE;

        // 从2包开始到最大可能的包数(总卡片数量的一半)进行尝试
        for (int k = 2; k <= totalCards / 2; k++) {
            if (totalCards % k == 0) { // 只有在k能均分所有卡片的情况下才进行进一步的检查
                int additionalCards = 0;
                int targetPerPack = totalCards / k;

                for (int count : cardTypes) {
                    int remainder = count % targetPerPack;
                    if (remainder != 0) {
                        additionalCards += targetPerPack - remainder;
                    }
                }

                minAdditionalCards = Math.min(minAdditionalCards, additionalCards);
            }
        }

        return minAdditionalCards;
    }
    public static void main(String[] args) {
        CollectionPack collectionPack = new CollectionPack();
        int[] arr = {4, 7, 5, 11, 15};
        System.out.println(collectionPack.cardPackets(arr));
    }
}
