package x10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

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

    @ParameterizedTest
    @ValueSource(strings = {"leader_siege = 1", "land_morale = 0.15", "infantry_power = 0.15",
            "war_exhaustion = -0.03", "own_coast_naval_combat_bonus = 1",
            "legitimacy = 1.5 #unique (it's the HRE :D)"})
    public void whenGivenLineEndingInNumeric_returnTrue(String currLine) {
        assertTrue(x10script.isLineAnIdeaWithNumbersToMultiply(currLine));
    }

    @ParameterizedTest
    @ValueSource(strings = {"has_country_flag = accepted_norse_ideas_flag",
            "may_perform_slave_raid_on_same_religion = yes", "start = {",
            "norse_ideas_a_wall_of_shields_for_the_king = {",})
    public void whenGivenLineNOTEndingInNumeric_returnFalse(String currLine) {
        assertFalse(x10script.isLineAnIdeaWithNumbersToMultiply(currLine));
    }
}
