package model.subject;

import java.time.LocalDateTime;

public class Lesson {
    private int id;
    private String title;
    private String description;
    private String image;
    private String video;
    private LocalDateTime releaseDate;

    public Lesson(int id, String title, String description, String image, String video) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.video = video;
        this.releaseDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
