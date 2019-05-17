import org.infai.seits.sepl.operators.Message;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SentenceSplitterTest {

    @Test
    public void run() throws Exception{
        SentenceSplitter tsc = new SentenceSplitter();
        List<Message> messages = TestMessageProvider.getTestMesssagesSet();
        for (Message m : messages) {
            tsc.config(m);
            tsc.run(m);
            m.addInput("words");
            String actual = new JSONArray(m.getMessageString().split("words\":")[1].split("]")[0]+"]").toString();
            m.addInput("compare");
            String expected = m.getInput("compare").getJSONArray().toString();
            Assert.assertEquals(expected, actual);
        }
    }
}
