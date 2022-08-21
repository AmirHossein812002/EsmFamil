public class GameModule {
     private String[] catagories = new String[5];
     private Mood mood;
     private int turn;
     private int time;

     public GameModule(String[] catagories) {
          this.catagories = catagories;
          this.time = -1;
     }

     public GameModule() {

     }

     public String[] getCatagories() {
          return catagories;
     }

     public Mood getMood() {
          return mood;
     }

     public int getTurn() {
          return turn;
     }

     public void setMood(Mood mood) {
          this.mood = mood;
     }

     public void setTurn(int turn) {
          this.turn = turn;
     }

     public int getTime() {
          return time;
     }

     public void setTime(int time) {
          this.time = time;
     }
}
