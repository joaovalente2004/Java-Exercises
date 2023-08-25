package Hotel;

public class Room {



    private int number;

    private int key;

    private int isavailable = 0;


    public Room(int number, int key) {
        this.number = number;
        this.key = key;
    }


    public int getNumber() {
        return number;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setNumber(int number) {
        this.number = number;

    }

    public void setisavailable(int isavailable){
         this.isavailable = isavailable;

    }

    public int getisavailable(){
        return isavailable;
    }


}
