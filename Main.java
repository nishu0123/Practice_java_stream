// Online Java Compilere
import java.util.*;
import java.lang.Math;
// import java.util.stream.IntStream;
import java.util.stream.*;
import java.util.Scanner;


class Main {
    public static <T> void printList(List<T> list)
    {
        int n = list.size();
        for(int i=0; i<n; i++){
            System.out.print(list.get(i) + " ");
        }
    }
    public static void practice_Stream_with_IntegerList(List<Integer> list){
    //now code is working fine 
    /*
    Calculate average of integers using streams
    */
    // List<Integer> answer = list.((num  , sum)->{
    //     sum += num;
    // },
    // (sum , size)->{
        
    // }
    
    //at first we have to map the element into int or double 
    //and then get the average 
    //and then return return into the list 
    
    /*
    double answer = list.stream() //convert to stream 
                        // .mapToDouble(Double::doubleValue) //map to double but the list is of Int type we needt to convert it into the int 
                        .mapToInt(Integer::intValue)
                        .average() //find the average 
                        .orElse(0); //if empty list then return 0 
                        
    */
                        
    IntStream intStreamValue = list.stream() //convert to stream 
                        .mapToInt(Integer::intValue);
                        
    int sum = intStreamValue.sum(); //cstream has been processed and now 
    //it has been closed to do more operation again we have to create the stream 
    //now it will work 
    Double avegage = list.stream().mapToInt(Integer::intValue).average().orElse(0);
  
  //now we will use the filter , it actually remove the item that does not pass it
  //like i have to list out the nuber which are greater than 20 
  /*
  List<Integer> greaterThan20 = list.stream().filter(n -> n > 20)
  .sorted(Comparator.naturalOrder()).collect(Collectors.toList());
  System.out.println("value greater tha 20 : ");
  printIntList(greaterThan20);
  */
  
  //now after filter we can use any other operation 
//   List<Integer> squreList = list.stream().map(n -> n*n)
//                             .peek(n -> System.out.print(n + " & "))
//                             .collect(Collectors.toList());

 //3. Sum even and odd numbers in list using streams
 
 int oddsum = list.stream().filter(n -> n%2 == 1).mapToInt(Integer::intValue).sum();
 int evensum = list.stream().filter(n -> n%2 == 0).mapToInt(Integer::intValue).sum();
 System.out.println("odd sum = " + oddsum + " even sum = " + evensum);
 
 //4. Remove duplicates from list using streams
 //now we have to remvoe the duplicate , so we can use the distinct function 
 List<Integer> distinctNumber = list.stream().mapToInt(Integer::intValue).distinct().boxed().collect(Collectors.toList());
 printList(distinctNumber);
 
 //5.                 
                        
    }
    
    
    public static void practice_Stream_with_StringList(List<String> list){
        
        //2. Convert strings to upper/lowercase using streams
        List<String> upperCaseString = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        
        // printList(upperCaseString);
        
        
        //5. Count strings starting with letter using streams
        //now here i have 
        Long cnt = list.stream().filter( n -> {
            Character firstchar = n.charAt(0);
            if(firstchar >= '0' && firstchar <= '9'){
                return false;
            }else{
                return true;
            }
        }).count();
        System.out.println("value of count = " + cnt);
        
        //6.Sort strings A-Z and Z-A using streams
        //here we have to sort the string 
        List<String> sortedString = list.stream().map(String::sorted.naturalOrder())
            
        
    }
    public static void main(String[] args) {
        //lets  create the list of the integer , list of the string 
        //on which operation will be performed 
        //or the list of the object  on which the operation will be performed 
        
        
        List<Integer> integerList = new ArrayList<>();
        int n = 89;
        //here ask from the user for the input 
        System.out.println("Enter the size of the list : ");
        Scanner sc = new Scanner(System.in);
        int inputInteger = sc.nextInt();
         n = inputInteger;
        
        for(int i = 0; i<n; i++){
            integerList.add(i*2 - 12);
        }
        List<String> stringList = Arrays.asList("sg" , "dgsgs", "iuqhfew" , "iofug");
        
        practice_Stream_with_IntegerList(integerList);
        practice_Stream_with_StringList(stringList);
        
        
        sc.close();//close the scanner at the end of the function 
        // System.out.println("Try programiz.pro");
    }
}
