package exercise.word;

public class CutTransform implements TextTransform{
    private String lastCut;

    public String getLastCut() {
        return lastCut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.lastCut = text.substring(startIndex, endIndex);
        text.replace(startIndex, endIndex, "");
    }
}
