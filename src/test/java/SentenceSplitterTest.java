import org.infai.seits.sepl.operators.Message;
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
            String actual = m.getMessageString().split("\\[")[1].split("]")[0];
            String expected = "\\\"Lorem\\\", \\\"ipsum\\\", \\\"dolor\\\", \\\"sit\\\", \\\"amet\\\", \\\"consetetur\\\", \\\"sadipscing\\\", \\\"elitr\\\", \\\"sed\\\", \\\"diam\\\"";

            Assert.assertEquals(expected, actual);
        }
    }
}
