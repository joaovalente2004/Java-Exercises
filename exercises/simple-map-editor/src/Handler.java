import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class Handler implements KeyboardHandler {

    public Keyboard keyboard;
    public Player player;

    public Handler( Player player){
        this.player = player ;
        keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public void createKeyboardEvents() {
        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP );
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN );
        keyboard.addEventListener(keyboardEventDown );

        KeyboardEvent keyboardEventSave = new KeyboardEvent();
        keyboardEventSave.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSave.setKey(KeyboardEvent.KEY_S );
        keyboard.addEventListener(keyboardEventSave);


        KeyboardEvent keyboardEventLoad = new KeyboardEvent();
        keyboardEventLoad.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLoad.setKey(KeyboardEvent.KEY_L );
        keyboard.addEventListener(keyboardEventLoad);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE );
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventBlack = new KeyboardEvent();
        keyboardEventBlack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventBlack.setKey(KeyboardEvent.KEY_B );
        keyboard.addEventListener(keyboardEventBlack);

        KeyboardEvent keyboardEventClear = new KeyboardEvent();
        keyboardEventClear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventClear.setKey(KeyboardEvent.KEY_C );
        keyboard.addEventListener(keyboardEventClear);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
                player.moveLeft();
                break;

            case KeyboardEvent.KEY_UP:
                player.moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
                player.moveDown();
                break;

            case KeyboardEvent.KEY_S:
                try {
                    player.save();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_L:
                try {
                    player.clearAll();
                    player.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
                case KeyboardEvent.KEY_SPACE:
                    player.drawBlackCell();
                    break;

                case KeyboardEvent.KEY_B:
                    player.drawWhiteCell();
                    break;

                    case KeyboardEvent.KEY_C:
                        player.clearAll();
                        break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
