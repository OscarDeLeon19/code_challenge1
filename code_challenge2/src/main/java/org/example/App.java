package org.example;



public class App 
{
    public static void main( String[] args )
    {
        Object[] array1 = {1, 2, new Object[]{3, 4, new Object[]{5, 6, new Object[]{7, 8, new Object[]{9, 10}}}} };

        Object[] result = transformArray(array1);

        System.out.println("Arreglo final");
        System.out.print("[");
        for (int i = 0; i < result.length; i++){

            if(i == result.length - 1){
                System.out.print(result[i]);
            } else{
                System.out.print(result[i] + ", ");
            }
        }
        System.out.print("]");


    }

    public static Object[] transformArray(Object[] array){

        // Get lenght of array
        Object[] result = new Object[getLength(array, 0)];
        // Get final result object array
        result = extractData(array, result, 0);

        return result;

    }

    /**
     * Extract data of array to transfor in a unique object array
     * @param array
     * @param result
     * @param index
     * @return
     */
    public static Object[] extractData(Object[] array, Object[] result, int index){

        for(int i = 0; i < array.length; i++){
            // Find if is and string or int and add to array
            if(array[i] instanceof String || array[i] instanceof Integer){
                result[index] = array[i];
                index++;
            } else if(array[i] instanceof Object[]){
                // if is an instance of object[], use the same method with recursion
                extractData((Object[]) array[i], result, index);
            }
        }

        return result;
    }

    /**
     * Get lengh of an object array
     * @param array
     * @param index
     * @return
     */
    public static int getLength(Object[] array, int index){

        for (int i = 0; i < array.length; i++){
            if(array[i] instanceof Object[]){
                // if is an instance of object use the same method with recursion
                index = getLength((Object[])array[i], index);
            } else{
                // only add 1 quantity for the lenght
                index++;
            }
        }

        return index;
    }


}
