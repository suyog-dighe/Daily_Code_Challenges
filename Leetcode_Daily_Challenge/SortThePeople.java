package Leetcode_Daily_Challenge;
import java.util.Map;
import java.util.TreeMap;

//Leetcode: https://leetcode.com/problems/sort-the-people/
// Question: 2418. Sort the People
public class SortThePeople {
        public String[] sortPeople(String[] names, int[] heights) {
            //  Integer[] indices = new Integer[names.length];
            // for (int i = 0; i < names.length; i++) {
            //     indices[i] = i;
            // }

            // Arrays.sort(indices, (i, j) -> Integer.compare(heights[j], heights[i]));

            // String[] sortedNames = new String[names.length];
            // for (int i = 0; i < names.length; i++) {
            //     sortedNames[i] = names[indices[i]];
            // }

            // return sortedNames;

        /*
        HashMap<Integer,String> map = new HashMap<Integer,String>();
       for(int i = 0;i<names.length;i++){
        map.put(heights[i],names[i]);
       }
       Arrays.sort(heights);
       String res[] = new String[heights.length];
       int j =0;
       for(int i = heights.length-1;i>=0;i--){
        res[j] = map.get(heights[i]);
        j++;
       }
       return res;
       */
       /*
        Map<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < names.length; i++) {
            treeMap.put(heights[i], names[i]);
        }

        // names = new String[names.length];
        int k = 0;
        for (String name : treeMap.values()) {
            names[k++] = name;
        }

        System.gc();
        return names;
        */
            Map<Integer,String> map = new TreeMap<>();
            String res[] = new String[names.length];
            for(int i=0; i<names.length; i++)
            {
                map.put(heights[i],names[i]);
            }
            int j = res.length-1;
            for(Map.Entry<Integer,String> m : map.entrySet()){
                res[j--] = m.getValue();
            }
            return res;
        }
    }

