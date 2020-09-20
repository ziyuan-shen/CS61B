package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static int size;
    private static int mid;
    private static int width;
    private static int height;
    private static TETile[][] world;
    private static final Random RANDOM = new Random(100);

    private static int randomTile() {
        return RANDOM.nextInt(5);
    }

    private static TETile getTile(int tileNum) {
        switch (tileNum) {
            case 0: return Tileset.GRASS;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.MOUNTAIN;
            case 3: return Tileset.TREE;
            case 4: return Tileset.SAND;
            default: return Tileset.NOTHING;
        }
    }

    private static void addHexagon(int x, int y) {
        int tileNum = randomTile();
        for (int i = x; i < x + size; i++) {
            for (int j = y - (i - x); j < (y + size + i - x); j++) {
                world[i][j] = getTile(tileNum);
            }
        }
        for (int i = x + size; i < x + 2 * size; i++) {
            for (int j = i - x - 2 * size + y + 1; j < x - i + 3 * size + y - 1; j++) {
                world[i][j] = getTile(tileNum);
            }
        }
    }

    public static void main(String[] args) {
        size = RANDOM.nextInt(4) + 2;
        mid = size + 2 * (size - 1);
        width = 3 * mid + 2 * size + 2;
        height = 10 * size + 2;
        TERenderer ter = new TERenderer();
        ter.initialize(width, height);
        world = new TETile[width][height];
        for (int i = 0; i < width; i += 1) {
            for (int j = 0; j < height; j += 1) {
                world[i][j] = Tileset.NOTHING;
            }
        }
        int x = 1;
        int y = size + mid + 2;
        world[0][0] = Tileset.TREE;
        // addHexagon(x, y);
        ter.renderFrame(world);
    }
}
