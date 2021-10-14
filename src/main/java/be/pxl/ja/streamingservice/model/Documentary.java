package be.pxl.ja.streamingservice.model;

public class Documentary extends Movie {
    private String topic;

    public Documentary(String title, Rating maturityRating, String topic) {
        super(title, maturityRating);
        setGenre(Genre.DOCUMENTARY);
        this.topic = topic;
    }

    public Documentary(String title, Rating maturityRating) {
        super(title, maturityRating);
        setGenre(Genre.DOCUMENTARY);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void play() {
        super.play();
        System.out.println( " - topic: " + topic);
    }

    @Override
    public void pause() {
        super.pause();
        System.out.println( " - topic: " + topic);
    }
}
