package doc.txt;

import doc.core.DocumentProcessor;

public class PlainTextProcessor implements DocumentProcessor {
    @Override
    public String process(String content) {
        return "Plain Text Content: " + content;
    }

    @Override
    public String getFormatName() {
        return "Plain Text";
    }
}
