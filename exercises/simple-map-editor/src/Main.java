import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class Main {

    public static void main(String[] args) {

        Player player = new Player(new Rectangle(100, 430, 30, 30));
        player.draw();
        player.color();


        Grid grid = new Grid(27, 16);
        grid.init();



        Handler handler = new Handler(player);



    }


}