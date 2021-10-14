package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends Content implements Playable {

    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;

    public static final int LONG_PLAYING_TIME = 135;

    public Movie(String title, Rating maturityRating) {
        super(title, maturityRating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void play() {
        String extra = "";
        if (!(this instanceof Documentary)) {
            extra = "\n";
        }
        System.out.print("Playing " + this + extra);
    }

    @Override
    public void pause() {
        String extra = "";
        if (!(this instanceof Documentary)) {
            extra = "\n";
        }
        System.out.print("Pausing " + this + extra);
    }

    public boolean isLongPlayingTime() {
        return duration >= LONG_PLAYING_TIME;
    }

    public String getPlayingTime() {
        String playTime;
        if (duration == 0) {
            return "?";
        }
        if (duration < 60) {
            playTime = duration + " min";
            return playTime;
        }
        if (duration % 60 == 0) {
            playTime = duration / 60 + " h";
            return playTime;
        }
        int uren = duration / 60;
        int minuten = duration % 60;
        // int minuten = duration - (uren * 60);
        playTime = uren + " h " + minuten + " min";
        return playTime;
    }

    public void setDuration(int duration) {
        this.duration = Math.abs(duration);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        builder.append(releaseDate != null ? " (" + releaseDate.getYear() + ")" : "");

      /*  if (releaseDate != null) {
            builder.append(" (").append(releaseDate.getYear()).append(")");
        }*/

        return builder.toString();
    }
}


