class Solution {
    public void nextPermutation(int[] a) {
        int n=a.length;
        int index=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(a[i]<a[i+1])
            {
                index=i;
                break;
            }
        }
                if(index == -1) {
            reverse(a, 0, n - 1);
            return;
        }
            for(int i=n-1;i>=index;i--)
            {
                if(a[i]>a[index])
                {
                    int temp=a[i];
                    a[i]=a[index];
                    a[index]=temp;
                    break;
                }
            }
        reverse(a, index + 1, n - 1);
    }
           private void reverse(int[] a, int left, int right) {
        while(left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
                 
}