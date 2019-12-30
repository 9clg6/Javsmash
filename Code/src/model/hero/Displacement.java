package model.hero;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * @author Clement GUYON and Maxime DACISAC
 * Displacement is managing the displacement of the character on x,y,z
 */
public class Displacement {
    private static final int ZERO = 0;

    /*




                        TA PRIORITE AUJOURD'HUI C'EST DE NETTOYER CETTE CLASSE : VIRER LES VARIABLE MAGIQUE,
                        TOUT LE CODE REDONDANT DOIT DEVENIR UNE METHODE AVEC PARAMETRES
                        SUPPRIMER LE MAX DE LIGNES POSSIBLE
                        PAR EXEMPLE EN CREANT UN OBJET COMPOSER D'UN BOOLEAN ET UN STRING POUR REMPLACER
                        LES LIGNES COMME LES LIGNES DE 86 A 92

                        OCCUPES TOI UNIQUEMENT DE LA CLASSE DEPLACEMENT FAUT QUE CE CODE SOIT NETTOYER LE PLUS
                        RAPIDEMENT POSSIBLE





     */


    private int nbJumpA = ZERO;
    private int nbJumpB = ZERO;
    private Pane root;

    private boolean leftA, rightA, jumpA, isJumpingA = false, Aattacking;
    private boolean leftB, rightB, jumpB, isJumpingB = false;

    private long timeinitA, timeinitB, timeA, timeB, timeInitA, timeInitB, oneSecond = 1000000000, ti, ty, timeinitAttackA;

    private CharacterPosition firstCp, secondCp;
    private Sprite spriteA, spriteB;


    /**
     * GameLoop who manages displacement on x,y,z depending of keys pressed, released
     * Constructor of Displacement
     *
     * @param firstCp  defines the actual position of the first character
     * @param secondCp defines the actual position of the second character
     * @param sc1      defines the actual scene where keys-event are applied
     *                 Instantiates the Sprite Class
     * @see Sprite, CharacterPosition
     */

    public Displacement(CharacterPosition firstCp, CharacterPosition secondCp, Scene sc1, Pane root) {
        this.firstCp = firstCp;
        this.secondCp = secondCp;
        this.root = root;

        spriteA = new Sprite(this.firstCp);
        spriteB = new Sprite(this.secondCp);
    }

    private void swapScale(CharacterPosition characterPosition) {
        if (characterPosition.getPersonnage().getSkin().getScaleX() == 1 && leftA || rightB) {
            characterPosition.getPersonnage().getSkin().setScaleX(-1);
        } else {
            if (characterPosition.getPersonnage().getSkin().getScaleX() == -1 && rightA || leftB)
                characterPosition.getPersonnage().getSkin().setScaleX(1);
        }
    }

    public void moving(long l) {

        timeA = l - timeinitA;
        if (movingLR(firstCp, leftA, rightA, timeA)) {
            timeinitA = l;
        }

        timeB = l - timeinitB;
        if (movingLR(secondCp, leftB, rightB, timeB)) {
            timeinitB = l;
        }


        jump(firstCp, jumpA, l);

        jump(secondCp, jumpB, l);


        if (Aattacking) {
            if (l - timeinitAttackA > 2 * oneSecond) {
                new RangeAttack(firstCp.getPersonnage(), root);
                Aattacking = false;
                timeinitAttackA = l;
            }
        }
    }


    private boolean movingLR(CharacterPosition cp, boolean isMovingL, boolean isMovingR, long time) {
        double dx = 3;

        if (isMovingL)
            dx = dx * -1;

        if (isMovingL || isMovingR) {

            if (time > oneSecond / 1000) {
                cp.setPosX(dx);
                return true;
            }
        }
        return false;
    }


    private void jump(CharacterPosition cp, boolean jump, long l) {


        if (jump && !cp.isIsjumping()) {
            cp.setIsjumping(true);
            cp.setNbjump(cp.getNbjump() + 1);
            cp.setTimeinit(l);


        }
        cp.setTi(l - cp.getTimeinit());
        cp.setTifloat((float) cp.getTi() / 1000000000);

        if (cp.isIsjumping()) {


            if (0.5 < cp.getTifloat() && cp.getTifloat() > 0.6 && cp.getNbjump() < 2 && jump) {
                cp.setIsjumping(true);
                cp.setNbjump(cp.getNbjump() + 1);
                cp.setTimeinit(l);

            } else {
                cp.setPosY(-10 * Math.cos(Math.PI * cp.getTifloat()));

            }

            if (cp.getNbjump() < 2 && (l - cp.getTimeinit()) > oneSecond) {
                cp.setIsjumping(false);
                cp.setNbjump(0);

            }

            if (cp.getNbjump() == 2 && (l - cp.getTimeinit()) > (1.5 * oneSecond)) {
                cp.setIsjumping(false);
                cp.setNbjump(0);

            }

        }

    }

    /**
     * CharacterEventOnKeyPressed is called when an keys is press during the AnimationTimer and sets
     * boolean to know in which direction move and when jumpA.
     *
     * @param keyEvent KeyEvent, used to get which keys is pressed
     */
    public void CharacterEventOnKeyPressed(KeyEvent keyEvent) {
        spriteA.spriteAnimation("Walk");
        spriteB.spriteAnimation("Walk");
        switch (keyEvent.getCode()) {
            case Q:
                leftA = true;
                swapScale(firstCp);
                break;
            case D:
                rightA = true;
                swapScale(firstCp);
                break;
            case SPACE:
                jumpA = true;
                break;

            case LEFT:
                leftB = true;
                swapScale(secondCp);
                break;
            case RIGHT:
                rightB = true;
                swapScale(secondCp);
                break;
            case UP:
                jumpB = true;
                break;
        }
    }

    /**
     * CharacterEventOnKeyReleased is used to know when key is released to stop the animation and stop any movement
     *
     * @param keyEvent KeyEvent, used to get which key is released.
     * @see Sprite
     */
    public void CharacterEventOnKeyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                leftA = false;
                spriteA.spriteReset();
                break;
            case D:
                rightA = false;
                spriteA.spriteReset();
                break;
            case SPACE:
                jumpA = false;
                break;

            case LEFT:
                leftB = false;
                spriteB.spriteReset();
                break;
            case RIGHT:
                rightB = false;
                spriteB.spriteReset();
                break;
            case UP:
                jumpB = false;
                break;
        }
    }
}
