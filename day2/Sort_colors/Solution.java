class Solution {
    public void sortColors(int[] a) {
        for(int i=0,j=a.length-1,k=0;k<=j;)
        {
            if(a[k]==0)
            {
                int  temp=a[k];
                a[k]=a[i];
                a[i]=temp;
                i++;
                k++;
            }
            else if(a[k]==1)
            {
                k++;
            }
            else{
                int t=a[k];
                a[k]=a[j];
                a[j]=t;
                j--;
            }
        }
    }
}