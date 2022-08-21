import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Word {
   public static ArrayList<String> name = new ArrayList<String>();
   public static ArrayList<String> lastName = new ArrayList<String>();
   public static ArrayList<String> city = new ArrayList<String>();
   public static ArrayList<String> country = new ArrayList<String>();
   public static ArrayList<String> food = new ArrayList<String>();
   public static ArrayList<String> cloth = new ArrayList<String>();
   public static ArrayList<String> fruit = new ArrayList<String>();
   public static ArrayList<String> car = new ArrayList<String>();
   public static ArrayList<String> flower = new ArrayList<String>();
   public static ArrayList<String> animal = new ArrayList<String>();
   public static ArrayList<String> object = new ArrayList<String>();
   static {
      Scanner scanner = null;
      try {
         scanner = new Scanner(new File("اسم.txt"));
         while (scanner.hasNext()) {
            name.add(scanner.nextLine());
         }
         scanner = new Scanner(new File("فامیل.txt"));
         while (scanner.hasNext()) {
            lastName.add(scanner.nextLine());
         }

         scanner = new Scanner(new File("شهر.txt"));
         while (scanner.hasNext()) {
            city.add(scanner.nextLine());
         }

         scanner = new Scanner(new File("کشور.txt"));
         while (scanner.hasNext()) {
            country.add(scanner.nextLine());
         }

         scanner = new Scanner(new File("غذا.txt"));
         while (scanner.hasNext()) {
            food.add(scanner.nextLine());
         }

         scanner = new Scanner(new File("پوشاک.txt"));
         while (scanner.hasNext()) {
            cloth.add(scanner.nextLine());
         }

         scanner = new Scanner(new File("میوه.txt"));
         while (scanner.hasNext()) {
            fruit.add(scanner.nextLine());
         }

         scanner = new Scanner(new File("ماشین.txt"));
         while (scanner.hasNext()) {
            car.add(scanner.nextLine());
         }
         scanner = new Scanner(new File("گل.txt"));
         while (scanner.hasNext()) {
            flower.add(scanner.nextLine());
         }
         scanner = new Scanner(new File("حیوان.txt"));
         while (scanner.hasNext()) {
            animal.add(scanner.nextLine());
         }

         scanner = new Scanner(new File("اشیا.txt"));
         while (scanner.hasNext()) {
            object.add(scanner.nextLine());
         }

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
   public static void giveScore() {
      int score = Game.totScore.getValue();
      for (int j = 0; j <= 4; j++) {
         switch (ServerUI.host.getGameModule().getCatagories()[j]) {
            case "اسم":
               for (int i = 0; i < name.size(); i++) {
                  if (Game.catagories[j].getValue().equals(name.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "فامیل":
               for (int i = 0; i < lastName.size(); i++) {
                  if (Game.catagories[j].getValue().equals(lastName.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "شهر":
               for (int i = 0; i < city.size(); i++) {
                  if (Game.catagories[j].getValue().equals(city.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "کشور":
               for (int i = 0; i < country.size(); i++) {
                  if (Game.catagories[j].getValue().equals(country.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "غذا":
               for (int i = 0; i < food.size(); i++) {
                  if (Game.catagories[j].getValue().equals(food.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "پوشاک":
               for (int i = 0; i < cloth.size(); i++) {
                  if (Game.catagories[j].getValue().equals(cloth.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "میوه":
               for (int i = 0; i < fruit.size(); i++) {
                  if (Game.catagories[j].getValue().equals(fruit.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "ماشین":
               for (int i = 0; i < car.size(); i++) {
                  if (Game.catagories[j].getValue().equals(car.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "گل":
               for (int i = 0; i < flower.size(); i++) {
                  if (Game.catagories[j].getValue().equals(flower.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "حیوان":
               for (int i = 0; i < animal.size(); i++) {
                  if (Game.catagories[j].getValue().equals(animal.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
            case "اشیا":
               for (int i = 0; i < object.size(); i++) {
                  if (Game.catagories[j].getValue().equals(object.get(i))) {
                     if (Game.catagories[j].getValue().equals(Game.otherCatagories[j]))
                        score += 5;
                     else
                        score += 10;
                     break;
                  }
               }
               break;
         }
      }
      Game.totScore.setValue(score);
   }
}
