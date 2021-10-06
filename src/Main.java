import java.util.*;
class Boxes {

   int height;
   int width;
   Animals animals; //Doing aggregation
   Boxes B1;
   Boxes B2;
   Boxes B3;
   Boxes() {
      B1 = new Boxes(20, 20); //Assigning boxes lengths
      B2 = new Boxes(40, 20);
      B3 = new Boxes(40, 40);
   }
   Boxes(int height, int width) {
      this.height = height;
      this.width = width;

   }

   String getBoxes(String animalsName) {
      //This function will calculate total length(width,height) required by animals and then see in
      //how many least boxes required for them to fit within boxes
      String Boxes = " ";
      animals = new Animals();
      int lengthx = 0, lengthy = 0;

      for (int i = 0; i < animalsName.length(); i++) {

         if (animalsName.charAt(i) == 'R') {
            lengthx += animals.getRat().requiredHeight;
            lengthy += animals.getRat().requiredWidth;
         } else if (animalsName.charAt(i) == 'H') {
            lengthx += animals.getHedgehog().requiredHeight;
            lengthy += animals.getHedgehog().requiredWidth;
         } else if (animalsName.charAt(i) == 'M') {
            lengthx += animals.getMongoose().requiredHeight;
            lengthy += animals.getMongoose().requiredWidth;
         } else if (animalsName.charAt(i) == 'S') {
            lengthx += animals.getSnake().requiredHeight;
            lengthy += animals.getSnake().requiredWidth;
         }

      }
      if (B1.height - lengthx == 0 && B1.width - lengthy == 0) {
         Boxes += "B1";
      }
      if (B2.height - lengthx == 0 && B2.width - lengthy == 0) {
         Boxes += "B2";
      }
      if (B3.height - lengthx == 0 && B3.width - lengthy == 0) {
         Boxes += "B3";
      } else if (B3.height + B2.height - lengthx == 0 && B3.width + B2.width - lengthy == 0) {
         Boxes += "B2" + "B3";

      } else if (B3.height + B1.height - lengthx == 0 && B3.width + B1.width - lengthy == 0) {
         Boxes += "B1" + "B3";
      } else if (B2.height + B1.height - lengthx == 0 && B2.width + B1.width - lengthy == 0) {
         Boxes += "B2" + "B1";

      } else if (B3.height + B3.height - lengthx == 0 && B3.width + B3.width - lengthy == 0) {
         Boxes += "B3" + "B3";

      }
      return Boxes;
   }

}

class Animals {
   int requiredHeight;
   int requiredWidth;
   Animals() {}
   Animals(int requiredHeight, int requiredWidth) {
      this.requiredHeight = requiredHeight;
      this.requiredWidth = requiredWidth;
   }

   Animals getRat() {
      return new Animals(20, 20);
   }
   Animals getHedgehog() {
      return new Animals(20, 20);

   }
   Animals getMongoose() {
      return new Animals(40, 20);
   }
   Animals getSnake() {
      return new Animals(40, 40);
   }

}

public class Main {
   public static void main(String[] args) {

      Boxes B = new Boxes();
      Scanner myObj = new Scanner(System.in); // Create a Scanner object for taking input

      String Animals = " ";
      while (Animals.charAt(0) != 'e') {
         System.out.println("Enter the name(first letter) of animals in capital, enter e to exit program");
         Animals = myObj.nextLine();
         System.out.println("Output: " + B.getBoxes(Animals));
      }

   }
}