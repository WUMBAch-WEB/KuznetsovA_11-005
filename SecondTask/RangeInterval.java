package SecondTask;

public class RangeInterval  extends  Range{
      public RangeInterval(int start, int end){
          super(end);
          try {
              if(start<end){
                  counter =start;
              }
              else {
                  throw new Exception();
              }

              }
          catch (Exception e){
              System.out.println("Start > end eror");
              counter = end;
          }
      }

}
