package lection.p02_OpenClosedPrinciple.p01_FileStream;

public class MusicFile extends File {
    private String artist;
    private String album;

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
