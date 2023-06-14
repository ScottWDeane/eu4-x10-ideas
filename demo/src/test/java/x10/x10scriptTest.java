package x10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class x10scriptTest {
    // I hate writing tests for file/directory manipulation in a windows environment (gross), so I'm
    // just... not going to.

    @Test
    public void whenGiven_lineEndingIn0Point1_return_1Point0() {
        // strings ending in numerics should be multiplied by 10
        String lineToModify = "nobles_loyalty_modifier = 0.1";
        String expectedOutput = "nobles_loyalty_modifier = 1.0";
        String modifiedLine = x10script.modifyLine(lineToModify);
        assertEquals(expectedOutput, modifiedLine);
    }

    @Test
    public void whenGiven_lineEndingIn1_return_10() {
        // strings ending in numerics should be multiplied by 10
        String lineToModify = "leader_siege = 1";
        String expectedOutput = "leader_siege = 10.0";
        String modifiedLine = x10script.modifyLine(lineToModify);
        assertEquals(expectedOutput, modifiedLine);
    }

    @Test
    public void whenGiven_lineEndingInNegative0Point05_return_Negative0PointFive() {
        // strings ending in numerics should be multiplied by 10
        String lineToModify = "development_cost = -0.05";
        String expectedOutput = "development_cost = -0.5";
        String modifiedLine = x10script.modifyLine(lineToModify);
        assertEquals(expectedOutput, modifiedLine);
    }

}
