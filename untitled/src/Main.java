import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Programm learning\\Neeeded Skills\\schedule4.pdf");
        File file = new File(path.toUri());
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];

        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();

            int arrayLength = 256;
            int[][] groupOfBytesAndCountsOfByte = new int[arrayLength][2];
            double allDataBytes=0;



            //Loop for filling counts
            for (int i = 0; i < bFile.length; i++) {
                groupOfBytesAndCountsOfByte[bFile[i] + 128][0] += 1;
            }

            // Loop for filling bytes position
            for (int i = 0; i < arrayLength; i++) {
                groupOfBytesAndCountsOfByte[i][1] = i;
            }

            //Loop for filling percent from all Data
//                for (int i = 0; i < arrayLength; i++) {
//                    groupOfBytesAndCountsOfByte[i][2]=
//                }

            // Sorting bytes by counts from bigger to smaller
            for (int i = 0; i < arrayLength; i++) {
                for (int j = 0; j < arrayLength; j++) {
                    if (groupOfBytesAndCountsOfByte[i][0] > groupOfBytesAndCountsOfByte[j][0]) {
                        int tempByteBuffer = groupOfBytesAndCountsOfByte[i][0];
                        groupOfBytesAndCountsOfByte[i][0] = groupOfBytesAndCountsOfByte[j][0];
                        groupOfBytesAndCountsOfByte[j][0] = tempByteBuffer;
                        int tempBytePosition = groupOfBytesAndCountsOfByte[i][1];
                        groupOfBytesAndCountsOfByte[i][1] = groupOfBytesAndCountsOfByte[j][1];
                        groupOfBytesAndCountsOfByte[j][1] = tempBytePosition;
                    }
                }
            }

            //Sorting by byte position(smaller byte must be up to bigger byte if counts are same)
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength; j++) {
                    if (groupOfBytesAndCountsOfByte[i][0] == groupOfBytesAndCountsOfByte[j][0]) {
                        System.out.println(groupOfBytesAndCountsOfByte[i][0] + " " + groupOfBytesAndCountsOfByte[j][0]);
                        if (groupOfBytesAndCountsOfByte[i][1] < groupOfBytesAndCountsOfByte[j][1]) {
                            int tempPositionBuffer = groupOfBytesAndCountsOfByte[i][1];
                            groupOfBytesAndCountsOfByte[i][1] = groupOfBytesAndCountsOfByte[j][1];
                            groupOfBytesAndCountsOfByte[j][1] = tempPositionBuffer;
                        }
                    }
                }
            }

            //Deprecated
            // Output bytes sorting by counts
//                for (int i = 0; i <groupOfBytesAndCountsOfByte.length ; i++) {
//                    if(groupOfBytesAndCountsOfByte[i][0] != 0){
//                        System.out.println("Bytes " + groupOfBytesAndCountsOfByte[i][1] + " seems " + groupOfBytesAndCountsOfByte[i][0]);
//                    }
//                }

            //Sum of all Data Bytes
            for (int i = 0; i < arrayLength; i++) {
                allDataBytes+=groupOfBytesAndCountsOfByte[i][0];
            }


            for (int i = 0; i < groupOfBytesAndCountsOfByte.length; i++) {
                if (groupOfBytesAndCountsOfByte[i][0] != 0) {
                    System.out.println(Integer.toHexString(groupOfBytesAndCountsOfByte[i][1]) + " " + groupOfBytesAndCountsOfByte[i][0] + " " + String.format("%.2f%%",(groupOfBytesAndCountsOfByte[i][0]/allDataBytes)*100));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}