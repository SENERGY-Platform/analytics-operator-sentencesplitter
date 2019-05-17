/*
 * Copyright 2018 InfAI (CC SES)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.commons.lang3.StringUtils;
import org.infai.seits.sepl.operators.Message;
import org.infai.seits.sepl.operators.OperatorInterface;
import org.json.JSONArray;

import java.util.HashMap;

public class SentenceSplitter implements OperatorInterface {

    @Override
    public void run(Message message) {
        String sentence = message.getInput("sentence").getString();
        String[] words = sentence.split("(\\W+)");
        JSONArray wordsArray = new JSONArray();

        for(String s: words){
            wordsArray = wordsArray.put(s);
        }

        message.output("words", wordsArray);
    }

    @Override
    public void config(Message message) {
        message.addInput("sentence");
    }
}
