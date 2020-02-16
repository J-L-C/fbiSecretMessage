package secretDecoder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SecretDecoderTest {

    SecretDecoder decoder = new SecretDecoder();

    @Test
    public void possibleSolutions_givenASingDigitReturn1PossibleWaysToDecode() {
        Assert.assertEquals(1, decoder.possibleSolutions(1));
    }

    @Test
    public void possibleSolutions_givenATwoDigitNumberReturn2ForTheNumberOfPossibleSolutions() {
        Assert.assertEquals(2, decoder.possibleSolutions(12));
    }

    @Test
    public void possibleSolutions_givenAThreeDigitNumberReturn3ForTheNumberOfPossibleSolutions() {
        Assert.assertEquals(3, decoder.possibleSolutions(123));
    }

    @Test
    public void possibleSolutions_givenAFourDigitNumberReturn3ForTheNumberOfPossibleSolutions() {
        Assert.assertEquals(3, decoder.possibleSolutions(1234));
    }

    @Test
    public void possibleSolutions_givenAFIVEDigitNumberReturn3ForTheNumberOfPossibleSolutions() {
        Assert.assertEquals(3, decoder.possibleSolutions(12345));
    }

    @Test
    public void possibleSolutions_given205_shouldReturn2AsTheNumberOfSolutions() {
        Assert.assertEquals(2, decoder.possibleSolutions(205));
    }

    @Test
    public void possibleSolutions_given665_shouldReturn1AsTheNumberOfSolutions() {
        Assert.assertEquals(1, decoder.possibleSolutions(665));
    }

    @Test
    public void possibleSolutions_given23759228973_shouldReturn4AsTheNumberOfSolutions() {
        Assert.assertEquals(4, decoder.possibleSolutions(23759228973l));
    }

    @Test
    public void possibleSolutions_given23219228973_shouldReturn4AsTheNumberOfSolutions() {
        Assert.assertEquals(16, decoder.possibleSolutions(23219228973l));
    }
}