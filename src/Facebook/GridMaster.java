package Facebook;

public interface GridMaster {
    boolean canMove(char direction);
    void move(char direction);
    boolean isTarget();
}
