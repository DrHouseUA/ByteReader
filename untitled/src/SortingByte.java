public class SortingByte {

    public int bytePos;
    public int byteCounts;

    Integer[][] byteArr = new Integer[255][1];


    public int getBytePos() {
        return bytePos;
    }

    public void setBytePos(int bytePos) {
        this.bytePos = bytePos;
    }

    public int getByteCounts() {
        return byteCounts;
    }

    public void setByteCounts(int byteCounts) {
        this.byteCounts = byteCounts;
    }

    public int[] sortingByte(int[] arr){
        int bytePos;
        int byteCounts;
        int bytePosTemp;
        int byteCountsTemp;
        int[] arrpos =new int [arr.length];

        for (int i = 0; i < arr.length; i++) {

                for (int j = 0; j < arr.length; j++) {
                    if(arr[i]<arr[j]){
                        bytePos=i;
                        arrpos[j]=i;
                        byteCounts=arr[i];
                        arr[i]=arr[j];
                        arr[j]=byteCounts;

                }
            }

        }


        return arr;
    }

}
