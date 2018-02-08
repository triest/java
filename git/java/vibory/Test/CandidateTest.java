import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by triest on 04.06.2017.
 */
class CandidateTest {
    @Test
    void getVoite() {
    }

    @Test
    void setVoite() {
    }

    @Test
    void setName() {
    }

    @Test
    void getName() {
        Candidate candidate=new Candidate();
        String name="ds";
        candidate.setName(name);
        assertEquals(candidate.getName(),"ds");
    }

    @Test
    void addVoice() {
    }

    @Test
    void getVoices() {
    }

}